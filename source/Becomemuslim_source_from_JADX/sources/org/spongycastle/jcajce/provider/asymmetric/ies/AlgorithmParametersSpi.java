package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.jce.spec.IESParameterSpec;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    /* renamed from: a */
    IESParameterSpec f22780a;

    protected String engineToString() {
        return "IES Parameters";
    }

    /* renamed from: a */
    protected boolean m27976a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return m27975a(cls);
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
        r0 = new org.spongycastle.asn1.ASN1EncodableVector;	 Catch:{ IOException -> 0x003c }
        r0.<init>();	 Catch:{ IOException -> 0x003c }
        r1 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x003c }
        r2 = r4.f22780a;	 Catch:{ IOException -> 0x003c }
        r2 = r2.m28334a();	 Catch:{ IOException -> 0x003c }
        r1.<init>(r2);	 Catch:{ IOException -> 0x003c }
        r0.m27141a(r1);	 Catch:{ IOException -> 0x003c }
        r1 = new org.spongycastle.asn1.DEROctetString;	 Catch:{ IOException -> 0x003c }
        r2 = r4.f22780a;	 Catch:{ IOException -> 0x003c }
        r2 = r2.m28335b();	 Catch:{ IOException -> 0x003c }
        r1.<init>(r2);	 Catch:{ IOException -> 0x003c }
        r0.m27141a(r1);	 Catch:{ IOException -> 0x003c }
        r1 = new org.spongycastle.asn1.ASN1Integer;	 Catch:{ IOException -> 0x003c }
        r2 = r4.f22780a;	 Catch:{ IOException -> 0x003c }
        r2 = r2.m28336c();	 Catch:{ IOException -> 0x003c }
        r2 = (long) r2;	 Catch:{ IOException -> 0x003c }
        r1.<init>(r2);	 Catch:{ IOException -> 0x003c }
        r0.m27141a(r1);	 Catch:{ IOException -> 0x003c }
        r1 = new org.spongycastle.asn1.DERSequence;	 Catch:{ IOException -> 0x003c }
        r1.<init>(r0);	 Catch:{ IOException -> 0x003c }
        r0 = "DER";	 Catch:{ IOException -> 0x003c }
        r0 = r1.m34596a(r0);	 Catch:{ IOException -> 0x003c }
        return r0;
    L_0x003c:
        r0 = new java.lang.RuntimeException;
        r1 = "Error encoding IESParameters";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi.engineGetEncoded():byte[]");
    }

    protected byte[] engineGetEncoded(String str) {
        if (!m27976a(str)) {
            if (str.equalsIgnoreCase("X.509") == null) {
                return null;
            }
        }
        return engineGetEncoded();
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec m27975a(Class cls) {
        if (cls != IESParameterSpec.class) {
            if (cls != AlgorithmParameterSpec.class) {
                throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
            }
        }
        return this.f22780a;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.f22780a = (IESParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
    }

    protected void engineInit(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = org.spongycastle.asn1.ASN1Primitive.m39798b(r5);	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r5 = (org.spongycastle.asn1.ASN1Sequence) r5;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r0 = new org.spongycastle.jce.spec.IESParameterSpec;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r1 = 0;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r2 = r5.mo6860a(r1);	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r2 = (org.spongycastle.asn1.ASN1OctetString) r2;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r2 = r2.mo6859c();	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r3 = r5.mo6860a(r1);	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r3 = (org.spongycastle.asn1.ASN1OctetString) r3;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r3 = r3.mo6859c();	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r5 = r5.mo6860a(r1);	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r5 = (org.spongycastle.asn1.ASN1Integer) r5;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r5 = r5.m42968b();	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r5 = r5.intValue();	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r0.<init>(r2, r3, r5);	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        r4.f22780a = r0;	 Catch:{ ClassCastException -> 0x0039, ArrayIndexOutOfBoundsException -> 0x0031 }
        return;
    L_0x0031:
        r5 = new java.io.IOException;
        r0 = "Not a valid IES Parameter encoding.";
        r5.<init>(r0);
        throw r5;
    L_0x0039:
        r5 = new java.io.IOException;
        r0 = "Not a valid IES Parameter encoding.";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ies.AlgorithmParametersSpi.engineInit(byte[]):void");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (!m27976a(str)) {
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
