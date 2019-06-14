package expolib_v1.p321a.p322a.p331i;

import com.facebook.stetho.websocket.CloseCodes;

/* compiled from: WebSocketProtocol */
/* renamed from: expolib_v1.a.a.i.b */
public final class C6203b {
    /* renamed from: a */
    static void m25528a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int length = bArr2.length;
        int i = 0;
        while (((long) i) < j) {
            int i2 = (int) (j2 % ((long) length));
            bArr[i] = (byte) (bArr2[i2] ^ bArr[i]);
            i++;
            j2++;
        }
    }

    /* renamed from: a */
    static String m25527a(int i) {
        StringBuilder stringBuilder;
        if (i >= 1000) {
            if (i < 5000) {
                if ((i < 1004 || i > CloseCodes.CLOSED_ABNORMALLY) && (i < 1012 || i > 2999)) {
                    return 0;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Code ");
                stringBuilder.append(i);
                stringBuilder.append(" is reserved and may not be used.");
                return stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Code must be in range [1000,5000): ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    static void m25529b(int i) {
        i = C6203b.m25527a(i);
        if (i != 0) {
            throw new IllegalArgumentException(i);
        }
    }
}
