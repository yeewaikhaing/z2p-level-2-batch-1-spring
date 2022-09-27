package com.mmit.controller;

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
import com.mmit.model.service.OrderService;
import com.mmit.model.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/cart/detail")
	public String home() {
		
		return "cart";
	}
	
	@GetMapping("/cart/checkout")
	public String checkoutPage(ModelMap map) {
		
		map.put("name", "Aung Aung");
		map.put("phone", "0912345678");
		map.put("email", "aungaung@gmail.com");
		map.put("address", "Yangon");
		
		return "checkout";
	}
	
	@PostMapping("/cart/place-order")
	public @ResponseBody String makeOrder(@RequestBody OrderRequestData obj) {
		
		try {
			OrderReceiverData receiver = obj.getReceiver();
			List<OrderProductData> itemList = obj.getOrderItems();
			
			// new order
			Orders new_order = new Orders();
			
			new_order.setStatus(OrderStatus.pending);
			new_order.setShippingAddress(receiver.getAddress());
			new_order.setShippingEmail(receiver.getEmail());
			new_order.setShippingName(receiver.getName());
			new_order.setShippingPhone(receiver.getPhone());
			new_order.setCustomer(null);
			
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
			return "";
		}
		
	}
}
