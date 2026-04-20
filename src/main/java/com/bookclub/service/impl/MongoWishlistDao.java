/**
 * Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
 * Modified by D. Locascio (2026)
 */

package com.bookclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;


/**
 * MongoWishlistDao
 * 
 * Implements Spring's MongoTemplate to perform CRUD operations for WishlistItem entities.
 */
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * This method is used by the controller to populate the wishlist view.
     * 
     * @return List of all WishlistItem documents.
     */
    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    /**
     * Adds a new WishlistItem document to MongoDB
     * 
     * @param WishlistItem entity
     */
    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Updates an existing WishlistItem document.
     * 
     * @param WishlistItem entity
     * @throws UnsupportedOperationException 
     */
    @Override
    public void update(WishlistItem entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /**
     * Removes a WishlistItem document from MongoDB.
     * 
     * @param WishlistItem entity
     * @return false until implemented
     * @throws UnsupportedOperationException 
     */
    @Override
    public boolean remove(WishlistItem entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

     /**
     * Finds a WishlistItem by its unique key.
     * 
     * @param Key id
     * @return WishlistItem when implemented.
     * @throws UnsupportedOperationException 
     */
    @Override
    public WishlistItem find(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
}
