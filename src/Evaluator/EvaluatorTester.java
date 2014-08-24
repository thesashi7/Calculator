
package Evaluator;

public class EvaluatorTester {

    public static void main(String[] args) {
        Evaluator anEvaluator = new Evaluator();
         System.out.println("main");
        for (String arg : args) {
            System.out.println("args");
            System.out.println(arg + " = " + anEvaluator.eval(arg));
        }
    }

}
