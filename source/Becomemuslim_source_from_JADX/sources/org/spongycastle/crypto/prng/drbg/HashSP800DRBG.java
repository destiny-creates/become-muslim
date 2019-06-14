package org.spongycastle.crypto.prng.drbg;

import com.facebook.imageutils.JfifUtil;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

public class HashSP800DRBG implements SP80090DRBG {
    /* renamed from: a */
    private static final byte[] f27230a = new byte[]{(byte) 1};
    /* renamed from: b */
    private static final Hashtable f27231b = new Hashtable();
    /* renamed from: c */
    private Digest f27232c;
    /* renamed from: d */
    private byte[] f27233d;
    /* renamed from: e */
    private byte[] f27234e;
    /* renamed from: f */
    private long f27235f;
    /* renamed from: g */
    private EntropySource f27236g;
    /* renamed from: h */
    private int f27237h;
    /* renamed from: i */
    private int f27238i;

    static {
        f27231b.put("SHA-1", Integers.m29396a(440));
        f27231b.put("SHA-224", Integers.m29396a(440));
        f27231b.put("SHA-256", Integers.m29396a(440));
        f27231b.put("SHA-512/256", Integers.m29396a(440));
        f27231b.put("SHA-512/224", Integers.m29396a(440));
        f27231b.put("SHA-384", Integers.m29396a(888));
        f27231b.put("SHA-512", Integers.m29396a(888));
    }

    public HashSP800DRBG(Digest digest, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > Utils.m27524a(digest)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.mo5789b() >= i) {
            this.f27232c = digest;
            this.f27236g = entropySource;
            this.f27237h = i;
            this.f27238i = ((Integer) f27231b.get(digest.mo5729a())).intValue();
            this.f27233d = Utils.m27527a(this.f27232c, Arrays.m29362a(m35763a(), bArr2, bArr), this.f27238i);
            digest = new byte[(this.f27233d.length + 1)];
            System.arraycopy(this.f27233d, null, digest, 1, this.f27233d.length);
            this.f27234e = Utils.m27527a(this.f27232c, digest, this.f27238i);
            this.f27235f = 1;
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    /* renamed from: a */
    public int mo5793a(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.f27235f > 140737488355328L) {
            return -1;
        } else {
            Object obj;
            if (z) {
                mo5794a(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                obj = new byte[((this.f27233d.length + 1) + bArr2.length)];
                obj[0] = 2;
                System.arraycopy(this.f27233d, 0, obj, 1, this.f27233d.length);
                System.arraycopy(bArr2, 0, obj, this.f27233d.length + 1, bArr2.length);
                m35762a(this.f27233d, m35766b(obj));
            }
            bArr2 = m35764a(this.f27233d, length);
            obj = new byte[(this.f27233d.length + 1)];
            System.arraycopy(this.f27233d, 0, obj, 1, this.f27233d.length);
            obj[0] = 3;
            m35762a(this.f27233d, m35766b(obj));
            m35762a(this.f27233d, this.f27234e);
            m35762a(this.f27233d, new byte[]{(byte) ((int) (this.f27235f >> 24)), (byte) ((int) (this.f27235f >> 16)), (byte) ((int) (this.f27235f >> 8)), (byte) ((int) this.f27235f)});
            this.f27235f++;
            System.arraycopy(bArr2, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    /* renamed from: a */
    private byte[] m35763a() {
        byte[] a = this.f27236g.mo5788a();
        if (a.length >= (this.f27237h + 7) / 8) {
            return a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    /* renamed from: a */
    private void m35762a(byte[] bArr, byte[] bArr2) {
        int i;
        int i2 = 0;
        for (i = 1; i <= bArr2.length; i++) {
            int i3 = ((bArr[bArr.length - i] & JfifUtil.MARKER_FIRST_BYTE) + (bArr2[bArr2.length - i] & JfifUtil.MARKER_FIRST_BYTE)) + i2;
            i2 = i3 > JfifUtil.MARKER_FIRST_BYTE ? 1 : 0;
            bArr[bArr.length - i] = (byte) i3;
        }
        for (bArr2 = bArr2.length + 1; bArr2 <= bArr.length; bArr2++) {
            i = (bArr[bArr.length - bArr2] & JfifUtil.MARKER_FIRST_BYTE) + i2;
            i2 = i > JfifUtil.MARKER_FIRST_BYTE ? 1 : 0;
            bArr[bArr.length - bArr2] = (byte) i;
        }
    }

    /* renamed from: a */
    public void mo5794a(byte[] bArr) {
        this.f27233d = Utils.m27527a(this.f27232c, Arrays.m29363a(f27230a, this.f27233d, m35763a(), bArr), this.f27238i);
        bArr = new byte[(this.f27233d.length + 1)];
        bArr[0] = (byte) 0;
        System.arraycopy(this.f27233d, 0, bArr, 1, this.f27233d.length);
        this.f27234e = Utils.m27527a(this.f27232c, bArr, this.f27238i);
        this.f27235f = 1;
    }

    /* renamed from: b */
    private byte[] m35766b(byte[] bArr) {
        byte[] bArr2 = new byte[this.f27232c.mo5732b()];
        m35765b(bArr, bArr2);
        return bArr2;
    }

    /* renamed from: b */
    private void m35765b(byte[] bArr, byte[] bArr2) {
        this.f27232c.mo5731a(bArr, 0, bArr.length);
        this.f27232c.mo5728a(bArr2, 0);
    }

    /* renamed from: a */
    private byte[] m35764a(byte[] bArr, int i) {
        i /= 8;
        int b = i / this.f27232c.mo5732b();
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr = new byte[i];
        i = new byte[this.f27232c.mo5732b()];
        for (int i2 = 0; i2 <= b; i2++) {
            m35765b(bArr2, i);
            System.arraycopy(i, 0, bArr, i.length * i2, bArr.length - (i.length * i2) > i.length ? i.length : bArr.length - (i.length * i2));
            m35762a(bArr2, f27230a);
        }
        return bArr;
    }
}
