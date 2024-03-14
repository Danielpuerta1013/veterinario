package org.example;

import org.example.paqueteDos.Animal;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int opcion;
        boolean bandera=true;
        Scanner sc=new Scanner(System.in); // inicializo el scanner para la entrada de datos se le pone el nombre sc
        Map<String,List<Animal>>clasificaciones=new TreeMap<>(); // se crea el treemap para clasificar los animales
        List<Animal> animales=new ArrayList<>(); // se crea un arraylist para almacenar los animales

        while (bandera){
            System.out.print("ingrese 1 para agregar un animal y 0 para salir ");
            opcion=sc.nextInt();
            if (opcion==0){
                bandera=false;
                break;
            } else if (opcion==1) {
                sc.nextLine();
                System.out.print("ingrese el nombre del animal a agregar: ");
                String nombreAnimal=sc.nextLine();
                System.out.print("Ingrese el tipo del animal: "+nombreAnimal+", terreste,volador o acuatico: "); // se pide el tipo del animal al usuario
                String tipoAnimal=sc.nextLine(); // se guarda en una variable el tipo
                System.out.print("Ingrese el genero del animal: "+nombreAnimal+", M,H: "); // se pide el genero del animal al usuario
                String generoAnimal=sc.nextLine(); // se guarda en una variable el tipo
                Animal animal=new Animal(); // creo el objeto con la información solicitada por el usuario
                animal.setNombre(nombreAnimal);
                animal.setGenero(generoAnimal);
                animal.setTipo(tipoAnimal);
                animales.add(animal);

            }else {
                System.out.println("opcion incorrecta");
            }

        }

        for(Animal animal:animales){ // se recorre el arraylist animales
            if (!clasificaciones.containsKey(animal.getTipo())) { // verifica que en el tree map exista la llave del tipo si no lo crea
                clasificaciones.put(animal.getTipo(), new ArrayList<>());
            }
            clasificaciones.get(animal.getTipo()).add(animal); // una vez cree la llave se agrega el animal
        }

        for (Map.Entry<String, List<Animal>> entry : clasificaciones.entrySet()) { // se recorre el treemap y se imprime
            System.out.println(entry.getKey() + ":");
            for (Animal animal : entry.getValue()) {
                System.out.println("\t" + animal.getNombre());
            }
        }


    }

}