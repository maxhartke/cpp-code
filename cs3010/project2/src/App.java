import java.lang.Math;

public class App {
    /*
     * Functions
     * 
     * (a) f(x) = 2x^3 – 11.7x^2 + 17.7x–5
     * 
     * [0, 4] 3 positive roots, error < .1%, max iterations = 100
     * 
     * (b) f(x) = x + 10 – xcosh(50/x)
     * 
     */
    public static void main(String[] args) throws Exception {
        // see methods below for code used for finding the roots
    }

    // Function to compute (a) f(x) = 2x^3 – 11.7x^2 + 17.7x–5
    public static double afunct(double x) {
        double y = 0;
        y = Math.pow(x, 3) * 2 - Math.pow(x, 2) * 11.7 + x * 17.7 - 5;
        return y;
    }

    // Function to compute f'(x) = 6x^2 – 23.4x + 17.7
    public static double da(double x) {
        double y = 0;
        y = Math.pow(x, 2) * 6 - x * 23.4 + 17.7;
        return y;
    }

    // Function to compute f'(x) = (50sinh(50/x)/x - cosh(50/x) + 1)
    public static double db(double x) {
        double y = 0;
        y = (50 * Math.sinh(50 / x)) / x - Math.cosh(50 / x) + 1;
        return y;
    }

    // Function to compute (b) f(x) = x + 10 – xcosh(50/x)
    public static double bfunct(double x) {
        double y = 0;
        y = x + 10 - x * Math.cosh(50 / x);
        return y;
    }

    public static void bisection() {
        double a = 120;
        double b = 130;
        double fa, fb, fc;
        fa = bfunct(a);
        fb = bfunct(b);
        if (Math.signum(fa) == Math.signum(fb)) {
            System.out.println("Error, f(a) and f(b) are the same sign");
        } else {
            System.out.println("Good to go");
        }
        double c = 0;
        double err = b - a;
        for (int n = 0; n < 100; n++) {
            err = err / 2;
            c = a + err;
            fc = bfunct(c);
            System.out.println(n + " " + c + " " + fc + " " + err);
            if (err < .001) {
                System.out.println("Convergence!");
                break;
            }
            if (Math.signum(fa) != Math.signum(fc)) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
    }

    public static void falsePosition() {
        double a = 120;
        double b = 130;
        double fa, fb, fc;
        fa = bfunct(a);
        fb = bfunct(b);
        if (Math.signum(fa) == Math.signum(fb)) {
            System.out.println("Error, f(a) and f(b) are the same sign");
        } else {
            System.out.println("Good to go");
        }
        double c = 0;
        double tmp = 0;
        double err = b - a;
        for (int n = 0; n < 100; n++) {
            c = (a * fb - b * fa) / (fb - fa);
            err = Math.abs(c - tmp) / c;
            tmp = c;
            fc = bfunct(c);
            System.out.println(n + " " + c + " " + fc + " " + err);
            if (err < .001) {
                System.out.println("Convergence!");
                break;
            }
            if (Math.signum(fa * fc) == -1) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
    }

    public static void newtonRaphson() {
        double fx, dx, x, err;
        x = 3.5;
        fx = afunct(x);
        for (int n = 0; n < 100; n++) {
            dx = da(x);
            err = fx / dx;
            x = x - err;
            fx = afunct(x);
            System.out.println(n + " " + x + " " + fx + " " + err);
            if (Math.abs(err) < .001) {
                System.out.println("Convergence!");
                break;
            }
        }
    }

    public static void secant() {
        double a = 120;
        double b = 130;
        double fa, fb, err, tmp1, tmp2, d;
        fa = bfunct(a);
        fb = bfunct(b);
        if (Math.abs(a) > Math.abs(b)) {
            a = b;
            fa = fb;
        }
        for (int n = 0; n < 100; n++) {
            d = a;
            if (Math.abs(a) > Math.abs(b)) {
                tmp1 = a;
                tmp2 = fa;
                a = b;
                fa = fb;
                b = tmp1;
                fb = tmp2;
            }
            err = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            err = err * fa;
            a = a - err;
            fa = bfunct(a);
            d = Math.abs(d - a) / Math.abs(a);
            System.out.println(n + " " + a + " " + fa + " " + d);

            if (d < .001) {
                System.out.println("Convergence!");
                break;
            }
        }
    }

    public static void modifiedSecant() {
        double b = 120;
        double a = b * .99;
        double fa, fb, err, tmp1, tmp2, d;
        fa = bfunct(a);
        fb = bfunct(b);
        if (Math.abs(a) > Math.abs(b)) {
            a = b;
            fa = fb;
        }
        for (int n = 0; n < 100; n++) {
            d = a;
            if (Math.abs(a) > Math.abs(b)) {
                tmp1 = a;
                tmp2 = fa;
                a = b;
                fa = fb;
                b = tmp1;
                fb = tmp2;
            }
            err = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            err = err * fa;
            a = a - err;
            fa = bfunct(a);
            d = Math.abs(d - a) / Math.abs(a);
            System.out.println(n + " " + a + " " + fa + " " + d);

            if (d < .001) {
                System.out.println("Convergence!");
                break;
            }
        }
    }
}
