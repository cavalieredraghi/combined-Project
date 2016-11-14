package org.elevenfifty.java301.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.ProductImage;
import org.elevenfifty.java301.beans.Smoothie;
import org.elevenfifty.java301.beans.SmoothieImage;
import org.elevenfifty.java301.repository.ProductImageRepository;
import org.elevenfifty.java301.repository.ProductRepository;
import org.elevenfifty.java301.repository.SmoothieImageRepository;
import org.elevenfifty.java301.repository.SmoothieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private ProductImageRepository proImageRepo;
	@Autowired
	private SmoothieRepository smoothRepo;
	@Autowired
	private SmoothieImageRepository smoothImageRepo;
	
	@GetMapping(path = { "/home", "/", "" })
	public String home(Model model) {
		model.addAttribute("products", proRepo.findAll());
		return "home";
	}
	
	@GetMapping("/product/list")
	public String productList(Model model) {
		model.addAttribute("products", proRepo.findAll());
		model.addAttribute("smoothies", smoothRepo.findAll());
		return "product_list";
	}
	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);

		Product u = proRepo.findOne(id);

		model.addAttribute("product", u);

		ProductImage i = proImageRepo.findByProductId(id);
		model.addAttribute("userImage", i);

		return "product_detail";
	}
	
	


	
	
}

