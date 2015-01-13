package ua.ll7.slot7.ma.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * MA
 * Velichko A.
 * 13.01.15 13:01
 */
@Aspect
public class LogAroundAspect {

  private static final Logger LOGGER = Logger.getLogger(LogAroundAspect.class);

  @Around("@annotation(ua.ll7.slot7.ma.util.LogAround) || @within(ua.ll7.slot7.ma.util.LogAround)")
  public Object log(ProceedingJoinPoint pjp) throws Throwable {
    final Class methodClass = pjp.getSourceLocation().getWithinType();
    Object[] methodArgs = pjp.getArgs();
    String methodName = pjp.getSignature().getName();

    LOGGER.debug(String.format("Invoked: %s::%s with arguments: %s", methodClass.getName(), methodName, Arrays.toString(methodArgs)));

    final Object result = pjp.proceed(methodArgs);

    LOGGER.debug(String.format("Returning from: %s::%s result: '%s'", methodClass.getName(), methodName, result.toString()));
    return result;
  }
}
