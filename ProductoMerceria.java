/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenentornos;

/**
 * Gestiona los productos de la merceria
 * @author samur
 */
public class ProductoMerceria {
    private String nombre;
    private double precio;
    private int cantidadDisponible;
    
   /**
    * Constructor
    * @param nombre Nombre del producto como un String
    * @param precio Valor double positivo entendido en €
    * @param cantidadDisponible Valor int positivo correspondiente a la cantidad de producto disponible
    */
    

    public ProductoMerceria(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }
    
    /**
     * Obtiene el nombre de cada producto
     * @return devuelve el nombre del producto en tipo String.
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el precio de cada producto
     * @return devuelve el precio del producto en tipo double
     */

    public double getPrecio() {
        return precio;
    }
    
    /**
     * Obtiene la cantidad disponible de cada producto
     * @return devuelve la cantidad disponible de producto en tipo int
     */

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    
    /**
     * Esto cumple la función de vender el producto que queramos.
     * @param cantidad Cantidad de producto a ser vendida
     * @see <a href="GestionMerceria.html#agregarProducto">Si no hay nignún producto, nos avisará por consola</a>
     */

    public void venderProducto(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
           // System.out.println("Producto vendido: " + nombre + " x" + cantidad);
        } else {
            //System.out.println("No hay suficiente cantidad disponible de " + nombre);
        }
    }
    
    /**
     * Obtiene una representación de la información del producto en una cadena.
     * @return devuelve una cadena de texto combinando el nombre, el precio y la cantidad disponible del producto.
     */

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad Disponible: " + cantidadDisponible;
    }
}
