package com.prasad.library.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prasad.library.dto.BookRequestDTO;
import com.prasad.library.dto.BookResponseDTO;

public interface BookService {

    BookResponseDTO addBook(BookRequestDTO requestDto);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO getBookById(Integer id);
    ResponseEntity<?> updateAvailabilityById(Integer id, Boolean available);
    String deleteBookById(Integer id);

}
