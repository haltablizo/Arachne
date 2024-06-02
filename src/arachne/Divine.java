
package arachne;

import java.util.ArrayList;
import java.util.List;

public class Divine extends NPC {
    private Equipment reward; 
    private Needle owned; 

    public List<Integer> hand = new ArrayList(); 
    
    public List<Integer> deck = new ArrayList(); 
    
    public void createDeck() {
        for (int i=0; i<4; i++) {
            for (int j=1; j<=10; j++) {
                deck.add(j); 
            }
        }
    }
    
    public void hit(int card) {
        hand.add(card);
    }
    
    
    public Divine(String name, Equipment e) {
        super(name); 
        this.reward = e; 
    }
    
    public Divine(String name) {
        super(name); 
    }
    
    public Equipment getReward() {
        return this.reward; 
    }
    
    public int getHandSum() {
        int s = 0; 
        for (int i : this.hand) s = s + i;
        return s; 
    }
    
}
