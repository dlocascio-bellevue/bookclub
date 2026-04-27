/**
 * Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
 * Modified by D. Locascio (2026)
 */

package com.bookclub.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
/**
 * WishlistRestController
 * 
 * Handles RESTful API endpoints for the wish list application.
 * Routes include:  
 *      - "api/wishlist" (GET)
 *      - "api/wishlist/{id}" (GET)  
 */
public class WishlistRestController {
    WishlistDao wishlistDao = new MongoWishlistDao();

    @Autowired
    /**
     * Setter for WishlistDao to allow for dependency injection.
     * @param wishlistDao
     */
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    /**
     * Retrieves all wishlist items from the DAO and returns them as JSON.
     * @return List of WishlistItem objects in JSON format.
     */
    public List<WishlistItem> showWishlist() {
        return wishlistDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    /**
     * Retrieves a wishlist item by its ID from the DAO and returns it as JSON.
     * @param id The ID of the wishlist item to retrieve.
     * @return The WishlistItem object in JSON format.
     */
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}
