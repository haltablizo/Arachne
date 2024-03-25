
package arachne;

public class Settings {
    private static int music = 100;
    private static int sfx = 100;
    private static int currentMusic = music;
    private static int currentSFX = sfx;

    public static void save(int m, int s) {
        music = m; 
        sfx = s; 
    }

    public static int getMusic() {
        return music;
    }

    public static int getSfx() {
        return sfx;
    }
  
    
}
