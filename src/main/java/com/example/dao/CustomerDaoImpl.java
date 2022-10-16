package com.example.dao;

import com.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session curSession = sessionFactory.getCurrentSession();

        Query<Customer> customerQuery = curSession.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = customerQuery.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session curSession = sessionFactory.getCurrentSession();

        Customer customer = curSession.get(Customer.class, customerId);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session curSession = sessionFactory.getCurrentSession();
        Query query = curSession.createQuery("from Customer where email=?3", Customer.class).setParameter(3, customer.getEmail());

        try {
            Customer existingCustomer = (Customer) query.getSingleResult();
            customer.setId(existingCustomer.getId());
            curSession.merge(customer);
        } catch (NoResultException nre) {
            curSession.save(customer);
        }
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        session.delete(customer);
    }
}
