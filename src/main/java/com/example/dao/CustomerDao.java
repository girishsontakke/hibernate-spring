package com.example.dao;

import com.example.entity.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();
    Customer getCustomer(int customerId);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(int customerId);
}
