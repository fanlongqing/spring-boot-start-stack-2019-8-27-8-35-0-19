package com.tw.apistackbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 18/08/2017.
 */
@RestController//暴露出办事处所有的功能
@RequestMapping("/hello")//具体模块
public class HelloResource {

    @GetMapping(path = "/{userName}")//获取URL中的参数
    public ResponseEntity<String> getAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }
    @GetMapping(path = "/{userName}/123")//获取URL中的参数
    public ResponseEntity<String> setAll(@PathVariable String userName) {

        return ResponseEntity.ok("Hello:" + userName);
    }
}
