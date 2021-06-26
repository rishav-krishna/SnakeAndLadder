package Service;

import lombok.Getter;
import lombok.Setter;
import model.Ladder;
import model.Player;
import model.Snake;
import model.SnakeLadderBoard;

import java.util.*;

@Getter
@Setter
public class DefaultSnakeLadderService implements SnakeLadderService{
    private boolean isGameCompleted;
    private SnakeLadderBoard board;
    private DiceService diceService;
    private Queue<Player> playerQueue;
    private Map<Player,Integer> playerPositionMap;

    private int noOfDices;
    private static int DEFAULT_NO_DICES = 1;
    private static int DEFAULT_BOARD_SIZE = 100;

    public DefaultSnakeLadderService(){
        this.isGameCompleted = false;
        this.board = new SnakeLadderBoard();
        playerQueue = new LinkedList<>();
        playerPositionMap = new HashMap<>();
        noOfDices = DEFAULT_NO_DICES;
    }

    public void setNoOfDices(int noOfDices){
        this.noOfDices = noOfDices;
        setDiceService(noOfDices);
    }
    public DiceService getDiceService() {
        return diceService;
    }

    public void setDiceService(int noOfDices) {
        this.diceService = new DiceServiceImpl(noOfDices);
    }

    private boolean hasPlayerWon(Player currPlayer){
        if(playerPositionMap.containsKey(currPlayer) && playerPositionMap.get(currPlayer)==board.getBOARD_SIZE())
            return true;
        return false;
    }

    public void startGame() {
        while(!isGameCompleted && !playerQueue.isEmpty()){
            Player currPlayer = playerQueue.poll();
            int position = playerPositionMap.get(currPlayer);
            makeMove(currPlayer,position);
            if(hasPlayerWon(currPlayer)){
                System.out.println(currPlayer.getName()+" won!!");
                playerPositionMap.remove(currPlayer);
                if(playerQueue.size()==1){
                    isGameCompleted = true;
                }
            }else{
                System.out.println(currPlayer.getName()+" moved to "+playerPositionMap.get(currPlayer));
                playerQueue.add(currPlayer);
            }
        }
    }

    private void makeMove(Player currPlayer, int position) {
        int oldPosition = position;
        int currDiceValue = getValueFromDices();
        int newPosition = oldPosition+currDiceValue;
        do {
            oldPosition = newPosition;
            for (Snake snake : board.getSnakeList()) {
                if (newPosition == snake.getStart()) {
                    newPosition = snake.getEnd();
                }
            }

            for (Ladder ladder : board.getLadderList()) {
                if (newPosition == ladder.getStart()) {
                    newPosition = ladder.getEnd();
                }
            }
        }while(newPosition!=oldPosition);
        if(newPosition<=board.getBOARD_SIZE()){
            playerPositionMap.put(currPlayer,newPosition);
        }
    }

    public int getValueFromDices() {
        return diceService.getDiceValue();
    }

    public void initializeService(List<Snake> snakeList, List<Ladder> ladderList, List<Player> playerList, int noOfDices) {
        board.setLadderList(ladderList);
        board.setSnakeList(snakeList);
        setNoOfDices(noOfDices);
        for(Player player:playerList){
            playerQueue.add(player);
            playerPositionMap.put(player,0);
        }
    }
}
