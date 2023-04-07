package com.company;

import java.time.LocalTime;

public class Clock extends Thread{
//    Kod wykonywany przez wątek
//    Następnie w metodzie run()
//
//    dodaj pętlę nieskończoną
//    w pętli odczytuj i drukuj bieżący czas
//    LocalTime time = LocalTime.now();
//   System.out.printf("%02d:%02d:%02d\n",
//           time.getHour(),
//           time.getMinute(),
//           time.getSecond());
//    Usypianie wątku
//    Prawdopodobnie ten sam czas drukuje się wielokrotnie. Uśpij wątek na jedną sekundę (1000 milisekund) wprowadzając wywołanie metody sleep()
    @Override
    public void run() {
        while (true) {
            LocalTime time = LocalTime.now();
            System.out.printf("%02d:%02d:%02d\n",
                    time.getHour(),
                    time.getMinute(),
                    time.getSecond());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Clock().start();
    }
}