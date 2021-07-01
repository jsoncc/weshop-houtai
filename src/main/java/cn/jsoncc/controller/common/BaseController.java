package cn.jsoncc.controller.common;

import cn.jsoncc.bean.ErrorBean;
import cn.jsoncc.common.bean.PageBean;
import cn.jsoncc.common.bean.ResultBean;
import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: JsonCC
 * Date: 2021/6/16 16:27
 * Email:896415482@qq.com
 */
/**
 *  0可以理解为失败
 *  1可以理解为成功
 */
public class BaseController {
    private static final int SUCCESS = 200;
    private static final int FAIL = 0;

    /**
     * @param msg  成功的消息描述
     * @param data 接口返回的数据
     * @return ResultBean
     */
    protected String success(String msg, Object data) {
        return getResult(SUCCESS, msg, data);
    }

    /**
     * @param msg 成功的消息描述
     * @return ResultBean
     */
    protected String success(String msg) {
        return getResult(SUCCESS, msg, null);
    }

    /**
     * @param msg 失败的消息描述
     * @return ResultBean
     */
    protected String fail(String msg) {
        return getResult(FAIL, msg, null);
    }

    protected String fail(String msg,List list) {
        return getResult(FAIL, msg, list);
    }


    private String getResult(int code, String msg, Object data) {
        if (data instanceof PageBean) {
            PageBean pageBean = (PageBean) data;
            pageBean.setCode(code);
            pageBean.setMsg(msg);
            return toJsonString(pageBean);
        }
        return toJsonString(new ResultBean(code, msg, data));
    }

    /**
     * 将ResultBean转换为json格式的字符串
     *
     * @param rs ResultBean 封装的结果
     * @return json格式的字符串
     */
    String toJsonString(Object rs) {
        return JSONObject.toJSONString(rs);
    }

    protected List validate(BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            //封装错误信息
            List rs = new ArrayList();
            List<FieldError> list = bindingResult.getFieldErrors();
            //迭代器封装
            Iterator<FieldError> iterator= list.iterator();
            if (iterator.hasNext()){
                FieldError fieldError=iterator.next();
                rs.add(new ErrorBean(fieldError.getField(),fieldError.getDefaultMessage()));
            }
            return rs;
        }
        return null;
    }
}
