package com.example.undoRedoTest.util;

/**
 * @author chenweijia
 * @version 1.0
 * @date 2024/9/5 下午5:41
 */
public class CalculatorCommand extends Command{

    char curOperator;
    int num;
    BasicCalculator basicCalculator;

    public CalculatorCommand(BasicCalculator basicCalculator, char curOperator, int num) {
        this.basicCalculator = basicCalculator;
        this.curOperator = curOperator;
        this.num = num;
    }

    public char getCurOperator() {
        return curOperator;
    }

    public void setCurOperator(char curOperator) {
        this.curOperator = curOperator;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BasicCalculator getCalculator() {
        return basicCalculator;
    }

    public void setCalculator(BasicCalculator basicCalculator) {
        this.basicCalculator = basicCalculator;
    }

    @Override
    public void execute() {
        basicCalculator.calc(curOperator, num);
    }

    @Override
    public void reverse() {
        basicCalculator.calc(undo(curOperator), num);
    }

    private char undo(char op) {
        char undo = ' ';
        switch (op) {
            case '+':
                undo = '-';
                break;
            case '-':
                undo = '+';
                break;
            case '*':
                undo = '/';
                break;
            case '/':
                undo = '*';
                break;
        }
        return undo;
    }

}
