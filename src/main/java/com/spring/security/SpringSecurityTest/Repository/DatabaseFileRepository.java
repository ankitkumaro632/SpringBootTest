package com.spring.security.SpringSecurityTest.Repository;

import com.spring.security.SpringSecurityTest.entites.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {
}
