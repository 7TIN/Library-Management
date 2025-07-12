package com.prasad.library.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prasad.library.Service.BookService;
import com.prasad.library.dto.AvailabilityUpdateDTO;
import com.prasad.library.dto.BookRequestDTO;
import com.prasad.library.dto.BookResponseDTO;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO requestDto) {
        BookResponseDTO response = bookService.addBook(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer id) {
        BookResponseDTO book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PatchMapping("/avail/{id}")
    public ResponseEntity<?> updateAvailability(
            @PathVariable Integer id,
            @RequestBody AvailabilityUpdateDTO updateDTO) {
        return bookService.updateAvailabilityById(id, updateDTO.getAvailable());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        String result = bookService.deleteBookById(id);
        if (result.startsWith("Book not found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
