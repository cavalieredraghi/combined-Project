package org.elevenfifty.java301.controller;

import javax.validation.Valid;

import org.elevenfifty.java301.beans.Order;
import org.elevenfifty.java301.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;

	@GetMapping("/order/list")
	public String orderList(Model model) {
		model.addAttribute("orders", orderRepo.findAll());
		return "order_list";
	}

	@GetMapping("/order/add")
	public String orderAdd(Model model, Order order) {
		Order u = new Order();
		model.addAttribute(order);
		return "order_add";
	}

	@PostMapping("/order/add")
	public String orderAddSave(@ModelAttribute @Valid Order order, Model model) {

		orderRepo.save(order);
		return "redirect:/order/list";
	}
	

}
