import java.util.*;
public class VersionCompatibilityManagement {
    
    Map<Integer, Integer> map;
    int lastCompatible;
    
    public VersionCompatibilityManagement() {
        lastCompatible = 0;
        map = new HashMap<>();
    }
    
    public void addNewVersion(int ver, boolean isCompatibleWithPrev) {
        if (!isCompatibleWithPrev) {
            lastCompatible = ver;
        }
        map.put(ver, lastCompatible);
    }

    public boolean isCompatible(int srcVer, int targetVer) {
        if (srcVer == targetVer) return true;
        else if (!map.containsKey(targetVer)) return false;
        else {
            int last = map.get(targetVer);
            
            return srcVer >= last && srcVer <= targetVer;
        }
        
    }
    
}