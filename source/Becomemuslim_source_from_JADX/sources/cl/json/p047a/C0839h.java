package cl.json.p047a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import cl.json.C0841c;
import cl.json.C0842d;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.internal.ShareConstants;
import java.util.List;

/* compiled from: ShareIntent */
/* renamed from: cl.json.a.h */
public abstract class C0839h {
    /* renamed from: a */
    protected final ReactApplicationContext f2330a;
    /* renamed from: b */
    protected Intent f2331b;
    /* renamed from: c */
    protected String f2332c = "Share";
    /* renamed from: d */
    protected C0841c f2333d;
    /* renamed from: e */
    protected ReadableMap f2334e;

    /* renamed from: a */
    protected abstract String mo715a();

    /* renamed from: b */
    protected abstract String mo717b();

    /* renamed from: c */
    protected abstract String mo718c();

    public C0839h(ReactApplicationContext reactApplicationContext) {
        this.f2330a = reactApplicationContext;
        m3020a(new Intent("android.intent.action.SEND"));
        m3029e().setType("text/plain");
    }

    /* renamed from: a */
    public void mo716a(ReadableMap readableMap) {
        this.f2334e = readableMap;
        if (C0839h.m3018a("subject", readableMap)) {
            m3029e().putExtra("android.intent.extra.SUBJECT", readableMap.getString("subject"));
        }
        if (C0839h.m3018a("title", readableMap)) {
            this.f2332c = readableMap.getString("title");
        }
        Object obj = "";
        if (C0839h.m3018a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, readableMap)) {
            obj = readableMap.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        }
        StringBuilder stringBuilder;
        if (C0839h.m3018a("urls", readableMap)) {
            C0842d c = m3026c(readableMap);
            if (c.m3042a()) {
                readableMap = c.m3044c();
                m3029e().setAction("android.intent.action.SEND_MULTIPLE");
                m3029e().setType(c.m3043b());
                m3029e().putParcelableArrayListExtra("android.intent.extra.STREAM", readableMap);
                m3029e().addFlags(1);
                if (TextUtils.isEmpty(obj) == null) {
                    m3029e().putExtra("android.intent.extra.TEXT", obj);
                }
            } else if (TextUtils.isEmpty(obj)) {
                m3029e().putExtra("android.intent.extra.TEXT", readableMap.getArray("urls").toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj);
                stringBuilder.append(" ");
                stringBuilder.append(readableMap.getArray("urls").toString());
                m3029e().putExtra("android.intent.extra.TEXT", stringBuilder.toString());
            }
        } else if (C0839h.m3018a("url", readableMap)) {
            this.f2333d = m3024b(readableMap);
            if (this.f2333d.m3033a()) {
                readableMap = this.f2333d.m3037e();
                m3029e().setType(this.f2333d.m3036d());
                m3029e().putExtra("android.intent.extra.STREAM", readableMap);
                m3029e().addFlags(1);
                if (TextUtils.isEmpty(obj) == null) {
                    m3029e().putExtra("android.intent.extra.TEXT", obj);
                }
            } else if (TextUtils.isEmpty(obj)) {
                m3029e().putExtra("android.intent.extra.TEXT", readableMap.getString("url"));
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj);
                stringBuilder.append(" ");
                stringBuilder.append(readableMap.getString("url"));
                m3029e().putExtra("android.intent.extra.TEXT", stringBuilder.toString());
            }
        } else if (TextUtils.isEmpty(obj) == null) {
            m3029e().putExtra("android.intent.extra.TEXT", obj);
        }
    }

    /* renamed from: b */
    protected C0841c m3024b(ReadableMap readableMap) {
        if (C0839h.m3018a("type", readableMap)) {
            return new C0841c(readableMap.getString("url"), readableMap.getString("type"), this.f2330a);
        }
        return new C0841c(readableMap.getString("url"), this.f2330a);
    }

    /* renamed from: c */
    protected C0842d m3026c(ReadableMap readableMap) {
        if (C0839h.m3018a("type", readableMap)) {
            return new C0842d(readableMap.getArray("urls"), readableMap.getString("type"), this.f2330a);
        }
        return new C0842d(readableMap.getArray("urls"), this.f2330a);
    }

    /* renamed from: a */
    protected static java.lang.String m3017a(java.lang.String r3) {
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
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        r0 = java.net.URLEncoder.encode(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "URLEncoder.encode() failed for ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.a.h.a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    protected Intent[] m3023a(Intent intent, Uri uri) {
        int i = 0;
        List queryIntentActivities = this.f2330a.getPackageManager().queryIntentActivities(intent, 0);
        Intent[] intentArr = new Intent[queryIntentActivities.size()];
        while (i < queryIntentActivities.size()) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            String str = resolveInfo.activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
            intent2.setAction("android.intent.action.VIEW");
            intent2.setDataAndType(uri, intent.getType());
            intent2.addFlags(1);
            intentArr[i] = new Intent(intent2);
            i++;
        }
        return intentArr;
    }

    /* renamed from: d */
    protected void mo719d() {
        Intent createChooser = Intent.createChooser(m3029e(), this.f2332c);
        createChooser.setFlags(268435456);
        if (C0839h.m3018a("showAppsToView", this.f2334e) && C0839h.m3018a("url", this.f2334e)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setType(this.f2333d.m3036d());
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", m3023a(intent, this.f2333d.m3037e()));
        }
        this.f2330a.startActivity(createChooser);
    }

    /* renamed from: a */
    protected boolean m3022a(java.lang.String r2, android.content.Context r3) {
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
        r1 = this;
        r3 = r3.getPackageManager();
        r0 = 1;
        r3.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0009 }
        return r0;
    L_0x0009:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cl.json.a.h.a(java.lang.String, android.content.Context):boolean");
    }

    /* renamed from: e */
    protected Intent m3029e() {
        return this.f2331b;
    }

    /* renamed from: a */
    protected void m3020a(Intent intent) {
        this.f2331b = intent;
    }

    /* renamed from: a */
    public static boolean m3018a(String str, ReadableMap readableMap) {
        return (readableMap != null && readableMap.hasKey(str) && readableMap.isNull(str) == null) ? true : null;
    }
}
