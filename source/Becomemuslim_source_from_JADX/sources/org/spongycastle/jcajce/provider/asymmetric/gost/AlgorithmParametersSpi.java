package org.spongycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.jce.spec.GOST3410ParameterSpec;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    /* renamed from: a */
    GOST3410ParameterSpec f22773a;

    protected String engineToString() {
        return "GOST3410 Parameters";
    }

    /* renamed from: a */
    protected boolean m27973a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return m27972a(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    protected byte[] engineGetEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
        r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r2 = r5.f22773a;
        r2 = r2.mo5890a();
        r1.<init>(r2);
        r2 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r3 = r5.f22773a;
        r3 = r3.mo5891b();
        r2.<init>(r3);
        r3 = new org.spongycastle.asn1.ASN1ObjectIdentifier;
        r4 = r5.f22773a;
        r4 = r4.mo5892c();
        r3.<init>(r4);
        r0.<init>(r1, r2, r3);
        r1 = "DER";	 Catch:{ IOException -> 0x002d }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x002d }
        return r0;
    L_0x002d:
        r0 = new java.lang.RuntimeException;
        r1 = "Error encoding GOST3410Parameters";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi.engineGetEncoded():byte[]");
    }

    protected byte[] engineGetEncoded(String str) {
        if (!m27973a(str)) {
            if (str.equalsIgnoreCase("X.509") == null) {
                return null;
            }
        }
        return engineGetEncoded();
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec m27972a(Class cls) {
        if (cls != GOST3410PublicKeyParameterSetSpec.class) {
            if (cls != AlgorithmParameterSpec.class) {
                throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
            }
        }
        return this.f22773a;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
            this.f22773a = (GOST3410ParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
    }

    protected void engineInit(byte[] r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = org.spongycastle.asn1.ASN1Primitive.m39798b(r2);	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        r2 = (org.spongycastle.asn1.ASN1Sequence) r2;	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        r0 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        r0.<init>(r2);	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        r2 = org.spongycastle.jce.spec.GOST3410ParameterSpec.m36255a(r0);	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        r1.f22773a = r2;	 Catch:{ ClassCastException -> 0x001a, ArrayIndexOutOfBoundsException -> 0x0012 }
        return;
    L_0x0012:
        r2 = new java.io.IOException;
        r0 = "Not a valid GOST3410 Parameter encoding.";
        r2.<init>(r0);
        throw r2;
    L_0x001a:
        r2 = new java.io.IOException;
        r0 = "Not a valid GOST3410 Parameter encoding.";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi.engineInit(byte[]):void");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (!m27973a(str)) {
            if (!str.equalsIgnoreCase("X.509")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown parameter format ");
                stringBuilder.append(str);
                throw new IOException(stringBuilder.toString());
            }
        }
        engineInit(bArr);
    }
}
