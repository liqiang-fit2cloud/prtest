public class HelloWorld {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 20;
        int sum = add(number1, number2);
        System.out.println("The sum is: " + sum);
    }
 
    public static int add(int a, int b) {
        return a + b;
    }
}
