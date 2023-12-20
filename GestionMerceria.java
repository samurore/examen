/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenentornos;


/**
 * Aplicación para gestión de mercería.
 * 
 * @author Sr.GPT
 * @version 1.1
 * 
 */
import com.stopwatch.IStopWatch;
import com.stopwatch.StopWatch;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionMerceria {

    private static void ordenaNumeros() {
        //Creo la matriz
        int[] numeros=new int[100];
        //Relleno la matriz
        for(int i=0;i<numeros.length;i++){
            numeros[i]=(int)(Math.random()*100 + 1);
        }
        //ordeno
        for (int i = 0; i < numeros.length-1; i++) {
            for (int j = i+1; j < numeros.length; j++) {
                if(numeros[i]>numeros[j]){
                    int temp=numeros[i];
                    numeros[i]=numeros[j];
                    numeros[j]=temp;
                }
            }
        }
    }
    public ArrayList<ProductoMerceria> inventario;

    /**
     * gestionMercería gestiona la mercería.
     */
    public GestionMerceria() {
        inventario = new ArrayList<>();
    }

    /**
     * Constructor
     * @param nombre Nombre del producto que queremos agregar al inventario
     * @param precio Precio en tipo double que le queremos establecer al producto
     * @param cantidadDisponible cantidad en tipo int de producto que queremos añadir
     */
    public void agregarProducto(String nombre, double precio, int cantidadDisponible) {
        ProductoMerceria nuevoProducto = new ProductoMerceria(nombre, precio, cantidadDisponible);
        inventario.add(nuevoProducto);
        //System.out.println("Producto agregado: " + nuevoProducto);
    }
    
    /**
     * Ver los productos que hay en el inventario.
     */

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            //System.out.println("El inventario está vacío.");
        } else {
            //System.out.println("Inventario de la mercería:");
            for (ProductoMerceria producto : inventario) {
               // System.out.println(producto);
            }
        }
    }
    /**
     * Vender el producto que queramos del inventario
     * @param nombre Nombre del producto que queremos vender
     * @param cantidad Cantidad en int del producto que queremos vender
     */

    public void venderProducto(String nombre, int cantidad) {
        boolean encontrado = false;
        for (ProductoMerceria producto : inventario) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.venderProducto(cantidad);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            //System.out.println("Producto no encontrado en el inventario.");
        }
    }

    /**
     * Gestiona mercería
     * @param args No tratamos argumentos por el momento
     * @throws NumberFormatException El dato introducido debe ser numérico.
     */
    public static void main(String[] args) throws NumberFormatException{ 
        GestionMerceria gestionMerceria = new GestionMerceria();
        Scanner scanner = new Scanner(System.in);
        IStopWatch relojStopWatch = StopWatch.create();
        relojStopWatch.start();
        int lista[]={1,2,3,4};
         for(int i=0;i<100000;i++){
             gestionMerceria.mostrarInventario();
             gestionMerceria.agregarProducto("hola", 5, 10);
             gestionMerceria.venderProducto("hola", 10);
        }
        
        System.out.println("Resultado prueba de rendimiento: "+ relojStopWatch.elapsedMillis()/1000000.0);
        relojStopWatch.stop();
        boolean ejecucion = true;

        while (ejecucion) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar producto al inventario");
            System.out.println("2. Mostrar inventario de la mercería");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
        try{
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: $");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea después del número
                    System.out.print("Ingrese la cantidad disponible del producto: ");
                    int cantidad = scanner.nextInt();
                    gestionMerceria.agregarProducto(nombre, precio, cantidad);
                    break;
                case 2:
                    gestionMerceria.mostrarInventario();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a vender: ");
                    String productoVender = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVender = scanner.nextInt();
                    gestionMerceria.venderProducto(productoVender, cantidadVender);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    ejecucion = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                     }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }
}
