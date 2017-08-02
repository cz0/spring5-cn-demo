package cz.steman.spring5demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SlackMessage {
    private boolean ok;
    private List<User> members;
    private long cache_ts;
}
