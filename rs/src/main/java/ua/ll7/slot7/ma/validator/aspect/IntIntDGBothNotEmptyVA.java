package ua.ll7.slot7.ma.validator.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.IntIntDG;
import ua.ll7.slot7.ma.exception.AppValidationException;

/**
 * @author Alex Velichko
 *         05.01.15 : 15:18
 */
@Component
@Aspect
public class IntIntDGBothNotEmptyVA {

	@Pointcut("execution(@ua.ll7.slot7.ma.validator.annotations.IntIntDGBothNotEmpty * *(..))")
	private void methodPointcut() {

	}

	@Before("methodPointcut()")
	public void methodExecution(JoinPoint joinPoint) throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		for (Object argument : arguments) {
			if (
													 (((IntIntDG) argument).getData1() < 1)
																								||
																								(((IntIntDG) argument).getData2() < 1)
													 ) {
				throw new AppValidationException(Constants.messageNotValidRequest
														 + Constants.divider
														 + argument);
			}
		}
	}
}
