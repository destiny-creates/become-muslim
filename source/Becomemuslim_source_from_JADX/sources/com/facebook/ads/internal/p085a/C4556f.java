package com.facebook.ads.internal.p085a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p108c.C1539g;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.a.f */
public class C4556f extends C3545h {
    /* renamed from: e */
    private static final String f12285e = "f";
    /* renamed from: f */
    private final Uri f12286f;
    /* renamed from: g */
    private final Map<String, String> f12287g;

    public C4556f(Context context, C1412c c1412c, String str, Uri uri, Map<String, String> map, C1304l c1304l) {
        super(context, c1412c, str, c1304l);
        this.f12286f = uri;
        this.f12287g = map;
    }

    /* renamed from: a */
    private Intent m15488a(C1302g c1302g) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!(TextUtils.isEmpty(c1302g.m4454a()) || TextUtils.isEmpty(c1302g.m4455b()))) {
            intent.setComponent(new ComponentName(c1302g.m4454a(), c1302g.m4455b()));
        }
        if (!TextUtils.isEmpty(c1302g.m4456c())) {
            intent.setData(Uri.parse(c1302g.m4456c()));
        }
        return intent;
    }

    /* renamed from: b */
    private Intent m15489b(C1302g c1302g) {
        if (TextUtils.isEmpty(c1302g.m4454a()) || !C1301e.m4452a(this.a, c1302g.m4454a())) {
            return null;
        }
        CharSequence c = c1302g.m4456c();
        if (!TextUtils.isEmpty(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (TextUtils.isEmpty(c1302g.m4455b()) && TextUtils.isEmpty(c)) {
            return packageManager.getLaunchIntentForPackage(c1302g.m4454a());
        }
        Intent a = m15488a(c1302g);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(a, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (a.getComponent() == null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(c1302g.m4454a())) {
                    a.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        if (!queryIntentActivities.isEmpty()) {
            if (a.getComponent() != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: f */
    private List<C1302g> m15490f() {
        Object queryParameter = this.f12286f.getQueryParameter("appsite_data");
        if (!TextUtils.isEmpty(queryParameter)) {
            if (!"[]".equals(queryParameter)) {
                List<C1302g> arrayList = new ArrayList();
                try {
                    JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            C1302g a = C1302g.m4453a(optJSONArray.optJSONObject(i));
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                    }
                } catch (Throwable e) {
                    Log.w(f12285e, "Error parsing appsite_data", e);
                }
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: g */
    private boolean m15491g() {
        List<Intent> d = m15495d();
        if (d == null) {
            return false;
        }
        for (Intent startActivity : d) {
            try {
                this.a.startActivity(startActivity);
                return true;
            } catch (Throwable e) {
                Log.d(f12285e, "Failed to open app intent, falling back", e);
            }
        }
        return false;
    }

    /* renamed from: h */
    private boolean m15492h() {
        C1539g c1539g = new C1539g();
        try {
            C1539g.m5388a(c1539g, this.a, m15494c(), this.c);
            return true;
        } catch (Throwable e) {
            String str = f12285e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to open market url: ");
            stringBuilder.append(this.f12286f.toString());
            Log.d(str, stringBuilder.toString(), e);
            String queryParameter = this.f12286f.getQueryParameter("store_url_web_fallback");
            if (queryParameter != null && queryParameter.length() > 0) {
                C1539g.m5388a(c1539g, this.a, Uri.parse(queryParameter), this.c);
            }
            return false;
        }
    }

    /* renamed from: a */
    public C1395a mo918a() {
        return C1395a.OPEN_STORE;
    }

    /* renamed from: c */
    protected Uri m15494c() {
        Object queryParameter = this.f12286f.getQueryParameter("store_url");
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        String queryParameter2 = this.f12286f.getQueryParameter("store_id");
        return Uri.parse(String.format("market://details?id=%s", new Object[]{queryParameter2}));
    }

    /* renamed from: d */
    protected List<Intent> m15495d() {
        List<C1302g> f = m15490f();
        List<Intent> arrayList = new ArrayList();
        if (f != null) {
            for (C1302g b : f) {
                Intent b2 = m15489b(b);
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    void mo2815e() {
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
        r4 = this;
        r0 = "opened_deeplink";
        r1 = r4.m15491g();
        r2 = 0;
        if (r1 != 0) goto L_0x001f;
    L_0x0009:
        r1 = r4.m15492h();	 Catch:{ Exception -> 0x0016 }
        if (r1 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x0016 }
    L_0x000f:
        r1 = "opened_store_url";	 Catch:{ Exception -> 0x0016 }
        goto L_0x0014;	 Catch:{ Exception -> 0x0016 }
    L_0x0012:
        r1 = "opened_store_fallback_url";	 Catch:{ Exception -> 0x0016 }
    L_0x0014:
        r0 = r1;
        goto L_0x001f;
    L_0x0016:
        r1 = f12285e;
        r2 = "Failed to open all options including fallback url, can't open anything";
        android.util.Log.d(r1, r2);
        r2 = com.facebook.ads.internal.p085a.C1296a.CANNOT_OPEN;
    L_0x001f:
        r1 = r4.f12287g;
        r3 = 1;
        r3 = java.lang.String.valueOf(r3);
        r1.put(r0, r3);
        r0 = r4.f12287g;
        r4.m11492a(r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.a.f.e():void");
    }
}
