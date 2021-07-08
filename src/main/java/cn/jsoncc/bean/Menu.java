package cn.jsoncc.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: JsonCC
 * Date: 2021/7/5 15:24
 * Email:896415482@qq.com
 */
@Data
public class Menu {
    private String id;

    @NotBlank(message = "菜单名称不能为空")
    private String menuname;

    private String icon;
    private int menutype;
    private int sorts;
    private String routepath;
    private String authorization;

    private String parentId;
}
