/* 
Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
Modified by D. Locascio (2026)
*/ 

package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

/**
 * RestBookDao
 * 
 * Implements the BookDao interface to retrieve book data from the Open Library Books API.
 */
public class RestBookDao implements BookDao {
    /** 
     * No argument constructor to initialize a new RestBookDao object.
     */
    public RestBookDao() { } 

    /**
     * Retrieves a list of books from the Open Library Books API based on a predefined list of ISBNs.
     */
    @Override
    public List<Book> list() {
        String isbnString = "ISBN:9780553808049,ISBN:9781984821157,ISBN:9780553106633,ISBN:9780553801507,ISBN:9780553801477";
    
        // Retrieve the JSON document from the Open Library API for the specified ISBNs.
        Object doc = getBooksDoc(isbnString);

        List<Book> books = new ArrayList<>();
    
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        // Iterate through the retrieved data and create Book objects to add to the list.
        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index)));
        }
        return books;
    }

    /**
     * Retrieves a single book from the Open Library Books API based on the provided ISBN key.
     * 
     * @param key String
     * @return Book object with the retrieved data.
     */
    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = !isbns.isEmpty() ? isbns.get(0) : "N/A";
        String title = !titles.isEmpty() ? titles.get(0) : "N/A";
        String desc = !subtitle.isEmpty() ? subtitle.get(0) : "N/A";
        String infoUrl = !infoUrls.isEmpty() ? infoUrls.get(0) : "N/A";
        int numOfPages = !pages.isEmpty() ? pages.get(0) : 0;

        // Create and return a Book object with the retrieved data.
        Book book = new Book(isbn, title, desc, infoUrl, numOfPages);

        return book;
    }

    /**
     * Helper method to retrieve the JSON document from the Open Library Books API for a given ISBN string.
     * 
     * @param isbnString String
     * @return Object representing the parsed JSON document.
     */
    private Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        // Call the RestTemplate object to invoke a third-party API call.
        RestTemplate rest = new RestTemplate(); 

        // Set the HTTP headers to specify that we want to receive JSON data.
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        // Build the URI with query parameters for the API call.
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openLibraryUrl)
            .queryParam("bibkeys", isbnString)
            .queryParam("format", "json")
            .queryParam("jscmd", "details");

        // Create an HttpEntity object with the headers to include in the API call.
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Make the API call and retrieve the response as a String.
        HttpEntity<String> response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        // Parse the JSON response and return it as an Object.
        String jsonBooklist = response.getBody();

        // Use the JsonPath library to parse the JSON string and return it as an Object.
        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }
}