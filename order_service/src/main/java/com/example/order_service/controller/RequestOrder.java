package com.example.order_service.controller;

import lombok.Data;

@Data
public class RequestOrder {

	private String productId;
	private Integer qty;
	private Integer unitPrice;
}
