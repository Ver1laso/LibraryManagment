package dev.jlprisan.LibraryManagment.DTO;

import java.util.List;

public class VolumeInfoDTO {

    private String title;
    private List<AuthorsDTO> authors;
    private String publisher;
    private Integer publishedDate;
    private String description;
    private List<IndustryIdentifiersDTO> industryIdentifiers;
    private List<ReadingModesDTO> readingModes;
    private Integer pageCount;
    private String printType;
    private List<String> categories;
    private String maturityRating;
    private Boolean allowAnonLogging;
    private String contentVersion;
    // Language might not be a list, keep in mind
    private List<String> language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}
