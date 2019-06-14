package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.Arrays;

public class GMSSPrivateKeyParameters extends GMSSKeyParameters {
    /* renamed from: A */
    private int[] f32677A;
    /* renamed from: B */
    private int f32678B;
    /* renamed from: C */
    private Digest f32679C;
    /* renamed from: D */
    private int f32680D;
    /* renamed from: E */
    private GMSSRandom f32681E;
    /* renamed from: F */
    private int[] f32682F;
    /* renamed from: b */
    private int[] f32683b;
    /* renamed from: c */
    private byte[][] f32684c;
    /* renamed from: d */
    private byte[][] f32685d;
    /* renamed from: e */
    private byte[][][] f32686e;
    /* renamed from: f */
    private byte[][][] f32687f;
    /* renamed from: g */
    private Treehash[][] f32688g;
    /* renamed from: h */
    private Treehash[][] f32689h;
    /* renamed from: i */
    private Vector[] f32690i;
    /* renamed from: j */
    private Vector[] f32691j;
    /* renamed from: k */
    private Vector[][] f32692k;
    /* renamed from: l */
    private Vector[][] f32693l;
    /* renamed from: m */
    private byte[][][] f32694m;
    /* renamed from: n */
    private GMSSLeaf[] f32695n;
    /* renamed from: o */
    private GMSSLeaf[] f32696o;
    /* renamed from: p */
    private GMSSLeaf[] f32697p;
    /* renamed from: q */
    private int[] f32698q;
    /* renamed from: r */
    private GMSSParameters f32699r;
    /* renamed from: s */
    private byte[][] f32700s;
    /* renamed from: t */
    private GMSSRootCalc[] f32701t;
    /* renamed from: u */
    private byte[][] f32702u;
    /* renamed from: v */
    private GMSSRootSig[] f32703v;
    /* renamed from: w */
    private GMSSDigestProvider f32704w;
    /* renamed from: x */
    private boolean f32705x;
    /* renamed from: y */
    private int[] f32706y;
    /* renamed from: z */
    private int[] f32707z;

    public GMSSPrivateKeyParameters(byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][] bArr5, byte[][] bArr6, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        this(null, bArr, bArr2, bArr3, bArr4, (byte[][][]) null, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, null, null, null, null, bArr5, null, bArr6, null, gMSSParameters, gMSSDigestProvider);
    }

    public GMSSPrivateKeyParameters(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, GMSSDigestProvider gMSSDigestProvider) {
        int i;
        int i2;
        int i3;
        int[] iArr3 = iArr;
        byte[][] bArr8 = bArr;
        byte[][][] bArr9 = bArr5;
        Vector[] vectorArr5 = vectorArr;
        Vector[] vectorArr6 = vectorArr2;
        GMSSLeaf[] gMSSLeafArr4 = gMSSLeafArr;
        GMSSLeaf[] gMSSLeafArr5 = gMSSLeafArr2;
        GMSSLeaf[] gMSSLeafArr6 = gMSSLeafArr3;
        int[] iArr4 = iArr2;
        byte[][] bArr10 = bArr6;
        GMSSRootCalc[] gMSSRootCalcArr2 = gMSSRootCalcArr;
        GMSSRootSig[] gMSSRootSigArr2 = gMSSRootSigArr;
        GMSSParameters gMSSParameters2 = gMSSParameters;
        super(true, gMSSParameters2);
        this.f32705x = false;
        this.f32679C = gMSSDigestProvider.m29043a();
        this.f32680D = this.f32679C.mo5732b();
        this.f32699r = gMSSParameters2;
        this.f32707z = gMSSParameters.m29051c();
        this.f32677A = gMSSParameters.m29052d();
        this.f32706y = gMSSParameters.m29050b();
        this.f32678B = this.f32699r.m29049a();
        if (iArr3 == null) {
            r0.f32683b = new int[r0.f32678B];
            for (i = 0; i < r0.f32678B; i++) {
                r0.f32683b[i] = 0;
            }
        } else {
            r0.f32683b = iArr3;
        }
        r0.f32684c = bArr8;
        r0.f32685d = bArr2;
        r0.f32686e = bArr3;
        r0.f32687f = bArr4;
        if (bArr9 == null) {
            r0.f32694m = new byte[r0.f32678B][][];
            for (i = 0; i < r0.f32678B; i++) {
                r0.f32694m[i] = (byte[][]) Array.newInstance(byte.class, new int[]{(int) Math.floor((double) (r0.f32706y[i] / 2)), r0.f32680D});
            }
        } else {
            r0.f32694m = bArr9;
        }
        if (vectorArr5 == null) {
            r0.f32690i = new Vector[r0.f32678B];
            for (i = 0; i < r0.f32678B; i++) {
                r0.f32690i[i] = new Vector();
            }
        } else {
            r0.f32690i = vectorArr5;
        }
        if (vectorArr6 == null) {
            i2 = 1;
            r0.f32691j = new Vector[(r0.f32678B - 1)];
            i = 0;
            while (i < r0.f32678B - i2) {
                r0.f32691j[i] = new Vector();
                i++;
                i2 = 1;
            }
        } else {
            r0.f32691j = vectorArr6;
        }
        r0.f32688g = treehashArr;
        r0.f32689h = treehashArr2;
        r0.f32692k = vectorArr3;
        r0.f32693l = vectorArr4;
        r0.f32700s = bArr10;
        r0.f32704w = gMSSDigestProvider;
        if (gMSSRootCalcArr2 == null) {
            i3 = 1;
            r0.f32701t = new GMSSRootCalc[(r0.f32678B - 1)];
            i2 = 0;
            while (i2 < r0.f32678B - i3) {
                int i4 = i2 + 1;
                r0.f32701t[i2] = new GMSSRootCalc(r0.f32706y[i4], r0.f32677A[i4], r0.f32704w);
                i2 = i4;
                i3 = 1;
            }
        } else {
            r0.f32701t = gMSSRootCalcArr2;
        }
        r0.f32702u = bArr7;
        r0.f32682F = new int[r0.f32678B];
        for (i2 = 0; i2 < r0.f32678B; i2++) {
            r0.f32682F[i2] = 1 << r0.f32706y[i2];
        }
        r0.f32681E = new GMSSRandom(r0.f32679C);
        if (r0.f32678B <= 1) {
            r0.f32695n = new GMSSLeaf[0];
        } else if (gMSSLeafArr4 == null) {
            r0.f32695n = new GMSSLeaf[(r0.f32678B - 2)];
            i2 = 0;
            while (i2 < r0.f32678B - 2) {
                i4 = i2 + 1;
                r0.f32695n[i2] = new GMSSLeaf(gMSSDigestProvider.m29043a(), r0.f32707z[i4], r0.f32682F[i2 + 2], r0.f32685d[i2]);
                i2 = i4;
            }
        } else {
            r0.f32695n = gMSSLeafArr4;
        }
        if (gMSSLeafArr5 == null) {
            i3 = 1;
            r0.f32696o = new GMSSLeaf[(r0.f32678B - 1)];
            i2 = 0;
            while (i2 < r0.f32678B - i3) {
                i4 = i2 + 1;
                r0.f32696o[i2] = new GMSSLeaf(gMSSDigestProvider.m29043a(), r0.f32707z[i2], r0.f32682F[i4], r0.f32684c[i2]);
                i2 = i4;
                i3 = 1;
            }
        } else {
            r0.f32696o = gMSSLeafArr5;
        }
        if (gMSSLeafArr6 == null) {
            i3 = 1;
            r0.f32697p = new GMSSLeaf[(r0.f32678B - 1)];
            i2 = 0;
            while (i2 < r0.f32678B - i3) {
                int i5 = i2 + 1;
                r0.f32697p[i2] = new GMSSLeaf(gMSSDigestProvider.m29043a(), r0.f32707z[i2], r0.f32682F[i5]);
                i2 = i5;
                i3 = 1;
            }
        } else {
            r0.f32697p = gMSSLeafArr6;
        }
        if (iArr4 == null) {
            i3 = 1;
            r0.f32698q = new int[(r0.f32678B - 1)];
            i2 = 0;
            while (i2 < r0.f32678B - i3) {
                r0.f32698q[i2] = -1;
                i2++;
                i3 = 1;
            }
        } else {
            r0.f32698q = iArr4;
        }
        Object obj = new byte[r0.f32680D];
        byte[] bArr11 = new byte[r0.f32680D];
        if (gMSSRootSigArr2 == null) {
            r0.f32703v = new GMSSRootSig[(r0.f32678B - 1)];
            i3 = 0;
            while (i3 < r0.f32678B - 1) {
                System.arraycopy(bArr8[i3], 0, obj, 0, r0.f32680D);
                r0.f32681E.m29078a(obj);
                byte[] a = r0.f32681E.m29078a(obj);
                int i6 = i3 + 1;
                r0.f32703v[i3] = new GMSSRootSig(gMSSDigestProvider.m29043a(), r0.f32707z[i3], r0.f32706y[i6]);
                r0.f32703v[i3].m29064a(a, bArr10[i3]);
                i3 = i6;
            }
            return;
        }
        r0.f32703v = gMSSRootSigArr2;
    }

    /* renamed from: c */
    public boolean m43437c() {
        return this.f32705x;
    }

    /* renamed from: d */
    public void m43438d() {
        this.f32705x = true;
    }

    /* renamed from: e */
    public int[] m43439e() {
        return this.f32683b;
    }

    /* renamed from: a */
    public int m43434a(int i) {
        return this.f32683b[i];
    }

    /* renamed from: f */
    public byte[][] m43440f() {
        return Arrays.m29369a(this.f32684c);
    }

    /* renamed from: g */
    public byte[][][] m43441g() {
        return Arrays.m29370a(this.f32686e);
    }

    /* renamed from: b */
    public byte[] m43435b(int i) {
        return this.f32702u[i];
    }

    /* renamed from: c */
    public int m43436c(int i) {
        return this.f32682F[i];
    }
}
