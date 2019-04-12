package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Orders;
import com.app.pojos.Pricing;
import com.app.service.MenuService;
import com.app.service.OrderService;

@Controller
public class CartController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addToCart(@RequestParam(value = "ids", required = false) String ids, Model map, HttpSession session) {
		System.out.println(ids);

		if (ids != null) {
			List<Pricing> list = (List<Pricing>) session.getAttribute("cart_items");
			Double ammount = (Double) session.getAttribute("total_ammount");
			if (list == null) {
				list = new ArrayList<>();
				ammount = (double) 0;
			}
			String[] i = ids.split(",");
			for (String id : i) {
				System.out.println(id);
				int ID = Integer.parseInt(id);
				System.out.println(ID);
				Pricing itemprice = menuService.fetchItemsPriceById(ID);
				ammount += itemprice.getPrice();
				list.add(itemprice);
			}
			System.out.println(list);
			session.setAttribute("cart_items", list);
			session.setAttribute("total_ammount", ammount);
			session.setAttribute("cart_total", list.size());
		}

		List<String> list = menuService.fetchType();
		map.addAttribute("type", list);
		return "welcome";
	}

	@RequestMapping("showcart")
	public String showCartItems() {
		return "cartItems";
	}

}
