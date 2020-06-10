package api.mapping;

import annotations.JsonField;
import model.Forecast;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
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
                    System.out.println(value);
                }
            }
        }catch (IntrospectionException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
        return forecast;
    }
}
