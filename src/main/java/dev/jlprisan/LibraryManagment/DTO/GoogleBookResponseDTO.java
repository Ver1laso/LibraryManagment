package dev.jlprisan.LibraryManagment.DTO;

import java.util.List;

public class GoogleBookResponseDTO {
    private String kind;
    private Integer totalItems;
    private List<ItemsDTO> items;
    private SaleInfoDTO saleInfo;
    private AccessInfoDTO accessInfo;
    private List<PdfDTO> pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
    private SearchInfoDTO searchInfo;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<ItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemsDTO> items) {
        this.items = items;
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

    public List<PdfDTO> getPdf() {
        return pdf;
    }

    public void setPdf(List<PdfDTO> pdf) {
        this.pdf = pdf;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    public Boolean getQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    public SearchInfoDTO getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfoDTO searchInfo) {
        this.searchInfo = searchInfo;
    }
}
