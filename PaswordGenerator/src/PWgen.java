import java.util.ArrayList;
import java.util.LinkedHashSet;

public class PWgen extends X{
    /**
     * Constructor
     * also runs the PWgen
     */
    public PWgen(int leng, int numbers) {
        PWrun(leng,numbers);
    }

    /**
     * Make's the output header.
     * Is called from the Constructor
     */
    private void PWrun(int leng, int numbers){
        ArrayList<String> passes = generate(leng,numbers,3);
        int n = 0;

        for(int i = 0; i < passes.size(); i=i+3) {
            if(i%50 == 0){

                println("-----------------------------------------------------------------");
                println("    Nr     |                     Password");
                println("-----------------------------------------------------------------");

            }

            println(pwRowFormatter(n+1,passes.get(i),passes.get(i+1),passes.get(i+2)));
            n++;

        }
    }

    /**
     * Format's the output of the table rows
     * is run from the PWrun();
     * @param line
     * @param pass1
     * @param pass2
     * @param pass3
     * @return
     */
    //TODO make the list variable depending on length of password and nestleing

    private String pwRowFormatter(int line, String pass1,String pass2,String pass3){

        String nr = ""+line+"";
        StringBuilder sb = new StringBuilder();
        sb.append(" "+line);
        for(int i = 0; i < 10-nr.length();i++){
            sb.append(" ");
        }
        sb.append(": "+pass1+pass2+pass3);
        return sb.toString();

    }

    /**
     * Help method for generating one password for the last decoy list
     * @param leng
     * @param arl
     * @return passwordlist
     */

    public static ArrayList<String> getGenerate(int leng, ArrayList<String> arl){

        return generate(leng,arl.size(),1);

    }

    //TODO Hash from random instead example : https://stackoverflow.com/questions/2860943/how-can-i-hash-a-password-in-java
    //TODO And Mix in specials

    /**
     * generates the password
     * @param leng
     * @param numbers
     * @param nestled
     * @return
     */

    private static ArrayList<String> generate(int leng, int numbers, int nestled){

        char[] dividers = {'{','}','[',']','(',')','!','|','/',':',';','=','!','&','?','#','%','<','>','*','-'};
        char[] begEnd = {'=','!','&','?','#','%','<','>','*','-','_','|','/'};
        char[] numLett ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                '1','2','3','4','5','6','7','8','9','0'};

        ArrayList<String> pass = new ArrayList<>();
        LinkedHashSet<String> passes = new LinkedHashSet<>();
        int n = 0;
        StringBuilder sb;

         while(passes.size() < numbers*nestled){
            sb = new StringBuilder();
            for (int i = 0; i < leng; i++) {
                n = ran(100, 0);
                if (i == 0 || i == leng - 1) {
                    if (n >= 50) {
                        sb.append(numLett[ran(numLett.length)]);
                    } else {
                        sb.append(begEnd[ran(begEnd.length)]);
                    }
                } else {
                    if (n <= 20) {
                        sb.append(dividers[ran(dividers.length)]);
                    } else {
                        sb.append(numLett[ran(numLett.length)]);
                    }
                }
            }
            sb.append(dividers[ran(dividers.length)]);
            passes.add(sb.toString());
        }

        for (String str : passes){
            pass.add(str);
        }

        return pass;

    }
}
