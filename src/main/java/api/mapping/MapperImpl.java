package api.mapping;

import annotations.JsonField;
import model.Forecast;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
public class MapperImpl implements Mapper {

    private static Logger logger = LoggerFactory.getLogger(MapperImpl.class);

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
                    logger.info("Received value: {}",value);
                }
            }
        }catch (IntrospectionException | IllegalAccessException | InvocationTargetException e){
            logger.error("{}", e.getMessage());
        }
        return forecast;
    }
}
