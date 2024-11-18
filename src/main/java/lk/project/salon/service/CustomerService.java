package lk.project.salon.service;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(CustomerDto customerDto);



    List<Customer> getAllCustomer();


    String login(CustomerDto customerDto);


    String deleteCustomer(Integer id);
}
