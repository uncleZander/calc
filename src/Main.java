/*package whatever //do not write package name here */

import java.io.*;

class calc {
    static String[] roman = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    static int[] arab = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    public static void main (String[] args)
            throws java.io.IOException {
        int count = 0, value1 = 0, value2 = 0, result = 0, minusCount = 0, chInLength, i, tmpOst, tmpResult, checkDiv, posActn = 0;
        char arabValue1 = ' ', arabValue2 = ' ', romanValue1 = ' ', romanValue2 = ' ', charNum2, chrMinus;
        String opPlus = "+";
        String opMinus = "-";
        String opStar = "*";
        String opSlash = "/";
        String action = "o";
        String numSet = "", chInput1 = "", strNum1 = "", strNum2 = "", tmpStr = "", resultRoman = "";
        System.out.println("Введите задание в виде: \'Число1\' \'арифметический оператор\' \'Число2\' и нажмите ENTER.");
        System.out.println("Допустимо использование арабских чисел от -10 до 10 или римских чисел от I до X.");
        System.out.println();

//    Ввод задания.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chInput = br.readLine();
        chInput = chInput.replaceAll("\\s+","");
        chInput = chInput.toUpperCase();
        chInLength = chInput.length();

// Проверка корректности задания

        for (i = 0; i < chInLength; i++ ) {
            tmpStr = chInput.substring(i, i+1);
            if (tmpStr.equals("+")) {
                posActn = i;
                action = chInput.substring(i, i+1);
                count = count + 1;
            }
            else if (tmpStr.equals("-")) {
                chrMinus = chInput.charAt(i+1);
                if (chrMinus == '1' || chrMinus == '2' || chrMinus == '3' || chrMinus == '4' || chrMinus == '5' || chrMinus == '6' || chrMinus == '7' || chrMinus == '8' || chrMinus == '9' || chrMinus == '0') {
                    minusCount = minusCount + 1;
                    if (minusCount == 2 && chrMinus == chInput.charAt(i)) {
                        posActn = i;
                        action = chInput.substring(i, i+1);
                        count = count + 1;
                    }
                }
                else {
                    posActn = i;
                    action = chInput.substring(i, i+1);
                    count = count + 1;
                }
            }
            else if (tmpStr.equals("*")) {
                posActn = i;
                action = chInput.substring(i, i+1);
                count = count + 1;
            }
            else if (tmpStr.equals("/")) {
                posActn = i;
                action = chInput.substring(i, i+1);
                count = count + 1;
            }
            else count = count;
        }
        if (posActn == 0) {
            System.out.println("Задание должно содержать арифметическое действие");
            System.exit(1);
        }
        if (count > 1) {
            System.out.println("Задание должно содержать только одно аифметическое действие");
            System.exit(1);
        }

// Проверка арабские/латинские числа

        chInput1 = chInput.substring(0,1);
        if (chInput1.equals("I") || chInput1.equals("V") || chInput1.equals("X")) {
            numSet = "roman";
        }
        else if (chInput1.equals("-") || chInput1.equals("0") || chInput1.equals("1") || chInput1.equals("2") || chInput1.equals("3") || chInput1.equals("4") || chInput1.equals("5") || chInput1.equals("6") || chInput1.equals("7") || chInput1.equals("8") || chInput1.equals("9")) {
            numSet = "arab";
        }
        else {
            System.out.println("Задание должно содержать только арабские или римские числа и знак арифметической операции");
            System.exit(1);
        }

// Проверка, что оба операнда записаны в одинаковой системе

        if (numSet.equals("roman")) {
            for (i = posActn+1; i < chInLength; i++) {
                charNum2 = chInput.charAt(i);
                if (charNum2 == '-' || charNum2 == '0' || charNum2 == '1' || charNum2 == '2' || charNum2 == '3' || charNum2 == '4' || charNum2 == '5' || charNum2 == '6' || charNum2 == '7' || charNum2 == '8' || charNum2 == '9') {
                    System.out.println("Числа должны быть одной системы, арабские или римские");
                    System.exit(1);
                }
                else numSet = numSet;
            }
        }
        else {
            for (i = posActn+1; i < chInLength; i++) {
                charNum2 = chInput.charAt(i);
                if (charNum2 == 'I' || charNum2 == 'V' || charNum2 == 'X') {
                    System.out.println("Числа должны быть одной системы, арабские или римские");
                    System.exit(1);
                }
                else numSet = numSet;
            }
        }

// Преобразование римских чисел в арабские

        strNum1 = chInput.substring(0, posActn);
        strNum2 = chInput.substring(posActn+1, chInLength);
        if (numSet.equals("roman")) {
            if (strNum1.equals("I")) value1 = 1;
            else if (strNum1.equals("II")) value1 = 2;
            else if (strNum1.equals("III")) value1 = 3;
            else if (strNum1.equals("IV")) value1 = 4;
            else if (strNum1.equals("V")) value1 = 5;
            else if (strNum1.equals("VI")) value1 = 6;
            else if (strNum1.equals("VII")) value1 = 7;
            else if (strNum1.equals("VIII")) value1 = 8;
            else if (strNum1.equals("IX")) value1 = 9;
            else if (strNum1.equals("X")) value1 = 10;
            else {
                System.out.println("Введенное число " + strNum1 + " не является корректным");
                System.exit(1);
            }
            if (strNum2.equals("I")) value2 = 1;
            else if (strNum2.equals("II")) value2 = 2;
            else if (strNum2.equals("III")) value2 = 3;
            else if (strNum2.equals("IV")) value2 = 4;
            else if (strNum2.equals("V")) value2 = 5;
            else if (strNum2.equals("VI")) value2 = 6;
            else if (strNum2.equals("VII")) value2 = 7;
            else if (strNum2.equals("VIII")) value2 = 8;
            else if (strNum2.equals("IX")) value2 = 9;
            else if (strNum2.equals("X")) value2 = 10;
            else {
                System.out.println("Введенное число " + strNum2 + " не является корректным");
                System.exit(1);
            }
        }
        else {
            value1 = Integer.parseInt(strNum1);
            value2 = Integer.parseInt(strNum2);
        }

// Вычисление и вывод результа

        switch (action) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                if (numSet == "roman" && value1 < value2) {
                    System.out.println("В римских числах не бывает отрицательных значений");
                    System.exit(1);
                }
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if (value2 != 0) {
                    result = value1 / value2;
                    break;
                }
                else {
                    System.out.println("На ноль делить нельзя!");
                    System.exit(1);
                }
        }
        switch (numSet) {
            case "arab":
                if (result > 100) {
                    System.out.println("Числа в задании должны быть от -10 до 10");
                    System.exit(1);
                }
                System.out.println("Результат: " + result);
                break;
            case "roman":
                if (result > 100) {
                    System.out.println("Числа в задании должны быть от I до X");
                    System.exit(1);
                }
                tmpResult = result;
                for (i = 0; i < 9; i++) {
                    checkDiv = tmpResult / arab[i];
                    if(checkDiv == 1) {
                        resultRoman = resultRoman + roman[i];
                        tmpResult = tmpResult - arab[i];
                    }
                    else if (checkDiv > 1) {
                        for (int j = 0; j < checkDiv; j++) {
                            resultRoman = resultRoman + roman[i];
                            tmpResult = tmpResult - arab[i];
                        }
                    }
                }
                System.out.println("Результат: " + resultRoman);
                break;
        }
    }
}
