package com.example.kafka_learn.dto;

public class Book {

    // Class data members
    private String bookName;
    private String isbn;
    private String type;

    // Constructor 1
    public Book() {}

    // Constructor 2
    public Book(String bookName, String isbn, String tye)
    {
        // This keyword refers to
        // current instance itself
        this.bookName = bookName;
        this.isbn = isbn;
        this.type = tye;
    }

    // Setter
    public String getBookName() { return bookName; }

    // Setter
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    // Setter
    public String getIsbn() { return isbn; }

    // Setter
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}