package lk.project.salon.controller;


import lk.project.salon.dto.ContactDto;
import lk.project.salon.entity.Contact;
import lk.project.salon.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired
    ContactService contactService;


    @PostMapping
    public ResponseEntity<Object> saveContact(@RequestBody ContactDto contactDto){
        Object newContact = contactService.saveContact(contactDto);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllContact(){
        List<Contact> allContact = contactService.getAllContact();
        return new ResponseEntity<>(allContact, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable Integer id){
        Object contact = contactService.deleteContact(id);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }


}
