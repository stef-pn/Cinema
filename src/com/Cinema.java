/*Una sala cinematografica è dotata di 300 posti suddivisi in 3 zone da 100 posti: sinistra, 
destra, centrale.
Realizzare un programma che, chiedendo il numero di spettatori all'utente (valore da 
incapsulare nel modo più efficace possibile), assegni loro i posti occupandoli con i rispettivi
numeri dei biglietti d'ingresso, i quali devono essere unici per tutta la sala, distribuendoli
equamente e automaticamente nelle tre zone della sala. Esempi:
 7 spettatori saranno ripartiti 2 a sinistra, 3 al centro, 2 a destra;
 20 spettatori saranno ripartiti 7 a sinistra, 7 al centro, 6 a destra.
Stampare a fine "spettacolo" un riepilogo della distribuzione dei posti in ciascuna zona della 
sala attraverso i numeri dei biglietti, nonché un totale sull'affluenza; esempio di riepilogo da 
mostrare su terminale:
Zona sinistra: 2 5 8 11 14 17 20
Zona centrale: 1 4 7 10 13 16 19
Zona destra: 3 6 9 12 15 18
Assegnati 7 posti a sinistra, 7 posti al centro, 6 posti a destra; 
totale 20 spettatori.
Un possibile approccio al problema, implementando gli opportuni metodi necessari:
1. Generare biglietti univoci numerati ricevendo un input dall'utente (incapsulamento)
2. Assegnare i biglietti a rotazione alle tre zone della sala
3. Stampare il numero di posti occupati per ogni zona e il totale.*/


package com;

import java.util.Scanner;
import java.util.ArrayList;


public class Cinema {
    ArrayList<Integer> zonaSinistra = new ArrayList<>();
    ArrayList<Integer> zonaCentro = new ArrayList<>();
    ArrayList<Integer> zonaDestra = new ArrayList<>();
  
    private int numeroSpettatori;
    
    Scanner input = new Scanner(System.in);

    public void setnumeroSpettatori(int numeroSpettatori){
        boolean ancora = true;

        do {
            if (numeroSpettatori > 0 && numeroSpettatori <= 300) {
                this.numeroSpettatori = numeroSpettatori;
                ancora = false;

            } else if (numeroSpettatori > 300) {
                int spettatoriEccesso = numeroSpettatori - 300;
                System.out.println("La sala ha raggiunto la capienza massima di 300 posti. " + spettatoriEccesso + " spettatori sono in eccesso e verranno smistati nei prossimi spettacoli");
                this.numeroSpettatori = 300;
                ancora = false;

            } else {
                System.out.println("Il numero di spettatori non può essere negativo, reinseriscilo:");
                numeroSpettatori = input.nextInt();

            }
            
        } while (ancora);
    
    }

    public int getnumeroSpettatori() { return numeroSpettatori; }

    public void distribuzione(){

        for (int i = 1; i <= numeroSpettatori; i++) {

            if (i % 3 == 0){
            zonaCentro.add(i);

            } else if (i % 3 == 1){
            zonaSinistra.add(i);

            } else {
            zonaDestra.add(i);
            }
        }
    }

    public void stampaPosti(){
        System.out.println("Numero totale di spettatori in sala: " + (int)(zonaSinistra.size() + zonaCentro.size() + zonaDestra.size()));


        System.out.print("Zona sinistra: ");
        for(int i = 0; i < zonaSinistra.size(); i++) {
            System.out.print(zonaSinistra.get(i) + " ");
        }

        System.out.println();

        System.out.print("Zona centrale: ");
        for(int i = 0; i < zonaCentro.size(); i++){
            System.out.print(zonaCentro.get(i) + " ");
        }

        System.out.println();

        System.out.print("Zona destra: ");
        for(int i = 0; i < zonaDestra.size(); i++){
            System.out.print(zonaDestra.get(i) + " ");
        }

        System.out.println();
        System.out.println(zonaSinistra.size() + " posti a sinistra, " + zonaCentro.size() + " posti al centro, " + zonaDestra.size() + " posti a destra");
    }
}


