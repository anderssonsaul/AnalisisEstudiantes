
package analisisdatosestudiantes;

import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.nio.file.StandardOpenOption;


//clase usada para crear objeto que escribira en archivo
public class Operar implements Serializable{
    Estudiante  estudiante;
    ObjectOutputStream datoEstudiante=null;
    ObjectInputStream lectura=null;
    Scanner leer = new Scanner(System.in);
    String op="";
    
    ArrayList<Estudiante>ListaEstudiantes=new ArrayList<>();
    
    //Estudiante estudiante=new Estudiante();
    
    //creara el archivo datos_estudiantes.prj
    public void CrearArchivo (){
    try {
            
    File archivo = new File("datos_estudiantes.prj");
if (archivo.exists()) {
       datoEstudiante= new RecuperarData(Files.newOutputStream(Paths.get("datos_estudiantes.prj"), StandardOpenOption.APPEND));
}else{
        datoEstudiante=new ObjectOutputStream(Files.newOutputStream(Paths.get("datos_estudiantes.prj")));
}    
    
    } catch (IOException e){
            System.err.println("Error al crear el archivo: "+e.toString());
        }
    }//fin de metodo CrearArchivo
    
    public void agregarDato(char sn){
        try{
        boolean limpiar=false;
        op="";
        String g="-";
        System.out.println(g.repeat(60));
        System.out.println("               Analisis de Datos Estudiantes");
        System.out.println("                      Ingreso de datos");
        System.out.println(g.repeat(60));
        do{
            System.out.println("\nIngrese los Datos del estudiante: ");
            
            
            if (limpiar) {
                leer.nextLine();
            }
            op=leer.nextLine();
            limpiar=true;
          //  if(op.trim().length()>0){
            //datoEstudiante.writeUTF(op);
           
            if (infoEstudiante(op)) {
                System.out.println("Dato registrado con exito.");
            }else {
            System.out.println("Dato no pudo ser registrado, verifique su cadena de texto.");
            }
                      
            System.out.println("Desea agregar otro estudiante? (s/n)");
            op=leer.next();
            sn=op.charAt(0);
            
        }while(sn=='s'||sn=='S');
        datoEstudiante.close();
        Menu men= new Menu();
        men.MenuPrincipal();
        } catch (Exception e){
            System.err.println("Error al agregarDato: "+e.toString());
        }
    }//fin de agregarDato
    
    public boolean infoEstudiante(String datos){
        try{
            int a=0;
                    int r=0;
        estudiante = new Estudiante();
         estudiante.ListaCurso=new ArrayList<>();
         Curso curso = new Curso();
            // String[] Corchete = datos.split(Pattern.quote("["));
            datos=datos.replace("\"", "");
            datos=datos.replace("{", "");
            datos=datos.replace("}", "");
            datos=datos.replace("]", "");
            datos=datos.trim();
            String[] corchete = datos.split("\\[");
         //   String[] titulo,dato;
            String[] linea;
           
             String[] CursoReprobado;
                     
            for (int i = 0; i < corchete.length; i++) {            
                //tomara los datos del estudiante
                if (i==0) {
                    String[] dtoEstud = corchete[i].split(",");
                    if (dtoEstud.length>0) {
                      //  System.out.println("--------Dato Estudiante---------");
                        for (int j = 0; j < dtoEstud.length; j++) {
                            //System.out.println(dtoEstud[j]);
                            linea=dtoEstud[j].split(":");
                            //posicion 0 es titulo
                            // posicion 1 es dato
                            if (linea[0].length()>0){
                                if (linea[0].toString().trim().toLowerCase().compareTo("nombres")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setNombre(linea[1]);
                                    }    
                                }
                                ///
                                if (linea[0].toString().trim().toLowerCase().compareTo("apellidos")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setApellido(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("carne")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setCarne(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("edad")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setEdad(Integer.valueOf(linea[1].trim()));
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("sexo")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setSexo(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("carrera")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setCarrera(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("totalcreditos")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setCreditoTotal(Integer.valueOf(linea[1].trim()));
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("cantidadcursosaprobados")==0) {
                                    if (linea[1].length()>0) {
                                        estudiante.setCantidadCursoAprobado(Integer.valueOf(linea[1].trim()));
                                    }    
                                }                                
                               
                            }                            
                        }
                 /*
                                System.out.println(estudiante.getNombre());
                                System.out.println(estudiante.getApellido());
                                System.out.println(estudiante.getCarne());
                                System.out.println(estudiante.getEdad());
                                System.out.println(estudiante.getSexo());
                                System.out.println(estudiante.getCarrera());
                                System.out.println(estudiante.getCreditoTotal());
                                System.out.println(estudiante.getCantidadCursoAprobado()); 
                                System.out.println("--------Dato Estudiante---------");
                                */
                    }
                }//fin de if que revisa los datos del estudiante
                
                //tiene cursos aprobados
                if (i==1) { 
                    a=0;
                    String[] CursoAprobado = corchete[i].split(",");
                    if (CursoAprobado.length>0) {
                      //  System.out.println("\n-----Curso Aprobado-----");
                        for (int j = 0; j < CursoAprobado.length; j++) {
                            linea=CursoAprobado[j].split(":");
                            if (linea[0].length()>0){
                                if (linea[0].toString().trim().toLowerCase().compareTo("semestre")==0) {
                                    if (linea[1].length()>0) {
                                        a=a+1;
                                        curso=new Curso();
                                        curso.setNumsemestre(Integer.valueOf(linea[1].trim()));
                                       curso.setCursoAprobado(true);
                                       estudiante.setCantidadCursoAprobado(a);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("nombre")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setNombre(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("codigo")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setCodigo(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("zona")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setZona(Double.valueOf(linea[1].trim()));                                       
                                    }    
                                } 
                                if (linea[0].toString().trim().toLowerCase().compareTo("examenfinal")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setNotaexamenfin(Double.valueOf(linea[1].trim()));
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("fecha")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setFecha(linea[1]);
                                        estudiante.ListaCurso.add(curso);
                                    /*    System.out.println(curso.getNumsemestre());
                            System.out.println(curso.getNombre());
                            System.out.println(curso.getCodigo());
                            System.out.println(curso.getZona());
                            System.out.println(curso.getNotaexamenfin());
                            System.out.println(curso.getFecha());*/
                                    }    
                                }   

                            }                          
                        }

                       // System.out.println("-----Curso Aprobado-----");
                    }
                }//fin de if que revisa los curso aprobados
                
                
                //tiene cursos perdidos
                if (i==2) {
                    r=0;
                    CursoReprobado = corchete[i].split(",");
                    if (CursoReprobado.length>0) {
                       // System.out.println("\n-----Curso Reprobado-----");
                        for (int j = 0; j < CursoReprobado.length; j++) {
                           // System.out.println(CursoReprobado[j]);
                            linea=CursoReprobado[j].split(":");
                           if (linea[0].length()>0){
                                if (linea[0].toString().trim().toLowerCase().compareTo("semestre")==0) {
                                    if (linea[1].length()>0) {
                                        curso=new Curso();
                                        curso.setNumsemestre(Integer.valueOf(linea[1].trim()));
                                       curso.setCursoAprobado(false);
                                       estudiante.setCantidadCursoAprobado(r);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("nombre")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setNombre(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("codigo")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setCodigo(linea[1]);
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("zona")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setZona(Double.valueOf(linea[1].trim()));                                       
                                    }    
                                } 
                                if (linea[0].toString().trim().toLowerCase().compareTo("examenfinal")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setNotaexamenfin(Double.valueOf(linea[1].trim()));
                                    }    
                                }
                                if (linea[0].toString().trim().toLowerCase().compareTo("fecha")==0) {
                                    if (linea[1].length()>0) {
                                        curso.setFecha(linea[1]);
                                        estudiante.ListaCurso.add(curso);
                                    /*    System.out.println(curso.getNumsemestre());
                            System.out.println(curso.getNombre());
                            System.out.println(curso.getCodigo());
                            System.out.println(curso.getZona());
                            System.out.println(curso.getNotaexamenfin());
                            System.out.println(curso.getFecha());*/
                                    }    
                                }   

                            } 
                        }
                       // System.out.println("-----Curso Reprobado-----");
                    }
                }//fin de if que revisa los cursos repetidos            
            }//fin de for que recorreel primer string, separandolo en info de estudiante, curso aprobado y curos reprobado
            

          /*  for (int j = 0; j < estudiante.ListaCurso.size(); j++) {
                    System.out.println( estudiante.ListaCurso.get(j).getNombre() + " --> "+estudiante.ListaCurso.get(j).getCursoAprobado());                   
                }*/
     
             datoEstudiante.writeObject(estudiante);
            return true;    
        }catch (IOException e){
            System.out.println("error al transcribir los datos del estudiante. "+e.toString());
            return false;
        }
    }//fin metodo info Estudiante
    
    public void lecturaArchivo() throws IOException{
        try{
            lectura= new ObjectInputStream(Files.newInputStream(Paths.get("datos_estudiantes.prj")));
            while (true) {
                estudiante=(Estudiante) lectura.readObject();
                ListaEstudiantes.add(estudiante);
            }
        
        }
        catch(EOFException e){}
        catch (ClassNotFoundException e){System.out.println("Clase no encontrada "+e.toString());}
        catch(IOException e){System.out.println("Error al leer el arhivo. "+e.toString());}
        finally{
        lectura.close();
        }
    }
    
    public void datosPersonalesEstudiantes(){
        String vacio=" ";
        String n,a,e,s;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Análisis de Datos de Estudiantes");
        System.out.println("Análisis de Datos");
        System.out.println("Datos personales estudiantes");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Nombres                   Apellidos                 Edad     Sexo     ");
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            //System.out.println( estudiante.ListaCurso.get(i).getNombre() + " --> "+estudiante.ListaCurso.get(i).getCursoAprobado());                             
        n=ListaEstudiantes.get(i).getNombre();
        n=n+vacio.repeat(27-n.length());
        a=ListaEstudiantes.get(i).getApellido();
         a=a+vacio.repeat(27-a.length());
        e=String.valueOf(ListaEstudiantes.get(i).getEdad());
         e=e+vacio.repeat(10-e.length());
        s=ListaEstudiantes.get(i).getSexo();
        s=s+vacio.repeat(10-s.length());
            System.out.println(n+a+e+s);
        }
    }
    public void CantidadEstudiantsMasculinoFemenino(){
    String v=" ";
        int m=0;
        int f=0;
        int o=0;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Análisis de Datos de Estudiantes");
        System.out.println("Análisis de Datos");
        System.out.println("Cantidad de estudiantes maculinos y femeninos");
        System.out.println("----------------------------------------------------------------------");
    String s;
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            s=ListaEstudiantes.get(i).getSexo();
            if (s.toLowerCase().trim().compareTo("femenino")==0) {
                f=f+1;
            }else if (s.toLowerCase().trim().compareTo("masculino")==0){
                m=m+1;
            }else{
            o=o+1;
            }       
        }
        System.out.println("Sexo            Cantidad");
        System.out.println("Maculino           "+String.valueOf(m));
        System.out.println("Femenino           "+String.valueOf(f));
        System.out.println("Otro               "+String.valueOf(o));
    }
    
    public void datosAcademicosEstudiantes(){
        String vacio=" ";
        String n,a,carne,carrera,tc,cs,cr;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Análisis de Datos de Estudiantes");
        System.out.println("Análisis de Datos");
        System.out.println("Datos Academicos de estudiantes");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" Nombres                    Apellidos                   Carne               Carrera                                Tot.Cred  Cur.Aprob Cur.Rep   ");
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            //System.out.println( estudiante.ListaCurso.get(i).getNombre() + " --> "+estudiante.ListaCurso.get(i).getCursoAprobado());                             
        n=ListaEstudiantes.get(i).getNombre();
        n=n+vacio.repeat(27-n.length());
        a=ListaEstudiantes.get(i).getApellido();
         a=a+vacio.repeat(27-a.length());
        carne=ListaEstudiantes.get(i).getCarne();
         carne=carne+vacio.repeat(22-carne.length());
        carrera=ListaEstudiantes.get(i).getCarrera();
        carrera=carrera+vacio.repeat(40-carrera.length());
         tc=String.valueOf(ListaEstudiantes.get(i).getCreditoTotal());
        tc=tc+vacio.repeat(11-tc.length());
         cs=String.valueOf(ListaEstudiantes.get(i).getCantidadCursoAprobado());
        cs=cs+vacio.repeat(11-cs.length());
         cr=String.valueOf(ListaEstudiantes.get(i).getCantidadCursoReprobado());
        cr=cr+vacio.repeat(10-cr.length());

        System.out.println(n+a+carne+carrera+tc+cs+cr);
        }
    }
   
}
 