
package arachne;

public abstract class NPC {
    private String name;
    
    public NPC(String name) {
        this.name = name; 
    }
    
    public String getName() {
        return this.name; 
    }     
  
}
