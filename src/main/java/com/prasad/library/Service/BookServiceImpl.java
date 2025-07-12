package com.prasad.library.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prasad.library.Beans.Book;
import com.prasad.library.Repository.BookRepository;
import com.prasad.library.dto.BookRequestDTO;
import com.prasad.library.dto.BookResponseDTO;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }


    private BookResponseDTO toDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setAvailable(book.getAvailable());
        return dto;
    }

    @Override
    public BookResponseDTO addBook(BookRequestDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setAvailable(true);
        Book saved = repo.save(book);
        return toDTO(saved);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return repo.findAll()
                   .stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO getBookById(Integer id) {
        Optional<Book> bookOpt = repo.findById(id);
        return bookOpt.map(this::toDTO).orElse(null);
    }

    @Override
    public ResponseEntity<?> updateAvailabilityById(Integer id, Boolean available) {
        Optional<Book> bookOpt = repo.findById(id);
        if (!bookOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Book book = bookOpt.get();
        book.setAvailable(available);
        Book updated = repo.save(book);
        return ResponseEntity.ok(toDTO(updated));
    }

    @Override
    public String deleteBookById(Integer id) {
        if (!repo.existsById(id)) {
            return "Book not found with id: " + id;
        }
        repo.deleteById(id);
        return "Book deleted successfully with id: " + id;
    }
}
