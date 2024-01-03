package org.example.recursive;

public class Factorial {

    static public int calculate(Integer num){
        return calculate(num, 1);
    }

    static private int calculate(Integer num, Integer result){
        if(num == 1){
            return result;
        }
        return calculate(--num, result * num);
    }
}
