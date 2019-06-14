package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.encoders.Hex;

public class GMSSLeaf {
    /* renamed from: a */
    byte[] f23178a;
    /* renamed from: b */
    private Digest f23179b;
    /* renamed from: c */
    private int f23180c = this.f23179b.mo5732b();
    /* renamed from: d */
    private int f23181d;
    /* renamed from: e */
    private GMSSRandom f23182e = new GMSSRandom(this.f23179b);
    /* renamed from: f */
    private byte[] f23183f;
    /* renamed from: g */
    private byte[] f23184g;
    /* renamed from: h */
    private int f23185h;
    /* renamed from: i */
    private int f23186i;
    /* renamed from: j */
    private int f23187j;
    /* renamed from: k */
    private int f23188k;
    /* renamed from: l */
    private int f23189l;
    /* renamed from: m */
    private byte[] f23190m;

    /* renamed from: a */
    private int m29044a(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    GMSSLeaf(Digest digest, int i, int i2) {
        this.f23188k = i;
        this.f23179b = digest;
        double d = (double) i;
        digest = (int) Math.ceil(((double) (this.f23180c << 3)) / d);
        this.f23181d = digest + ((int) Math.ceil(((double) m29044a((digest << i) + 1)) / d));
        digest = 1 << i;
        this.f23187j = digest;
        this.f23189l = (int) Math.ceil(((double) ((((digest - 1) * this.f23181d) + 1) + this.f23181d)) / ((double) i2));
        this.f23190m = new byte[this.f23180c];
        this.f23183f = new byte[this.f23180c];
        this.f23178a = new byte[this.f23180c];
        this.f23184g = new byte[(this.f23180c * this.f23181d)];
    }

    public GMSSLeaf(Digest digest, int i, int i2, byte[] bArr) {
        this.f23188k = i;
        this.f23179b = digest;
        double d = (double) i;
        digest = (int) Math.ceil(((double) (this.f23180c << 3)) / d);
        this.f23181d = digest + ((int) Math.ceil(((double) m29044a((digest << i) + 1)) / d));
        digest = 1 << i;
        this.f23187j = digest;
        this.f23189l = (int) Math.ceil(((double) ((((digest - 1) * this.f23181d) + 1) + this.f23181d)) / ((double) i2));
        this.f23190m = new byte[this.f23180c];
        this.f23183f = new byte[this.f23180c];
        this.f23178a = new byte[this.f23180c];
        this.f23184g = new byte[(this.f23180c * this.f23181d)];
        m29045a(bArr);
    }

    /* renamed from: a */
    void m29045a(byte[] bArr) {
        this.f23185h = 0;
        this.f23186i = 0;
        Object obj = new byte[this.f23180c];
        System.arraycopy(bArr, 0, obj, 0, this.f23190m.length);
        this.f23190m = this.f23182e.m29078a(obj);
    }

    /* renamed from: a */
    public byte[][] m29046a() {
        byte[][] bArr = new byte[][]{new byte[this.f23180c], new byte[this.f23180c], new byte[(this.f23180c * this.f23181d)], new byte[this.f23180c]};
        bArr[0] = this.f23178a;
        bArr[1] = this.f23190m;
        bArr[2] = this.f23184g;
        bArr[3] = this.f23183f;
        return bArr;
    }

    /* renamed from: b */
    public int[] m29047b() {
        return new int[]{this.f23185h, this.f23186i, this.f23189l, this.f23188k};
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < 4; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(m29047b()[i]);
            stringBuilder.append(" ");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(" ");
        stringBuilder2.append(this.f23180c);
        stringBuilder2.append(" ");
        stringBuilder2.append(this.f23181d);
        stringBuilder2.append(" ");
        stringBuilder2.append(this.f23187j);
        stringBuilder2.append(" ");
        String stringBuilder3 = stringBuilder2.toString();
        byte[][] a = m29046a();
        for (int i2 = 0; i2 < 4; i2++) {
            StringBuilder stringBuilder4;
            if (a[i2] != null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stringBuilder3);
                stringBuilder4.append(new String(Hex.m29437a(a[i2])));
                stringBuilder4.append(" ");
                stringBuilder3 = stringBuilder4.toString();
            } else {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stringBuilder3);
                stringBuilder4.append("null ");
                stringBuilder3 = stringBuilder4.toString();
            }
        }
        return stringBuilder3;
    }
}
