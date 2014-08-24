
package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class AdditionOperator                                      *       
 Description : This class represents an addition operator in numerical         *
                expressions.                                                   *
 Date        : 9/4/2013.                                                      *
*******************************************************************************/
public class AdditionOperator extends Operator{

    private int palevel=0;
    
    /**
     * 
     * @return 2 as the priority of '+' operator.
     */
    public int priority() 
    {
        return 2;
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return the sum of the two operands.
     */
    public Operand execute(Operand opd1, Operand opd2)
    {
        return new Operand(opd1.getValue()+opd2.getValue());
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
