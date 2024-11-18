package lk.project.salon.controller;

import lk.project.salon.dto.CustomerDto;
import lk.project.salon.entity.Customer;
import lk.project.salon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        try {
            Customer savedCustomer = customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerDto customerDto) {
        String token = customerService.login(customerDto);
        return ResponseEntity.ok(token);
    }




    @GetMapping
    public ResponseEntity<Object> getAllCustomer(){
        List<Customer> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
        String deleted = customerService.deleteCustomer(id);
        return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }


}

