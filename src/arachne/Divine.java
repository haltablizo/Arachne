
package arachne;

import java.util.ArrayList;
import java.util.List;

public class Divine extends NPC { 
    private Needle needle; 
    private Coat coat; 
    private String filename; 

    public List<Integer> hand = new ArrayList(); 
    
    public List<Integer> deck = new ArrayList(); 
    
    /**
     * creates a deck to be dealt to divine and player 
     */
    public void createDeck() {
        for (int i=0; i<4; i++) {
            for (int j=1; j<=10; j++) {
                deck.add(j); 
            }
        }
    }
    
    /**
     * 
     * @param card add a card of value card to the hand of divine
     */
    public void hit(int card) {
        hand.add(card);
    }
    
    
    public Divine(String name, Coat c, Needle n, String s) {
        super(name); 
        this.coat = c; 
        this.needle = n; 
        this.filename = s; 
    }
    
    public Divine(String name) {
        super(name); 
    }
    
    public Coat getCoatReward() {
        return this.coat; 
    }
    
    public Needle getNeedleReward() {
        return this.needle; 
    }
    
    public String getFn() {
        return this.filename; 
    }
    
    public int getHandSum() {
        int s = 0; 
        for (int i : this.hand) s = s + i;
        return s; 
    }
    
}
