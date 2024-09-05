package com.example.undoRedoTest.util;

/**
 * @author chenweijia
 * @version 1.0
 * @date 2024/9/5 下午6:39
 */
public class BasicCalculator {

    private int total = 0;
    public void calc(char curOperator, int num) {
        int before = total;
        switch (curOperator) {
            case '+':
                total += num;
                break;
            case '-':
                total -= num;
                break;
            case '*':
                total *= num;
                break;
            case '/':
                total /= num;
                break;
        }
        System.out.println(before + "" + curOperator +num+"=" + total);
    }


}
