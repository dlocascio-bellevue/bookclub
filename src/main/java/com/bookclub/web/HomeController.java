/*
Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
*/

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import com.bookclub.model.Book;
import com.bookclub.service.impl.RestBookDao;
import java.util.List;

/**
 * HomeController
 * 
 * Handles navigation for the Bookclub application.
 * Routes include:
 * - "/" (home page)
 * - "/about"
 * - "/contact"
 * - "/{id}" (Book of the month details)
 */

@Controller
@RequestMapping("/")


/**
 * Displays the home page with the full list of books.
 * @param model
 * @return index.html view
*/
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        RestBookDao bookDao = new RestBookDao();
        List<Book> books = bookDao.list();

        for (Book book : books) {
            System.out.println(book.toString());
        }

        model.addAttribute("books", books);

        return "index";
    }

    /**
     * Displays the About Us page
     * @param model
     * @return about.html view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    /**
     * Displays the Contact Us page
     * @param model
     * @return contact.html
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    }

    /**
     * Displays the details for the book of the month.
     * The {id} path variable represents the book's ISBN.
     * @param id
     * @param model
     * @return view.html view
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        String isbn = id;
        System.out.println(id);

        RestBookDao bookDao = new RestBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}