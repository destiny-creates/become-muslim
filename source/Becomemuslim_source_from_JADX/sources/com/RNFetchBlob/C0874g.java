package com.RNFetchBlob;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.network.TLSSocketFactory;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6224j;
import expolib_v1.p321a.C6226k;
import expolib_v1.p321a.C6226k.C6225a;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ae;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

/* compiled from: RNFetchBlobReq */
/* renamed from: com.RNFetchBlob.g */
public class C0874g extends BroadcastReceiver implements Runnable {
    /* renamed from: a */
    public static HashMap<String, C6216e> f2449a = new HashMap();
    /* renamed from: b */
    static HashMap<String, C0869f> f2450b = new HashMap();
    /* renamed from: c */
    static HashMap<String, C0869f> f2451c = new HashMap();
    /* renamed from: d */
    static C6224j f2452d = new C6224j();
    /* renamed from: e */
    ReactApplicationContext f2453e;
    /* renamed from: f */
    C0862b f2454f;
    /* renamed from: g */
    String f2455g;
    /* renamed from: h */
    String f2456h;
    /* renamed from: i */
    String f2457i;
    /* renamed from: j */
    String f2458j;
    /* renamed from: k */
    String f2459k;
    /* renamed from: l */
    ReadableArray f2460l;
    /* renamed from: m */
    ReadableMap f2461m;
    /* renamed from: n */
    Callback f2462n;
    /* renamed from: o */
    long f2463o;
    /* renamed from: p */
    long f2464p;
    /* renamed from: q */
    C3353a f2465q;
    /* renamed from: r */
    C0871a f2466r;
    /* renamed from: s */
    C0873c f2467s;
    /* renamed from: t */
    C0872b f2468t = C0872b.Auto;
    /* renamed from: u */
    WritableMap f2469u;
    /* renamed from: v */
    boolean f2470v = false;
    /* renamed from: w */
    ArrayList<String> f2471w = new ArrayList();
    /* renamed from: x */
    C7490w f2472x;

    /* compiled from: RNFetchBlobReq */
    /* renamed from: com.RNFetchBlob.g$a */
    enum C0871a {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    /* compiled from: RNFetchBlobReq */
    /* renamed from: com.RNFetchBlob.g$b */
    enum C0872b {
        Auto,
        UTF8,
        BASE64
    }

    /* compiled from: RNFetchBlobReq */
    /* renamed from: com.RNFetchBlob.g$c */
    enum C0873c {
        KeepInMemory,
        FileStorage
    }

    /* compiled from: RNFetchBlobReq */
    /* renamed from: com.RNFetchBlob.g$1 */
    class C33551 implements C6239s {
        /* renamed from: a */
        final /* synthetic */ C0874g f8918a;

        C33551(C0874g c0874g) {
            this.f8918a = c0874g;
        }

        public ab intercept(C6238a c6238a) {
            this.f8918a.f2471w.add(c6238a.a().a().toString());
            return c6238a.a(c6238a.a());
        }
    }

    /* compiled from: RNFetchBlobReq */
    /* renamed from: com.RNFetchBlob.g$3 */
    class C33573 implements C6217f {
        /* renamed from: a */
        final /* synthetic */ C0874g f8921a;

        C33573(C0874g c0874g) {
            this.f8921a = c0874g;
        }

        public void onFailure(C6216e c6216e, IOException iOException) {
            C0874g.m3114a(this.f8921a.f2455g);
            if (this.f8921a.f2469u == null) {
                this.f8921a.f2469u = Arguments.createMap();
            }
            if (iOException.getClass().equals(SocketTimeoutException.class) != null) {
                this.f8921a.f2469u.putBoolean("timeout", true);
                this.f8921a.f2462n.invoke(new Object[]{"request timed out.", null, null});
            } else {
                this.f8921a.f2462n.invoke(iOException.getLocalizedMessage(), null, null);
            }
            this.f8921a.m3109a();
        }

        public void onResponse(C6216e c6216e, ab abVar) {
            c6216e = this.f8921a.f2454f.f2404d;
            if (c6216e != null) {
                String str = "";
                String str2 = "";
                String str3 = "text/plain";
                if (c6216e.hasKey("title")) {
                    str = this.f8921a.f2454f.f2404d.getString("title");
                }
                String str4 = str;
                if (c6216e.hasKey("description")) {
                    str2 = c6216e.getString("description");
                }
                String str5 = str2;
                if (c6216e.hasKey("mime")) {
                    str3 = c6216e.getString("mime");
                }
                String str6 = str3;
                boolean z = c6216e.hasKey("mediaScannable") ? c6216e.getBoolean("mediaScannable") : false;
                boolean z2 = c6216e.hasKey("notification") ? c6216e.getBoolean("notification") : false;
                c6216e = RNFetchBlob.RCTContext;
                ReactApplicationContext reactApplicationContext = RNFetchBlob.RCTContext;
                ((DownloadManager) c6216e.getSystemService("download")).addCompletedDownload(str4, str5, z, str6, this.f8921a.f2459k, this.f8921a.f2463o, z2);
            }
            this.f8921a.m3113a(abVar);
        }
    }

    public C0874g(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, C7490w c7490w, Callback callback) {
        this.f2456h = str2.toUpperCase();
        this.f2454f = new C0862b(readableMap);
        this.f2455g = str;
        this.f2457i = str3;
        this.f2461m = readableMap2;
        this.f2462n = callback;
        this.f2458j = str4;
        this.f2460l = readableArray;
        this.f2472x = c7490w;
        if (this.f2454f.f2401a.booleanValue() == null) {
            if (this.f2454f.f2402b == null) {
                this.f2467s = C0873c.KeepInMemory;
                if (str4 != null) {
                    this.f2466r = C0871a.SingleFile;
                } else if (readableArray == null) {
                    this.f2466r = C0871a.Form;
                } else {
                    this.f2466r = C0871a.WithoutBody;
                }
            }
        }
        this.f2467s = C0873c.FileStorage;
        if (str4 != null) {
            this.f2466r = C0871a.SingleFile;
        } else if (readableArray == null) {
            this.f2466r = C0871a.WithoutBody;
        } else {
            this.f2466r = C0871a.Form;
        }
    }

    /* renamed from: a */
    public static void m3114a(String str) {
        if (f2449a.containsKey(str)) {
            ((C6216e) f2449a.get(str)).c();
            f2449a.remove(str);
        }
    }

    public void run() {
        if (this.f2454f.f2404d != null && this.f2454f.f2404d.hasKey("useDownloadManager") && this.f2454f.f2404d.getBoolean("useDownloadManager")) {
            Request request = new Request(Uri.parse(this.f2457i));
            request.setNotificationVisibility(1);
            if (this.f2454f.f2404d.hasKey("title")) {
                request.setTitle(this.f2454f.f2404d.getString("title"));
            }
            if (this.f2454f.f2404d.hasKey("description")) {
                request.setDescription(this.f2454f.f2404d.getString("description"));
            }
            if (this.f2454f.f2404d.hasKey("path")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("file://");
                stringBuilder.append(this.f2454f.f2404d.getString("path"));
                request.setDestinationUri(Uri.parse(stringBuilder.toString()));
            }
            if (this.f2454f.f2404d.hasKey("mime")) {
                request.setMimeType(this.f2454f.f2404d.getString("mime"));
            }
            ReadableMapKeySetIterator keySetIterator = this.f2461m.keySetIterator();
            if (this.f2454f.f2404d.hasKey("mediaScannable") && this.f2454f.f2404d.hasKey("mediaScannable")) {
                request.allowScanningByMediaScanner();
            }
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                request.addRequestHeader(nextKey, this.f2461m.getString(nextKey));
            }
            Context applicationContext = RNFetchBlob.RCTContext.getApplicationContext();
            this.f2464p = ((DownloadManager) applicationContext.getSystemService("download")).enqueue(request);
            applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            return;
        }
        String str;
        StringBuilder stringBuilder2;
        String str2 = this.f2455g;
        if (this.f2454f.f2403c.isEmpty()) {
            str = "";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(".");
            stringBuilder3.append(this.f2454f.f2403c);
            str = stringBuilder3.toString();
        }
        if (this.f2454f.f2406f != null) {
            str2 = C0877h.m3119a(this.f2454f.f2406f);
            if (str2 == null) {
                str2 = this.f2455g;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(C0867d.m3072a(RNFetchBlob.RCTContext, str2));
            stringBuilder2.append(str);
            if (new File(stringBuilder2.toString()).exists()) {
                this.f2462n.invoke(null, "path", r3.getAbsolutePath());
                return;
            }
        }
        if (this.f2454f.f2402b != null) {
            this.f2459k = this.f2454f.f2402b;
        } else if (this.f2454f.f2401a.booleanValue()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(C0867d.m3072a(RNFetchBlob.RCTContext, str2));
            stringBuilder4.append(str);
            this.f2459k = stringBuilder4.toString();
        }
        try {
            C6243a a;
            boolean equalsIgnoreCase;
            String stringBuilder5;
            C3353a a2;
            final C6246z b;
            C6216e a3;
            if (this.f2454f.f2405e.booleanValue()) {
                a = C0877h.m3118a(this.f2472x);
            } else {
                a = this.f2472x.y();
            }
            C6245a c6245a = new C6245a();
            try {
                c6245a.a(new URL(this.f2457i));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            if (this.f2461m != null) {
                ReadableMapKeySetIterator keySetIterator2 = this.f2461m.keySetIterator();
                while (keySetIterator2.hasNextKey()) {
                    String nextKey2 = keySetIterator2.nextKey();
                    String string = this.f2461m.getString(nextKey2);
                    if (!nextKey2.equalsIgnoreCase("RNFB-Response")) {
                        c6245a.a(nextKey2.toLowerCase(), string);
                        hashMap.put(nextKey2.toLowerCase(), string);
                    } else if (string.equalsIgnoreCase(Results.BASE_64)) {
                        this.f2468t = C0872b.BASE64;
                    } else if (string.equalsIgnoreCase("utf8")) {
                        this.f2468t = C0872b.UTF8;
                    }
                }
            }
            if (!(this.f2456h.equalsIgnoreCase("post") || this.f2456h.equalsIgnoreCase("put"))) {
                if (!this.f2456h.equalsIgnoreCase("patch")) {
                    this.f2466r = C0871a.WithoutBody;
                    equalsIgnoreCase = m3108a(hashMap, "Transfer-Encoding").equalsIgnoreCase("chunked");
                    switch (this.f2466r) {
                        case SingleFile:
                            this.f2465q = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10659a(this.f2458j).m10658a(C6240u.a(m3108a(hashMap, "content-type")));
                            c6245a.a(this.f2456h, this.f2465q);
                            break;
                        case AsIs:
                            this.f2465q = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10659a(this.f2458j).m10658a(C6240u.a(m3108a(hashMap, "content-type")));
                            c6245a.a(this.f2456h, this.f2465q);
                            break;
                        case Form:
                            stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("RNFetchBlob-");
                            stringBuilder4.append(this.f2455g);
                            stringBuilder5 = stringBuilder4.toString();
                            a2 = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10657a(this.f2460l);
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("multipart/form-data; boundary=");
                            stringBuilder2.append(stringBuilder5);
                            this.f2465q = a2.m10658a(C6240u.a(stringBuilder2.toString()));
                            c6245a.a(this.f2456h, this.f2465q);
                            break;
                        case WithoutBody:
                            if (!(this.f2456h.equalsIgnoreCase("post") || this.f2456h.equalsIgnoreCase("put"))) {
                                if (!this.f2456h.equalsIgnoreCase("patch")) {
                                    c6245a.a(this.f2456h, null);
                                    break;
                                }
                            }
                            c6245a.a(this.f2456h, aa.create(null, new byte[0]));
                            break;
                        default:
                            break;
                    }
                    b = c6245a.b();
                    a.b(new C33551(this));
                    a.a(new C6239s(this) {
                        /* renamed from: b */
                        final /* synthetic */ C0874g f8920b;

                        public expolib_v1.p321a.ab intercept(expolib_v1.p321a.C6239s.C6238a r10) {
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
                            r9 = this;
                            r0 = 1;
                            r1 = r2;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r1 = r10.a(r1);	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r2 = com.RNFetchBlob.C0874g.C08704.f2435b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r3.f2467s;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r3.ordinal();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r2 = r2[r3];	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            switch(r2) {
                                case 1: goto L_0x0038;
                                case 2: goto L_0x0019;
                                default: goto L_0x0016;
                            };	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                        L_0x0016:
                            r2 = new com.RNFetchBlob.a.a;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            goto L_0x0052;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                        L_0x0019:
                            r2 = new com.RNFetchBlob.a.b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r4 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r5 = r3.f2455g;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r1.h();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r7 = r3.f2459k;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r3.f2454f;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r3.f2409i;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r8 = r3.booleanValue();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = r2;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            goto L_0x0069;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                        L_0x0038:
                            r2 = new com.RNFetchBlob.a.a;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r3 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r4 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r4 = r4.f2455g;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r5 = r1.h();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.f2454f;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.f2411k;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.booleanValue();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r2.<init>(r3, r4, r5, r6);	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            goto L_0x0069;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                        L_0x0052:
                            r3 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r4 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r4 = r4.f2455g;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r5 = r1.h();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r9.f8920b;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.f2454f;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.f2411k;	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r6 = r6.booleanValue();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r2.<init>(r3, r4, r5, r6);	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                        L_0x0069:
                            r1 = r1.i();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r1 = r1.a(r2);	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            r1 = r1.a();	 Catch:{ SocketException -> 0x0094, SocketTimeoutException -> 0x0076, Exception -> 0x0098 }
                            return r1;
                        L_0x0076:
                            r1 = move-exception;
                            r2 = r9.f8920b;
                            r2.f2470v = r0;
                            r0 = new java.lang.StringBuilder;
                            r0.<init>();
                            r2 = "RNFetchBlob error when sending request : ";
                            r0.append(r2);
                            r1 = r1.getLocalizedMessage();
                            r0.append(r1);
                            r0 = r0.toString();
                            com.RNFetchBlob.C0877h.m3120b(r0);
                            goto L_0x0098;
                        L_0x0094:
                            r1 = r9.f8920b;
                            r1.f2470v = r0;
                        L_0x0098:
                            r0 = r10.a();
                            r10 = r10.a(r0);
                            return r10;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.g.2.intercept(expolib_v1.a.s$a):expolib_v1.a.ab");
                        }
                    });
                    if (this.f2454f.f2410j >= 0) {
                        a.a(this.f2454f.f2410j, TimeUnit.MILLISECONDS);
                        a.b(this.f2454f.f2410j, TimeUnit.MILLISECONDS);
                    }
                    a.a(f2452d);
                    a.c(false);
                    a.b(this.f2454f.f2412l.booleanValue());
                    a.a(this.f2454f.f2412l.booleanValue());
                    a.c(true);
                    a3 = C0874g.m3106a(a).a().a(b);
                    f2449a.put(this.f2455g, a3);
                    a3.a(new C33573(this));
                }
            }
            String toLowerCase = m3108a(hashMap, HttpHeaders.CONTENT_TYPE).toLowerCase();
            if (this.f2460l != null) {
                this.f2466r = C0871a.Form;
            } else if (toLowerCase.isEmpty()) {
                c6245a.a(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
                this.f2466r = C0871a.SingleFile;
            }
            if (this.f2458j != null) {
                if (this.f2458j.startsWith("RNFetchBlob-file://")) {
                    this.f2466r = C0871a.SingleFile;
                } else {
                    if (!toLowerCase.toLowerCase().contains(";base64")) {
                        if (!toLowerCase.toLowerCase().startsWith("application/octet")) {
                            this.f2466r = C0871a.AsIs;
                        }
                    }
                    toLowerCase = toLowerCase.replace(";base64", "").replace(";BASE64", "");
                    if (hashMap.containsKey("content-type")) {
                        hashMap.put("content-type", toLowerCase);
                    }
                    if (hashMap.containsKey(HttpHeaders.CONTENT_TYPE)) {
                        hashMap.put(HttpHeaders.CONTENT_TYPE, toLowerCase);
                    }
                    this.f2466r = C0871a.SingleFile;
                }
            }
            equalsIgnoreCase = m3108a(hashMap, "Transfer-Encoding").equalsIgnoreCase("chunked");
            switch (this.f2466r) {
                case SingleFile:
                    this.f2465q = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10659a(this.f2458j).m10658a(C6240u.a(m3108a(hashMap, "content-type")));
                    c6245a.a(this.f2456h, this.f2465q);
                    break;
                case AsIs:
                    this.f2465q = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10659a(this.f2458j).m10658a(C6240u.a(m3108a(hashMap, "content-type")));
                    c6245a.a(this.f2456h, this.f2465q);
                    break;
                case Form:
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("RNFetchBlob-");
                    stringBuilder4.append(this.f2455g);
                    stringBuilder5 = stringBuilder4.toString();
                    a2 = new C3353a(this.f2455g).m10660a(equalsIgnoreCase).m10656a(this.f2466r).m10657a(this.f2460l);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("multipart/form-data; boundary=");
                    stringBuilder2.append(stringBuilder5);
                    this.f2465q = a2.m10658a(C6240u.a(stringBuilder2.toString()));
                    c6245a.a(this.f2456h, this.f2465q);
                    break;
                case WithoutBody:
                    if (!this.f2456h.equalsIgnoreCase("patch")) {
                        c6245a.a(this.f2456h, aa.create(null, new byte[0]));
                        break;
                    } else {
                        c6245a.a(this.f2456h, null);
                        break;
                    }
                    break;
                default:
                    break;
            }
            b = c6245a.b();
            a.b(new C33551(this));
            a.a(/* anonymous class already generated */);
            if (this.f2454f.f2410j >= 0) {
                a.a(this.f2454f.f2410j, TimeUnit.MILLISECONDS);
                a.b(this.f2454f.f2410j, TimeUnit.MILLISECONDS);
            }
            a.a(f2452d);
            a.c(false);
            a.b(this.f2454f.f2412l.booleanValue());
            a.a(this.f2454f.f2412l.booleanValue());
            a.c(true);
            a3 = C0874g.m3106a(a).a().a(b);
            f2449a.put(this.f2455g, a3);
            a3.a(new C33573(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            m3109a();
            Callback callback = this.f2462n;
            Object[] objArr = new Object[1];
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("RNFetchBlob request error: ");
            stringBuilder4.append(e2.getMessage());
            stringBuilder4.append(e2.getCause());
            objArr[0] = stringBuilder4.toString();
            callback.invoke(objArr);
        }
    }

    /* renamed from: a */
    private void m3109a() {
        if (f2449a.containsKey(this.f2455g)) {
            f2449a.remove(this.f2455g);
        }
        if (f2451c.containsKey(this.f2455g)) {
            f2451c.remove(this.f2455g);
        }
        if (f2450b.containsKey(this.f2455g)) {
            f2450b.remove(this.f2455g);
        }
        if (this.f2465q != null) {
            this.f2465q.m10661a();
        }
    }

    /* renamed from: a */
    private void m3113a(expolib_v1.p321a.ab r12) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r11 = this;
        r0 = r11.m3116b(r12);
        r1 = r11.m3105a(r12, r0);
        r11.m3112a(r1);
        r1 = com.RNFetchBlob.C0874g.C08704.f2435b;
        r2 = r11.f2467s;
        r2 = r2.ordinal();
        r1 = r1[r2];
        r2 = 3;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r6 = 2;
        switch(r1) {
            case 1: goto L_0x0047;
            case 2: goto L_0x0021;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r11.f2462n;	 Catch:{ IOException -> 0x0139 }
        goto L_0x011c;
    L_0x0021:
        r0 = r12.h();	 Catch:{ Exception -> 0x0028 }
        r0.bytes();	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        r0 = r11.f2459k;
        r1 = "?append=true";
        r7 = "";
        r0 = r0.replace(r1, r7);
        r11.f2459k = r0;
        r0 = r11.f2462n;
        r1 = new java.lang.Object[r2];
        r1[r5] = r3;
        r2 = "path";
        r1[r4] = r2;
        r2 = r11.f2459k;
        r1[r6] = r2;
        r0.invoke(r1);
        goto L_0x0146;
    L_0x0047:
        if (r0 == 0) goto L_0x0096;
    L_0x0049:
        r0 = r11.f2454f;	 Catch:{ IOException -> 0x010e }
        r0 = r0.f2408h;	 Catch:{ IOException -> 0x010e }
        r0 = r0.booleanValue();	 Catch:{ IOException -> 0x010e }
        if (r0 == 0) goto L_0x0096;	 Catch:{ IOException -> 0x010e }
    L_0x0053:
        r0 = r11.f2453e;	 Catch:{ IOException -> 0x010e }
        r1 = r11.f2455g;	 Catch:{ IOException -> 0x010e }
        r0 = com.RNFetchBlob.C0867d.m3072a(r0, r1);	 Catch:{ IOException -> 0x010e }
        r1 = r12.h();	 Catch:{ IOException -> 0x010e }
        r1 = r1.byteStream();	 Catch:{ IOException -> 0x010e }
        r7 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x010e }
        r8 = new java.io.File;	 Catch:{ IOException -> 0x010e }
        r8.<init>(r0);	 Catch:{ IOException -> 0x010e }
        r7.<init>(r8);	 Catch:{ IOException -> 0x010e }
        r8 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;	 Catch:{ IOException -> 0x010e }
        r8 = new byte[r8];	 Catch:{ IOException -> 0x010e }
    L_0x0071:
        r9 = r1.read(r8);	 Catch:{ IOException -> 0x010e }
        r10 = -1;	 Catch:{ IOException -> 0x010e }
        if (r9 == r10) goto L_0x007c;	 Catch:{ IOException -> 0x010e }
    L_0x0078:
        r7.write(r8, r5, r9);	 Catch:{ IOException -> 0x010e }
        goto L_0x0071;	 Catch:{ IOException -> 0x010e }
    L_0x007c:
        r1.close();	 Catch:{ IOException -> 0x010e }
        r7.flush();	 Catch:{ IOException -> 0x010e }
        r7.close();	 Catch:{ IOException -> 0x010e }
        r1 = r11.f2462n;	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x010e }
        r2[r5] = r3;	 Catch:{ IOException -> 0x010e }
        r7 = "path";	 Catch:{ IOException -> 0x010e }
        r2[r4] = r7;	 Catch:{ IOException -> 0x010e }
        r2[r6] = r0;	 Catch:{ IOException -> 0x010e }
        r1.invoke(r2);	 Catch:{ IOException -> 0x010e }
        goto L_0x0146;	 Catch:{ IOException -> 0x010e }
    L_0x0096:
        r0 = r12.h();	 Catch:{ IOException -> 0x010e }
        r0 = r0.bytes();	 Catch:{ IOException -> 0x010e }
        r1 = "UTF-8";	 Catch:{ IOException -> 0x010e }
        r1 = java.nio.charset.Charset.forName(r1);	 Catch:{ IOException -> 0x010e }
        r1 = r1.newEncoder();	 Catch:{ IOException -> 0x010e }
        r7 = r11.f2468t;	 Catch:{ IOException -> 0x010e }
        r8 = com.RNFetchBlob.C0874g.C0872b.BASE64;	 Catch:{ IOException -> 0x010e }
        if (r7 != r8) goto L_0x00c2;	 Catch:{ IOException -> 0x010e }
    L_0x00ae:
        r1 = r11.f2462n;	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x010e }
        r2[r5] = r3;	 Catch:{ IOException -> 0x010e }
        r7 = "base64";	 Catch:{ IOException -> 0x010e }
        r2[r4] = r7;	 Catch:{ IOException -> 0x010e }
        r0 = android.util.Base64.encodeToString(r0, r6);	 Catch:{ IOException -> 0x010e }
        r2[r6] = r0;	 Catch:{ IOException -> 0x010e }
        r1.invoke(r2);	 Catch:{ IOException -> 0x010e }
        return;
    L_0x00c2:
        r7 = java.nio.ByteBuffer.wrap(r0);	 Catch:{ CharacterCodingException -> 0x00e2 }
        r7 = r7.asCharBuffer();	 Catch:{ CharacterCodingException -> 0x00e2 }
        r1.encode(r7);	 Catch:{ CharacterCodingException -> 0x00e2 }
        r1 = new java.lang.String;	 Catch:{ CharacterCodingException -> 0x00e2 }
        r1.<init>(r0);	 Catch:{ CharacterCodingException -> 0x00e2 }
        r7 = r11.f2462n;	 Catch:{ CharacterCodingException -> 0x00e2 }
        r8 = new java.lang.Object[r2];	 Catch:{ CharacterCodingException -> 0x00e2 }
        r8[r5] = r3;	 Catch:{ CharacterCodingException -> 0x00e2 }
        r9 = "utf8";	 Catch:{ CharacterCodingException -> 0x00e2 }
        r8[r4] = r9;	 Catch:{ CharacterCodingException -> 0x00e2 }
        r8[r6] = r1;	 Catch:{ CharacterCodingException -> 0x00e2 }
        r7.invoke(r8);	 Catch:{ CharacterCodingException -> 0x00e2 }
        goto L_0x0146;
    L_0x00e2:
        r1 = r11.f2468t;	 Catch:{ IOException -> 0x010e }
        r7 = com.RNFetchBlob.C0874g.C0872b.UTF8;	 Catch:{ IOException -> 0x010e }
        if (r1 != r7) goto L_0x00fa;	 Catch:{ IOException -> 0x010e }
    L_0x00e8:
        r0 = r11.f2462n;	 Catch:{ IOException -> 0x010e }
        r1 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x010e }
        r1[r5] = r3;	 Catch:{ IOException -> 0x010e }
        r2 = "utf8";	 Catch:{ IOException -> 0x010e }
        r1[r4] = r2;	 Catch:{ IOException -> 0x010e }
        r2 = "";	 Catch:{ IOException -> 0x010e }
        r1[r6] = r2;	 Catch:{ IOException -> 0x010e }
        r0.invoke(r1);	 Catch:{ IOException -> 0x010e }
        goto L_0x0146;	 Catch:{ IOException -> 0x010e }
    L_0x00fa:
        r1 = r11.f2462n;	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x010e }
        r2[r5] = r3;	 Catch:{ IOException -> 0x010e }
        r7 = "base64";	 Catch:{ IOException -> 0x010e }
        r2[r4] = r7;	 Catch:{ IOException -> 0x010e }
        r0 = android.util.Base64.encodeToString(r0, r6);	 Catch:{ IOException -> 0x010e }
        r2[r6] = r0;	 Catch:{ IOException -> 0x010e }
        r1.invoke(r2);	 Catch:{ IOException -> 0x010e }
        goto L_0x0146;
    L_0x010e:
        r0 = r11.f2462n;
        r1 = new java.lang.Object[r6];
        r2 = "RNFetchBlob failed to encode response data to BASE64 string.";
        r1[r5] = r2;
        r1[r4] = r3;
        r0.invoke(r1);
        goto L_0x0146;
    L_0x011c:
        r1 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x0139 }
        r1[r5] = r3;	 Catch:{ IOException -> 0x0139 }
        r2 = "utf8";	 Catch:{ IOException -> 0x0139 }
        r1[r4] = r2;	 Catch:{ IOException -> 0x0139 }
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x0139 }
        r7 = r12.h();	 Catch:{ IOException -> 0x0139 }
        r7 = r7.bytes();	 Catch:{ IOException -> 0x0139 }
        r8 = "UTF-8";	 Catch:{ IOException -> 0x0139 }
        r2.<init>(r7, r8);	 Catch:{ IOException -> 0x0139 }
        r1[r6] = r2;	 Catch:{ IOException -> 0x0139 }
        r0.invoke(r1);	 Catch:{ IOException -> 0x0139 }
        goto L_0x0146;
    L_0x0139:
        r0 = r11.f2462n;
        r1 = new java.lang.Object[r6];
        r2 = "RNFetchBlob failed to encode response data to UTF8 string.";
        r1[r5] = r2;
        r1[r4] = r3;
        r0.invoke(r1);
    L_0x0146:
        r12 = r12.h();
        r12.close();
        r11.m3109a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.g.a(expolib_v1.a.ab):void");
    }

    /* renamed from: b */
    public static C0869f m3115b(String str) {
        if (f2450b.containsKey(str)) {
            return (C0869f) f2450b.get(str);
        }
        return null;
    }

    /* renamed from: c */
    public static C0869f m3117c(String str) {
        if (f2451c.containsKey(str)) {
            return (C0869f) f2451c.get(str);
        }
        return null;
    }

    /* renamed from: a */
    private WritableMap m3105a(ab abVar, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, abVar.c());
        createMap.putString(ServerProtocol.DIALOG_PARAM_STATE, "2");
        createMap.putString("taskId", this.f2455g);
        createMap.putBoolean("timeout", this.f2470v);
        WritableMap createMap2 = Arguments.createMap();
        for (int i = 0; i < abVar.g().a(); i++) {
            createMap2.putString(abVar.g().a(i), abVar.g().b(i));
        }
        WritableArray createArray = Arguments.createArray();
        Iterator it = this.f2471w.iterator();
        while (it.hasNext()) {
            createArray.pushString((String) it.next());
        }
        createMap.putArray("redirects", createArray);
        createMap.putMap("headers", createMap2);
        C6234q g = abVar.g();
        if (z) {
            createMap.putString("respType", "blob");
        } else if (m3107a(g, "content-type").equalsIgnoreCase("text/")) {
            createMap.putString("respType", "text");
        } else if (m3107a(g, "content-type").contains("application/json") != null) {
            createMap.putString("respType", "json");
        } else {
            createMap.putString("respType", "");
        }
        return createMap;
    }

    /* renamed from: b */
    private boolean m3116b(ab abVar) {
        abVar = m3107a(abVar.g(), HttpHeaders.CONTENT_TYPE);
        int equalsIgnoreCase = abVar.equalsIgnoreCase("text/") ^ 1;
        int equalsIgnoreCase2 = abVar.equalsIgnoreCase("application/json") ^ 1;
        if (this.f2454f.f2413m != null) {
            for (int i = 0; i < this.f2454f.f2413m.size(); i++) {
                if (abVar.toLowerCase().contains(this.f2454f.f2413m.getString(i).toLowerCase())) {
                    abVar = true;
                    break;
                }
            }
        }
        abVar = null;
        if (equalsIgnoreCase2 == 0 && equalsIgnoreCase == 0) {
            return true;
        }
        if (abVar != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private String m3107a(C6234q c6234q, String str) {
        String a = c6234q.a(str);
        if (a != null) {
            return a;
        }
        return c6234q.a(str.toLowerCase()) == null ? "" : c6234q.a(str.toLowerCase());
    }

    /* renamed from: a */
    private String m3108a(HashMap<String, String> hashMap, String str) {
        String str2 = (String) hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        hashMap = (String) hashMap.get(str.toLowerCase());
        if (hashMap == null) {
            hashMap = "";
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m3112a(WritableMap writableMap) {
        ((RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobState", writableMap);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction()) != null) {
            context = RNFetchBlob.RCTContext.getApplicationContext();
            if (intent.getExtras().getLong("extra_download_id") == this.f2464p) {
                intent = new Query();
                intent.setFilterById(new long[]{this.f2464p});
                DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                downloadManager.query(intent);
                intent = downloadManager.query(intent);
                if (intent.moveToFirst()) {
                    int i = intent.getInt(intent.getColumnIndex(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS));
                    if (i == 16) {
                        context = this.f2462n;
                        intent = new Object[3];
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Download manager failed to download from  ");
                        stringBuilder.append(this.f2457i);
                        stringBuilder.append(". Statu Code = ");
                        stringBuilder.append(i);
                        intent[0] = stringBuilder.toString();
                        intent[1] = null;
                        intent[2] = null;
                        context.invoke(intent);
                        return;
                    }
                    intent = intent.getString(intent.getColumnIndex("local_uri"));
                    if (intent != null && this.f2454f.f2404d.hasKey("mime") && this.f2454f.f2404d.getString("mime").contains(MessengerShareContentUtility.MEDIA_IMAGE)) {
                        context = context.getContentResolver().query(Uri.parse(intent), new String[]{"_data"}, null, null, null);
                        if (context != null) {
                            context.moveToFirst();
                            context = context.getString(0);
                            if (this.f2454f.f2404d.hasKey("path") != null) {
                                try {
                                    if (new File(this.f2454f.f2404d.getString("path")).exists() == null) {
                                        this.f2462n.invoke(null, "path", context);
                                    } else {
                                        throw new Exception("Download manager download failed, the file does not downloaded to destination.");
                                    }
                                } catch (Context context2) {
                                    context2.printStackTrace();
                                    this.f2462n.invoke(context2.getLocalizedMessage(), null);
                                }
                            } else if (context2 != null) {
                                this.f2462n.invoke(new Object[]{"Download manager could not resolve downloaded file path.", "path", null});
                            } else {
                                this.f2462n.invoke(null, "path", context2);
                            }
                        }
                    }
                }
                context2 = null;
                if (this.f2454f.f2404d.hasKey("path") != null) {
                    if (new File(this.f2454f.f2404d.getString("path")).exists() == null) {
                        throw new Exception("Download manager download failed, the file does not downloaded to destination.");
                    }
                    this.f2462n.invoke(null, "path", context2);
                } else if (context2 != null) {
                    this.f2462n.invoke(null, "path", context2);
                } else {
                    this.f2462n.invoke(new Object[]{"Download manager could not resolve downloaded file path.", "path", null});
                }
            }
        }
    }

    /* renamed from: a */
    public static C6243a m3106a(C6243a c6243a) {
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19) {
            try {
                c6243a.a(new TLSSocketFactory());
                C6226k a = new C6225a(C6226k.f20250a).a(new ae[]{ae.f20130b}).a();
                List arrayList = new ArrayList();
                arrayList.add(a);
                arrayList.add(C6226k.f20251b);
                arrayList.add(C6226k.f20252c);
                c6243a.b(arrayList);
            } catch (Throwable e) {
                FLog.m5675e("OkHttpClientProvider", "Error while enabling TLS 1.2", e);
            }
        }
        return c6243a;
    }
}
