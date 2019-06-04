package com.tensquare.user.Filter;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <Description>
 *
 * @author Jiangyong
 * @version 1.0
 * @createDate 2019/06/01 17:27
 * @see com.tensquare.user.Filter
 */
public class JwtFilter extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(header)&&header.startsWith("Bearer ")){
            String token = header.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if ("admin".equals(claims.get("roles"))){
                request.setAttribute("admin_claims",claims);
            }
            if ("user".equals(claims.get("roles"))){
                request.setAttribute("user_claims",claims);
            }

        }
        return true;
    }
}
