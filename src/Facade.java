import java.util.HashMap;

public class Facade {

    private HashMap<String, String[]> dependencies;

    public Facade(){
        this.dependencies = new HashMap<>();
    }

    public void addDependencies(String dependency, String[] dependencies){
        this.dependencies.put(dependency, dependencies);
    }

    public String[] getOrder() {
        String [] keys = this.dependencies.keySet().toArray(new String[this.dependencies.keySet().size()]);
        String[] result = new String[keys.length];

        int priority = 0;
        int noPriority =  keys.length - 1;

        for (int i = 0; i < keys.length; i++){
            String[] currentDependencies = this.dependencies.get(keys[i]);
            if (currentDependencies.length == 0){
                result[priority] = keys[i];
                priority++;
            }else {
                if (result[noPriority] == null) {
                    this.changePlaces(currentDependencies, result, noPriority, keys[i]);
                }

                result[noPriority] = keys[i];
                noPriority --;
            }
        }
        return result;
    }

    private void changePlaces(String[] currentDependencies, String[] result, int noPriority, String key) {
        if (!this.in(key, currentDependencies) && noPriority < 0) {
            this.changePlaces(this.dependencies.get(result[noPriority]), result, noPriority - 1, result[noPriority - 1]);
        }
        else if (noPriority >= 0) {
            boolean dependenciesAdded = true;
            for (String dependency : currentDependencies) {
                if (!this.in(dependency, result)) {
                    dependenciesAdded = false;
                    break;
                }
            }
            if (dependenciesAdded) {
                result[noPriority] = key;
            } else if (noPriority - 1 > 0){
                this.changePlaces(currentDependencies, result, noPriority - 1, key);
            }
        }

    }

    private boolean in (String dependency, String [] dependencies){
        if (dependencies == null || dependency == null) {
            return false;
        }
        for (String dep : dependencies) {
            if (dep != null && dep.equals(dependency)) {
                return true;
            }
        }
        return false;
    }
}
