/*
Locascio, D. (2026). CIS 530 Server-Side Development. Bellevue University, all right reserved. 
*/

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;

import java.util.List;
import jakarta.validation.Valid;

/**
 * WishlistController
 * 
 * Handles navigation for the wish list application.
 * Routes include:
 * - "wishlist/list"
 * - "wishlist/new"
 * - "/wishlist"
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    /**
     * Retrieves all wishlist items from the in-memory DAO and passes them to the view.
     * @param model
     * @return wishlist/list view.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        MemWishlistDao wishlistDao = new MemWishlistDao();
        List<WishlistItem> wishlist = wishlistDao.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";
    }

    /**
     * Displays the form for creating a new wishlist item.
     * @param model
     * @return wishlist/new view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    /**
     * Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
     * 
     * WishlistItem is validated. If error exists, a new form re-displays. If no error exists, the display redirects back to the wishlist page.
     * @param wishlistItem
     * @param bindingResult
     * @return appropriate validation outcome
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        return "redirect:/wishlist";
    }
}