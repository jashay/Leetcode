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
    
    // public static void main(String[] args) {
    //     VersionCompatibilityManagement versions = new VersionCompatibilityManagement();
    //     versions.addNewVersion(1, false);
    //     versions.addNewVersion(2, true);
    //     versions.addNewVersion(3, true);
    //     versions.addNewVersion(4, false);
    //     versions.addNewVersion(5, true);
    //     versions.addNewVersion(6, true);
    //     System.out.println(versions.isCompatible(1, 3));
    //     System.out.println(versions.isCompatible(3, 5));//== false);
    //     System.out.println(versions.isCompatible(4, 2));// == false); // downgrade
    //     System.out.println(versions.isCompatible(3, 3));// == true); // upgrade to itself, always compatible
    // }
}