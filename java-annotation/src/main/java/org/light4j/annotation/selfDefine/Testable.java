package org.light4j.annotation.selfDefine;

import java.lang.annotation.*;

//使用JDK的元数据Annotation：Retention
@Retention(RetentionPolicy.RUNTIME)
// 使用JDK的元数据Annotation：Target
@Target(ElementType.METHOD)
// 定义一个标记注解，不包含任何成员变量，即不可传入元数据
public @interface Testable {
}