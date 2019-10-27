package com.hp.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String username;
	private String password;
	private Date createdate;
	private String address;
	
}

