package com.example.base.infrastructure.adapters;

import com.example.base.application.mapper.CustomerMapper;
import com.example.base.domain.model.Customer;
import com.example.base.domain.repository.CustomerRepository;
import com.example.base.infrastructure.repositories.data.CustomerData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final R2dbcEntityTemplate template;
    private final CustomerMapper mapper;

    @Override
    public Mono<Customer> save(Customer customer) {
        return template.insert(CustomerData.class)
                .using(mapper.toData(customer))
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Customer> findById(Long id) {
        return template.select(CustomerData.class)
                .matching(Query.query(Criteria.where("id").is(id)))
                .one()
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Customer> findAll() {
        return template.select(CustomerData.class).all()
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Integer> update(Customer customer) {

        CustomerData data = mapper.toData(customer);

        Update update = Update.update("name", data.getName())
                .set("gender", data.getGender())
                .set("age", data.getAge())
                .set("identification", data.getIdentification())
                .set("address", data.getAddress())
                .set("phone", data.getPhone())
                .set("password", data.getPassword())
                .set("status", data.getStatus());

        return template.update(Query.query(Criteria.where("id").is(data.getId())),
                update,
                CustomerData.class).map(Long::intValue);

    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return template.delete(
                Query.query(Criteria.where("id").is(id)),
                CustomerData.class
        ).then();
    }
}
