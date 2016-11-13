package edu.unsam.algo3.poifinder.util;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import edu.unsam.algo3.poifinder.model.Banco;
import edu.unsam.algo3.poifinder.model.CGP;
import edu.unsam.algo3.poifinder.model.Colectivo;
import edu.unsam.algo3.poifinder.model.Local;
import edu.unsam.algo3.poifinder.model.Poi;

/**
 * Created by Marcelo on 13/11/2016.
 */

public class CustomDeserializer implements JsonDeserializer<ArrayList<Poi>> {

    private static Map<String, Class> map = new TreeMap<String, Class>();

    static {
        map.put("Poi", Poi.class);
        map.put("Colectivo", Colectivo.class);
        map.put("Local", Local.class);
        map.put("GCP", CGP.class);
        map.put("Banco", Banco.class);
    }

    public ArrayList<Poi> deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context) throws JsonParseException {

        ArrayList list = new ArrayList<Poi>();
        JsonArray ja = json.getAsJsonArray();

        for (JsonElement je : ja) {
            try {
                String type = je.getAsJsonObject().get("tipo").getAsString();
                Class c = map.get(type);
                if (c == null)
                    throw new RuntimeException("Unknow class: " + type);
                list.add(context.deserialize(je, c));
            } catch (Exception e) {
            }
        }
        return list;
    }

}

