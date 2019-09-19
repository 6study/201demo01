package com.lx.demo.controller;
import com.lx.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/demo/login")
    public  Boolean login (@RequestBody User loginParams){
//         JSONObject  user= JSONObject.parseObject(loginParams);
        logger.info("对于登录信息进行打印校验");
        logger.info(loginParams.getUserName());
        logger.info(loginParams.getPassword());



        //针对于登录之后返回的状态码为false--登录失败，true ---登录成功
        return Boolean.FALSE;
    }
}
