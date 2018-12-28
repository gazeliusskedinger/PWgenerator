import java.util.ArrayList;
import java.util.Scanner;


class CommandLineMenu extends X {

    /*
     * class Globals
     */

    private int numbers;
    private int leng;
    private ArrayList<String> sal = new ArrayList<>();
    private final String menuGuide = readFile("Menu_guide");

    /**
     * Constructor that also serves as place where the
     * is run from main
     */

    CommandLineMenu(){
        println(readFile("intro_title.dat"));
        menu();
    }

    /**
     * Menu head method
     * is run from Constructor
     */

    private void menu(){

        choice();

    }

    /**
     * The decision part ot the menu
     * is run from menu();
     */
    private void choice(){

        print(menuGuide);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("0")) {

            println("Exiting!");

        }

        else if (input.equals("1")) {

            makePWList();
            choice();
        }
        else if (input.equals("2")) {

            sal = makeLList();
            choice();

        }
        else if (input.equals("3")) {

            makeDecoy();
            choice();

        }
        else {
            println("Wrong input \nTry again!");
            choice();
        }
    }

    /**
     * Make's the password list
     * is run from menu();
     */

    private void makePWList(){

        print("Enter number of passwords : ");
        Scanner sc = new Scanner(System.in);
        numbers = sc.nextInt();
        print("Enter wanted Password length : ");
        leng = sc.nextInt();

        printEmptyRows();
        new PWgen(leng,numbers);
        printEmptyRows();

    }

    /**
     * Make's the linked list to somehow link a service to a password
     * Is run from menu();
     * @return the service ArrayList to de able to use it in the Makedecoy
     */

    private ArrayList<String> makeLList(){

        Scanner sc = new Scanner(System.in);
        String in;
        boolean exit = false;
        ArrayList<String> sal = new ArrayList<>();

        //enter services step.
        println("Enter all Services you want to create passwords for.\nDone with '0'\nExit with '-1'");


        do {

            in = sc.nextLine();
            sal.add(in);
            if(in.equals("-1")){
                exit = true;
            }

        }while(!(in.equals("-1")||in.equals("0")));

        sal.remove(sal.size()-1);

        //if done... run.
        if(!exit){

            printEmptyRows();
            new LLgen(sal,numbers);

        }

        printEmptyRows();

        return sal;
    }

    /**
     * Make's Decoy List.
     * is run from menu()
     */

    private void makeDecoy(){

        printEmptyRows();
        new Decoy(sal, leng);
        printEmptyRows();

    }

    /**
     * Print's ten empty rows just to space output
     */

    private void printEmptyRows(){

        for(int i = 0; i< 10; i++){
            System.out.println();
        }

    }
}


