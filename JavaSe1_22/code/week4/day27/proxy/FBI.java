package org.example.week4.day27.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FBI implements InvocationHandler {
    IMan target;

    public FBI(IMan target) {
        this.target = target;
    }

    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        Object result = null;
        String methodName = arg1.getName();
        System.out.println("FBI发现你正准备执行" + methodName + "活动！");
        result = arg1.invoke(target, arg2);
        System.out.println("FBI发现你已经完成" + methodName + "活动的执行！");
        return result;
    }
}
