package cn.jsoncc.bean;

import lombok.Data;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/7/6 11:02
 * Email:896415482@qq.com
 */
@Data
public class TreeMenu {
    private String id;
    private String menuname;
    private List<TreeMenu> children;
}
