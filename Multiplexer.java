import java.util.Scanner;

public class Multiplexer {
    /*
    //i put main method only for test
    public static void main(String[] args) {
    
        boolean[] function = {true, true, false, false, true, true, false, true}; 
                           //{1   , 1   , 0    , 0    , 1   , 1   , 0    , 1   }
                           //(0, 1, 4, 5, 7) 
        System.out.println(functionInMultiplexer(3, function));
    }
    */
    public static String functionInMultiplexer(int numberOfVars, boolean[] minterms) {
        String output = "";
        
        for(int i = 0; i < numberOfVars - 1; ++i)
            output += "selector" + i + " = " + (char)('a' + i) + "\n";
            
        output += "\n";
        
        for(int i = 0; i < minterms.length - 1; i += 2) {
            if(minterms[i] && minterms[i+1])
                output += "Input" + i/2 + " = 1\n";
            else if(minterms[i])
                output += "Input" + i/2 + " = " + "~" +(char)('a' + numberOfVars - 1) + "\n";
            else if(minterms[i+1])
                output += "Input" + i/2 + " = " + (char)('a' + numberOfVars - 1) + "\n";
            else
                output += "Input" + i/2 + " = 0\n";
        }
        return output;
    }
}
