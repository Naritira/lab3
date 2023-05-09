

import lab2.*;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final double A = 0.1;
        final double B = 0.2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть x: ");
        double x = scan.nextDouble();
        System.out.format("a = %f", A).println();
        System.out.format("b = %f", B).println();
        System.out.format("x = %f", x).println();

        final Function expression = Sum.of(
                Multiplication.of(Const.of(A),
                        Power.of(
                                Sinh.of(Linear.X), 3
                        )
                ),Multiplication.of(
                        Const.NEGATIVE_ONE, Abs.of(
                                Multiplication.of(
                                        Const.of(B),Cosh.of(
                                                Sqrt.of(
                                                        Power.of(
                                                                Sum.of(
                                                                        Const.of(A),Linear.X), 5
                                                        ),2
                                                )
                                        )
                                )
                        )
                )
        );
        final NumberFormat nf = NumberFormat.getInstance();
        System.out.format("f(x) = %s",expression.toPrettyString(nf)).println();
        System.out.format("f'(x) = %s",expression.derivative().toPrettyString(nf)).println();
        System.out.format("f(x) = %s",expression.calculate(x)).println();
        System.out.format("f'(x) = %s",expression.derivative().calculate(x)).println();

        final Function expression2 = Multiplication.of(
                Linear.X,Power.of(
                        Cos.of(
                                Power.of(
                                        Abs.of(
                                                Sum.of(
                                                        Linear.of(A),Const.of(B)
                                                )
                                        ),3
                                )
                        ),2
                )
        );

        final NumberFormat nf2 = NumberFormat.getInstance();
        System.out.format("f(x) = %s",expression2.toPrettyString(nf)).println();
        System.out.format("f'(x) = %s",expression2.derivative().toPrettyString(nf)).println();
        System.out.format("f(x) = %s",expression2.calculate(x)).println();
        System.out.format("f'(x) = %s",expression2.derivative().calculate(x)).println();
    }
}