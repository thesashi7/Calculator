
package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class DivisionOperator                                      *       
 Description : This class represents an Opening brackets '(' operator in       *
               numerical expressions.                                          *
 Date        : 9/4/2013.                                                       *
*******************************************************************************/
public class OpeningBracket extends Operator
{
    private int palevel=0;
 
    /**
     * 
     * @return 4 as the priority of the '(' operator.
     */
    public int priority() 
    {
        return 4; 
    }

    
    /**
     * 
     * @param opd1
     * @param opd2
     * @return null as this operator is not for execution
     */
    public Operand execute(Operand opd1, Operand opd2) {
       return null; 
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
     * @return the Paranthesis level of this operator.
     */
    public int paLevel()
    {
       return this.palevel;
    }
    
}
