import java.util.Locale;
import java.util.Scanner;

public class main {

    public static void main(String args []){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println( "Welcome to Dependency Install, your dependency installation assistent \n" +
                    "How can I help you?\n" +
                    "1- Get new project's dependencies\n" +
                    "2- Finish");
            try {
                int action = Integer.parseInt(scanner.nextLine());
                if (action == 2){
                    break;
                } else{
                    Facade facade = new Facade();
                    System.out.println("What is your project's name?\n");
                    String name = scanner.nextLine();

                    System.out.println("What is your project's dependencies? (Split with comma)\n");
                    String d = scanner.nextLine();
                    String [] dependencies = d.toUpperCase().split(",");

                    System.out.println("Now you will tell me wich dependency depends on wich\n" +
                            "If any dependency has no associated dependencies just press Enter");
                    for (int i = 0; i < dependencies.length; i++){
                        System.out.println("Which are the dependency of " +
                                dependencies[i] + "? (Split with comma)");
                        String currentDependency = scanner.nextLine().toUpperCase();

                        if (!currentDependency.trim().equals("")){
                            String [] currentDependencies = currentDependency.split(",");
                            facade.addDependencies(dependencies[i], currentDependencies);
                        }
                    }
                    System.out.println("Here are an order to install " + name +"'s dependencies:\n");
                    System.out.println(facade.getOrder());
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid Option\n");
            }
        }
    }
}
