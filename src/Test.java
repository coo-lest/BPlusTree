import tree.BPlusTree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //int[] testData = {13, 2, 16, 14, 10, 13, 16, 7};
        userInterface();
    }

    public static void userInterface() {
        System.out.println("Welcome to User Interface");

        Scanner in = new Scanner(System.in);

        BPlusTree tree;

        String command = "";
        String option = "";

        while (!option.equals("exit")) {
            System.out.print("> ");
            command = in.nextLine();
            String[] s = handler(command);
            option = s[0];
            if (s.length > 1) {
                switch (option) {
                    case "btree":
                        // argument 1 = "-help"
                        if (s[1].equals("-help")) {
                            System.out.println("Usage: btree [fname]\n"
                                    + "fname: the name of the data file "
                                    + "storing the search key values");
                        } else {
                            tree = new BPlusTree(s[1]);
                            System.out.println("Building an initial B+-Tree...\n" +
                                    "Launching B+-Tree test program…\n");

                            while (!option.equals("quit")) {
                                System.out.print("Waiting for your commands: ");
                                command = in.nextLine();
                                s = handler(command);
                                option = s[0];

                                switch (option) {
                                    case "insert":
                                        //tree.insert(argument);
                                        break;
                                    case "delete":
                                        //tree.delete(argument);
                                        break;
                                    case "print":
                                        //tree.print(argument);
                                        break;
                                    case "stat":
                                        //stat(argument);
                                        break;
                                    case "search":
                                        tree.search(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                                        break;
                                    case "quit":
                                        System.out.println("Thanks! Byebye\uF04A");
                                        break;
                                    default:
                                        System.out.println("Invalid command");
                                }
                            }
                        }

                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            } else if (!option.equals("exit")) {
                System.out.println("Invalid command");
            }
        }
        System.out.println("Tree End.");
        in.close();
    }

    public static String[] handler(String command) {
        String[] arr = command.split("\\s+");
        return arr;
    }
}