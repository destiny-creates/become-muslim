package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.encoders.Hex;

public class GMSSRootCalc {
    /* renamed from: a */
    private int f23195a;
    /* renamed from: b */
    private int f23196b = this.f23204j.mo5732b();
    /* renamed from: c */
    private Treehash[] f23197c;
    /* renamed from: d */
    private Vector[] f23198d;
    /* renamed from: e */
    private byte[] f23199e;
    /* renamed from: f */
    private byte[][] f23200f;
    /* renamed from: g */
    private int f23201g;
    /* renamed from: h */
    private Vector f23202h;
    /* renamed from: i */
    private Vector f23203i;
    /* renamed from: j */
    private Digest f23204j;
    /* renamed from: k */
    private GMSSDigestProvider f23205k;
    /* renamed from: l */
    private int[] f23206l;
    /* renamed from: m */
    private boolean f23207m;
    /* renamed from: n */
    private boolean f23208n;
    /* renamed from: o */
    private int f23209o;
    /* renamed from: p */
    private int f23210p;

    public GMSSRootCalc(int i, int i2, GMSSDigestProvider gMSSDigestProvider) {
        this.f23195a = i;
        this.f23205k = gMSSDigestProvider;
        this.f23204j = gMSSDigestProvider.m29043a();
        this.f23201g = i2;
        this.f23206l = new int[i];
        this.f23200f = (byte[][]) Array.newInstance(byte.class, new int[]{i, this.f23196b});
        this.f23199e = new byte[this.f23196b];
        this.f23198d = new Vector[(this.f23201g - 1)];
        for (i = 0; i < i2 - 1; i++) {
            this.f23198d[i] = new Vector();
        }
    }

    /* renamed from: a */
    public void m29053a(Vector vector) {
        int i;
        this.f23197c = new Treehash[(this.f23195a - this.f23201g)];
        for (i = 0; i < this.f23195a - this.f23201g; i++) {
            this.f23197c[i] = new Treehash(vector, i, this.f23205k.m29043a());
        }
        this.f23206l = new int[this.f23195a];
        this.f23200f = (byte[][]) Array.newInstance(byte.class, new int[]{this.f23195a, this.f23196b});
        this.f23199e = new byte[this.f23196b];
        this.f23202h = new Vector();
        this.f23203i = new Vector();
        this.f23207m = true;
        this.f23208n = false;
        for (i = 0; i < this.f23195a; i++) {
            this.f23206l[i] = -1;
        }
        this.f23198d = new Vector[(this.f23201g - 1)];
        for (i = 0; i < this.f23201g - 1; i++) {
            this.f23198d[i] = new Vector();
        }
        this.f23209o = 3;
        this.f23210p = 0;
    }

    /* renamed from: a */
    public void m29054a(byte[] bArr) {
        if (this.f23208n) {
            System.out.print("Too much updates for Tree!!");
        } else if (this.f23207m) {
            int[] iArr = this.f23206l;
            iArr[0] = iArr[0] + 1;
            if (this.f23206l[0] == 1) {
                System.arraycopy(bArr, 0, this.f23200f[0], 0, this.f23196b);
            } else if (this.f23206l[0] == 3 && this.f23195a > this.f23201g) {
                this.f23197c[0].m29073b(bArr);
            }
            if ((this.f23206l[0] - 3) % 2 == 0 && this.f23206l[0] >= 3 && this.f23195a == this.f23201g) {
                this.f23198d[0].insertElementAt(bArr, 0);
            }
            if (this.f23206l[0] == 0) {
                this.f23202h.addElement(bArr);
                this.f23203i.addElement(Integers.m29396a(0));
            } else {
                Object obj = new byte[this.f23196b];
                Object obj2 = new byte[(this.f23196b << 1)];
                System.arraycopy(bArr, 0, obj, 0, this.f23196b);
                bArr = null;
                while (this.f23202h.size() > 0 && bArr == ((Integer) this.f23203i.lastElement()).intValue()) {
                    System.arraycopy(this.f23202h.lastElement(), 0, obj2, 0, this.f23196b);
                    this.f23202h.removeElementAt(this.f23202h.size() - 1);
                    this.f23203i.removeElementAt(this.f23203i.size() - 1);
                    System.arraycopy(obj, 0, obj2, this.f23196b, this.f23196b);
                    this.f23204j.mo5731a(obj2, 0, obj2.length);
                    obj = new byte[this.f23204j.mo5732b()];
                    this.f23204j.mo5728a(obj, 0);
                    bArr++;
                    if (bArr < this.f23195a) {
                        int[] iArr2 = this.f23206l;
                        iArr2[bArr] = iArr2[bArr] + 1;
                        if (this.f23206l[bArr] == 1) {
                            System.arraycopy(obj, 0, this.f23200f[bArr], 0, this.f23196b);
                        }
                        if (bArr >= this.f23195a - this.f23201g) {
                            if (bArr == null) {
                                System.out.println("M���P");
                            }
                            if ((this.f23206l[bArr] - 3) % 2 == 0 && this.f23206l[bArr] >= 3) {
                                this.f23198d[bArr - (this.f23195a - this.f23201g)].insertElementAt(obj, 0);
                            }
                        } else if (this.f23206l[bArr] == 3) {
                            this.f23197c[bArr].m29073b(obj);
                        }
                    }
                }
                this.f23202h.addElement(obj);
                this.f23203i.addElement(Integers.m29396a(bArr));
                if (bArr == this.f23195a) {
                    this.f23208n = true;
                    this.f23207m = false;
                    this.f23199e = (byte[]) this.f23202h.lastElement();
                }
            }
        } else {
            System.err.println("GMSSRootCalc not initialized!");
        }
    }

    /* renamed from: a */
    public void m29055a(byte[] bArr, int i) {
        this.f23197c[i].m29072a(bArr);
    }

    /* renamed from: a */
    public boolean m29056a() {
        return this.f23208n;
    }

    /* renamed from: b */
    public byte[][] m29057b() {
        return GMSSUtils.m29070a(this.f23200f);
    }

    /* renamed from: c */
    public Treehash[] m29058c() {
        return GMSSUtils.m29069a(this.f23197c);
    }

    /* renamed from: d */
    public Vector[] m29059d() {
        return GMSSUtils.m29068a(this.f23198d);
    }

    /* renamed from: e */
    public byte[] m29060e() {
        return Arrays.m29373b(this.f23199e);
    }

    /* renamed from: f */
    public byte[][] m29061f() {
        int i;
        int i2 = 0;
        if (this.f23202h == null) {
            i = 0;
        } else {
            i = this.f23202h.size();
        }
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{(this.f23195a + 1) + i, 64});
        bArr[0] = this.f23199e;
        int i3 = 0;
        while (i3 < this.f23195a) {
            int i4 = i3 + 1;
            bArr[i4] = this.f23200f[i3];
            i3 = i4;
        }
        while (i2 < i) {
            bArr[(this.f23195a + 1) + i2] = (byte[]) this.f23202h.elementAt(i2);
            i2++;
        }
        return bArr;
    }

    /* renamed from: g */
    public int[] m29062g() {
        int i;
        int i2 = 0;
        if (this.f23202h == null) {
            i = 0;
        } else {
            i = this.f23202h.size();
        }
        int[] iArr = new int[((this.f23195a + 8) + i)];
        iArr[0] = this.f23195a;
        iArr[1] = this.f23196b;
        iArr[2] = this.f23201g;
        iArr[3] = this.f23209o;
        iArr[4] = this.f23210p;
        if (this.f23208n) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.f23207m) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = i;
        for (int i3 = 0; i3 < this.f23195a; i3++) {
            iArr[i3 + 8] = this.f23206l[i3];
        }
        while (i2 < i) {
            iArr[(this.f23195a + 8) + i2] = ((Integer) this.f23203i.elementAt(i2)).intValue();
            i2++;
        }
        return iArr;
    }

    public String toString() {
        int i;
        StringBuilder stringBuilder;
        String str = "";
        if (this.f23202h == null) {
            i = 0;
        } else {
            i = this.f23202h.size();
        }
        String str2 = str;
        for (int i2 = 0; i2 < (this.f23195a + 8) + i; i2++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(m29062g()[i2]);
            stringBuilder2.append(" ");
            str2 = stringBuilder2.toString();
        }
        for (int i3 = 0; i3 < (this.f23195a + 1) + i; i3++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(new String(Hex.m29437a(m29061f()[i3])));
            stringBuilder.append(" ");
            str2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(this.f23205k.m29043a().mo5732b());
        return stringBuilder.toString();
    }
}
