package k23.Bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.Category;
import k23.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	private static final Logger log =LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public String getCategory(Model model) {
		log.info("näytä kategoriat");
		model.addAttribute("categories", categoryRepository.findAll());
		return "categoryList";
	}
	@GetMapping("addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addCategory";
		
	}
	@PostMapping("saveCategory")
	public String saveCategory(@Valid Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("some validation error happened");
			return "/addCategory";
		}
		categoryRepository.save(category);
		return "redirect:categories";
	}
	/*
	@GetMapping("delete/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {
		categoryRepository.deleteById(id);
		return "redirect:/categoryList";
	}*/

}
