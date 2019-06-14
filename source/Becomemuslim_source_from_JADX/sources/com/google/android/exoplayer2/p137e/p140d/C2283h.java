package com.google.android.exoplayer2.p137e.p140d;

import android.util.Log;
import com.google.android.exoplayer2.p164l.C2529l;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: PsshAtomUtil */
/* renamed from: com.google.android.exoplayer2.e.d.h */
public final class C2283h {

    /* compiled from: PsshAtomUtil */
    /* renamed from: com.google.android.exoplayer2.e.d.h$a */
    private static class C2282a {
        /* renamed from: a */
        private final UUID f5569a;
        /* renamed from: b */
        private final int f5570b;
        /* renamed from: c */
        private final byte[] f5571c;

        public C2282a(UUID uuid, int i, byte[] bArr) {
            this.f5569a = uuid;
            this.f5570b = i;
            this.f5571c = bArr;
        }
    }

    /* renamed from: a */
    public static byte[] m6316a(UUID uuid, byte[] bArr) {
        return C2283h.m6317a(uuid, null, bArr);
    }

    /* renamed from: a */
    public static byte[] m6317a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        Object obj = uuidArr != null ? 1 : null;
        int length = bArr != null ? bArr.length : 0;
        int i = length + 32;
        if (obj != null) {
            i += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.putInt(i);
        allocate.putInt(C2268a.f5461U);
        allocate.putInt(obj != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (obj != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    /* renamed from: a */
    public static UUID m6315a(byte[] bArr) {
        bArr = C2283h.m6318b(bArr);
        if (bArr == null) {
            return null;
        }
        return bArr.f5569a;
    }

    /* renamed from: b */
    private static C2282a m6318b(byte[] bArr) {
        C2529l c2529l = new C2529l(bArr);
        if (c2529l.m7095c() < 32) {
            return null;
        }
        c2529l.m7096c(0);
        if (c2529l.m7111o() != c2529l.m7093b() + 4 || c2529l.m7111o() != C2268a.f5461U) {
            return null;
        }
        int a = C2268a.m6269a(c2529l.m7111o());
        if (a > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported pssh version: ");
            stringBuilder.append(a);
            Log.w("PsshAtomUtil", stringBuilder.toString());
            return null;
        }
        UUID uuid = new UUID(c2529l.m7113q(), c2529l.m7113q());
        if (a == 1) {
            c2529l.m7098d(c2529l.m7117u() * 16);
        }
        int u = c2529l.m7117u();
        if (u != c2529l.m7093b()) {
            return null;
        }
        byte[] bArr2 = new byte[u];
        c2529l.m7092a(bArr2, 0, u);
        return new C2282a(uuid, a, bArr2);
    }
}
