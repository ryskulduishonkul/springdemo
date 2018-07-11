package com.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Holley
 * @Description 每次调用重新创建bean的实例
 * @create 2018-07-11 17:01
 **/
@Service("demoPrototyService")
@Scope("prototype")
public class DemoPrototyService {
}
