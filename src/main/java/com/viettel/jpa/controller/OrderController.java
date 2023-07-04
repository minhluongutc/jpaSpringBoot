package com.viettel.jpa.controller;

import com.viettel.jpa.dto.OrderRequest;
import com.viettel.jpa.dto.OrderResponse;
import com.viettel.jpa.entity.Customer;
import com.viettel.jpa.repository.CustomerRepository;
import com.viettel.jpa.repository.ProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeProduct(@RequestBody OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrder")
    public List<Customer> findAllOrder() {
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }

    @GetMapping("/findOrder/{customerId}")
    public Optional<Customer> findOrder(@PathVariable("customerId") Customer customer) {
        return customerRepository.findById(customer.getId());
    }
}
