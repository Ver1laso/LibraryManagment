package dev.jlprisan.LibraryManagment.DTO;




import java.util.List;


public class GoogleBookResponseDTO {
    private String kind;
    private Integer totalItems;
    private List<ItemsDTO> items;
//    private SaleInfoDTO saleInfo;
//    private AccessInfoDTO accessInfo;
//    private List<PdfDTO> pdf;
//    private String webReaderLink;
//    private String accessViewStatus;
//    private Boolean quoteSharingAllowed;
//    private SearchInfoDTO searchInfo;
//    private VolumenInfoDTO volumenInfoDTO;


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
}
