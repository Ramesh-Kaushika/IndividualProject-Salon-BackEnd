package lk.project.salon.service;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;

public interface CustomerService {

    public Customer saveCustomer(CustomerDto customerDto);

    public Customer updateCustomer(Integer customerId,CustomerDto customerDto);
}
