/*
Locascio, D. (2026). CIS 530 Server-Side Development. Bellevue University, all right reserved. 
*/ 

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.*;

/**
 * MemWishlistDao
 * 
 * An in-memory implementation of the WishlistDao interface.
 */
public class MemWishlistDao implements WishlistDao {
    private List<WishlistItem> wishlist;

    /**
     * Constructor
     * 
     * Initializes the in-memory wish list.
     * Wish list properties include:
     * - Isbn
     * - Title
     */
    public MemWishlistDao() {
        this.wishlist = new ArrayList<WishlistItem>();
        this.wishlist.add(new WishlistItem("9780553808049", "A Game of Thrones"));
        this.wishlist.add(new WishlistItem("9781984821157", "A Clash of Kings"));
        this.wishlist.add(new WishlistItem("9780553106633", "A Storm of Swords"));
        this.wishlist.add(new WishlistItem("9780553801507", "A Feast for Crows"));
        this.wishlist.add(new WishlistItem("9780553801538", "The Winds of Winter"));
    }

    /**
     * Returns all wish list items stored in memory.
     * @return list of wish item objects.
     */
    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    /**
     * Find a wish list item by its ISBN.
     * @param key
     * @return The designated wish list item, or a new empty wish list item if not found.
     */
    @Override
    public WishlistItem find(String key) {
        for (WishlistItem item : wishlist) {
            if (item.getIsbn().equals(key)) {
                return item;
            }
        }
        return new WishlistItem();
    }
}
