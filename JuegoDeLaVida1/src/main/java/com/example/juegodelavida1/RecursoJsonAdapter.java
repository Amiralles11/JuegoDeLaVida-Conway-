package com.example.juegodelavida1;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class RecursoJsonAdapter implements JsonSerializer<Recurso>, JsonDeserializer<Recurso> {
    private static final Logger log = LogManager.getLogger(RecursoJsonAdapter.class);
    @Override
    public Recurso deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        log.info("deserializando json a recurso");
        JsonObject recursoNuevo = jsonElement.getAsJsonObject();
        if(recursoNuevo.get("Tipo").getAsString().contains("RecursoAgua")){
            return jsonDeserializationContext.deserialize(recursoNuevo.get("Data").getAsJsonObject(),RecursoAgua.class);
        }else if(recursoNuevo.get("Tipo").getAsString().contains("RecursoBiblioteca")){
            return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"),RecursoBiblioteca.class);
        }else if(recursoNuevo.get("Tipo").getAsString().contains("RecursoComida")){
            return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"),RecursoComida.class);
        }else if(recursoNuevo.get("Tipo").getAsString().contains("RecursoMontaña")){
        return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"),RecursoMontaña.class);
        }else if(recursoNuevo.get("Tipo").getAsString().contains("RecursoPozo")){
            return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"),RecursoPozo.class);
        }else if(recursoNuevo.get("Tipo").getAsString().contains("RecursoTesoro")) {
            return jsonDeserializationContext.deserialize(recursoNuevo.get("Data"), RecursoTesoro.class);
        } else{
            log.fatal("error al encontrar el tipo de recurso");
            throw new JsonParseException("El tipo de recurso no ha sido bien identificado al deserializarlo");
        }
    }

    @Override
    public JsonElement serialize(Recurso recurso, Type type, JsonSerializationContext jsonSerializationContext) {
        log.info("serializando recurso a json");
        JsonObject recursoNuevo = new JsonObject();
        recursoNuevo.addProperty("Tipo",recurso.getClass().descriptorString());
        recursoNuevo.add("Data",jsonSerializationContext.serialize(recurso));
        log.info("recurso a json serializado");
        return recursoNuevo;
    }
}
