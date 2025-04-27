package dev.jlprisan.LibraryManagment.DTO;

import java.util.List;

public class AccessInfoDTO {

    // Might not be a list
    private List<String> country;
    private String viewability;
    private Boolean embeddable;
    private Boolean publicDomain;
    private String textToSpeechPermission;
    private List<EpubDTO> epub;
}
