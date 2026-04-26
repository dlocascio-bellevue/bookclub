/*
Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
*/

package com.bookclub.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class SecurityController {
    /**
     * This method handles GET requests to the /login endpoint and returns the login view.
     * @return The name of the login view template to be rendered.
     */
    @RequestMapping(path = "/login", method=RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    /**
     * This method handles GET requests to the /logout endpoint, performs logout operations, and redirects to the login page with a logout parameter.
     * @param request  // HttpServletRequest object used to perform logout operations.
     * @param response // HttpServletResponse object used to perform logout operations.
     * @return A redirect string to the login page with a logout parameter indicating that the user has been logged out.
     */
    @RequestMapping(path = "/logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // If the user is authenticated, perform logout operations using SecurityContextLogoutHandler.
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        // Redirect to the login page with a logout parameter to indicate that the user has been logged out.
        return "redirect:/login?logout=true";
    }
}