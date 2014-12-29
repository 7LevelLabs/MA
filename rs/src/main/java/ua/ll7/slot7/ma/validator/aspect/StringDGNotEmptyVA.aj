package ua.ll7.slot7.ma.validator.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.StringDG;
import ua.ll7.slot7.ma.exception.AppValidationException;

/**
 *
 * @author Alex Velichko
 * 29.12.14 : 23:53
 */
@Component
@Aspect
public aspect StringDGNotEmptyVA {

	private static final Logger LOGGER = Logger.getLogger(StringDGNotEmptyVA.class);

	@Pointcut("execution(@ua.ll7.slot7.ma.validator.annotations.StringDGNotEmpty * *(..))")
	private void methodPointcut() {

	}

	@Before("methodPointcut()")
	public void methodExecution(JoinPoint joinPoint) throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		for (Object argument : arguments) {
			if (
													 StringUtils.isBlank(((StringDG) argument).getData1())
													 ) {
				throw new AppValidationException(Constants.messageNotValidRequest
														 + Constants.divider
														 + argument);
			}
		}
	}

}
