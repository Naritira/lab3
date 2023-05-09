package lab2;

import java.text.NumberFormat;

public class Sin implements Function{
    private final Function fx;

    public Sin(Function fx) {
        this.fx = fx;
    }

    public static Sin of(Function fx) {
        return new Sin(fx);
    }

    @Override
    public double calculate(double x) {
        return Math.sin(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return Multiplication.of((Function) Cos.of(fx), fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sin("+fx.toPrettyString(nf)+")";
    }
}
