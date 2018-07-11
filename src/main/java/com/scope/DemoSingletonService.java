package com.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Holley
 * @Description
 * Singleton : 单例模式
 * Prototype : 每次调用新建一个bean的实例
 * Request : Web项目中，给每个http request新建一个bean的实例
 * Session : Web项目中，给每个http session新建一个bean的实例
 *  GlobalSession : 这个只用在portal应用中，给每个global http session新建一个bean的实例
 * 默认的是@Scope("singleton"),单例模式
 * @create 2018-07-11 16:58
 **/
@Service("demoSingletonService")
public class DemoSingletonService {

}
