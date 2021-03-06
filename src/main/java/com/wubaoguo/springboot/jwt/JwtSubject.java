package com.wubaoguo.springboot.jwt;

import org.apache.commons.lang3.StringUtils;
import org.wustrive.java.core.filter.ThreadContentFilter;

import com.nimbusds.jose.JWSObject;
import com.wubaoguo.springboot.constant.JwtConstants;

public class JwtSubject {
    private JWSObject jwsObject;

    public JwtSubject() {}
    
    
    public JwtSubject(JWSObject jwsObject) {
        this.jwsObject = jwsObject;
    }
    
    /**
     * @return the jwsObject
     */
    public JWSObject getJwsObject() {
        return jwsObject;
    }

    /**
     * @param jwsObject the jwsObject to set
     */
    public void setJwsObject(JWSObject jwsObject) {
        this.jwsObject = jwsObject;
    }
    
    public static JwtAuthentication getJwtUser() {
        return ThreadContentFilter.getData(JwtConstants.THREAD_CURRENT_USER);
    }
    
    public static boolean isLogin() {
        // 直接进行非空验证.后期做修改
        JwtAuthentication jwtUser = getJwtUser();
        if(jwtUser != null && StringUtils.isNotBlank(jwtUser.getUserId())) {
            return true;
        }
        return false;
    }
}
