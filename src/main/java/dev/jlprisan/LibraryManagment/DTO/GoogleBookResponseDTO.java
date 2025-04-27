package dev.jlprisan.LibraryManagment.DTO;

import java.util.List;

public class GoogleBookResponseDTO {
    private String kind;
    private Integer totalItems;
    private List<ItemsDTO> items;
    private List<SaleInfoDTO> saleInfo;
    private List<AccessInfoDTO> accessInfo;
    private List<PdfDTO> pdf;
    private String webReaderLink;
    private String accessViewStatus;
    private Boolean quoteSharingAllowed;
    private List<SearchInfoDTO> searchInfo;
}
