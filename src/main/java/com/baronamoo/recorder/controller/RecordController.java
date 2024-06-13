package com.baronamoo.recorder.controller;

import com.baronamoo.recorder.service.RecordListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class RecordController {

    private final RecordListService recordListService;

    //    @PostMapping("/login") //localhost:8080/api/login
//    public String login(String username, String password){
//        if(!databaseInfo.checkId(username)){
//            throw new IllegalArgumentException("잘못된 id 입니다");
//        } else if (!databaseInfo.checkPwd(password)) {
//            throw new IllegalArgumentException("잘못된 password 입니다");
//        }else {
//            return "home";
//        }
//    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}

