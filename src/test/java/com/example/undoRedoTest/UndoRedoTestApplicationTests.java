package com.example.undoRedoTest;

import com.example.undoRedoTest.util.UndoRedoCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UndoRedoTestApplicationTests {

	public static UndoRedoCalculator calculator = new UndoRedoCalculator();

	@Test
	void contextLoads() {
		calculator.calc('+', 100);//加法
		calculator.calc('-', 50);//减法
		calculator.calc('*', 10);//乘法
		calculator.calc('/', 2);//除法
		calculator.undo(4);//撤销前四个步骤
		calculator.redo(3);//再次执行三个步骤
		//再次执行
		calculator.calc('+', 2);//加法
	}

}
