package com.example.order_service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {

	private String productId;
	private Integer qty;
	private Integer unitPrice;
	private Integer totalPrice;
	private String orderId;
	private Date createdAt;
}
