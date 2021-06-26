package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Ladder {
    int start;
    int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
