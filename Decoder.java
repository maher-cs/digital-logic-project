import java.util.Scanner;

public class Decoder {
    /*
    //just a test
    public static void main(String[] args) {
    
        boolean[] function = {true, true, false, false, true, true, false, true}; 
                           //{1   , 1   , 0    , 0    , 1   , 1   , 0    , 1   }
                           //(0, 1, 4, 5, 7) 
        System.out.println(functionInDecoder(3, function));
    }
    */
    public static String functionInDecoder(int numberOfVars, boolean[] minterms) {
        String output = "";
        
        //inputs of the decoder are all variables.
        for(int i = 0; i < numberOfVars; ++i)
            output += "Input" + i + " = " + (char)('a' + i) + "\n";
            
        output += "\n";
        
        //the outputs of decoder are the minterms with or gate:
        output += "F = ";
        for(int i = 0; i < minterms.length; ++i) {
            if(minterms[i])
                output += "output" + i + (i < minterms.length - 1? " + ": "");
            
        }
        return output;
    }
}
