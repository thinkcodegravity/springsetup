package aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileAspect  {
	
	@Around("within(service.LoginBusiness)")
	public boolean getResponseTime(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("entering aspect");
		long startTime=System.currentTimeMillis();
		
		boolean res=(boolean)joinPoint.proceed();
		
		long stopTime=System.currentTimeMillis();
		long totalTime=stopTime-startTime;
		System.out.println( " total time taken :"+totalTime+ " milli seconds");
		System.out.println("exiting aspect");
		return res;
	}
	

	@AfterThrowing("within(service.LoginBusiness)")
	public void commonErrorMessage() throws Throwable{
		System.out.println( "we are experiencing technical difficultie. please try again later");
	}
	
	/*
	@Around("within(com.spring.beans.CartBean)")
	public String getResponseTime(ProceedingJoinPoint  joinPoint) throws Throwable{
		System.out.println(" aspect code before");
		String s=(String)joinPoint.proceed();
		System.out.println("aspect code after");
		return s;
	}
	*/	
}
