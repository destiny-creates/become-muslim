package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    /* renamed from: a */
    DHParameterSpec f22709a;

    protected String engineToString() {
        return "Diffie-Hellman Parameters";
    }

    /* renamed from: a */
    protected boolean m27959a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return m27958a(cls);
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
        r0 = new org.spongycastle.asn1.pkcs.DHParameter;
        r1 = r4.f22709a;
        r1 = r1.getP();
        r2 = r4.f22709a;
        r2 = r2.getG();
        r3 = r4.f22709a;
        r3 = r3.getL();
        r0.<init>(r1, r2, r3);
        r1 = "DER";	 Catch:{ IOException -> 0x001e }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x001e }
        return r0;
    L_0x001e:
        r0 = new java.lang.RuntimeException;
        r1 = "Error encoding DHParameters";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi.engineGetEncoded():byte[]");
    }

    protected byte[] engineGetEncoded(String str) {
        return m27959a(str) != null ? engineGetEncoded() : null;
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec m27958a(Class cls) {
        if (cls != DHParameterSpec.class) {
            if (cls != AlgorithmParameterSpec.class) {
                throw new InvalidParameterSpecException("unknown parameter spec passed to DH parameters object.");
            }
        }
        return this.f22709a;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            this.f22709a = (DHParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("DHParameterSpec required to initialise a Diffie-Hellman algorithm parameters object");
    }

    protected void engineInit(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r4 = org.spongycastle.asn1.pkcs.DHParameter.m40065a(r4);	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r0 = r4.m40068c();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        if (r0 == 0) goto L_0x0022;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
    L_0x000a:
        r0 = new javax.crypto.spec.DHParameterSpec;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r1 = r4.m40066a();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r2 = r4.m40067b();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r4 = r4.m40068c();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r4 = r4.intValue();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r0.<init>(r1, r2, r4);	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r3.f22709a = r0;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        goto L_0x0031;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
    L_0x0022:
        r0 = new javax.crypto.spec.DHParameterSpec;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r1 = r4.m40066a();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r4 = r4.m40067b();	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r0.<init>(r1, r4);	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
        r3.f22709a = r0;	 Catch:{ ClassCastException -> 0x003a, ArrayIndexOutOfBoundsException -> 0x0032 }
    L_0x0031:
        return;
    L_0x0032:
        r4 = new java.io.IOException;
        r0 = "Not a valid DH Parameter encoding.";
        r4.<init>(r0);
        throw r4;
    L_0x003a:
        r4 = new java.io.IOException;
        r0 = "Not a valid DH Parameter encoding.";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi.engineInit(byte[]):void");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (m27959a(str)) {
            engineInit(bArr);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown parameter format ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }
}
