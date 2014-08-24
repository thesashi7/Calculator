
package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class DivisionOperator                                      *       
 Description : This class represents a Subtraction operator in numerical       *
               expressions. And has many functions like performs subtraction of*
               the operands and returns the priority of the operator etc.      *
 Date        : 9/4/2013.                                                       *
*******************************************************************************/
public class SubtractionOperator extends Operator{

    private int palevel=0;
    
    /**
     * 
     * @return 2 as the priority of '-' operator
     */
    public int priority() {
        return 2;
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return the difference of the two operands passed (op2-op1).
     */
    public Operand execute(Operand opd1, Operand opd2) {
        return new Operand(opd2.getValue()-opd1.getValue());
    }
    
    /**
     * Assigns the level of paranthesis -- which is under how many paranthesis this oeprator is -- to this operator.
     * @param numP 
     */
    public void addpalevel(int numP)
    {
       this.palevel=numP;
    }
    
    /**
     * 
     * @return the level of paranthesis
     */
    public int paLevel()
    {
       return this.palevel;
    }
 
}
