package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.util.DigestFactory;

public abstract class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    public static class OAEP extends AlgorithmParametersSpi {
        /* renamed from: a */
        OAEPParameterSpec f27420a;

        protected String engineToString() {
            return "OAEP Parameters";
        }

        protected byte[] engineGetEncoded() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
            r1 = r6.f27420a;
            r1 = r1.getDigestAlgorithm();
            r1 = org.spongycastle.jcajce.provider.util.DigestFactory.m28102b(r1);
            r2 = org.spongycastle.asn1.DERNull.f32850a;
            r0.<init>(r1, r2);
            r1 = r6.f27420a;
            r1 = r1.getMGFParameters();
            r1 = (java.security.spec.MGF1ParameterSpec) r1;
            r2 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
            r3 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.l_;
            r4 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
            r1 = r1.getDigestAlgorithm();
            r1 = org.spongycastle.jcajce.provider.util.DigestFactory.m28102b(r1);
            r5 = org.spongycastle.asn1.DERNull.f32850a;
            r4.<init>(r1, r5);
            r2.<init>(r3, r4);
            r1 = r6.f27420a;
            r1 = r1.getPSource();
            r1 = (javax.crypto.spec.PSource.PSpecified) r1;
            r3 = new org.spongycastle.asn1.x509.AlgorithmIdentifier;
            r4 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.f21863j;
            r5 = new org.spongycastle.asn1.DEROctetString;
            r1 = r1.getValue();
            r5.<init>(r1);
            r3.<init>(r4, r5);
            r1 = new org.spongycastle.asn1.pkcs.RSAESOAEPparams;
            r1.<init>(r0, r2, r3);
            r0 = "DER";	 Catch:{ IOException -> 0x0053 }
            r0 = r1.m34596a(r0);	 Catch:{ IOException -> 0x0053 }
            return r0;
        L_0x0053:
            r0 = new java.lang.RuntimeException;
            r1 = "Error encoding OAEPParameters";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi.OAEP.engineGetEncoded():byte[]");
        }

        protected byte[] engineGetEncoded(String str) {
            if (!m27978a(str)) {
                if (str.equalsIgnoreCase("X.509") == null) {
                    return null;
                }
            }
            return engineGetEncoded();
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5862a(Class cls) {
            if (cls != OAEPParameterSpec.class) {
                if (cls != AlgorithmParameterSpec.class) {
                    throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
                }
            }
            return this.f27420a;
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                this.f27420a = (OAEPParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
        }

        protected void engineInit(byte[] r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r6 = org.spongycastle.asn1.pkcs.RSAESOAEPparams.m40120a(r6);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r0 = new javax.crypto.spec.OAEPParameterSpec;	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r1 = r6.m40121a();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r1 = r1.m40230a();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r1 = r1.m42986b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r2 = r6.m40122b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r2 = r2.m40230a();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r2 = r2.m42986b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r3 = new java.security.spec.MGF1ParameterSpec;	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = r6.m40122b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = r4.m40231b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = org.spongycastle.asn1.x509.AlgorithmIdentifier.m40228a(r4);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = r4.m40230a();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = r4.m42986b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r3.<init>(r4);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4 = new javax.crypto.spec.PSource$PSpecified;	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r6 = r6.m40123c();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r6 = r6.m40231b();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r6 = org.spongycastle.asn1.ASN1OctetString.m42990a(r6);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r6 = r6.mo6859c();	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r4.<init>(r6);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r0.<init>(r1, r2, r3, r4);	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            r5.f27420a = r0;	 Catch:{ ClassCastException -> 0x005a, ArrayIndexOutOfBoundsException -> 0x0052 }
            return;
        L_0x0052:
            r6 = new java.io.IOException;
            r0 = "Not a valid OAEP Parameter encoding.";
            r6.<init>(r0);
            throw r6;
        L_0x005a:
            r6 = new java.io.IOException;
            r0 = "Not a valid OAEP Parameter encoding.";
            r6.<init>(r0);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi.OAEP.engineInit(byte[]):void");
        }

        protected void engineInit(byte[] bArr, String str) {
            if (!str.equalsIgnoreCase("X.509")) {
                if (!str.equalsIgnoreCase("ASN.1")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown parameter format ");
                    stringBuilder.append(str);
                    throw new IOException(stringBuilder.toString());
                }
            }
            engineInit(bArr);
        }
    }

    public static class PSS extends AlgorithmParametersSpi {
        /* renamed from: a */
        PSSParameterSpec f27421a;

        protected String engineToString() {
            return "PSS Parameters";
        }

        protected byte[] engineGetEncoded() {
            PSSParameterSpec pSSParameterSpec = this.f27421a;
            return new RSASSAPSSparams(new AlgorithmIdentifier(DigestFactory.m28102b(pSSParameterSpec.getDigestAlgorithm()), DERNull.f32850a), new AlgorithmIdentifier(PKCSObjectIdentifiers.l_, new AlgorithmIdentifier(DigestFactory.m28102b(((MGF1ParameterSpec) pSSParameterSpec.getMGFParameters()).getDigestAlgorithm()), DERNull.f32850a)), new ASN1Integer((long) pSSParameterSpec.getSaltLength()), new ASN1Integer((long) pSSParameterSpec.getTrailerField())).m34596a("DER");
        }

        protected byte[] engineGetEncoded(String str) {
            if (!str.equalsIgnoreCase("X.509")) {
                if (str.equalsIgnoreCase("ASN.1") == null) {
                    return null;
                }
            }
            return engineGetEncoded();
        }

        /* renamed from: a */
        protected AlgorithmParameterSpec mo5862a(Class cls) {
            if (cls == PSSParameterSpec.class && this.f27421a != null) {
                return this.f27421a;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                this.f27421a = (PSSParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
        }

        protected void engineInit(byte[] r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r8 = org.spongycastle.asn1.pkcs.RSASSAPSSparams.m40148a(r8);	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r6 = new java.security.spec.PSSParameterSpec;	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r8.m40149a();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r0.m40230a();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r1 = r0.m42986b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r8.m40150b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r0.m40230a();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r2 = r0.m42986b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r3 = new java.security.spec.MGF1ParameterSpec;	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r8.m40150b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r0.m40231b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = org.spongycastle.asn1.x509.AlgorithmIdentifier.m40228a(r0);	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r0.m40230a();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r0.m42986b();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r3.<init>(r0);	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r8.m40151c();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r4 = r0.intValue();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r8 = r8.m40152d();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r5 = r8.intValue();	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0 = r6;	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            r7.f27421a = r6;	 Catch:{ ClassCastException -> 0x0056, ArrayIndexOutOfBoundsException -> 0x004e }
            return;
        L_0x004e:
            r8 = new java.io.IOException;
            r0 = "Not a valid PSS Parameter encoding.";
            r8.<init>(r0);
            throw r8;
        L_0x0056:
            r8 = new java.io.IOException;
            r0 = "Not a valid PSS Parameter encoding.";
            r8.<init>(r0);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi.PSS.engineInit(byte[]):void");
        }

        protected void engineInit(byte[] bArr, String str) {
            if (!m27978a(str)) {
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

    /* renamed from: a */
    protected abstract AlgorithmParameterSpec mo5862a(Class cls);

    /* renamed from: a */
    protected boolean m27978a(String str) {
        if (str != null) {
            if (str.equals("ASN.1") == null) {
                return null;
            }
        }
        return true;
    }

    protected AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
        if (cls != null) {
            return mo5862a(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }
}
