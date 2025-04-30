package dev.jlprisan.LibraryManagment.Mapper;

import dev.jlprisan.LibraryManagment.DTO.GoogleBookResponseDTO;
import dev.jlprisan.LibraryManagment.DTO.ImageLinksDTO;
import dev.jlprisan.LibraryManagment.DTO.IndustryIdentifiersDTO;
import dev.jlprisan.LibraryManagment.DTO.VolumenInfoDTO;
import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import dev.jlprisan.LibraryManagment.Entities.ImageLinksEntity;
import dev.jlprisan.LibraryManagment.Entities.IsbnEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookEntity toBookEntity(GoogleBookResponseDTO googleBookResponseDTO){
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(googleBookResponseDTO.getVolumenInfoDTO().getTitle());
        bookEntity.setAuthor(googleBookResponseDTO.getVolumenInfoDTO().getAuthors());
        bookEntity.setPublishDate(googleBookResponseDTO.getVolumenInfoDTO().getPublishedDate());
//        bookEntity.setIsbnList(mapIsbnLiksDTOToEntity(googleBookResponseDTO.getVolumenInfoDTO().getIndustryIdentifiers(),bookEntity));
        bookEntity.setImageLinksEntity(mapImageLinksDTOToEntity(googleBookResponseDTO.getVolumenInfoDTO().getImageLinks()));

        return bookEntity;
    }


//    public static List<IsbnEntity> mapIsbnLiksDTOToEntity(List<IndustryIdentifiersDTO> dtoList, BookEntity book){
//        if(dtoList == null) return Collections.emptyList();
//
//        return dtoList.stream().map(dto ->{
//            IsbnEntity isbn = new IsbnEntity();
//            isbn.setType(dto.getType());
//            isbn.setIdentifier(dto.getIdentifier());
//            isbn.setBook(book);
//            return isbn
//        }).collect(Collectors.toList());
//    }

    public static ImageLinksEntity mapImageLinksDTOToEntity(ImageLinksDTO dto){
        if(dto == null) return null;

        ImageLinksEntity entity = new ImageLinksEntity();
        entity.setThumbnail(dto.getThumbnail());
        entity.setSmallThumbnail(dto.getSmallThumbnail());
        return entity;
    }
}
