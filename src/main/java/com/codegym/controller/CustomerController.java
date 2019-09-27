package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    String showForm(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    String createCustomerForm() {
        return "create";
    }

    @PostMapping("create-customer")
    String createCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }
    @GetMapping("/delete/{id}")
    String deleteForm(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "remove";
    }
    @PostMapping("delete/realDelete/{id}")
    String deleteCustomer(@PathVariable int id,Model model) {
        customerService.remove(id);
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }
    @GetMapping("view/{id}")
    String viewCustomer(@PathVariable int id,Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "view";
    }
    @GetMapping("edit/{id}")
    String editForm(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }
    @PostMapping("edit/update")
    String editCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }
}


