package org.spongycastle.jcajce.provider.util;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    /* renamed from: a */
    protected void m36123a(ConfigurableProvider configurableProvider, String str, String str2, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("WITH");
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append("with");
        stringBuilder3.append(str2);
        String stringBuilder4 = stringBuilder3.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(str);
        stringBuilder5.append("With");
        stringBuilder5.append(str2);
        String stringBuilder6 = stringBuilder5.toString();
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(str);
        stringBuilder7.append("/");
        stringBuilder7.append(str2);
        str = stringBuilder7.toString();
        str2 = new StringBuilder();
        str2.append("Signature.");
        str2.append(stringBuilder2);
        configurableProvider.mo5883a(str2.toString(), str3);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Signature.");
        str2.append(stringBuilder4);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Signature.");
        str2.append(stringBuilder6);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Signature.");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), stringBuilder2);
        str = new StringBuilder();
        str.append("Alg.Alias.Signature.");
        str.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(str.toString(), stringBuilder2);
        str = new StringBuilder();
        str.append("Alg.Alias.Signature.OID.");
        str.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(str.toString(), stringBuilder2);
    }

    /* renamed from: a */
    protected void m36125a(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.KeyFactory.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.KeyPairGenerator.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
        configurableProvider.mo5885a(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    /* renamed from: a */
    protected void m36124a(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.AlgorithmParameterGenerator.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Alg.Alias.AlgorithmParameters.");
        stringBuilder.append(aSN1ObjectIdentifier);
        configurableProvider.mo5883a(stringBuilder.toString(), str);
    }
}
