import java.io.File;
import java.util.Scanner;

public abstract class X {

    /**
     * Extra over all is just a class to make the everyday coding stuff easier to write.
     * Simples said just a bunch of help methods;
     */

    /**
     * An easier random funktion
     * @param min
     * @param max
     * @return double
     */

    protected static int ran(int min, int max){
        // makes max the max possible
        max = max - min;
        return ((int)(Math.random()*max)+min);
    }

    /**
     *  An easier random funktion
     * @param max
     * @return
     */

    protected static int ran(int max){
        return ran(0,max);
    }

    /**
     * Console println
     * @param text
     */

    public static void println(String text){
        System.out.println(text);
    }

    /**
     * Console print
     * @param text
     */

    public static void print(String text){
        System.out.print(text);
    }

    /**
     *
     * @param filepath
     * @return
     */

    protected static String readFile(String filepath){
        String menu = "";
        File file = new File(filepath);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                menu = menu+in.nextLine()+"\n";
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return menu;
    }
}
