package edu.unsam.algo3.poifinder.util;

import android.support.annotation.NonNull;

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
    public Poi getCGP(JsonObject jo) {
        CGP cgp = new CGP(jo.get("id").getAsInt());
        cgp.setNombre(jo.get("nombre").getAsString());
        cgp.setDireccion(jo.get("direccion").getAsString());

        return cgp;
    }

    @NonNull
    public Poi getLocal(JsonObject jo) {
        Local local = new Local(jo.get("id").getAsInt());
        local.setNombre(jo.get("nombre").getAsString());
        local.setDireccion(jo.get("direccion").getAsString());
        for (JsonElement je : jo.get("palabrasClaves").getAsJsonArray()) {
            local.agregarPalabrasClaves(je.getAsString());
        }
        return local;
    }

    @NonNull
    public Poi getBanco(JsonObject jo) {
        Banco banco = new Banco(jo.get("id").getAsInt());
        banco.setNombre(jo.get("nombre").getAsString());
        banco.setDireccion(jo.get("direccion").getAsString());
        for (JsonElement je : jo.get("_servicios").getAsJsonArray()) {
            banco.agregarServicio(je.getAsString());
        }
        return banco;
    }

    @NonNull
    public Poi getColectivo(JsonObject jo) {
        Colectivo col = new Colectivo(jo.get("id").getAsInt());
        col.setNombre(jo.get("nombre").getAsString());
        col.setCantParadas(jo.get("cantParadas").getAsInt());
        return col;
    }
}
