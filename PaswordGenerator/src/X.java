import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;S
import java.util.Scanner;

public abstract class X {

    protected DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected DateFormat dateFormatFileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    protected Date date = new Date();


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
     *  An easier random help funktion
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
     * @param filePath
     * @return
     */

    protected static String readFile(String filePath){
        String text = "";
        File file = new File(filePath);
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                text = text+in.nextLine()+"\n";
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Makes a file
     * @param filePath
     * @param textToWrite
     */

    protected static void writeToFile(String filePath, String textToWrite){
        try {
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            boolean fileExists = file.createNewFile();
            if(fileExists){
                writer.append(textToWrite);
            }
            else{
                writer.write(textToWrite);
            }
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
