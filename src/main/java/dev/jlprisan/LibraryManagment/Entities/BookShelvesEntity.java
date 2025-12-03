package dev.jlprisan.LibraryManagment.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name="bookshelves")
public class BookShelvesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="room_id")
    private Long roomid;

    private String name;
    private Long total_shelves;
    private String qr_code;

    @Column(name="qr_code_generated_at")
    private LocalDateTime qr_code_generated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoom_id() {
        return roomid;
    }

    public void setRoom_id(Long room_id) {
        this.roomid = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotal_shelves() {
        return total_shelves;
    }

    public void setTotal_shelves(Long total_shelves) {
        this.total_shelves = total_shelves;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public Date getQr_code_generated_at() {
        return qr_code_generated_at;
    }

    public void setQr_code_generated_at(Date qr_code_generated_at) {
        this.qr_code_generated_at = qr_code_generated_at;
    }
}
