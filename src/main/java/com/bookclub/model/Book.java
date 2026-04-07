/*
Locascio, D. (2026). CIS 530 Server-Side Development. Bellevue University, all right reserved. 
*/ 

package com.bookclub.model;

import java.util.List;

/**
 * Represents a Book object with ISBN, Title, Description, Page Count, and Author.
 */
public class Book {
    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    /**
     * No argument constructor to initialize a new book object.
     */
    public Book() {
    }

    /**
     * Constructor to fully initialize a book object. 
     * 
     * @param isbn String
     * @param title String
     * @param description String
     * @param numOfPages int
     * @param authors List<String>
     */
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    /**
     * Mutator method to set ISBN.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Accessor method to get ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Mutator method to set Title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor method to get Title.
     */
    public String getTitle() {
        return title;
    } 

    /**
     * Mutator method to set Description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor method to get Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator method to set number of pages.
     */
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * Accessor method to get the number of pages.
     */
    public int getNumOfPages() {
        return numOfPages;
    }

    /**
     * Mutator method to set Authors.
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    /**
     * Accessor method to get Authors.
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Override toString to return a formatted string representation of the Book object.
     */
    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, numOfPages=%s, authors=%s}", isbn, title, description, numOfPages, authors);
    }
}
