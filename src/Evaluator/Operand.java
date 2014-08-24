
package Evaluator;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Operand class                                                   *       
 Description : This is an Operand class which can used in a Calculation and    *
               it has constructors that takes in a operand as a string and int *
               And it has other functions to check if an Object is an operand  *
               and to return the value of the operand as a number              *
 Date        : 3/29/2013.                                                      *
*******************************************************************************/

public class Operand {
    
    private int opvalue;
            
    /**
     * CONSTRUCTOR
     * @param tok 
     */        
    public Operand (String tok)
    {
       opvalue=Integer.parseInt(tok);
    }
    
    /**
     * 
     * @param value 
     */
    public Operand (int value)
    {
       opvalue=value;
    }
    
    /**
     *  Returns true if a valid integer is passed or Else false. 
    **/
    public static boolean check(String tok)
    {
       int tempt=0;
       
       try
       {
          tempt=Integer.parseInt(tok);
          return true;
       }
       catch(Exception e)
       {
          return false;
       }
       
    }
    
    /**
     * 
     * @return integer value of the Operand 
     */
    public int getValue()
    {
       return opvalue;
    }
}
