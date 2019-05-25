 package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exeption.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;



@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	//to get all orders
	@RequestMapping(value="/orders",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		return list;
	}
	
	//to create orders
	@PostMapping("/addorders")
	public Order createOrder( @RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	//get single order
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "orderid") Long orderId) throws ResourceNotFoundException {
		Order order= orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order Not found on"+orderId));
		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	}
	
	 @PutMapping("/orders/{orderid}")
	    public ResponseEntity<Order> updateUser(
	    @PathVariable(value = "orderid") Long orderId,
	    @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
	         Order order = orderRepository.findById(orderId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ orderId));
	  
	        order.setTotalPrice(orderDetails.getTotalPrice());
	        order.setUpdateAt(new Date());
	        final Order updatedOrder = orderRepository.save(order);
	        return ResponseEntity.ok(updatedOrder);
	   }
	 

		
		@DeleteMapping("/delete/{orderid}")
		public Map<String, Boolean> deleteOrder(@PathVariable(value="orderid") Long orderid)throws Exception{
			
			Order order = orderRepository.findById(orderid).orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ orderid));
			
			
			orderRepository.delete(order);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", true);
			return response;
			
		}
	 
	 
	

}
