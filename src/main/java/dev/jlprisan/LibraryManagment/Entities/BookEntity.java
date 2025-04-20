package dev.jlprisan.LibraryManagment.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity borrowedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public UserEntity getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(UserEntity borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
