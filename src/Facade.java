import java.util.*;

public class Facade {

    private Map<String, List<String>> dependencies;

    public Facade(){
        this.dependencies = new HashMap<>();
    }

    public void addDependencies(String dependency, String[] dependencies){
        this.dependencies.put(dependency, Arrays.asList(dependencies));
    }

    public String[] getOrder() {
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String dependency : dependencies.keySet()) {
            visit(dependency, visited, order);
        }
        return order.toArray(new String[0]);
    }

    private void visit(String dependency, Set<String> visited, List<String> order) {
        if (visited.contains(dependency)) {
            return;
        }
        visited.add(dependency);
        for (String dependent : dependencies.getOrDefault(dependency, Collections.emptyList())) {
            visit(dependent, visited, order);
        }
        order.add(dependency);
    }
}
