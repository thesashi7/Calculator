
package Operator;

/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Abstract class Operator                                         * 
 Description : This is an abstract Operator class which is extended by various *
               other sub classes                                               *
 Date        : 9/4/2013.                                                      *
*******************************************************************************/


import Evaluator.*;
import java.util.HashMap;
/**
 *
 * @author thapaliya
 */
public abstract class Operator {
    
    public static HashMap operators = new HashMap();
    
    
    /**
     * Returns true if the passed String is a valid operator or Else false.
    **/
    public static boolean check(String tok)
    {
       if(operators.containsKey(tok)) return true;
       return false;
    }
    
    /**
     * Returns a number indicating the priority of this Operator. 
     * Example: 0 for the lowest priority and 3 for the highest priority.
     **/
    public abstract int priority();
    
    /**
     * Returns the proper evaluation of the operands depending on the type of operator.
    **/
    public abstract Operand execute(Operand opd1, Operand opd2);
    
    /**
     * Adds all the available operators to the hashmap operators.
     */
    public static void setOperators()
    {
        operators.put("+" ,new AdditionOperator());
        operators.put("-" ,new SubtractionOperator());
        operators.put("*" ,new MutliplicationOperator());
        operators.put("/" ,new DivisionOperator());
        operators.put("#", new SpaceOperator());
        operators.put("!",new EndOperator());  
        operators.put("(", new OpeningBracket());
        operators.put(")", new ClosingBracket());
    
    }
    
    /**
     * Assigns the level of paranthesis to the operator
     * Like "+" in (2+2) will have numP =1 (palevel).
     * @param numP 
     */
    public  abstract void addpalevel(int numP);
    
    
    /**
     * 
     * @return inside how many brackets the operator is(paranthesis level).
     */
    public abstract int paLevel();
    
   
    
}
