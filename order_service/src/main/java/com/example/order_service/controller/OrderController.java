package com.example.order_service.controller;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.service.OrderService;
import com.example.order_service.vo.ResponseOrder;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("{userId}/orders")
	public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId,
		@RequestBody RequestOrder order) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		orderDto.setUserId(userId);
		OrderDto createdOrder = orderService.createOrder(orderDto);
		ResponseOrder responseOrder = modelMapper.map(createdOrder, ResponseOrder.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
	}

	@GetMapping("{userId}/orders")
	public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
		Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ResponseOrder> result = new ArrayList<>();
		orderList.forEach(v -> {
			result.add(modelMapper.map(v, ResponseOrder.class));
		});
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
