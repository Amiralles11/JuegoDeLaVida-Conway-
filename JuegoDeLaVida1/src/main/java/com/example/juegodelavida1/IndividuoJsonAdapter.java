package com.example.juegodelavida1;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class IndividuoJsonAdapter implements JsonSerializer<Individuo>, JsonDeserializer<Individuo>{
    private static final Logger log = LogManager.getLogger(IndividuoJsonAdapter.class);

    @Override
    public Individuo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        log.info("deserializando json a individuo");
        JsonObject individuoNuevo = jsonElement.getAsJsonObject();
        if(individuoNuevo.get("Tipo").getAsString().contains("IndividuoTipoBasico")){
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"), IndividuoTipoBasico.class);
        }else if(individuoNuevo.get("Tipo").getAsString().contains("IndividuoTipoNormal")){
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"),IndividuoTipoNormal.class);
        }else if(individuoNuevo.get("Tipo").getAsString().contains("IndividuoTipoAvanzado")){
            return jsonDeserializationContext.deserialize(individuoNuevo.get("Data"),IndividuoTipoAvanzado.class);
        }else{
            log.fatal("error al encontrar el tipo de individui");
            throw new JsonParseException("El tipo de individuo no ha sido bien identificado al deserializarlo");
        }
    }

    @Override
    public JsonElement serialize(Individuo individuo, Type type, JsonSerializationContext jsonSerializationContext) {
        log.info("serializando individuo a json");
        JsonObject individuoNuevo = new JsonObject();
        individuoNuevo.addProperty("Tipo",individuo.getClass().descriptorString());
        individuoNuevo.add("Data",jsonSerializationContext.serialize(individuo));
        log.info("individuo a json serializado");
        return individuoNuevo;
    }
}
