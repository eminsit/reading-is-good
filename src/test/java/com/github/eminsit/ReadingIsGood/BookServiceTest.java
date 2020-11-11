package com.github.eminsit.ReadingIsGood;

import com.github.eminsit.ReadingIsGood.exceptions.BookNotFoundException;
import com.github.eminsit.ReadingIsGood.models.Book;
import com.github.eminsit.ReadingIsGood.repositories.BookRepository;
import com.github.eminsit.ReadingIsGood.services.BookService;
import com.github.eminsit.ReadingIsGood.services.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
class BookServiceTest {

	@InjectMocks
	BookServiceImpl bookService;

	@Mock
	BookRepository bookRepository;

	private Long bookId = 1l;


	@Test
	public void whenUpdateStock_shouldThrowException() {
		Mockito.when(bookRepository.findBookById(bookId)).thenReturn(null);

		BookNotFoundException exception = assertThrows(BookNotFoundException.class, () -> {
			bookService.updateCount(bookId, 21);
		});
		assertEquals("Could not find book 1", exception.getMessage());
	}


	@Test
	public void whenUpdateStock_shouldSaveCorrectly() {
		Book book = new Book();
		book.setCount(3);
		book.setId(bookId);
		book.setTitle("Alchemist");
		book.setAuthorName("Paulo Coelho");
		book.setPrice(3.3);

		Mockito.when(bookRepository.findBookById(bookId)).thenReturn(book);
		book.setCount(21);
		Mockito.when(bookRepository.save(book)).thenReturn(book);


		Book savedBook = bookService.updateCount(bookId, 21);

		assertEquals(book, savedBook);
	}
}
