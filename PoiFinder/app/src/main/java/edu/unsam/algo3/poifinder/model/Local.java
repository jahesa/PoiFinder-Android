package edu.unsam.algo3.poifinder.model;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Local extends Poi {

    private String categoria;

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

//    protected void matcherXNombre(final String nombre) {
//        return (this.claves.includes(_nombre) || this.categoria == _nombre || this.nombre.startsWith(_nombre));
 //   }

}
