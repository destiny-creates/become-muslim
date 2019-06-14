package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.BigIntegers;

public class DefaultTlsAgreementCredentials extends AbstractTlsAgreementCredentials {
    /* renamed from: a */
    protected Certificate f32648a;
    /* renamed from: b */
    protected AsymmetricKeyParameter f32649b;
    /* renamed from: c */
    protected BasicAgreement f32650c;
    /* renamed from: d */
    protected boolean f32651d;

    /* renamed from: a */
    public Certificate mo6811a() {
        return this.f32648a;
    }

    /* renamed from: a */
    public byte[] mo6812a(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.f32650c.mo5724a(this.f32649b);
        asymmetricKeyParameter = this.f32650c.mo5725b(asymmetricKeyParameter);
        if (this.f32651d) {
            return BigIntegers.m29389a(asymmetricKeyParameter);
        }
        return BigIntegers.m29388a(this.f32650c.mo5723a(), asymmetricKeyParameter);
    }
}
