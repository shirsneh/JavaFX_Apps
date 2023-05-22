package org.example.Calculator;

import javafx.application.Platform;

import java.io.IOException;

public class DecCalc {
    public String decCalc (String str){
        int result = 0;
        String[] splitStr = splitStr(str);
        if(splitStr == null){
            System.exit(-1);
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
            Platform.runLater(() -> {
                org.example.App.setWindowTitle("My calculator");
                try {
                    org.example.App.setContent("/calc");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
        return String.valueOf(result);
    }

    public static String[] splitStr(String str){
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
                }  else if (chArr[i] == '+' || chArr[i] == '-' || chArr[i] == '*' || chArr[i] == '/') {
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
                result = result + tmp;
            }
            newStr[j++]=Integer.toString(result);
            result=0;
        }
        return newStr;
    }
}



