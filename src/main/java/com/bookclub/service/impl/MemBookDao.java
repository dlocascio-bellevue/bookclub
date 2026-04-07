/* 
Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
Modified by D. Locascio (2026)
*/ 

package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import java.util.*;


/**
 * MemBookDao
 * 
 * An in-memory implementation of the BookDao interface.
 */
public class MemBookDao implements BookDao {
    private List<Book> books;

    /**
     * Constructor
     * 
     * Initializes the in-memory book list.
     * Book properties include:
     * - ISBN
     * - Title
     * - Description
     * - Page Count
     * - Authors
     */
    public MemBookDao() {
        this.books = new ArrayList<Book>();
        /* Martin, G. R. R. (2016). A game of thrones: The illustrated edition book one of a song of ice and fire. Bantam Books. */
        this.books.add(new Book("9780553808049", "A Game of Thrones", "The first volume in the Game of Throne series.", 896, new ArrayList<>(List.of("George R. R. Martin"))));
        /* Martin, G. R. R., & Cannon, L. K. (2019). A clash of kings. Bantam Books. */
        this.books.add(new Book("9781984821157", "A Clash of Kings", "The second volume in the Game of Throne series.", 768, new ArrayList<>(List.of("George R. R. Martin"))));
        /* Martin, G. R. R. (2011). A storm of swords. Bantam Books.  */
        this.books.add(new Book("9780553106633", "A Storm of Swords", "The third volume in the Game of Throne series.", 992, new ArrayList<>(List.of("George R. R. Martin"))));
        /* Martin, G. R. R. (2005). A feast for crows: Book four, a song of ice and fire. Bantam Books. */
        this.books.add(new Book("9780553801507", "A Feast for Crows", "The fourth volume in the Game of Throne series.", 784, new ArrayList<>(List.of("George R. R. Martin"))));
        /* Martin, G. R. R., & Abraham, D. (2011). A song of ice and fire. Bantam Books. */
        this.books.add(new Book("9780553801477", "A Dance with Dragons", "The fifth volume in the Game of Throne series.", 1040, new ArrayList<>(List.of("George R. R. Martin"))));                             
    }

    /**
     * Returns all books stored in memory.
     * @return list of book objects
     */
    @Override
    public List<Book> list() {
        return this.books;
    }

    /**
     * Find a book by its ISBN.
     * @param key
     * @return The designated book object, or a new empty book if not found.
     */
    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}