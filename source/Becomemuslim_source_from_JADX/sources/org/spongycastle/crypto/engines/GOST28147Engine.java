package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import java.util.Hashtable;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class GOST28147Engine implements BlockCipher {
    /* renamed from: d */
    private static byte[] f26628d = new byte[]{(byte) 4, (byte) 10, (byte) 9, (byte) 2, (byte) 13, (byte) 8, (byte) 0, (byte) 14, (byte) 6, (byte) 11, (byte) 1, (byte) 12, (byte) 7, (byte) 15, (byte) 5, (byte) 3, (byte) 14, (byte) 11, (byte) 4, (byte) 12, (byte) 6, (byte) 13, (byte) 15, (byte) 10, (byte) 2, (byte) 3, (byte) 8, (byte) 1, (byte) 0, (byte) 7, (byte) 5, (byte) 9, (byte) 5, (byte) 8, (byte) 1, (byte) 13, (byte) 10, (byte) 3, (byte) 4, (byte) 2, (byte) 14, (byte) 15, (byte) 12, (byte) 7, (byte) 6, (byte) 0, (byte) 9, (byte) 11, (byte) 7, (byte) 13, (byte) 10, (byte) 1, (byte) 0, (byte) 8, (byte) 9, (byte) 15, (byte) 14, (byte) 4, (byte) 6, (byte) 12, (byte) 11, (byte) 2, (byte) 5, (byte) 3, (byte) 6, (byte) 12, (byte) 7, (byte) 1, (byte) 5, (byte) 15, (byte) 13, (byte) 8, (byte) 4, (byte) 10, (byte) 9, (byte) 14, (byte) 0, (byte) 3, (byte) 11, (byte) 2, (byte) 4, (byte) 11, (byte) 10, (byte) 0, (byte) 7, (byte) 2, (byte) 1, (byte) 13, (byte) 3, (byte) 6, (byte) 8, (byte) 5, (byte) 9, (byte) 12, (byte) 15, (byte) 14, (byte) 13, (byte) 11, (byte) 4, (byte) 1, (byte) 3, (byte) 15, (byte) 5, (byte) 9, (byte) 0, (byte) 10, (byte) 14, (byte) 7, (byte) 6, (byte) 8, (byte) 2, (byte) 12, (byte) 1, (byte) 15, (byte) 13, (byte) 0, (byte) 5, (byte) 7, (byte) 10, (byte) 4, (byte) 9, (byte) 2, (byte) 3, (byte) 14, (byte) 6, (byte) 11, (byte) 8, (byte) 12};
    /* renamed from: e */
    private static byte[] f26629e = new byte[]{(byte) 4, (byte) 2, (byte) 15, (byte) 5, (byte) 9, (byte) 1, (byte) 0, (byte) 8, (byte) 14, (byte) 3, (byte) 11, (byte) 12, (byte) 13, (byte) 7, (byte) 10, (byte) 6, (byte) 12, (byte) 9, (byte) 15, (byte) 14, (byte) 8, (byte) 1, (byte) 3, (byte) 10, (byte) 2, (byte) 7, (byte) 4, (byte) 13, (byte) 6, (byte) 0, (byte) 11, (byte) 5, (byte) 13, (byte) 8, (byte) 14, (byte) 12, (byte) 7, (byte) 3, (byte) 9, (byte) 10, (byte) 1, (byte) 5, (byte) 2, (byte) 4, (byte) 6, (byte) 15, (byte) 0, (byte) 11, (byte) 14, (byte) 9, (byte) 11, (byte) 2, (byte) 5, (byte) 15, (byte) 7, (byte) 1, (byte) 0, (byte) 13, (byte) 12, (byte) 6, (byte) 10, (byte) 4, (byte) 3, (byte) 8, (byte) 3, (byte) 14, (byte) 5, (byte) 9, (byte) 6, (byte) 8, (byte) 0, (byte) 13, (byte) 10, (byte) 11, (byte) 7, (byte) 12, (byte) 2, (byte) 1, (byte) 15, (byte) 4, (byte) 8, (byte) 15, (byte) 6, (byte) 11, (byte) 1, (byte) 9, (byte) 12, (byte) 5, (byte) 13, (byte) 3, (byte) 7, (byte) 10, (byte) 0, (byte) 14, (byte) 2, (byte) 4, (byte) 9, (byte) 11, (byte) 12, (byte) 0, (byte) 3, (byte) 6, (byte) 7, (byte) 5, (byte) 4, (byte) 8, (byte) 14, (byte) 15, (byte) 1, (byte) 10, (byte) 2, (byte) 13, (byte) 12, (byte) 6, (byte) 5, (byte) 2, (byte) 11, (byte) 0, (byte) 9, (byte) 13, (byte) 3, (byte) 14, (byte) 7, (byte) 10, (byte) 15, (byte) 4, (byte) 1, (byte) 8};
    /* renamed from: f */
    private static byte[] f26630f = new byte[]{(byte) 9, (byte) 6, (byte) 3, (byte) 2, (byte) 8, (byte) 11, (byte) 1, (byte) 7, (byte) 10, (byte) 4, (byte) 14, (byte) 15, (byte) 12, (byte) 0, (byte) 13, (byte) 5, (byte) 3, (byte) 7, (byte) 14, (byte) 9, (byte) 8, (byte) 10, (byte) 15, (byte) 0, (byte) 5, (byte) 2, (byte) 6, (byte) 12, (byte) 11, (byte) 4, (byte) 13, (byte) 1, (byte) 14, (byte) 4, (byte) 6, (byte) 2, (byte) 11, (byte) 3, (byte) 13, (byte) 8, (byte) 12, (byte) 15, (byte) 5, (byte) 10, (byte) 0, (byte) 7, (byte) 1, (byte) 9, (byte) 14, (byte) 7, (byte) 10, (byte) 12, (byte) 13, (byte) 1, (byte) 3, (byte) 9, (byte) 0, (byte) 2, (byte) 11, (byte) 4, (byte) 15, (byte) 8, (byte) 5, (byte) 6, (byte) 11, (byte) 5, (byte) 1, (byte) 9, (byte) 8, (byte) 13, (byte) 15, (byte) 0, (byte) 14, (byte) 4, (byte) 2, (byte) 3, (byte) 12, (byte) 7, (byte) 10, (byte) 6, (byte) 3, (byte) 10, (byte) 13, (byte) 12, (byte) 1, (byte) 2, (byte) 0, (byte) 11, (byte) 7, (byte) 5, (byte) 9, (byte) 4, (byte) 8, (byte) 15, (byte) 14, (byte) 6, (byte) 1, (byte) 13, (byte) 2, (byte) 9, (byte) 7, (byte) 10, (byte) 6, (byte) 0, (byte) 8, (byte) 12, (byte) 4, (byte) 5, (byte) 15, (byte) 3, (byte) 11, (byte) 14, (byte) 11, (byte) 10, (byte) 15, (byte) 5, (byte) 0, (byte) 12, (byte) 14, (byte) 8, (byte) 6, (byte) 2, (byte) 3, (byte) 9, (byte) 1, (byte) 7, (byte) 13, (byte) 4};
    /* renamed from: g */
    private static byte[] f26631g = new byte[]{(byte) 8, (byte) 4, (byte) 11, (byte) 1, (byte) 3, (byte) 5, (byte) 0, (byte) 9, (byte) 2, (byte) 14, (byte) 10, (byte) 12, (byte) 13, (byte) 6, (byte) 7, (byte) 15, (byte) 0, (byte) 1, (byte) 2, (byte) 10, (byte) 4, (byte) 13, (byte) 5, (byte) 12, (byte) 9, (byte) 7, (byte) 3, (byte) 15, (byte) 11, (byte) 8, (byte) 6, (byte) 14, (byte) 14, (byte) 12, (byte) 0, (byte) 10, (byte) 9, (byte) 2, (byte) 13, (byte) 11, (byte) 7, (byte) 5, (byte) 8, (byte) 15, (byte) 3, (byte) 6, (byte) 1, (byte) 4, (byte) 7, (byte) 5, (byte) 0, (byte) 13, (byte) 11, (byte) 6, (byte) 1, (byte) 2, (byte) 3, (byte) 10, (byte) 12, (byte) 15, (byte) 4, (byte) 14, (byte) 9, (byte) 8, (byte) 2, (byte) 7, (byte) 12, (byte) 15, (byte) 9, (byte) 5, (byte) 10, (byte) 11, (byte) 1, (byte) 4, (byte) 0, (byte) 13, (byte) 6, (byte) 8, (byte) 14, (byte) 3, (byte) 8, (byte) 3, (byte) 2, (byte) 6, (byte) 4, (byte) 13, (byte) 14, (byte) 11, (byte) 12, (byte) 1, (byte) 7, (byte) 15, (byte) 10, (byte) 0, (byte) 9, (byte) 5, (byte) 5, (byte) 2, (byte) 10, (byte) 11, (byte) 9, (byte) 1, (byte) 12, (byte) 3, (byte) 7, (byte) 4, (byte) 13, (byte) 0, (byte) 6, (byte) 15, (byte) 8, (byte) 14, (byte) 0, (byte) 4, (byte) 11, (byte) 14, (byte) 8, (byte) 3, (byte) 7, (byte) 1, (byte) 10, (byte) 2, (byte) 9, (byte) 6, (byte) 15, (byte) 13, (byte) 5, (byte) 12};
    /* renamed from: h */
    private static byte[] f26632h = new byte[]{(byte) 1, (byte) 11, (byte) 12, (byte) 2, (byte) 9, (byte) 13, (byte) 0, (byte) 15, (byte) 4, (byte) 5, (byte) 8, (byte) 14, (byte) 10, (byte) 7, (byte) 6, (byte) 3, (byte) 0, (byte) 1, (byte) 7, (byte) 13, (byte) 11, (byte) 4, (byte) 5, (byte) 2, (byte) 8, (byte) 14, (byte) 15, (byte) 12, (byte) 9, (byte) 10, (byte) 6, (byte) 3, (byte) 8, (byte) 2, (byte) 5, (byte) 0, (byte) 4, (byte) 9, (byte) 15, (byte) 10, (byte) 3, (byte) 7, (byte) 12, (byte) 13, (byte) 6, (byte) 14, (byte) 1, (byte) 11, (byte) 3, (byte) 6, (byte) 0, (byte) 1, (byte) 5, (byte) 13, (byte) 10, (byte) 8, (byte) 11, (byte) 2, (byte) 9, (byte) 7, (byte) 14, (byte) 15, (byte) 12, (byte) 4, (byte) 8, (byte) 13, (byte) 11, (byte) 0, (byte) 4, (byte) 5, (byte) 1, (byte) 2, (byte) 9, (byte) 3, (byte) 12, (byte) 14, (byte) 6, (byte) 15, (byte) 10, (byte) 7, (byte) 12, (byte) 9, (byte) 11, (byte) 1, (byte) 8, (byte) 14, (byte) 2, (byte) 4, (byte) 7, (byte) 3, (byte) 6, (byte) 5, (byte) 10, (byte) 0, (byte) 15, (byte) 13, (byte) 10, (byte) 9, (byte) 6, (byte) 8, (byte) 13, (byte) 14, (byte) 2, (byte) 0, (byte) 15, (byte) 3, (byte) 5, (byte) 11, (byte) 4, (byte) 1, (byte) 12, (byte) 7, (byte) 7, (byte) 4, (byte) 0, (byte) 5, (byte) 10, (byte) 2, (byte) 15, (byte) 14, (byte) 12, (byte) 6, (byte) 1, (byte) 11, (byte) 13, (byte) 9, (byte) 3, (byte) 8};
    /* renamed from: i */
    private static byte[] f26633i = new byte[]{(byte) 15, (byte) 12, (byte) 2, (byte) 10, (byte) 6, (byte) 4, (byte) 5, (byte) 0, (byte) 7, (byte) 9, (byte) 14, (byte) 13, (byte) 1, (byte) 11, (byte) 8, (byte) 3, (byte) 11, (byte) 6, (byte) 3, (byte) 4, (byte) 12, (byte) 15, (byte) 14, (byte) 2, (byte) 7, (byte) 13, (byte) 8, (byte) 0, (byte) 5, (byte) 10, (byte) 9, (byte) 1, (byte) 1, (byte) 12, (byte) 11, (byte) 0, (byte) 15, (byte) 14, (byte) 6, (byte) 5, (byte) 10, (byte) 13, (byte) 4, (byte) 8, (byte) 9, (byte) 3, (byte) 7, (byte) 2, (byte) 1, (byte) 5, (byte) 14, (byte) 12, (byte) 10, (byte) 7, (byte) 0, (byte) 13, (byte) 6, (byte) 2, (byte) 11, (byte) 4, (byte) 9, (byte) 3, (byte) 15, (byte) 8, (byte) 0, (byte) 12, (byte) 8, (byte) 9, (byte) 13, (byte) 2, (byte) 10, (byte) 11, (byte) 7, (byte) 3, (byte) 6, (byte) 5, (byte) 4, (byte) 14, (byte) 15, (byte) 1, (byte) 8, (byte) 0, (byte) 15, (byte) 3, (byte) 2, (byte) 5, (byte) 14, (byte) 11, (byte) 1, (byte) 10, (byte) 4, (byte) 7, (byte) 12, (byte) 9, (byte) 13, (byte) 6, (byte) 3, (byte) 0, (byte) 6, (byte) 15, (byte) 1, (byte) 14, (byte) 9, (byte) 2, (byte) 13, (byte) 8, (byte) 12, (byte) 4, (byte) 11, (byte) 10, (byte) 5, (byte) 7, (byte) 1, (byte) 10, (byte) 6, (byte) 8, (byte) 15, (byte) 11, (byte) 0, (byte) 4, (byte) 12, (byte) 3, (byte) 5, (byte) 9, (byte) 7, (byte) 13, (byte) 2, (byte) 14};
    /* renamed from: j */
    private static byte[] f26634j = new byte[]{(byte) 4, (byte) 10, (byte) 9, (byte) 2, (byte) 13, (byte) 8, (byte) 0, (byte) 14, (byte) 6, (byte) 11, (byte) 1, (byte) 12, (byte) 7, (byte) 15, (byte) 5, (byte) 3, (byte) 14, (byte) 11, (byte) 4, (byte) 12, (byte) 6, (byte) 13, (byte) 15, (byte) 10, (byte) 2, (byte) 3, (byte) 8, (byte) 1, (byte) 0, (byte) 7, (byte) 5, (byte) 9, (byte) 5, (byte) 8, (byte) 1, (byte) 13, (byte) 10, (byte) 3, (byte) 4, (byte) 2, (byte) 14, (byte) 15, (byte) 12, (byte) 7, (byte) 6, (byte) 0, (byte) 9, (byte) 11, (byte) 7, (byte) 13, (byte) 10, (byte) 1, (byte) 0, (byte) 8, (byte) 9, (byte) 15, (byte) 14, (byte) 4, (byte) 6, (byte) 12, (byte) 11, (byte) 2, (byte) 5, (byte) 3, (byte) 6, (byte) 12, (byte) 7, (byte) 1, (byte) 5, (byte) 15, (byte) 13, (byte) 8, (byte) 4, (byte) 10, (byte) 9, (byte) 14, (byte) 0, (byte) 3, (byte) 11, (byte) 2, (byte) 4, (byte) 11, (byte) 10, (byte) 0, (byte) 7, (byte) 2, (byte) 1, (byte) 13, (byte) 3, (byte) 6, (byte) 8, (byte) 5, (byte) 9, (byte) 12, (byte) 15, (byte) 14, (byte) 13, (byte) 11, (byte) 4, (byte) 1, (byte) 3, (byte) 15, (byte) 5, (byte) 9, (byte) 0, (byte) 10, (byte) 14, (byte) 7, (byte) 6, (byte) 8, (byte) 2, (byte) 12, (byte) 1, (byte) 15, (byte) 13, (byte) 0, (byte) 5, (byte) 7, (byte) 10, (byte) 4, (byte) 9, (byte) 2, (byte) 3, (byte) 14, (byte) 6, (byte) 11, (byte) 8, (byte) 12};
    /* renamed from: k */
    private static byte[] f26635k = new byte[]{(byte) 10, (byte) 4, (byte) 5, (byte) 6, (byte) 8, (byte) 1, (byte) 3, (byte) 7, (byte) 13, (byte) 12, (byte) 14, (byte) 0, (byte) 9, (byte) 2, (byte) 11, (byte) 15, (byte) 5, (byte) 15, (byte) 4, (byte) 0, (byte) 2, (byte) 13, (byte) 11, (byte) 9, (byte) 1, (byte) 7, (byte) 6, (byte) 3, (byte) 12, (byte) 14, (byte) 10, (byte) 8, (byte) 7, (byte) 15, (byte) 12, (byte) 14, (byte) 9, (byte) 4, (byte) 1, (byte) 0, (byte) 3, (byte) 11, (byte) 5, (byte) 2, (byte) 6, (byte) 10, (byte) 8, (byte) 13, (byte) 4, (byte) 10, (byte) 7, (byte) 12, (byte) 0, (byte) 15, (byte) 2, (byte) 8, (byte) 14, (byte) 1, (byte) 6, (byte) 5, (byte) 13, (byte) 11, (byte) 9, (byte) 3, (byte) 7, (byte) 6, (byte) 4, (byte) 11, (byte) 9, (byte) 12, (byte) 2, (byte) 10, (byte) 1, (byte) 8, (byte) 0, (byte) 14, (byte) 15, (byte) 13, (byte) 3, (byte) 5, (byte) 7, (byte) 6, (byte) 2, (byte) 4, (byte) 13, (byte) 9, (byte) 15, (byte) 0, (byte) 10, (byte) 1, (byte) 5, (byte) 11, (byte) 8, (byte) 14, (byte) 12, (byte) 3, (byte) 13, (byte) 14, (byte) 4, (byte) 1, (byte) 7, (byte) 0, (byte) 5, (byte) 10, (byte) 3, (byte) 12, (byte) 8, (byte) 15, (byte) 6, (byte) 2, (byte) 9, (byte) 11, (byte) 1, (byte) 3, (byte) 10, (byte) 9, (byte) 5, (byte) 11, (byte) 4, (byte) 15, (byte) 8, (byte) 6, (byte) 7, (byte) 14, (byte) 13, (byte) 0, (byte) 2, (byte) 12};
    /* renamed from: l */
    private static Hashtable f26636l = new Hashtable();
    /* renamed from: a */
    private int[] f26637a = null;
    /* renamed from: b */
    private boolean f26638b;
    /* renamed from: c */
    private byte[] f26639c = f26628d;

    /* renamed from: a */
    public String mo5741a() {
        return "GOST28147";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    static {
        m34942a("Default", f26628d);
        m34942a("E-TEST", f26629e);
        m34942a("E-A", f26630f);
        m34942a("E-B", f26631g);
        m34942a("E-C", f26632h);
        m34942a("E-D", f26633i);
        m34942a("D-TEST", f26634j);
        m34942a("D-A", f26635k);
    }

    /* renamed from: a */
    private static void m34942a(String str, byte[] bArr) {
        f26636l.put(Strings.m29424b(str), bArr);
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            byte[] a = parametersWithSBox.m35699a();
            if (a.length == f26628d.length) {
                this.f26639c = Arrays.m29373b(a);
                if (parametersWithSBox.m35700b() != null) {
                    this.f26637a = m34945a(z, ((KeyParameter) parametersWithSBox.m35700b()).m35685a());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
        } else if (cipherParameters instanceof KeyParameter) {
            this.f26637a = m34945a(z, ((KeyParameter) cipherParameters).m35685a());
        } else if (cipherParameters != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid parameter passed to GOST28147 init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26637a == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            m34943a(this.f26637a, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private int[] m34945a(boolean z, byte[] bArr) {
        this.f26638b = z;
        if (bArr.length) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = m34940a(bArr, i * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    /* renamed from: a */
    private int m34939a(int i, int i2) {
        i2 += i;
        i = (((((((this.f26639c[((i2 >> 0) & 15) + 0] << 0) + (this.f26639c[((i2 >> 4) & 15) + 16] << 4)) + (this.f26639c[((i2 >> 8) & 15) + 32] << 8)) + (this.f26639c[((i2 >> 12) & 15) + 48] << 12)) + (this.f26639c[((i2 >> 16) & 15) + 64] << 16)) + (this.f26639c[((i2 >> 20) & 15) + 80] << 20)) + (this.f26639c[((i2 >> 24) & 15) + 96] << 24)) + (this.f26639c[((i2 >> 28) & 15) + 112] << 28);
        return (i >>> 21) | (i << 11);
    }

    /* renamed from: a */
    private void m34943a(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m34940a(bArr, i);
        bArr = m34940a(bArr, i + 4);
        int i3 = 7;
        int a2;
        if (this.f26638b != 0) {
            i = bArr;
            bArr = null;
            while (bArr < 3) {
                int i4 = i;
                i = 0;
                while (i < 8) {
                    i++;
                    a2 = i4 ^ m34939a(a, iArr[i]);
                    i4 = a;
                    a = a2;
                }
                bArr++;
                i = i4;
            }
            bArr = i;
            i = a;
            while (i3 > 0) {
                i3--;
                a2 = i;
                i = bArr ^ m34939a(i, iArr[i3]);
                bArr = a2;
            }
        } else {
            i = bArr;
            bArr = null;
            while (bArr < 8) {
                bArr++;
                a2 = a;
                a = i ^ m34939a(a, iArr[bArr]);
                i = a2;
            }
            bArr = null;
            while (bArr < 3) {
                int i5 = i;
                i = 7;
                while (i >= 0) {
                    if (bArr == 2 && i == 0) {
                        break;
                    }
                    i--;
                    a2 = i5 ^ m34939a(a, iArr[i]);
                    i5 = a;
                    a = a2;
                }
                bArr++;
                i = i5;
            }
            bArr = i;
            i = a;
        }
        iArr = m34939a(i, iArr[0]) ^ bArr;
        m34941a(i, bArr2, i2);
        m34941a(iArr, bArr2, i2 + 4);
    }

    /* renamed from: a */
    private int m34940a(byte[] bArr, int i) {
        return ((((bArr[i + 3] << 24) & -16777216) + ((bArr[i + 2] << 16) & 16711680)) + ((bArr[i + 1] << 8) & 65280)) + (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: a */
    private void m34941a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    /* renamed from: a */
    public static byte[] m34944a(String str) {
        byte[] bArr = (byte[]) f26636l.get(Strings.m29424b(str));
        if (bArr != null) {
            return Arrays.m29373b(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"D-Test\", \"D-A\".");
    }
}
