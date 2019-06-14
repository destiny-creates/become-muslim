package org.spongycastle.crypto.digests;

import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;

public class SkeinEngine implements Memoable {
    /* renamed from: c */
    private static final Hashtable f26490c = new Hashtable();
    /* renamed from: a */
    final ThreefishEngine f26491a;
    /* renamed from: b */
    long[] f26492b;
    /* renamed from: d */
    private final int f26493d;
    /* renamed from: e */
    private long[] f26494e;
    /* renamed from: f */
    private byte[] f26495f;
    /* renamed from: g */
    private Parameter[] f26496g;
    /* renamed from: h */
    private Parameter[] f26497h;
    /* renamed from: i */
    private final UBI f26498i;
    /* renamed from: j */
    private final byte[] f26499j;

    private static class Configuration {
        /* renamed from: a */
        private byte[] f22262a = new byte[32];

        public Configuration(long j) {
            this.f22262a[0] = (byte) 83;
            this.f22262a[1] = (byte) 72;
            this.f22262a[2] = (byte) 65;
            this.f22262a[3] = (byte) 51;
            this.f22262a[4] = (byte) 1;
            this.f22262a[5] = (byte) 0;
            ThreefishEngine.m35263a(j, this.f22262a, 8);
        }

        /* renamed from: a */
        public byte[] m27384a() {
            return this.f22262a;
        }
    }

    public static class Parameter {
        /* renamed from: a */
        private int f22263a;
        /* renamed from: b */
        private byte[] f22264b;

        public Parameter(int i, byte[] bArr) {
            this.f22263a = i;
            this.f22264b = bArr;
        }

        /* renamed from: a */
        public int m27385a() {
            return this.f22263a;
        }

        /* renamed from: b */
        public byte[] m27386b() {
            return this.f22264b;
        }
    }

    private class UBI {
        /* renamed from: a */
        final /* synthetic */ SkeinEngine f22265a;
        /* renamed from: b */
        private final UbiTweak f22266b = new UbiTweak();
        /* renamed from: c */
        private byte[] f22267c;
        /* renamed from: d */
        private int f22268d;
        /* renamed from: e */
        private long[] f22269e;

        public UBI(SkeinEngine skeinEngine, int i) {
            this.f22265a = skeinEngine;
            this.f22267c = new byte[i];
            this.f22269e = new long[(this.f22267c.length / 8)];
        }

        /* renamed from: a */
        public void m27389a(UBI ubi) {
            this.f22267c = Arrays.m29382c(ubi.f22267c, this.f22267c);
            this.f22268d = ubi.f22268d;
            this.f22269e = Arrays.m29379b(ubi.f22269e, this.f22269e);
            this.f22266b.m27394a(ubi.f22266b);
        }

        /* renamed from: a */
        public void m27388a(int i) {
            this.f22266b.m27392a();
            this.f22266b.m27393a(i);
            this.f22268d = 0;
        }

        /* renamed from: a */
        public void m27390a(byte[] bArr, int i, int i2, long[] jArr) {
            int i3 = 0;
            while (i2 > i3) {
                if (this.f22268d == this.f22267c.length) {
                    m27387b(jArr);
                    this.f22266b.m27395a(false);
                    this.f22268d = 0;
                }
                int min = Math.min(i2 - i3, this.f22267c.length - this.f22268d);
                System.arraycopy(bArr, i + i3, this.f22267c, this.f22268d, min);
                i3 += min;
                this.f22268d += min;
                this.f22266b.m27397b(min);
            }
        }

        /* renamed from: b */
        private void m27387b(long[] jArr) {
            this.f22265a.f26491a.m35275a(true, this.f22265a.f26492b, this.f22266b.m27401e());
            for (int i = 0; i < this.f22269e.length; i++) {
                this.f22269e[i] = ThreefishEngine.m35262a(this.f22267c, i * 8);
            }
            this.f22265a.f26491a.m35272a(this.f22269e, jArr);
            for (int i2 = 0; i2 < jArr.length; i2++) {
                jArr[i2] = jArr[i2] ^ this.f22269e[i2];
            }
        }

        /* renamed from: a */
        public void m27391a(long[] jArr) {
            for (int i = this.f22268d; i < this.f22267c.length; i++) {
                this.f22267c[i] = (byte) 0;
            }
            this.f22266b.m27398b(true);
            m27387b(jArr);
        }
    }

    private static class UbiTweak {
        /* renamed from: a */
        private long[] f22270a = new long[2];
        /* renamed from: b */
        private boolean f22271b;

        public UbiTweak() {
            m27392a();
        }

        /* renamed from: a */
        public void m27394a(UbiTweak ubiTweak) {
            this.f22270a = Arrays.m29379b(ubiTweak.f22270a, this.f22270a);
            this.f22271b = ubiTweak.f22271b;
        }

        /* renamed from: a */
        public void m27392a() {
            this.f22270a[0] = 0;
            this.f22270a[1] = 0;
            this.f22271b = false;
            m27395a(true);
        }

        /* renamed from: a */
        public void m27393a(int i) {
            this.f22270a[1] = (this.f22270a[1] & -274877906944L) | ((((long) i) & 63) << 56);
        }

        /* renamed from: b */
        public int m27396b() {
            return (int) ((this.f22270a[1] >>> 56) & 63);
        }

        /* renamed from: a */
        public void m27395a(boolean z) {
            if (z) {
                z = this.f22270a;
                z[1] = z[1] | 4611686018427387904L;
                return;
            }
            z = this.f22270a;
            z[1] = z[1] & -4611686018427387905L;
        }

        /* renamed from: c */
        public boolean m27399c() {
            return (this.f22270a[1] & 4611686018427387904L) != 0;
        }

        /* renamed from: b */
        public void m27398b(boolean z) {
            if (z) {
                z = this.f22270a;
                z[1] = z[1] | Long.MIN_VALUE;
                return;
            }
            z = this.f22270a;
            z[1] = z[1] & Clock.MAX_TIME;
        }

        /* renamed from: d */
        public boolean m27400d() {
            return (this.f22270a[1] & Long.MIN_VALUE) != 0;
        }

        /* renamed from: b */
        public void m27397b(int i) {
            if (this.f22271b) {
                long[] jArr = new long[]{this.f22270a[0] & 4294967295L, (this.f22270a[0] >>> 32) & 4294967295L, this.f22270a[1] & 4294967295L};
                long j = (long) i;
                for (i = 0; i < jArr.length; i++) {
                    j += jArr[i];
                    jArr[i] = j;
                    j >>>= 32;
                }
                this.f22270a[0] = ((jArr[1] & 4294967295L) << 32) | (jArr[0] & 4294967295L);
                this.f22270a[1] = (this.f22270a[1] & -4294967296L) | (jArr[2] & 4294967295L);
                return;
            }
            long j2 = this.f22270a[0] + ((long) i);
            this.f22270a[0] = j2;
            if (j2 > 9223372034707292160L) {
                this.f22271b = true;
            }
        }

        /* renamed from: e */
        public long[] m27401e() {
            return this.f22270a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(m27396b());
            stringBuilder.append(" first: ");
            stringBuilder.append(m27399c());
            stringBuilder.append(", final: ");
            stringBuilder.append(m27400d());
            return stringBuilder.toString();
        }
    }

    static {
        m34732a(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        m34732a(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        m34732a(256, 224, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        m34732a(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        m34732a(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        m34732a(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        m34732a(512, 224, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        m34732a(512, (int) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        m34732a(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    /* renamed from: a */
    private static void m34732a(int i, int i2, long[] jArr) {
        f26490c.put(m34730a(i / 8, i2 / 8), jArr);
    }

    /* renamed from: a */
    private static Integer m34730a(int i, int i2) {
        return new Integer(i | (i2 << 16));
    }

    public SkeinEngine(int i, int i2) {
        this.f26499j = new byte[1];
        if (i2 % 8 == 0) {
            this.f26493d = i2 / 8;
            this.f26491a = new ThreefishEngine(i);
            this.f26498i = new UBI(this, this.f26491a.mo5743b());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Output size must be a multiple of 8 bits. :");
        stringBuilder.append(i2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public SkeinEngine(SkeinEngine skeinEngine) {
        this(skeinEngine.m34748b() * 8, skeinEngine.m34742a() * 8);
        m34736a(skeinEngine);
    }

    /* renamed from: a */
    private void m34736a(SkeinEngine skeinEngine) {
        this.f26498i.m27389a(skeinEngine.f26498i);
        this.f26492b = Arrays.m29379b(skeinEngine.f26492b, this.f26492b);
        this.f26494e = Arrays.m29379b(skeinEngine.f26494e, this.f26494e);
        this.f26495f = Arrays.m29382c(skeinEngine.f26495f, this.f26495f);
        this.f26496g = m34738a(skeinEngine.f26496g, this.f26496g);
        this.f26497h = m34738a(skeinEngine.f26497h, this.f26497h);
    }

    /* renamed from: a */
    private static Parameter[] m34738a(Parameter[] parameterArr, Parameter[] parameterArr2) {
        if (parameterArr == null) {
            return null;
        }
        if (parameterArr2 == null || parameterArr2.length != parameterArr.length) {
            parameterArr2 = new Parameter[parameterArr.length];
        }
        System.arraycopy(parameterArr, 0, parameterArr2, 0, parameterArr2.length);
        return parameterArr2;
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SkeinEngine(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        SkeinEngine skeinEngine = (SkeinEngine) memoable;
        if (m34748b() == skeinEngine.m34748b() && this.f26493d == skeinEngine.f26493d) {
            m34736a(skeinEngine);
            return;
        }
        throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
    }

    /* renamed from: a */
    public int m34742a() {
        return this.f26493d;
    }

    /* renamed from: b */
    public int m34748b() {
        return this.f26491a.mo5743b();
    }

    /* renamed from: a */
    public void m34745a(SkeinParameters skeinParameters) {
        this.f26492b = null;
        this.f26495f = null;
        this.f26496g = null;
        this.f26497h = null;
        if (skeinParameters != null) {
            if (skeinParameters.m35710b().length >= 16) {
                m34735a(skeinParameters.m35709a());
            } else {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
        }
        m34739d();
        m34731a(48);
    }

    /* renamed from: a */
    private void m34735a(Hashtable hashtable) {
        Enumeration keys = hashtable.keys();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            byte[] bArr = (byte[]) hashtable.get(num);
            if (num.intValue() == 0) {
                this.f26495f = bArr;
            } else if (num.intValue() < 48) {
                vector.addElement(new Parameter(num.intValue(), bArr));
            } else {
                vector2.addElement(new Parameter(num.intValue(), bArr));
            }
        }
        this.f26496g = new Parameter[vector.size()];
        vector.copyInto(this.f26496g);
        m34737a(this.f26496g);
        this.f26497h = new Parameter[vector2.size()];
        vector2.copyInto(this.f26497h);
        m34737a(this.f26497h);
    }

    /* renamed from: a */
    private static void m34737a(Parameter[] parameterArr) {
        if (parameterArr != null) {
            for (int i = 1; i < parameterArr.length; i++) {
                Parameter parameter = parameterArr[i];
                int i2 = i;
                while (i2 > 0) {
                    int i3 = i2 - 1;
                    if (parameter.m27385a() >= parameterArr[i3].m27385a()) {
                        break;
                    }
                    parameterArr[i2] = parameterArr[i3];
                    i2 = i3;
                }
                parameterArr[i2] = parameter;
            }
        }
    }

    /* renamed from: d */
    private void m34739d() {
        long[] jArr = (long[]) f26490c.get(m34730a(m34748b(), m34742a()));
        int i = 0;
        if (this.f26495f != null || jArr == null) {
            this.f26492b = new long[(m34748b() / 8)];
            if (this.f26495f != null) {
                m34733a(0, this.f26495f);
            }
            m34733a(4, new Configuration((long) (this.f26493d * 8)).m27384a());
        } else {
            this.f26492b = Arrays.m29364a(jArr);
        }
        if (this.f26496g != null) {
            while (i < this.f26496g.length) {
                Parameter parameter = this.f26496g[i];
                m34733a(parameter.m27385a(), parameter.m27386b());
                i++;
            }
        }
        this.f26494e = Arrays.m29364a(this.f26492b);
    }

    /* renamed from: c */
    public void m34749c() {
        System.arraycopy(this.f26494e, 0, this.f26492b, 0, this.f26492b.length);
        m34731a(48);
    }

    /* renamed from: a */
    private void m34733a(int i, byte[] bArr) {
        m34731a(i);
        this.f26498i.m27390a(bArr, 0, bArr.length, this.f26492b);
        m34740f();
    }

    /* renamed from: a */
    private void m34731a(int i) {
        this.f26498i.m27388a(i);
    }

    /* renamed from: f */
    private void m34740f() {
        this.f26498i.m27391a(this.f26492b);
    }

    /* renamed from: g */
    private void m34741g() {
        if (this.f26498i == null) {
            throw new IllegalArgumentException("Skein engine is not initialised.");
        }
    }

    /* renamed from: a */
    public void m34744a(byte b) {
        this.f26499j[0] = b;
        m34747a(this.f26499j, 0, 1);
    }

    /* renamed from: a */
    public void m34747a(byte[] bArr, int i, int i2) {
        m34741g();
        this.f26498i.m27390a(bArr, i, i2, this.f26492b);
    }

    /* renamed from: a */
    public int m34743a(byte[] bArr, int i) {
        m34741g();
        if (bArr.length >= this.f26493d + i) {
            m34740f();
            if (this.f26497h != null) {
                for (Parameter parameter : this.f26497h) {
                    m34733a(parameter.m27385a(), parameter.m27386b());
                }
            }
            int b = m34748b();
            int i2 = ((this.f26493d + b) - 1) / b;
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * b;
                m34734a((long) i3, bArr, i + i4, Math.min(b, this.f26493d - i4));
            }
            m34749c();
            return this.f26493d;
        }
        i = new StringBuilder();
        i.append("Output buffer is too short to hold output of ");
        i.append(this.f26493d);
        i.append(" bytes");
        throw new DataLengthException(i.toString());
    }

    /* renamed from: a */
    private void m34734a(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[8];
        ThreefishEngine.m35263a(j, bArr2, 0);
        long[] jArr = new long[this.f26492b.length];
        m34731a(63);
        this.f26498i.m27390a(bArr2, 0, bArr2.length, jArr);
        this.f26498i.m27391a(jArr);
        int i3 = ((i2 + 8) - 1) / 8;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 8;
            int min = Math.min(8, i2 - i5);
            if (min == 8) {
                ThreefishEngine.m35263a(jArr[i4], bArr, i5 + i);
            } else {
                ThreefishEngine.m35263a(jArr[i4], bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i5 + i, min);
            }
        }
    }
}
