package cn.jsoncc.controller.common;

import cn.jsoncc.utils.UploadUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/22 9:17
 * Email:896415482@qq.com
 */

/**
 * upload后面没有加注解
 */
@RestController
@RequestMapping("/api/file")
public class UploadController extends BaseController {

    @PostMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file) {

        Map map = UploadUtils.upload(request, file);
        return success("文件上传成功", map);
    }
}
