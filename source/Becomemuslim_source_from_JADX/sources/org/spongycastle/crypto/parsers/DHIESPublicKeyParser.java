package org.spongycastle.crypto.parsers;

import java.io.InputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class DHIESPublicKeyParser implements KeyParser {
    /* renamed from: a */
    private DHParameters f27150a;

    public DHIESPublicKeyParser(DHParameters dHParameters) {
        this.f27150a = dHParameters;
    }

    /* renamed from: a */
    public AsymmetricKeyParameter mo5787a(InputStream inputStream) {
        byte[] bArr = new byte[((this.f27150a.m35638a().bitLength() + 7) / 8)];
        inputStream.read(bArr, 0, bArr.length);
        return new DHPublicKeyParameters(new BigInteger(1, bArr), this.f27150a);
    }
}
