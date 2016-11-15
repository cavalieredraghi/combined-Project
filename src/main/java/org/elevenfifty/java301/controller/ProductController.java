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
		return "home";
	}
	
	//TODO something here is messing up the heroku app page for the product lists.
	@GetMapping("/product/list")
	public String ingredientList(Model model) {
//		model.addAttribute("products", proRepo.findAll());
		model.addAttribute("smoothies", smoothRepo.findAll());
		return "product_list";
	}

//checking the errors it has either to do with the Product portion or something with SQL
	

	
	
}

