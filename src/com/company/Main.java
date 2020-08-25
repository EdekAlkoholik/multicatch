package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // najgorsza możliwa obsługa wyjątków w javie
        try{
            buissnesMethod();
        } catch (Exception ex){
            // nieważne jaki wyjątek, nie wiemy nawet co się stało, na podstawie tego bloku nie znajdziemy błędu
        }

        try{
            buissnesMethod();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } catch(BusinessException ex){              // musi być wcześniej bo dziedziczy po IllegalStateException
            System.out.println(ex.getMessage());    // inaczej macierzysty wyjątek wyłapie wszystko zanim ten się pojawi
        } catch(IllegalStateException ex){
            System.out.println(ex.getMessage());
        }

        // można łączyć w jednym bloku catch kilka wyjątków
        try{
            buissnesMethod();
        } catch(BusinessException ex){                      // potomków nie można łączyć
            System.out.println(ex.getMessage());
        } catch(IOException | IllegalStateException ex) {   // dwa wyjątki w jednym catch, łączymy | pipeline (or)
            System.out.println(ex.getMessage());
            //ex = new IOException();                       // ex jest niejawnie final, nie da się go zmienić
        }



    }

    public static void buissnesMethod() throws IOException, IllegalStateException, BusinessException {

    }




}
