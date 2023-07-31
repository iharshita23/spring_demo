package com.bookapp.util;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import com.bookapp.model.Book;
@Component
public class BookDetails {
	public static List<Book> showBooks() {

		return Arrays.asList(

				new Book("Rich Dad POor Dad", "Harshita", "Tech", 1, 900, LocalDate.of(2010, 03, 20)),

				new Book("5 am club", "Robin Sharma", "Selfhelp", 2, 300, LocalDate.of(2020, 06, 10)),

				new Book("HTML for Dummies", "Ben John", "Tech", 3, 1900, LocalDate.of(2012, 04, 20)),

				new Book("Secret Seven", "Enid Ben", "Fiction", 4, 700, LocalDate.of(2014, 03, 20)),

				new Book("Seven Habits", "JHarshita", "Selfhelp", 5, 800, LocalDate.of(2010, 03, 20))

		);

	}
}
