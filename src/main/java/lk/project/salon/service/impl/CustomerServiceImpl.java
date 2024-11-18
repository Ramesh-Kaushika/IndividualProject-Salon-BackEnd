package lk.project.salon.service.impl;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;
import lk.project.salon.repo.CustomerRepo;
import lk.project.salon.service.CustomerService;
import lk.project.salon.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    AuthenticationManager authManager;

    private final CustomerRepo customerRepo;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) throws IllegalArgumentException {
        if (customerRepo.findByEmail(customerDto.getEmail()) != null) {
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
                encoder.encode(customerDto.getPassword()) //i m implement encode password

        );
        return customerRepo.save(customer);
    }

    @Override
    public String login(CustomerDto customerDto) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(customerDto.getEmail(),customerDto.getPassword()));
        if (authentication.isAuthenticated()) {
            String tokenCreate =  jwtService.generateToken(customerDto.getEmail());
            return ("token - " + tokenCreate) ;
        } else {
            return "fail";
        }
    }

    @Override
    public String deleteCustomer(Integer id) {
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return "Customer Deleted";
        }
        return "No customer found";
    }


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }


}
