package org.elevenfifty.java301.controller;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.ProductImage;
import org.elevenfifty.java301.repository.ProductImageRepository;
import org.elevenfifty.java301.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private ProductImageRepository proImageRepo;
	
	@GetMapping(path = { "/home", "/", "" })
	public String home(Model model) {
		model.addAttribute("products", proRepo.findAll());
		return "home";
	}
	
	@GetMapping("/product")
	public String productList(Model model) {
		model.addAttribute("products", proRepo.findAll());
		return "product_list";
	}
	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);

		Product u = proRepo.findOne(id);

		model.addAttribute("user", u);

		ProductImage i = proImageRepo.findByProductId(id);
		model.addAttribute("userImage", i);

		return "product_detail";
	}
	
}
