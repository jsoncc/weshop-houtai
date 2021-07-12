package cn.jsoncc.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Author: JsonCC
 * Date: 2021/7/12 16:39
 * Email:896415482@qq.com
 */
@Data
public class UserDTO extends BaseRowModel {

    @ExcelProperty(value = "ID", index = 0)
    private String id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "email", index = 2)
    private String email;

    @ExcelProperty(value = "密码", index = 3)
    private String password;

    @ExcelProperty(value = "性别", index = 4)
    private String gender;

    @ExcelProperty(value = "状态", index = 5)
    private int status;


}