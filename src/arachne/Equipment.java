
package arachne;

public class Equipment implements Storeable {
    private String name; 
    
    public Equipment(String name) {
        this.name = name; 
    }
    
    public String getName() {
        return this.name; 
    }
    @Override
    public void store() {
        System.out.println("Weapon " + name + " was stored."); 
    }
}
