package com.google.android.gms.internal.ads;

import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zm implements zh {
    /* renamed from: a */
    static final int[] f24418a = m31253a(ByteBuffer.wrap(new byte[]{(byte) 101, Framer.EXIT_FRAME_PREFIX, (byte) 112, (byte) 97, (byte) 110, (byte) 100, (byte) 32, (byte) 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, (byte) 98, (byte) 121, (byte) 116, (byte) 101, (byte) 32, (byte) 107}));
    /* renamed from: b */
    final zg f24419b;
    /* renamed from: c */
    private final int f24420c;

    zm(byte[] bArr, int i) {
        if (bArr.length == 32) {
            this.f24419b = zg.m20189a(bArr);
            this.f24420c = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* renamed from: a */
    static int m31252a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: a */
    static int[] m31253a(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* renamed from: a */
    abstract int mo6139a();

    /* renamed from: a */
    abstract ByteBuffer mo6140a(byte[] bArr, int i);

    /* renamed from: a */
    final void m31256a(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - mo6139a() >= bArr.length) {
            byte[] a = zk.m20197a(mo6139a());
            byteBuffer.put(a);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer a2 = mo6140a(a, this.f24420c + i2);
                if (i2 == i - 1) {
                    yi.m20168a(byteBuffer, wrap, a2, remaining % 64);
                } else {
                    yi.m20168a(byteBuffer, wrap, a2, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* renamed from: a */
    public final byte[] mo4391a(byte[] bArr) {
        int length = bArr.length;
        mo6139a();
        if (length <= 2147483635) {
            ByteBuffer allocate = ByteBuffer.allocate(mo6139a() + bArr.length);
            m31256a(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
