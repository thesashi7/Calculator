
package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class DivisionOperator                                      *       
 Description : This class represents a division operator in numerical          *
               expressions. And has many functions like performs division of   *
               the operands and returns the priority of the operator etc.      *
 Date        : 9/4/2013.                                                       *
*******************************************************************************/
public class DivisionOperator extends Operator {

    private int palevel=0;
   
    /**
     * 
     * @return 3 as priority of '/'
     */
    public int priority() {
        return 3;
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return the result of (op2/op1)
     */
    public Operand execute(Operand opd1, Operand opd2)
    {
        return new Operand(opd2.getValue()/opd1.getValue());
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
     * @return the paranthesis level.
     */
    
    public int paLevel()
    {
       return this.palevel;
    }
    
    
    
}
