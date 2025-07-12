package com.prasad.library.dto;

import jakarta.persistence.Column;

public class BookRequestDTO {
    
    private String title;
    
    private String author;
    
    private String isbn;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    // private Boolean available;
}
 