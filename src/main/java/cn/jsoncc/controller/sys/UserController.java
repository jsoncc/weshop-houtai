package cn.jsoncc.controller.sys;

import cn.jsoncc.bean.User;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.dto.UserDTO;
import cn.jsoncc.dto.UserImportDTO;
import cn.jsoncc.service.sys.Userservice;
import cn.jsoncc.utils.EasyExcelUtil;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/30 11:04
 * Email:896415482@qq.com
 */
@RequestMapping("/api/sys/user")
@RestController
@Api(tags = "用户管理控制器",description = "UserController")
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

    @ApiOperation(value = "导出员工")
    @PutMapping(value = "/getByDeptIdExport")
    public void getByDeptIdExport(HttpServletResponse response) {
        //开始导出
        try {
            ServletOutputStream out = response.getOutputStream();
            String fileName = new String("明细-汇总数据导出.xlsx".getBytes("utf-8"), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-xlsx;charset=gb2312");

            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            // 设置SHEET
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("sheet1");

            // 设置标题
            Table table = new Table(1);
            List<List<String>> titles = new ArrayList<List<String>>();
            titles.add(Arrays.asList("用户ID"));
            titles.add(Arrays.asList("账号名字"));
            titles.add(Arrays.asList("手机号"));
            titles.add(Arrays.asList("名字"));
            titles.add(Arrays.asList("邮件"));
//            titles.add(Arrays.asList("状态"));
            titles.add(Arrays.asList("创建时间"));
            table.setHead(titles);

            // 查询数据导出即可 比如说一次性总共查询出100条数据
            List<List<String>> userList = new ArrayList<>();
            List<User> users = userservice.queryAll();

            users.stream()
                    .forEach((User dto) -> {
                        List<String> list = new ArrayList<>();
                        list.add(dto.getId().toString());
                        list.add(dto.getUsername());
                        list.add(dto.getMobile());
                        list.add(dto.getName());
                        list.add(dto.getEmail());
//                        list.add(dto.getStatus());
                        list.add(dto.getAdddate());

                        userList.add(list);
                    });

            writer.write0(userList, sheet, table);
            writer.finish();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("导入(固定格式：名字;email;密码;性别(男或女);)")
    @RequestMapping(value = "/getByDeptIdImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void getByDeptIdImport(@RequestParam("uploadFile") MultipartFile file) {
        try {
            List<Object> list = EasyExcelUtil.readExcel(file, new UserDTO(), 1, 1);
            list.stream()
                    .forEach((Object obj) -> {
                        UserDTO dto = (UserDTO) obj;
                        //todo 开始处理逻辑
                        User user = new User();
                        user.setName(dto.getName());
                        user.setEmail(dto.getEmail());
                        user.setPassword(dto.getPassword());
                        user.setAdddate(dto.getAdddate());
                        String gender = dto.getGender();
                        if (gender.equals("男")){
                            user.setGender(1);
                        }else {
                            user.setGender(0);
                        }

                        int save = userservice.save(user);
                        System.out.println("----------------------------");
                        System.out.println(save);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
