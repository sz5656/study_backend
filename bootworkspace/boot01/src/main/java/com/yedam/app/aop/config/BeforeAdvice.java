package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // AOP의 설정
@Component
public class BeforeAdvice {
	//@Pointcut("execution(* com.yedam..*Impl.*(..))") // 조인포인트 중에서 Advice(횡단관심, 부가기능)이 적용된 메소드
	@Pointcut("within(com.yedam.app.emp.service.impl.*)")
	public void appPontCut() {
		
	}
	
	@Before("appPontCut()") // 동작시점
	public void beforeLog(JoinPoint jp) { // 어드바이스
		String methodName = jp.getSignature().getName();
		System.out.println("[사전처리] beforeLog" + methodName);
	}
}
