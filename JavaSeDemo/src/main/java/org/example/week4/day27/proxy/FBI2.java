package org.example.week4.day27.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FBI2 implements InvocationHandler {
    IMan1 target;

    public FBI2(IMan1 target) {
        this.target = target;
    }

    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        Object result = null;
        String methodName = arg1.getName();
        if ("mm".equals(methodName)) {
            System.out.println("FBI已经成功阻止你执行" + methodName + "活动！");
        } else if ("sayHelp".equals(methodName)) {
            arg1.invoke(target, new Object[]{"我很好！"});
            result = "没空搭理你";
        } else {
            System.out.println("FBI发现你正准备执行" + methodName + "活动！");
            result = arg1.invoke(target, arg2);
            System.out.println("FBI发现你已经完成" + methodName + "活动的执行！");
        }
        return result;
    }
}
