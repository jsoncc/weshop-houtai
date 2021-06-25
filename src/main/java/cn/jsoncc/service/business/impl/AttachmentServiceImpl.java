package cn.jsoncc.service.business.impl;

import cn.jsoncc.dao.business.AttachmentDao;
import cn.jsoncc.service.business.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * Author: JsonCC
 * Date: 2021/6/25 8:42
 * Email:896415482@qq.com
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentDao attachmentDao;


    @Override
    public int delete(String id, HttpServletRequest request) {
        Map map = attachmentDao.get(id);
        if (null == map) {
            return 0;
        }
        //获取服务器跟路径
        String realPath = request.getServletContext().getRealPath("/");

        //删除原图片
        deletefile(realPath,map.get("attUrl"));
        //删除缩略图
       deletefile(realPath,map.get("attMiniUrl"));
        //删除数据库的记录，（仅指图片）
        return attachmentDao.delete(id);
    }

    private void deletefile(String realPath,Object fileName){
        if (fileName == null){
            return;
        }
        File file = new File(realPath,fileName.toString());
        if (file.exists()){
            file.delete();
        }
    }
}
