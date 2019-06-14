package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.agreement.srp.SRP6VerifierGenerator;
import org.spongycastle.crypto.params.SRP6GroupParameters;
import org.spongycastle.util.Strings;

public class SimulatedTlsSRPIdentityManager implements TlsSRPIdentityManager {
    /* renamed from: d */
    private static final byte[] f27314d = Strings.m29429d("password");
    /* renamed from: e */
    private static final byte[] f27315e = Strings.m29429d("salt");
    /* renamed from: a */
    protected SRP6GroupParameters f27316a;
    /* renamed from: b */
    protected SRP6VerifierGenerator f27317b;
    /* renamed from: c */
    protected Mac f27318c;

    /* renamed from: a */
    public TlsSRPLoginParameters mo5834a(byte[] bArr) {
        this.f27318c.mo5765a(f27315e, 0, f27315e.length);
        this.f27318c.mo5765a(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[this.f27318c.mo5766b()];
        this.f27318c.mo5761a(bArr2, 0);
        this.f27318c.mo5765a(f27314d, 0, f27314d.length);
        this.f27318c.mo5765a(bArr, 0, bArr.length);
        byte[] bArr3 = new byte[this.f27318c.mo5766b()];
        this.f27318c.mo5761a(bArr3, 0);
        return new TlsSRPLoginParameters(this.f27316a, this.f27317b.m27383a(bArr2, bArr, bArr3), bArr2);
    }
}
