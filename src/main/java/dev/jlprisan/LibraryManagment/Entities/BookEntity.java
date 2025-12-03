package dev.jlprisan.LibraryManagment.Entities;


import jakarta.persistence.*;


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
//    @Column(name = "isbn_10", length = 13)
    private String isbn10;
//    @Column(name = "isbn_13", length = 17)
    private String isbn13;
    @Column(name = "thumbnail_url", length = 512)
    private String thumbNail;
    @Column(name = "small_thumbnail_url", length = 512)
    private String smallThumbNail;
    private String language;
    private String country;
    private Boolean isEbook;
    private boolean borrowed;
    private String borrowedTo;
    private String notes;



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

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public String getSmallThumbNail() {
        return smallThumbNail;
    }

    public void setSmallThumbNail(String smallThumbNail) {
        this.smallThumbNail = smallThumbNail;
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

    public String getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(String borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publishDate='" + publishDate + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", thumbNail='" + thumbNail + '\'' +
                ", smallThumbNail='" + smallThumbNail + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", isEbook=" + isEbook +
                ", borrowed=" + borrowed +
                ", borrowedTo='" + borrowedTo + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
