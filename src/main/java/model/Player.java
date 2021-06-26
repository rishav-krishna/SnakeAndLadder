package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    String name;
    String Id;

    public Player(String name) {
        this.name = name;
        this.Id = UUID.randomUUID().toString();
    }
}
