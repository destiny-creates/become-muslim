package org.spongycastle.pqc.crypto.rainbow;

import com.facebook.imageutils.JfifUtil;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.util.Arrays;

public class Layer {
    /* renamed from: a */
    private int f23316a;
    /* renamed from: b */
    private int f23317b;
    /* renamed from: c */
    private int f23318c;
    /* renamed from: d */
    private short[][][] f23319d;
    /* renamed from: e */
    private short[][][] f23320e;
    /* renamed from: f */
    private short[][] f23321f;
    /* renamed from: g */
    private short[] f23322g;

    public Layer(byte b, byte b2, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        this.f23316a = b & JfifUtil.MARKER_FIRST_BYTE;
        this.f23317b = b2 & JfifUtil.MARKER_FIRST_BYTE;
        this.f23318c = this.f23317b - this.f23316a;
        this.f23319d = sArr;
        this.f23320e = sArr2;
        this.f23321f = sArr3;
        this.f23322g = sArr4;
    }

    public Layer(int i, int i2, SecureRandom secureRandom) {
        int i3;
        this.f23316a = i;
        this.f23317b = i2;
        this.f23318c = i2 - i;
        this.f23319d = (short[][][]) Array.newInstance(short.class, new int[]{this.f23318c, this.f23318c, this.f23316a});
        this.f23320e = (short[][][]) Array.newInstance(short.class, new int[]{this.f23318c, this.f23316a, this.f23316a});
        this.f23321f = (short[][]) Array.newInstance(short.class, new int[]{this.f23318c, this.f23317b});
        this.f23322g = new short[this.f23318c];
        i = this.f23318c;
        for (i3 = 0; i3 < i; i3++) {
            int i4;
            for (i4 = 0; i4 < this.f23318c; i4++) {
                int i5;
                for (i5 = 0; i5 < this.f23316a; i5++) {
                    this.f23319d[i3][i4][i5] = (short) (secureRandom.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
        }
        for (i3 = 0; i3 < i; i3++) {
            for (i4 = 0; i4 < this.f23316a; i4++) {
                for (i5 = 0; i5 < this.f23316a; i5++) {
                    this.f23320e[i3][i4][i5] = (short) (secureRandom.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
                }
            }
        }
        for (i3 = 0; i3 < i; i3++) {
            for (i4 = 0; i4 < this.f23317b; i4++) {
                this.f23321f[i3][i4] = (short) (secureRandom.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
            }
        }
        for (i2 = 0; i2 < i; i2++) {
            this.f23322g[i2] = (short) (secureRandom.nextInt() & JfifUtil.MARKER_FIRST_BYTE);
        }
    }

    /* renamed from: a */
    public short[][] m29107a(short[] sArr) {
        int i;
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, new int[]{this.f23318c, this.f23318c + 1});
        short[] sArr3 = new short[this.f23318c];
        for (i = 0; i < this.f23318c; i++) {
            int i2;
            for (i2 = 0; i2 < this.f23316a; i2++) {
                int i3;
                for (i3 = 0; i3 < this.f23316a; i3++) {
                    sArr3[i] = GF2Field.m29126a(sArr3[i], GF2Field.m29127b(GF2Field.m29127b(this.f23320e[i][i2][i3], sArr[i2]), sArr[i3]));
                }
            }
        }
        for (i = 0; i < this.f23318c; i++) {
            for (i2 = 0; i2 < this.f23318c; i2++) {
                for (i3 = 0; i3 < this.f23316a; i3++) {
                    sArr2[i][i2] = GF2Field.m29126a(sArr2[i][i2], GF2Field.m29127b(this.f23319d[i][i2][i3], sArr[i3]));
                }
            }
        }
        for (i = 0; i < this.f23318c; i++) {
            for (i2 = 0; i2 < this.f23316a; i2++) {
                sArr3[i] = GF2Field.m29126a(sArr3[i], GF2Field.m29127b(this.f23321f[i][i2], sArr[i2]));
            }
        }
        for (sArr = null; sArr < this.f23318c; sArr++) {
            for (i = this.f23316a; i < this.f23317b; i++) {
                sArr2[sArr][i - this.f23316a] = GF2Field.m29126a(this.f23321f[sArr][i], sArr2[sArr][i - this.f23316a]);
            }
        }
        for (sArr = null; sArr < this.f23318c; sArr++) {
            sArr3[sArr] = GF2Field.m29126a(sArr3[sArr], this.f23322g[sArr]);
        }
        for (int i4 = 0; i4 < this.f23318c; i4++) {
            sArr2[i4][this.f23318c] = sArr3[i4];
        }
        return sArr2;
    }

    /* renamed from: a */
    public int m29106a() {
        return this.f23316a;
    }

    /* renamed from: b */
    public int m29108b() {
        return this.f23317b;
    }

    /* renamed from: c */
    public int m29109c() {
        return this.f23318c;
    }

    /* renamed from: d */
    public short[][][] m29110d() {
        return this.f23319d;
    }

    /* renamed from: e */
    public short[][][] m29111e() {
        return this.f23320e;
    }

    /* renamed from: f */
    public short[][] m29112f() {
        return this.f23321f;
    }

    /* renamed from: g */
    public short[] m29113g() {
        return this.f23322g;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            if (obj instanceof Layer) {
                Layer layer = (Layer) obj;
                if (this.f23316a == layer.m29106a() && this.f23317b == layer.m29108b() && this.f23318c == layer.m29109c() && RainbowUtil.m29130a(this.f23319d, layer.m29110d()) && RainbowUtil.m29130a(this.f23320e, layer.m29111e()) && RainbowUtil.m29129a(this.f23321f, layer.m29112f()) && RainbowUtil.m29128a(this.f23322g, layer.m29113g()) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f23316a * 37) + this.f23317b) * 37) + this.f23318c) * 37) + Arrays.m29350a(this.f23319d)) * 37) + Arrays.m29350a(this.f23320e)) * 37) + Arrays.m29349a(this.f23321f)) * 37) + Arrays.m29348a(this.f23322g);
    }
}
