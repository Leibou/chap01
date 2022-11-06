package org.sid.chapcrud.api;

import lombok.AllArgsConstructor;
import org.sid.chapcrud.models.Book;
import org.sid.chapcrud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    BookRepository bookRepository;


    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/book/{book_id}")
    public Optional<Book> getBookById(@PathVariable(value = "book_id") Long id){
        return bookRepository.findById(id);
    }

    @PostMapping("/add")
    public Book addbook(@RequestBody Book book){
        return bookRepository.save(book);
    }



}
