package lk.project.salon.service.impl;

import lk.project.salon.dto.ContactDto;
import lk.project.salon.entity.Contact;
import lk.project.salon.repo.ContactRepo;
import lk.project.salon.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;

    @Override
    public Object saveContact(ContactDto contactDto) {
        Contact contact = new Contact(
                contactDto.getContactId(),
                contactDto.getName(),
                contactDto.getEmail(),
                contactDto.getPhone(),
                contactDto.getSubject()
        );
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepo.findAll();
    }

    @Override
    public Object deleteContact(Integer id) {
       if (contactRepo.existsById(id)){
           contactRepo.deleteById(id);
           return "Contact deleted";
       }
       return "No Contact found ";
    }
}
