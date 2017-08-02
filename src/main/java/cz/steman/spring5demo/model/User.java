package cz.steman.spring5demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import cz.steman.spring5demo.model.deserializer.UserDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@JsonDeserialize(using = UserDeserializer.class)
@Document
public class User {
    @Id
    private String id;
    private String team_id;
    private String name;
    private String real_name;
    private String tz;
}