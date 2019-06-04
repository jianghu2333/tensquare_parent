package com.tensquare.Listener;

import com.tensquare.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <Description>
 *
 * @author Jiangyong
 * @version 1.0
 * @createDate 2019/06/01 10:38
 * @see com.tensquare.Listener
 */
@Component
@RabbitListener
public class SmsListener {
    /**
     * 发送短信
     *
     * @param message      
     */

    @Autowired
    private SmsUtil smsUtil;
    @Value("${aliyun.sms.template_code}")
    private String template_code;//模板编号
    @Value("${aliyun.sms.sign_name}")
    private String sign_name;//签名

    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        System.out.println("手机号：" + message.get("mobile"));
        System.out.println("验证码：" + message.get("code"));
    }

}
