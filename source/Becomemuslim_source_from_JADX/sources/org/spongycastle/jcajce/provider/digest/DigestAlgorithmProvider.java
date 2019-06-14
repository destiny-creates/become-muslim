package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class DigestAlgorithmProvider extends AlgorithmProvider {
    DigestAlgorithmProvider() {
    }

    /* renamed from: a */
    protected void m36031a(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HMAC");
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Mac.");
        stringBuilder3.append(stringBuilder2);
        configurableProvider.mo5883a(stringBuilder3.toString(), str2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Mac.HMAC-");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Mac.HMAC/");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str2 = new StringBuilder();
        str2.append("KeyGenerator.");
        str2.append(stringBuilder2);
        configurableProvider.mo5883a(str2.toString(), str3);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.KeyGenerator.HMAC-");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.KeyGenerator.HMAC/");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
    }

    /* renamed from: a */
    protected void m36032a(ConfigurableProvider configurableProvider, String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HMAC");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.Mac.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.KeyGenerator.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
    }
}
