import java.util.Scanner;

public class ToDo{

    private static Scanner scanner = new Scanner(System.in);
    private static ToDoFunction func = new ToDoFunction();

    public static void main(String[] args) {
        
        System.out.println("\n*** TODO List ***\n\n");

        int command = 0;
        boolean exit = false;

        printCommand();

        while(!exit){
            System.out.println("Enter Your Choice: ");
            command = scanner.nextInt();
            scanner.nextLine();

            switch(command){
                case 0: printCommand();
                break;
                case 1: func.printToDoList();
                break;
                case 2: addItem();
                break;
                case 3: updateItem();
                break;
                case 4: removeItem();
                break;
                case 5: searchItem();
                break;
                case 6: exit = true;
                break;
                default: System.out.println("Please Chooce right option.");
            }
        }

    }

    private static void searchItem() {
        System.out.println("Enter a String to be searched: ");
        String searchItem = scanner.nextLine();

        if(func.findItem(searchItem) == null){
            System.out.println("Item not found in your TODO list.");
        } else{
            System.out.println(searchItem + " was found in your list.");
        }
    }

    private static void removeItem() {
        System.out.println("Enter the item number to be deleted: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        func.removeItem(index-1);
    }

    private static void updateItem() {
        System.out.println("Enter the item number: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Item to be Added: ");
        String mNewItem = scanner.nextLine();
        func.updateTodo((index-1), mNewItem);
    }

    private static void addItem() {
        System.out.println("Enter Item to be added in todo list: ");
        func.addItem(scanner.nextLine());
    }

    private static void printCommand() {
        System.out.println("\n Comands: " + 
        "\n Press 0: To print instructions." + 
        "\n Press 1: To print all the list." + 
        "\n Press 2: To add list in ToDo." + 
        "\n Press 3: To modify item in ToDo." + 
        "\n Press 4: To remove item from ToDo." + 
        "\n Press 5: To search an Item from Todo." + 
        "\n Press 6: To exit the app.");
    }
}