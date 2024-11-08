package com.ejemplo;
import java.util.concurrent.*;


public class Casa {
  

    public static void main(String[] args) {
        // Crear un ExecutorService para gestionar los hilos
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Crear las tareas Callable
        Callable<String> lavarRopa = new Tarea("Lavando ropa", 3000);
        Callable<String> secarPlatos = new Tarea("Secando platos", 2000);

        // Enviar las tareas al ExecutorService y obtener los Futures
        Future<String> lavarFuture = executorService.submit(lavarRopa);
        Future<String> secarFuture = executorService.submit(secarPlatos);

        try {
            // Obtener los resultados de los objetos Future
            System.out.println(lavarFuture.get());
            System.out.println(secarFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // Usar un bloque synchronized para mostrar la seguridad de los hilos
        synchronized (Casa.class) {
            System.out.println("¡Ambas tareas están completas!");
        }
    }

}
