package com.example.demo.controller;

import com.example.demo.entity.BlackEntity;
import com.example.demo.entity.BlackUserDto;
import com.example.demo.service.InsertBlackListService;
import com.example.demo.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BlackListController {
    @Resource
    private InsertBlackListService insertBlackListService;
    private BlackEntity blackEntity;
    @PostMapping("/blacklist/insert")
    @ResponseBody
    public Result insertBlackList(@RequestBody BlackUserDto blackUser){
        String username=blackUser.getUsername();
        String reason=blackUser.getReason();
        System.out.println("收到插入请求，即将开始检查是否符合插入要求");
        return insertBlackListService.insertBlackList(username,reason);
    }
}
