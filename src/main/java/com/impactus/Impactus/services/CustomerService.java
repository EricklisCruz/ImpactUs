package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.Address;
import com.impactus.Impactus.domain.user.Customer;
import com.impactus.Impactus.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer updateUserBasicInformation(Long id, Customer customer) {
        try {
            Customer entity = customerRepository.getReferenceById(id);
            updateData(entity, customer);
            return customerRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("User Not Found");
        }
    }

    private void updateData(Customer entity, Customer customer) {
        entity.setName(customer.getName());
        entity.setSurname(customer.getSurname());
        entity.setLastPhone(customer.getLastPhone());
    }

    public Customer updateUserAddress(Long id, Customer customer) {
        try {
            Customer entity = customerRepository.getReferenceById(id);
            updateUserAddressData(entity, customer);
            return customerRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("User Not Found");
        }
    }

    private void updateUserAddressData(Customer entity, Customer customer) {
        entity.setAddress( new Address( customer.getAddress().getStreet(),customer.getAddress().getCity(),
                customer.getAddress().getState(), customer.getAddress().getZipCode(), customer.getAddress().getCountry()));
    }

    public void deleteCustomer(Long id) {
        try {
            boolean user = customerRepository.existsById(id);
            if (user) {
                customerRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("User not found!");
        }

    }
}
