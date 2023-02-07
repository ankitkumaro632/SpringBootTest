package com.spring.security.SpringSecurityTest.controller;

import com.spring.security.SpringSecurityTest.entities.Contact;
import com.spring.security.SpringSecurityTest.repository.ContactRepository;
import com.spring.security.SpringSecurityTest.service.ExcelFileService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class DownloadExcelController {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ExcelFileService excelFileService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/downloadExcelFile")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        List<Contact> contacts = (List<Contact>)contactRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = excelFileService.export(contacts);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=contacts.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
