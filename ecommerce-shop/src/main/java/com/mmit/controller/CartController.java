package com.mmit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmit.controller.request.OrderProductData;
import com.mmit.controller.request.OrderReceiverData;
import com.mmit.controller.request.OrderRequestData;
import com.mmit.model.entity.OrderItem;
import com.mmit.model.entity.OrderStatus;
import com.mmit.model.entity.Orders;
import com.mmit.model.entity.User;
import com.mmit.model.service.OrderService;
import com.mmit.model.service.ProductService;
import com.mmit.model.service.UserService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userUservice;
	
	@GetMapping("/cart/detail")
	public String home() {
		
		return "cart";
	}
	
	@GetMapping("/cart/checkout")
	public String checkoutPage(ModelMap map, Principal principal) {
		
		User loginUser = userUservice.profile(principal.getName()); //getname -> email
		map.put("name", loginUser.getName());
		map.put("phone", loginUser.getPhone());
		map.put("email", loginUser.getEmail());
		map.put("address", loginUser.getAddress());
		
		return "checkout";
	}
	
	@PostMapping("/cart/place-order")
	public @ResponseBody String makeOrder(@RequestBody OrderRequestData obj) {
		
		try {
			System.out.println("ok 1....");
			OrderReceiverData receiver = obj.getReceiver();
			List<OrderProductData> itemList = obj.getOrderItems();
			
			// new order
			Orders new_order = new Orders();
			
			new_order.setStatus(OrderStatus.pending);
			new_order.setShippingAddress(receiver.getAddress());
			new_order.setShippingEmail(receiver.getEmail());
			new_order.setShippingName(receiver.getName());
			new_order.setShippingPhone(receiver.getPhone());
			//User customer = userUservice.profile(principal.getName());
			//new_order.setCustomer(customer);
			
			//add order items
			for(var item: itemList) {
				var product = productService.findById(item.getProductId());
				
				var order_item = new OrderItem();
				order_item.setProduct(product);
				order_item.setQuantity(item.getQty());
				
				new_order.addOrderItem(order_item);
			}
			
			// save order to db
			Orders savedOrder = orderService.save(new_order);
			return savedOrder.getId() + "";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
}
