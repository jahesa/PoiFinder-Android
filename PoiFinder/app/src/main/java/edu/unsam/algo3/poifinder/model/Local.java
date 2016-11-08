package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Local extends Poi {

    // -------------------------------------------

    // FALTA

    // -------------------------------------------



    private String categoria;
    public ArrayList<String> palabrasClaves = new ArrayList<String>();
    private String direccion;

    //Acciones

    public Local(int id)
    {
        super(id);
    }

    public String getCategoria () {
        return categoria;
    }

    public void setCategoria (String categoria) {
        this. categoria = categoria;
    }

    public ArrayList<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(ArrayList<String> servicios) {
        this.palabrasClaves = servicios;
    }

    public void agregarPalabrasClaves(String clave) {
        palabrasClaves.add(clave);
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void adddia(String dia) {
        diasAtencionList.add(dia);
    }

    public void sethorarios(int horaap, int minap, int horacierr, int mincierr) {
        horarios = new Horario(horaap, minap, horacierr, mincierr);
    }

    public void sethorarios(int horaapMañana, int minapMañana, int horacierrMañana, int mincierrMañana, int horaapTarde,
                            int minapTarde, int horacierrTarde, int mincierrTarde)
    {
        horarios = new Horario(horaapMañana, minapMañana, horacierrMañana, mincierrMañana, horaapTarde, minapTarde,
                horacierrTarde, mincierrTarde);
    }

    @Override
    boolean estaAbierto(String nombre, String dia, int hora, int minuto)
    {
        if(horarios.checkHora(hora, minuto) && diasAtencionList.contains(dia))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //protected void matcherXNombre(String _nombre) {
//        return (palabrasClaves.contains(_nombre) || categoria == _nombre || this.nombre.startsWith(_nombre.toLowerCase));
//    }

}
