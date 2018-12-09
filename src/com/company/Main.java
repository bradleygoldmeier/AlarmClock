package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Clock clock = new Clock();

        while(true){
            clock.updateAndPrintTime();
        }
    }
}
