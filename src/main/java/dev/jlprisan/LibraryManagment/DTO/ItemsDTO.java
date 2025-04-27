package dev.jlprisan.LibraryManagment.DTO;



public class ItemsDTO {

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumenInfoDTO volumeInfo;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumenInfoDTO getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumenInfoDTO volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
