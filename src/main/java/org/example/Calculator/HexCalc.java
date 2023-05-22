package org.example.Calculator;

import org.example.CalculatorController;

public class HexCalc {
    public String hexCalc(String str) {
        int result = 0;
        String[] splitStr = convertHexStrToDecimalSplitStr(str);
        if(splitStr == null){
            CalculatorController.showAlert("error","Error: string is empty");
            return "error";
        }
        for(int i=0;i< splitStr.length && result != -1;i++) {
            if(splitStr[i]==null) continue;
            switch (splitStr[i]) {
                case "*":
                    result = App.mul(splitStr[i - 1], splitStr[i + 1]);
                    splitStr[i-1] = null;
                    splitStr[i+1] = Integer.toString(result);
                    splitStr[i] = null;
                    break;
                case "/":
                    result = App.div(splitStr[i - 1], splitStr[i + 1]);
                    splitStr[i-1] = null;
                    splitStr[i+1] = Integer.toString(result);
                    splitStr[i] = null;
                    break;
            }
        }

        if(result == -1){
            return "error";
        }
        result = 0;
        for(int i=0;i< splitStr.length && result != -1;i++) {
            if(splitStr[i] == null) continue;
            int j=1,k=1;
            switch (splitStr[i]) {
                case "+":
                    while(splitStr[i-j]==null && (i-j)>=0){
                        j++;
                    }
                    while(splitStr[i+k]==null && (i+k)<splitStr.length) {
                        k++;
                    }
                    result = App.add(splitStr[i - j], splitStr[i + k]);
                    splitStr[i-j] = null;
                    splitStr[i+k] = Integer.toString(result);
                    splitStr[i] = null;
                    break;
                case "-":
                    while(splitStr[i-j]==null && (i-j)>=0){
                        j++;
                    }
                    while(splitStr[i+k]==null && (i+k)<splitStr.length) {
                        k++;
                    }
                    result = App.sub(splitStr[i - j], splitStr[i + k]);
                    splitStr[i-j] = null;
                    splitStr[i+k] = Integer.toString(result);
                    splitStr[i] = null;
                    break;
            }
        }
        return convertDecToHexStr(String.valueOf(result));
    }

    String convertDecToHexStr(String str) {
        char[] chArr = str.toCharArray();
        int num = 0;
        for (int i = 0; i < chArr.length; i++) {
            switch (chArr[i]) {
                case '0':
                    num = 10 * num;
                    break;
                case '1':
                    num = 10 * num + 1;
                    break;
                case '2':
                    num = 10 * num + 2;
                    break;
                case '3':
                    num = 10 * num + 3;
                    break;
                case '4':
                    num = 10 * num + 4;
                    break;
                case '5':
                    num = 10 * num + 5;
                    break;
                case '6':
                    num = 10 * num + 6;
                    break;
                case '7':
                    num = 10 * num + 7;
                    break;
                case '8':
                    num = 10 * num + 8;
                    break;
                case '9':
                    num = 10 * num + 9;
                    break;
            }
        }
        return Integer.toHexString(num).toUpperCase();
    }

    public static String[] convertHexStrToDecimalSplitStr(String str){
        char[] chArr = str.toCharArray();
        String[] newStr = new String[str.length()];
        int result=0,tmp=0,j=0,i=0;
        int numOfOperators = 0;
        while(j<str.length()){
            for (; i < str.length(); i++) {
                if(numOfOperators > 1){
                    return null;
                }
                if (chArr[i] >= '0' && chArr[i] <= '9') {
                    tmp = chArr[i] - '0';
                    numOfOperators = 0;
                } else if (chArr[i] >= 'A' && chArr[i] <= 'F') {
                    tmp = chArr[i] - 'A' + 10;
                    numOfOperators = 0;
                } else if (chArr[i] == '+' || chArr[i] == '-' || chArr[i] == '*' || chArr[i] == '/') {
                    newStr[j++]=Integer.toString(result);
                    newStr[j++]=Character.toString(chArr[i]);
                    result=0;
                    numOfOperators++;
                    continue;
                } else if (chArr[i] == ' '){
                    continue;
                } else {
                    int m=0,n=0;
                    while(chArr[i-m] != ' ') {
                        m++;
                    }
                    while(chArr[i+n] != ' ') {
                        n++;
                    }
                    return null;
                }
                result = 16 * result + tmp;
            }
            newStr[j++]=Integer.toString(result);
            result=0;
        }
        return newStr;
    }
}


