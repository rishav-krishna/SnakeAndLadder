package Service;

import model.Ladder;
import model.Player;
import model.Snake;

import java.util.List;

public interface SnakeLadderService {
    void startGame();
    int getValueFromDices();
    void initializeService(List<Snake> snakeList, List<Ladder> ladderList, List<Player> playerList,int noOfDices);
}
