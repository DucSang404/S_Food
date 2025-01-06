package com.sfood.service.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    public CustomerDTO findCustomerById(Long customerId) {
        return customerMapper.toDTO(customerRepository.findById(customerId));
    }
}
