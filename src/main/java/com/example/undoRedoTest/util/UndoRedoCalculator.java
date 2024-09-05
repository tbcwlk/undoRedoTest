package com.example.undoRedoTest.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenweijia
 * @version 1.0
 * @date 2024/9/5 下午5:43
 */
public class UndoRedoCalculator {

    private BasicCalculator basicCalculator = new BasicCalculator();
    private List<Command> commands = new ArrayList<Command>();
    private int currentIndex = 0;

    //计算
    public void calc(char curOperator, int num) {
        Command command = new CalculatorCommand(basicCalculator, curOperator, num);
        command.execute();
        commands.add(command);
        currentIndex++;
    }

    //重做
    public void redo(int levels) {
        System.out.println("Redo" + levels);
        for (int i = 0; i < levels; i++)
            if (currentIndex < commands.size() - 1) {
                ((Command) commands.get(currentIndex++)).execute();
            }else {
                System.out.println("没有可redo的数据!");
            }
    }

    //撤销
    public void undo(int levels) {
        System.out.println("Undo" + levels);
        for (int i = 0; i < levels; i++)
            if (currentIndex > 0) {
                int index = --currentIndex;
                Command command= (Command)commands.get(index);
                command.reverse();
            }else {
                System.out.println("没有可undo的数据!");
            }
    }


}


