package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;

public class DHKDFParameters implements DerivationParameters {
    /* renamed from: a */
    private ASN1ObjectIdentifier f26480a;
    /* renamed from: b */
    private int f26481b;
    /* renamed from: c */
    private byte[] f26482c;
    /* renamed from: d */
    private byte[] f26483d;

    /* renamed from: a */
    public ASN1ObjectIdentifier m34718a() {
        return this.f26480a;
    }

    /* renamed from: b */
    public int m34719b() {
        return this.f26481b;
    }

    /* renamed from: c */
    public byte[] m34720c() {
        return this.f26482c;
    }

    /* renamed from: d */
    public byte[] m34721d() {
        return this.f26483d;
    }
}
