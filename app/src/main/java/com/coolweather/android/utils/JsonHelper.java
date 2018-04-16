package com.coolweather.android.utils;

import android.util.Log;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: myliang
 * Date: 4/15/13
 * Time: 3:52 PM
 */
public class JsonHelper {
    public static final ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally


    public static <K, V> String toJson(Map<K, V> obj) {
        String jsonString = "";
        try {
            if (obj == null)
                return "";
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, obj);
            jsonString = sw.toString();
            sw.close();
        } catch (Exception ex) {
            Log.e("toJson error ", ex.toString(), ex);
            return "";
        }

        return jsonString;
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> toMap(String json) {
        Map<K, V> hm = new HashMap<K, V>();
        try {
            if (json == null || "".equals(json))
                return hm;
            ObjectMapper objectMapper = new ObjectMapper();
            Map<K, V> maps = objectMapper.readValue(json, Map.class);
            if (maps != null) {
                hm.putAll(maps);
            }

        } catch (Exception ex) {
            Log.e("toMap error ", ex.toString(), ex);
        }
        return hm;
    }

    public static String toJson(Object object) {
        String json = "";
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
            ObjectMapper mapper = new ObjectMapper();
            mapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.writeValue(gen, object);

            json = sw.toString();
            sw.close();
        } catch (Exception ex) {
            Log.e("toMap error ", ex.toString(), ex);
            json = "";
        }
        return json;
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        T obj = null;
        try {
            if (null == json) return null;
            JsonFactory jsonFactory = new MappingJsonFactory();
            JsonParser jsonParser = jsonFactory.createJsonParser(json);
            ObjectMapper mapper = new ObjectMapper();
            mapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj = mapper.readValue(jsonParser, clazz);

        } catch (Exception ex) {
            Log.e("toMap error ", ex.toString(), ex);
            obj = null;
        }
        return obj;

    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        List<T> list = new ArrayList<T>();
        T obj = null;
        json = json.replaceAll("\\[", "");
        json = json.replaceAll("\\]", "");
        String[] jsonArray = json.split("},");
        int length = jsonArray.length;
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                obj = toObject(jsonArray[i] + "}", clazz);
            } else {
                obj = toObject(jsonArray[i], clazz);
            }
            list.add(obj);
        }
        return list;
    }

}
