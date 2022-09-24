package org.example;

import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Класс обратной польской записи с методами readLine и getResult.
 *
 * @author Новикова Анастасия
 */
public class ReversePolishNotation {

    /**
     * Метод, осуществляющий считывание записи с консоли.
     *
     * @throws IOException вызывается, если ввод не был осуществлен
     */
    public static String readLine() {
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
    public static Double getResult(String in) throws Exception {
        char[] arr = in.toCharArray();
        Stack<Double> exp = new Stack();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                exp.push(Double.parseDouble(String.valueOf(c)));
            } else if (exp.size() >= 2) {
                Double a = exp.pop();
                Double b = exp.pop();
                switch (c) {
                    case '+' -> exp.push(a + b);
                    case '-' -> exp.push(b - a);
                    case '*' -> exp.push(b * a);
                    case '/' -> {
                        if (a == 0) {
                            throw new ArithmeticException("Division by zero");
                        } else {
                            exp.push(b / a);
                        }
                    }
                }
            } else {
                throw new Exception("Wrong line!");
            }
        }
        if (exp.size() >= 2) {
            throw new Exception("Wrong line!");
        }
        return Double.parseDouble(String.valueOf(exp.pop()));
    }

    public static void main(String[] args) throws Exception {
        String in = readLine();
        Double result = getResult(in);
        System.out.println(result);
    }
}