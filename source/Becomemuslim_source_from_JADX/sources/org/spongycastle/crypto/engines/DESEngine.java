package org.spongycastle.crypto.engines;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.soloader.MinElf;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class DESEngine implements BlockCipher {
    /* renamed from: b */
    private static final short[] f26599b = new short[]{(short) 128, (short) 64, (short) 32, (short) 16, (short) 8, (short) 4, (short) 2, (short) 1};
    /* renamed from: c */
    private static final int[] f26600c = new int[]{8388608, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 2097152, ByteConstants.MB, 524288, 262144, 131072, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 32768, 16384, Utility.DEFAULT_STREAM_BUFFER_SIZE, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    /* renamed from: d */
    private static final byte[] f26601d = new byte[]{(byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, (byte) 16, (byte) 8, (byte) 0, (byte) 57, Framer.STDOUT_FRAME_PREFIX, (byte) 41, Framer.ENTER_FRAME_PREFIX, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58, Framer.STDERR_FRAME_PREFIX, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61, (byte) 53, Framer.STDIN_FRAME_PREFIX, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28, (byte) 20, (byte) 12, (byte) 4, (byte) 27, (byte) 19, (byte) 11, (byte) 3};
    /* renamed from: e */
    private static final byte[] f26602e = new byte[]{(byte) 1, (byte) 2, (byte) 4, (byte) 6, (byte) 8, (byte) 10, (byte) 12, (byte) 14, (byte) 15, (byte) 17, (byte) 19, (byte) 21, (byte) 23, (byte) 25, (byte) 27, (byte) 28};
    /* renamed from: f */
    private static final byte[] f26603f = new byte[]{(byte) 13, (byte) 16, (byte) 10, (byte) 23, (byte) 0, (byte) 4, (byte) 2, (byte) 27, (byte) 14, (byte) 5, (byte) 20, (byte) 9, (byte) 22, (byte) 18, (byte) 11, (byte) 3, (byte) 25, (byte) 7, (byte) 15, (byte) 6, (byte) 26, (byte) 19, (byte) 12, (byte) 1, (byte) 40, (byte) 51, (byte) 30, (byte) 36, (byte) 46, (byte) 54, (byte) 29, (byte) 39, Framer.STDERR_FRAME_PREFIX, (byte) 44, (byte) 32, (byte) 47, (byte) 43, (byte) 48, (byte) 38, (byte) 55, Framer.ENTER_FRAME_PREFIX, (byte) 52, Framer.STDIN_FRAME_PREFIX, (byte) 41, Framer.STDOUT_FRAME_PREFIX, (byte) 35, (byte) 28, (byte) 31};
    /* renamed from: g */
    private static final int[] f26604g = new int[]{16843776, 0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 16843780, 16842756, 66564, 4, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 1024, 16843776, 16843780, 1024, 16778244, 16842756, 16777216, 4, 1028, 16778240, 16778240, 66560, 66560, 16842752, 16842752, 16778244, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16777220, 16777220, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 0, 1028, 66564, 16777216, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 16843780, 4, 16842752, 16843776, 16777216, 16777216, 1024, 16842756, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 66560, 16777220, 1024, 4, 16778244, 66564, 16843780, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 16842752, 16778244, 16777220, 1028, 66564, 16843776, 1028, 16778240, 16778240, 0, NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST, 66560, 0, 16842756};
    /* renamed from: h */
    private static final int[] f26605h = new int[]{-2146402272, -2147450880, 32768, 1081376, ByteConstants.MB, 32, -2146435040, -2147450848, -2147483616, -2146402272, -2146402304, LinearLayoutManager.INVALID_OFFSET, -2147450880, ByteConstants.MB, 32, -2146435040, 1081344, 1048608, -2147450848, 0, LinearLayoutManager.INVALID_OFFSET, 32768, 1081376, -2146435072, 1048608, -2147483616, 0, 1081344, 32800, -2146402304, -2146435072, 32800, 0, 1081376, -2146435040, ByteConstants.MB, -2147450848, -2146435072, -2146402304, 32768, -2146435072, -2147450880, 32, -2146402272, 1081376, 32, 32768, LinearLayoutManager.INVALID_OFFSET, 32800, -2146402304, ByteConstants.MB, -2147483616, 1048608, -2147450848, -2147483616, 1048608, 1081344, 0, -2147450880, 32800, LinearLayoutManager.INVALID_OFFSET, -2146435040, -2146402272, 1081344};
    /* renamed from: i */
    private static final int[] f26606i = new int[]{520, 134349312, 0, 134348808, 134218240, 0, 131592, 134218240, 131080, 134217736, 134217736, 131072, 134349320, 131080, 134348800, 520, 134217728, 8, 134349312, 512, 131584, 134348800, 134348808, 131592, 134218248, 131584, 131072, 134218248, 8, 134349320, 512, 134217728, 134349312, 134217728, 131080, 520, 131072, 134349312, 134218240, 0, 512, 131080, 134349320, 134218240, 134217736, 512, 0, 134348808, 134218248, 131072, 134217728, 134349320, 8, 131592, 131584, 134217736, 134348800, 134218248, 520, 134348800, 131592, 8, 134348808, 131584};
    /* renamed from: j */
    private static final int[] f26607j = new int[]{8396801, 8321, 8321, 128, 8396928, 8388737, 8388609, 8193, 0, 8396800, 8396800, 8396929, 129, 0, 8388736, 8388609, 1, Utility.DEFAULT_STREAM_BUFFER_SIZE, 8388608, 8396801, 128, 8388608, 8193, 8320, 8388737, 1, 8320, 8388736, Utility.DEFAULT_STREAM_BUFFER_SIZE, 8396928, 8396929, 129, 8388736, 8388609, 8396800, 8396929, 129, 0, 0, 8396800, 8320, 8388736, 8388737, 1, 8396801, 8321, 8321, 128, 8396929, 129, 1, Utility.DEFAULT_STREAM_BUFFER_SIZE, 8388609, 8193, 8396928, 8388737, 8193, 8320, 8388608, 8396801, 128, 8388608, Utility.DEFAULT_STREAM_BUFFER_SIZE, 8396928};
    /* renamed from: k */
    private static final int[] f26608k = new int[]{256, 34078976, 34078720, 1107296512, 524288, 256, 1073741824, 34078720, 1074266368, 524288, 33554688, 1074266368, 1107296512, 1107820544, 524544, 1073741824, 33554432, 1074266112, 1074266112, 0, 1073742080, 1107820800, 1107820800, 33554688, 1107820544, 1073742080, 0, 1107296256, 34078976, 33554432, 1107296256, 524544, 524288, 1107296512, 256, 33554432, 1073741824, 34078720, 1107296512, 1074266368, 33554688, 1073741824, 1107820544, 34078976, 1074266368, 256, 33554432, 1107820544, 1107820800, 524544, 1107296256, 1107820800, 34078720, 0, 1074266112, 1107296256, 524544, 33554688, 1073742080, 524288, 0, 1074266112, 34078976, 1073742080};
    /* renamed from: l */
    private static final int[] f26609l = new int[]{536870928, 541065216, 16384, 541081616, 541065216, 16, 541081616, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 536887296, 4210704, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 536870928, 4194320, 536887296, 536870912, 16400, 0, 4194320, 536887312, 16384, 4210688, 536887312, 16, 541065232, 541065232, 0, 4210704, 541081600, 16400, 4210688, 541081600, 536870912, 536887296, 16, 541065232, 4210688, 541081616, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 16400, 536870928, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 536887296, 536870912, 16400, 536870928, 541081616, 4210688, 541065216, 4210704, 541081600, 0, 541065232, 16, 16384, 541065216, 4210704, 16384, 4194320, 536887312, 0, 541081600, 536870912, 4194320, 536887312};
    /* renamed from: m */
    private static final int[] f26610m = new int[]{2097152, 69206018, 67110914, 0, 2048, 67110914, 2099202, 69208064, 69208066, 2097152, 0, 67108866, 2, 67108864, 69206018, 2050, 67110912, 2099202, 2097154, 67110912, 67108866, 69206016, 69208064, 2097154, 69206016, 2048, 2050, 69208066, 2099200, 2, 67108864, 2099200, 67108864, 2099200, 2097152, 67110914, 67110914, 69206018, 69206018, 2, 2097154, 67108864, 67110912, 2097152, 69208064, 2050, 2099202, 69208064, 2050, 67108866, 69208066, 69206016, 2099200, 0, 2, 69208066, 0, 2099202, 69206016, 2048, 67108866, 67110912, 2048, 2097154};
    /* renamed from: n */
    private static final int[] f26611n = new int[]{268439616, 4096, 262144, 268701760, 268435456, 268439616, 64, 268435456, 262208, 268697600, 268701760, 266240, 268701696, 266304, 4096, 64, 268697600, 268435520, 268439552, 4160, 266240, 262208, 268697664, 268701696, 4160, 0, 0, 268697664, 268435520, 268439552, 266304, 262144, 266304, 262144, 268701696, 4096, 64, 268697664, 4096, 266304, 268439552, 64, 268435520, 268697600, 268697664, 268435456, 262144, 268439616, 0, 268701760, 262208, 268435520, 268697600, 268439552, 268439616, 0, 268701760, 266240, 266240, 4160, 4160, 262208, 268435456, 268701696};
    /* renamed from: a */
    private int[] f26612a = null;

    /* renamed from: a */
    public String mo5741a() {
        return "DES";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            KeyParameter keyParameter = (KeyParameter) cipherParameters;
            if (keyParameter.m35685a().length <= 8) {
                this.f26612a = m34925a(z, keyParameter.m35685a());
                return;
            }
            throw new IllegalArgumentException("DES key too long - should be 8 bytes");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to DES init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26612a == null) {
            throw new IllegalStateException("DES engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            m34924a(this.f26612a, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    protected int[] m34925a(boolean z, byte[] bArr) {
        int[] iArr = new int[32];
        boolean[] zArr = new boolean[56];
        boolean[] zArr2 = new boolean[56];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= 56) {
                break;
            }
            byte b = f26601d[i2];
            if ((f26599b[b & 7] & bArr[b >>> 3]) == 0) {
                z2 = false;
            }
            zArr[i2] = z2;
            i2++;
        }
        bArr = null;
        while (bArr < 16) {
            i2 = z ? bArr << 1 : (15 - bArr) << 1;
            int i3 = i2 + 1;
            iArr[i3] = 0;
            iArr[i2] = 0;
            int i4 = 0;
            while (true) {
                int i5 = 28;
                if (i4 >= 28) {
                    break;
                }
                int i6 = f26602e[bArr] + i4;
                if (i6 < 28) {
                    zArr2[i4] = zArr[i6];
                } else {
                    zArr2[i4] = zArr[i6 - 28];
                }
                i4++;
            }
            while (i5 < 56) {
                i4 = f26602e[bArr] + i5;
                if (i4 < 56) {
                    zArr2[i5] = zArr[i4];
                } else {
                    zArr2[i5] = zArr[i4 - 28];
                }
                i5++;
            }
            for (i4 = 0; i4 < 24; i4++) {
                if (zArr2[f26603f[i4]]) {
                    iArr[i2] = iArr[i2] | f26600c[i4];
                }
                if (zArr2[f26603f[i4 + 24]]) {
                    iArr[i3] = iArr[i3] | f26600c[i4];
                }
            }
            bArr++;
        }
        while (i != 32) {
            z = iArr[i];
            bArr = i + 1;
            int i7 = iArr[bArr];
            iArr[i] = (((16515072 & i7) >>> 10) | (((z & 16515072) << 6) | ((z & 4032) << 10))) | ((i7 & 4032) >>> 6);
            iArr[bArr] = ((((z & 63) << true) | ((z & 258048) << 12)) | ((258048 & i7) >>> 4)) | (i7 & 63);
            i += 2;
        }
        return iArr;
    }

    /* renamed from: a */
    protected void m34924a(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((((bArr[i + 0] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE);
        bArr = (bArr[i + 7] & JfifUtil.MARKER_FIRST_BYTE) | ((((bArr[i + 4] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i + 6] & JfifUtil.MARKER_FIRST_BYTE) << 8));
        i = ((i3 >>> 4) ^ bArr) & 252645135;
        bArr ^= i;
        i = (i << 4) ^ i3;
        i3 = ((i >>> 16) ^ bArr) & MinElf.PN_XNUM;
        bArr ^= i3;
        i ^= i3 << 16;
        i3 = ((bArr >>> 2) ^ i) & 858993459;
        i ^= i3;
        bArr ^= i3 << 2;
        i3 = ((bArr >>> 8) ^ i) & 16711935;
        i ^= i3;
        bArr ^= i3 << 8;
        bArr = (((bArr >>> 31) & 1) | (bArr << 1)) & -1;
        i3 = (i ^ bArr) & -1431655766;
        i ^= i3;
        bArr ^= i3;
        i = (((i >>> 31) & 1) | (i << 1)) & -1;
        for (i3 = 0; i3 < 8; i3++) {
            int i4 = i3 * 4;
            int i5 = ((bArr << 28) | (bArr >>> 4)) ^ iArr[i4 + 0];
            i5 = f26604g[(i5 >>> 24) & 63] | ((f26610m[i5 & 63] | f26608k[(i5 >>> 8) & 63]) | f26606i[(i5 >>> 16) & 63]);
            int i6 = iArr[i4 + 1] ^ bArr;
            i ^= (((i5 | f26611n[i6 & 63]) | f26609l[(i6 >>> 8) & 63]) | f26607j[(i6 >>> 16) & 63]) | f26605h[(i6 >>> 24) & 63];
            i5 = ((i << 28) | (i >>> 4)) ^ iArr[i4 + 2];
            i4 = iArr[i4 + 3] ^ i;
            bArr ^= ((((f26604g[(i5 >>> 24) & 63] | ((f26610m[i5 & 63] | f26608k[(i5 >>> 8) & 63]) | f26606i[(i5 >>> 16) & 63])) | f26611n[i4 & 63]) | f26609l[(i4 >>> 8) & 63]) | f26607j[(i4 >>> 16) & 63]) | f26605h[(i4 >>> 24) & 63];
        }
        iArr = (bArr << 31) | (bArr >>> 1);
        bArr = (i ^ iArr) & -1431655766;
        i ^= bArr;
        iArr ^= bArr;
        bArr = (i << 31) | (i >>> 1);
        i = ((bArr >>> 8) ^ iArr) & 16711935;
        iArr ^= i;
        bArr ^= i << 8;
        i = ((bArr >>> 2) ^ iArr) & 858993459;
        iArr ^= i;
        bArr ^= i << 2;
        i = ((iArr >>> 16) ^ bArr) & MinElf.PN_XNUM;
        bArr ^= i;
        iArr ^= i << 16;
        i = ((iArr >>> 4) ^ bArr) & 252645135;
        bArr ^= i;
        iArr ^= i << 4;
        bArr2[i2 + 0] = (byte) ((iArr >>> 24) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 1] = (byte) ((iArr >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 2] = (byte) ((iArr >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 3] = (byte) (iArr & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 4] = (byte) ((bArr >>> 24) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 5] = (byte) ((bArr >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 6] = (byte) ((bArr >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        bArr2[i2 + 7] = (byte) (bArr & JfifUtil.MARKER_FIRST_BYTE);
    }
}
