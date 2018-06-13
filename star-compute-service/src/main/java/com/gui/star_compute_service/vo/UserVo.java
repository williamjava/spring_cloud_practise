package com.gui.star_compute_service.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	private String job;

	public UserVo() {

	}

	public UserVo(String name, Integer age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}
}
