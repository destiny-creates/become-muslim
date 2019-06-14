package org.spongycastle.util;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import java.util.NoSuchElementException;

public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        /* renamed from: a */
        private final T[] f23430a;
        /* renamed from: b */
        private int f23431b = 0;

        public Iterator(T[] tArr) {
            this.f23430a = tArr;
        }

        public boolean hasNext() {
            return this.f23431b < this.f23430a.length;
        }

        public T next() {
            if (this.f23431b != this.f23430a.length) {
                Object[] objArr = this.f23430a;
                int i = this.f23431b;
                this.f23431b = i + 1;
                return objArr[i];
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Out of elements: ");
            stringBuilder.append(this.f23431b);
            throw new NoSuchElementException(stringBuilder.toString());
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    private Arrays() {
    }

    /* renamed from: a */
    public static boolean m29354a(char[] cArr, char[] cArr2) {
        if (cArr == cArr2) {
            return true;
        }
        if (cArr != null) {
            if (cArr2 != null) {
                if (cArr.length != cArr2.length) {
                    return false;
                }
                for (int i = 0; i != cArr.length; i++) {
                    if (cArr[i] != cArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29353a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr != null) {
            if (bArr2 != null) {
                if (bArr.length != bArr2.length) {
                    return false;
                }
                for (int i = 0; i != bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m29372b(byte[] bArr, byte[] bArr2) {
        boolean z = true;
        if (bArr == bArr2) {
            return true;
        }
        if (bArr != null) {
            if (bArr2 != null) {
                if (bArr.length != bArr2.length) {
                    return false;
                }
                int i = 0;
                for (int i2 = 0; i2 != bArr.length; i2++) {
                    i |= bArr[i2] ^ bArr2[i2];
                }
                if (i != 0) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29356a(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr != null) {
            if (iArr2 != null) {
                if (iArr.length != iArr2.length) {
                    return false;
                }
                for (int i = 0; i != iArr.length; i++) {
                    if (iArr[i] != iArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29357a(long[] jArr, long[] jArr2) {
        if (jArr == jArr2) {
            return true;
        }
        if (jArr != null) {
            if (jArr2 != null) {
                if (jArr.length != jArr2.length) {
                    return false;
                }
                for (int i = 0; i != jArr.length; i++) {
                    if (jArr[i] != jArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29358a(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr != null) {
            if (objArr2 != null) {
                if (objArr.length != objArr2.length) {
                    return false;
                }
                for (int i = 0; i != objArr.length; i++) {
                    Object obj = objArr[i];
                    Object obj2 = objArr2[i];
                    if (obj == null) {
                        if (obj2 != null) {
                            return false;
                        }
                    } else if (!obj.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29359a(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m29355a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m29351a(byte[] bArr, byte b) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = b;
        }
    }

    /* renamed from: a */
    public static void m29352a(long[] jArr, long j) {
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = j;
        }
    }

    /* renamed from: b */
    public static void m29371b(short[] sArr, short s) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = s;
        }
    }

    /* renamed from: a */
    public static int m29342a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ bArr[length];
        }
    }

    /* renamed from: a */
    public static int m29343a(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    /* renamed from: a */
    public static int m29344a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ iArr[length];
        }
    }

    /* renamed from: a */
    public static int m29345a(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ iArr[i + i2];
        }
    }

    /* renamed from: a */
    public static int m29346a(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            long j = jArr[i + i2];
            i3 = (((i3 * 257) ^ ((int) j)) * 257) ^ ((int) (j >>> 32));
        }
    }

    /* renamed from: a */
    public static int m29350a(short[][][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + m29349a(sArr[i2]);
        }
        return i;
    }

    /* renamed from: a */
    public static int m29349a(short[][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + m29348a(sArr[i2]);
        }
        return i;
    }

    /* renamed from: a */
    public static int m29348a(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        int length = sArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ (sArr[length] & JfifUtil.MARKER_FIRST_BYTE);
        }
    }

    /* renamed from: a */
    public static int m29347a(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ objArr[length].hashCode();
        }
    }

    /* renamed from: b */
    public static byte[] m29373b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Object obj = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        return obj;
    }

    /* renamed from: c */
    public static byte[] m29382c(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (bArr2 != null) {
            if (bArr2.length == bArr.length) {
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                return bArr2;
            }
        }
        return m29373b(bArr);
    }

    /* renamed from: a */
    public static byte[][] m29369a(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = m29373b(bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: a */
    public static byte[][][] m29370a(byte[][][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][][] bArr2 = new byte[bArr.length][][];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = m29369a(bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: b */
    public static int[] m29375b(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        Object obj = new int[iArr.length];
        System.arraycopy(iArr, 0, obj, 0, iArr.length);
        return obj;
    }

    /* renamed from: a */
    public static long[] m29364a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        Object obj = new long[jArr.length];
        System.arraycopy(jArr, 0, obj, 0, jArr.length);
        return obj;
    }

    /* renamed from: b */
    public static long[] m29379b(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return null;
        }
        if (jArr2 != null) {
            if (jArr2.length == jArr.length) {
                System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
                return jArr2;
            }
        }
        return m29364a(jArr);
    }

    /* renamed from: b */
    public static short[] m29380b(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        Object obj = new short[sArr.length];
        System.arraycopy(sArr, 0, obj, 0, sArr.length);
        return obj;
    }

    /* renamed from: a */
    public static BigInteger[] m29366a(BigInteger[] bigIntegerArr) {
        if (bigIntegerArr == null) {
            return null;
        }
        Object obj = new BigInteger[bigIntegerArr.length];
        System.arraycopy(bigIntegerArr, 0, obj, 0, bigIntegerArr.length);
        return obj;
    }

    /* renamed from: a */
    public static byte[] m29360a(byte[] bArr, int i) {
        Object obj = new byte[i];
        if (i < bArr.length) {
            System.arraycopy(bArr, 0, obj, 0, i);
        } else {
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
        }
        return obj;
    }

    /* renamed from: b */
    public static int[] m29376b(int[] iArr, int i) {
        Object obj = new int[i];
        if (i < iArr.length) {
            System.arraycopy(iArr, 0, obj, 0, i);
        } else {
            System.arraycopy(iArr, 0, obj, 0, iArr.length);
        }
        return obj;
    }

    /* renamed from: a */
    public static long[] m29365a(long[] jArr, int i) {
        Object obj = new long[i];
        if (i < jArr.length) {
            System.arraycopy(jArr, 0, obj, 0, i);
        } else {
            System.arraycopy(jArr, 0, obj, 0, jArr.length);
        }
        return obj;
    }

    /* renamed from: a */
    public static BigInteger[] m29367a(BigInteger[] bigIntegerArr, int i) {
        Object obj = new BigInteger[i];
        if (i < bigIntegerArr.length) {
            System.arraycopy(bigIntegerArr, 0, obj, 0, i);
        } else {
            System.arraycopy(bigIntegerArr, 0, obj, 0, bigIntegerArr.length);
        }
        return obj;
    }

    /* renamed from: a */
    public static byte[] m29361a(byte[] bArr, int i, int i2) {
        i2 = m29341a(i, i2);
        Object obj = new byte[i2];
        if (bArr.length - i < i2) {
            System.arraycopy(bArr, i, obj, 0, bArr.length - i);
        } else {
            System.arraycopy(bArr, i, obj, 0, i2);
        }
        return obj;
    }

    /* renamed from: b */
    public static int[] m29377b(int[] iArr, int i, int i2) {
        i2 = m29341a(i, i2);
        Object obj = new int[i2];
        if (iArr.length - i < i2) {
            System.arraycopy(iArr, i, obj, 0, iArr.length - i);
        } else {
            System.arraycopy(iArr, i, obj, 0, i2);
        }
        return obj;
    }

    /* renamed from: b */
    public static long[] m29378b(long[] jArr, int i, int i2) {
        i2 = m29341a(i, i2);
        Object obj = new long[i2];
        if (jArr.length - i < i2) {
            System.arraycopy(jArr, i, obj, 0, jArr.length - i);
        } else {
            System.arraycopy(jArr, i, obj, 0, i2);
        }
        return obj;
    }

    /* renamed from: a */
    public static BigInteger[] m29368a(BigInteger[] bigIntegerArr, int i, int i2) {
        i2 = m29341a(i, i2);
        Object obj = new BigInteger[i2];
        if (bigIntegerArr.length - i < i2) {
            System.arraycopy(bigIntegerArr, i, obj, 0, bigIntegerArr.length - i);
        } else {
            System.arraycopy(bigIntegerArr, i, obj, 0, i2);
        }
        return obj;
    }

    /* renamed from: a */
    private static int m29341a(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            return i3;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* renamed from: c */
    public static short[] m29384c(short[] sArr, short s) {
        if (sArr == null) {
            return new short[]{s};
        }
        int length = sArr.length;
        Object obj = new short[(length + 1)];
        System.arraycopy(sArr, 0, obj, 0, length);
        obj[length] = s;
        return obj;
    }

    /* renamed from: d */
    public static byte[] m29385d(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            Object obj = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
            return obj;
        } else if (bArr2 != null) {
            return m29373b(bArr2);
        } else {
            return m29373b(bArr);
        }
    }

    /* renamed from: a */
    public static byte[] m29362a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr2 != null && bArr3 != null) {
            Object obj = new byte[((bArr.length + bArr2.length) + bArr3.length)];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
            System.arraycopy(bArr3, 0, obj, bArr.length + bArr2.length, bArr3.length);
            return obj;
        } else if (bArr2 == null) {
            return m29385d(bArr, bArr3);
        } else {
            return m29385d(bArr, bArr2);
        }
    }

    /* renamed from: a */
    public static byte[] m29363a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr != null && bArr2 != null && bArr3 != null && bArr4 != null) {
            Object obj = new byte[(((bArr.length + bArr2.length) + bArr3.length) + bArr4.length)];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
            System.arraycopy(bArr3, 0, obj, bArr.length + bArr2.length, bArr3.length);
            System.arraycopy(bArr4, 0, obj, (bArr.length + bArr2.length) + bArr3.length, bArr4.length);
            return obj;
        } else if (bArr4 == null) {
            return m29362a(bArr, bArr2, bArr3);
        } else {
            if (bArr3 == null) {
                return m29362a(bArr, bArr2, bArr4);
            }
            if (bArr2 == null) {
                return m29362a(bArr, bArr3, bArr4);
            }
            return m29362a(bArr2, bArr3, bArr4);
        }
    }

    /* renamed from: b */
    public static byte[] m29374b(byte[] bArr, byte b) {
        if (bArr == null) {
            return new byte[]{b};
        }
        int length = bArr.length;
        Object obj = new byte[(length + 1)];
        System.arraycopy(bArr, 0, obj, 1, length);
        obj[0] = b;
        return obj;
    }

    /* renamed from: c */
    public static byte[] m29381c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            int i2 = i + 1;
            bArr2[length] = bArr[i];
            i = i2;
        }
    }

    /* renamed from: c */
    public static int[] m29383c(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int i = 0;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        while (true) {
            length--;
            if (length < 0) {
                return iArr2;
            }
            int i2 = i + 1;
            iArr2[length] = iArr[i];
            i = i2;
        }
    }
}
