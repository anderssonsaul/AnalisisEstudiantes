package analisisdatosestudiantes;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable{
    private String nombre;
    private String apellido;
    private String carrera;
    private String carne;
    private int edad;
    private int creditoTotal;
    private int cantidadCursoAprobado;
    private int cantidadCursoReprobado;
    private String sexo;
    private Curso curso;
    public ArrayList<Curso>ListaCurso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCreditoTotal() {
        return creditoTotal;
    }

    public void setCreditoTotal(int creditoTotal) {
        this.creditoTotal = creditoTotal;
    }

    public int getCantidadCursoAprobado() {
        return cantidadCursoAprobado;
    }

    public void setCantidadCursoAprobado(int cantidadCursoAprobado) {
        this.cantidadCursoAprobado = cantidadCursoAprobado;
    }
    
    public int getCantidadCursoReprobado() {
        return cantidadCursoReprobado;
    }

    public void setCantidadCursoReprobado(int cantidadCursoReprobado) {
        this.cantidadCursoReprobado = cantidadCursoReprobado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


  /*  public ArrayList<Curso> getListaCurso() {
        return ListaCurso;
    }

    public void setListaCurso(Curso curso) {
        this.ListaCurso.add(curso);
    }*/
    
    public void Estudiante(){
      ListaCurso = new ArrayList<>();
        nombre="";
        apellido="";
        carrera="";
        carne="";
        edad=0;
        creditoTotal=0;
        cantidadCursoAprobado=0;
        cantidadCursoReprobado=0;
        sexo="";  
       curso= new Curso();
    }

}