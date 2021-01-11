package com.lx.demo.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lx.demo.constant.DemoClassConstant;
import com.lx.demo.dao.UserDao;
import com.lx.demo.model.User;
import com.lx.demo.portocol.LoginProcessRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.MidiDevice;
import javax.sound.sampled.DataLine;
import java.util.List;


/**
 * 登录信息数据处理
 */
@RestController
public class LoginController {

    private static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping("/wexinlogin/login")
    public LoginProcessRes login (@RequestBody String  loginParams){
        LoginProcessRes loginProcessRes=new LoginProcessRes();
        //对于录入的json格式字段进行转换，注意（这里未定义其他的接收类型，只是单一的类对象，不必在发送的json外层包对象，否者解析不到）
        User user = JSON.parseObject(loginParams,User.class);
        logger.info("对于登录信息进行打印校验");
        logger.info(user.getUserName());
        logger.info(user.getPassword());
        //对于输入的密码做校验，特殊字符，类型和长度 - 防止sql注入
        List<User> list = userDao.findByUsernameAndPassword(user.getUserName(),user.getPassword());
        if(null != list && null != list.get(0)){
            loginProcessRes.setResProcessStatus(DemoClassConstant.SUCCCESS);
            loginProcessRes.setResCode(DemoClassConstant.SUCCCESS_CODE);
            loginProcessRes.setResStatus(DemoClassConstant.RETURN_MSG01);
            loginProcessRes.setValue("1");
        }else{
            logger.error("输入的用户名或密码不匹配！");
            loginProcessRes.setResProcessStatus(DemoClassConstant.SUCCCESS);
            loginProcessRes.setResCode(DemoClassConstant.FAILED_CODE);
            loginProcessRes.setResStatus(DemoClassConstant.RETURN_MSG02);
        }

        //针对于登录之后返回的状态码为false--登录失败，true ---登录成功
        return loginProcessRes;
    }
}
