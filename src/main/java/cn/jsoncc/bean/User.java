package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:03
 * Email:896415482@qq.com
 */
@Data
public class User {
    private String id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^\\w{6,}$",message = "密码至少是6位")
    private String password;

    private String name;
    private int gender;
    private String mobile;
    private String email;
    private int usertype;
    private String bid;
    private int status;
    private int isdel;
    private String adddate;
}
