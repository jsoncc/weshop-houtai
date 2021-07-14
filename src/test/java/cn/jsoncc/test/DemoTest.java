package cn.jsoncc.test;

import java.util.UUID;

/**
 * Author: JsonCC
 * Date: 2021/7/14 15:03
 * Email:896415482@qq.com
 */
public class DemoTest {
    public static void main(String[] args) {
        for(int i=0;i<1;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
    }
}
