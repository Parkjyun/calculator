import java.util.Scanner;

public class Main {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException();
        }
        return a/b;
    }

    public static double calculate(double firstvalue, char operator, double secondvalue){

        if(operator == '+')
            return add(firstvalue, secondvalue);

        if(operator == '-')
            return subtract(firstvalue, secondvalue);

        if(operator == '*')
            return multiply(firstvalue,secondvalue);

        if(operator == '/')
            return divide(firstvalue, secondvalue);
        System.out.println("잘못된 값 입력");
        throw new IllegalArgumentException();

    }
    // 공백으로 숫자와 기호들을 구분한다.
    public static String[] seperate(String str){
        return str.split(" ");
    }

    public static double toDouble(String str){
        return Double.parseDouble(str);
    }

    public static double calculateString(String[] str){
        double result = toDouble(str[0]); //미리 작성했던 메소드를 이용
        for(int i = 0; i < str.length - 2; i += 2){
            result = calculate(result, str[i + 1].charAt(0), toDouble(str[i + 2])); //charAt 을 이용해서 String 한글자를 char로 변경

        }
        return result;
    }

    public static String input() {
        String str = new Scanner(System.in).nextLine();
        String[] strarr = str.split(" ");

        return str;
    }

    public static void main(String[] args) {
        String expression = input();
        String[] seperateExpression = seperate(expression);
        try {
            double num = calculateString(seperateExpression);
            System.out.println(num);
        } catch (IllegalArgumentException e) {
            System.out.println("제대로 된 수식을 입력하세요");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        }




    }
}