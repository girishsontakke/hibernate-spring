package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> customers = customerService.getCustomers();
        theModel.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/showFormToAdd")
    public String showFormToAdd(Model theModel){
        Customer customerAttribute = new Customer();
        theModel.addAttribute("customer", customerAttribute);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model theModel){
        Customer customer = customerService.getCustomer(customerId);

        theModel.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
