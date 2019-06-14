package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class HMacDSAKCalculator implements DSAKCalculator {
    /* renamed from: a */
    private static final BigInteger f27261a = BigInteger.valueOf(0);
    /* renamed from: b */
    private final HMac f27262b;
    /* renamed from: c */
    private final byte[] f27263c = new byte[this.f27262b.mo5766b()];
    /* renamed from: d */
    private final byte[] f27264d = new byte[this.f27262b.mo5766b()];
    /* renamed from: e */
    private BigInteger f27265e;

    /* renamed from: a */
    public boolean mo5805a() {
        return true;
    }

    public HMacDSAKCalculator(Digest digest) {
        this.f27262b = new HMac(digest);
    }

    /* renamed from: a */
    public void mo5804a(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    /* renamed from: a */
    public void mo5803a(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f27265e = bigInteger;
        Arrays.m29351a(this.f27264d, (byte) 1);
        Arrays.m29351a(this.f27263c, (byte) 0);
        byte[] bArr2 = new byte[((bigInteger.bitLength() + 7) / 8)];
        bigInteger2 = BigIntegers.m29389a(bigInteger2);
        System.arraycopy(bigInteger2, 0, bArr2, bArr2.length - bigInteger2.length, bigInteger2.length);
        byte[] bArr3 = new byte[((bigInteger.bitLength() + 7) / 8)];
        bArr = m35812a(bArr);
        if (bArr.compareTo(bigInteger) >= 0) {
            bArr = bArr.subtract(bigInteger);
        }
        bigInteger = BigIntegers.m29389a(bArr);
        System.arraycopy(bigInteger, 0, bArr3, bArr3.length - bigInteger.length, bigInteger.length);
        this.f27262b.mo5764a(new KeyParameter(this.f27263c));
        this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
        this.f27262b.mo5763a((byte) 0);
        this.f27262b.mo5765a(bArr2, 0, bArr2.length);
        this.f27262b.mo5765a(bArr3, 0, bArr3.length);
        this.f27262b.mo5761a(this.f27263c, 0);
        this.f27262b.mo5764a(new KeyParameter(this.f27263c));
        this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
        this.f27262b.mo5761a(this.f27264d, 0);
        this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
        this.f27262b.mo5763a((byte) 1);
        this.f27262b.mo5765a(bArr2, 0, bArr2.length);
        this.f27262b.mo5765a(bArr3, 0, bArr3.length);
        this.f27262b.mo5761a(this.f27263c, 0);
        this.f27262b.mo5764a(new KeyParameter(this.f27263c));
        this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
        this.f27262b.mo5761a(this.f27264d, 0);
    }

    /* renamed from: b */
    public BigInteger mo5806b() {
        Object obj = new byte[((this.f27265e.bitLength() + 7) / 8)];
        while (true) {
            int i = 0;
            while (i < obj.length) {
                this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
                this.f27262b.mo5761a(this.f27264d, 0);
                int min = Math.min(obj.length - i, this.f27264d.length);
                System.arraycopy(this.f27264d, 0, obj, i, min);
                i += min;
            }
            BigInteger a = m35812a(obj);
            if (a.compareTo(f27261a) > 0 && a.compareTo(this.f27265e) < 0) {
                return a;
            }
            this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
            this.f27262b.mo5763a((byte) 0);
            this.f27262b.mo5761a(this.f27263c, 0);
            this.f27262b.mo5764a(new KeyParameter(this.f27263c));
            this.f27262b.mo5765a(this.f27264d, 0, this.f27264d.length);
            this.f27262b.mo5761a(this.f27264d, 0);
        }
    }

    /* renamed from: a */
    private BigInteger m35812a(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return bArr.length * 8 > this.f27265e.bitLength() ? bigInteger.shiftRight((bArr.length * 8) - this.f27265e.bitLength()) : bigInteger;
    }
}
