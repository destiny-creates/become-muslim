package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class AlgorithmParametersSpi extends BaseAlgorithmParameters {
    /* renamed from: a */
    ElGamalParameterSpec f27415a;

    protected String engineToString() {
        return "ElGamal Parameters";
    }

    protected byte[] engineGetEncoded() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.spongycastle.asn1.oiw.ElGamalParameter;
        r1 = r3.f27415a;
        r1 = r1.m28321a();
        r2 = r3.f27415a;
        r2 = r2.m28322b();
        r0.<init>(r1, r2);
        r1 = "DER";	 Catch:{ IOException -> 0x0018 }
        r0 = r0.m34596a(r1);	 Catch:{ IOException -> 0x0018 }
        return r0;
    L_0x0018:
        r0 = new java.lang.RuntimeException;
        r1 = "Error encoding ElGamalParameters";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi.engineGetEncoded():byte[]");
    }

    protected byte[] engineGetEncoded(String str) {
        if (!m28078a(str)) {
            if (str.equalsIgnoreCase("X.509") == null) {
                return null;
            }
        }
        return engineGetEncoded();
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec mo5855a(Class cls) {
        if (cls != ElGamalParameterSpec.class) {
            if (cls != AlgorithmParameterSpec.class) {
                if (cls == DHParameterSpec.class) {
                    return new DHParameterSpec(this.f27415a.m28321a(), this.f27415a.m28322b());
                }
                throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
            }
        }
        return this.f27415a;
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (!z) {
            if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
                throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
            }
        }
        if (z) {
            this.f27415a = (ElGamalParameterSpec) algorithmParameterSpec;
            return;
        }
        DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
        this.f27415a = new ElGamalParameterSpec(dHParameterSpec.getP(), dHParameterSpec.getG());
    }

    protected void engineInit(byte[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = org.spongycastle.asn1.ASN1Primitive.m39798b(r3);	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r3 = org.spongycastle.asn1.oiw.ElGamalParameter.m40046a(r3);	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r0 = new org.spongycastle.jce.spec.ElGamalParameterSpec;	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r1 = r3.m40047a();	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r3 = r3.m40048b();	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r0.<init>(r1, r3);	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        r2.f27415a = r0;	 Catch:{ ClassCastException -> 0x0020, ArrayIndexOutOfBoundsException -> 0x0018 }
        return;
    L_0x0018:
        r3 = new java.io.IOException;
        r0 = "Not a valid ElGamal Parameter encoding.";
        r3.<init>(r0);
        throw r3;
    L_0x0020:
        r3 = new java.io.IOException;
        r0 = "Not a valid ElGamal Parameter encoding.";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi.engineInit(byte[]):void");
    }

    protected void engineInit(byte[] bArr, String str) {
        if (!m28078a(str)) {
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
