package org.spongycastle.crypto.generators;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;

public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private static int[] f26849a = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    /* renamed from: c */
    private static final BigInteger f26850c = BigInteger.valueOf(1);
    /* renamed from: b */
    private NaccacheSternKeyGenerationParameters f26851b;

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        NaccacheSternKeyPairGenerator naccacheSternKeyPairGenerator;
        int i;
        BigInteger add;
        BigInteger a;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        int b = this.f26851b.m27325b();
        Random a2 = this.f26851b.m27324a();
        int c = this.f26851b.m35692c();
        boolean e = this.f26851b.m35694e();
        if (e) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fetching first ");
            stringBuilder.append(naccacheSternKeyPairGenerator.f26851b.m35693d());
            stringBuilder.append(" primes.");
            printStream.println(stringBuilder.toString());
        }
        Vector a3 = m35348a(m35347a(naccacheSternKeyPairGenerator.f26851b.m35693d()), (SecureRandom) a2);
        BigInteger bigInteger3 = f26850c;
        BigInteger bigInteger4 = f26850c;
        BigInteger bigInteger5 = bigInteger3;
        for (i = 0; i < a3.size() / 2; i++) {
            bigInteger5 = bigInteger5.multiply((BigInteger) a3.elementAt(i));
        }
        for (i = a3.size() / 2; i < a3.size(); i++) {
            bigInteger4 = bigInteger4.multiply((BigInteger) a3.elementAt(i));
        }
        bigInteger3 = bigInteger5.multiply(bigInteger4);
        int bitLength = (((b - bigInteger3.bitLength()) - 48) / 2) + 1;
        BigInteger a4 = m35346a(bitLength, c, a2);
        BigInteger a5 = m35346a(bitLength, c, a2);
        if (e) {
            System.out.println("generating p and q");
        }
        bigInteger5 = a4.multiply(bigInteger5).shiftLeft(1);
        bigInteger4 = a5.multiply(bigInteger4).shiftLeft(1);
        long j = 0;
        while (true) {
            BigInteger bigInteger6;
            BigInteger bigInteger7;
            long j2 = j + 1;
            BigInteger a6 = m35346a(24, c, a2);
            add = a6.multiply(bigInteger5).add(f26850c);
            if (add.isProbablePrime(c)) {
                while (true) {
                    while (true) {
                        a = m35346a(24, c, a2);
                        if (!a6.equals(a)) {
                            break;
                        }
                    }
                    bigInteger6 = bigInteger4;
                    bigInteger4 = a.multiply(bigInteger4).add(f26850c);
                    if (bigInteger4.isProbablePrime(c)) {
                        break;
                    }
                    int i2 = b;
                    Random random = a2;
                    bigInteger4 = bigInteger6;
                }
                bigInteger7 = bigInteger5;
                if (bigInteger3.gcd(a6.multiply(a)).equals(f26850c)) {
                    if (add.multiply(bigInteger4).bitLength() >= b) {
                        break;
                    } else if (e) {
                        PrintStream printStream2 = System.out;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("key size too small. Should be ");
                        stringBuilder2.append(b);
                        stringBuilder2.append(" but is actually ");
                        stringBuilder2.append(add.multiply(bigInteger4).bitLength());
                        printStream2.println(stringBuilder2.toString());
                    }
                }
            } else {
                bigInteger6 = bigInteger4;
                bigInteger7 = bigInteger5;
            }
            j = j2;
            bigInteger4 = bigInteger6;
            bigInteger5 = bigInteger7;
            naccacheSternKeyPairGenerator = this;
        }
        if (e) {
            PrintStream printStream3 = System.out;
            StringBuilder stringBuilder3 = new StringBuilder();
            bigInteger = a5;
            stringBuilder3.append("needed ");
            stringBuilder3.append(j2);
            stringBuilder3.append(" tries to generate p and q.");
            printStream3.println(stringBuilder3.toString());
        } else {
            bigInteger = a5;
        }
        bigInteger5 = add.multiply(bigInteger4);
        BigInteger multiply = add.subtract(f26850c).multiply(bigInteger4.subtract(f26850c));
        if (e) {
            System.out.println("generating g");
        }
        long j3 = 0;
        while (true) {
            Object obj;
            BigInteger bigInteger8;
            PrintStream printStream4;
            StringBuilder stringBuilder4;
            Vector vector = new Vector();
            BigInteger bigInteger9 = bigInteger4;
            BigInteger bigInteger10 = add;
            long j4 = j3;
            int i3 = 0;
            while (i3 != a3.size()) {
                long j5;
                BigInteger divide = multiply.divide((BigInteger) a3.elementAt(i3));
                while (true) {
                    j5 = j4 + 1;
                    bigInteger4 = new BigInteger(b, c, a2);
                    i2 = b;
                    if (!bigInteger4.modPow(divide, bigInteger5).equals(f26850c)) {
                        break;
                    }
                    j4 = j5;
                    b = i2;
                }
                vector.addElement(bigInteger4);
                i3++;
                j4 = j5;
                b = i2;
            }
            i2 = b;
            bigInteger2 = f26850c;
            b = 0;
            while (b < a3.size()) {
                random = a2;
                bigInteger2 = bigInteger2.multiply(((BigInteger) vector.elementAt(b)).modPow(bigInteger3.divide((BigInteger) a3.elementAt(b)), bigInteger5)).mod(bigInteger5);
                b++;
                a2 = random;
            }
            random = a2;
            b = 0;
            while (b < a3.size()) {
                PrintStream printStream5;
                StringBuilder stringBuilder5;
                if (bigInteger2.modPow(multiply.divide((BigInteger) a3.elementAt(b)), bigInteger5).equals(f26850c)) {
                    if (e) {
                        printStream5 = System.out;
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("g has order phi(n)/");
                        stringBuilder5.append(a3.elementAt(b));
                        stringBuilder5.append("\n g: ");
                        stringBuilder5.append(bigInteger2);
                        printStream5.println(stringBuilder5.toString());
                    }
                    obj = 1;
                    if (obj == null) {
                        if (bigInteger2.modPow(multiply.divide(BigInteger.valueOf(4)), bigInteger5).equals(f26850c)) {
                            if (bigInteger2.modPow(multiply.divide(a6), bigInteger5).equals(f26850c)) {
                                if (bigInteger2.modPow(multiply.divide(a), bigInteger5).equals(f26850c)) {
                                    if (bigInteger2.modPow(multiply.divide(a4), bigInteger5).equals(f26850c)) {
                                        bigInteger8 = bigInteger;
                                        if (bigInteger2.modPow(multiply.divide(bigInteger8), bigInteger5).equals(f26850c)) {
                                            break;
                                        }
                                        if (e) {
                                            printStream5 = System.out;
                                            stringBuilder5 = new StringBuilder();
                                            stringBuilder5.append("g has order phi(n)/b\n g: ");
                                            stringBuilder5.append(bigInteger2);
                                            printStream5.println(stringBuilder5.toString());
                                        }
                                        bigInteger = bigInteger8;
                                        j3 = j4;
                                        add = bigInteger10;
                                        bigInteger4 = bigInteger9;
                                        b = i2;
                                        a2 = random;
                                    } else if (e) {
                                        printStream4 = System.out;
                                        stringBuilder4 = new StringBuilder();
                                        stringBuilder4.append("g has order phi(n)/a\n g: ");
                                        stringBuilder4.append(bigInteger2);
                                        printStream4.println(stringBuilder4.toString());
                                    }
                                } else if (e) {
                                    printStream4 = System.out;
                                    stringBuilder4 = new StringBuilder();
                                    stringBuilder4.append("g has order phi(n)/q'\n g: ");
                                    stringBuilder4.append(bigInteger2);
                                    printStream4.println(stringBuilder4.toString());
                                }
                            } else if (e) {
                                printStream4 = System.out;
                                stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("g has order phi(n)/p'\n g: ");
                                stringBuilder4.append(bigInteger2);
                                printStream4.println(stringBuilder4.toString());
                            }
                        } else if (e) {
                            printStream4 = System.out;
                            stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("g has order phi(n)/4\n g:");
                            stringBuilder4.append(bigInteger2);
                            printStream4.println(stringBuilder4.toString());
                        }
                    }
                    bigInteger8 = bigInteger;
                    bigInteger = bigInteger8;
                    j3 = j4;
                    add = bigInteger10;
                    bigInteger4 = bigInteger9;
                    b = i2;
                    a2 = random;
                } else {
                    b++;
                }
            }
            obj = null;
            if (obj == null) {
                if (bigInteger2.modPow(multiply.divide(BigInteger.valueOf(4)), bigInteger5).equals(f26850c)) {
                    if (bigInteger2.modPow(multiply.divide(a6), bigInteger5).equals(f26850c)) {
                        if (bigInteger2.modPow(multiply.divide(a), bigInteger5).equals(f26850c)) {
                            if (bigInteger2.modPow(multiply.divide(a4), bigInteger5).equals(f26850c)) {
                                bigInteger8 = bigInteger;
                                if (bigInteger2.modPow(multiply.divide(bigInteger8), bigInteger5).equals(f26850c)) {
                                    break;
                                }
                                if (e) {
                                    printStream5 = System.out;
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("g has order phi(n)/b\n g: ");
                                    stringBuilder5.append(bigInteger2);
                                    printStream5.println(stringBuilder5.toString());
                                }
                                bigInteger = bigInteger8;
                                j3 = j4;
                                add = bigInteger10;
                                bigInteger4 = bigInteger9;
                                b = i2;
                                a2 = random;
                            } else if (e) {
                                printStream4 = System.out;
                                stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("g has order phi(n)/a\n g: ");
                                stringBuilder4.append(bigInteger2);
                                printStream4.println(stringBuilder4.toString());
                            }
                        } else if (e) {
                            printStream4 = System.out;
                            stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("g has order phi(n)/q'\n g: ");
                            stringBuilder4.append(bigInteger2);
                            printStream4.println(stringBuilder4.toString());
                        }
                    } else if (e) {
                        printStream4 = System.out;
                        stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("g has order phi(n)/p'\n g: ");
                        stringBuilder4.append(bigInteger2);
                        printStream4.println(stringBuilder4.toString());
                    }
                } else if (e) {
                    printStream4 = System.out;
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("g has order phi(n)/4\n g:");
                    stringBuilder4.append(bigInteger2);
                    printStream4.println(stringBuilder4.toString());
                }
            }
            bigInteger8 = bigInteger;
            bigInteger = bigInteger8;
            j3 = j4;
            add = bigInteger10;
            bigInteger4 = bigInteger9;
            b = i2;
            a2 = random;
        }
        if (e) {
            printStream5 = System.out;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("needed ");
            stringBuilder6.append(j4);
            stringBuilder6.append(" tries to generate g");
            printStream5.println(stringBuilder6.toString());
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            printStream5 = System.out;
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("smallPrimes: ");
            stringBuilder6.append(a3);
            printStream5.println(stringBuilder6.toString());
            printStream5 = System.out;
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("sigma:...... ");
            stringBuilder6.append(bigInteger3);
            stringBuilder6.append(" (");
            stringBuilder6.append(bigInteger3.bitLength());
            stringBuilder6.append(" bits)");
            printStream5.println(stringBuilder6.toString());
            printStream5 = System.out;
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("a:.......... ");
            stringBuilder6.append(a4);
            printStream5.println(stringBuilder6.toString());
            printStream5 = System.out;
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("b:.......... ");
            stringBuilder6.append(bigInteger8);
            printStream5.println(stringBuilder6.toString());
            printStream4 = System.out;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("p':......... ");
            stringBuilder4.append(a6);
            printStream4.println(stringBuilder4.toString());
            printStream4 = System.out;
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("q':......... ");
            stringBuilder4.append(a);
            printStream4.println(stringBuilder4.toString());
            printStream2 = System.out;
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append("p:.......... ");
            stringBuilder7.append(bigInteger10);
            printStream2.println(stringBuilder7.toString());
            printStream2 = System.out;
            stringBuilder7 = new StringBuilder();
            stringBuilder7.append("q:.......... ");
            stringBuilder7.append(bigInteger9);
            printStream2.println(stringBuilder7.toString());
            printStream2 = System.out;
            stringBuilder7 = new StringBuilder();
            stringBuilder7.append("n:.......... ");
            stringBuilder7.append(bigInteger5);
            printStream2.println(stringBuilder7.toString());
            printStream2 = System.out;
            stringBuilder7 = new StringBuilder();
            stringBuilder7.append("phi(n):..... ");
            stringBuilder7.append(multiply);
            printStream2.println(stringBuilder7.toString());
            printStream2 = System.out;
            stringBuilder7 = new StringBuilder();
            stringBuilder7.append("g:.......... ");
            stringBuilder7.append(bigInteger2);
            printStream2.println(stringBuilder7.toString());
            System.out.println();
        }
        return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, bigInteger2, bigInteger5, bigInteger3.bitLength()), new NaccacheSternPrivateKeyParameters(bigInteger2, bigInteger5, bigInteger3.bitLength(), a3, multiply));
    }

    /* renamed from: a */
    private static BigInteger m35346a(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    /* renamed from: a */
    private static Vector m35348a(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != null) {
            vector2.insertElementAt(vector3.elementAt(0), m35345a(secureRandom, vector2.size() + 1));
            vector3.removeElementAt(0);
        }
        return vector2;
    }

    /* renamed from: a */
    private static int m35345a(SecureRandom secureRandom, int i) {
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() & 2147483647))) >> 31);
        }
        int i2;
        int nextInt;
        do {
            nextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = nextInt % i;
        } while ((nextInt - i2) + (i - 1) < 0);
        return i2;
    }

    /* renamed from: a */
    private static Vector m35347a(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf((long) f26849a[i2]));
        }
        return vector;
    }
}
