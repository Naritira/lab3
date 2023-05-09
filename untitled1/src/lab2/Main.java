package lab2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        final double a = 0.1;
        final double b = 0.2;
        final double x = 0.3;
        System.out.format("a = %f", a).println();
        System.out.format("b = %f", b).println();
        System.out.format("x = %f", x).println();

        final Function expression = Sum.of(
                Multiplication.of(Const.of(a),
                        Power.of(
                               Sinh.of(Linear.X), 3
                        )
                ),Multiplication.of(
                        Const.NEGATIVE_ONE, Abs.of(
                                Multiplication.of(
                                        Const.of(b),Cosh.of(
                                                Sqrt.of(
                                                        Power.of(
                                                                Sum.of(
                                                                        Const.of(a),Linear.X), 5
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
    System.out.format("f(1) = %f",expression.calculate(x)).println();
    System.out.format("f'(1) =%f",expression.derivative().calculate(x)).println();
    final Function expression2 =Multiplication.of(
                Linear.X,Power.of(
                        Cos.of(
                                Power.of(
                                        Abs.of(
                                                Sum.of(
                                                        Linear.of(a),Const.of(b)
                                                )
                                        ),3
                                )
                        ),2
                )
        );
        final NumberFormat nff = NumberFormat.getInstance();
        System.out.format("f(x) = %s",expression2.toPrettyString(nf)).println();
        System.out.format("f'(x) = %s",expression2.derivative().toPrettyString(nf)).println();
        System.out.format("f(2) = %f",expression2.calculate(x)).println();
        System.out.format("f'(2) =%f",expression2.derivative().calculate(x)).println();
    }
}


