package com.example.kafkaexample.springevent;

import com.example.kafkaexample.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Autowired
    private ApplicationEventPublisher publisher;

    public Book createNewBooks(Book bk)
    {
        Book book =  new Book();
        book.setBookName(bk.getBookName());
        book.setIsbn(bk.getIsbn());
        publisher.publishEvent(new BookEvent( "ADD", book));  //publish event
        return book;
    }
}
