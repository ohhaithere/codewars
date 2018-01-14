package com.frostmaster.Katas.Calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;

public class Kata {

    public static Object evaluate(String expression) {
        int result = 0;
        expression = expression.replace(" ", "");
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        //Integer test = 0;

        try {
            if(engine.eval(expression) instanceof Double)
                return engine.eval(expression);
            else {
                Integer test = (Integer) engine.eval(expression);
                String test2 = test.toString();
                test2 = test2 + ".0";
                return Double.parseDouble(test2);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
