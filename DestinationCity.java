public class DestinationCity {
  public String destCity(List<List<String>> paths) {
    Set<String> destinations = new HashSet<>();
    Set<String> sources = new HashSet<>();
    for (List<String> path : paths) {
        String i = path.get(0);
        String d = path.get(1);
        destinations.add(d);
        sources.add(i);
    }
    
    for (String dest : destinations) {
        if (!sources.contains(dest)) return dest;
    }
    
    return "";
  }
}
