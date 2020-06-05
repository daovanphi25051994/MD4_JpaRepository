package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public ModelAndView showListCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.getAll());
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView moveAddCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("customer/create-form");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("customer/create-form");
        if (customer.getId() == 0){
            Customer customer1 = customerService.save(customer);
            if (customer1 == null){
                modelAndView.addObject("message", "save not successfully !!!");
            }else {
                modelAndView.addObject("message", "save not successfully !!!");
            }
        }else {
            customerService.update(customer.getId(), customer);
        }
        modelAndView.addObject("message", "save not successfully !!!");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}