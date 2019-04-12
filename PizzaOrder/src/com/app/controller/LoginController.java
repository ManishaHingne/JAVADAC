package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Customer;
import com.app.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping("/signin")
	public String showLoginPage() {

		return "LoginPage";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String processLoginPage(Customer c, Model map, HttpSession session) {
		Customer cust = null;

		if (c.getEmail().equals("") || c.getPassword().equals("")) {
			map.addAttribute("msg", "Email or password must not be empty");
			return "LoginPage";
		}

		try {
			cust = service.fetchCustomerByEmailPass(c.getEmail(), c.getPassword());
			map.addAttribute("msg", "Successful Login");
			if (cust == null) {
				map.addAttribute("msg", "Invalid Email or Password , pls retry");
				return "LoginPage";
			}

		} catch (javax.persistence.NoResultException e) {
			System.out.println("invalid login");
			map.addAttribute("msg", "Invalid Login , pls retry");
			return "LoginPage";
		} catch (Exception e) {
			map.addAttribute("msg", "Server internal error " + e.getMessage());
			return "LoginPage";
		}
		// admin page redirection
		if (cust.getName().equals("admin")) {
			map.addAttribute("admin", cust);
			session.setAttribute("admin", cust);
			return "AdminPage";
		}

		session.setAttribute("customer", cust);
		return "redirect:/types";
	}

	@RequestMapping("/registerpro")
	public String showRegistrationForm(Customer c) {
		return "RegistrationForm";
	}

	@RequestMapping(value = "/registerpro", method = RequestMethod.POST)
	public String procesUserRegistrationForm(Customer c, BindingResult res, Model map) {
		String msg = null;
		if (res.hasFieldErrors()) {
			map.addAttribute("msg", "Invalid entries please enter proper details");
			return "RegistrationForm";
		}
		msg = service.insertNewCustomer(c);

		if (msg.contains("failed")) {
			map.addAttribute("msg", msg);
			return "RegistrationForm";
		}
		map.addAttribute("msg", msg);

		return "redirect:/signin";
	}

	@RequestMapping("/logout")
	public String logOutSession(HttpSession session, Model map) {
		session.invalidate();
		map.addAttribute("msg", "Logged out successfully");
		return "redirect:types";
	}

}