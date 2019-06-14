package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class ServerSRPParams {
    /* renamed from: a */
    protected BigInteger f22555a;
    /* renamed from: b */
    protected BigInteger f22556b;
    /* renamed from: c */
    protected BigInteger f22557c;
    /* renamed from: d */
    protected byte[] f22558d;

    public ServerSRPParams(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, BigInteger bigInteger3) {
        this.f22555a = bigInteger;
        this.f22556b = bigInteger2;
        this.f22558d = Arrays.m29373b(bArr);
        this.f22557c = bigInteger3;
    }

    /* renamed from: a */
    public BigInteger m27607a() {
        return this.f22557c;
    }

    /* renamed from: b */
    public BigInteger m27609b() {
        return this.f22556b;
    }

    /* renamed from: c */
    public BigInteger m27610c() {
        return this.f22555a;
    }

    /* renamed from: d */
    public byte[] m27611d() {
        return this.f22558d;
    }

    /* renamed from: a */
    public void m27608a(OutputStream outputStream) {
        TlsSRPUtils.m27783a(this.f22555a, outputStream);
        TlsSRPUtils.m27783a(this.f22556b, outputStream);
        TlsUtils.m27819a(this.f22558d, outputStream);
        TlsSRPUtils.m27783a(this.f22557c, outputStream);
    }

    /* renamed from: a */
    public static ServerSRPParams m27606a(InputStream inputStream) {
        return new ServerSRPParams(TlsSRPUtils.m27782a(inputStream), TlsSRPUtils.m27782a(inputStream), TlsUtils.m27872e(inputStream), TlsSRPUtils.m27782a(inputStream));
    }
}
