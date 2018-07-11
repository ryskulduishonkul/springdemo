package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-07-11 17:31
 **/
@Service("propertiesService")
public class PropertiesService {

    @Value("其他类的属性")
    private String anthor;

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }
}
