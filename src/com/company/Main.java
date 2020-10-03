package com.company;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {


            System.out.println ("Введите кол-во работающих кассет");
            Scanner scn = new Scanner(System.in);
            int[] currencies = new int[scn.nextInt()];

            System.out.println("Введите номиналы в кассетах");
            for (int i = 0; i < currencies.length; i++) {
                currencies[i] = scn.nextInt();
            }

            System.out.println("Введите сумму для размена");
            int amount = scn.nextInt();

            long start = System.nanoTime();

            System.out.println(
                    "Количество возможных способов размена : " +
                            coinchange(0, amount, currencies, ""));

            long finish = System.nanoTime();
            long elapsed = finish - start;
            System.out.println("Прошло времени, мс: " + elapsed / 1000000);

        }

        public static int coinchange(int ci, int remaining, int[] currencies,
                                     String paid) {
            if (remaining == 0) {

                System.out.println(paid);

                return 1;
            }
            if (remaining < 0) {

                return 0;
            }

            int res = 0;
            for (int i = ci; i < currencies.length; i++) {

                res += coinchange(i, remaining - currencies[i], currencies,
                        paid + Integer.toString(currencies[i]) + ", ");

            }

            return res;

        }

    }