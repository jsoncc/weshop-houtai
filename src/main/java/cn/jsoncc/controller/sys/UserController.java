package cn.jsoncc.controller.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.sys.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:04
 * Email:896415482@qq.com
 */
@RequestMapping("/api/sys/user")
@RestController
public class UserController extends BaseController {

    @Autowired
    Userservice userservice;

    /*
    *   验证有个注解没加在save里 @Validate,后面还有 BindingResult bindingresult
     */
    @RequestMapping("/save")
    public String save(@Validated @RequestBody User user, BindingResult bindingResult){
        List val=validate(bindingResult);
        if(null!=val){
            return fail("验证错误",val);
        }
        int rs = userservice.save(user);
        if (rs>0){
            return success("保存成功");
        }
        return fail("保存失败");
    }

    @RequestMapping("/list")
    public String query(@RequestBody Map map){
        PageBean pageBean = userservice.query(map);
        return success("用户表",pageBean);
    }

}
