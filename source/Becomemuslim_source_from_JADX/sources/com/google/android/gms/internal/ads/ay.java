package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.ae;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class ay implements Callable<is> {
    /* renamed from: a */
    private static long f15047a = 10;
    /* renamed from: b */
    private final Context f15048b;
    /* renamed from: c */
    private final lg f15049c;
    /* renamed from: d */
    private final ae f15050d;
    /* renamed from: e */
    private final ahi f15051e;
    /* renamed from: f */
    private final bq f15052f;
    /* renamed from: g */
    private final Object f15053g = new Object();
    /* renamed from: h */
    private final it f15054h;
    /* renamed from: i */
    private final atc f15055i;
    /* renamed from: j */
    private boolean f15056j;
    /* renamed from: k */
    private int f15057k;
    /* renamed from: l */
    private List<String> f15058l;
    /* renamed from: m */
    private JSONObject f15059m;
    /* renamed from: n */
    private String f15060n;
    /* renamed from: o */
    private String f15061o;

    public ay(Context context, ae aeVar, lg lgVar, ahi ahi, it itVar, atc atc) {
        this.f15048b = context;
        this.f15050d = aeVar;
        this.f15049c = lgVar;
        this.f15054h = itVar;
        this.f15051e = ahi;
        this.f15055i = atc;
        this.f15052f = aeVar.I();
        this.f15056j = false;
        this.f15057k = -2;
        this.f15058l = null;
        this.f15060n = null;
        this.f15061o = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final com.google.android.gms.internal.ads.is m19109a() {
        /*
        r15 = this;
        r0 = 0;
        r1 = 0;
        r2 = r15.f15050d;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r11 = r2.o_();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2 = r15.m19120b();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r2 != 0) goto L_0x006e;
    L_0x000e:
        r2 = new org.json.JSONObject;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r3.f15601b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r3.f28597b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2.<init>(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = new org.json.JSONObject;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f15601b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f28597b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3.<init>(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r3.length();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r4 == 0) goto L_0x0040;
    L_0x002a:
        r4 = "ads";
        r3 = r3.optJSONArray(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 == 0) goto L_0x0037;
    L_0x0032:
        r3 = r3.optJSONObject(r0);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x0038;
    L_0x0037:
        r3 = r1;
    L_0x0038:
        if (r3 == 0) goto L_0x0040;
    L_0x003a:
        r3 = r3.length();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 != 0) goto L_0x0044;
    L_0x0040:
        r3 = 3;
        r15.m19114a(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
    L_0x0044:
        r3 = r15.f15052f;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2 = r3.mo4220a(r2);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = f15047a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2 = r2.get(r3, r5);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2 = (org.json.JSONObject) r2;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = "success";
        r3 = r2.optBoolean(r3, r0);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 == 0) goto L_0x006e;
    L_0x005c:
        r3 = "json";
        r2 = r2.getJSONObject(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = "ads";
        r2 = r2.optJSONArray(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r2 = r2.getJSONObject(r0);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r8 = r2;
        goto L_0x006f;
    L_0x006e:
        r8 = r1;
    L_0x006f:
        r2 = "enable_omid";
        r2 = r8.optBoolean(r2);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r2 != 0) goto L_0x007d;
    L_0x0077:
        r3 = com.google.android.gms.internal.ads.nd.m19938a(r1);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r12 = r3;
        goto L_0x00a3;
    L_0x007d:
        r3 = "omid_settings";
        r3 = r8.optJSONObject(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 != 0) goto L_0x0086;
    L_0x0085:
        goto L_0x0077;
    L_0x0086:
        r4 = "omid_html";
        r3 = r3.optString(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r4 == 0) goto L_0x0093;
    L_0x0092:
        goto L_0x0077;
    L_0x0093:
        r4 = new com.google.android.gms.internal.ads.nz;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4.<init>();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = com.google.android.gms.internal.ads.nu.f15846a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = new com.google.android.gms.internal.ads.az;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6.<init>(r15, r4, r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5.execute(r6);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r12 = r4;
    L_0x00a3:
        r3 = r15.m19120b();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 != 0) goto L_0x014c;
    L_0x00a9:
        if (r8 != 0) goto L_0x00ad;
    L_0x00ab:
        goto L_0x014c;
    L_0x00ad:
        r3 = "template_id";
        r3 = r8.getString(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f15600a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f28569y;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r4 == 0) goto L_0x00c4;
    L_0x00bb:
        r4 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f15600a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f28569y;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r4.f28388b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x00c5;
    L_0x00c4:
        r4 = 0;
    L_0x00c5:
        r5 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r5.f15600a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r5.f28569y;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r5 == 0) goto L_0x00d6;
    L_0x00cd:
        r5 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r5.f15600a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r5.f28569y;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r5.f28390d;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x00d7;
    L_0x00d6:
        r5 = 0;
    L_0x00d7:
        r6 = "2";
        r6 = r6.equals(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r6 == 0) goto L_0x00e9;
    L_0x00df:
        r3 = new com.google.android.gms.internal.ads.br;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = r6.f15609j;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3.<init>(r4, r5, r6);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x014d;
    L_0x00e9:
        r6 = "1";
        r6 = r6.equals(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r6 == 0) goto L_0x00fb;
    L_0x00f1:
        r3 = new com.google.android.gms.internal.ads.bs;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = r6.f15609j;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3.<init>(r4, r5, r6);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x014d;
    L_0x00fb:
        r5 = "3";
        r3 = r5.equals(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 == 0) goto L_0x0149;
    L_0x0103:
        r3 = "custom_template_id";
        r3 = r8.getString(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = new com.google.android.gms.internal.ads.nz;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5.<init>();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = com.google.android.gms.internal.ads.jw.f15691a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r7 = new com.google.android.gms.internal.ads.bb;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r7.<init>(r15, r5, r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6.post(r7);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = f15047a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r5.get(r6, r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 == 0) goto L_0x0128;
    L_0x0122:
        r3 = new com.google.android.gms.internal.ads.bt;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3.<init>(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x014d;
    L_0x0128:
        r3 = "No handler for custom template: ";
        r4 = "custom_template_id";
        r4 = r8.getString(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r4.length();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r5 == 0) goto L_0x013f;
    L_0x013a:
        r3 = r3.concat(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x0145;
    L_0x013f:
        r4 = new java.lang.String;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4.<init>(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r4;
    L_0x0145:
        com.google.android.gms.internal.ads.mt.m19920c(r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x014c;
    L_0x0149:
        r15.m19114a(r0);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
    L_0x014c:
        r3 = r1;
    L_0x014d:
        r4 = r15.m19120b();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r4 != 0) goto L_0x01bd;
    L_0x0153:
        if (r3 == 0) goto L_0x01bd;
    L_0x0155:
        if (r8 != 0) goto L_0x0158;
    L_0x0157:
        goto L_0x01bd;
    L_0x0158:
        r4 = "tracking_urls_and_actions";
        r4 = r8.getJSONObject(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = "impression_tracking_urls";
        r5 = r4.optJSONArray(r5);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r5 != 0) goto L_0x0168;
    L_0x0166:
        r6 = r1;
        goto L_0x017e;
    L_0x0168:
        r6 = r5.length();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = new java.lang.String[r6];	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r7 = 0;
    L_0x016f:
        r9 = r5.length();	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r7 >= r9) goto L_0x017e;
    L_0x0175:
        r9 = r5.getString(r7);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6[r7] = r9;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r7 = r7 + 1;
        goto L_0x016f;
    L_0x017e:
        if (r6 != 0) goto L_0x0182;
    L_0x0180:
        r5 = r1;
        goto L_0x0186;
    L_0x0182:
        r5 = java.util.Arrays.asList(r6);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
    L_0x0186:
        r15.f15058l = r5;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = "active_view";
        r4 = r4.optJSONObject(r5);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r15.f15059m = r4;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = "debug_signals";
        r4 = r8.optString(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r15.f15060n = r4;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = "omid_settings";
        r4 = r8.optString(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r15.f15061o = r4;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r13 = r3.mo4219a(r15, r8);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r14 = new com.google.android.gms.internal.ads.auk;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = r15.f15048b;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = r15.f15050d;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r6 = r15.f15052f;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r7 = r15.f15051e;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r15.f15054h;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r3.f15600a;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r10 = r3.f28555k;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r14;
        r9 = r13;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r13.mo6084a(r14);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        goto L_0x01be;
    L_0x01bd:
        r13 = r1;
    L_0x01be:
        r3 = r13 instanceof com.google.android.gms.internal.ads.aty;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        if (r3 == 0) goto L_0x01d1;
    L_0x01c2:
        r3 = r13;
        r3 = (com.google.android.gms.internal.ads.aty) r3;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = new com.google.android.gms.internal.ads.bc;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4.<init>(r15, r3);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r15.f15052f;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r5 = "/nativeAdCustomClick";
        r3.mo4222a(r5, r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
    L_0x01d1:
        r2 = r15.m19110a(r13, r2);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3 = r15.f15050d;	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r4 = m19117b(r12);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        r3.b(r4);	 Catch:{ CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, CancellationException -> 0x01e7, TimeoutException -> 0x01e3, Exception -> 0x01df }
        return r2;
    L_0x01df:
        r2 = move-exception;
        r3 = "Error occured while doing native ads initialization.";
        goto L_0x01ea;
    L_0x01e3:
        r2 = move-exception;
        r3 = "Timeout when loading native ad.";
        goto L_0x01ea;
    L_0x01e7:
        r2 = move-exception;
        r3 = "Malformed native JSON response.";
    L_0x01ea:
        com.google.android.gms.internal.ads.mt.m19921c(r3, r2);
        r2 = r15.f15056j;
        if (r2 != 0) goto L_0x01f4;
    L_0x01f1:
        r15.m19114a(r0);
    L_0x01f4:
        r0 = r15.m19110a(r1, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ay.a():com.google.android.gms.internal.ads.is");
    }

    /* renamed from: a */
    private final is m19110a(aui aui, boolean z) {
        int i;
        synchronized (this.f15053g) {
            i = (aui == null && r1.f15057k == -2) ? 0 : r1.f15057k;
        }
        return new is(r1.f15054h.f15600a.f28547c, null, r1.f15054h.f15601b.f28598c, i, r1.f15054h.f15601b.f28600e, r1.f15058l, r1.f15054h.f15601b.f28606k, r1.f15054h.f15601b.f28605j, r1.f15054h.f15600a.f28553i, false, null, null, null, null, null, 0, r1.f15054h.f15603d, r1.f15054h.f15601b.f28601f, r1.f15054h.f15605f, r1.f15054h.f15606g, r1.f15054h.f15601b.f28609n, r1.f15059m, i != -2 ? null : aui, null, null, null, r1.f15054h.f15601b.f28575D, r1.f15054h.f15601b.f28576E, null, r1.f15054h.f15601b.f28579H, r1.f15060n, r1.f15054h.f15608i, r1.f15054h.f15601b.f28586O, r1.f15054h.f15609j, z, r1.f15054h.f15601b.f28589R, r1.f15054h.f15601b.f28590S, r1.f15061o);
    }

    /* renamed from: a */
    private final no<att> m19111a(JSONObject jSONObject, boolean z, boolean z2) {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? nd.m19938a(new att(null, Uri.parse(string), optDouble)) : this.f15049c.m19832a(string, new bf(this, z, optDouble, optBoolean, string));
        } else {
            m19126a(0, z);
            return nd.m19938a(null);
        }
    }

    /* renamed from: a */
    static qo m19112a(no<qo> noVar) {
        try {
            return (qo) noVar.get((long) ((Integer) aph.m18688f().m18889a(asp.cc)).intValue(), TimeUnit.SECONDS);
        } catch (Throwable e) {
            mt.m19921c("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (Throwable e2) {
            mt.m19921c("Exception occurred while waiting for video to load", e2);
            return null;
        }
    }

    /* renamed from: a */
    private final void m19114a(int i) {
        synchronized (this.f15053g) {
            this.f15056j = true;
            this.f15057k = i;
        }
    }

    /* renamed from: a */
    private final void m19115a(awa awa, String str) {
        try {
            awl b = this.f15050d.b(awa.mo4053l());
            if (b != null) {
                b.mo4056a(awa, str);
            }
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 40);
            stringBuilder.append("Failed to call onCustomClick for asset ");
            stringBuilder.append(str);
            stringBuilder.append(".");
            mt.m19921c(stringBuilder.toString(), e);
        }
    }

    /* renamed from: b */
    private static qo m19117b(no<qo> noVar) {
        try {
            return (qo) noVar.get((long) ((Integer) aph.m18688f().m18889a(asp.cd)).intValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            mt.m19921c("", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (Throwable e2) {
            mt.m19921c("", e2);
            return null;
        }
    }

    /* renamed from: b */
    private static java.lang.Integer m19118b(org.json.JSONObject r2, java.lang.String r3) {
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
        r2 = r2.getJSONObject(r3);	 Catch:{ JSONException -> 0x001f }
        r3 = "r";	 Catch:{ JSONException -> 0x001f }
        r3 = r2.getInt(r3);	 Catch:{ JSONException -> 0x001f }
        r0 = "g";	 Catch:{ JSONException -> 0x001f }
        r0 = r2.getInt(r0);	 Catch:{ JSONException -> 0x001f }
        r1 = "b";	 Catch:{ JSONException -> 0x001f }
        r2 = r2.getInt(r1);	 Catch:{ JSONException -> 0x001f }
        r2 = android.graphics.Color.rgb(r3, r0, r2);	 Catch:{ JSONException -> 0x001f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ JSONException -> 0x001f }
        return r2;
    L_0x001f:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ay.b(org.json.JSONObject, java.lang.String):java.lang.Integer");
    }

    /* renamed from: b */
    private static <V> List<V> m19119b(List<no<V>> list) {
        List<V> arrayList = new ArrayList();
        for (no noVar : list) {
            Object obj = noVar.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private final boolean m19120b() {
        boolean z;
        synchronized (this.f15053g) {
            z = this.f15056j;
        }
        return z;
    }

    /* renamed from: a */
    public final no<atp> m19121a(JSONObject jSONObject) {
        ay ayVar = this;
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return nd.m19938a(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer b = m19118b(optJSONObject, "text_color");
        Integer b2 = m19118b(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (ayVar.f15054h.f15600a.f28569y == null || ayVar.f15054h.f15600a.f28569y.f28387a < 2) ? 1 : ayVar.f15054h.f15600a.f28569y.f28391e;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = m19124a(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(m19123a(optJSONObject, MessengerShareContentUtility.MEDIA_IMAGE, false, false));
        }
        nz nzVar = new nz();
        int size = r0.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (no a : r0) {
            List list = arrayList;
            a.mo4319a(new bg(atomicInteger, size, nzVar, arrayList), ju.f15687a);
            arrayList = list;
        }
        return nd.m19941a((no) nzVar, new be(this, optString, b2, b, optInt, optInt3, optInt2, i, optBoolean), ju.f15687a);
    }

    /* renamed from: a */
    public final no<qo> m19122a(JSONObject jSONObject, String str) {
        jSONObject = jSONObject.optJSONObject(str);
        if (jSONObject == null) {
            return nd.m19938a(null);
        }
        if (TextUtils.isEmpty(jSONObject.optString("vast_xml"))) {
            mt.m19924e("Required field 'vast_xml' is missing");
            return nd.m19938a(null);
        }
        bi biVar = new bi(this.f15048b, this.f15051e, this.f15054h, this.f15055i, this.f15050d);
        no nzVar = new nz();
        nu.f15846a.execute(new bj(biVar, jSONObject, nzVar));
        return nzVar;
    }

    /* renamed from: a */
    public final no<att> m19123a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        jSONObject = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return m19111a(jSONObject, z, z2);
    }

    /* renamed from: a */
    public final List<no<att>> m19124a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        List<no<att>> arrayList = new ArrayList();
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int length = z3 ? optJSONArray.length() : 1;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    arrayList.add(m19111a(jSONObject2, false, z2));
                }
                return arrayList;
            }
        }
        m19126a(0, false);
        return arrayList;
    }

    /* renamed from: a */
    public final Future<att> m19125a(JSONObject jSONObject, String str, boolean z) {
        jSONObject = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject.optBoolean("require", true);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return m19111a(jSONObject, optBoolean, z);
    }

    /* renamed from: a */
    public final void m19126a(int i, boolean z) {
        if (z) {
            m19114a(i);
        }
    }

    /* renamed from: a */
    final /* synthetic */ void m19127a(nz nzVar, String str) {
        try {
            ax.f();
            qo a = qv.m20039a(this.f15048b, sc.m20088a(), "native-omid", false, false, this.f15051e, this.f15054h.f15600a.f28555k, this.f15055i, null, this.f15050d.h(), this.f15054h.f15608i);
            a.mo6718v().mo4343a(new ba(nzVar, a));
            a.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, Utf8Charset.NAME);
        } catch (Throwable e) {
            nzVar.m30915b(null);
            mt.m19921c("", e);
        }
    }

    public final /* synthetic */ Object call() {
        return m19109a();
    }
}
