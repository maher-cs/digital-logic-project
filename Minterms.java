import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Minterms {
    
    /* Method #1
     * This method takes a function as String and return minterms as array of all combinations.
     */
    public static int[] getMinterms(String function, int numberOfVars) throws ScriptException {
    
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        String tempFunction = new String(function);
        int numberOfCombination = (int)Math.pow(2, numberOfVars);
        int[] minterms = new int[numberOfCombination];
        String[] varsNames = {"x'", "x", "y'", "y", "z'", "z", "w'", "w", "v'", "v"};
        
        int[] valuesOfVars = new int[numberOfVars];
        
        //This block will go through all combinations like how truth table
        for(int row = 0; row < numberOfCombination; ++row) {
            for(int column = numberOfVars-1; column >= 0; --column) {
                int value = (row / (int)Math.pow(2, column)) % 2;
                int index = (numberOfVars-1-column)*2;
                tempFunction = tempFunction.replaceAll(varsNames[index], not(value)+"");
                tempFunction = tempFunction.replaceAll(varsNames[index+1], value+"");
            }
            
            int minterm = (int)engine.eval(tempFunction);
            minterms[row] = (minterm > 0? 1: 0);
            
            tempFunction = new String(function);
            
        }
        
        return minterms;
    }
    
    /* Method #2
     * This method takes 1 or 0 as integer and returns its binary complement
     */
    public static int not(int varValue) {
        return (varValue + 1) % 2;
    }
    
    /* Method #3
     * This method takes minterms as array and return Sum Of Products form as a String.
     */
    public static String getSOPForm(int[] minterms) {
    
        String SOPForm = "F = Σ(";
        for(int i = 0; i < minterms.length; ++i)
            if(minterms[i] == 1)
                SOPForm += i + ", ";
        
        //to delete the last ", "        
        SOPForm = SOPForm.substring(0, (SOPForm.length() - 2));
        SOPForm += ")";
        
        return SOPForm;
    }
    
    /* Method #4
     * This method takes minterms as array and return Sum Of Products form as a String.
     * This method does exactly what Method #3 does but with different parameters.
     */
    public static String getSOPForm(String function, int numberOfVars) throws ScriptException {
        int[] minterms = getMinterms(function, numberOfVars);
        String SOPForm = "F = Σ(";
        for(int i = 0; i < minterms.length; ++i)
            if(minterms[i] == 1)
                SOPForm += i + ", ";
        
        //to delete the last ", " 
        SOPForm = SOPForm.substring(0, (SOPForm.length() - 2));
        SOPForm += ")";
        
        return SOPForm;
    }
}
