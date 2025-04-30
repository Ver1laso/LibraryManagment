package dev.jlprisan.LibraryManagment.Entities;

import dev.jlprisan.LibraryManagment.DTO.IndustryIdentifiersDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private List<String> author;
    private String publishDate;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IsbnEntity> isbnList = new ArrayList<>();
    @Embedded
    private ImageLinksEntity imageLinks;
    private String language;
    private String country;
    private Boolean isEbook;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity borrowedBy;

    public void addIsbnFromDTO(List<IndustryIdentifiersDTO> dtos){
        this.isbnList = dtos.stream()
                .map(dto ->{
                    IsbnEntity isbn = new IsbnEntity();
                    isbn.setType(dto.getType());
                    isbn.setIdentifier(dto.getIdentifier());
                    isbn.setBook(this);
                    return isbn;
                }).toList();
    }


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

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<IsbnEntity> getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(List<IsbnEntity> isbnList) {
        this.isbnList = isbnList;
    }

    public ImageLinksEntity getImageLinksEntity() {
        return imageLinks;
    }

    public void setImageLinksEntity(ImageLinksEntity imageLinksEntity) {
        this.imageLinks = imageLinksEntity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getEbook() {
        return isEbook;
    }

    public void setEbook(Boolean ebook) {
        isEbook = ebook;
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
