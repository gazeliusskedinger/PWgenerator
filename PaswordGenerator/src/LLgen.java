import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LLgen extends X{
    private static char[] stuff = {'A','B','C','D','E','F','1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f'};

    /**
     * Constructor
     * @param sal
     * @param numbers
     */

    public LLgen(ArrayList<String>sal, int numbers){
        llRunGen(sal,numbers);
    }

    /**
     * Format's the output of the table rows
     * is run from the PWrun();
     * @param pwl
     * @param numbers
     */
    public void llRunGen(ArrayList<String> pwl, int numbers){
        ArrayList<Integer> passl = genPass(pwl.size(), numbers);
        StringBuilder sb = new StringBuilder();
        sb.append("Generated : "+dateFormat.format(date));
        for(int i = 0; i < pwl.size(); i++) {
            if (i % 50 == 0) {
                sb.append("\n-------------------------------------------------------------------------------------------\n"+
                        "            Service           |       Stuff        |                 Number\n"+
                        "-------------------------------------------------------------------------------------------\n");
            }
            sb.append(lLRowFormatter(pwl.get(i),stuffGen(),passl.get(i))+"\n");
        }
        String output = sb.toString();
        println(output);
        writeToFile(dateFormatFileName.format(date)+"LList.txt",output);
    }

    /**
     * Format's the output of the table rows
     * @param pwl
     * @param stuff
     * @param passl
     * @return
     */

    private String lLRowFormatter(String pwl, String stuff, int passl){
        int leng = pwl.length();
        StringBuilder sb = new StringBuilder();
        sb.append(" "+pwl);
        String passlen = ""+passl+"";
        for(int i = 0; i < 29-pwl.length();i++ ){
            sb.append(" ");
        }
        sb.append(":");
        for(int i = 0; i < 5;i++ ){
            sb.append(" ");
        }
        sb.append(stuff);
        for(int i = 0; i < 5;i++ ){
            sb.append(" ");
        }
        sb.append(":");
        for(int i = 0; i < 38-passlen.length();i++ ){
            sb.append(" ");
        }
        sb.append(passlen);
        return sb.toString();
    }

    /**
     * generate's the password link.
     * @param size
     * @param leng
     * @return
     */

    private ArrayList<Integer> genPass(int size, int leng){
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
        ArrayList<Integer> pass = new ArrayList<>();
        while(lhs.size() < size){
            lhs.add(ran(leng,0));
        }
        for(int nr : lhs){
            pass.add(nr);
        }

        return pass;
    }

    /**
     * generates stuff
     * @return
     */
    private String stuffGen(){
        String str = "";
        for(int i = 0; i < 10; i++){
            str = str + stuff[ran(6,0)];
        }
        return str;
    }
}
