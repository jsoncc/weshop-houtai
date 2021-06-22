package cn.jsoncc.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/16 20:45
 * Email:896415482@qq.com
 */
@Data
@AllArgsConstructor
public class PageMap extends HashMap {
    int page;  //当前第几页
    int pageSize; //默认每页记录数
    int begin; //从第几条记录开始查询

    public PageMap(Map map) {
        //接收用户提交过来的参数
        this.putAll(map);

        //判断用户是否传递page
        if (map.containsKey("page")) {
            this.page = Integer.parseInt(map.get("page").toString());
        } else {
            this.page = 1;
        }
        //判断用户是否传递pageSize
        if (map.containsKey("pageSize")) {
            this.pageSize = Integer.parseInt(map.get("pageSize").toString());
        } else {
            this.pageSize = 10;
        }
        //计算 begin的值
        this.begin = (this.page - 1) * this.pageSize;
        this.put("page", this.page);
        this.put("pageSize", this.pageSize);
        this.put("begin", this.begin);
    }
}
