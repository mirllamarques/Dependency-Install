import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String args []){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println( "Welcome to Dependency Install, your dependency installation assistant \n" +
                    "How can I help you?\n" +
                    "1- Get new project's dependencies\n" +
                    "2- Finish\n");
            try {
                int action = Integer.parseInt(scanner.nextLine());
                if (action == 2){
                    break;
                } else if (action == 1) {
                    Server server = new Server();
                    String name;

                    while (true) {
                        System.out.println("\nWhat is your project's name?\n");
                        name = scanner.nextLine().trim();
                        if (name.trim().isEmpty()) {
                            System.out.println("Your project must have a name");
                        } else {
                            break;
                        }
                    }

                    String dependenciesSTR;
                    while (true) {
                        System.out.println("\nWhat is your project's dependencies? (Split with comma)\n");
                        dependenciesSTR = scanner.nextLine();
                        if (dependenciesSTR.trim().isEmpty()) {
                            System.out.println("Your project must have dependencies");
                        } else {
                            break;
                        }
                    }

                    String[] dependencies = server.removeInvalidsInput(dependenciesSTR.toUpperCase().split(","));


                    System.out.println("\nNow you will tell me which dependency depends on which\n" +
                            "If any dependency has no associated dependencies just press Enter");
                    for (int i = 0; i < dependencies.length; i++) {

                        while (true) {
                            System.out.println("Which are the dependency of " +
                                    dependencies[i] + "? (Split with comma)");
                            String currentDependency = scanner.nextLine().toUpperCase();
                            if (!currentDependency.trim().equals("")) {
                                String[] currentDependencies = currentDependency.split(",");
                                if (server.validDependencies(dependencies, currentDependencies)) {
                                    if (!server.inCurrentDependency(dependencies[i], currentDependencies)) {
                                        server.addDependencies(dependencies[i], currentDependencies);
                                        break;
                                    } else {
                                        System.out.println(dependencies[i] + " could not be dependent on itself\n" +
                                                "Please Try again\n");
                                    }
                                } else {
                                    System.out.println("You provided a dependency that does not exist in this project\n" +
                                            "Please Try again\n");
                                }
                            } else {
                                String[] empty = new String[0];
                                server.addDependencies(dependencies[i], empty);
                                break;
                            }
                        }
                    }
                    System.out.println("Here is an order to install " + name + "'s dependencies:\n");
                    System.out.println(Arrays.toString(server.getOrder()));
                } else{
                    System.out.println("Invalid Option\n");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid Option\n");
            }
        }
    }
}
