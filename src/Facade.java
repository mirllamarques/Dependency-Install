import java.util.HashMap;

public class Facade {

    private HashMap<String, String[]> dependencies;

    public Facade(){
        this.dependencies = new HashMap<>();
    }

    public void addDependencies(String dependency, String[] dependencies){
        this.dependencies.put(dependency, dependencies);
    }

    public String getOrder() {
        String result = "";
        String [] keys = dependencies.keySet().toArray(new String[dependencies.keySet().size()]);
        for (int i = 0; i < keys.length; i++){

        }
        return result;
    }
}
