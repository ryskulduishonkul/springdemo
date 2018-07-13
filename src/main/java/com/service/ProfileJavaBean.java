package com.service;

/**
 * @author Holley
 * @Description java配置的bean，在配置类注入时，通过@Profile("dev")注解来设置不同环境下不同配置
 * @create 2018-07-13 10:52
 **/
public class ProfileJavaBean {

    private String content;

    public ProfileJavaBean(String content){
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
