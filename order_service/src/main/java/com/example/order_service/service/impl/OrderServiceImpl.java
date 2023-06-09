package com.example.order_service.service.impl;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		orderDto.setOrderId(UUID.randomUUID().toString());
		orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrderEntity orderEntity = modelMapper.map(orderDto, OrderEntity.class);
		orderRepository.save(orderEntity);
		return modelMapper.map(orderEntity, OrderDto.class);
	}

	@Override
	public OrderDto getOrderByOrderId(String orderId) {
		OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
		return new ModelMapper().map(orderEntity, OrderDto.class);
	}

	@Override
	public Iterable<OrderEntity> getOrdersByUserId(String userId) {
		return orderRepository.findByUserId(userId);
	}
}
