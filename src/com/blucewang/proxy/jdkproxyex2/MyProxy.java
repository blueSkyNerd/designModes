package com.blucewang.proxy.jdkproxyex2;

import java.lang.reflect.*;

/**
 * 1.ͨ��ʵ��InvocationHandler�ӿ����Զ����Լ���InvocationHandler
 * 2.ͨ��Proxy.getProxyClass��ȡ��̬������
 * 3.ͨ��������ƻ��Ĵ�����Ĺ��췽��������ǩ��ΪgetContructor(InvocationHandler.class)
 * 4.ͨ�����캯����ô�����󲢽��Զ����InvocationHandlerʵ��������Ϊ��������
 * 5.ͨ������������Ŀ�귽��
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
    //�Զ���InvocationHandler
    static  class HWInvocationHandler implements InvocationHandler {
        //Ŀ�����
        private Object target;
        public HWInvocationHandler(Object target){
            this.target = target;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("------����ǰ��֪ͨ����-------------");
            //ִ����Ӧ��Ŀ�귽��
            Object rs = method.invoke(target,args);
            System.out.println("------������ô������-------------");
            return rs;
        }
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //��ȡ��̬������
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        //��ô�����Ĺ��캯�����������������InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //ͨ�����캯����������̬������󣬽��Զ����InvocationHandlerʵ������
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //ͨ������������Ŀ�귽��
        iHello.sayHello();
    }
}
