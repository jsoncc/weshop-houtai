package cn.jsoncc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: JsonCC
 * Date: 2021/6/22 18:38
 * Email:896415482@qq.com
 */
public class DateUtils {
    public static String getYmd() {
        //获取日期
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);

    }

    public static void main(String[] args) {
        System.out.println(getYmd());
    }
}
