
package Operator;

import Evaluator.*;


/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Sub class EndOperator                                           * 
 Description : This class is used to represent an end of expression oeprator   *
 Date        : 9/4/2013.                                                      *
*******************************************************************************/
public class EndOperator extends Operator {

   
    /**
     * 
     * @return 0 
     */
    public int priority() {
        return 0;
    }

    /**
     * 
     * @param opd1
     * @param opd2
     * @return null
     */
    public Operand execute(Operand opd1, Operand opd2) {
        return null;
    }

    /**
     * This operator is not part of the real expression.
     * So no parantheis level required. Just 0.
     * @param numP 
     */
    public void addpalevel(int numP) 
    {
         
    }

    /**
     * 
     * @return 0.
     */
    public int paLevel() 
    {
        return 0; 
    }
    
 
}
