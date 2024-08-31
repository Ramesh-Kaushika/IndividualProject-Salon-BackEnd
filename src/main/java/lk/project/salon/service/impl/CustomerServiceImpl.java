package lk.project.salon.service.impl;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;
import lk.project.salon.repo.CustomerRepo;
import lk.project.salon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) throws IllegalArgumentException {
        if (customerRepo.findByEmail(customerDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists!");
        }

        if (customerRepo.findByPhoneNumber(customerDto.getPhoneNumber()).isPresent()) {
            throw new IllegalArgumentException("Phone Number already exists!");
        }

        if (customerRepo.findByPassword(customerDto.getPassword()).isPresent()) {
            throw new IllegalArgumentException("Password already exists!");
        }
        Customer customer = new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getGender(),
                customerDto.getEmail(),
                customerDto.getPhoneNumber(),
                customerDto.getRole(),
                customerDto.getPassword()
        );
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer customerId, CustomerDto customerDto) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID must not be null");
        }

        Optional<Customer> existingCustomerOpt = customerRepo.findById(customerId);

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();

            // Check for unique constraints on email, phone number, and password
            if (customerRepo.findByEmail(customerDto.getEmail()).isPresent() &&
                    !existingCustomer.getEmail().equals(customerDto.getEmail())) {
                throw new IllegalArgumentException("Email already exists!");
            }

            if (customerRepo.findByPhoneNumber(customerDto.getPhoneNumber()).isPresent() &&
                    !existingCustomer.getPhoneNumber().equals(customerDto.getPhoneNumber())) {
                throw new IllegalArgumentException("Phone Number already exists!");
            }

            if (customerRepo.findByPassword(customerDto.getPassword()).isPresent() &&
                    !existingCustomer.getPassword().equals(customerDto.getPassword())) {
                throw new IllegalArgumentException("Password already exists!");
            }

            // Update fields of the existing customer entity with the values from the DTO
            existingCustomer.setCustomerName(customerDto.getCustomerName());
            existingCustomer.setGender(customerDto.getGender());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());
            existingCustomer.setRole(customerDto.getRole());
            existingCustomer.setPassword(customerDto.getPassword());

            // Save the updated customer entity back to the database
            return customerRepo.save(existingCustomer);
        } else {
            throw new IllegalArgumentException("Customer not found!");
        }
    }
}
