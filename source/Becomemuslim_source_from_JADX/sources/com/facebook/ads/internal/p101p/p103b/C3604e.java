package com.facebook.ads.internal.p101p.p103b;

import android.text.TextUtils;
import com.facebook.ads.internal.p101p.p103b.p104a.C3601b;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/* renamed from: com.facebook.ads.internal.p.b.e */
class C3604e extends C1476k {
    /* renamed from: a */
    private final C3606h f9610a;
    /* renamed from: b */
    private final C3601b f9611b;
    /* renamed from: c */
    private C1462b f9612c;

    public C3604e(C3606h c3606h, C3601b c3601b) {
        super(c3606h, c3601b);
        this.f9611b = c3601b;
        this.f9610a = c3606h;
    }

    /* renamed from: a */
    private void m11748a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int a = m5222a(bArr, j, bArr.length);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m11749a(C1464d c1464d) {
        int a = this.f9610a.mo992a();
        return (a > 0 ? 1 : null) == null || !c1464d.f4320c || ((float) c1464d.f4319b) <= ((float) this.f9611b.mo982a()) + (((float) a) * 0.2f);
    }

    /* renamed from: b */
    private String m11750b(C1464d c1464d) {
        int isEmpty = TextUtils.isEmpty(this.f9610a.m11763c()) ^ 1;
        int a = this.f9611b.mo987d() ? this.f9611b.mo982a() : this.f9610a.mo992a();
        Object obj = a >= 0 ? 1 : null;
        long j = c1464d.f4320c ? ((long) a) - c1464d.f4319b : (long) a;
        Object obj2 = (obj == null || !c1464d.f4320c) ? null : 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c1464d.f4320c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        stringBuilder.append("Accept-Ranges: bytes\n");
        stringBuilder.append(obj != null ? String.format("Content-Length: %d\n", new Object[]{Long.valueOf(j)}) : "");
        stringBuilder.append(obj2 != null ? String.format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(c1464d.f4319b), Integer.valueOf(a - 1), Integer.valueOf(a)}) : "");
        stringBuilder.append(isEmpty != 0 ? String.format("Content-Type: %s\n", new Object[]{r0}) : "");
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private void m11751b(OutputStream outputStream, long j) {
        try {
            C3606h c3606h = new C3606h(this.f9610a);
            c3606h.mo994a((int) j);
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                int a = c3606h.mo993a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
            }
            outputStream.flush();
        } finally {
            this.f9610a.mo995b();
        }
    }

    /* renamed from: a */
    protected void mo990a(int i) {
        if (this.f9612c != null) {
            this.f9612c.mo991a(this.f9611b.f9606a, this.f9610a.f9615a, i);
        }
    }

    /* renamed from: a */
    public void m11753a(C1462b c1462b) {
        this.f9612c = c1462b;
    }

    /* renamed from: a */
    public void m11754a(C1464d c1464d, Socket socket) {
        OutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m11750b(c1464d).getBytes(Utf8Charset.NAME));
        long j = c1464d.f4319b;
        if (m11749a(c1464d)) {
            m11748a(bufferedOutputStream, j);
        } else {
            m11751b(bufferedOutputStream, j);
        }
    }
}
