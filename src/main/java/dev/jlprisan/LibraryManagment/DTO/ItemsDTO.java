package dev.jlprisan.LibraryManagment.DTO;



public class ItemsDTO {

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfoDTO volumeInfo;
    private SaleInfoDTO saleInfo;
    private AccessInfoDTO accessInfo;
    private SearchInfoDTO searchInfo;

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

    public VolumeInfoDTO getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfoDTO volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfoDTO getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfoDTO saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfoDTO getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfoDTO accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfoDTO getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfoDTO searchInfo) {
        this.searchInfo = searchInfo;
    }
}
