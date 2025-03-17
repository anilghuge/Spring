package com.example.client;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.sbean.WishMessageGenerator;

public class FieldInjection {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext("src/com/example/cfg/applicationContext.xml");
		Object bean = context.getBean("wmg");
		WishMessageGenerator obj=(WishMessageGenerator)bean;
		String generatorMessage = obj.getGeneratorMessage("Anil");
		System.out.println("Result :"+generatorMessage);
		
		Object bean1 = context.getBean("wmg");
		System.out.println(bean.hashCode()+" "+bean1.hashCode());
		System.out.println("obj==obj1 "+(bean==bean1));
		context.close();
	}
}
