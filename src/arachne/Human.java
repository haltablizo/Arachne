
package arachne;

public class Human extends NPC {
    private Powerup reward; 
    private int amtOfCoins; 
    private Powerup owned; 
    
    public Human(String name, Powerup p, int a) {
        super(name); 
        this.reward = p; 
        this.amtOfCoins = a; 
    }

    public void give(Player p, Quest q) {
        p.setQuest(q);
    }
    
    public void reward(Player p) {
        p.pStorage.store(this.reward, 1); 
        p.pStorage.coinInc(amtOfCoins);
    }
}
