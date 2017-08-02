package cz.steman.spring5demo.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import cz.steman.spring5demo.model.User;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.io.IOException;

public class UserDeserializer extends JsonObjectDeserializer<User> {
    @Override
    protected User deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext,
                                     ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {

        String id = nullSafeValue(jsonNode.get("id"), String.class);
        String team_id = nullSafeValue(jsonNode.get("team_id"), String.class);
        String name = nullSafeValue(jsonNode.get("name"), String.class);
        String real_name = nullSafeValue(jsonNode.get("real_name"), String.class);
        String tz = nullSafeValue(jsonNode.get("tz"), String.class);

        return new User(id, team_id, name, real_name, tz);
    }
}
