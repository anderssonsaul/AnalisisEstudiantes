/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdatosestudiantes;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ander
 */
public class Menu {
    Scanner leer = new Scanner(System.in);
    String op="";
    Operar operar=new Operar();
    
    public void MenuPrincipal() throws IOException{
        op="";
        System.out.println("----------------------------------------");
        System.out.println("    Análisis de Datos de Estudiantes");
        System.out.println("----------------------------------------");
        System.out.println("\n1. Ingreso de datos");
        System.out.println("2. Análisis de datos");
        System.out.println("3. Salir");
        System.out.println("\nIngrese una opción:");
        op=leer.next();
        
        if(op.trim().toUpperCase().compareTo("1")==0){
            operar.CrearArchivo();
            operar.agregarDato('S');
        }
        if (op.trim().toUpperCase().compareTo("2")==0) {
            operar.lecturaArchivo();
        System.out.println("----------------------------------------");
        System.out.println("    Análisis de Datos de Estudiantes");
        System.out.println("            Análisis de Datos");
        System.out.println("----------------------------------------");
        System.out.println("1. Datos personales de estudiantes");
        System.out.println("2. Cantidad de estudiantes femeninos y masculinos");
        System.out.println("3. Mejor promedio de cada carrera");
        System.out.println("4. Datos academicos de estudiantes");
        System.out.println("5. Constancia de cursos aprobados");
        System.out.println("6. Salir");
        System.out.println("\nSeleccione el reporte a generar");
        op=leer.next();
        switch(Integer.valueOf(op)){
            case 1:
                operar.datosPersonalesEstudiantes();
                System.out.println("Ingrese cualquier letra para regresar al menu principal ");
                leer.next();
                break;
            case 2:
                operar.CantidadEstudiantsMasculinoFemenino();
                System.out.println("Ingrese cualquier letra para regresar al menu principal ");
                leer.next();
                MenuPrincipal();
                break;
            case 3:
                System.out.println("Sistema en mantenimiento, sentimos las molestas");
                System.out.println("Ingrese cualquier letra para regresar al menu principal ");
                leer.next();
                MenuPrincipal();
                break;
            case 4:
                operar.datosAcademicosEstudiantes();
                System.out.println("Ingrese cualquier letra para regresar al menu principal ");
                leer.next();
                MenuPrincipal();
                break;
            case 5:
                System.out.println("Sistema en mantenimiento, sentimos las molestas");
                System.out.println("Ingrese cualquier letra para regresar al menu principal ");
                leer.next();
                MenuPrincipal();
                break;
            case 6:
                System.exit(0);
                break;
                
            default:
                System.out.println("Opcion no valida, intente nuevamente");
                this.MenuPrincipal();
        }
        }
         if (op.trim().toUpperCase().compareTo("3")==0) {
         System.exit(0);
         }
    }
    
    
}
