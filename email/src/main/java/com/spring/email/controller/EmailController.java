package com.spring.email.controller;

import com.spring.email.service.IMailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private IMailServiceImpl mailService;//注入发送邮件的各种实现方法
    @Autowired
    private TemplateEngine templateEngine;//注入模板引擎

    @RequestMapping
    public void index(){
        try {
            mailService.sendSimpleMail("xxx@qq.com","SpringBoot Email","这是一封普通的SpringBoot测试邮件");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping("/htmlEmail")
    public void htmlEmail(){
        try {
            mailService.sendHtmlMail("xxx@126.com","IJPay让支付触手可及","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + "	<div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"		<h3>欢迎使用IJPay -By Javen</h3>\n"
                    +"		<span>https://github.com/Javen205/IJPay</span>"
                    + "		<div\n"
                    + "			style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "		<div\n" + "			style=\"text-align: center; padding: 4px\">如果对你有帮助,请任意打赏</div>\n"
                    + "		<img width=\"180px\" height=\"180px\"\n"
                    + "			src=\"https://javen205.gitbooks.io/ijpay/content/assets/wxpay.png\">\n"
                    + "	</div>\n" + "</body>");
        }catch (Exception ex){
            ex.printStackTrace();

        }
    }

    @RequestMapping("/attachmentsMail")
    public void attachmentsMail(){
        try {
            String filePath = "/Users/Javen/Desktop/IJPay.png";
            mailService.sendAttachmentsMail("xxx@126.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", filePath);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping("/resourceMail")
    public void resourceMail(){
        try {
            String rscId = "IJPay";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "/Users/Javen/Desktop/IJPay.png";
            mailService.sendResourceMail("xxx@126.com", "这邮件中含有图片", content, imgPath, rscId);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @RequestMapping("/templateMail")
    public void templateMail(){
        try {
            Context context = new Context();
            context.setVariable("project", "IJPay");
            context.setVariable("author", "Javen");
            context.setVariable("url", "https://github.com/Javen205/IJPay");
            String emailContent = templateEngine.process("emailTemp", context);

            mailService.sendHtmlMail("xxx@126.com", "这是模板邮件", emailContent);
        }catch (Exception ex){
            ex.printStackTrace();

        }
    }
}
