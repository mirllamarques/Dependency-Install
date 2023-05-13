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
            String[] currentDependencies= this.dependencies.get(keys[i]);
            if (currentDependencies.length == 0){
                result[priority] = keys[i];
                priority++;
            }else if (currentDependencies.length > 0) {
                if (result[noPriority] != null && !result[noPriority].equals("")) {
                    result[noPriority] = keys[i];
                } else {
                    int count = noPriority;
                    this.changePlaces(currentDependencies, result, noPriority, keys[i]);
                }
            }

        }
        return result;
    }

    private void changePlaces(String[] currentDependencies, String[] result, int noPriority, String key) {
        if (this.in(result[noPriority], currentDependencies)) {

            if (result[noPriority-1] != null && !result[noPriority-1].equals("")) {
                result[noPriority - 1] = result[noPriority];
                result[noPriority] = key;
            } else {
                this.changePlaces(this.dependencies.get(result[noPriority]), result, noPriority - 1, result[noPriority - 1]);
            }
        }
    }

    private boolean in (String dependency, String [] dependencies){
        for (String dep : dependencies) {
            if (dep.equals(dependency)) {
                return true;
            }
        }
        return false;
    }
}
