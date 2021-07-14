package cn.jsoncc.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

/**
 * Author: JsonCC
 * Date: 2021/7/13 14:59
 * Email:896415482@qq.com
 */
public class TokenUtils {

    private static final String SECRET = "agb.sdf234.affw5asd";
    /**
     * token 过期时间: 1天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 1;

    public static String getToken() {
        // expire time 到期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        JWTCreator.Builder builder = JWT.create();
        String token = builder.withClaim("username", "admin")
                .withClaim("id", "001")
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;

    }

    public static void verifyToken() {
        String info = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjAwMSIsInVzZXJuYW1lIjoiYWRtaW4ifQ.sPKqCA13-QfLKGZlfiPq9pyEukuoXQM7skRziZLzlqo";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        //解码
        //异常没有捕获
        DecodedJWT decodedJWT = jwtVerifier.verify(jwtVerifier.verify(info));

        //验证：-- 获取的时间和系统时间作比较，大于系统时间就是未到期，小于就是过期了
        Date validateDate = decodedJWT.getExpiresAt();
        if (validateDate.getTime() < System.currentTimeMillis()) {
            //令牌过期了
            System.out.println("过期了");
        }

        System.out.println(decodedJWT.getPayload());//载荷：JWT的中间组成部分
        System.out.println(decodedJWT.getType());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getClaim("username"));
        System.out.println(decodedJWT.getClaim("id"));
    }

    public static void main(String[] args) {
        System.out.println(getToken());
//        verifyToken();
    }
}
