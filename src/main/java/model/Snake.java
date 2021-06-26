package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Snake {
    int start;
    int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
