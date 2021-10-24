package com.company;

import java.util.Objects;

public class Logic {
    Logic(){
        RomanDigits rd = new RomanDigits();
        Main main = new Main();
        String[] help = main.userinput.split(" ");
        ArabicDigits ad = new ArabicDigits();
        for(int i = 0; i < ad.arab.length; i++){
            if(Objects.equals(help[0], ad.arab[i])){
                for(int j = 0; j < ad.arab.length; j++){
                    if(Objects.equals(help[2], ad.arab[j])){
                        ad.arabic = true;
                    }
                    else if(Objects.equals(help[2], rd.rim[i])) {
                        System.out.println("Нельзя использовать разные виды");
                        return;
                    }
                }
            }
        }
        if(!ad.arabic) {
            for (int i = 0; i < rd.rim.length; i++) {
                if (Objects.equals(help[0], rd.rim[i])) {
                    for (int j = 0; j < rd.rim.length; j++) {
                        if (Objects.equals(help[2], rd.rim[j])) {
                            rd.rime = true;
                        } else if(Objects.equals(help[2], ad.arab[j])){
                            System.out.println("Нельзя использовать разные виды");
                            return;
                        }
                    }
                }
            }
        }
        if (!ad.arabic && !rd.rime){
            System.out.println("Такие цифры не может обработать калькулятор");
            return;
        }
        if(ad.arabic){
            switch (help[1]){
                case "+":
                    System.out.println(Integer.valueOf(help[0]) + Integer.valueOf(help[2]));
                    break;
                case "-":
                    System.out.println(Integer.valueOf(help[0]) - Integer.valueOf(help[2]));
                    break;
                case "*":
                    System.out.println(Integer.valueOf(help[0]) * Integer.valueOf(help[2]));
                    break;
                case "/":
                    System.out.println(Integer.valueOf(help[0]) / Integer.valueOf(help[2]));
                    break;
                default:
                    System.out.println("Такого оператора нет");
                    return;
            }
        }
        int indexRim1 = 0;
        int indexRim2 = 0;
        int operation = 0;
        if(rd.rime){
            for(int i = 0; i < rd.rim.length; i++){
                if (help[0].equals(rd.rim[i]))
                    indexRim1 = i;
                if (help[2].equals(rd.rim[i]))
                    indexRim2 = i;
            }

            switch (help[1]){
                case "+":
                    operation = Integer.valueOf(ad.arab[indexRim1]) + Integer.valueOf(ad.arab[indexRim2]);
                    break;
                case "-":
                    operation = Integer.valueOf(ad.arab[indexRim1]) - Integer.valueOf(ad.arab[indexRim2]);
                    break;
                case "*":
                    operation = Integer.valueOf(ad.arab[indexRim1]) * Integer.valueOf(ad.arab[indexRim2]);
                    break;
                case "/":
                    operation = Integer.valueOf(ad.arab[indexRim1]) / Integer.valueOf(ad.arab[indexRim2]);
                    break;
                default:
                    System.out.println("Такого оператора нет");
                    return;
            }
            if (operation < 0)
                System.out.println("Римское число не может быть отрицательным!!!");
            else if (operation == 0)
                System.out.println("Римское число не может быть 0!");
            else
                System.out.println(rd.rimout[operation - 1]);

        }
    }
    }

