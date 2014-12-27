package ua.ll7.slot7.ma.validator.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.ll7.slot7.ma.data.Constants;
import ua.ll7.slot7.ma.data.generic.StringStringDG;
import ua.ll7.slot7.ma.exception.AppValidationException;

/**
 * MA
 * Velichko A.
 * 27.12.14 16:59
 */
@Component
@Aspect
public class StringStringDGBothNotEmptyVA {

  private static final Logger LOGGER = Logger.getLogger(StringStringDGBothNotEmptyVA.class);

  @Pointcut("execution(@ua.ll7.slot7.ma.validator.annotations.StringStringDGBothNotEmpty * *(..))")
  private void methodPointcut() {

  }

  @Before("methodPointcut()")
  public void methodExecution(JoinPoint joinPoint) throws Throwable {
    Object[] arguments = joinPoint.getArgs();
    for (Object argument : arguments) {

      System.out.println(argument);

      if (
                           (StringUtils.isBlank(((StringStringDG) argument).getData1()))
                                                ||
                                                (StringUtils.isBlank(((StringStringDG) argument).getData2()))

                           ) {
        throw new AppValidationException(Constants.messageNotValidRequest
                                                              + Constants.divider
                                                              + argument);
      }
    }
  }

}
