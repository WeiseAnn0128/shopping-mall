package cn.htu.shoppingmall.controller;

import cn.htu.shoppingmall.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @RequestMapping("/login")
    public String login(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid
                + "&secret=" + appsecret
                + "&js_code=" + code
                + "&grant_type=authorization_code";

        String get = HttpUtil.httpRequest(url, "GET", null);
        System.out.println(code);
        System.out.println(get);
        return "0";
    }

}
