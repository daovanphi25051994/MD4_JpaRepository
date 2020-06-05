package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer model) {
         Customer cus =  customerRepository.saveAndFlush(model);
         return cus;
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer update(Long id, Customer model) {
       return customerRepository.saveAndFlush(model);
    }
}