package cn.jsoncc.controller.common;

import cn.jsoncc.bean.User;
import cn.jsoncc.service.sys.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/7/1 20:14
 * Email:896415482@qq.com
 */
@RestController
@RequestMapping("/api/common")
public class LoginController extends BaseController{

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestBody Map map){
        //先判断验证码是否正确

        //判断用户是否存在
        User user = loginService.login(map);
        if (null == user){
            return fail("该账号不存在");
        }
        //判断密码是否正确
        Object pwd= map.get("password");
        if (null == pwd){
            return fail("密码不能为空");
        }
        String tmp = DigestUtils.md5DigestAsHex(pwd.toString().getBytes());//对密码进行加密
        if (!tmp.equals(user.getPassword())){
            return fail("密码不正确");
        }
        if (user.getStatus()==0){
            return fail("该账号被禁用");
        }
        user.setPassword(null);//返回空，防止反向验证密码
        return success("登录成功",user);
    }

    @RequestMapping("/logout")
    public String logout(){

        return null;
    }
}
