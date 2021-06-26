package Service;

import lombok.NoArgsConstructor;
import java.util.Random;

@NoArgsConstructor
public class DiceServiceImpl implements DiceService{
    int noOfDices;

    public DiceServiceImpl(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    public int getDiceValue() {
        Random random = new Random();
        int totalDieValue = 0;
        for(int i=0;i<noOfDices;i++){
            totalDieValue+=random.nextInt(6)+1;
        }
        return totalDieValue;
    }
}
