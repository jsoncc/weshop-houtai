package cn.jsoncc.controller.business;

import cn.jsoncc.controller.common.BaseController;
import cn.jsoncc.service.business.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: JsonCC
 * Date: 2021/6/25 8:40
 * Email:896415482@qq.com
 */


@RestController
@RequestMapping("/api/attach")
public class AttachmentController extends BaseController {

    @Autowired
    AttachmentService attachmentService;

    @RequestMapping("/delete")
    public String delete(String id, HttpServletRequest request){
        int delete = attachmentService.delete(id, request);
        if (delete == 1){
            return success("删除成功");
        }
        return fail("删除失败");
    }

}
