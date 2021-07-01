package cn.jsoncc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JsonCC
 * Date: 2021/6/30 22:48
 * Email:896415482@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBean {

    private String fieldName;

    private String errorMsg;

}
