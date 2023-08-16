package com.cyy.cyyinterface.controller;
import com.cyy.cyyclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称API
 * （服务端)
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getname01(String name){//从请求头中取AK ，SK
        return "get 名字"+name;
    }

    //参数传值url
    @PostMapping("/post")
    public String getname02(@RequestParam String name){
        return "post 名字"+name;
    }

    @PostMapping("/user")
    public String getname03(@RequestBody User user, HttpServletRequest request){
//        String accessKey =request.getHeader("accessKey");
//        String nonce =request.getHeader("nonce");
//        String timestamp =request.getHeader("timestamp");
//        String sign =request.getHeader("sign");
//        String body =request.getHeader("body");
//        //实际是去数据库中查是否已分配给用户
//        if(!accessKey.equals("1414")){
//            throw new RuntimeException("无权限");
//        }
//        //签名算法来生成签名
//        String serverSign= signUtils.getsign(body, "abcdefgh");
//        if(!sign.equals(serverSign)){
//            throw new RuntimeException("无权限");
//        }
        String result ="post 用户名字"+user.getUserName();
        //调用成功后，次数加一
        return result;
    }

}
