package dev.jlprisan.LibraryManagment.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleInfoDTO {


    private String country;
    private String saleability;
    private Boolean isEbook;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public Boolean getEbook() {
        return isEbook;
    }

    public void setEbook(Boolean ebook) {
        isEbook = ebook;
    }
}
