package com.mankan.plumad.util;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;


/**
 * @author：youtiao
 * @description：
 * @date：下午6:47 2018/6/20
 */
public class HttpParamUtil {

    /**
     * 获取request参数
     * @param request
     * @return
     */
    public static HashMap getParams(HttpServletRequest request) throws IOException, DocumentException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String body = IOUtils.read(reader);
        HashMap map = new HashMap();
        if(!"".equals(body)){
            if(request.getContentType().contains("application/json")) {
                map = JSON.parseObject(body, new TypeReference<HashMap>() {});
            }else if(request.getContentType().contains("application/xml")){
                map = JSON.parseObject(XmlUtil.documentToJSONObject(body).toJSONString(), new TypeReference<HashMap>() {});
            }else if(request.getContentType().contains("text/xml")){
                map = JSON.parseObject(XmlUtil.documentToJSONObject(body).toJSONString(), new TypeReference<HashMap>() {});
            }else{
                map = JSON.parseObject(body, new TypeReference<HashMap>() {});
            }
        }else {
            Enumeration paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() != 0) {
                        map.put(paramName, paramValue);
                    }
                }
            }
        }
        return map;
    }
}
