import java.util.Scanner;

public class TruthTable {
    /*
    //just a test
    public static void main(String[] args) {
    
        boolean[] function = {true, true, false, false, true, true, false, true}; 
        System.out.println(printTruthTable(3, function));
    }
    */
    public static String printTruthTable(int numberOfVars, boolean[] minterms) {
        String output = "";
        int numberOfCombination = (int)Math.pow(2, numberOfVars);
        
        
        for(int row = 0; row < numberOfCombination; ++row) {
            for(int column = numberOfVars-1; column >= 0; --column)
                output += (row / (int)Math.pow(2, column)) % 2 + " ";
            
            output += "| " + (minterms[row]? 1: 0);
            output += "\n";
        }
        return output;
    }
}
