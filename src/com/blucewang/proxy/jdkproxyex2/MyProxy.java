package com.blucewang.proxy.jdkproxyex2;

import java.lang.reflect.*;

/**
 * 1.通过实现InvocationHandler接口来自定义自己的InvocationHandler
 * 2.通过Proxy.getProxyClass获取动态代理类
 * 3.通过反射机制货的代理类的构造方法，方法签名为getContructor(InvocationHandler.class)
 * 4.通过构造函数获得代理对象并将自定义的InvocationHandler实例对象作为参数传入
 * 5.通过代理对象调用目标方法
 * Created by bluceWang on 2017/1/13.
 */

public class MyProxy {
    public interface IHello{
        void sayHello();
    }
    static class Hello implements IHello{
        public void sayHello() {
            System.out.println("Hello world!!");
        }
    }
    //自定义InvocationHandler
    static  class HWInvocationHandler implements InvocationHandler {
        //目标对象
        private Object target;
        public HWInvocationHandler(Object target){
            this.target = target;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("------插入前置通知代码-------------");
            //执行相应的目标方法
            Object rs = method.invoke(target,args);
            System.out.println("------插入后置处理代码-------------");
            return rs;
        }
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //通过代理对象调用目标方法
        iHello.sayHello();
    }
}
