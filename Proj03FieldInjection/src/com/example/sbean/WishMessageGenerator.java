package com.example.sbean;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime localDateTime;

	/*
	public WishMessageGenerator(LocalDateTime localDateTime) {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
		this.localDateTime=localDateTime;
	}*/

	/*@Autowired
	public void setLocalDateTime(LocalDateTime localDateTime) {
		System.out.println("WishMessageGenerator.setLocalDateTime()");
		this.localDateTime = localDateTime;
	}*/

	public String getGeneratorMessage(String user) {
		System.out.println("WishMessageGenerator.getGeneratorMessage()");
		int hour = localDateTime.getHour();

		if (hour < 12)
			return "Good Morning :" + user;
		else if (hour < 16)
			return "Good AfterNoon :" + user;
		else if (hour < 20)
			return "Good Evening :" + user;
		else
			return "Good Night :" + user;
	}
}
