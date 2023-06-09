import java.util.*;

public class Server {

    private Map<String, List<String>> dependencies;

    public Server() {
        this.dependencies = new HashMap<>();
    }

    public void addDependencies(String dependency, String[] dependencies) {
        this.dependencies.put(dependency, Arrays.asList(dependencies));
    }

    public String[] getOrder() {
        List<String> ordered = new ArrayList<>();
        Set<String> changed = new HashSet<>();
        for (String dependency : dependencies.keySet()) {
            changePosition(dependency, changed, ordered);
        }
        return ordered.toArray(new String[0]);
    }

    private void changePosition(String dependency, Set<String> changed, List<String> order) {
        if (changed.contains(dependency)) {
            return;
        }
        changed.add(dependency);
        for (String dependent : dependencies.getOrDefault(dependency, Collections.emptyList())) {
            changePosition(dependent, changed, order);
        }
        order.add(dependency);
    }

    public boolean validDependencies(String[] dependencies, String[] currentDependencies) {
        Set<String> setDependencies = new HashSet<>(Arrays.asList(dependencies));
        for (String item : currentDependencies) {
            if (!setDependencies.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public boolean inCurrentDependency(String dependency, String[] currentDependencies) {
        for (String dep : currentDependencies) {
            if (dep.equals(dependency)) {
                return true;
            }
        }
        return false;
    }

    public String[] removeInvalidsInput(String[] dependencies) {
        List<String> nonEmptyDependencies = new ArrayList<>();

        for (String dep : dependencies) {
            if (dep != null && !dep.trim().isEmpty()) {
                nonEmptyDependencies.add(dep);
            }
        }

        return nonEmptyDependencies.toArray(new String[0]);
    }
}
