package com.example.clientes.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "release_date")
    private Date releaseDate;
    @Basic
    @Column(name = "author_id")
    private int authorId;
    @Basic
    @Column(name = "editorial_id")
    private int editorialId;
    @Basic
    @Column(name = "language")
    private String language;
    @Basic
    @Column(name = "pages")
    private int pages;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "book_cover")
    private String bookCover;
    @Basic
    @Column(name = "status")
    private int status;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && authorId == book.authorId && editorialId == book.editorialId && pages == book.pages && status == book.status && Objects.equals(title, book.title) && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(language, book.language) && Objects.equals(description, book.description) && Objects.equals(bookCover, book.bookCover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, releaseDate, authorId, editorialId, language, pages, description, bookCover, status);
    }
}
