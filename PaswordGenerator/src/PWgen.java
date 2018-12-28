import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.security.SecureRandom;

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
        StringBuilder sb = new StringBuilder();
        int n = 0;
        sb.append("Generated : "+dateFormat.format(date)+"\n");
        for(int i = 0; i < passes.size(); i=i+3) {
            if(i%50 == 0){

                sb.append("-----------------------------------------------------------------\n" +
                        "    Nr     |                     Password" +
                        "\n-----------------------------------------------------------------\n");

            }
            sb.append(pwRowFormatter(n+1,passes.get(i),passes.get(i+1),passes.get(i+2)+"\n"));
            n++;
        }
        String output = sb.toString();
        println(output);
        writeToFile(dateFormatFileName.format(date)+"PwList.txt",output);
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

    /**
     * generates the password
     * @param leng
     * @param numbers
     * @param nestled
     * @return
     */

    private static ArrayList<String> generate(int leng, int numbers, int nestled){

        char[] dividers = {'{','}','[',']','(',')','!','|','/',':',';','=','!','&','?','#','%','<','>','*','-','A','B','C','D','E','F','1','2','3','4','5','6','7','8','9','0'};
        char[] begEnd = {'=','!','&','?','#','%','<','>','*','-','_','|','/','@','1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F'};


        ArrayList<String> pass = new ArrayList<>();
        LinkedHashSet<String> passes = new LinkedHashSet<>();
        int n = 0;
        StringBuilder sb;

         while(passes.size() < numbers*nestled){
             sb = new StringBuilder();
             sb.append(begEnd[ran(begEnd.length)]+base64()+dividers[ran(dividers.length)]);
             passes.add(sb.toString());
        }
        for (String str : passes){
            pass.add(str);
        }
        return pass;
    }

    /**
     * generates the base64 encoded random text
     * @return base64 encoding
     */

    private static String base64( ){
        byte[] stuff = new byte[11];
        final SecureRandom random = new SecureRandom();
        String b64 = "";
        try {
            random.nextBytes(stuff);
            Base64.Encoder enc = Base64.getEncoder();
            b64 = enc.encodeToString(stuff);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        b64 = b64.substring(0,b64.length()-1); // remove's double ==
        return b64;
    }
}
