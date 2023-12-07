package com.example.blacklist.controller;

import com.example.blacklist.service.BlackEntityService;
import com.example.blacklist.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/29 21:26
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/blacklist")
@Slf4j
public class BlackEntityController {

    @Autowired
    private BlackEntityService blackEntityService;

    /**
     * 查询黑名单
     * @param username
     * @return
     */
    @GetMapping("select")
    public Result<List<String>> select(@RequestParam(required = false) String username){
        log.info("查询黑名单：" + username);
        List<String> list = blackEntityService.getList(username);
        if(list.isEmpty()){
            if(username == null){
                return Result.success("445", null, "黑名单中暂时没有用户");
            }else{
                return Result.success("446", null, "黑名单中搜索不到符合该关键词的用户");
            }
        }else{
            return Result.success("241", list, "查询成功");
        }
    }
}
