package cn.jsoncc.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/6/16 20:35
 * Email:896415482@qq.com
 */
@Data
@NoArgsConstructor

public class PageBean {
    private int page; //当前第几页数据

    private int pageSize; //每页记录数

    private int total; //总记录数

    private List data;  //分页结果集

    private int code;

    private String msg;

    public PageBean(int page, int pageSize, int total, List data) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }



}
