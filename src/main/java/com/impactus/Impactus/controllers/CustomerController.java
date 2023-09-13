package com.impactus.Impactus.controllers;

import com.impactus.Impactus.domain.user.Customer;
import com.impactus.Impactus.dto.CustomerDTO;
import com.impactus.Impactus.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/customer")
public class CustomerController {

    private final CustomerService customerService;


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateUser(@PathVariable Long id, Customer customer) {
        Customer cust = customerService.updateUserBasicInformation(id, customer);
        return ResponseEntity.ok().body(new CustomerDTO(customer));
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<CustomerDTO> updateUserAddress(@PathVariable Long id, Customer customer) {
        Customer cust = customerService.updateUserBasicInformation(id, customer);
        return ResponseEntity.ok().body(new CustomerDTO(customer));
    }
}
