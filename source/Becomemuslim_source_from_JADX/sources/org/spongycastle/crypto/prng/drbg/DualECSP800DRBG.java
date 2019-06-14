package org.spongycastle.crypto.prng.drbg;

import com.facebook.imageutils.JfifUtil;
import java.math.BigInteger;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.math.ec.ECCurve.Fp;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class DualECSP800DRBG implements SP80090DRBG {
    /* renamed from: a */
    private static final BigInteger f27200a = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
    /* renamed from: b */
    private static final BigInteger f27201b = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
    /* renamed from: c */
    private static final BigInteger f27202c = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
    /* renamed from: d */
    private static final BigInteger f27203d = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
    /* renamed from: e */
    private static final BigInteger f27204e = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
    /* renamed from: f */
    private static final BigInteger f27205f = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
    /* renamed from: g */
    private static final BigInteger f27206g = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
    /* renamed from: h */
    private static final BigInteger f27207h = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
    /* renamed from: i */
    private static final BigInteger f27208i = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
    /* renamed from: j */
    private static final BigInteger f27209j = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
    /* renamed from: k */
    private static final BigInteger f27210k = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
    /* renamed from: l */
    private static final BigInteger f27211l = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
    /* renamed from: m */
    private static final DualECPoints[] f27212m = new DualECPoints[3];
    /* renamed from: n */
    private Digest f27213n;
    /* renamed from: o */
    private long f27214o;
    /* renamed from: p */
    private EntropySource f27215p;
    /* renamed from: q */
    private int f27216q;
    /* renamed from: r */
    private int f27217r;
    /* renamed from: s */
    private int f27218s;
    /* renamed from: t */
    private ECPoint f27219t;
    /* renamed from: u */
    private ECPoint f27220u;
    /* renamed from: v */
    private byte[] f27221v;
    /* renamed from: w */
    private int f27222w;
    /* renamed from: x */
    private ECMultiplier f27223x;

    static {
        Fp fp = (Fp) NISTNamedCurves.m27187a("P-256").m40516a();
        f27212m[0] = new DualECPoints(128, fp.m28376b(f27200a, f27201b), fp.m28376b(f27202c, f27203d), 1);
        fp = (Fp) NISTNamedCurves.m27187a("P-384").m40516a();
        f27212m[1] = new DualECPoints(JfifUtil.MARKER_SOFn, fp.m28376b(f27204e, f27205f), fp.m28376b(f27206g, f27207h), 1);
        fp = (Fp) NISTNamedCurves.m27187a("P-521").m40516a();
        f27212m[2] = new DualECPoints(256, fp.m28376b(f27208i, f27209j), fp.m28376b(f27210k, f27211l), 1);
    }

    public DualECSP800DRBG(Digest digest, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this(f27212m, digest, i, entropySource, bArr, bArr2);
    }

    public DualECSP800DRBG(DualECPoints[] dualECPointsArr, Digest digest, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this.f27223x = new FixedPointCombMultiplier();
        this.f27213n = digest;
        this.f27215p = entropySource;
        this.f27216q = i;
        if (Utils.m27526a(bArr, 512)) {
            throw new IllegalArgumentException("Personalization string too large");
        } else if (entropySource.mo5789b() < i || entropySource.mo5789b() > 4096) {
            digest = new StringBuilder();
            digest.append("EntropySource must provide between ");
            digest.append(i);
            digest.append(" and ");
            digest.append(4096);
            digest.append(" bits");
            throw new IllegalArgumentException(digest.toString());
        } else {
            entropySource = Arrays.m29362a(m35752a(), bArr2, bArr);
            bArr = null;
            while (bArr != dualECPointsArr.length) {
                if (i > dualECPointsArr[bArr].m27521e()) {
                    bArr++;
                } else if (Utils.m27524a(digest) >= dualECPointsArr[bArr].m27521e()) {
                    this.f27217r = dualECPointsArr[bArr].m27517a();
                    this.f27218s = dualECPointsArr[bArr].m27518b() / 8;
                    this.f27219t = dualECPointsArr[bArr].m27519c();
                    this.f27220u = dualECPointsArr[bArr].m27520d();
                    if (this.f27219t == null) {
                        this.f27221v = Utils.m27527a(this.f27213n, entropySource, this.f27217r);
                        this.f27222w = this.f27221v.length;
                        this.f27214o = null;
                    }
                    throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
                } else {
                    throw new IllegalArgumentException("Requested security strength is not supported by digest");
                }
            }
            if (this.f27219t == null) {
                throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
            }
            this.f27221v = Utils.m27527a(this.f27213n, entropySource, this.f27217r);
            this.f27222w = this.f27221v.length;
            this.f27214o = null;
        }
    }

    /* renamed from: a */
    public int mo5793a(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        boolean length2 = bArr.length / this.f27218s;
        if (Utils.m27526a(bArr2, 512)) {
            throw new IllegalArgumentException("Additional input too large");
        } else if (this.f27214o + ((long) length2) > 2147483648L) {
            return -1;
        } else {
            BigInteger bigInteger;
            if (z) {
                mo5794a(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                bigInteger = new BigInteger(1, m35754a(this.f27221v, Utils.m27527a(this.f27213n, bArr2, this.f27217r)));
            } else {
                bigInteger = new BigInteger(1, this.f27221v);
            }
            Arrays.m29351a(bArr, (byte) 0);
            boolean z2 = false;
            for (z = false; z < length2; z++) {
                bigInteger = m35751a(this.f27219t, bigInteger);
                Object toByteArray = m35751a(this.f27220u, bigInteger).toByteArray();
                if (toByteArray.length > this.f27218s) {
                    System.arraycopy(toByteArray, toByteArray.length - this.f27218s, bArr, z2, this.f27218s);
                } else {
                    System.arraycopy(toByteArray, 0, bArr, (this.f27218s - toByteArray.length) + z2, toByteArray.length);
                }
                z2 += this.f27218s;
                this.f27214o++;
            }
            if (z2 < bArr.length) {
                bigInteger = m35751a(this.f27219t, bigInteger);
                z = m35751a(this.f27220u, bigInteger).toByteArray();
                int length3 = bArr.length - z2;
                if (z.length > this.f27218s) {
                    System.arraycopy(z, z.length - this.f27218s, bArr, z2, length3);
                } else {
                    System.arraycopy(z, 0, bArr, z2 + (this.f27218s - z.length), length3);
                }
                this.f27214o += 1;
            }
            this.f27221v = BigIntegers.m29388a(this.f27222w, m35751a(this.f27219t, bigInteger));
            return length;
        }
    }

    /* renamed from: a */
    public void mo5794a(byte[] bArr) {
        if (Utils.m27526a(bArr, 512)) {
            throw new IllegalArgumentException("Additional input string too large");
        }
        this.f27221v = Utils.m27527a(this.f27213n, Arrays.m29362a(m35753a(this.f27221v, this.f27217r), m35752a(), bArr), this.f27217r);
        this.f27214o = 0;
    }

    /* renamed from: a */
    private byte[] m35752a() {
        byte[] a = this.f27215p.mo5788a();
        if (a.length >= (this.f27216q + 7) / 8) {
            return a;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    /* renamed from: a */
    private byte[] m35754a(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i != bArr3.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: a */
    private byte[] m35753a(byte[] bArr, int i) {
        i %= 8;
        if (i == 0) {
            return bArr;
        }
        i = 8 - i;
        int i2 = 0;
        int length = bArr.length - 1;
        while (length >= 0) {
            int i3 = bArr[length] & JfifUtil.MARKER_FIRST_BYTE;
            bArr[length] = (byte) ((i2 >> (8 - i)) | (i3 << i));
            length--;
            i2 = i3;
        }
        return bArr;
    }

    /* renamed from: a */
    private BigInteger m35751a(ECPoint eCPoint, BigInteger bigInteger) {
        return this.f27223x.mo5901a(eCPoint, bigInteger).m28418p().m28409g().mo6549a();
    }
}
