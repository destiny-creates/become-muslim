package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    /* renamed from: a */
    DSAParameterSpec f22731a;

    protected String engineToString() {
        return "DSA Parameters";
    }

    /* renamed from: a */
    protected boolean m27962a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return m27961a(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    protected byte[] engineGetEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new org.spongycastle.asn1.x509.DSAParameter;
        r1 = r4.f22731a;
        r1 = r1.getP();
        r2 = r4.f22731a;
        r2 = r2.getQ();
        r3 = r4.f22731a;
        r3 = r3.getG();
        r0.<init>(r1, r2, r3);
        r1 = "DER";	 Catch:{ IOException -> 0x001e }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x001e }
        return r0;
    L_0x001e:
        r0 = new java.lang.RuntimeException;
        r1 = "Error encoding DSAParameters";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi.engineGetEncoded():byte[]");
    }

    protected byte[] engineGetEncoded(String str) {
        return m27962a(str) != null ? engineGetEncoded() : null;
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec m27961a(Class cls) {
        if (cls != DSAParameterSpec.class) {
            if (cls != AlgorithmParameterSpec.class) {
                throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
            }
        }
        return this.f22731a;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            this.f22731a = (DSAParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
    }

    protected void engineInit(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = org.spongycastle.asn1.ASN1Primitive.m39798b(r4);	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r4 = org.spongycastle.asn1.x509.DSAParameter.m40300a(r4);	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r0 = new java.security.spec.DSAParameterSpec;	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r1 = r4.m40301a();	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r2 = r4.m40302b();	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r4 = r4.m40303c();	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r0.<init>(r1, r2, r4);	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        r3.f22731a = r0;	 Catch:{ ClassCastException -> 0x0024, ArrayIndexOutOfBoundsException -> 0x001c }
        return;
    L_0x001c:
        r4 = new java.io.IOException;
        r0 = "Not a valid DSA Parameter encoding.";
        r4.<init>(r0);
        throw r4;
    L_0x0024:
        r4 = new java.io.IOException;
        r0 = "Not a valid DSA Parameter encoding.";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi.engineInit(byte[]):void");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (!m27962a(str)) {
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
