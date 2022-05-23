package com.example.clientes.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_category", schema = "public", catalog = "library_db")
public class BookCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_book_category")
    private int idBookCategory;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "book_category_id")
    private int bookCategoryId;

    public int getIdBookCategory() {
        return idBookCategory;
    }

    public void setIdBookCategory(int idBookCategory) {
        this.idBookCategory = idBookCategory;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCategory that = (BookCategory) o;
        return idBookCategory == that.idBookCategory && bookId == that.bookId && categoryId == that.categoryId && bookCategoryId == that.bookCategoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBookCategory, bookId, categoryId, bookCategoryId);
    }
}
