

package Operator;

import Evaluator.*;



/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class SpaceOperator                                         * 
 Description : This class is used to represent a end oeprator.                *
 Date        : 9/4/2013.                                                      *
*******************************************************************************/
public class SpaceOperator extends Operator
{

    /**
     * 
     * @return prirority of '#'Operator
     */
    public int priority() {
        return 1;
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return null
     */
    public Operand execute(Operand opd1, Operand opd2)
    {
        return null;
    }

   /**
    * This operators paranthesis level is 0 
    * @param numP 
    */
    public void addpalevel(int numP) 
    {
        
    }

    /**
     * 
     * @return 0 because this operator is not part of the real expression.
     */
    public int paLevel()
    {
       return 0; 
    }
    
}
