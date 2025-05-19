package dev.jlprisan.LibraryManagment.Mapper;

import dev.jlprisan.LibraryManagment.DTO.*;
import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component
public class BookMapper {

    public List<BookEntity> toBookEntity(GoogleBookResponseDTO googleBookResponseDTO){

        return googleBookResponseDTO.getItems().stream()
                .map(item ->{
                    BookEntity bookEntity = new BookEntity();
                    VolumeInfoDTO volumeInfo = item.getVolumeInfo();
                    SaleInfoDTO saleInfo = item.getSaleInfo();
                    AccessInfoDTO accessInfo = item.getAccessInfo();

                    // Basic mapping
                    bookEntity.setTitle(volumeInfo.getTitle());
                    bookEntity.setAuthor(volumeInfo.getAuthors());
                    bookEntity.setPublishDate(volumeInfo.getPublishedDate());
                    bookEntity.setLanguage(volumeInfo.getLanguage());

                    // Null Checks

                    if(accessInfo != null){
                        bookEntity.setCountry(accessInfo.getCountry());
                    }
                    if(saleInfo != null){
                        bookEntity.setEbook(saleInfo.getEbook());
                    }

                    // ISBN's
                    volumeInfo.getIndustryIdentifiers().stream()
                            .filter(Objects::nonNull)
                            .forEach(identifier -> {
                                if("ISBN_10".equals(identifier.getType())){
                                    bookEntity.setIsbn10(identifier.getIdentifier());
                                } else if("ISBN_13".equals(identifier.getType())){
                                    bookEntity.setIsbn13(identifier.getIdentifier());
                                }
                            });

                    // Thumb Images
                    if(volumeInfo.getImageLinks() != null){
                        bookEntity.setThumbNail(volumeInfo.getImageLinks().getThumbnail());
                        bookEntity.setSmallThumbNail(volumeInfo.getImageLinks().getSmallThumbnail());
                    }

                    return bookEntity;
                })
                .collect(Collectors.toList());
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setTitle(googleBookResponseDTO.getItems().getVolumeInfo().getTitle());
//        bookEntity.setAuthor(googleBookResponseDTO.getItems().getVolumeInfo().getAuthors());
//        bookEntity.setPublishDate(googleBookResponseDTO.getItems().getVolumeInfo().getPublishedDate());
//        bookEntity.setLanguage(googleBookResponseDTO.getItems().getVolumeInfo().getLanguage());
//        bookEntity.setCountry(googleBookResponseDTO.getItems().getAccessInfo().getCountry());
//        bookEntity.setEbook(googleBookResponseDTO.getItems().getSaleInfo().getEbook());
//
//        // Processing ISBNs
//        if(googleBookResponseDTO.getItems().getVolumeInfo().getIndustryIdentifiers() != null){
//            for(IndustryIdentifiersDTO identifier : googleBookResponseDTO.getItems().getVolumeInfo().getIndustryIdentifiers()){
//                if("ISBN_10".equals((identifier.getType()))) {
//                    bookEntity.setIsbn10(identifier.getIdentifier());
//                } else if ("ISBN_13".equals(identifier.getType())){
//                    bookEntity.setIsbn13(identifier.getIdentifier());
//                }
//            }
//        }
//
//        // Thumb images
//        if(googleBookResponseDTO.getItems().getVolumeInfo().getImageLinks() != null){
//            bookEntity.setThumbNail(googleBookResponseDTO.getItems().getVolumeInfo().getImageLinks().getThumbnail());
//            bookEntity.setSmallThumbNail(googleBookResponseDTO.getItems().getVolumeInfo().getImageLinks().getSmallThumbnail());
//        }
//
//        return bookEntity;

    }

//    public String mapAndToString(GoogleBookResponseDTO dto) {
//        BookEntity entity = this.toBookEntity(dto);
//        return entity.toString(); // Usa el toString() de BookEntity
//    }

}
