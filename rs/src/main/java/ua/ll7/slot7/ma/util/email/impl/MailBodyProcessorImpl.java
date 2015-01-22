package ua.ll7.slot7.ma.util.email.impl;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import ua.ll7.slot7.ma.util.email.IMailBodyProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * MA
 * Velichko A.
 * 22.01.15 12:58
 */
@Component
public class MailBodyProcessorImpl implements IMailBodyProcessor {

  private VelocityEngine velocityEngine;

  @Value("${emails.welcome}")
  private String templateWelcome;

  @Value("${template.encoding}")
  private String emailEncoding;

  @Override
  public String userWelcomeAboard(String nick, String email) {
    String mailBody;

    Map<String, Object> model = new HashMap<>();

    model.put("nick", nick);
    model.put("email", email);

    mailBody = VelocityEngineUtils.mergeTemplateIntoString(
           velocityEngine, templateWelcome, emailEncoding, model);

    return mailBody;
  }

  public void setVelocityEngine(VelocityEngine velocityEngine) {
    this.velocityEngine = velocityEngine;
  }
}
