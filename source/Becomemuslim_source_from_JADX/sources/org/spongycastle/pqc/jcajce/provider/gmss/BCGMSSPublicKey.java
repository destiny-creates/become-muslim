package org.spongycastle.pqc.jcajce.provider.gmss;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.security.PublicKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.GMSSPublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.ParSet;
import org.spongycastle.pqc.crypto.gmss.GMSSParameters;
import org.spongycastle.pqc.jcajce.provider.util.KeyUtil;
import org.spongycastle.util.encoders.Hex;

public class BCGMSSPublicKey implements PublicKey, CipherParameters {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private byte[] f27825a;
    /* renamed from: b */
    private GMSSParameters f27826b;

    public String getAlgorithm() {
        return "GMSS";
    }

    public String getFormat() {
        return "X.509";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GMSS public key : ");
        stringBuilder.append(new String(Hex.m29437a(this.f27825a)));
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append("Height of Trees: \n");
        String stringBuilder2 = stringBuilder.toString();
        for (int i = 0; i < this.f27826b.m29050b().length; i++) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append("Layer ");
            stringBuilder3.append(i);
            stringBuilder3.append(" : ");
            stringBuilder3.append(this.f27826b.m29050b()[i]);
            stringBuilder3.append(" WinternitzParameter: ");
            stringBuilder3.append(this.f27826b.m29051c()[i]);
            stringBuilder3.append(" K: ");
            stringBuilder3.append(this.f27826b.m29052d()[i]);
            stringBuilder3.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder3.toString();
        }
        return stringBuilder2;
    }

    public byte[] getEncoded() {
        return KeyUtil.m29166a(new AlgorithmIdentifier(PQCObjectIdentifiers.f23170g, new ParSet(this.f27826b.m29049a(), this.f27826b.m29050b(), this.f27826b.m29051c(), this.f27826b.m29052d()).mo5709e()), new GMSSPublicKey(this.f27825a));
    }
}
