
package arachne;

import java.util.ArrayList;
import java.util.List;


public class Spider {
    private String name; 
    private int atk; 
    private int hp;
    private int maxHp; 
    private int amtOfSilk; 
    
    public Spider(String n, int a, int m, int amt) {
        this.name = n; 
        this.atk = a; 
        this.hp = m; 
        this.maxHp = m; 
        this.amtOfSilk = amt; 

    }
    
    public String getName() {
        return this.name; 
    }
    public int getAtk() {
        return this.atk; 
    }     
    
    public int getHp() {
        return this.hp; 
    }    
    public int getMaxHp() {
        return this.maxHp; 
    }
    public int getAmtOfSilk() {
        return this.amtOfSilk; 
    }
    
    public void reduceHP(int i){
        this.hp-=i;
    }
   
    public void attack() {
        if (this.getAtk() > Player.getDef() ) {
            if (Player.getCurDef()) {
                Player.reduceHP(this.getAtk()-Player.getDef());
                Player.removeDef(); 
            } 
            else {
                Player.reduceHP(this.getAtk());
            }
        }

    }
    
}
