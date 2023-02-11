/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package super24;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Carlos
 */
public class Super24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // VARIABLES
        boolean q = true, ga = true, cup = true, busqueda = true, ver = true,pro=true;
        Scanner scan = new Scanner(System.in);
        String productos[][] = new String[3][20];
        String factura[][] = new String[4][20];
        String cupones[][] = new String[2][20];
        //PRUEBA
        //productos[0][0] = "Cebolla";
        //productos[1][0] = "4";
        //productos[2][0] = "0";
        //cupones[0][0] = "xyz1";
        //cupones[0][1] = "adfw";
        //cupones[0][2] = "nblk";
        //cupones[1][0] = "15";
        //cupones[1][1] = "25";
        //cupones[1][2] = "50";
        String usuario, contraseña, opcion, nombre, codigo, porcentaje, precio, cing, b;
        String cliente, nit;
        int  producto, cantidad, mult;
        int total = 0, tod = 0, desc = 0;
        int continuar, c = 0;
        int list = 0, a = 0, k = 2, inv = 0, ing = 0;
        //USUARIO
        usuario = "";
        while(ver){
            System.out.println("Ingrese su usuario:");
            usuario = scan.next();
            System.out.println("Ingrese su contraseña:");
            contraseña = scan.next();
            if(usuario.equals("cajero_201900930") && contraseña.equals("ipc1_201900930")){
                ver = false;
            } else{
                System.out.println("El nombre de usuario o contraseña no son correctos" 
                        + "\nIntentelo de nuevo");
            }
        }
        System.out.println("Bienvenido " + usuario);
        // MENU
        while(q){
            System.out.println("Elija una opcion:"
                    + "\n1. Agregar nuevos productos"
                    + "\n2. Agregar cupones de descuento"
                    + "\n3. Realizar ventas"
                    + "\n4. Realizar reporte"
                    + "\n5. Salir"
                    + "\n");
            opcion = scan.next();
            
            // INGRESAR PRODUCTOS
            if(opcion.equals("1")){
                pro = true;
                while(pro){
                    System.out.println("Ingrese el nombre del producto:");
                    nombre = scan.next();
                    productos[0][ing] = nombre;
                    System.out.println("Ingrese el precio del producto:");
                    precio = scan.next();
                    productos[1][ing] = precio;
                    productos[2][ing] = "0";
                    System.out.println("¿Desea ingresar otro producto?"
                            + "\n1. Si"
                            + "\n2. No"
                            + "\n");
                    continuar = scan.nextInt();
                    if(continuar == 1){
                        System.out.println("");
                    }else if(continuar == 2){
                        pro = false;
                    }else{
                        System.out.println("Opción no valida");
                    } ing++;
                }
                
                // INGRESAR CUPONES
            } else if(opcion.equals("2")){
                k = 0;
                cup = true;
                while(cup){
                    System.out.println("Ingrese el código del cupon");
                    codigo = scan.next();
                    cupones[0][k] = codigo;
                    System.out.println("Ingrese el porcentaje de descuento");
                    porcentaje = scan.next();
                    cupones[1][k] = porcentaje;
                    System.out.println("1. Agregar otro cupon"
                            + "\n2. Regresar al menú");
                    continuar = scan.nextInt();
                    if(continuar == 1){
                        k++;
                    } else if(continuar == 2){
                        cup = false;
                    } else{}
                }
                
                // REALIZAR VENTAS
            } else if(opcion.equals("3")){
                System.out.println("Nombre del cliente: ");
                cliente = scan.next();
                System.out.print("NIT: ");
                nit = scan.next();
                ga = true;
                while(ga){
                    inv = 0;
                    for(int i=0;i<20;i++){
                        if(productos[0][i]!=null){
                            System.out.print((i+1) + ". ");
                            System.out.print(productos[0][i] + ":   ");
                            System.out.println("Q." + productos[1][i]);
                        } else{
                        }
                    }
                    System.out.println("Ingrese el producto");
                    producto = scan.nextInt();
                    System.out.println("Ingrese la cantidad");
                    cantidad = scan.nextInt();
                    factura[0][list] = productos[0][(producto-1)];
                    factura[1][list] = productos[1][(producto-1)];
                    factura[2][list] = String.valueOf(cantidad);
                    mult = Integer.parseInt(productos[1][(producto-1)]);
                    factura[3][list] = String.valueOf((mult*cantidad));
                    total = total + mult*cantidad;
                    inv = Integer.parseInt(productos[2][producto-1]) + cantidad;
                    productos[2][producto-1] = String.valueOf(inv);
                    System.out.println("1. Agregar otro producto" 
                            + "\n2. Finalizar venta");
                    continuar = scan.nextInt();
                    if(continuar == 1){
                        list++;
                        //FACTURA
                    } else if(continuar == 2){
                        System.out.println("¿Ingresar código de descuento?" 
                                + "\n1. Si" 
                                + "\n2. No");
                        continuar = scan.nextInt();
                        if(continuar == 1){
                            System.out.println("Ingrese el código");
                            cing = scan.next();
                            //BUSCAR EL CUPON
                            a = 0;
                            for(int i=0;i<=k;i++){
                                b = cupones[0][i];
                                if(cing.equals(b)){
                                    //System.out.println("encontrado");
                                    c = i;
                                } else{
                                    //System.out.println("no encontrado");
                                }
                            }
                            System.out.println(cupones[1][c]);
                            desc = Integer.parseInt(cupones[1][c]);
                            tod = total - total*desc/100;
                            
                        } else{}
                        ga = false;
                        System.out.println("SUPER-25" 
                                + "\nAtendió: " + usuario 
                                + "\n" + cliente 
                                + "\n" + nit
                                + "\nProductos: ");
                        for(int i=0;i<20;i++){
                        if(factura[0][i]!=null){
                            System.out.print(factura[2][i] + " ");
                            System.out.print(factura[0][i] + ": ");
                            System.out.print("Q." + factura[1][i] + "c/u  ");
                            System.out.println(factura[3][i]);
                        } else{
                        }
                    }
                        System.out.println("El total es de: Q." + total);
                        System.out.println("Su descuento es de: %" + cupones[1][c]);
                        System.out.println("Total final: Q" + tod);
                        System.out.println("");
                    } else{
                        System.out.println("Opción no valida");
                    }
                }
                
                
                //REPORTE
            } else if(opcion.equals("4")){
                for(int i=0;i<20;i++){
                        if(productos[0][i]!=null){
                            System.out.print((i+1) + ". ");
                            System.out.print(productos[0][i] + ":   ");
                            System.out.println(productos[2][i]);
                        } else{
                        }
                    }
                //SALIR
            } else if(opcion.equals("5")){
                q = false;
            } else {
                System.out.println("Ingresar valor valido, Por favor.\n");
            }
        }
    }
    
}

