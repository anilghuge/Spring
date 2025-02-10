package com.vinsys.advice.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vinsys.advice.service.BankService;

public class SpringAOP_AroundAdvice_Test {

	public static void main(String[] args) {
		// create ioc container

		ApplicationContext context = null;

		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BankService bankService = context.getBean("proxyFactoryBean", BankService.class);

		float calSI = bankService.calSI(1200, 12, 2);
		System.out.println(bankService.getClass());
		System.out.println("Interest Amount :" + calSI);
		((AbstractApplicationContext) context).close();
	}
}
