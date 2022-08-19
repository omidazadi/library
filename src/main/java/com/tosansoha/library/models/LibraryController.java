package com.tosansoha.library.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tosansoha.library.TestService;

@Controller
public class LibraryController {
    @Autowired
    private TestService testService;
    
    @RequestMapping(value = "/test")
    public String addBook()
    {
        testService.addBook();
        return "Success?";
    }
}
