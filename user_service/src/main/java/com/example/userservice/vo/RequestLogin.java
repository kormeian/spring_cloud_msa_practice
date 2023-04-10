package com.example.userservice.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {

	@NotNull(message = "Email cannot be null")
	@Size(min = 2, message = "Email must not be less than two characters")
	@Email
	private String email;
	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less than 16 characters")
	private String password;
}
