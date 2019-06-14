package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class SerpentEngine implements BlockCipher {
    /* renamed from: a */
    private boolean f26779a;
    /* renamed from: b */
    private int[] f26780b;
    /* renamed from: c */
    private int f26781c;
    /* renamed from: d */
    private int f26782d;
    /* renamed from: e */
    private int f26783e;
    /* renamed from: f */
    private int f26784f;

    /* renamed from: a */
    private int m35195a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: b */
    private int m35200b(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "Serpent";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26779a = z;
            this.f26780b = m35199a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to Serpent init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public final int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26780b == null) {
            throw new IllegalStateException("Serpent not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            if (this.f26779a) {
                m35202b(bArr, i, bArr2, i2);
            } else {
                m35204c(bArr, i, bArr2, i2);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private int[] m35199a(byte[] bArr) {
        Object obj = new int[16];
        int length = bArr.length - 4;
        int i = 0;
        while (length > 0) {
            int i2 = i + 1;
            obj[i] = m35196a(bArr, length);
            length -= 4;
            i = i2;
        }
        if (length == 0) {
            length = i + 1;
            obj[i] = m35196a(bArr, 0);
            if (length < 8) {
                obj[length] = 1;
            }
            Object obj2 = new int[132];
            for (int i3 = 8; i3 < 16; i3++) {
                int i4 = i3 - 8;
                obj[i3] = m35195a((-1640531527 ^ (((obj[i4] ^ obj[i3 - 5]) ^ obj[i3 - 3]) ^ obj[i3 - 1])) ^ i4, 11);
            }
            System.arraycopy(obj, 8, obj2, 0, 8);
            for (int i5 = 8; i5 < 132; i5++) {
                obj2[i5] = m35195a(((((obj2[i5 - 8] ^ obj2[i5 - 5]) ^ obj2[i5 - 3]) ^ obj2[i5 - 1]) ^ -1640531527) ^ i5, 11);
            }
            m35210g(obj2[0], obj2[1], obj2[2], obj2[3]);
            obj2[0] = this.f26781c;
            obj2[1] = this.f26782d;
            obj2[2] = this.f26783e;
            obj2[3] = this.f26784f;
            m35208e(obj2[4], obj2[5], obj2[6], obj2[7]);
            obj2[4] = this.f26781c;
            obj2[5] = this.f26782d;
            obj2[6] = this.f26783e;
            obj2[7] = this.f26784f;
            m35203c(obj2[8], obj2[9], obj2[10], obj2[11]);
            obj2[8] = this.f26781c;
            obj2[9] = this.f26782d;
            obj2[10] = this.f26783e;
            obj2[11] = this.f26784f;
            m35197a(obj2[12], obj2[13], obj2[14], obj2[15]);
            obj2[12] = this.f26781c;
            obj2[13] = this.f26782d;
            obj2[14] = this.f26783e;
            obj2[15] = this.f26784f;
            m35218o(obj2[16], obj2[17], obj2[18], obj2[19]);
            obj2[16] = this.f26781c;
            obj2[17] = this.f26782d;
            obj2[18] = this.f26783e;
            obj2[19] = this.f26784f;
            m35216m(obj2[20], obj2[21], obj2[22], obj2[23]);
            obj2[20] = this.f26781c;
            obj2[21] = this.f26782d;
            obj2[22] = this.f26783e;
            obj2[23] = this.f26784f;
            m35214k(obj2[24], obj2[25], obj2[26], obj2[27]);
            obj2[24] = this.f26781c;
            obj2[25] = this.f26782d;
            obj2[26] = this.f26783e;
            obj2[27] = this.f26784f;
            m35212i(obj2[28], obj2[29], obj2[30], obj2[31]);
            obj2[28] = this.f26781c;
            obj2[29] = this.f26782d;
            obj2[30] = this.f26783e;
            obj2[31] = this.f26784f;
            m35210g(obj2[32], obj2[33], obj2[34], obj2[35]);
            obj2[32] = this.f26781c;
            obj2[33] = this.f26782d;
            obj2[34] = this.f26783e;
            obj2[35] = this.f26784f;
            m35208e(obj2[36], obj2[37], obj2[38], obj2[39]);
            obj2[36] = this.f26781c;
            obj2[37] = this.f26782d;
            obj2[38] = this.f26783e;
            obj2[39] = this.f26784f;
            m35203c(obj2[40], obj2[41], obj2[42], obj2[43]);
            obj2[40] = this.f26781c;
            obj2[41] = this.f26782d;
            obj2[42] = this.f26783e;
            obj2[43] = this.f26784f;
            m35197a(obj2[44], obj2[45], obj2[46], obj2[47]);
            obj2[44] = this.f26781c;
            obj2[45] = this.f26782d;
            obj2[46] = this.f26783e;
            obj2[47] = this.f26784f;
            m35218o(obj2[48], obj2[49], obj2[50], obj2[51]);
            obj2[48] = this.f26781c;
            obj2[49] = this.f26782d;
            obj2[50] = this.f26783e;
            obj2[51] = this.f26784f;
            m35216m(obj2[52], obj2[53], obj2[54], obj2[55]);
            obj2[52] = this.f26781c;
            obj2[53] = this.f26782d;
            obj2[54] = this.f26783e;
            obj2[55] = this.f26784f;
            m35214k(obj2[56], obj2[57], obj2[58], obj2[59]);
            obj2[56] = this.f26781c;
            obj2[57] = this.f26782d;
            obj2[58] = this.f26783e;
            obj2[59] = this.f26784f;
            m35212i(obj2[60], obj2[61], obj2[62], obj2[63]);
            obj2[60] = this.f26781c;
            obj2[61] = this.f26782d;
            obj2[62] = this.f26783e;
            obj2[63] = this.f26784f;
            m35210g(obj2[64], obj2[65], obj2[66], obj2[67]);
            obj2[64] = this.f26781c;
            obj2[65] = this.f26782d;
            obj2[66] = this.f26783e;
            obj2[67] = this.f26784f;
            m35208e(obj2[68], obj2[69], obj2[70], obj2[71]);
            obj2[68] = this.f26781c;
            obj2[69] = this.f26782d;
            obj2[70] = this.f26783e;
            obj2[71] = this.f26784f;
            m35203c(obj2[72], obj2[73], obj2[74], obj2[75]);
            obj2[72] = this.f26781c;
            obj2[73] = this.f26782d;
            obj2[74] = this.f26783e;
            obj2[75] = this.f26784f;
            m35197a(obj2[76], obj2[77], obj2[78], obj2[79]);
            obj2[76] = this.f26781c;
            obj2[77] = this.f26782d;
            obj2[78] = this.f26783e;
            obj2[79] = this.f26784f;
            m35218o(obj2[80], obj2[81], obj2[82], obj2[83]);
            obj2[80] = this.f26781c;
            obj2[81] = this.f26782d;
            obj2[82] = this.f26783e;
            obj2[83] = this.f26784f;
            m35216m(obj2[84], obj2[85], obj2[86], obj2[87]);
            obj2[84] = this.f26781c;
            obj2[85] = this.f26782d;
            obj2[86] = this.f26783e;
            obj2[87] = this.f26784f;
            m35214k(obj2[88], obj2[89], obj2[90], obj2[91]);
            obj2[88] = this.f26781c;
            obj2[89] = this.f26782d;
            obj2[90] = this.f26783e;
            obj2[91] = this.f26784f;
            m35212i(obj2[92], obj2[93], obj2[94], obj2[95]);
            obj2[92] = this.f26781c;
            obj2[93] = this.f26782d;
            obj2[94] = this.f26783e;
            obj2[95] = this.f26784f;
            m35210g(obj2[96], obj2[97], obj2[98], obj2[99]);
            obj2[96] = this.f26781c;
            obj2[97] = this.f26782d;
            obj2[98] = this.f26783e;
            obj2[99] = this.f26784f;
            m35208e(obj2[100], obj2[101], obj2[102], obj2[103]);
            obj2[100] = this.f26781c;
            obj2[101] = this.f26782d;
            obj2[102] = this.f26783e;
            obj2[103] = this.f26784f;
            m35203c(obj2[104], obj2[105], obj2[106], obj2[107]);
            obj2[104] = this.f26781c;
            obj2[105] = this.f26782d;
            obj2[106] = this.f26783e;
            obj2[107] = this.f26784f;
            m35197a(obj2[108], obj2[109], obj2[110], obj2[111]);
            obj2[108] = this.f26781c;
            obj2[109] = this.f26782d;
            obj2[110] = this.f26783e;
            obj2[111] = this.f26784f;
            m35218o(obj2[112], obj2[113], obj2[114], obj2[115]);
            obj2[112] = this.f26781c;
            obj2[113] = this.f26782d;
            obj2[114] = this.f26783e;
            obj2[115] = this.f26784f;
            m35216m(obj2[116], obj2[117], obj2[118], obj2[119]);
            obj2[116] = this.f26781c;
            obj2[117] = this.f26782d;
            obj2[118] = this.f26783e;
            obj2[119] = this.f26784f;
            m35214k(obj2[120], obj2[121], obj2[122], obj2[123]);
            obj2[120] = this.f26781c;
            obj2[121] = this.f26782d;
            obj2[122] = this.f26783e;
            obj2[123] = this.f26784f;
            m35212i(obj2[124], obj2[125], obj2[126], obj2[127]);
            obj2[124] = this.f26781c;
            obj2[125] = this.f26782d;
            obj2[126] = this.f26783e;
            obj2[127] = this.f26784f;
            m35210g(obj2[128], obj2[129], obj2[130], obj2[131]);
            obj2[128] = this.f26781c;
            obj2[129] = this.f26782d;
            obj2[130] = this.f26783e;
            obj2[131] = this.f26784f;
            return obj2;
        }
        throw new IllegalArgumentException("key must be a multiple of 4 bytes");
    }

    /* renamed from: a */
    private int m35196a(byte[] bArr, int i) {
        return (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) | ((((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    private void m35198a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) i;
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2] = (byte) (i >>> 24);
    }

    /* renamed from: b */
    private void m35202b(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.f26784f = m35196a(bArr, i);
        this.f26783e = m35196a(bArr, i + 4);
        this.f26782d = m35196a(bArr, i + 8);
        this.f26781c = m35196a(bArr, i + 12);
        m35197a(this.f26780b[0] ^ this.f26781c, this.f26780b[1] ^ this.f26782d, this.f26780b[2] ^ this.f26783e, this.f26780b[3] ^ this.f26784f);
        m35205d();
        m35203c(this.f26780b[4] ^ this.f26781c, this.f26780b[5] ^ this.f26782d, this.f26780b[6] ^ this.f26783e, this.f26780b[7] ^ this.f26784f);
        m35205d();
        m35208e(this.f26780b[8] ^ this.f26781c, this.f26780b[9] ^ this.f26782d, this.f26780b[10] ^ this.f26783e, this.f26780b[11] ^ this.f26784f);
        m35205d();
        m35210g(this.f26780b[12] ^ this.f26781c, this.f26780b[13] ^ this.f26782d, this.f26780b[14] ^ this.f26783e, this.f26780b[15] ^ this.f26784f);
        m35205d();
        m35212i(this.f26780b[16] ^ this.f26781c, this.f26780b[17] ^ this.f26782d, this.f26780b[18] ^ this.f26783e, this.f26780b[19] ^ this.f26784f);
        m35205d();
        m35214k(this.f26780b[20] ^ this.f26781c, this.f26780b[21] ^ this.f26782d, this.f26780b[22] ^ this.f26783e, this.f26780b[23] ^ this.f26784f);
        m35205d();
        m35216m(this.f26780b[24] ^ this.f26781c, this.f26780b[25] ^ this.f26782d, this.f26780b[26] ^ this.f26783e, this.f26780b[27] ^ this.f26784f);
        m35205d();
        m35218o(this.f26780b[28] ^ this.f26781c, this.f26780b[29] ^ this.f26782d, this.f26780b[30] ^ this.f26783e, this.f26780b[31] ^ this.f26784f);
        m35205d();
        m35197a(this.f26780b[32] ^ this.f26781c, this.f26780b[33] ^ this.f26782d, this.f26780b[34] ^ this.f26783e, this.f26780b[35] ^ this.f26784f);
        m35205d();
        m35203c(this.f26780b[36] ^ this.f26781c, this.f26780b[37] ^ this.f26782d, this.f26780b[38] ^ this.f26783e, this.f26780b[39] ^ this.f26784f);
        m35205d();
        m35208e(this.f26780b[40] ^ this.f26781c, this.f26780b[41] ^ this.f26782d, this.f26780b[42] ^ this.f26783e, this.f26780b[43] ^ this.f26784f);
        m35205d();
        m35210g(this.f26780b[44] ^ this.f26781c, this.f26780b[45] ^ this.f26782d, this.f26780b[46] ^ this.f26783e, this.f26780b[47] ^ this.f26784f);
        m35205d();
        m35212i(this.f26780b[48] ^ this.f26781c, this.f26780b[49] ^ this.f26782d, this.f26780b[50] ^ this.f26783e, this.f26780b[51] ^ this.f26784f);
        m35205d();
        m35214k(this.f26780b[52] ^ this.f26781c, this.f26780b[53] ^ this.f26782d, this.f26780b[54] ^ this.f26783e, this.f26780b[55] ^ this.f26784f);
        m35205d();
        m35216m(this.f26780b[56] ^ this.f26781c, this.f26780b[57] ^ this.f26782d, this.f26780b[58] ^ this.f26783e, this.f26780b[59] ^ this.f26784f);
        m35205d();
        m35218o(this.f26780b[60] ^ this.f26781c, this.f26780b[61] ^ this.f26782d, this.f26780b[62] ^ this.f26783e, this.f26780b[63] ^ this.f26784f);
        m35205d();
        m35197a(this.f26780b[64] ^ this.f26781c, this.f26780b[65] ^ this.f26782d, this.f26780b[66] ^ this.f26783e, this.f26780b[67] ^ this.f26784f);
        m35205d();
        m35203c(this.f26780b[68] ^ this.f26781c, this.f26780b[69] ^ this.f26782d, this.f26780b[70] ^ this.f26783e, this.f26780b[71] ^ this.f26784f);
        m35205d();
        m35208e(this.f26780b[72] ^ this.f26781c, this.f26780b[73] ^ this.f26782d, this.f26780b[74] ^ this.f26783e, this.f26780b[75] ^ this.f26784f);
        m35205d();
        m35210g(this.f26780b[76] ^ this.f26781c, this.f26780b[77] ^ this.f26782d, this.f26780b[78] ^ this.f26783e, this.f26780b[79] ^ this.f26784f);
        m35205d();
        m35212i(this.f26780b[80] ^ this.f26781c, this.f26780b[81] ^ this.f26782d, this.f26780b[82] ^ this.f26783e, this.f26780b[83] ^ this.f26784f);
        m35205d();
        m35214k(this.f26780b[84] ^ this.f26781c, this.f26780b[85] ^ this.f26782d, this.f26780b[86] ^ this.f26783e, this.f26780b[87] ^ this.f26784f);
        m35205d();
        m35216m(this.f26780b[88] ^ this.f26781c, this.f26780b[89] ^ this.f26782d, this.f26780b[90] ^ this.f26783e, this.f26780b[91] ^ this.f26784f);
        m35205d();
        m35218o(this.f26780b[92] ^ this.f26781c, this.f26780b[93] ^ this.f26782d, this.f26780b[94] ^ this.f26783e, this.f26780b[95] ^ this.f26784f);
        m35205d();
        m35197a(this.f26780b[96] ^ this.f26781c, this.f26780b[97] ^ this.f26782d, this.f26780b[98] ^ this.f26783e, this.f26780b[99] ^ this.f26784f);
        m35205d();
        m35203c(this.f26780b[100] ^ this.f26781c, this.f26780b[101] ^ this.f26782d, this.f26780b[102] ^ this.f26783e, this.f26780b[103] ^ this.f26784f);
        m35205d();
        m35208e(this.f26780b[104] ^ this.f26781c, this.f26780b[105] ^ this.f26782d, this.f26780b[106] ^ this.f26783e, this.f26780b[107] ^ this.f26784f);
        m35205d();
        m35210g(this.f26780b[108] ^ this.f26781c, this.f26780b[109] ^ this.f26782d, this.f26780b[110] ^ this.f26783e, this.f26780b[111] ^ this.f26784f);
        m35205d();
        m35212i(this.f26780b[112] ^ this.f26781c, this.f26780b[113] ^ this.f26782d, this.f26780b[114] ^ this.f26783e, this.f26780b[115] ^ this.f26784f);
        m35205d();
        m35214k(this.f26780b[116] ^ this.f26781c, this.f26780b[117] ^ this.f26782d, this.f26780b[118] ^ this.f26783e, this.f26780b[119] ^ this.f26784f);
        m35205d();
        m35216m(this.f26780b[120] ^ this.f26781c, this.f26780b[121] ^ this.f26782d, this.f26780b[122] ^ this.f26783e, this.f26780b[123] ^ this.f26784f);
        m35205d();
        m35218o(this.f26780b[124] ^ this.f26781c, this.f26780b[125] ^ this.f26782d, this.f26780b[126] ^ this.f26783e, this.f26780b[127] ^ this.f26784f);
        m35198a(this.f26780b[131] ^ this.f26784f, bArr2, i2);
        m35198a(this.f26780b[130] ^ this.f26783e, bArr2, i2 + 4);
        m35198a(this.f26780b[129] ^ this.f26782d, bArr2, i2 + 8);
        m35198a(this.f26780b[128] ^ this.f26781c, bArr2, i2 + 12);
    }

    /* renamed from: c */
    private void m35204c(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.f26784f = this.f26780b[131] ^ m35196a(bArr, i);
        this.f26783e = this.f26780b[130] ^ m35196a(bArr, i + 4);
        this.f26782d = this.f26780b[129] ^ m35196a(bArr, i + 8);
        this.f26781c = m35196a(bArr, i + 12) ^ this.f26780b[128];
        m35219p(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[124];
        this.f26782d ^= this.f26780b[125];
        this.f26783e ^= this.f26780b[126];
        this.f26784f ^= this.f26780b[127];
        m35207e();
        m35217n(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[120];
        this.f26782d ^= this.f26780b[121];
        this.f26783e ^= this.f26780b[122];
        this.f26784f ^= this.f26780b[123];
        m35207e();
        m35215l(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[116];
        this.f26782d ^= this.f26780b[117];
        this.f26783e ^= this.f26780b[118];
        this.f26784f ^= this.f26780b[119];
        m35207e();
        m35213j(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[112];
        this.f26782d ^= this.f26780b[113];
        this.f26783e ^= this.f26780b[114];
        this.f26784f ^= this.f26780b[115];
        m35207e();
        m35211h(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[108];
        this.f26782d ^= this.f26780b[109];
        this.f26783e ^= this.f26780b[110];
        this.f26784f ^= this.f26780b[111];
        m35207e();
        m35209f(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[104];
        this.f26782d ^= this.f26780b[105];
        this.f26783e ^= this.f26780b[106];
        this.f26784f ^= this.f26780b[107];
        m35207e();
        m35206d(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[100];
        this.f26782d ^= this.f26780b[101];
        this.f26783e ^= this.f26780b[102];
        this.f26784f ^= this.f26780b[103];
        m35207e();
        m35201b(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[96];
        this.f26782d ^= this.f26780b[97];
        this.f26783e ^= this.f26780b[98];
        this.f26784f ^= this.f26780b[99];
        m35207e();
        m35219p(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[92];
        this.f26782d ^= this.f26780b[93];
        this.f26783e ^= this.f26780b[94];
        this.f26784f ^= this.f26780b[95];
        m35207e();
        m35217n(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[88];
        this.f26782d ^= this.f26780b[89];
        this.f26783e ^= this.f26780b[90];
        this.f26784f ^= this.f26780b[91];
        m35207e();
        m35215l(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[84];
        this.f26782d ^= this.f26780b[85];
        this.f26783e ^= this.f26780b[86];
        this.f26784f ^= this.f26780b[87];
        m35207e();
        m35213j(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[80];
        this.f26782d ^= this.f26780b[81];
        this.f26783e ^= this.f26780b[82];
        this.f26784f ^= this.f26780b[83];
        m35207e();
        m35211h(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[76];
        this.f26782d ^= this.f26780b[77];
        this.f26783e ^= this.f26780b[78];
        this.f26784f ^= this.f26780b[79];
        m35207e();
        m35209f(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[72];
        this.f26782d ^= this.f26780b[73];
        this.f26783e ^= this.f26780b[74];
        this.f26784f ^= this.f26780b[75];
        m35207e();
        m35206d(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[68];
        this.f26782d ^= this.f26780b[69];
        this.f26783e ^= this.f26780b[70];
        this.f26784f ^= this.f26780b[71];
        m35207e();
        m35201b(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[64];
        this.f26782d ^= this.f26780b[65];
        this.f26783e ^= this.f26780b[66];
        this.f26784f ^= this.f26780b[67];
        m35207e();
        m35219p(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[60];
        this.f26782d ^= this.f26780b[61];
        this.f26783e ^= this.f26780b[62];
        this.f26784f ^= this.f26780b[63];
        m35207e();
        m35217n(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[56];
        this.f26782d ^= this.f26780b[57];
        this.f26783e ^= this.f26780b[58];
        this.f26784f ^= this.f26780b[59];
        m35207e();
        m35215l(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[52];
        this.f26782d ^= this.f26780b[53];
        this.f26783e ^= this.f26780b[54];
        this.f26784f ^= this.f26780b[55];
        m35207e();
        m35213j(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[48];
        this.f26782d ^= this.f26780b[49];
        this.f26783e ^= this.f26780b[50];
        this.f26784f ^= this.f26780b[51];
        m35207e();
        m35211h(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[44];
        this.f26782d ^= this.f26780b[45];
        this.f26783e ^= this.f26780b[46];
        this.f26784f ^= this.f26780b[47];
        m35207e();
        m35209f(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[40];
        this.f26782d ^= this.f26780b[41];
        this.f26783e ^= this.f26780b[42];
        this.f26784f ^= this.f26780b[43];
        m35207e();
        m35206d(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[36];
        this.f26782d ^= this.f26780b[37];
        this.f26783e ^= this.f26780b[38];
        this.f26784f ^= this.f26780b[39];
        m35207e();
        m35201b(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[32];
        this.f26782d ^= this.f26780b[33];
        this.f26783e ^= this.f26780b[34];
        this.f26784f ^= this.f26780b[35];
        m35207e();
        m35219p(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[28];
        this.f26782d ^= this.f26780b[29];
        this.f26783e ^= this.f26780b[30];
        this.f26784f ^= this.f26780b[31];
        m35207e();
        m35217n(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[24];
        this.f26782d ^= this.f26780b[25];
        this.f26783e ^= this.f26780b[26];
        this.f26784f ^= this.f26780b[27];
        m35207e();
        m35215l(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[20];
        this.f26782d ^= this.f26780b[21];
        this.f26783e ^= this.f26780b[22];
        this.f26784f ^= this.f26780b[23];
        m35207e();
        m35213j(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[16];
        this.f26782d ^= this.f26780b[17];
        this.f26783e ^= this.f26780b[18];
        this.f26784f ^= this.f26780b[19];
        m35207e();
        m35211h(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[12];
        this.f26782d ^= this.f26780b[13];
        this.f26783e ^= this.f26780b[14];
        this.f26784f ^= this.f26780b[15];
        m35207e();
        m35209f(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[8];
        this.f26782d ^= this.f26780b[9];
        this.f26783e ^= this.f26780b[10];
        this.f26784f ^= this.f26780b[11];
        m35207e();
        m35206d(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        this.f26781c ^= this.f26780b[4];
        this.f26782d ^= this.f26780b[5];
        this.f26783e ^= this.f26780b[6];
        this.f26784f ^= this.f26780b[7];
        m35207e();
        m35201b(this.f26781c, this.f26782d, this.f26783e, this.f26784f);
        m35198a(this.f26784f ^ this.f26780b[3], bArr2, i2);
        m35198a(this.f26783e ^ this.f26780b[2], bArr2, i2 + 4);
        m35198a(this.f26782d ^ this.f26780b[1], bArr2, i2 + 8);
        m35198a(this.f26781c ^ this.f26780b[0], bArr2, i2 + 12);
    }

    /* renamed from: a */
    private void m35197a(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ i5;
        int i7 = i2 ^ i6;
        this.f26784f = (i4 & i) ^ i7;
        i ^= i2 & i5;
        this.f26783e = (i3 | i) ^ i7;
        i2 = this.f26784f & (i6 ^ i);
        this.f26782d = (~i6) ^ i2;
        this.f26781c = (~i) ^ i2;
    }

    /* renamed from: b */
    private void m35201b(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        i2 ^= i;
        int i6 = (i5 | i2) ^ i4;
        i3 ^= i6;
        this.f26783e = i2 ^ i3;
        i2 = (i2 & i4) ^ i5;
        this.f26782d = (this.f26783e & i2) ^ i6;
        this.f26784f = (i & i6) ^ (this.f26782d | i3);
        this.f26781c = this.f26784f ^ (i2 ^ i3);
    }

    /* renamed from: c */
    private void m35203c(int i, int i2, int i3, int i4) {
        int i5 = (~i) ^ i2;
        i = (i | i5) ^ i3;
        this.f26783e = i4 ^ i;
        i2 ^= i4 | i5;
        i3 = this.f26783e ^ i5;
        this.f26784f = (i & i2) ^ i3;
        i2 ^= i;
        this.f26782d = this.f26784f ^ i2;
        this.f26781c = i ^ (i2 & i3);
    }

    /* renamed from: d */
    private void m35206d(int i, int i2, int i3, int i4) {
        i4 ^= i2;
        i ^= i2 & i4;
        int i5 = i4 ^ i;
        this.f26784f = i3 ^ i5;
        i2 ^= i4 & i;
        this.f26782d = i ^ (this.f26784f | i2);
        i = ~this.f26782d;
        i2 ^= this.f26784f;
        this.f26781c = i ^ i2;
        this.f26783e = (i | i2) ^ i5;
    }

    /* renamed from: e */
    private void m35208e(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i4;
        this.f26781c = (i3 & i5) ^ i6;
        int i7 = i3 ^ i5;
        i2 &= i3 ^ this.f26781c;
        this.f26784f = i7 ^ i2;
        this.f26783e = i ^ ((i2 | i4) & (this.f26781c | i7));
        this.f26782d = (this.f26784f ^ i6) ^ (this.f26783e ^ (i4 | i5));
    }

    /* renamed from: f */
    private void m35209f(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i4;
        int i6 = ~i5;
        int i7 = i ^ i3;
        i3 ^= i5;
        this.f26781c = (i2 & i3) ^ i7;
        this.f26784f = (((i | i6) ^ i4) | i7) ^ i5;
        i = ~i3;
        i2 = this.f26781c | this.f26784f;
        this.f26782d = i ^ i2;
        this.f26783e = (i & i4) ^ (i2 ^ i7);
    }

    /* renamed from: g */
    private void m35210g(int i, int i2, int i3, int i4) {
        int i5 = i ^ i2;
        int i6 = i & i3;
        i |= i4;
        i3 ^= i4;
        i6 |= i5 & i;
        this.f26783e = i3 ^ i6;
        i = (i ^ i2) ^ i6;
        this.f26781c = i5 ^ (i3 & i);
        i5 = this.f26783e & this.f26781c;
        this.f26782d = i ^ i5;
        this.f26784f = (i2 | i4) ^ (i3 ^ i5);
    }

    /* renamed from: h */
    private void m35211h(int i, int i2, int i3, int i4) {
        int i5 = i | i2;
        int i6 = i2 ^ i3;
        i ^= i2 & i6;
        i2 = i3 ^ i;
        i3 = i4 | i;
        this.f26781c = i6 ^ i3;
        i3 = (i3 | i6) ^ i4;
        this.f26783e = i2 ^ i3;
        i2 = i5 ^ i3;
        this.f26784f = i ^ (this.f26781c & i2);
        this.f26782d = this.f26784f ^ (i2 ^ this.f26781c);
    }

    /* renamed from: i */
    private void m35212i(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        i3 ^= i4 & i5;
        i4 = i2 | i3;
        this.f26784f = i5 ^ i4;
        i2 = ~i2;
        this.f26781c = (i5 | i2) ^ i3;
        i2 ^= i5;
        this.f26783e = (i4 & i2) ^ (this.f26781c & i);
        this.f26782d = (i ^ i3) ^ (i2 & this.f26783e);
    }

    /* renamed from: j */
    private void m35213j(int i, int i2, int i3, int i4) {
        i2 ^= (i3 | i4) & i;
        i3 ^= i & i2;
        this.f26782d = i4 ^ i3;
        i = ~i;
        this.f26784f = (i3 & this.f26782d) ^ i2;
        i3 = (this.f26782d | i) ^ i4;
        this.f26781c = this.f26784f ^ i3;
        this.f26783e = (i ^ this.f26782d) ^ (i2 & i3);
    }

    /* renamed from: k */
    private void m35214k(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        i ^= i4;
        this.f26781c = (i3 ^ i5) ^ (i6 | i);
        i3 = this.f26781c & i4;
        this.f26782d = (this.f26781c ^ i6) ^ i3;
        i ^= this.f26781c | i5;
        this.f26783e = (i6 | i3) ^ i;
        this.f26784f = (i & this.f26782d) ^ (i2 ^ i3);
    }

    /* renamed from: l */
    private void m35215l(int i, int i2, int i3, int i4) {
        int i5 = ~i3;
        int i6 = (i2 & i5) ^ i4;
        int i7 = i & i6;
        this.f26784f = (i2 ^ i5) ^ i7;
        int i8 = this.f26784f | i2;
        this.f26782d = i6 ^ (i & i8);
        i4 |= i;
        this.f26781c = (i5 ^ i8) ^ i4;
        this.f26783e = ((i ^ i3) | i7) ^ (i2 & i4);
    }

    /* renamed from: m */
    private void m35216m(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        i ^= i4;
        int i6 = i2 ^ i;
        i3 ^= i5 | i;
        this.f26782d = i2 ^ i3;
        i = (i | this.f26782d) ^ i4;
        this.f26783e = (i3 & i) ^ i6;
        i ^= i3;
        this.f26781c = this.f26783e ^ i;
        this.f26784f = (i & i6) ^ (~i3);
    }

    /* renamed from: n */
    private void m35217n(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        i ^= i2;
        int i6 = i3 ^ i;
        i3 = (i3 | i5) ^ i4;
        this.f26782d = i6 ^ i3;
        i ^= i6 & i3;
        this.f26784f = i3 ^ (i2 | i);
        i2 |= this.f26784f;
        this.f26781c = i ^ i2;
        this.f26783e = (i4 & i5) ^ (i2 ^ i6);
    }

    /* renamed from: o */
    private void m35218o(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i3;
        i3 = (i3 & i5) ^ i4;
        int i6 = i ^ i3;
        this.f26782d = i2 ^ ((i4 | i5) & i6);
        i2 = this.f26782d | i3;
        this.f26784f = (i & i6) ^ i5;
        i = i6 ^ i2;
        this.f26783e = (this.f26784f & i) ^ i3;
        this.f26781c = (~i) ^ (this.f26784f & this.f26783e);
    }

    /* renamed from: p */
    private void m35219p(int i, int i2, int i3, int i4) {
        int i5 = (i & i2) | i3;
        int i6 = (i | i2) & i4;
        this.f26784f = i5 ^ i6;
        i2 ^= i6;
        this.f26782d = ((this.f26784f ^ (~i4)) | i2) ^ i;
        this.f26781c = (i2 ^ i3) ^ (this.f26782d | i4);
        this.f26783e = ((i & this.f26784f) ^ this.f26781c) ^ (this.f26782d ^ i5);
    }

    /* renamed from: d */
    private void m35205d() {
        int a = m35195a(this.f26781c, 13);
        int a2 = m35195a(this.f26783e, 3);
        int i = (this.f26784f ^ a2) ^ (a << 3);
        this.f26782d = m35195a((this.f26782d ^ a) ^ a2, 1);
        this.f26784f = m35195a(i, 7);
        this.f26781c = m35195a((a ^ this.f26782d) ^ this.f26784f, 5);
        this.f26783e = m35195a((this.f26784f ^ a2) ^ (this.f26782d << 7), 22);
    }

    /* renamed from: e */
    private void m35207e() {
        int b = (m35200b(this.f26783e, 22) ^ this.f26784f) ^ (this.f26782d << 7);
        int b2 = (m35200b(this.f26781c, 5) ^ this.f26782d) ^ this.f26784f;
        int b3 = m35200b(this.f26784f, 7);
        int b4 = m35200b(this.f26782d, 1);
        this.f26784f = (b3 ^ b) ^ (b2 << 3);
        this.f26782d = (b4 ^ b2) ^ b;
        this.f26783e = m35200b(b, 3);
        this.f26781c = m35200b(b2, 13);
    }
}
