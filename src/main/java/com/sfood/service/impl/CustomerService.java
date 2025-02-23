package com.sfood.service.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    public CustomerDTO findCustomerById(Long customerId) {
        return customerMapper.toDTO(customerRepository.findById(customerId));
    }

    public CustomerDTO updateCustomer(Long customerId, CustomerDTO updateCustomer) {
        Optional<CustomerEntity> optionalCustomer = Optional.ofNullable(customerRepository.findById(customerId));

        if (optionalCustomer.isPresent()) {
            CustomerEntity customer = optionalCustomer.get();

            customer.setEmail(updateCustomer.getEmail());
            customer.setDateOfBirth(updateCustomer.getDateOfBirth());
            customer.setName(updateCustomer.getName());
            customer.setPhone(updateCustomer.getPhone());
            customer.setAvatar(updateCustomer.getAvatar());

            customerRepository.save(customer);

            return customerMapper.toDTO(customer);
        }

        throw new RuntimeException("Customer not found with ID: " + customerId);
    }

    public void changeAvatar(Long customerId, String avatar) {
        CustomerEntity entity = customerRepository.findById(customerId);
        entity.setAvatar(avatar);
        customerRepository.save(entity);
    }
}
