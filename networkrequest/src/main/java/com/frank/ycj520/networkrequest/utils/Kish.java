package com.frank.ycj520.networkrequest.utils;

import java.util.ArrayList;

public class Kish {

    public static int getMember( int number, String kishRule){
        int m = 0;
        switch (kishRule){
            case "A":m = 1;
                break;
            case "B1":{
                switch (number){
                    case 1: case 2: case 3: case 4:m = 1;break;
                    case 5: case 6: default:m = 2;break;
                }
            }
                break;
            case "B2":
                switch (number){
                    case 1: case 2: case 3: m = 1;break;
                    case 4: case 5: case 6: default:m = 2;break;
                }
                break;
            case "C":
                switch (number){
                    case 1: case 2: m = 1;break;
                    case 3: case 4: m = 2;break;
                    case 5: case 6: default:m = 3;break;
                }
                break;
            case "D":
                switch (number){
                    case 1: m = 1;break;
                    case 2: case 3: m = 2;break;
                    case 4: m = 3;break;
                    case 5: case 6: default:m = 4;break;
                }
                break;
            case "E1":
                switch (number){
                    case 1: m = 1;break;
                    case 2: m = 2;break;
                    case 3: case 4: case 5: m = 3;break;
                    case 6: default:m = 5;break;
                }
                break;
            case "E2":
                switch (number){
                    case 1: m = 1;break;
                    case 2: case 3: m = 2;break;
                    case 4: m = 4;break;
                    case 5: case 6: default:m = 5;break;
                }
                break;
            case "F":
                switch (number){
                    case 1: m = 1;break;
                    case 2: m = 2;break;
                    case 3: m = 3;break;
                    case 4: m = 4;break;
                    case 5: m = 5;break;
                    case 6: default:m = 6;break;
                }
                break;
                default:break;
        }
        return m;
    }
}
