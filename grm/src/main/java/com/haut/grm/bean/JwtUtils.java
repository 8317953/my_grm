package com.haut.grm.bean;
 
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haut.grm.model.MyUser;
//import com.zhanchuan.logon.entity.TSmsCode;
import com.haut.grm.model.meta.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
public class JwtUtils {
 
 
    /**
     * 密钥
     */
    private static  final String SECRET="XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
    /**
     * 默认字段key:exp
     */
    private static final String EXP="exp";
    /**
     * 默认字段key:payload
     */
    private static final String PAYLOAD="payload";
 
    /**
     * 加密
     * @param object 加密数据
     * @param maxTime 有效期（毫秒数）
     * @param <T>
     * @return
     */
    public static <T> String encode(T object,long maxTime){
        try{
            final JWTSigner signer=new JWTSigner(SECRET);
            final Map<String ,Object> data=new HashMap<String ,Object>(10);
            ObjectMapper objectMapper=new ObjectMapper();
            String jsonString=objectMapper.writeValueAsString(object);
            data.put(PAYLOAD,jsonString);
            data.put(EXP,System.currentTimeMillis()+maxTime);
            return signer.sign(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
 
    /**
     * 数据解密
     * @param jwt 解密数据
     * @param classT 解密类型
     * @param <T>
     * @return
     * @throws Exception
     */
    public static MyUser unsign(String jwt) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    System.out.println(json);
                    Map<String,Object> jsonToMap = JSONObject.parseObject(json);
                    String username=jsonToMap.get("username").toString();
                    String pwd=jsonToMap.get("pwd").toString();
                    String id=jsonToMap.get("id").toString();
                    if(username==null) {
                    	return null;
                    }else {
                    	return new MyUser(username, pwd,id);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
 
    public static void main(String[] args) {
//    	MyUser user=new MyUser("toyla","123456");
////    	user.setId(1l);
////    	user.setUsername("toyla");
//    	
//    	String token=encode(user,300000000);
//    	System.out.println(token);
//    	MyUser u=unsign(token);
//    	System.out.println(u.getUsername());
//        TSmsCode tSmsCode = new TSmsCode();
//       /* tSmsCode.setPhone("15865732513");
//        String s = encode(tSmsCode,1);
//        System.out.println(s);*/
//        TSmsCode s1 =unsign("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4MDk2NzI3MDAsInBheWxvYWQiOiJ7XCJpZFwiOjAsXCJwaG9uZVwiOlwiMTU4NjU3MzI1MTNcIixcInN0YXR1c1wiOjAsXCJjcmVhdGVUaW1lXCI6bnVsbCxcImV4cGlyYXRpb25UaW1lXCI6bnVsbCxcImNoZWNrQ29kZVwiOm51bGx9In0.j2L2EDCjZivJAoJ5agfgjtQyXPJM9OX0T5HB8Tt0JzY",TSmsCode.class);
//        if (null == s1){
//            System.out.println("身份认证过期");
//        }
        //System.out.println(s1.getPhone());
    }
}
