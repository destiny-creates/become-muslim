package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@cm
public final class alz extends alu {
    /* renamed from: b */
    private MessageDigest f23717b;

    /* renamed from: a */
    public final byte[] mo3842a(String str) {
        byte[] array;
        String[] split = str.split(" ");
        int i = 4;
        if (split.length == 1) {
            int a = aly.m18618a(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(a);
            array = allocate.array();
        } else if (split.length < 5) {
            array = new byte[(split.length << 1)];
            for (r4 = 0; r4 < split.length; r4++) {
                int a2 = aly.m18618a(split[r4]);
                a2 = (a2 >> 16) ^ (MinElf.PN_XNUM & a2);
                byte[] bArr = new byte[]{(byte) a2, (byte) (a2 >> 8)};
                a2 = r4 << 1;
                array[a2] = bArr[0];
                array[a2 + 1] = bArr[1];
            }
        } else {
            array = new byte[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                r4 = aly.m18618a(split[i2]);
                array[i2] = (byte) ((r4 >> 24) ^ (((r4 & JfifUtil.MARKER_FIRST_BYTE) ^ ((r4 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) ^ ((r4 >> 16) & JfifUtil.MARKER_FIRST_BYTE)));
            }
        }
        this.f23717b = m18613a();
        synchronized (this.a) {
            if (this.f23717b == null) {
                array = new byte[0];
                return array;
            }
            this.f23717b.reset();
            this.f23717b.update(array);
            Object digest = this.f23717b.digest();
            if (digest.length <= 4) {
                i = digest.length;
            }
            Object obj = new byte[i];
            System.arraycopy(digest, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
