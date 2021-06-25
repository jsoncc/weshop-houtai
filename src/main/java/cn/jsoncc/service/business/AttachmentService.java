package cn.jsoncc.service.business;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: JsonCC
 * Date: 2021/6/25 8:41
 * Email:896415482@qq.com
 */
public interface AttachmentService {
    public int delete(String id, HttpServletRequest request);
}
