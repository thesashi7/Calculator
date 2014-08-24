
package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class AdditionOperator                                      *       
 Description : This class represents a closing bracket operator "(" in         *
               numerical expressions.                                          *
 Date        : 9/4/2013.                                                       *
*******************************************************************************/
public class ClosingBracket extends Operator
{

    private int palevel=0;
    
    /**
     * 
     * @return 5 as the priority of ')'operator.
     */
    public int priority() {
        return 5; 
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return null
     */
    public Operand execute(Operand opd1, Operand opd2) {
        return  null; 
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
     * @return the level of paranthesis.
     */
    public int paLevel()
    {
       return this.palevel;
    }
  
}
