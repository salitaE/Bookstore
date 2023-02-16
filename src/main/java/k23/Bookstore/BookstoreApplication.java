package k23.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	@Autowired
	BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository) {
		return (args) -> {
			
			log.info("create books");
			bookRepository.save(new Book("Kasvoton kuolema", "Henning Mankell", "5689976", 2002, 12.0));
			bookRepository.save(new Book("Riian kasvot", "Henning Mankell", "5345596", 2010, 14.0));
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "36794596", 1929, 14.0));
			bookRepository.save(new Book("Animal Farm", "George Orwell", "5329636", 1945, 14.0));
				
			
			log.info("fetch all books from the database");
			for (Book book : bookRepository.findAll()) {
				log.info("kirja: " + book.toString());}
			};
		
		}
	
}
