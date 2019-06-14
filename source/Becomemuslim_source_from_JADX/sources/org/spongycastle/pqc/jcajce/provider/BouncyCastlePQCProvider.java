package org.spongycastle.pqc.jcajce.provider;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    /* renamed from: a */
    public static String f27820a = "BCPQC";
    /* renamed from: b */
    public static final ProviderConfiguration f27821b = null;
    /* renamed from: c */
    private static String f27822c = "BouncyCastle Post-Quantum Security Provider v1.52";
    /* renamed from: d */
    private static final Map f27823d = new HashMap();
    /* renamed from: e */
    private static final String[] f27824e = new String[]{"Rainbow", "McEliece"};

    /* renamed from: org.spongycastle.pqc.jcajce.provider.BouncyCastlePQCProvider$1 */
    class C66981 implements PrivilegedAction {
        /* renamed from: a */
        final /* synthetic */ BouncyCastlePQCProvider f23327a;

        C66981(BouncyCastlePQCProvider bouncyCastlePQCProvider) {
            this.f23327a = bouncyCastlePQCProvider;
        }

        public Object run() {
            this.f23327a.m36427a();
            return null;
        }
    }

    public BouncyCastlePQCProvider() {
        super(f27820a, 1.52d, f27822c);
        AccessController.doPrivileged(new C66981(this));
    }

    /* renamed from: a */
    private void m36427a() {
        m36428a("org.spongycastle.pqc.jcajce.provider.", f27824e);
    }

    /* renamed from: a */
    private void m36428a(java.lang.String r6, java.lang.String[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
    L_0x0001:
        r1 = r7.length;
        if (r0 == r1) goto L_0x007a;
    L_0x0004:
        r1 = 0;
        r2 = r5.getClass();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x0046 }
        if (r2 == 0) goto L_0x002b;	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x000f:
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r6);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r4 = r7[r0];	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r4 = "$Mappings";	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3.append(r4);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.loadClass(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x0029:
        r1 = r2;	 Catch:{ ClassNotFoundException -> 0x0046 }
        goto L_0x0046;	 Catch:{ ClassNotFoundException -> 0x0046 }
    L_0x002b:
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r6);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = r7[r0];	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r3 = "$Mappings";	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0046 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0046 }
        goto L_0x0029;
    L_0x0046:
        if (r1 == 0) goto L_0x0077;
    L_0x0048:
        r1 = r1.newInstance();	 Catch:{ Exception -> 0x0052 }
        r1 = (org.spongycastle.jcajce.provider.util.AlgorithmProvider) r1;	 Catch:{ Exception -> 0x0052 }
        r1.mo5864a(r5);	 Catch:{ Exception -> 0x0052 }
        goto L_0x0077;
    L_0x0052:
        r1 = move-exception;
        r2 = new java.lang.InternalError;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "cannot create instance of ";
        r3.append(r4);
        r3.append(r6);
        r6 = r7[r0];
        r3.append(r6);
        r6 = "$Mappings : ";
        r3.append(r6);
        r3.append(r1);
        r6 = r3.toString();
        r2.<init>(r6);
        throw r2;
    L_0x0077:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x007a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.jcajce.provider.BouncyCastlePQCProvider.a(java.lang.String, java.lang.String[]):void");
    }

    /* renamed from: b */
    public boolean mo5886b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        if (!containsKey(stringBuilder.toString())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.");
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(str2);
            if (containsKey(stringBuilder.toString()) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo5883a(String str, String str2) {
        if (containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("duplicate provider key (");
            stringBuilder.append(str);
            stringBuilder.append(") found");
            throw new IllegalStateException(stringBuilder.toString());
        }
        put(str, str2);
    }

    /* renamed from: a */
    public void mo5884a(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        if (containsKey(stringBuilder.toString())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".");
            stringBuilder.append(aSN1ObjectIdentifier);
            mo5883a(stringBuilder.toString(), str2);
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".OID.");
            stringBuilder.append(aSN1ObjectIdentifier);
            mo5883a(stringBuilder.toString(), str2);
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("primary key (");
        stringBuilder.append(str);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        stringBuilder.append(") not found");
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: a */
    public void mo5885a(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        f27823d.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }
}
