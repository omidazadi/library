package com.tosansoha.library;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tosansoha.library.services.*;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private OwnershipService ownershipService;

    public LibraryController() {
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String welcome() {
        return "Hello Traveler!";
    }

    @RequestMapping(value="/book/add", method=RequestMethod.POST)
    public String addBook(@RequestBody Map<String, String> body) {
        return bookService.addBook(body).toString();
    }

    @RequestMapping(value="/book/{id:[\\d]+}/update", method=RequestMethod.POST)
    public String updateBook(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        return bookService.updateBook(id, body).toString();
    }

    @RequestMapping(value="/book/{id:[\\d]+}/delete", method=RequestMethod.POST)
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "Done.";
    }

    @RequestMapping(value="/book/{id:[\\d]+}/show", method=RequestMethod.GET)
    public String getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id).toString();
    }

    @RequestMapping(value="/book/show", method=RequestMethod.GET)
    public String getAllBooks() {
        return bookService.getAllBooks().toString();
    }

    @RequestMapping(value="/member/add", method=RequestMethod.POST)
    public String addMember(@RequestBody Map<String, String> body) {
        return memberService.addMember(body).toString();
    }

    @RequestMapping(value="/member/{id:[\\d]+}/update", method=RequestMethod.POST)
    public String updateMember(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        return memberService.updateMember(id, body).toString();
    }

    @RequestMapping(value="/member/{id:[\\d]+}/delete", method=RequestMethod.POST)
    public String deleteMember(@PathVariable("id") Integer id) {
        memberService.deleteMember(id);
        return "Done.";
    }

    @RequestMapping(value="/member/{id:[\\d]+}/show", method=RequestMethod.GET)
    public String getMemberById(@PathVariable("id") Integer id) {
        return memberService.getMemberById(id).toString();
    }

    @RequestMapping(value="/member/{id:[\\d]+}/library", method=RequestMethod.GET)
    public String getAllOwnedBooks(@PathVariable("id") Integer id) {
        return memberService.getAllOwnedBooks(id).toString();
    }

    @RequestMapping(value="/member/show", method=RequestMethod.GET)
    public String getAllMembers() {
        return memberService.getAllMembers().toString();
    }

    @RequestMapping(value="/member/{mid:[\\d]+}/acquire/book/{bid:[\\d]+}", method=RequestMethod.POST)
    public String acquire(@PathVariable("mid") Integer memberId, @PathVariable("bid") Integer bookId, 
    @RequestBody Map<String, String> body) {
        return ownershipService.acquire(memberId, bookId, body).toString();
    }
}
