
package arachne;

public class Equipment implements Storeable {
    private String name; 
    private String filename; 
    
    public Equipment(String name, String fn) {
        this.name = name; 
        this.filename = fn; 
    }
    
    public String getName() {
        return this.name; 
    }
    
    public String getFn() {
        return this.filename; 
    } 
    @Override
    public void store() {
        System.out.println("Weapon " + name + " was stored."); 
    }
}
