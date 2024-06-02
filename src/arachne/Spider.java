
package arachne;

import java.util.ArrayList;
import java.util.List;


public class Spider {
    private String name; 
    private int atk; 
    private int hp;
    private int maxHp; 
    private int amtOfSilk; 
    
    public Spider(String n, int m, int a, int amt) {
        this.name = n; 
        this.atk = a; 
        this.hp = m; 
        this.maxHp = m; 
        this.amtOfSilk = amt; 

    }
    
    public void resetHp() {
        this.hp = this.maxHp; 
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
        if (Player.getCurDef()) {
            Player.reduceHP(this.getAtk()-Player.getDef());
            
            if (Player.getHp() < this.getAtk()-Player.getDef()) {
                Player.reduceHP(Player.getHp());
            }
            
            else {
                Player.reduceHP(this.getAtk()-Player.getDef());
            }
            
            Player.removeDef(); 
        } 
        else {
            if (Player.getHp() < this.getAtk()) {
                Player.reduceHP(Player.getHp());
            }
            
            else {
                Player.reduceHP(this.getAtk());
            }
        }
    }

}
