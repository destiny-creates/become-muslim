package org.spongycastle.crypto.prng.drbg;

import com.facebook.imageutils.JfifUtil;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.util.Integers;

class Utils {
    /* renamed from: a */
    static final Hashtable f22459a = new Hashtable();

    Utils() {
    }

    static {
        f22459a.put("SHA-1", Integers.m29396a(128));
        f22459a.put("SHA-224", Integers.m29396a(JfifUtil.MARKER_SOFn));
        f22459a.put("SHA-256", Integers.m29396a(256));
        f22459a.put("SHA-384", Integers.m29396a(256));
        f22459a.put("SHA-512", Integers.m29396a(256));
        f22459a.put("SHA-512/224", Integers.m29396a(JfifUtil.MARKER_SOFn));
        f22459a.put("SHA-512/256", Integers.m29396a(256));
    }

    /* renamed from: a */
    static int m27524a(Digest digest) {
        return ((Integer) f22459a.get(digest.mo5729a())).intValue();
    }

    /* renamed from: a */
    static int m27525a(Mac mac) {
        mac = mac.mo5762a();
        return ((Integer) f22459a.get(mac.substring(0, mac.indexOf("/")))).intValue();
    }

    /* renamed from: a */
    static byte[] m27527a(Digest digest, byte[] bArr, int i) {
        Object obj = new byte[((i + 7) / 8)];
        int length = obj.length / digest.mo5732b();
        Object obj2 = new byte[digest.mo5732b()];
        int i2 = 0;
        int i3 = 1;
        for (int i4 = 0; i4 <= length; i4++) {
            digest.mo5730a((byte) i3);
            digest.mo5730a((byte) (i >> 24));
            digest.mo5730a((byte) (i >> 16));
            digest.mo5730a((byte) (i >> 8));
            digest.mo5730a((byte) i);
            digest.mo5731a(bArr, 0, bArr.length);
            digest.mo5728a(obj2, 0);
            System.arraycopy(obj2, 0, obj, obj2.length * i4, obj.length - (obj2.length * i4) > obj2.length ? obj2.length : obj.length - (obj2.length * i4));
            i3++;
        }
        i %= 8;
        if (i != 0) {
            digest = 8 - i;
            bArr = null;
            while (i2 != obj.length) {
                i = obj[i2] & JfifUtil.MARKER_FIRST_BYTE;
                obj[i2] = (byte) ((bArr << (8 - digest)) | (i >>> digest));
                i2++;
                bArr = i;
            }
        }
        return obj;
    }

    /* renamed from: a */
    static boolean m27526a(byte[] bArr, int i) {
        return (bArr == null || bArr.length <= i) ? null : 1;
    }
}
