/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * RestBookDao class.
 * This class retrieves book data from the OpenLibrary API.
 */
public class RestBookDao implements BookDao {

    /**
     * Calls the OpenLibrary API and returns a parsed JSON document.
     *
     * @param isbnString the ISBN string used by the API
     * @return parsed JSON document
     */
    private Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openLibraryUrl)
        .queryParam("bibkeys", isbnString)
        .queryParam("format", "json")
        .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }

    /**
     * Returns a list of books from OpenLibrary.
     *
     * @return list of books
     */
    @Override
    public List<Book> list(String key) {
        Object doc = getBooksDoc(key);

        List<Book> books = new ArrayList<>();
        List<String> isbns = JsonPath.read(doc, "$.*.bib_key");
        List<String> titles = JsonPath.read(doc, "$.*.details.title");
        List<String> infoUrls = JsonPath.read(doc, "$.*.info_url");

        for (int index = 0; index < isbns.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), "N/A", infoUrls.get(index), 0));
        }

        return books;
    }

    /**
     * Finds one book from OpenLibrary by ISBN.
     *
     * @param key the ISBN key
     * @return matching book
     */
    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$.*.bib_key");
        List<String> titles = JsonPath.read(doc, "$.*.details.title");
        List<String> subtitles = JsonPath.read(doc, "$.*.details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$.*.info_url");
        List<Integer> pages = JsonPath.read(doc, "$.*.details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String description = subtitles.size() > 0 ? subtitles.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        return new Book(isbn, title, description, infoUrl, numOfPages);
    }
}