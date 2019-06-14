package org.spongycastle.pqc.crypto.ntru;

import java.util.Arrays;
import org.spongycastle.crypto.Digest;

public class NTRUEncryptionParameters implements Cloneable {
    /* renamed from: A */
    public Digest f23270A;
    /* renamed from: a */
    public int f23271a;
    /* renamed from: b */
    public int f23272b;
    /* renamed from: c */
    public int f23273c;
    /* renamed from: d */
    public int f23274d;
    /* renamed from: e */
    public int f23275e;
    /* renamed from: f */
    public int f23276f;
    /* renamed from: g */
    public int f23277g;
    /* renamed from: h */
    public int f23278h;
    /* renamed from: i */
    public int f23279i;
    /* renamed from: j */
    public int f23280j;
    /* renamed from: k */
    public int f23281k;
    /* renamed from: l */
    int f23282l;
    /* renamed from: m */
    public int f23283m;
    /* renamed from: n */
    public int f23284n;
    /* renamed from: o */
    public int f23285o;
    /* renamed from: p */
    int f23286p;
    /* renamed from: q */
    public int f23287q;
    /* renamed from: r */
    public int f23288r;
    /* renamed from: s */
    public int f23289s;
    /* renamed from: t */
    public int f23290t;
    /* renamed from: u */
    public int f23291u;
    /* renamed from: v */
    public boolean f23292v;
    /* renamed from: w */
    public byte[] f23293w;
    /* renamed from: x */
    public boolean f23294x;
    /* renamed from: y */
    public boolean f23295y;
    /* renamed from: z */
    public int f23296z = 1;

    public /* synthetic */ Object clone() {
        return m29102a();
    }

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f23271a = i;
        this.f23272b = i2;
        this.f23273c = i3;
        this.f23284n = i5;
        this.f23287q = i4;
        this.f23289s = i6;
        this.f23290t = i7;
        this.f23291u = i8;
        this.f23292v = z;
        this.f23293w = bArr;
        this.f23294x = z2;
        this.f23295y = z3;
        this.f23270A = digest;
        m29101b();
    }

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f23271a = i;
        this.f23272b = i2;
        this.f23274d = i3;
        this.f23275e = i4;
        this.f23276f = i5;
        this.f23284n = i7;
        this.f23287q = i6;
        this.f23289s = i8;
        this.f23290t = i9;
        this.f23291u = i10;
        this.f23292v = z;
        this.f23293w = bArr;
        this.f23294x = z2;
        this.f23295y = z3;
        this.f23270A = digest;
        m29101b();
    }

    /* renamed from: b */
    private void m29101b() {
        this.f23277g = this.f23273c;
        this.f23278h = this.f23274d;
        this.f23279i = this.f23275e;
        this.f23280j = this.f23276f;
        this.f23281k = this.f23271a / 3;
        this.f23282l = 1;
        this.f23283m = (((((this.f23271a * 3) / 2) / 8) - this.f23282l) - (this.f23284n / 8)) - 1;
        this.f23285o = (((((this.f23271a * 3) / 2) + 7) / 8) * 8) + 1;
        this.f23286p = this.f23271a - 1;
        this.f23288r = this.f23284n;
    }

    /* renamed from: a */
    public NTRUEncryptionParameters m29102a() {
        if (this.f23296z == 0) {
            return new NTRUEncryptionParameters(r0.f23271a, r0.f23272b, r0.f23273c, r0.f23287q, r0.f23284n, r0.f23289s, r0.f23290t, r0.f23291u, r0.f23292v, r0.f23293w, r0.f23294x, r0.f23295y, r0.f23270A);
        }
        return new NTRUEncryptionParameters(r0.f23271a, r0.f23272b, r0.f23274d, r0.f23275e, r0.f23276f, r0.f23287q, r0.f23284n, r0.f23289s, r0.f23290t, r0.f23291u, r0.f23292v, r0.f23293w, r0.f23294x, r0.f23295y, r0.f23270A);
    }

    public int hashCode() {
        int i = 1237;
        int hashCode = (((((((((((((((((((((((((((((((((((((((((((((((((((this.f23271a + 31) * 31) + this.f23285o) * 31) + this.f23286p) * 31) + this.f23289s) * 31) + this.f23284n) * 31) + this.f23273c) * 31) + this.f23274d) * 31) + this.f23275e) * 31) + this.f23276f) * 31) + this.f23281k) * 31) + this.f23287q) * 31) + this.f23277g) * 31) + this.f23278h) * 31) + this.f23279i) * 31) + this.f23280j) * 31) + (this.f23295y ? 1231 : 1237)) * 31) + (this.f23270A == null ? 0 : this.f23270A.mo5729a().hashCode())) * 31) + (this.f23292v ? 1231 : 1237)) * 31) + this.f23282l) * 31) + this.f23283m) * 31) + this.f23291u) * 31) + this.f23290t) * 31) + Arrays.hashCode(this.f23293w)) * 31) + this.f23288r) * 31) + this.f23296z) * 31) + this.f23272b) * 31;
        if (this.f23294x) {
            i = 1231;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionParameters nTRUEncryptionParameters = (NTRUEncryptionParameters) obj;
        if (this.f23271a != nTRUEncryptionParameters.f23271a || this.f23285o != nTRUEncryptionParameters.f23285o || this.f23286p != nTRUEncryptionParameters.f23286p || this.f23289s != nTRUEncryptionParameters.f23289s || this.f23284n != nTRUEncryptionParameters.f23284n || this.f23273c != nTRUEncryptionParameters.f23273c || this.f23274d != nTRUEncryptionParameters.f23274d || this.f23275e != nTRUEncryptionParameters.f23275e || this.f23276f != nTRUEncryptionParameters.f23276f || this.f23281k != nTRUEncryptionParameters.f23281k || this.f23287q != nTRUEncryptionParameters.f23287q || this.f23277g != nTRUEncryptionParameters.f23277g || this.f23278h != nTRUEncryptionParameters.f23278h || this.f23279i != nTRUEncryptionParameters.f23279i || this.f23280j != nTRUEncryptionParameters.f23280j || this.f23295y != nTRUEncryptionParameters.f23295y) {
            return false;
        }
        if (this.f23270A == null) {
            if (nTRUEncryptionParameters.f23270A != null) {
                return false;
            }
        } else if (!this.f23270A.mo5729a().equals(nTRUEncryptionParameters.f23270A.mo5729a())) {
            return false;
        }
        return this.f23292v == nTRUEncryptionParameters.f23292v && this.f23282l == nTRUEncryptionParameters.f23282l && this.f23283m == nTRUEncryptionParameters.f23283m && this.f23291u == nTRUEncryptionParameters.f23291u && this.f23290t == nTRUEncryptionParameters.f23290t && Arrays.equals(this.f23293w, nTRUEncryptionParameters.f23293w) && this.f23288r == nTRUEncryptionParameters.f23288r && this.f23296z == nTRUEncryptionParameters.f23296z && this.f23272b == nTRUEncryptionParameters.f23272b && this.f23294x == nTRUEncryptionParameters.f23294x;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EncryptionParameters(N=");
        stringBuilder.append(this.f23271a);
        stringBuilder.append(" q=");
        stringBuilder.append(this.f23272b);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        if (this.f23296z == 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=SIMPLE df=");
            stringBuilder.append(this.f23273c);
            stringBuilder2.append(stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" polyType=PRODUCT df1=");
            stringBuilder.append(this.f23274d);
            stringBuilder.append(" df2=");
            stringBuilder.append(this.f23275e);
            stringBuilder.append(" df3=");
            stringBuilder.append(this.f23276f);
            stringBuilder2.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(" dm0=");
        stringBuilder.append(this.f23287q);
        stringBuilder.append(" db=");
        stringBuilder.append(this.f23284n);
        stringBuilder.append(" c=");
        stringBuilder.append(this.f23289s);
        stringBuilder.append(" minCallsR=");
        stringBuilder.append(this.f23290t);
        stringBuilder.append(" minCallsMask=");
        stringBuilder.append(this.f23291u);
        stringBuilder.append(" hashSeed=");
        stringBuilder.append(this.f23292v);
        stringBuilder.append(" hashAlg=");
        stringBuilder.append(this.f23270A);
        stringBuilder.append(" oid=");
        stringBuilder.append(Arrays.toString(this.f23293w));
        stringBuilder.append(" sparse=");
        stringBuilder.append(this.f23294x);
        stringBuilder.append(")");
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }
}
