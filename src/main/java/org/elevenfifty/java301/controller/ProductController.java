package org.elevenfifty.java301.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.ProductImage;
import org.elevenfifty.java301.repository.ProductImageRepository;
import org.elevenfifty.java301.repository.ProductRepository;
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
	
	@GetMapping(path = { "/home", "/", "" })
	public String home(Model model) {
		model.addAttribute("products", proRepo.findAll());
		return "home";
	}
	
	@GetMapping("/product/list")
	public String productList(Model model) {
		model.addAttribute("products", proRepo.findAll());
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
	
	@PostMapping("/product/{id}/edit")
	public String proEditSave(@ModelAttribute @Valid Product product, BindingResult result, Model model,
			@RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		log.info("here");
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			//
			return "product_add";
		} else {
			if (removeImage) {
				// See if the user even has an user image
				ProductImage image = proImageRepo.findByProductId(product.getId());
				if (image != null) {
					// Removes if it exists
					proImageRepo.delete(image);
					log.info("Image Removed" + product.getId());

				}
			}
			// Check to see if there is an upload file
			else if (file != null && !file.isEmpty()) {

				try {
					// Load the file in the proper format(Spring does this!)

					// Load or create a UserImage
					ProductImage image = proImageRepo.findByProductId(product.getId());

					if (image == null) {
						image = new ProductImage();
						image.setProductId(product.getId());

					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					// Store in a Database
					proImageRepo.save(image);
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}
			}
			proRepo.save(product);
			return "redirect:/product/" + product.getId();
		}
	}
	
	@GetMapping ("/product/add")
	public String productAdd(Model model, Product product) {
		model.addAttribute(product);
		return "product_add";
	}
	
	@PostMapping("/product/add")
	public String productAddSave(@ModelAttribute @Valid Product product, Model model ) {

		proRepo.save(product);
		return "redirect:/product/" + product.getId();
	}
	@PostMapping("/product/list")
	public String productDelete( Model model, @RequestParam(name = "productId") int productId) {
		
		proRepo.delete(proRepo.findOne(productId));
		return "redirect:/product/list";
	}
}

