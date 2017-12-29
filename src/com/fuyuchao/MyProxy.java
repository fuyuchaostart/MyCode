package com.fuyuchao;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月30
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class MyProxy {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Object proxyInstance = ProxyFactory.getProxyInstance(superMan);
        MySupMan mySupMan = (MySupMan) proxyInstance;
        int say = mySupMan.say(10, 10);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public void bind(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法执行前执行");
        Object invoke = method.invoke(object, args);
        System.out.println("目标方法执行---后---执行");
        return invoke;
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object o) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), handler);
    }
}

class SuperMan implements MySupMan {
    @Override
    public int say(int x, int y) {
        System.out.println(x * y);
        return x * y;
    }
}


