package com.vaadin.tutorial.crm.backend.library.generator.email;//package com.vaadin.tutorial.crm.backend.library.generator.email;
//
//import lombok.extern.log4j.Log4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//@Component
//@Log4j
//public class EmailGenerator {
//
//    private static final String FILENAME_PATTERN = "%s.pdf";
//    private final JavaMailSender emailSender;
//    private final SpringTemplateEngine templateEngine;
//
//    @Autowired
//    public EmailGenerator(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
//        this.emailSender = emailSender;
//        this.templateEngine = templateEngine;
//    }
//
//    public void sendSimpleEmail(String to, String subject, String message) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(to);
//
//        msg.setSubject(subject);
//        msg.setText(message);
//
//        emailSender.send(msg);
//    }
//
//    public void sendMessage(String subject, String template, Map<String, Object> variables, String... to) {
//        try {
//            MimeMessage message = emailSender.createMimeMessage();
//            message.setSubject(subject, "UTF-8");
//
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setTo(to);
//            helper.setText(this.buildTemplateToString(template, variables), true);
//
//            emailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            log.error("Hibás email küldés");
//        }
//
//    }
//
//    public void sendMessageWithAttachment(String subject,
//                                          String template,
//                                          Map<String, Object> variables,
//                                          List<Map<String, String>> emailInfo,
//                                          String... to) {
//        try {
//            MimeMessage message = emailSender.createMimeMessage();
//            message.setSubject(subject, "UTF-8");
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//            for (Map<String, String> infoData : emailInfo) {
//                FileSystemResource file = new FileSystemResource(new File(infoData.get("filePath")));
//                String attachmentFileName = String.format(FILENAME_PATTERN, infoData.get("productNumber"));
//                helper.addAttachment(attachmentFileName, file);
//            }
//
//            helper.setTo(to);
//            helper.setText(this.buildTemplateToString(template, variables), true);
//
//            emailSender.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            log.error("Hibás email küldés");
//        }
//    }
//
//    public void sendMessageToOneAddress(String to, String subject, String template, Map<String, Object> variables) {
//        this.sendMessage(subject, template, variables, to);
//    }
//
//    public void sendMessageWithAttachmentToOneAddress(String to,
//                                                      String subject,
//                                                      String template,
//                                                      Map<String, Object> variables,
//                                                      List<Map<String, String>> emailInfo) {
//        this.sendMessageWithAttachment(subject, template, variables, emailInfo, to);
//    }
//
//
//    public String buildTemplateToString(String template, Map<String, Object> variables) {
//        System.out.println("Locale context language: "+ LocaleContextHolder.getLocale());
//        Context context = new Context(LocaleContextHolder.getLocale(), variables);
//        System.out.println("Email context language: "+context.getLocale());
//        return this.templateEngine.process(template, context);
//    }
//
//}
