package lk.project.salon.service.impl;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;
import lk.project.salon.repo.CustomerRepo;
import lk.project.salon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
