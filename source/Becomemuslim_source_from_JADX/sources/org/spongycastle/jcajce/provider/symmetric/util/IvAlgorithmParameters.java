package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.util.Arrays;

public class IvAlgorithmParameters extends BaseAlgorithmParameters {
    /* renamed from: a */
    private byte[] f27507a;

    protected String engineToString() {
        return "IV Parameters";
    }

    protected byte[] engineGetEncoded() {
        return engineGetEncoded("ASN.1");
    }

    protected byte[] engineGetEncoded(String str) {
        if (m28078a(str)) {
            return new DEROctetString(engineGetEncoded("RAW")).mo6822f();
        }
        return str.equals("RAW") != null ? Arrays.m29373b(this.f27507a) : null;
    }

    /* renamed from: a */
    protected AlgorithmParameterSpec mo5855a(Class cls) {
        if (cls == IvParameterSpec.class) {
            return new IvParameterSpec(this.f27507a);
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    }

    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.f27507a = ((IvParameterSpec) algorithmParameterSpec).getIV();
            return;
        }
        throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
    }

    protected void engineInit(byte[] bArr) {
        if (bArr.length % 8 != 0 && bArr[0] == (byte) 4 && bArr[1] == bArr.length - 2) {
            bArr = ((ASN1OctetString) ASN1Primitive.m39798b(bArr)).mo6859c();
        }
        this.f27507a = Arrays.m29373b(bArr);
    }

    protected void engineInit(byte[] bArr, String str) {
        if (m28078a(str)) {
            try {
                engineInit(((ASN1OctetString) ASN1Primitive.m39798b(bArr)).mo6859c());
            } catch (byte[] bArr2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception decoding: ");
                stringBuilder.append(bArr2);
                throw new IOException(stringBuilder.toString());
            }
        } else if (str.equals("RAW") != null) {
            engineInit(bArr2);
        } else {
            throw new IOException("Unknown parameters format in IV parameters object");
        }
    }
}
