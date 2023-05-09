package lab2;

import java.text.NumberFormat;

public class Abs implements Function{
    private final Function fx;

    public Abs(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.abs(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return Multiplication.of(Multiplication.of(fx,Power.of(Abs.of(fx),-1)),fx.derivative());
    }



    @Override
    public String toPrettyString(NumberFormat nf) {
        return "|"+fx.toPrettyString(nf)+"|";
    }

    public static Abs of(Function fx) {
        return new Abs(fx);
    }
}
