package org.example;

import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Вычисление выражения, записанного в виде обратной польской нотации
 *
 * @author Новикова Анастасия
 */

/**
 * Абстрактный класс, связанный с интерфейсом Notation
 */
public class ReversePolishNotation implements Notation {

    /**
     * Метод, осуществляющий считывание записи с консоли.
     *
     * @return строка с выражением, а при ошибке вызывается исключение
     * @throws IOException вызывается, если ввод не был осуществлен
     */
    public String readLine() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            return new String();
        }
    }

    /**
     * Метод, осуществляющий получение результата.
     * Введенная строка обрабатывается посимвольно
     *
     * @return Результат вычислений
     * @throws ArithmeticException вызывается, если произошло деление на 0
     * @throws Exception           если произошел неверный ввод строки
     */
    public Double getResult(String in) throws Exception {
        char[] arr = in.toCharArray();
        Stack<Double> expression = new Stack();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                expression.push(Double.parseDouble(String.valueOf(c)));
            } else if (expression.size() >= 2) {
                Double a = expression.pop();
                Double b = expression.pop();
                switch (c) {
                    case '+' -> expression.push(a + b);
                    case '-' -> expression.push(b - a);
                    case '*' -> expression.push(b * a);
                    case '/' -> {
                        if (a == 0) {
                            throw new ArithmeticException("Division by zero");
                        } else {
                            expression.push(b / a);
                        }
                    }
                }
            } else {
                throw new Exception("Wrong line!");
            }
        }
        if (expression.size() >= 2) {
            throw new Exception("Wrong line!");
        }
        return expression.pop();
    }

    public static void main(String[] args) throws Exception {
        ReversePolishNotation notation = new ReversePolishNotation();
        String input = notation.readLine();
        System.out.println(notation.getResult(input));
    }
}