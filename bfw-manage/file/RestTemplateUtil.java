package cn.jmfen.backend.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

@Slf4j
public class RestTemplateUtil {

    /**
     * GET请求，返回结果是JSON string
     * @param url
     * @return
     */
    public static String getForJson(String url){
        RestTemplate restTemplate = new RestTemplate();
        log.info("------liveApi------"+url);
        String result = restTemplate.getForObject(url,String.class);
        log.info("------result------"+result);
        return result;
    }

    /**
     * POST请求，数据格式为 application/json，并且返回结果是JSON string
     * @param url
     * @param
     * @return
     */
    public static String postForJson(String url, JSONObject json){
        RestTemplate restTemplate = new RestTemplate();
        //设置Http Header
        HttpHeaders headers = new HttpHeaders();
        //设置请求媒体数据类型
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        //设置返回媒体数据类型
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(null==json?null:json.toString(), headers);
        log.info("------postApi------"+url+"---"+json);
        return restTemplate.postForObject(url, formEntity, String.class);
    }

    /**
     * 拼接get请求的url请求地址
     */
    public static String getRequestUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null&&!params.get(key).equals("")) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }

}
