package org.light4j.genericity.senior;


public class R<T>
{
    // 下面代码错误，不能在静态Field声明中使用类型形参
  //static T info;
    T age;
    public void foo(T msg){}
    // 下面代码错误，不能在静态方法声明中使用类型形参
//  public static void bar(T msg){}
}
