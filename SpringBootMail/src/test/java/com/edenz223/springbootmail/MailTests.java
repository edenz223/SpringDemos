package com.edenz223.springbootmail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class MailTests {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    MailSender ms;

    @Autowired
    JavaMailSender jms;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void sendTextMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("999999@qq.com");                 // 接收地址
        message.setSubject("一封纯文本的邮件");            // 标题
        message.setText("使用Spring Boot发送纯文本邮件。"); // 内容
        ms.send(message);
        System.out.println("发送成功");
    }

    @Test
    void sendMimeEmail() throws MessagingException {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true); //使用true表示使用附件
        helper.setFrom(from);
        helper.setTo("999999@qq.com");                          // 接收地址
        helper.setSubject("一封带有MIME类型数据的邮件");            // 标题
        helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true); // 内容，使用true表示文本包含HTML
        FileSystemResource res = new FileSystemResource(new File("Sample.jpg"));
        helper.addInline("identifier1234", res);

        FileSystemResource file = new FileSystemResource(new File("Attachment.txt"));
        helper.addAttachment("Attachment.txt", file);
        jms.send(message);
        System.out.println("发送成功");
    }

    @Test
    public void sendTemplateEmail() throws MessagingException {
        MimeMessage message = jms.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo("999999@qq.com");                 // 接收地址
        helper.setSubject("一封模板邮件");            // 标题
        Context context = new Context();
        FileSystemResource file = new FileSystemResource(new File("Attachment.txt"));
        context.setVariable("fileName", file.getFilename());
        String template = templateEngine.process("emailTemplate", context);
        helper.setText(template, true);

        helper.addAttachment("Attachment.txt", file);
        jms.send(message);
        System.out.println("发送成功");
    }



}
