package com.example.service;

import com.example.dao.CustomerDao;
import com.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDao.getCustomer(customerId);
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDao.deleteCustomer(customerId);
    }
}
