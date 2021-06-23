package cn.jsoncc.utils;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Author: JsonCC
 * Date: 2021/6/22 9:18
 * Email:896415482@qq.com
 */

/**
 * 26 单引号
 * 33 attachment/
 */
public class UploadUtils {
    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;
    private static final int MINI_WIDTH = 180;
    private static final int MINI_HEIGHT = 180;

    public static Map upload(HttpServletRequest request, MultipartFile file) {
        //获取文件名
        String filename = file.getOriginalFilename();
        // 获取后缀
        int pos = filename.lastIndexOf('.');//找到.的位置
        String ext = filename.substring(pos);//文件后缀ext
        //将上传的文件生成新的文件名
        String tmpName = UUID.randomUUID().toString() ;
        String newFileName = tmpName + ext;

        //获取服务器的跟路径 ？？？服务器是哪个服务器
        String root = request.getServletContext().getRealPath("/");

        // 二：
        // 根据附件上传目录，生成文件 会生成一个文件夹：attachment
        // 临时的多级目录
        String tmp = "attachment/" + DateUtils.getYmd() + "/";

        File dir = new File(root, tmp);
        if (!dir.exists()) {
            //创建目录
            dir.mkdirs();
        }
        //创建目标文件
        File newFile = new File(dir, newFileName);
        //拷贝
        try {
            copyFile(file.getInputStream(), newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //将图片压缩
        tonarrow(root + tmp + newFileName, WIDTH, HEIGHT, null);
        //缩略图
        String miniFile = tmpName + ".mini" + ext;
        tonarrow(root + tmp + newFileName, MINI_WIDTH, MINI_HEIGHT, root + tmp + miniFile);


        Map map = new HashMap();
        map.put("name", filename);                   //上传的原图片的名
        map.put("attType", file.getContentType());  //生成的新文件的类型
        map.put("attUrl", tmp + newFileName);       //新图片的名字

        //缩略图
        map.put("attMiniUrl", tmp + miniFile);

        return map;
    }

    /**
     * src 目标图片在服务器的绝对路径，目标图片就是生成的新图片
     * width 图片的宽
     * height 图片的高
     * isMini 生成缩略图后是否加上.mini
     * distFile 目标图片路径
     */
    //缩略图
    static void tonarrow(String src, int width, int height, String distFileName) {
        File srcFile = new File(src);
        File distFile = srcFile;
        //文件加上.mini
        if (null != distFileName) {

            distFile = new File(distFileName);

        }
        try {
            Thumbnails.of(srcFile)
                    .size(width, height)
                    .toFile(distFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 抛出异常应该修改修改 直接抛Exception不合适
    //拷贝文件
    static void copyFile(InputStream src, File dist) throws Exception {
        // 缓存流
        BufferedInputStream bis = new BufferedInputStream(src);
        //生成文件输出流
        FileOutputStream fos = new FileOutputStream(dist);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 设置缓存大小
        byte[] buffer = new byte[10240];
        while (bis.read(buffer) != -1) {
            bos.write(buffer);
        }
        //刷新缓存
        bos.flush();
        //关闭  减少资源浪费
        if (null != bis) {
            bis.close();
        }
        if (null != bos) {
            bos.close();
        }

    }
}
