package api.mapping;

import annotations.JsonField;
import api.requester.Requester;
import api.requester.RequesterImpl;
import model.Forecast;
import org.json.JSONObject;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MapperImpl implements Mapper {

    @Override
    public Forecast mapToModel(JSONObject jsonObject) {
        Forecast forecast = new Forecast();
        Class forecastClass = forecast.getClass();
        Field[] fields = forecastClass.getDeclaredFields();
        Object value;

        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    value = jsonObject.query(field.getAnnotation(JsonField.class).path());
                    new PropertyDescriptor(field.getName(), forecastClass).getWriteMethod().invoke(forecast, field.getType().cast(value));
                }
            }
        }catch (IntrospectionException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        return forecast;
    }
}
