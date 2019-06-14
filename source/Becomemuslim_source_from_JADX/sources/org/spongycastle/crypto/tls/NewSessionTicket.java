package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;

public class NewSessionTicket {
    /* renamed from: a */
    protected long f22509a;
    /* renamed from: b */
    protected byte[] f22510b;

    public NewSessionTicket(long j, byte[] bArr) {
        this.f22509a = j;
        this.f22510b = bArr;
    }

    /* renamed from: a */
    public void m27564a(OutputStream outputStream) {
        TlsUtils.m27808a(this.f22509a, outputStream);
        TlsUtils.m27844b(this.f22510b, outputStream);
    }

    /* renamed from: a */
    public static NewSessionTicket m27563a(InputStream inputStream) {
        return new NewSessionTicket(TlsUtils.m27862d(inputStream), TlsUtils.m27875f(inputStream));
    }
}
