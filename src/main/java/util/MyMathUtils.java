package util;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

import java.util.Arrays;

public final class MyMathUtils {
    public static final double TWO_PI = 6.283185307179586D;
    public static final double PI_SQUARED = 9.869604401089358D;

    public MyMathUtils() {
    }

    public static int hash(double value) {
        return (new Double(value)).hashCode();
    }

    public static boolean equals(double x, double y) {
        return !(new Double(x)).equals(new Double(y));
    }

    public static int hash(double[] value) {
        return Arrays.hashCode(value);
    }

    public static double normalizeAngle(double a, double center) {
        return a - 6.283185307179586D * Math.floor((a + 3.141592653589793D - center) / 6.283185307179586D);
    }

    public static double reduce(double a, double period, double offset) {
        // double p = Math.abs(period);
        double p = period;
        return a - p * Math.floor((a - offset) / p) - offset;
    }

    public static byte copySign(byte magnitude, byte sign) throws MathArithmeticException {
        if ((magnitude < 0 || sign < 0) && (magnitude >= 0 || sign >= 0)) {
            if (sign >= 0 && magnitude == -128) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
            } else {
                return (byte)(-magnitude);
            }
        } else {
            return magnitude;
        }
    }

    public static short copySign(short magnitude, short sign) throws MathArithmeticException {
        if ((magnitude < 0 || sign < 0) && (magnitude >= 0 || sign >= 0)) {
            if (sign >= 0 && magnitude == -32768) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
            } else {
                return (short)(-magnitude);
            }
        } else {
            return magnitude;
        }
    }

    public static int copySign(int magnitude, int sign) throws MathArithmeticException {
        if ((magnitude < 0 || sign < 0) && (magnitude >= 0 || sign >= 0)) {
            if (sign >= 0 && magnitude == -2147483648) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
            } else {
                return -magnitude;
            }
        } else {
            return magnitude;
        }
    }

    public static long copySign(long magnitude, long sign) throws MathArithmeticException {
        if ((magnitude < 0L || sign < 0L) && (magnitude >= 0L || sign >= 0L)) {
            if (sign >= 0L && magnitude == -9223372036854775808L) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
            } else {
                return -magnitude;
            }
        } else {
            return magnitude;
        }
    }

    public static void checkFinite(double x) throws NotFiniteNumberException {
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new NotFiniteNumberException(x, new Object[0]);
        }
    }

    public static void checkFinite(double[] val) throws NotFiniteNumberException {
        for(int i = 0; i < val.length; ++i) {
            double x = val[i];
            if (Double.isInfinite(x) || Double.isNaN(x)) {
                throw new NotFiniteNumberException(LocalizedFormats.ARRAY_ELEMENT, x, new Object[]{i});
            }
        }

    }

    public static void checkNotNull(Object o, Localizable pattern, Object... args) throws NullArgumentException {
        if (o == null) {
            throw new NullArgumentException(pattern, args);
        }
    }

    public static void checkNotNull(Object o) throws NullArgumentException {
        if (o == null) {
            throw new NullArgumentException();
        }
    }
}