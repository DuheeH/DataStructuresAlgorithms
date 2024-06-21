/*
 * Compliation: javac HelloGoodbye.java
 *  Execution: java HelloGoodbye Name1 Name2
 *
 *  Print Names in a hello and subsequent goodbye message
 *
 *  % java HelloGoodbye John Jill
 *  Hello John and Jill
 *  Goodbye John and Jill
 *
 */
public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
