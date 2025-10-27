import java.util.*;

public class CityGraph {

    
    private Map<String, List<String>> adjList = new HashMap<>();

    
    public boolean addLocation(String id) {
        if (adjList.containsKey(id)) {
            System.out.println("❌ Location " + id + " already exists!");
            return false;
        }
        adjList.put(id, new ArrayList<>());
        System.out.println("✅ Location " + id + " added.");
        return true;
    }

    
    public boolean removeLocation(String id) {
        if (!adjList.containsKey(id)) {
            System.out.println("❌ Location " + id + " not found!");
            return false;
        }
        adjList.remove(id);
        
        for (List<String> connections : adjList.values()) {
            connections.remove(id);
        }
        System.out.println("✅ Location " + id + " removed.");
        return true;
    }

    
    public boolean addRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("❌ One or both locations not found!");
            return false;
        }
        if (!adjList.get(from).contains(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from); 
            System.out.println("✅ Road added between " + from + " and " + to);
        } else {
            System.out.println("⚠️ Road already exists between " + from + " and " + to);
        }
        return true;
    }

    
    public boolean removeRoad(String from, String to) {
        if (adjList.containsKey(from)) adjList.get(from).remove(to);
        if (adjList.containsKey(to)) adjList.get(to).remove(from);
        System.out.println("✅ Road removed between " + from + " and " + to);
        return true;
    }

    
    public void displayConnections() {
        System.out.println("\n--- City Road Connections ---");
        for (String id : adjList.keySet()) {
            System.out.println(id + " connected to " + adjList.get(id));
        }
    }
}