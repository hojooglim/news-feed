package com.sparta.newsfeed.Common.email;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @ResponseBody
    @PostMapping("/newsfeed/user/mail")
    String mailConfirm(@RequestParam("email") String email) throws Exception {
        String code = mailService.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        return code;
    }

    //인증번호 비교
    @PostMapping("/newsfeed/user/mailcompare")
    String mailCodeCompare(@RequestBody MailDto mailDto){
        return  mailService.compareCode(mailDto);
    }
}