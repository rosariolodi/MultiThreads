package com.ejemplo;

import java.util.concurrent.Callable;

class Tarea implements Callable<String>{

    private String nombreTarea;
    private int duracion;

    public Tarea(String nombreTarea, int duracion){
        this.nombreTarea = nombreTarea;  
        this.duracion = duracion;
    }


    @Override
    public String call() throws Exception {

        try {
            System.out.println(nombreTarea + " comenzó...");
            Thread.sleep(duracion);  // Simular la duración de la tarea
            return nombreTarea + " terminó!";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return nombreTarea + " fue interrumpido!";
        }
    }
    
}