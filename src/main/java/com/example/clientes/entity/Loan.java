package com.example.clientes.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Loan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "loan_id")
    private int loanId;
    @Basic
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "loan_date")
    private Date loanDate;
    @Basic
    @Column(name = "return_date")
    private Date returnDate;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId && clientId == loan.clientId && bookId == loan.bookId && Objects.equals(loanDate, loan.loanDate) && Objects.equals(returnDate, loan.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, clientId, bookId, loanDate, returnDate);
    }
}
