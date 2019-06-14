package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class SymmetricAlgorithmProvider extends AlgorithmProvider {
    SymmetricAlgorithmProvider() {
    }

    /* renamed from: a */
    protected void m36091a(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mac.");
        stringBuilder.append(str);
        stringBuilder.append("-CMAC");
        configurableProvider.mo5883a(stringBuilder.toString(), str2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Mac.");
        str2.append(str);
        str2.append("CMAC");
        str2 = str2.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-CMAC");
        configurableProvider.mo5883a(str2, stringBuilder.toString());
        str2 = new StringBuilder();
        str2.append("KeyGenerator.");
        str2.append(str);
        str2.append("-CMAC");
        configurableProvider.mo5883a(str2.toString(), str3);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.KeyGenerator.");
        str2.append(str);
        str2.append("CMAC");
        str2 = str2.toString();
        str3 = new StringBuilder();
        str3.append(str);
        str3.append("-CMAC");
        configurableProvider.mo5883a(str2, str3.toString());
    }

    /* renamed from: b */
    protected void m36092b(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mac.");
        stringBuilder.append(str);
        stringBuilder.append("-GMAC");
        configurableProvider.mo5883a(stringBuilder.toString(), str2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Mac.");
        str2.append(str);
        str2.append("GMAC");
        str2 = str2.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-GMAC");
        configurableProvider.mo5883a(str2, stringBuilder.toString());
        str2 = new StringBuilder();
        str2.append("KeyGenerator.");
        str2.append(str);
        str2.append("-GMAC");
        configurableProvider.mo5883a(str2.toString(), str3);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.KeyGenerator.");
        str2.append(str);
        str2.append("GMAC");
        str2 = str2.toString();
        str3 = new StringBuilder();
        str3.append(str);
        str3.append("-GMAC");
        configurableProvider.mo5883a(str2, str3.toString());
    }

    /* renamed from: c */
    protected void m36093c(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mac.POLY1305-");
        stringBuilder.append(str);
        configurableProvider.mo5883a(stringBuilder.toString(), str2);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.Mac.POLY1305");
        str2.append(str);
        str2 = str2.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("POLY1305-");
        stringBuilder.append(str);
        configurableProvider.mo5883a(str2, stringBuilder.toString());
        str2 = new StringBuilder();
        str2.append("KeyGenerator.POLY1305-");
        str2.append(str);
        configurableProvider.mo5883a(str2.toString(), str3);
        str2 = new StringBuilder();
        str2.append("Alg.Alias.KeyGenerator.POLY1305");
        str2.append(str);
        str2 = str2.toString();
        str3 = new StringBuilder();
        str3.append("POLY1305-");
        str3.append(str);
        configurableProvider.mo5883a(str2, str3.toString());
    }
}
