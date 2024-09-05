package com.example.undoRedoTest.util;

/**
 * @author chenweijia
 * @version 1.0
 * @date 2024/9/5 下午5:40
 */
abstract class Command {
    abstract public void execute();
    abstract public void reverse();
}
