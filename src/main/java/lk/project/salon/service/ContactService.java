package lk.project.salon.service;

import lk.project.salon.dto.ContactDto;
import lk.project.salon.entity.Contact;

import java.util.List;

public interface ContactService {
    Object saveContact(ContactDto contactDto);

    List<Contact> getAllContact();

    Object deleteContact(Integer id);
}
