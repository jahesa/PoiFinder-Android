package edu.unsam.algo3.poifinder.util;

import android.support.annotation.NonNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import edu.unsam.algo3.poifinder.model.Banco;
import edu.unsam.algo3.poifinder.model.CGP;
import edu.unsam.algo3.poifinder.model.Colectivo;
import edu.unsam.algo3.poifinder.model.Local;
import edu.unsam.algo3.poifinder.model.Poi;


public class CustomPoiDeserializer implements JsonDeserializer<Poi> {

    public Poi deserialize(JsonElement json, Type typeOfT,
                           JsonDeserializationContext context) throws JsonParseException {

        JsonObject jo = json.getAsJsonObject();
        String type = jo.get("tipo").getAsString();
        try {
            Method getPoiMethod = CustomPoiDeserializer.class.getMethod("get"+type, JsonObject.class);
            return (Poi)  getPoiMethod.invoke(this, jo);
        } catch (SecurityException e) {  }
        catch (NoSuchMethodException e) {  }
        catch (IllegalArgumentException e) {  }
        catch (IllegalAccessException e) {  }
        catch (InvocationTargetException e) {  }

        return null;
    }

    @NonNull
    public Poi getcgp(JsonObject jo) {
        CGP cgp = new CGP(jo.get("id").getAsInt());
        cgp.setNombre(jo.get("nombre").getAsString());
        cgp.setDireccion(jo.get("direccion").getAsString());
        cgp.setDirector(jo.get("director").getAsString());
        cgp.setTel(jo.get("telefono").getAsString());
        cgp.setBarrio(jo.get("barrio").getAsString());

        return cgp;
    }

    @NonNull
    public Poi getlocal(JsonObject jo) {
        Local local = new Local(jo.get("id").getAsInt());
        local.setNombre(jo.get("nombre").getAsString());
        local.setDireccion(jo.get("direccion").getAsString());
        for (JsonElement je : jo.get("palabrasClaves").getAsJsonArray()) {
            local.agregarPalabrasClaves(je.getAsString());
        }
        local.setCategoria(jo.get("categoria").getAsString());
        return local;
    }

    @NonNull
    public Poi getbanco(JsonObject jo) {
        Banco banco = new Banco(jo.get("id").getAsInt());
        banco.setNombre(jo.get("nombre").getAsString());
        banco.setDireccion(jo.get("direccion").getAsString());
        for (JsonElement je : jo.get("servicios").getAsJsonArray()) {
            banco.agregarServicio(je.getAsString());
        }
        banco.setGerente(jo.get("gerente").getAsString());
        banco.setBarrio(jo.get("barrio").getAsString());

        return banco;
    }

    @NonNull
    public Poi getcolectivo(JsonObject jo) {
        Colectivo col = new Colectivo(jo.get("id").getAsInt());
        col.setNombre(jo.get("nombre").getAsString());
        int cantParadas = 0;
        for (JsonElement je : jo.get("paradas").getAsJsonArray()) {
            cantParadas++;
        }
        col.setCantParadas(cantParadas);
        return col;
    }
}
