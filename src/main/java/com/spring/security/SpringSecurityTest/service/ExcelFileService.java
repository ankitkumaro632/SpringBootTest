package com.spring.security.SpringSecurityTest.service;

import com.spring.security.SpringSecurityTest.entities.Contact;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ExcelFileService {

    ByteArrayInputStream export(List<Contact> contacts);

}
