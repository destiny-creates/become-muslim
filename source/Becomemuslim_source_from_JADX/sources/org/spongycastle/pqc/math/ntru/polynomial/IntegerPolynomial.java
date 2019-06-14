package org.spongycastle.pqc.math.ntru.polynomial;

import co.apptailor.googlesignin.RNGoogleSigninModule;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

public class IntegerPolynomial implements Polynomial {
    /* renamed from: b */
    private static final int[] f27877b = new int[]{4507, 4513, 4517, 4519, 4523, 4547, 4549, 4561, 4567, 4583, 4591, 4597, 4603, 4621, 4637, 4639, 4643, 4649, 4651, 4657, 4663, 4673, 4679, 4691, 4703, 4721, 4723, 4729, 4733, 4751, 4759, 4783, 4787, 4789, 4793, 4799, 4801, 4813, 4817, 4831, 4861, 4871, 4877, 4889, 4903, 4909, 4919, 4931, 4933, 4937, 4943, 4951, 4957, 4967, 4969, 4973, 4987, 4993, 4999, 5003, 5009, 5011, 5021, 5023, 5039, 5051, 5059, 5077, 5081, 5087, 5099, 5101, 5107, 5113, 5119, 5147, 5153, 5167, 5171, 5179, 5189, 5197, 5209, 5227, 5231, 5233, 5237, 5261, 5273, 5279, 5281, 5297, 5303, 5309, 5323, 5333, 5347, 5351, 5381, 5387, 5393, 5399, 5407, 5413, 5417, 5419, 5431, 5437, 5441, 5443, 5449, 5471, 5477, 5479, 5483, 5501, 5503, 5507, 5519, 5521, 5527, 5531, 5557, 5563, 5569, 5573, 5581, 5591, 5623, 5639, 5641, 5647, 5651, 5653, 5657, 5659, 5669, 5683, 5689, 5693, 5701, 5711, 5717, 5737, 5741, 5743, 5749, 5779, 5783, 5791, 5801, 5807, 5813, 5821, 5827, 5839, 5843, 5849, 5851, 5857, 5861, 5867, 5869, 5879, 5881, 5897, 5903, 5923, 5927, 5939, 5953, 5981, 5987, 6007, 6011, 6029, 6037, 6043, 6047, 6053, 6067, 6073, 6079, 6089, 6091, 6101, 6113, 6121, 6131, 6133, 6143, 6151, 6163, 6173, 6197, 6199, 6203, 6211, 6217, 6221, 6229, 6247, 6257, 6263, 6269, 6271, 6277, 6287, 6299, 6301, 6311, 6317, 6323, 6329, 6337, 6343, 6353, 6359, 6361, 6367, 6373, 6379, 6389, 6397, 6421, 6427, 6449, 6451, 6469, 6473, 6481, 6491, 6521, 6529, 6547, 6551, 6553, 6563, 6569, 6571, 6577, 6581, 6599, 6607, 6619, 6637, 6653, 6659, 6661, 6673, 6679, 6689, 6691, 6701, 6703, 6709, 6719, 6733, 6737, 6761, 6763, 6779, 6781, 6791, 6793, 6803, 6823, 6827, 6829, 6833, 6841, 6857, 6863, 6869, 6871, 6883, 6899, 6907, 6911, 6917, 6947, 6949, 6959, 6961, 6967, 6971, 6977, 6983, 6991, 6997, 7001, 7013, 7019, 7027, 7039, 7043, 7057, 7069, 7079, 7103, 7109, 7121, 7127, 7129, 7151, 7159, 7177, 7187, 7193, 7207, 7211, 7213, 7219, 7229, 7237, 7243, 7247, 7253, 7283, 7297, 7307, 7309, 7321, 7331, 7333, 7349, 7351, 7369, 7393, 7411, 7417, 7433, 7451, 7457, 7459, 7477, 7481, 7487, 7489, 7499, 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583, 7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691, 7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823, 7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919, 7927, 7933, 7937, 7949, 7951, 7963, 7993, 8009, 8011, 8017, 8039, 8053, 8059, 8069, 8081, 8087, 8089, 8093, 8101, 8111, 8117, 8123, 8147, 8161, 8167, 8171, 8179, 8191, 8209, 8219, 8221, 8231, 8233, 8237, 8243, 8263, 8269, 8273, 8287, 8291, 8293, 8297, 8311, 8317, 8329, 8353, 8363, 8369, 8377, 8387, 8389, 8419, 8423, 8429, 8431, 8443, 8447, 8461, 8467, 8501, 8513, 8521, 8527, 8537, 8539, 8543, 8563, 8573, 8581, 8597, 8599, 8609, 8623, 8627, 8629, 8641, 8647, 8663, 8669, 8677, 8681, 8689, 8693, 8699, 8707, 8713, 8719, 8731, 8737, 8741, 8747, 8753, 8761, 8779, 8783, 8803, 8807, 8819, 8821, 8831, 8837, 8839, 8849, 8861, 8863, 8867, 8887, 8893, 8923, 8929, 8933, 8941, 8951, 8963, 8969, 8971, 8999, RNGoogleSigninModule.RC_SIGN_IN, 9007, 9011, 9013, 9029, 9041, 9043, 9049, 9059, 9067, 9091, 9103, 9109, 9127, 9133, 9137, 9151, 9157, 9161, 9173, 9181, 9187, 9199, 9203, 9209, 9221, 9227, 9239, 9241, 9257, 9277, 9281, 9283, 9293, 9311, 9319, 9323, 9337, 9341, 9343, 9349, 9371, 9377, 9391, 9397, 9403, 9413, 9419, 9421, 9431, 9433, 9437, 9439, 9461, 9463, 9467, 9473, 9479, 9491, 9497, 9511, 9521, 9533, 9539, 9547, 9551, 9587, 9601, 9613, 9619, 9623, 9629, 9631, 9643, 9649, 9661, 9677, 9679, 9689, 9697, 9719, 9721, 9733, 9739, 9743, 9749, 9767, 9769, 9781, 9787, 9791, 9803, 9811, 9817, 9829, 9833, 9839, 9851, 9857, 9859, 9871, 9883, 9887, 9901, 9907, 9923, 9929, 9931, 9941, 9949, 9967, 9973};
    /* renamed from: c */
    private static final List f27878c = new ArrayList();
    /* renamed from: a */
    public int[] f27879a;

    private class CombineTask implements Callable<ModularResultant> {
        /* renamed from: a */
        private ModularResultant f23413a;
        /* renamed from: b */
        private ModularResultant f23414b;

        public /* synthetic */ Object call() {
            return m29316a();
        }

        /* renamed from: a */
        public ModularResultant m29316a() {
            return ModularResultant.m36578a(this.f23413a, this.f23414b);
        }
    }

    private class ModResultantTask implements Callable<ModularResultant> {
        /* renamed from: a */
        final /* synthetic */ IntegerPolynomial f23415a;
        /* renamed from: b */
        private int f23416b;

        public /* synthetic */ Object call() {
            return m29317a();
        }

        /* renamed from: a */
        public ModularResultant m29317a() {
            return this.f23415a.m36554c(this.f23416b);
        }
    }

    static {
        for (int i = 0; i != f27877b.length; i++) {
            f27878c.add(BigInteger.valueOf((long) f27877b[i]));
        }
    }

    public IntegerPolynomial(int i) {
        this.f27879a = new int[i];
    }

    public IntegerPolynomial(int[] iArr) {
        this.f27879a = iArr;
    }

    public IntegerPolynomial(BigIntPolynomial bigIntPolynomial) {
        this.f27879a = new int[bigIntPolynomial.f23409a.length];
        for (int i = 0; i < bigIntPolynomial.f23409a.length; i++) {
            this.f27879a[i] = bigIntPolynomial.f23409a[i].intValue();
        }
    }

    /* renamed from: a */
    public static IntegerPolynomial m36538a(byte[] bArr, int i) {
        return new IntegerPolynomial(ArrayEncoder.m29333a(bArr, i));
    }

    /* renamed from: a */
    public static IntegerPolynomial m36539a(byte[] bArr, int i, int i2) {
        return new IntegerPolynomial(ArrayEncoder.m29334a(bArr, i, i2));
    }

    /* renamed from: d */
    public byte[] m36558d() {
        return ArrayEncoder.m29331a(this.f27879a);
    }

    /* renamed from: a */
    public byte[] m36550a(int i) {
        return ArrayEncoder.m29332a(this.f27879a, i);
    }

    /* renamed from: a */
    public IntegerPolynomial mo5934a(IntegerPolynomial integerPolynomial, int i) {
        integerPolynomial = mo5933a(integerPolynomial);
        integerPolynomial.m36568i(i);
        return integerPolynomial;
    }

    /* renamed from: a */
    public IntegerPolynomial mo5933a(IntegerPolynomial integerPolynomial) {
        int length = this.f27879a.length;
        if (integerPolynomial.f27879a.length == length) {
            integerPolynomial = m36544d(integerPolynomial);
            if (integerPolynomial.f27879a.length > length) {
                for (int i = length; i < integerPolynomial.f27879a.length; i++) {
                    int[] iArr = integerPolynomial.f27879a;
                    int i2 = i - length;
                    iArr[i2] = iArr[i2] + integerPolynomial.f27879a[i];
                }
                integerPolynomial.f27879a = Arrays.m29376b(integerPolynomial.f27879a, length);
            }
            return integerPolynomial;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    /* renamed from: a */
    public BigIntPolynomial mo5932a(BigIntPolynomial bigIntPolynomial) {
        return new BigIntPolynomial(this).m29310a(bigIntPolynomial);
    }

    /* renamed from: d */
    private IntegerPolynomial m36544d(IntegerPolynomial integerPolynomial) {
        int[] iArr = this.f27879a;
        int[] iArr2 = integerPolynomial.f27879a;
        int length = integerPolynomial.f27879a.length;
        int i = 0;
        int i2;
        IntegerPolynomial integerPolynomial2;
        int max;
        if (length <= 32) {
            i2 = (length * 2) - 1;
            integerPolynomial2 = new IntegerPolynomial(new int[i2]);
            for (int i3 = 0; i3 < i2; i3++) {
                for (max = Math.max(0, (i3 - length) + 1); max <= Math.min(i3, length - 1); max++) {
                    int[] iArr3 = integerPolynomial2.f27879a;
                    iArr3[i3] = iArr3[i3] + (iArr2[max] * iArr[i3 - max]);
                }
            }
            return integerPolynomial2;
        }
        i2 = length / 2;
        integerPolynomial2 = new IntegerPolynomial(Arrays.m29376b(iArr, i2));
        IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(Arrays.m29377b(iArr, i2, length));
        IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(Arrays.m29376b(iArr2, i2));
        IntegerPolynomial integerPolynomial5 = new IntegerPolynomial(Arrays.m29377b(iArr2, i2, length));
        IntegerPolynomial integerPolynomial6 = (IntegerPolynomial) integerPolynomial2.clone();
        integerPolynomial6.m36552b(integerPolynomial3);
        IntegerPolynomial integerPolynomial7 = (IntegerPolynomial) integerPolynomial4.clone();
        integerPolynomial7.m36552b(integerPolynomial5);
        integerPolynomial4 = integerPolynomial2.m36544d(integerPolynomial4);
        integerPolynomial2 = integerPolynomial3.m36544d(integerPolynomial5);
        integerPolynomial6 = integerPolynomial6.m36544d(integerPolynomial7);
        integerPolynomial6.m36555c(integerPolynomial4);
        integerPolynomial6.m36555c(integerPolynomial2);
        integerPolynomial3 = new IntegerPolynomial((length * 2) - 1);
        for (integerPolynomial = null; integerPolynomial < integerPolynomial4.f27879a.length; integerPolynomial++) {
            integerPolynomial3.f27879a[integerPolynomial] = integerPolynomial4.f27879a[integerPolynomial];
        }
        for (integerPolynomial = null; integerPolynomial < integerPolynomial6.f27879a.length; integerPolynomial++) {
            iArr = integerPolynomial3.f27879a;
            max = i2 + integerPolynomial;
            iArr[max] = iArr[max] + integerPolynomial6.f27879a[integerPolynomial];
        }
        while (i < integerPolynomial2.f27879a.length) {
            integerPolynomial = integerPolynomial3.f27879a;
            int i4 = (i2 * 2) + i;
            integerPolynomial[i4] = integerPolynomial[i4] + integerPolynomial2.f27879a[i];
            i++;
        }
        return integerPolynomial3;
    }

    /* renamed from: b */
    public IntegerPolynomial m36551b(int i) {
        int length = this.f27879a.length;
        int i2 = length + 1;
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i2);
        integerPolynomial.f27879a[0] = 1;
        IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(i2);
        IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(i2);
        integerPolynomial3.f27879a = Arrays.m29376b(this.f27879a, i2);
        integerPolynomial3.m36564g(2);
        IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(i2);
        integerPolynomial4.f27879a[0] = 1;
        integerPolynomial4.f27879a[length] = 1;
        IntegerPolynomial integerPolynomial5 = integerPolynomial;
        int i3 = 0;
        while (true) {
            int i4;
            if (integerPolynomial3.f27879a[0] == 0) {
                for (i4 = 1; i4 <= length; i4++) {
                    integerPolynomial3.f27879a[i4 - 1] = integerPolynomial3.f27879a[i4];
                    integerPolynomial2.f27879a[i2 - i4] = integerPolynomial2.f27879a[length - i4];
                }
                integerPolynomial3.f27879a[length] = 0;
                integerPolynomial2.f27879a[0] = 0;
                i3++;
                if (integerPolynomial3.mo6591a()) {
                    return null;
                }
            } else if (integerPolynomial3.m36570j()) {
                break;
            } else {
                i4 = i;
                if (integerPolynomial3.m36563g() < integerPolynomial4.m36563g()) {
                    IntegerPolynomial integerPolynomial6 = integerPolynomial5;
                    integerPolynomial5 = integerPolynomial2;
                    integerPolynomial2 = integerPolynomial6;
                    IntegerPolynomial integerPolynomial7 = integerPolynomial4;
                    integerPolynomial4 = integerPolynomial3;
                    integerPolynomial3 = integerPolynomial7;
                }
                integerPolynomial3.m36553b(integerPolynomial4, 2);
                integerPolynomial5.m36553b(integerPolynomial2, 2);
            }
        }
        if (integerPolynomial5.f27879a[length] != 0) {
            return null;
        }
        IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(length);
        i3 %= length;
        for (int i5 = length - 1; i5 >= 0; i5--) {
            int i6 = i5 - i3;
            if (i6 < 0) {
                i6 += length;
            }
            integerPolynomial8.f27879a[i6] = integerPolynomial5.f27879a[i5];
        }
        return m36545d(integerPolynomial8, i);
    }

    /* renamed from: d */
    private IntegerPolynomial m36545d(IntegerPolynomial integerPolynomial, int i) {
        int i2 = 2;
        if (Util.m29339a() && i == 2048) {
            LongPolynomial2 longPolynomial2 = new LongPolynomial2(this);
            LongPolynomial2 longPolynomial22 = new LongPolynomial2(integerPolynomial);
            while (i2 < i) {
                i2 *= 2;
                LongPolynomial2 longPolynomial23 = (LongPolynomial2) longPolynomial22.clone();
                int i3 = i2 - 1;
                longPolynomial23.m29323a(i3);
                longPolynomial23.m29324a(longPolynomial2.m29322a(longPolynomial22).m29322a(longPolynomial22), i3);
                longPolynomial22 = longPolynomial23;
            }
            return longPolynomial22.m29321a();
        }
        while (i2 < i) {
            i2 *= 2;
            IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(Arrays.m29376b(integerPolynomial.f27879a, integerPolynomial.f27879a.length));
            integerPolynomial2.m36546o(i2);
            integerPolynomial2.m36556c(mo5934a(integerPolynomial, i2).mo5934a(integerPolynomial, i2), i2);
            integerPolynomial = integerPolynomial2;
        }
        return integerPolynomial;
    }

    /* renamed from: e */
    public IntegerPolynomial m36559e() {
        int length = this.f27879a.length;
        int i = length + 1;
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i);
        integerPolynomial.f27879a[0] = 1;
        IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(i);
        IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(i);
        integerPolynomial3.f27879a = Arrays.m29376b(this.f27879a, i);
        integerPolynomial3.m36564g(3);
        IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(i);
        integerPolynomial4.f27879a[0] = -1;
        integerPolynomial4.f27879a[length] = 1;
        IntegerPolynomial integerPolynomial5 = integerPolynomial;
        int i2 = 0;
        while (true) {
            if (integerPolynomial3.f27879a[0] == 0) {
                for (int i3 = 1; i3 <= length; i3++) {
                    integerPolynomial3.f27879a[i3 - 1] = integerPolynomial3.f27879a[i3];
                    integerPolynomial2.f27879a[i - i3] = integerPolynomial2.f27879a[length - i3];
                }
                integerPolynomial3.f27879a[length] = 0;
                integerPolynomial2.f27879a[0] = 0;
                i2++;
                if (integerPolynomial3.mo6591a()) {
                    return null;
                }
            } else if (integerPolynomial3.mo6592b()) {
                break;
            } else {
                if (integerPolynomial3.m36563g() < integerPolynomial4.m36563g()) {
                    IntegerPolynomial integerPolynomial6 = integerPolynomial5;
                    integerPolynomial5 = integerPolynomial2;
                    integerPolynomial2 = integerPolynomial6;
                    IntegerPolynomial integerPolynomial7 = integerPolynomial4;
                    integerPolynomial4 = integerPolynomial3;
                    integerPolynomial3 = integerPolynomial7;
                }
                if (integerPolynomial3.f27879a[0] == integerPolynomial4.f27879a[0]) {
                    integerPolynomial3.m36556c(integerPolynomial4, 3);
                    integerPolynomial5.m36556c(integerPolynomial2, 3);
                } else {
                    integerPolynomial3.m36553b(integerPolynomial4, 3);
                    integerPolynomial5.m36553b(integerPolynomial2, 3);
                }
            }
        }
        if (integerPolynomial5.f27879a[length] != 0) {
            return null;
        }
        IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(length);
        i2 %= length;
        for (int i4 = length - 1; i4 >= 0; i4--) {
            int i5 = i4 - i2;
            if (i5 < 0) {
                i5 += length;
            }
            integerPolynomial8.f27879a[i5] = integerPolynomial3.f27879a[0] * integerPolynomial5.f27879a[i4];
        }
        integerPolynomial8.m36569j(3);
        return integerPolynomial8;
    }

    /* renamed from: f */
    public Resultant m36561f() {
        BigInteger multiply;
        int length = this.f27879a.length;
        LinkedList linkedList = new LinkedList();
        BigInteger bigInteger = Constants.f23411b;
        BigInteger bigInteger2 = Constants.f23411b;
        Iterator it = f27878c.iterator();
        BigInteger bigInteger3 = null;
        int i = 1;
        while (true) {
            bigInteger3 = it.hasNext() ? (BigInteger) it.next() : bigInteger3.nextProbablePrime();
            ModularResultant c = m36554c(bigInteger3.intValue());
            linkedList.add(c);
            multiply = bigInteger.multiply(bigInteger3);
            BigIntEuclidean a = BigIntEuclidean.m29295a(bigInteger3, bigInteger);
            bigInteger = bigInteger2.multiply(a.f23399a.multiply(bigInteger3)).add(c.c.multiply(a.f23400b.multiply(bigInteger))).mod(multiply);
            BigInteger divide = multiply.divide(BigInteger.valueOf(2));
            BigInteger negate = divide.negate();
            if (bigInteger.compareTo(divide) > 0) {
                bigInteger = bigInteger.subtract(multiply);
            } else if (bigInteger.compareTo(negate) < 0) {
                bigInteger = bigInteger.add(multiply);
            }
            if (bigInteger.equals(bigInteger2)) {
                i++;
                if (i >= 3) {
                    break;
                }
            } else {
                i = 1;
            }
            bigInteger2 = bigInteger;
            bigInteger = multiply;
        }
        while (linkedList.size() > 1) {
            linkedList.addLast(ModularResultant.m36578a((ModularResultant) linkedList.removeFirst(), (ModularResultant) linkedList.removeFirst()));
        }
        BigIntPolynomial bigIntPolynomial = ((ModularResultant) linkedList.getFirst()).b;
        bigInteger2 = multiply.divide(BigInteger.valueOf(2));
        BigInteger negate2 = bigInteger2.negate();
        if (bigInteger.compareTo(bigInteger2) > 0) {
            bigInteger = bigInteger.subtract(multiply);
        }
        if (bigInteger.compareTo(negate2) < 0) {
            bigInteger = bigInteger.add(multiply);
        }
        for (int i2 = 0; i2 < length; i2++) {
            bigInteger3 = bigIntPolynomial.f23409a[i2];
            if (bigInteger3.compareTo(bigInteger2) > 0) {
                bigIntPolynomial.f23409a[i2] = bigInteger3.subtract(multiply);
            }
            if (bigInteger3.compareTo(negate2) < 0) {
                bigIntPolynomial.f23409a[i2] = bigInteger3.add(multiply);
            }
        }
        return new Resultant(bigIntPolynomial, bigInteger);
    }

    /* renamed from: c */
    public ModularResultant m36554c(int i) {
        int[] b = Arrays.m29376b(this.f27879a, this.f27879a.length + 1);
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(b);
        int length = b.length;
        IntegerPolynomial integerPolynomial2 = new IntegerPolynomial(length);
        integerPolynomial2.f27879a[0] = -1;
        int i2 = length - 1;
        integerPolynomial2.f27879a[i2] = 1;
        IntegerPolynomial integerPolynomial3 = new IntegerPolynomial(integerPolynomial.f27879a);
        integerPolynomial = new IntegerPolynomial(length);
        IntegerPolynomial integerPolynomial4 = new IntegerPolynomial(length);
        integerPolynomial4.f27879a[0] = 1;
        int i3 = i2;
        int i4 = 1;
        i2 = integerPolynomial3.m36563g();
        IntegerPolynomial integerPolynomial5 = integerPolynomial2;
        integerPolynomial2 = integerPolynomial3;
        integerPolynomial3 = integerPolynomial;
        int i5 = i3;
        while (i2 > 0) {
            int a = (Util.m29336a(integerPolynomial2.f27879a[i2], i) * integerPolynomial5.f27879a[i5]) % i;
            i5 -= i2;
            integerPolynomial5.m36540a(integerPolynomial2, a, i5, i);
            integerPolynomial3.m36540a(integerPolynomial4, a, i5, i);
            i5 = integerPolynomial5.m36563g();
            if (i5 < i2) {
                i4 = (i4 * Util.m29337a(integerPolynomial2.f27879a[i2], i3 - i5, i)) % i;
                if (i3 % 2 == 1 && i2 % 2 == 1) {
                    i4 = (-i4) % i;
                }
                i3 = i2;
                i2 = i5;
                i5 = i3;
                IntegerPolynomial integerPolynomial6 = integerPolynomial2;
                integerPolynomial2 = integerPolynomial5;
                integerPolynomial5 = integerPolynomial6;
                IntegerPolynomial integerPolynomial7 = integerPolynomial4;
                integerPolynomial4 = integerPolynomial3;
                integerPolynomial3 = integerPolynomial7;
            }
        }
        i4 = (i4 * Util.m29337a(integerPolynomial2.f27879a[0], i5, i)) % i;
        integerPolynomial4.m36560e(Util.m29336a(integerPolynomial2.f27879a[0], i));
        integerPolynomial4.m36568i(i);
        integerPolynomial4.m36560e(i4);
        integerPolynomial4.m36568i(i);
        integerPolynomial4.f27879a = Arrays.m29376b(integerPolynomial4.f27879a, integerPolynomial4.f27879a.length - 1);
        return new ModularResultant(new BigIntPolynomial(integerPolynomial4), BigInteger.valueOf((long) i4), BigInteger.valueOf((long) i));
    }

    /* renamed from: a */
    private void m36540a(IntegerPolynomial integerPolynomial, int i, int i2, int i3) {
        int length = this.f27879a.length;
        for (int i4 = i2; i4 < length; i4++) {
            this.f27879a[i4] = (this.f27879a[i4] - (integerPolynomial.f27879a[i4 - i2] * i)) % i3;
        }
    }

    /* renamed from: g */
    int m36563g() {
        int length = this.f27879a.length - 1;
        while (length > 0 && this.f27879a[length] == 0) {
            length--;
        }
        return length;
    }

    /* renamed from: b */
    public void m36553b(IntegerPolynomial integerPolynomial, int i) {
        m36552b(integerPolynomial);
        m36568i(i);
    }

    /* renamed from: b */
    public void m36552b(IntegerPolynomial integerPolynomial) {
        if (integerPolynomial.f27879a.length > this.f27879a.length) {
            this.f27879a = Arrays.m29376b(this.f27879a, integerPolynomial.f27879a.length);
        }
        for (int i = 0; i < integerPolynomial.f27879a.length; i++) {
            int[] iArr = this.f27879a;
            iArr[i] = iArr[i] + integerPolynomial.f27879a[i];
        }
    }

    /* renamed from: c */
    public void m36556c(IntegerPolynomial integerPolynomial, int i) {
        m36555c(integerPolynomial);
        m36568i(i);
    }

    /* renamed from: c */
    public void m36555c(IntegerPolynomial integerPolynomial) {
        if (integerPolynomial.f27879a.length > this.f27879a.length) {
            this.f27879a = Arrays.m29376b(this.f27879a, integerPolynomial.f27879a.length);
        }
        for (int i = 0; i < integerPolynomial.f27879a.length; i++) {
            int[] iArr = this.f27879a;
            iArr[i] = iArr[i] - integerPolynomial.f27879a[i];
        }
    }

    /* renamed from: d */
    void m36557d(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            int[] iArr = this.f27879a;
            iArr[i2] = iArr[i2] - i;
        }
    }

    /* renamed from: e */
    public void m36560e(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            int[] iArr = this.f27879a;
            iArr[i2] = iArr[i2] * i;
        }
    }

    /* renamed from: o */
    private void m36546o(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            int[] iArr = this.f27879a;
            iArr[i2] = iArr[i2] * 2;
            iArr = this.f27879a;
            iArr[i2] = iArr[i2] % i;
        }
    }

    /* renamed from: f */
    public void m36562f(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            int[] iArr = this.f27879a;
            iArr[i2] = iArr[i2] * 3;
            iArr = this.f27879a;
            iArr[i2] = iArr[i2] % i;
        }
    }

    /* renamed from: h */
    public void m36565h() {
        for (int i = 0; i < this.f27879a.length; i++) {
            int[] iArr = this.f27879a;
            iArr[i] = iArr[i] % 3;
            if (this.f27879a[i] > 1) {
                iArr = this.f27879a;
                iArr[i] = iArr[i] - 3;
            }
            if (this.f27879a[i] < -1) {
                iArr = this.f27879a;
                iArr[i] = iArr[i] + 3;
            }
        }
    }

    /* renamed from: g */
    public void m36564g(int i) {
        m36568i(i);
        m36569j(i);
    }

    /* renamed from: h */
    void m36566h(int i) {
        m36568i(i);
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            while (true) {
                int i3 = i / 2;
                if (this.f27879a[i2] >= i3) {
                    break;
                }
                int[] iArr = this.f27879a;
                iArr[i2] = iArr[i2] + i;
            }
            while (this.f27879a[i2] >= i3) {
                iArr = this.f27879a;
                iArr[i2] = iArr[i2] - i;
            }
        }
    }

    /* renamed from: i */
    public void m36568i(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            int[] iArr = this.f27879a;
            iArr[i2] = iArr[i2] % i;
        }
    }

    /* renamed from: j */
    public void m36569j(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            while (this.f27879a[i2] < 0) {
                int[] iArr = this.f27879a;
                iArr[i2] = iArr[i2] + i;
            }
        }
    }

    /* renamed from: k */
    public long m36571k(int i) {
        int length = this.f27879a.length;
        IntegerPolynomial integerPolynomial = (IntegerPolynomial) clone();
        integerPolynomial.m36574l(i);
        long j = 0;
        long j2 = 0;
        for (i = 0; i != integerPolynomial.f27879a.length; i++) {
            int i2 = integerPolynomial.f27879a[i];
            j += (long) i2;
            j2 += (long) (i2 * i2);
        }
        return j2 - ((j * j) / ((long) length));
    }

    /* renamed from: l */
    void m36574l(int i) {
        m36566h(i);
        int[] b = Arrays.m29375b(this.f27879a);
        m36541a(b);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < b.length - 1) {
            int i5 = i2 + 1;
            int i6 = b[i5] - b[i2];
            if (i6 > i3) {
                i4 = b[i2];
                i3 = i6;
            }
            i2 = i5;
        }
        int i7 = b[0];
        int i8 = b[b.length - 1];
        if ((i - i8) + i7 > i3) {
            i8 = (i8 + i7) / 2;
        } else {
            i8 = (i4 + (i3 / 2)) + (i / 2);
        }
        m36557d(i8);
    }

    /* renamed from: a */
    private void m36541a(int[] iArr) {
        Object obj;
        for (Object obj2 = 1; obj2 != null; obj2 = obj) {
            int i = 0;
            obj = null;
            while (i != iArr.length - 1) {
                int i2 = i + 1;
                if (iArr[i] > iArr[i2]) {
                    int i3 = iArr[i];
                    iArr[i] = iArr[i2];
                    iArr[i2] = i3;
                    obj = 1;
                }
                i = i2;
            }
        }
    }

    /* renamed from: m */
    public void m36576m(int i) {
        for (int i2 = 0; i2 < this.f27879a.length; i2++) {
            while (this.f27879a[i2] < (-i) / 2) {
                int[] iArr = this.f27879a;
                iArr[i2] = iArr[i2] + i;
            }
            while (this.f27879a[i2] > i / 2) {
                iArr = this.f27879a;
                iArr[i2] = iArr[i2] - i;
            }
        }
    }

    /* renamed from: i */
    public int m36567i() {
        int i = 0;
        for (int i2 : this.f27879a) {
            i += i2;
        }
        return i;
    }

    /* renamed from: a */
    private boolean mo6591a() {
        for (int i : this.f27879a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    public boolean m36570j() {
        boolean z = true;
        for (int i = 1; i < this.f27879a.length; i++) {
            if (this.f27879a[i] != 0) {
                return false;
            }
        }
        if (this.f27879a[0] != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean mo6592b() {
        boolean z = true;
        for (int i = 1; i < this.f27879a.length; i++) {
            if (this.f27879a[i] != 0) {
                return false;
            }
        }
        if (Math.abs(this.f27879a[0]) != 1) {
            z = false;
        }
        return z;
    }

    /* renamed from: n */
    public int m36577n(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 != this.f27879a.length; i3++) {
            if (this.f27879a[i3] == i) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: k */
    public void m36572k() {
        int i = this.f27879a[this.f27879a.length - 1];
        for (int length = this.f27879a.length - 1; length > 0; length--) {
            this.f27879a[length] = this.f27879a[length - 1];
        }
        this.f27879a[0] = i;
    }

    /* renamed from: l */
    public void m36573l() {
        for (int i = 0; i < this.f27879a.length; i++) {
            this.f27879a[i] = 0;
        }
    }

    /* renamed from: m */
    public IntegerPolynomial mo5935m() {
        return (IntegerPolynomial) clone();
    }

    public Object clone() {
        return new IntegerPolynomial((int[]) this.f27879a.clone());
    }

    public boolean equals(Object obj) {
        return obj instanceof IntegerPolynomial ? Arrays.m29356a(this.f27879a, ((IntegerPolynomial) obj).f27879a) : null;
    }
}
