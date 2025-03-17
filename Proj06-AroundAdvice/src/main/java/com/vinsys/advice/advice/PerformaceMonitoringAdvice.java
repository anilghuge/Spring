package com.vinsys.advice.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformaceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformaceMonitoringAdvice.invoke()");

		long startTime = System.currentTimeMillis();

		Object invocationValue = invocation.proceed();

		long endTime = System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName());
		System.out.println("the target method/business method has taken " + (endTime - startTime)
				+ "ms to complete the execution");
		return invocationValue;
	}

}
