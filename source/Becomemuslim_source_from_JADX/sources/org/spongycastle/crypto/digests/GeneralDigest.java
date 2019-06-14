package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    /* renamed from: a */
    private final byte[] f31581a;
    /* renamed from: b */
    private int f31582b;
    /* renamed from: c */
    private long f31583c;

    /* renamed from: a */
    protected abstract void mo6793a(long j);

    /* renamed from: b */
    protected abstract void mo6794b(byte[] bArr, int i);

    /* renamed from: d */
    public int mo6445d() {
        return 64;
    }

    /* renamed from: g */
    protected abstract void mo6795g();

    protected GeneralDigest() {
        this.f31581a = new byte[4];
        this.f31582b = 0;
    }

    protected GeneralDigest(GeneralDigest generalDigest) {
        this.f31581a = new byte[4];
        m40566a(generalDigest);
    }

    /* renamed from: a */
    protected void m40566a(GeneralDigest generalDigest) {
        System.arraycopy(generalDigest.f31581a, 0, this.f31581a, 0, generalDigest.f31581a.length);
        this.f31582b = generalDigest.f31582b;
        this.f31583c = generalDigest.f31583c;
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        byte[] bArr = this.f31581a;
        int i = this.f31582b;
        this.f31582b = i + 1;
        bArr[i] = b;
        if (this.f31582b == this.f31581a.length) {
            mo6794b(this.f31581a, 0);
            this.f31582b = 0;
        }
        this.f31583c++;
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        while (this.f31582b != 0 && i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.f31581a.length) {
            mo6794b(bArr, i);
            i += this.f31581a.length;
            i2 -= this.f31581a.length;
            this.f31583c += (long) this.f31581a.length;
        }
        while (i2 > 0) {
            mo5730a(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: f */
    public void m40571f() {
        long j = this.f31583c << 3;
        mo5730a(Byte.MIN_VALUE);
        while (this.f31582b != 0) {
            mo5730a((byte) 0);
        }
        mo6793a(j);
        mo6795g();
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f31583c = 0;
        this.f31582b = 0;
        for (int i = 0; i < this.f31581a.length; i++) {
            this.f31581a[i] = (byte) 0;
        }
    }
}
