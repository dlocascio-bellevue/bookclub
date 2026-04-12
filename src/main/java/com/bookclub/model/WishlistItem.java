/*
Locascio, D. (2026). CIS 530 Server-Side Development. Bellevue University, all right reserved. 
*/ 
package com.bookclub.model;

//VMware Tanzu. Getting started: Validating form input. Getting Started | Validating Form Input. (2026). https://spring.io/guides/gs/validating-form-input 
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

public class WishlistItem {
    // Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title;

    /**
     * No-arg constructor to initialize a new wish list item object.
     */
    public WishlistItem() {
    }

    /**
     * Constructor to fully initialize a wish list item object.
     * 
     * @param isbn String
     * @param title String
     */
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    /**
     * Mutator method to set isbn.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Accessor method to get isbn.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Mutator method to set title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor method to get title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Override toString to return a formatted string representation of a wish list item object.
     */
    @Override
    public String toString() {
        // return String.format("WishlistItem{isbn=%s, title=%s}", isbn, title);
        return String.format("WishlistItem{isbn=<isbnValue>, title=<titleValue>}");
    }
}
