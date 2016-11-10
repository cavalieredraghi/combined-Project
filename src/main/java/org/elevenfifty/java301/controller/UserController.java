package org.elevenfifty.java301.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.beans.UserImage;
import org.elevenfifty.java301.repository.UserImageRepository;
import org.elevenfifty.java301.repository.UserRepository;
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
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserImageRepository userImageRepo;

	@GetMapping("")
	// @RequestMapping (path="",method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/user/list")
	public String userList(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "user_list";
	}

	@GetMapping("/user/{id}")
	public String user(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);

		model.addAttribute("user", u);

		UserImage i = userImageRepo.findByUserId(id);
		model.addAttribute("userImage", i);

		return "user_detail";
	}

	@GetMapping("/user/{id}/edit")
	public String userEdit(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("id", id);
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_edit";
	}

	@PostMapping("/user/{userId}/edit")
	public String userEditSave(@ModelAttribute @Valid User user, BindingResult result, Model model,
			@RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

		log.info("here");
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			//
			return "user_edit";
		} else {
			if (removeImage) {
				// See if the user even has an user image
				UserImage image = userImageRepo.findByUserId(user.getId());
				if (image != null) {
					// Removes if it exists
					userImageRepo.delete(image);
					log.info("Image Removed" + user.getId());

				}
			}
			// Check to see if there is an upload file
			else if (file != null && !file.isEmpty()) {

				try {
					// Load the file in the proper format(Spring does this!)

					// Load or create a UserImage
					UserImage image = userImageRepo.findByUserId(user.getId());

					if (image == null) {
						image = new UserImage();
						image.setUserId(user.getId());

					}
					image.setContentType(file.getContentType());
					image.setImage(file.getBytes());

					// Store in a Database
					userImageRepo.save(image);
				} catch (IOException e) {
					log.error("Failed to upload file", e);
				}
			}
			userRepo.save(user);
			return "redirect:/user/" + user.getId();
		}
	}

	@GetMapping ("/user/add")
	public String userAdd(Model model, User user) {
		User u = new User();
		model.addAttribute(user);
		return "user_add";
	}
	
	@PostMapping("/user/add")
	public String userAddSave(@ModelAttribute @Valid User user, Model model ) {

		userRepo.save(user);
		return "redirect:/user/" + user.getId();
	}
	@GetMapping ("/user/new")
	public String userNew(Model model, User user) {
		User u = new User();
		model.addAttribute(user);
		return "user_new";
	}
	
	@PostMapping("/user/new")
	public String userNewSave(@ModelAttribute @Valid User user, Model model ) {

		userRepo.save(user);
		return "redirect:/login";
	}
}
