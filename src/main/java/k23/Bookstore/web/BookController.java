
package k23.Bookstore.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import org.slf4j.Logger;
//import k23.Bookstore.BookstoreApplication;
import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;
import k23.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	private static final Logger log =LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping(value= {"/main"})
	public String mainPage() {
		return "index";
		
	}
	
	@GetMapping("/booklist")
	public String showBooklist(Model model) {
		log.info("get books from db");
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	@GetMapping("/addBook")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("category", categoryRepository.findAll());
		return "newBook";
	}
	
	@PostMapping("saveBook")
	public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			log.info("some validation error happened");
			model.addAttribute("book", book);
			model.addAttribute("category", categoryRepository.findAll());
			return "/newBook";
		}
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping("edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("category", categoryRepository.findAll());
		return "editBook";
	}

}
