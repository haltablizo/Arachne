
package arachne;

public class Equipment implements Storeable {
    private String name; 
    private String filename; 
    private String desc; 
    
    public Equipment(String name, String fn, String desc) {
        this.name = name; 
        this.filename = fn; 
        this.desc = desc; 
    }
    
    public String getName() {
        return this.name; 
    }
    
    public String getFn() {
        return this.filename; 
    } 
    
    public String getDesc() {
        return this.desc; 
    } 
    
    @Override
    public void store() {
        System.out.println("Weapon " + name + " was stored."); 
    }
}
