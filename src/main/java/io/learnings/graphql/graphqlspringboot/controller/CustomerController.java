package io.learnings.graphql.graphqlspringboot.controller;

import io.learnings.graphql.graphqlspringboot.repository.entities.Customer;
import io.learnings.graphql.graphqlspringboot.repository.entities.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @QueryMapping("customers") //method name or name in this annotation should match schema.graphqls.query.customers
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @QueryMapping("customerById")
    public Customer getCustomerById(@Argument Long id) {
        return repository.findById(id).orElseThrow();
    }

    @QueryMapping("customerById")
    public Customer customerByEmail(@Argument String email) {
        return repository.findByEmail(email);
    }
}
