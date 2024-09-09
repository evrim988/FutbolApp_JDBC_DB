package org.example;

import org.example.entites.Futbolcu;
import org.example.repository.FutbolcuRepository;
import org.example.repository.TakimRepository;
import org.example.utility.EMevki;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TakimRepository takimRepository = new TakimRepository();
        FutbolcuRepository futbolcuRepository = new FutbolcuRepository();

        //Takim takim1 = new Takim("Fenerbahçe", LocalDate.of(1907,7,19),"Ali Koç",2.500000);
        //Takim takim2 = new Takim("Galatasaray", LocalDate.of(1905,7,19),"Fatih Terim",3.500000);
        //takimRepository.save(takim2);

       /* Takim takim = new Takim("saf", LocalDate.of(1905,7,19),"Fatih Terim",3.500000);
        takimRepository.save(takim);*/


        //takimRepository.hardDelete(3);
        //takimRepository.softDelete(4);
        takimRepository.findAll().forEach(System.out::println);

       /* Optional<Takim> byId = takimRepository.findById(2);
        if (byId.isPresent()) {
            Takim takim = byId.get();
            takim.setState(0);
            takimRepository.update(takim);
        }*/

        /*Futbolcu futbolcu = new Futbolcu(1,"Evrim","Çalışkan",LocalDate.parse("1998-07-22"), EMevki.Defans,10,68);
        futbolcuRepository.save(futbolcu);*/

        System.out.println("----------------------------------------------------------------");

        /*Futbolcu futbolcu = new Futbolcu(1,"asd","asdfa", LocalDate.parse("1998-07-22"), EMevki.Defans,10,68);
        futbolcuRepository.save(futbolcu);*/

        //futbolcuRepository.hardDelete(3);

        futbolcuRepository.findAll().forEach(System.out::println);

    }
}