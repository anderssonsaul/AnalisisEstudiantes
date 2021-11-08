package analisisdatosestudiantes;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable{
    private int numsemestre; 
    private double zona;
    private double notaexamenfin;
    private String codigo;
    private String nombre;
    private String fecha ;
    private boolean cursoAprobado;
   
    public int getNumsemestre() {
        return numsemestre;
    }

    public void setNumsemestre(int numsemestre) {
        this.numsemestre = numsemestre;
    }

    public double getZona() {
        return zona;
    }

    public void setZona(double zona) {
        this.zona = zona;
    }

    public double getNotaexamenfin() {
        return notaexamenfin;
    }

    public void setNotaexamenfin(double notaexamenfin) {
        this.notaexamenfin = notaexamenfin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getCursoAprobado() {
        return cursoAprobado;
    }

    public void setCursoAprobado(boolean cursoAprobado) {
        this.cursoAprobado = cursoAprobado;
    }
    public void Curso(){
        numsemestre =0;
        zona=0.0;
        notaexamenfin=0.0;
        codigo = "";
        nombre= "";
        fecha= "";
        cursoAprobado=false;
    }



}