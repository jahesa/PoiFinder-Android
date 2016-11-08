package edu.unsam.algo3.poifinder.model;

/**
 * Created by Javier on 06/11/2016.
 */

public class Horario {

    private int horaAperturaMañana;
    private int horaAperturaTarde = 0;
    private int minutoAperturaMañana;
    private int minutoAperturaTarde = 0;
    private int horaCierreMañana;
    private int horaCierreTarde = 0;
    private int minutoCierreMañana;
    private int minutoCierreTarde = 0;

    public Horario(int abreHoraMañana, int abreMinMañana, int cierraHoraMañana, int cierraMinMañana, int abreHoraTarde,
                                  int abreMinTarde, int cierraHoraTarde, int cierraMinTarde)
    {
        horaAperturaMañana = abreHoraMañana;
        minutoAperturaMañana = abreMinMañana;
        horaCierreMañana = cierraHoraMañana;
        minutoCierreMañana = cierraMinMañana;
        horaAperturaTarde = abreHoraTarde;
        minutoAperturaTarde = abreMinTarde;
        horaCierreTarde = cierraHoraTarde;
        minutoCierreTarde = cierraMinTarde;
    }

    public Horario(int abreHoraMañana, int abreMinMañana, int cierraHoraMañana, int cierraMinMañana)
    {
        horaAperturaMañana = abreHoraMañana;
        minutoAperturaMañana = abreMinMañana;
        horaCierreMañana = cierraHoraMañana;
        minutoCierreMañana = cierraMinMañana;
    }

    public boolean checkHora(int hora, int minuto)
    {
        return entreHora(hora, minuto, horaAperturaMañana, minutoAperturaMañana, horaCierreMañana, minutoCierreMañana) ||
                entreHora(hora, minuto, horaAperturaTarde, minutoAperturaTarde, horaCierreTarde, minutoCierreTarde);

    }

    private boolean entreHora(int horaUsuario, int minutoUsuario, int horaAperturaDato, int minutoAperturaDato, int horaCierreDato,
                              int minutoCierreDato)
    {
        if (horaUsuario > horaAperturaDato && horaUsuario < horaCierreDato)
        {
            return true;
        }
        else
        {
            return (horaUsuario == horaCierreDato && minutoUsuario <= minutoCierreDato) || (horaUsuario == horaAperturaDato && minutoUsuario >= minutoAperturaDato);
        }
    }

}