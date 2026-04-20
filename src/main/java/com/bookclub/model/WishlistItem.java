/**
 * Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
 * Modified by D. Locascio (2026)
 */

package com.bookclub.model;

//VMware Tanzu. Getting started: Validating form input. Getting Started | Validating Form Input. (2026). https://spring.io/guides/gs/validating-form-input 
import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {

    @Id
    private String id;

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
     * Accessor method to get title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Accessor method to get Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Override toString to return a formatted string representation of a wish list item object.
     */
    @Override
    public String toString() {
        return String.format("WishlistItem{isbn=%s, title=%s, id=%s}", isbn, title, id);
    }
}
