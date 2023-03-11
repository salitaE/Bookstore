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
import k23.Bookstore.domain.Category;
import k23.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			log.info("choose category");
			categoryRepository.save(new Category("Jännitys"));
			categoryRepository.save(new Category("Rikosromaani"));
			categoryRepository.save(new Category("Realismi"));
			categoryRepository.save(new Category("Poliittinen satiiri"));
			categoryRepository.save(new Category("Lapset"));
			categoryRepository.save(new Category("Self help"));
			
			log.info("create books");
			bookRepository.save(new Book("Kasvoton kuolema", "Henning Mankell", "5689976", 1991, 10.9, categoryRepository.findByName("Jännitys").get(0)));
			bookRepository.save(new Book("Riian verikoirat", "Henning Mankell", "5345596", 1992, 14.1, categoryRepository.findByName("Rikosromaani").get(0)));
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "36794596", 1929, 14.0, categoryRepository.findByName("Realismi").get(0)));
			bookRepository.save(new Book("Animal Farm", "George Orwell", "5329636", 1945, 14.0, categoryRepository.findByName("Poliittinen satiiri").get(0)));	
			
			log.info("fetch all books from the database");
			for (Book book : bookRepository.findAll()) {
				log.info("kirja: " + book.toString());
				}
			};
		
		}
	
}
