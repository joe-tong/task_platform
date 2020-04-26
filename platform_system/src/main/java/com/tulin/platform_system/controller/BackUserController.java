package com.tulin.platform_system.controller;

import com.sun.org.apache.xalan.internal.xsltc.trax.DOM2TO;
import com.tulin.api.user.UserService;
import com.tulin.common.base.controller.BaseController;
import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_model.dto.UserLoginDTO;
import com.tulin.platform_model.vo.request.UserLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "后台用户模块")
@RequestMapping("/user/back")
@RestController
public class BackUserController extends BaseController {

    @Resource
    private UserService userService;

    @ApiOperation("后台用户登录")
    @PostMapping("/login")
    public ServerResponse<UserLoginDTO> login(@RequestBody @Valid UserLoginRequest request){


       return userService.login(request);
    }
}
