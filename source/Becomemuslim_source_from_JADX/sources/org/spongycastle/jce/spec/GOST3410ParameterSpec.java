package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;

public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    /* renamed from: a */
    private GOST3410PublicKeyParameterSetSpec f27626a;
    /* renamed from: b */
    private String f27627b;
    /* renamed from: c */
    private String f27628c;
    /* renamed from: d */
    private String f27629d;

    public GOST3410ParameterSpec(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>();
        r0 = new org.spongycastle.asn1.ASN1ObjectIdentifier;	 Catch:{ IllegalArgumentException -> 0x000d }
        r0.<init>(r5);	 Catch:{ IllegalArgumentException -> 0x000d }
        r0 = org.spongycastle.asn1.cryptopro.GOST3410NamedParameters.m27185a(r0);	 Catch:{ IllegalArgumentException -> 0x000d }
        goto L_0x001e;
        r0 = org.spongycastle.asn1.cryptopro.GOST3410NamedParameters.m27184a(r5);
        if (r0 == 0) goto L_0x001d;
    L_0x0014:
        r5 = r0.m42986b();
        r0 = org.spongycastle.asn1.cryptopro.GOST3410NamedParameters.m27185a(r0);
        goto L_0x001e;
    L_0x001d:
        r0 = 0;
    L_0x001e:
        if (r0 == 0) goto L_0x003a;
    L_0x0020:
        r1 = new org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
        r2 = r0.m39944a();
        r3 = r0.m39945b();
        r0 = r0.m39946c();
        r1.<init>(r2, r3, r0);
        r4.f27626a = r1;
        r4.f27627b = r5;
        r4.f27628c = r6;
        r4.f27629d = r7;
        return;
    L_0x003a:
        r5 = new java.lang.IllegalArgumentException;
        r6 = "no key parameter set for passed in name/OID.";
        r5.<init>(r6);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.spec.GOST3410ParameterSpec.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public GOST3410ParameterSpec(String str, String str2) {
        this(str, str2, null);
    }

    public GOST3410ParameterSpec(String str) {
        this(str, CryptoProObjectIdentifiers.f21567m.m42986b(), null);
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec) {
        this.f27626a = gOST3410PublicKeyParameterSetSpec;
        this.f27628c = CryptoProObjectIdentifiers.f21567m.m42986b();
        this.f27629d = null;
    }

    /* renamed from: a */
    public String mo5890a() {
        return this.f27627b;
    }

    /* renamed from: d */
    public GOST3410PublicKeyParameterSetSpec mo5893d() {
        return this.f27626a;
    }

    /* renamed from: b */
    public String mo5891b() {
        return this.f27628c;
    }

    /* renamed from: c */
    public String mo5892c() {
        return this.f27629d;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof GOST3410ParameterSpec)) {
            return false;
        }
        GOST3410ParameterSpec gOST3410ParameterSpec = (GOST3410ParameterSpec) obj;
        if (this.f27626a.equals(gOST3410ParameterSpec.f27626a) && this.f27628c.equals(gOST3410ParameterSpec.f27628c) && (this.f27629d == gOST3410ParameterSpec.f27629d || !(this.f27629d == null || this.f27629d.equals(gOST3410ParameterSpec.f27629d) == null))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f27626a.hashCode() ^ this.f27628c.hashCode()) ^ (this.f27629d != null ? this.f27629d.hashCode() : 0);
    }

    /* renamed from: a */
    public static GOST3410ParameterSpec m36255a(GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters) {
        if (gOST3410PublicKeyAlgParameters.m39951c() != null) {
            return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.m39949a().m42986b(), gOST3410PublicKeyAlgParameters.m39950b().m42986b(), gOST3410PublicKeyAlgParameters.m39951c().m42986b());
        }
        return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.m39949a().m42986b(), gOST3410PublicKeyAlgParameters.m39950b().m42986b());
    }
}
