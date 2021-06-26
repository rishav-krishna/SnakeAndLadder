import Service.DefaultSnakeLadderService;
import Service.SnakeLadderService;
import model.Ladder;
import model.Player;
import model.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int totalSnakes,totalLadders,totalPLayers,totalDiceCount = 1;
        SnakeLadderService service = new DefaultSnakeLadderService();
        Scanner scanner = new Scanner(System.in);
        try{
            totalSnakes = scanner.nextInt();
            List<Snake> snakeList = new ArrayList<>();
            for(int i=0;i<totalSnakes;i++){
                snakeList.add(new Snake(scanner.nextInt(),scanner.nextInt()));
            }

            totalLadders = scanner.nextInt();
            List<Ladder> ladderList = new ArrayList<>();
            for(int i=0;i<totalLadders;i++){
               ladderList.add(new Ladder(scanner.nextInt(),scanner.nextInt()));
            }

            totalPLayers = scanner.nextInt();
            List<Player> playerList =  new ArrayList<>();
            for(int i=0;i<totalPLayers;i++){
                playerList.add(new Player(scanner.next()));
            }

            System.out.println("Do you want more than one dice? yes/no");
            if("yes".equals(scanner.next())) {
                totalDiceCount = scanner.nextInt();
            }
            service.initializeService(snakeList,ladderList,playerList,totalDiceCount);
            service.startGame();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
