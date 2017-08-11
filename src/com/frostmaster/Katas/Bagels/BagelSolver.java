package com.frostmaster.Katas.Bagels;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Igor_Usachev on 8/8/2017.
 */
public class BagelSolver {

    public static Bagel getBagel() {
        BagelWrapper bagelWrapper = new BagelWrapper();

       // bagelWrapper.invoke();
        return bagelWrapper;
    }

    static class BagelWrapper extends Bagel implements InvocationHandler {
        // private final Object target;

        // public MyInvocationHandler(Object target) {
        //     this.target = target;
        // }

        @Override
        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            return (Object) 4; //;m.invoke(target, args);
        }
    }
}
