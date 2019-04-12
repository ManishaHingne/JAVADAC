package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Items;
import com.app.service.MenuService;

@Controller
public class MenuController {

	/*
	 * @Autowired MenuService menuservice;
	 * 
	 * @RequestMapping("/list") public String listCusts(Model map) {
	 * map.addAttribute("typelist", menuservice.fetchType()); return "MenuView";
	 * }
	 */

	@Autowired
	MenuService menuservice;

	@RequestMapping("/types")
	public String getMenus(Model map, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "category", required = false) String category) {

		List<String> list = menuservice.fetchType();
		map.addAttribute("type", list);
		if (type != null)
			map.addAttribute("subtype", menuservice.fetchCategoryByType(type));
		if (type != null && category != null)
			map.addAttribute("category", menuservice.fetchCategoryByTypeCateg(type, category));
		return "welcome";

	}

	@RequestMapping("/item")
	public String showitem(Integer id, Model map, HttpSession session) {

		Items item = menuservice.findItemById(id);
		System.out.println(item);
		map.addAttribute("item", item);
		session.setAttribute("all", item);
		return "item";
	}

}
