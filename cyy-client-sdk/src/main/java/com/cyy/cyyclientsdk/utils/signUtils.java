package com.cyy.cyyclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class signUtils {
    /**
     *签名算法来生成签名
     */
    public static String getsign(String body, String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String content = body+"."+secretKey;
        String digestHex = md5.digestHex(content);
        return digestHex;
    }
}
