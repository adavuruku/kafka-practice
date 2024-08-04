package com.example.kafkaexample.springevent;

import com.example.kafkaexample.dto.Book;

public class BookEvent {

    private String eventType;

    public String getEventType() {
        return eventType;
    }

    public Book getBook() {
        return book;
    }

    public BookEvent(String eventType, Book book) {
        this.eventType = eventType;
        this.book = book;
    }

    private Book book;
}
