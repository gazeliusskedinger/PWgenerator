import java.util.ArrayList;

public class Decoy extends X{

    private ArrayList<String> services;
    private int leng;

    /**
     * Constructor and runs the Decoy main method
     * @param services
     * @param leng
     */

    public Decoy(ArrayList<String> services, int leng){
        this.leng = leng;
        this.services = services;
        genDecoy();
    }

    /**
     * Make's the output header.
     * Is called from the Constructor
     */

    private void genDecoy(){
        ArrayList<String> pw = PWgen.getGenerate(leng,services);
        for(int i = 0; i < services.size(); i++) {
            if (i % 50 == 0) {
                println("------------------------------------------------------------------------");
                println("            Service           |               Password");
                println("------------------------------------------------------------------------");
            }
            println(decoyFormater(services.get(i),pw.get(i)));
        }
    }

    /**
     * Format's the output of the table rows
     * @param pw
     * @return
     */

    private String decoyFormater(String service, String pw){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(service);
        for(int i = 0; i < 29-service.length();i++ ){
            sb.append(" ");
        }
        sb.append(":");
        for(int i = 0; i < 40-pw.length();i++ ){
            sb.append(" ");
        }
        sb.append(pw);
        return sb.toString();
    }
}
