package com.RNFetchBlob.p048a;

import com.facebook.react.bridge.ReactApplicationContext;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7497e;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: RNFetchBlobFileResp */
/* renamed from: com.RNFetchBlob.a.b */
public class C3352b extends ac {
    /* renamed from: g */
    static final /* synthetic */ boolean f8901g = (C3352b.class.desiredAssertionStatus() ^ 1);
    /* renamed from: a */
    String f8902a;
    /* renamed from: b */
    ac f8903b;
    /* renamed from: c */
    String f8904c;
    /* renamed from: d */
    long f8905d = 0;
    /* renamed from: e */
    ReactApplicationContext f8906e;
    /* renamed from: f */
    FileOutputStream f8907f;

    /* compiled from: RNFetchBlobFileResp */
    /* renamed from: com.RNFetchBlob.a.b$a */
    private class C3351a implements C6258s {
        /* renamed from: a */
        final /* synthetic */ C3352b f8900a;

        public C6259t timeout() {
            return null;
        }

        private C3351a(C3352b c3352b) {
            this.f8900a = c3352b;
        }

        public long read(expolib_v1.p332b.C8170c r11, long r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r10 = this;
            r11 = (int) r12;
            r12 = new byte[r11];	 Catch:{ Exception -> 0x008d }
            r13 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r13 = r13.f8903b;	 Catch:{ Exception -> 0x008d }
            r13 = r13.byteStream();	 Catch:{ Exception -> 0x008d }
            r0 = 0;	 Catch:{ Exception -> 0x008d }
            r11 = r13.read(r12, r0, r11);	 Catch:{ Exception -> 0x008d }
            r1 = (long) r11;	 Catch:{ Exception -> 0x008d }
            r11 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r3 = r11.f8905d;	 Catch:{ Exception -> 0x008d }
            r5 = 0;	 Catch:{ Exception -> 0x008d }
            r13 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x008d }
            if (r13 <= 0) goto L_0x001d;	 Catch:{ Exception -> 0x008d }
        L_0x001b:
            r7 = r1;	 Catch:{ Exception -> 0x008d }
            goto L_0x001e;	 Catch:{ Exception -> 0x008d }
        L_0x001d:
            r7 = r5;	 Catch:{ Exception -> 0x008d }
        L_0x001e:
            r9 = 0;	 Catch:{ Exception -> 0x008d }
            r3 = r3 + r7;	 Catch:{ Exception -> 0x008d }
            r11.f8905d = r3;	 Catch:{ Exception -> 0x008d }
            if (r13 <= 0) goto L_0x002c;	 Catch:{ Exception -> 0x008d }
        L_0x0024:
            r11 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r11 = r11.f8907f;	 Catch:{ Exception -> 0x008d }
            r13 = (int) r1;	 Catch:{ Exception -> 0x008d }
            r11.write(r12, r0, r13);	 Catch:{ Exception -> 0x008d }
        L_0x002c:
            r11 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r11 = r11.f8902a;	 Catch:{ Exception -> 0x008d }
            r11 = com.RNFetchBlob.C0874g.m3115b(r11);	 Catch:{ Exception -> 0x008d }
            if (r11 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
        L_0x0036:
            r12 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r12 = r12.contentLength();	 Catch:{ Exception -> 0x008d }
            r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x008d }
            if (r12 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
        L_0x0040:
            r12 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r12 = r12.f8905d;	 Catch:{ Exception -> 0x008d }
            r0 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r3 = r0.contentLength();	 Catch:{ Exception -> 0x008d }
            r12 = r12 / r3;	 Catch:{ Exception -> 0x008d }
            r12 = (float) r12;	 Catch:{ Exception -> 0x008d }
            r11 = r11.m3104a(r12);	 Catch:{ Exception -> 0x008d }
            if (r11 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
        L_0x0052:
            r11 = com.facebook.react.bridge.Arguments.createMap();	 Catch:{ Exception -> 0x008d }
            r12 = "taskId";	 Catch:{ Exception -> 0x008d }
            r13 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r13 = r13.f8902a;	 Catch:{ Exception -> 0x008d }
            r11.putString(r12, r13);	 Catch:{ Exception -> 0x008d }
            r12 = "written";	 Catch:{ Exception -> 0x008d }
            r13 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r3 = r13.f8905d;	 Catch:{ Exception -> 0x008d }
            r13 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x008d }
            r11.putString(r12, r13);	 Catch:{ Exception -> 0x008d }
            r12 = "total";	 Catch:{ Exception -> 0x008d }
            r13 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r3 = r13.contentLength();	 Catch:{ Exception -> 0x008d }
            r13 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x008d }
            r11.putString(r12, r13);	 Catch:{ Exception -> 0x008d }
            r12 = r10.f8900a;	 Catch:{ Exception -> 0x008d }
            r12 = r12.f8906e;	 Catch:{ Exception -> 0x008d }
            r13 = com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter.class;	 Catch:{ Exception -> 0x008d }
            r12 = r12.getJSModule(r13);	 Catch:{ Exception -> 0x008d }
            r12 = (com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r12;	 Catch:{ Exception -> 0x008d }
            r13 = "RNFetchBlobProgress";	 Catch:{ Exception -> 0x008d }
            r12.emit(r13, r11);	 Catch:{ Exception -> 0x008d }
        L_0x008c:
            return r1;
        L_0x008d:
            r11 = -1;
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.a.b.a.read(expolib_v1.b.c, long):long");
        }

        public void close() {
            this.f8900a.f8907f.close();
        }
    }

    public C3352b(ReactApplicationContext reactApplicationContext, String str, ac acVar, String str2, boolean z) {
        this.f8906e = reactApplicationContext;
        this.f8902a = str;
        this.f8903b = acVar;
        if (f8901g == null) {
            if (str2 == null) {
                throw new AssertionError();
            }
        }
        this.f8904c = str2;
        if (str2 != null) {
            reactApplicationContext = z ^ 1;
            str = str2.replace("?append=true", "");
            this.f8904c = str;
            acVar = new File(str);
            str2 = acVar.getParentFile();
            if (!str2.exists()) {
                if (!str2.mkdirs()) {
                    str = new StringBuilder();
                    str.append("Couldn't create dir: ");
                    str.append(str2);
                    throw new IllegalStateException(str.toString());
                }
            }
            if (acVar.exists() == null) {
                acVar.createNewFile();
            }
            this.f8907f = new FileOutputStream(new File(str), reactApplicationContext);
        }
    }

    public C6240u contentType() {
        return this.f8903b.contentType();
    }

    public long contentLength() {
        return this.f8903b.contentLength();
    }

    public C7497e source() {
        return C6252l.a(new C3351a());
    }
}
