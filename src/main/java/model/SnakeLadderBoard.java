package model;

import Service.SnakeLadderService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SnakeLadderBoard {

    private int BOARD_SIZE = 100;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;

    public SnakeLadderBoard(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
    }

    public void setSnakeList(List<Snake> snakeList) {
        this.snakeList = new ArrayList<>(snakeList);
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = new ArrayList<>(ladderList);
    }
}
