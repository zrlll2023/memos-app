package com.memos.memosapp.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // 密钥（实际项目放配置文件，今天先写死）
    private static final String SECRET = "memos-app-secret-key-2024-very-long-string";
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L; // 7天

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 生成 Token
    public static String generateToken(Long userId, String username) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))   // 把用户ID存进去
                .claim("username", username)           // 把用户名存进去
                .setIssuedAt(new Date())               // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 过期时间
                .signWith(KEY)                         // 用密钥签名
                .compact();
    }

    // 解析 Token，拿到用户ID
    public static Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Long.valueOf(claims.getSubject());
    }

    // 验证 Token 是否有效
    public static boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}