package com.cyy.cyyclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cyy.cyyclientsdk.model.User;


import java.util.HashMap;
import java.util.Map;

import static com.cyy.cyyclientsdk.utils.signUtils.getsign;


/**
 * 调用第三方接口的客户端
 */
public class cyyClient {
    private static final String GATEWAY_HOST="http://123.207.78.21:8090";
    private String accessKey;
    private String secretKey;
    public cyyClient(String accessKey, String secretKey){
        this.accessKey=accessKey;
        this.secretKey=secretKey;
    }
    public String getname01(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result1= HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result1);
        return result1;
    }

    //参数传值url
    public String getname02(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result1= HttpUtil.post(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result1);
        return result1;
    }



    private Map<String,String> getHeaderMap(String body){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);
        //密钥一定不能直接发送给后端
      //  hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);//用户传递的参数
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign",getsign(body, secretKey));//签名算法来生成签名

        return hashMap;
    }



    public String getname03(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());//响应状态码
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
