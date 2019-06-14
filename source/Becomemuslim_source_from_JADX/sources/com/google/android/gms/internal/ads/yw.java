package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class yw<T_WRAPPER extends yx<T_ENGINE>, T_ENGINE> {
    /* renamed from: a */
    public static final yw<yz, Cipher> f16111a = new yw(new yz());
    /* renamed from: b */
    public static final yw<zd, Mac> f16112b = new yw(new zd());
    /* renamed from: c */
    public static final yw<za, KeyAgreement> f16113c = new yw(new za());
    /* renamed from: d */
    public static final yw<zc, KeyPairGenerator> f16114d = new yw(new zc());
    /* renamed from: e */
    public static final yw<zb, KeyFactory> f16115e = new yw(new zb());
    /* renamed from: f */
    private static final Logger f16116f = Logger.getLogger(yw.class.getName());
    /* renamed from: g */
    private static final List<Provider> f16117g;
    /* renamed from: h */
    private static final yw<zf, Signature> f16118h = new yw(new zf());
    /* renamed from: i */
    private static final yw<ze, MessageDigest> f16119i = new yw(new ze());
    /* renamed from: j */
    private T_WRAPPER f16120j;
    /* renamed from: k */
    private List<Provider> f16121k = f16117g;
    /* renamed from: l */
    private boolean f16122l = true;

    static {
        if (zo.m20199a()) {
            String[] strArr = new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL"};
            List arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                Provider provider = Security.getProvider(strArr[i]);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f16116f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{r4}));
                }
            }
            f16117g = arrayList;
        } else {
            f16117g = new ArrayList();
        }
    }

    private yw(T_WRAPPER t_wrapper) {
        this.f16120j = t_wrapper;
    }

    /* renamed from: a */
    private final boolean m20183a(java.lang.String r2, java.security.Provider r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.f16120j;	 Catch:{ Exception -> 0x0007 }
        r0.mo4392a(r2, r3);	 Catch:{ Exception -> 0x0007 }
        r2 = 1;
        return r2;
    L_0x0007:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.yw.a(java.lang.String, java.security.Provider):boolean");
    }

    /* renamed from: a */
    public final T_ENGINE m20184a(String str) {
        Provider provider;
        for (Provider provider2 : this.f16121k) {
            if (m20183a(str, provider2)) {
                yx yxVar = this.f16120j;
                break;
            }
        }
        if (this.f16122l) {
            yxVar = this.f16120j;
            provider2 = null;
            return yxVar.mo4392a(str, provider2);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
