package com;

import java.util.Scanner;

public class CinemaTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cinema mioCinema = new Cinema();

        System.out.println("Inserisci il numero di spettatori (da 1 a 300):");
        mioCinema.setnumeroSpettatori(input.nextInt());

        mioCinema.distribuzione();
        mioCinema.stampaPosti();

        input.close();
        System.exit(0);
    }

}
