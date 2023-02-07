package com.spring.security.SpringSecurityTest.repository;

import com.spring.security.SpringSecurityTest.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
