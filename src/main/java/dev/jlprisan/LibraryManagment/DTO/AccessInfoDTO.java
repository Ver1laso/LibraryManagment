package dev.jlprisan.LibraryManagment.DTO;

import java.util.List;

public class AccessInfoDTO {


    private List<String> country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private EpubDTO epub;
    private PdfDTO pdf;

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public String getViewability() {
        return viewability;
    }

    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public Boolean getPublicDomain() {
        return publicDomain;
    }

    public void setPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    public EpubDTO getEpub() {
        return epub;
    }

    public void setEpub(EpubDTO epub) {
        this.epub = epub;
    }

    public PdfDTO getPdf() {
        return pdf;
    }

    public void setPdf(PdfDTO pdf) {
        this.pdf = pdf;
    }
}
