package Evaluator;

/*******************************************************************************
 Author      : Sashi B Thapaliya                                               *
 Program     : Evaluator                                                       * 
 Description : This Evaluator class evaluates simple numerical expressions based
               on operator's priority                                          *
               Like '*' and '/' have the highest priority                      *
               And '#' and '!' operators are used to make a boundary while     * 
               evaluating according to the priority of operators               *
               Example: Multiplication '*' and Division '/' gets executed before
               addition '+' and subtraction '-'.                               *
               Also handles paranthesis "()"                                   *
 Date        : 9/4/2013                                                        *
*******************************************************************************/
import Operator.AdditionOperator;
import Operator.ClosingBracket;
import Operator.DivisionOperator;
import Operator.MutliplicationOperator;
import Operator.OpeningBracket;
import Operator.Operator;
import Operator.SubtractionOperator;
import java.util.*;


public class Evaluator
{

    private Stack<Operand> opdStack;
    private Stack<Operator> oprStack;
    
    /**
     * Default CONSTRUCTOR 
     * Initializes the types(opdStack, oprStack).
     **/
    public Evaluator() {
        opdStack = new Stack<Operand>();
        oprStack = new Stack<Operator>();
    }
    
    /**
     * Takes in the expression to be evaluated as a String
     * Evaluates the expression according to the priority of the operators
     * In which '*' and '/' have the highest priority
     * @returns integer -- the result of the evaluation.
     */
    public int eval(String expr) 
    {
        String tok, delimiters = "(+-*/#!) ";
        StringTokenizer st = new StringTokenizer(expr, delimiters, true);
        StringTokenizer endT = new StringTokenizer("!","!",true);
        Operator newOpr;
        HashMap operators;
        int foundP=0; // if "(" found then increase so this indicates the paranthesis level for the operators
                       // or the number of paranthesis.
        int ans=0;
        
        Operator.setOperators();
        operators = Operator.operators;
        
       
        oprStack.push((Operator)Operator.operators.get("#"));



        while (st.hasMoreTokens())
        {
            tok=st.nextToken();
            //System.out.println(tok);
            if (!tok.equals(" ")) 
            { 
                if (Operand.check(tok)) 
                {
                    opdStack.push(new Operand(tok));
                    //check if the expression ends with an operand
                    // If so then need to assign the string tokenizer to an end of line marker 
                    //   So, that the loop continues and the expression is evaluated.
                    if(!st.hasMoreTokens()) st=endT; 
                } 
                else 
                {
                    if (!Operator.check(tok))
                    {
                       System.out.println("***********Invalid Token*************");
                       //System.exit(1);
                    }
                     newOpr = (Operator) Operator.operators.get(tok);   // POINT 1
                     
                     //Need to get a new object or else the reference might be given to an existing operator object
                     // And it will increase the Paranthesis level in all places by just increasing in one place
                     // So from this all the newOpr will be an independent object
                     if(newOpr.priority()!=0)newOpr= instanceOp(newOpr);
                     newOpr.addpalevel(foundP); //assigning the number of paranthesis inside which this newOpr is found.
                     
                    //Check if Opening Brackets is found. If so then number of Paranthesis is increased
                    if(newOpr.priority()==4) foundP++;
                    else if(newOpr.priority()==5) foundP--;  // If Closing brackets is found number of paranthesis is decreased
                    
                    while(oprStack.peek().priority()>=newOpr.priority())
                    {   
                        
                     
                        //Should not execute if an opening bracket is encountered
                        // or "#" is encountered 
                       if(oprStack.peek().priority()!=1 && oprStack.peek().priority()!=4)
                       {    
                           //check if the operators are a fair number of paranthesis 
                           //So that it can be properly evaluated
                           if(oprStack.peek().paLevel()>= newOpr.paLevel()  ) calc();
                           else break;
                           //if(CheckEndBracketsReached(oPFlag, cPFlag)>0){calc();}
                           //else if(newOpr.priority()==oprStack.peek().priority()){ break;}
                       
                       }
                       else 
                       {
                          //Should come here at the end when all the execution is completed.
                          // swaping the operators so that the loop stops.
                         oprStack.pop();
                         break;
                       }
                      
                    }
                   
                   
                    //(Check)If expression ends with a paranthesis operator then we need to assing endToken to the 
                    //String tokenizer so that the loop continues with next token being the end marker operator 
                    // Then the expression will be evaluated
                    if(newOpr.priority()==5 && !st.hasMoreTokens()) st= endT;
                    
                    oprStack.push(newOpr); 
                }
                
            }
            
          
        }
        
        ans =opdStack.pop().getValue();
        
        return ans;
    }


   
   
    /**
     * Executes the Operator at the top of the oprStack by using operands fromm 
     * the top of the opdStack
     * (oprStack must have a proper operator and opdStack must have at least two
     *  operands).
     */
    private void calc()
    {
       Operand op1=opdStack.pop();
       Operand op2=opdStack.pop();
       Operator opr= oprStack.pop();
       
        //if we encounter ending brackets then need to get a valid operator to execute
       if(opr.priority()==5) opr=oprStack.pop();
       
       opdStack.push(opr.execute(op1, op2));
    }
    
    /**
     * Gives a new object in each call.
     * @param op
     * @return reference to a new instance of the type of Operator object passed
     */
    private Operator instanceOp(Operator op)
    {
       if(op instanceof AdditionOperator) return new AdditionOperator();
       else if(op instanceof SubtractionOperator) return new SubtractionOperator();
       else if(op instanceof MutliplicationOperator) return new MutliplicationOperator();
       else if (op instanceof DivisionOperator) return new DivisionOperator();
       else if (op instanceof OpeningBracket) return new OpeningBracket();
       return new ClosingBracket();
       
     }
   
}

//**********************************************************************************
//**********************************************************************************
//                   THIS IS A TEST CLASS FOR EVALUATOR.
//**********************************************************************************
class tesTE {

    public static void main(String[] args) {
        Evaluator ev = new Evaluator();
        Scanner input = new Scanner(System.in);
        int i = 1;
        String[] expr= new String[30];
        Operator.setOperators();
        System.out.println(Operator.check("("));
        Operator oper;
        oper= (Operator)new AdditionOperator();
        oper.addpalevel(3);
        System.out.println("paLevel:"+oper.paLevel());
        oper  = new SubtractionOperator();
        System.out.println("paLevel:"+oper.paLevel());
        
        expr[0]="(2+2)*10";
        expr[1]="2+2+2";
        expr[2]="2+2*10";
        expr[3]="2+2+10+2+10*2";
        expr[4]="2+2+10+2+10+10";
        expr[5]="2+2+10/5";
        expr[6]="2+2*10+10/5";
        expr[7]="2+2*10+10/5+2+2+10";
        expr[8]="10/1*10";
        expr[9]="2+4+4/1+10";
        expr[10]="2+2+10/5*2/2*10";
        expr[11]="1+10*10/2";
        expr[12]="2*2*2";
        expr[13]="100+20/5+2*2*2*2*2*2";
        expr[14]="100+20/5*2*2*2*2*2*2";
        expr[15]="10+10+10+100/100*10/5/2*20/2/5";        
        expr[16]="10-10-10+10+10+10+100/100*10/5/2*20/2/5";                         //22
        expr[17]="10+2+1+10-3-1*30/5/3*2*10/2*10+10+10";                            //-160
        expr[18]="10+2+1+10-3-1*30/5/3*2*10/2*10+10+10-160+320";                    //0
        expr[19]="10/5+2+2+10*10+1-1+20/5+2*20+10+1+1";                             //162
        expr[20]="(2+2)*10";
        expr[21]="2*(10+2)";
        expr[22]="2*2+(10*2/5)";
        expr[23]="(10/5+2+2+10)*10+1-1+20/5+2*20+10+1+1";
        expr[24]="(10/5+2+2+10)*(10+1-1+20/5+2*20+10+1+1)";
        expr[25]="(2+2)*(2-2)";
        expr[26]="(2+2)*(10/2)*(10-5)+(10/10)";
        expr[27]="(2*(2+5*(1+1)))";
        expr[28]="(10*(100*2+(2*50*2-(100+100))))";
        System.out.println("=========================================");
      
        for(int j=0; j<29; j++){ System.out.println(expr[j]+"=" + ev.eval(expr[j]));}

        while (i==1) {
            System.out.print("Enter expression: ");
            String[] expres = {input.next()};

            EvaluatorTester.main(expres);

        }

    }
}