package com.example.hanyan.hanee.controller;

import com.example.hanyan.common.Result;
import com.example.hanyan.hanee.dto.request.UserInfoAddVO;
import com.example.hanyan.service.UserService;
import com.example.hanyan.util.ResultUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试鉴权登录
 * @author vigo.xian
 */
@RestController
public class HelloController {

    @Resource
    private UserService userService;

    @GetMapping("/detail")
    public Result<String> detail() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return ResultUtil.success(userDetails);
    }

    @GetMapping("/hello")
    public String hello() {
        return "admin";
    }


    @PostMapping("/add")
    public Result<String> add(UserInfoAddVO userInfoAddVO) {
        userService.saveUserRole(userInfoAddVO);
        return ResultUtil.success("创建成功");
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }

    @GetMapping("/visit/hello")
    public String visit() {
        return "visit";
    }
}
