package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(int customerId);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
