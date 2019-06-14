package com.RNFetchBlob;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: RNFetchBlobUtils */
/* renamed from: com.RNFetchBlob.h */
public class C0877h {

    /* compiled from: RNFetchBlobUtils */
    /* renamed from: com.RNFetchBlob.h$1 */
    static class C08751 implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        C08751() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* compiled from: RNFetchBlobUtils */
    /* renamed from: com.RNFetchBlob.h$2 */
    static class C08762 implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        C08762() {
        }
    }

    /* renamed from: a */
    public static java.lang.String m3119a(java.lang.String r8) {
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
        r0 = 0;
        r1 = "MD5";	 Catch:{ Exception -> 0x003a }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003a }
        r8 = r8.getBytes();	 Catch:{ Exception -> 0x003a }
        r1.update(r8);	 Catch:{ Exception -> 0x003a }
        r8 = r1.digest();	 Catch:{ Exception -> 0x003a }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x003a }
        r1.<init>();	 Catch:{ Exception -> 0x003a }
        r2 = r8.length;	 Catch:{ Exception -> 0x003a }
        r3 = 0;	 Catch:{ Exception -> 0x003a }
        r4 = 0;	 Catch:{ Exception -> 0x003a }
    L_0x001a:
        if (r4 >= r2) goto L_0x0035;	 Catch:{ Exception -> 0x003a }
    L_0x001c:
        r5 = r8[r4];	 Catch:{ Exception -> 0x003a }
        r6 = "%02x";	 Catch:{ Exception -> 0x003a }
        r7 = 1;	 Catch:{ Exception -> 0x003a }
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x003a }
        r5 = r5 & 255;	 Catch:{ Exception -> 0x003a }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x003a }
        r7[r3] = r5;	 Catch:{ Exception -> 0x003a }
        r5 = java.lang.String.format(r6, r7);	 Catch:{ Exception -> 0x003a }
        r1.append(r5);	 Catch:{ Exception -> 0x003a }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x003a }
        goto L_0x001a;	 Catch:{ Exception -> 0x003a }
    L_0x0035:
        r8 = r1.toString();	 Catch:{ Exception -> 0x003a }
        return r8;
    L_0x003a:
        r8 = move-exception;
        r8.printStackTrace();	 Catch:{ all -> 0x003e }
    L_0x003e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.h.a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static void m3120b(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", "warn");
        createMap.putString("detail", str);
        ((RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobMessage", createMap);
    }

    /* renamed from: a */
    public static C6243a m3118a(C7490w c7490w) {
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new C08751()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            c7490w = c7490w.y();
            c7490w.a(socketFactory);
            c7490w.a(new C08762());
            return c7490w;
        } catch (C7490w c7490w2) {
            throw new RuntimeException(c7490w2);
        }
    }
}
