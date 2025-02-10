package com.vinsys.advice.service;

public class BankService {

	public float calSI(float p, float r, float t) {
		System.out.println("BankService.calSI()");
		return p * t * r / 100.0f;
	}
}
