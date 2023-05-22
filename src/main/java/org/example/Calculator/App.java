package org.example.Calculator;

import org.example.CalculatorController;

public class App {

    public static int mul(String a,String b){
        int numA = convertStrToInt(a);
        if(numA == -1){
            return -1;
        }
        int numB = convertStrToInt(b);
        if(numB == -1){
            return -1;
        }
        return numA*numB;
    }

    public static int div(String a,String b){
        int numA = convertStrToInt(a);
        if(numA == -1){
            return -1;
        }
        int numB = convertStrToInt(b);
        if(numB == -1){
            return -1;
        }
        if(numB == 0){
            CalculatorController.showAlert("Arithmetic error","Error: trying to divide by 0");
            return -1;
        }
        return numA/numB;
    }

    public static int add(String a,String b){
        int numA = convertStrToInt(a);
        if(numA == -1){
            return -1;
        }
        int numB = convertStrToInt(b);
        if(numB == -1){
            return -1;
        }
        return numA+numB;
    }

    public static int sub(String a,String b){
        int numA = convertStrToInt(a);
        if(numA == -1){
            return -1;
        }
        int numB = convertStrToInt(b);
        if(numB == -1){
            return -1;
        }
        return numA-numB;
    }

    public static int convertStrToInt(String str){
        char[] chArr = str.toCharArray();
        int result=0,tmp=0;
        boolean neg = false;
        for(int i=0;i<str.length();i++){
            if(chArr[i]>='0'&& chArr[i]<='9'){
                tmp = chArr[i]-'0';
            }else if(chArr[i] == '-' ||chArr[i] == ' ') {
                if(chArr[i] == '-'){
                    neg = true;
                }
                continue;
            }
            result = 10*result + tmp;
        }
        if(neg){
            return -result;
        }else {
            return result;
        }
    }
}
