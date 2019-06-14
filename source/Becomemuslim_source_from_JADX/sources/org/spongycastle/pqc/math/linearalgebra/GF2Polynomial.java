package org.spongycastle.pqc.math.linearalgebra;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.soloader.MinElf;
import java.util.Random;

public class GF2Polynomial {
    /* renamed from: d */
    private static Random f23364d = new Random();
    /* renamed from: e */
    private static final boolean[] f23365e = new boolean[]{false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    /* renamed from: f */
    private static final short[] f23366f = new short[]{(short) 0, (short) 1, (short) 4, (short) 5, (short) 16, (short) 17, (short) 20, (short) 21, (short) 64, (short) 65, (short) 68, (short) 69, (short) 80, (short) 81, (short) 84, (short) 85, (short) 256, (short) 257, (short) 260, (short) 261, (short) 272, (short) 273, (short) 276, (short) 277, (short) 320, (short) 321, (short) 324, (short) 325, (short) 336, (short) 337, (short) 340, (short) 341, (short) 1024, (short) 1025, (short) 1028, (short) 1029, (short) 1040, (short) 1041, (short) 1044, (short) 1045, (short) 1088, (short) 1089, (short) 1092, (short) 1093, (short) 1104, (short) 1105, (short) 1108, (short) 1109, (short) 1280, (short) 1281, (short) 1284, (short) 1285, (short) 1296, (short) 1297, (short) 1300, (short) 1301, (short) 1344, (short) 1345, (short) 1348, (short) 1349, (short) 1360, (short) 1361, (short) 1364, (short) 1365, (short) 4096, (short) 4097, (short) 4100, (short) 4101, (short) 4112, (short) 4113, (short) 4116, (short) 4117, (short) 4160, (short) 4161, (short) 4164, (short) 4165, (short) 4176, (short) 4177, (short) 4180, (short) 4181, (short) 4352, (short) 4353, (short) 4356, (short) 4357, (short) 4368, (short) 4369, (short) 4372, (short) 4373, (short) 4416, (short) 4417, (short) 4420, (short) 4421, (short) 4432, (short) 4433, (short) 4436, (short) 4437, (short) 5120, (short) 5121, (short) 5124, (short) 5125, (short) 5136, (short) 5137, (short) 5140, (short) 5141, (short) 5184, (short) 5185, (short) 5188, (short) 5189, (short) 5200, (short) 5201, (short) 5204, (short) 5205, (short) 5376, (short) 5377, (short) 5380, (short) 5381, (short) 5392, (short) 5393, (short) 5396, (short) 5397, (short) 5440, (short) 5441, (short) 5444, (short) 5445, (short) 5456, (short) 5457, (short) 5460, (short) 5461, (short) 16384, (short) 16385, (short) 16388, (short) 16389, (short) 16400, (short) 16401, (short) 16404, (short) 16405, (short) 16448, (short) 16449, (short) 16452, (short) 16453, (short) 16464, (short) 16465, (short) 16468, (short) 16469, (short) 16640, (short) 16641, (short) 16644, (short) 16645, (short) 16656, (short) 16657, (short) 16660, (short) 16661, (short) 16704, (short) 16705, (short) 16708, (short) 16709, (short) 16720, (short) 16721, (short) 16724, (short) 16725, (short) 17408, (short) 17409, (short) 17412, (short) 17413, (short) 17424, (short) 17425, (short) 17428, (short) 17429, (short) 17472, (short) 17473, (short) 17476, (short) 17477, (short) 17488, (short) 17489, (short) 17492, (short) 17493, (short) 17664, (short) 17665, (short) 17668, (short) 17669, (short) 17680, (short) 17681, (short) 17684, (short) 17685, (short) 17728, (short) 17729, (short) 17732, (short) 17733, (short) 17744, (short) 17745, (short) 17748, (short) 17749, (short) 20480, (short) 20481, (short) 20484, (short) 20485, (short) 20496, (short) 20497, (short) 20500, (short) 20501, (short) 20544, (short) 20545, (short) 20548, (short) 20549, (short) 20560, (short) 20561, (short) 20564, (short) 20565, (short) 20736, (short) 20737, (short) 20740, (short) 20741, (short) 20752, (short) 20753, (short) 20756, (short) 20757, (short) 20800, (short) 20801, (short) 20804, (short) 20805, (short) 20816, (short) 20817, (short) 20820, (short) 20821, (short) 21504, (short) 21505, (short) 21508, (short) 21509, (short) 21520, (short) 21521, (short) 21524, (short) 21525, (short) 21568, (short) 21569, (short) 21572, (short) 21573, (short) 21584, (short) 21585, (short) 21588, (short) 21589, (short) 21760, (short) 21761, (short) 21764, (short) 21765, (short) 21776, (short) 21777, (short) 21780, (short) 21781, (short) 21824, (short) 21825, (short) 21828, (short) 21829, (short) 21840, (short) 21841, (short) 21844, (short) 21845};
    /* renamed from: g */
    private static final int[] f23367g = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, Utility.DEFAULT_STREAM_BUFFER_SIZE, 16384, 32768, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 131072, 262144, 524288, ByteConstants.MB, 2097152, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, LinearLayoutManager.INVALID_OFFSET, 0};
    /* renamed from: h */
    private static final int[] f23368h = new int[]{0, 1, 3, 7, 15, 31, 63, 127, JfifUtil.MARKER_FIRST_BYTE, 511, 1023, 2047, 4095, 8191, 16383, 32767, MinElf.PN_XNUM, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    /* renamed from: a */
    private int f23369a;
    /* renamed from: b */
    private int f23370b;
    /* renamed from: c */
    private int[] f23371c;

    public GF2Polynomial(int i) {
        if (i < 1) {
            i = 1;
        }
        this.f23370b = ((i - 1) >> 5) + 1;
        this.f23371c = new int[this.f23370b];
        this.f23369a = i;
    }

    public GF2Polynomial(int i, String str) {
        if (i < 1) {
            i = 1;
        }
        this.f23370b = ((i - 1) >> 5) + 1;
        this.f23371c = new int[this.f23370b];
        this.f23369a = i;
        if (str.equalsIgnoreCase("ZERO") != 0) {
            m29198d();
        } else if (str.equalsIgnoreCase("ONE") != 0) {
            m29189a();
        } else if (str.equalsIgnoreCase("RANDOM") != 0) {
            m29202e();
        } else if (str.equalsIgnoreCase("X") != 0) {
            m29192b();
        } else if (str.equalsIgnoreCase("ALL") != 0) {
            m29194c();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error: GF2Polynomial was called using ");
            stringBuilder.append(str);
            stringBuilder.append(" as value!");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public GF2Polynomial(int i, int[] iArr) {
        if (i < 1) {
            i = 1;
        }
        this.f23370b = ((i - 1) >> 5) + 1;
        this.f23371c = new int[this.f23370b];
        this.f23369a = i;
        System.arraycopy(iArr, 0, this.f23371c, 0, Math.min(this.f23370b, iArr.length));
        m29187l();
    }

    public GF2Polynomial(GF2Polynomial gF2Polynomial) {
        this.f23369a = gF2Polynomial.f23369a;
        this.f23370b = gF2Polynomial.f23370b;
        this.f23371c = IntUtils.m29234a(gF2Polynomial.f23371c);
    }

    public Object clone() {
        return new GF2Polynomial(this);
    }

    /* renamed from: a */
    public String m29188a(int i) {
        GF2Polynomial gF2Polynomial = this;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String[] strArr = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String str = new String();
        StringBuilder stringBuilder;
        if (i == 16) {
            for (int i2 = gF2Polynomial.f23370b - 1; i2 >= 0; i2--) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 28) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 24) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 20) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 16) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 12) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 8) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[(gF2Polynomial.f23371c[i2] >>> 4) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cArr[gF2Polynomial.f23371c[i2] & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                str = stringBuilder.toString();
            }
        } else {
            for (int i3 = gF2Polynomial.f23370b - 1; i3 >= 0; i3--) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 28) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 24) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 20) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 16) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 12) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 8) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[(gF2Polynomial.f23371c[i3] >>> 4) & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(strArr[gF2Polynomial.f23371c[i3] & 15]);
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" ");
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    /* renamed from: a */
    public void m29189a() {
        for (int i = 1; i < this.f23370b; i++) {
            this.f23371c[i] = 0;
        }
        this.f23371c[0] = 1;
    }

    /* renamed from: b */
    public void m29192b() {
        for (int i = 1; i < this.f23370b; i++) {
            this.f23371c[i] = 0;
        }
        this.f23371c[0] = 2;
    }

    /* renamed from: c */
    public void m29194c() {
        for (int i = 0; i < this.f23370b; i++) {
            this.f23371c[i] = -1;
        }
        m29187l();
    }

    /* renamed from: d */
    public void m29198d() {
        for (int i = 0; i < this.f23370b; i++) {
            this.f23371c[i] = 0;
        }
    }

    /* renamed from: e */
    public void m29202e() {
        for (int i = 0; i < this.f23370b; i++) {
            this.f23371c[i] = f23364d.nextInt();
        }
        m29187l();
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2Polynomial) {
                GF2Polynomial gF2Polynomial = (GF2Polynomial) obj;
                if (this.f23369a != gF2Polynomial.f23369a) {
                    return false;
                }
                for (int i = 0; i < this.f23370b; i++) {
                    if (this.f23371c[i] != gF2Polynomial.f23371c[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f23369a + this.f23371c.hashCode();
    }

    /* renamed from: f */
    public boolean m29204f() {
        if (this.f23369a == 0) {
            return true;
        }
        for (int i = 0; i < this.f23370b; i++) {
            if (this.f23371c[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public boolean m29206g() {
        for (int i = 1; i < this.f23370b; i++) {
            if (this.f23371c[i] != 0) {
                return false;
            }
        }
        return this.f23371c[0] == 1;
    }

    /* renamed from: a */
    public void m29190a(GF2Polynomial gF2Polynomial) {
        m29193b(gF2Polynomial.f23369a);
        m29205g(gF2Polynomial);
    }

    /* renamed from: b */
    public GF2Polynomial m29191b(GF2Polynomial gF2Polynomial) {
        return m29203f(gF2Polynomial);
    }

    /* renamed from: c */
    public void m29196c(GF2Polynomial gF2Polynomial) {
        m29193b(gF2Polynomial.f23369a);
        m29205g(gF2Polynomial);
    }

    /* renamed from: d */
    public GF2Polynomial m29197d(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        if (gF2Polynomial3.m29204f() == null) {
            gF2Polynomial2.m29208i();
            gF2Polynomial3.m29208i();
            if (gF2Polynomial2.f23369a < gF2Polynomial3.f23369a) {
                return gF2Polynomial2;
            }
            for (int i = gF2Polynomial2.f23369a - gF2Polynomial3.f23369a; i >= null; i = gF2Polynomial2.f23369a - gF2Polynomial3.f23369a) {
                gF2Polynomial2.m29196c(gF2Polynomial3.m29200e(i));
                gF2Polynomial2.m29208i();
            }
            return gF2Polynomial2;
        }
        throw new RuntimeException();
    }

    /* renamed from: e */
    public GF2Polynomial m29201e(GF2Polynomial gF2Polynomial) {
        if (m29204f()) {
            if (gF2Polynomial.m29204f()) {
                throw new ArithmeticException("Both operands of gcd equal zero.");
            }
        }
        if (m29204f()) {
            return new GF2Polynomial(gF2Polynomial);
        }
        if (gF2Polynomial.m29204f()) {
            return new GF2Polynomial(this);
        }
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        gF2Polynomial = gF2Polynomial2;
        gF2Polynomial2 = gF2Polynomial3;
        while (!gF2Polynomial2.m29204f()) {
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            gF2Polynomial2 = gF2Polynomial.m29197d(gF2Polynomial2);
            gF2Polynomial = gF2Polynomial4;
        }
        return gF2Polynomial;
    }

    /* renamed from: h */
    public boolean m29207h() {
        if (m29204f()) {
            return false;
        }
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this);
        gF2Polynomial.m29208i();
        int i = gF2Polynomial.f23369a - 1;
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(gF2Polynomial.f23369a, "X");
        for (int i2 = 1; i2 <= (i >> 1); i2++) {
            gF2Polynomial2.m29209j();
            gF2Polynomial2 = gF2Polynomial2.m29197d(gF2Polynomial);
            GF2Polynomial b = gF2Polynomial2.m29191b(new GF2Polynomial(32, "X"));
            if (b.m29204f() || !gF2Polynomial.m29201e(b).m29206g()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public void m29208i() {
        int i = this.f23370b - 1;
        while (this.f23371c[i] == 0 && i > 0) {
            i--;
        }
        int i2 = this.f23371c[i];
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        this.f23369a = (i << 5) + i3;
        this.f23370b = i + 1;
    }

    /* renamed from: b */
    public void m29193b(int i) {
        if (this.f23369a < i) {
            this.f23369a = i;
            i = ((i - 1) >>> 5) + 1;
            if (this.f23370b < i) {
                if (this.f23371c.length >= i) {
                    for (int i2 = this.f23370b; i2 < i; i2++) {
                        this.f23371c[i2] = 0;
                    }
                    this.f23370b = i;
                    return;
                }
                Object obj = new int[i];
                System.arraycopy(this.f23371c, 0, obj, 0, this.f23370b);
                this.f23370b = i;
                this.f23371c = 0;
                this.f23371c = obj;
            }
        }
    }

    /* renamed from: j */
    public void m29209j() {
        if (!m29204f()) {
            int i;
            if (this.f23371c.length >= (this.f23370b << 1)) {
                for (int i2 = this.f23370b - 1; i2 >= 0; i2--) {
                    i = i2 << 1;
                    this.f23371c[i + 1] = f23366f[(this.f23371c[i2] & 16711680) >>> 16] | (f23366f[(this.f23371c[i2] & -16777216) >>> 24] << 16);
                    this.f23371c[i] = f23366f[this.f23371c[i2] & JfifUtil.MARKER_FIRST_BYTE] | (f23366f[(this.f23371c[i2] & 65280) >>> 8] << 16);
                }
                this.f23370b <<= 1;
                this.f23369a = (this.f23369a << 1) - 1;
            } else {
                int[] iArr = new int[(this.f23370b << 1)];
                for (int i3 = 0; i3 < this.f23370b; i3++) {
                    i = i3 << 1;
                    iArr[i] = f23366f[this.f23371c[i3] & JfifUtil.MARKER_FIRST_BYTE] | (f23366f[(this.f23371c[i3] & 65280) >>> 8] << 16);
                    iArr[i + 1] = f23366f[(this.f23371c[i3] & 16711680) >>> 16] | (f23366f[(this.f23371c[i3] & -16777216) >>> 24] << 16);
                }
                this.f23371c = null;
                this.f23371c = iArr;
                this.f23370b <<= 1;
                this.f23369a = (this.f23369a << 1) - 1;
            }
        }
    }

    /* renamed from: f */
    public GF2Polynomial m29203f(GF2Polynomial gF2Polynomial) {
        GF2Polynomial gF2Polynomial2;
        int min = Math.min(this.f23370b, gF2Polynomial.f23370b);
        int i = 0;
        if (this.f23369a >= gF2Polynomial.f23369a) {
            gF2Polynomial2 = new GF2Polynomial(this);
            while (i < min) {
                int[] iArr = gF2Polynomial2.f23371c;
                iArr[i] = iArr[i] ^ gF2Polynomial.f23371c[i];
                i++;
            }
        } else {
            gF2Polynomial2 = new GF2Polynomial(gF2Polynomial);
            while (i < min) {
                gF2Polynomial = gF2Polynomial2.f23371c;
                gF2Polynomial[i] = gF2Polynomial[i] ^ this.f23371c[i];
                i++;
            }
        }
        gF2Polynomial2.m29187l();
        return gF2Polynomial2;
    }

    /* renamed from: g */
    public void m29205g(GF2Polynomial gF2Polynomial) {
        for (int i = 0; i < Math.min(this.f23370b, gF2Polynomial.f23370b); i++) {
            int[] iArr = this.f23371c;
            iArr[i] = iArr[i] ^ gF2Polynomial.f23371c[i];
        }
        m29187l();
    }

    /* renamed from: l */
    private void m29187l() {
        if ((this.f23369a & 31) != 0) {
            int[] iArr = this.f23371c;
            int i = this.f23370b - 1;
            iArr[i] = iArr[i] & f23368h[this.f23369a & 31];
        }
    }

    /* renamed from: c */
    public void m29195c(int i) {
        if (i < 0 || i > this.f23369a - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.f23371c;
        int i2 = i >>> 5;
        iArr[i2] = f23367g[i & 31] | iArr[i2];
    }

    /* renamed from: d */
    public void m29199d(int i) {
        if (i < 0) {
            throw new RuntimeException();
        } else if (i <= this.f23369a - 1) {
            int[] iArr = this.f23371c;
            int i2 = i >>> 5;
            iArr[i2] = (~f23367g[i & 31]) & iArr[i2];
        }
    }

    /* renamed from: k */
    public GF2Polynomial m29210k() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.f23369a + 1, this.f23371c);
        for (int i = gF2Polynomial.f23370b - 1; i >= 1; i--) {
            int[] iArr = gF2Polynomial.f23371c;
            iArr[i] = iArr[i] << 1;
            iArr = gF2Polynomial.f23371c;
            iArr[i] = iArr[i] | (gF2Polynomial.f23371c[i - 1] >>> 31);
        }
        int[] iArr2 = gF2Polynomial.f23371c;
        iArr2[0] = iArr2[0] << 1;
        return gF2Polynomial;
    }

    /* renamed from: e */
    public GF2Polynomial m29200e(int i) {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.f23369a + i, this.f23371c);
        if (i >= 32) {
            gF2Polynomial.m29186f(i >>> 5);
        }
        i &= 31;
        if (i != 0) {
            for (int i2 = gF2Polynomial.f23370b - 1; i2 >= 1; i2--) {
                int[] iArr = gF2Polynomial.f23371c;
                iArr[i2] = iArr[i2] << i;
                iArr = gF2Polynomial.f23371c;
                iArr[i2] = iArr[i2] | (gF2Polynomial.f23371c[i2 - 1] >>> (32 - i));
            }
            int[] iArr2 = gF2Polynomial.f23371c;
            iArr2[0] = iArr2[0] << i;
        }
        return gF2Polynomial;
    }

    /* renamed from: f */
    private void m29186f(int i) {
        if (this.f23370b <= this.f23371c.length) {
            int i2;
            for (i2 = this.f23370b - 1; i2 >= i; i2--) {
                this.f23371c[i2] = this.f23371c[i2 - i];
            }
            for (i2 = 0; i2 < i; i2++) {
                this.f23371c[i2] = 0;
            }
            return;
        }
        Object obj = new int[this.f23370b];
        System.arraycopy(this.f23371c, 0, obj, i, this.f23370b - i);
        this.f23371c = 0;
        this.f23371c = obj;
    }
}
