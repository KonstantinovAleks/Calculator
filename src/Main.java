package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String calc(String input) {
        boolean romanOrArabic = false;
        int res;
        String exception = "throws Exception";
        String[] inputs = input.split(" ");
        NumHelper numHelper = new NumHelper();
        if (inputs.length < 3) {
            return exception + " //т.к. строка не является математической операцией";
        }
        if (inputs.length > 3) {
            return exception + " //т.к. формат математической оперции не удовлетворяет заданию - два операнда и один оператор (+, -, *, /)";
        }
        int num1 = 0;
        int num2 = 0;
        try {
            num1 = Integer.valueOf(inputs[0]);
            num2 = Integer.valueOf(inputs[2]);
        } catch (NumberFormatException e) {
            try {
                num1 = numHelper.romanToArabic(inputs[0]);
                num2 = numHelper.romanToArabic(inputs[2]);
                romanOrArabic = true;
            } catch (NumberFormatException ex) {
                return exception + " //т.к. используются одновременно разные системы счисления";
            }
        }
        if ((num1 < 1) || (num1 > 10) || (num2 < 1) || (num2 > 10)) {
            return exception + " //т.к. один из операндов не удовлетворяет заданию";
        }

        String sign = inputs[1];
        switch (sign) {
            case "+": res = num1 + num2; break;
            case "-": res = num1 - num2; break;
            case "*": res = num1 * num2; break;
            case "/": res = num1 / num2; break;
            default: {
                return exception + " //т.к. введённый оператор не соответствует заданному условию (+, -, *, /)";
            }
        }

        String output;
        if (romanOrArabic) {
            if (res < 1) {
                return exception + " //т.к. в римской системе не может быть такого результата";
            } else {
                output = numHelper.arabicToRoman(res);
            }
        } else {
            output = Integer.toString(res);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader expressionInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input:");
        String expression = expressionInput.readLine();
        System.out.println("Output:\n" + calc(expression));
    }
}