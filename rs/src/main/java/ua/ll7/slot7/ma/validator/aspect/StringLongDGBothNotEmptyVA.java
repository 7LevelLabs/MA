package ua.ll7.slot7.ma.validator.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.StringLongDG;
import ua.ll7.slot7.ma.exception.AppValidationException;

/**
 * @author Alex Velichko
 *         28.12.14 : 15:14
 */
@Component
@Aspect
public class StringLongDGBothNotEmptyVA {

	private static final Logger LOGGER = Logger.getLogger(StringLongDGBothNotEmptyVA.class);

	@Pointcut("execution(@ua.ll7.slot7.ma.validator.annotations.StringLongDGBothNotEmpty * *(..))")
	private void methodPointcut() {

	}

	@Before("methodPointcut()")
	public void methodExecution(JoinPoint joinPoint) throws Throwable {
		Object[] arguments = joinPoint.getArgs();
		for (Object argument : arguments) {
			if (
													 (StringUtils.isBlank(((StringLongDG) argument).getData1()))
																								||
																								(((StringLongDG) argument).getData0() < 1)
													 ) {
				throw new AppValidationException(Constants.messageNotValidRequest
														 + Constants.divider
														 + argument);
			}
		}
	}

}
