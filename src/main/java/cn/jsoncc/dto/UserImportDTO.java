package cn.jsoncc.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Author: JsonCC
 * Date: 2021/7/12 14:36
 * Email:896415482@qq.com
 */

/**
 * 导出
 */
@Data
public class UserImportDTO extends BaseRowModel {
    @ExcelProperty(value = "用户名", index = 0)
    private String username;

    @ExcelProperty(value = "名字", index = 1)
    private String name;

    @ExcelProperty(value = "状态", index = 2)
    private int status;

    @ExcelProperty(value = "手机号", index = 3)
    private String mobile;

    @ExcelProperty(value = "密码", index = 4)
    private String password;

}
