package com.tosansoha.library;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tosansoha.library.models.Book;
import com.tosansoha.library.models.Member;
import com.tosansoha.library.services.*;

@RestController
public class LibraryController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MemberService memberService;

    public LibraryController() {
    }
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String welcome() {
        return "Hello Traveler!";
    }

    @RequestMapping(value="/book/add", method=RequestMethod.POST)
    public Book addBook(@RequestBody Map<String, String> body) {
        return bookService.addBook(body);
    }

    @RequestMapping(value="/book/update/{id:[\\d]+}", method=RequestMethod.POST)
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        return bookService.updateBook(id, body);
    }

    @RequestMapping(value="/book/delete/{id:[\\d]+}", method=RequestMethod.POST)
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "Done.";
    }

    @RequestMapping(value="/book/show/{id:[\\d]+}", method=RequestMethod.GET)
    public List<Book> getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value="/book/show", method=RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value="/member/add", method=RequestMethod.POST)
    public Member addMember(@RequestBody Map<String, String> body) {
        return memberService.addMember(body);
    }

    @RequestMapping(value="/member/update/{id:[\\d]+}", method=RequestMethod.POST)
    public Member updateMember(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        return memberService.updateMember(id, body);
    }

    @RequestMapping(value="/member/delete/{id:[\\d]+}", method=RequestMethod.POST)
    public String deleteMember(@PathVariable("id") Integer id) {
        memberService.deleteMember(id);
        return "Done.";
    }

    @RequestMapping(value="/member/show/{id:[\\d]+}", method=RequestMethod.GET)
    public List<Member> getMemberById(@PathVariable("id") Integer id) {
        return memberService.getMemberById(id);
    }

    @RequestMapping(value="/member/show", method=RequestMethod.GET)
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
