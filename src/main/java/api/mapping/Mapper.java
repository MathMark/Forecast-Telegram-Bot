package api.mapping;

import model.Forecast;
import org.json.JSONObject;

public interface Mapper {
    Forecast mapToModel(JSONObject jsonObject);
}
