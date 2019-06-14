package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.C2872v;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

@cm
public class auk implements auf {
    /* renamed from: a */
    boolean f23797a;
    /* renamed from: b */
    boolean f23798b;
    /* renamed from: c */
    private final Object f23799c = new Object();
    /* renamed from: d */
    private final auh f23800d;
    /* renamed from: e */
    private final Context f23801e;
    /* renamed from: f */
    private final atq f23802f;
    /* renamed from: g */
    private final JSONObject f23803g;
    /* renamed from: h */
    private final bq f23804h;
    /* renamed from: i */
    private final aui f23805i;
    /* renamed from: j */
    private final ahi f23806j;
    /* renamed from: k */
    private final mv f23807k;
    /* renamed from: l */
    private String f23808l;
    /* renamed from: m */
    private ih f23809m;
    /* renamed from: n */
    private WeakReference<View> f23810n = null;

    public auk(Context context, auh auh, bq bqVar, ahi ahi, JSONObject jSONObject, aui aui, mv mvVar, String str) {
        this.f23801e = context;
        this.f23800d = auh;
        this.f23804h = bqVar;
        this.f23806j = ahi;
        this.f23803g = jSONObject;
        this.f23805i = aui;
        this.f23807k = mvVar;
        this.f23808l = str;
        this.f23802f = new atq(this.f23804h);
    }

    /* renamed from: a */
    private final int m30201a(int i) {
        aph.m18683a();
        return mi.m19874b(this.f23801e, i);
    }

    /* renamed from: a */
    private final JSONObject m30202a(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", m30201a(rect.right - rect.left));
        jSONObject.put("height", m30201a(rect.bottom - rect.top));
        jSONObject.put("x", m30201a(rect.left));
        jSONObject.put("y", m30201a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* renamed from: a */
    private final org.json.JSONObject m30203a(java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r13, android.view.View r14) {
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
        r12 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r13 == 0) goto L_0x0105;
    L_0x0007:
        if (r14 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x0105;
    L_0x000b:
        r14 = m30208f(r14);
        monitor-enter(r13);
        r1 = r13.entrySet();	 Catch:{ all -> 0x0102 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0102 }
    L_0x0018:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0102 }
        if (r2 == 0) goto L_0x0100;	 Catch:{ all -> 0x0102 }
    L_0x001e:
        r2 = r1.next();	 Catch:{ all -> 0x0102 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x0102 }
        r3 = r2.getValue();	 Catch:{ all -> 0x0102 }
        r3 = (java.lang.ref.WeakReference) r3;	 Catch:{ all -> 0x0102 }
        r3 = r3.get();	 Catch:{ all -> 0x0102 }
        r3 = (android.view.View) r3;	 Catch:{ all -> 0x0102 }
        if (r3 == 0) goto L_0x0018;	 Catch:{ all -> 0x0102 }
    L_0x0032:
        r4 = m30208f(r3);	 Catch:{ all -> 0x0102 }
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0102 }
        r5.<init>();	 Catch:{ all -> 0x0102 }
        r6 = new org.json.JSONObject;	 Catch:{ all -> 0x0102 }
        r6.<init>();	 Catch:{ all -> 0x0102 }
        r7 = "width";	 Catch:{ JSONException -> 0x00f9 }
        r8 = r3.getMeasuredWidth();	 Catch:{ JSONException -> 0x00f9 }
        r8 = r12.m30201a(r8);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "height";	 Catch:{ JSONException -> 0x00f9 }
        r8 = r3.getMeasuredHeight();	 Catch:{ JSONException -> 0x00f9 }
        r8 = r12.m30201a(r8);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "x";	 Catch:{ JSONException -> 0x00f9 }
        r8 = 0;	 Catch:{ JSONException -> 0x00f9 }
        r9 = r4[r8];	 Catch:{ JSONException -> 0x00f9 }
        r10 = r14[r8];	 Catch:{ JSONException -> 0x00f9 }
        r9 = r9 - r10;	 Catch:{ JSONException -> 0x00f9 }
        r9 = r12.m30201a(r9);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r9);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "y";	 Catch:{ JSONException -> 0x00f9 }
        r9 = 1;	 Catch:{ JSONException -> 0x00f9 }
        r10 = r4[r9];	 Catch:{ JSONException -> 0x00f9 }
        r11 = r14[r9];	 Catch:{ JSONException -> 0x00f9 }
        r10 = r10 - r11;	 Catch:{ JSONException -> 0x00f9 }
        r10 = r12.m30201a(r10);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r10);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "relative_to";	 Catch:{ JSONException -> 0x00f9 }
        r10 = "ad_view";	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r10);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "frame";	 Catch:{ JSONException -> 0x00f9 }
        r5.put(r7, r6);	 Catch:{ JSONException -> 0x00f9 }
        r6 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x00f9 }
        r6.<init>();	 Catch:{ JSONException -> 0x00f9 }
        r7 = r3.getLocalVisibleRect(r6);	 Catch:{ JSONException -> 0x00f9 }
        if (r7 == 0) goto L_0x0094;	 Catch:{ JSONException -> 0x00f9 }
    L_0x008f:
        r4 = r12.m30202a(r6);	 Catch:{ JSONException -> 0x00f9 }
        goto L_0x00c7;	 Catch:{ JSONException -> 0x00f9 }
    L_0x0094:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f9 }
        r6.<init>();	 Catch:{ JSONException -> 0x00f9 }
        r7 = "width";	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "height";	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "x";	 Catch:{ JSONException -> 0x00f9 }
        r10 = r4[r8];	 Catch:{ JSONException -> 0x00f9 }
        r8 = r14[r8];	 Catch:{ JSONException -> 0x00f9 }
        r10 = r10 - r8;	 Catch:{ JSONException -> 0x00f9 }
        r8 = r12.m30201a(r10);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f9 }
        r7 = "y";	 Catch:{ JSONException -> 0x00f9 }
        r4 = r4[r9];	 Catch:{ JSONException -> 0x00f9 }
        r8 = r14[r9];	 Catch:{ JSONException -> 0x00f9 }
        r4 = r4 - r8;	 Catch:{ JSONException -> 0x00f9 }
        r4 = r12.m30201a(r4);	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r7, r4);	 Catch:{ JSONException -> 0x00f9 }
        r4 = "relative_to";	 Catch:{ JSONException -> 0x00f9 }
        r7 = "ad_view";	 Catch:{ JSONException -> 0x00f9 }
        r6.put(r4, r7);	 Catch:{ JSONException -> 0x00f9 }
        r4 = r6;	 Catch:{ JSONException -> 0x00f9 }
    L_0x00c7:
        r6 = "visible_bounds";	 Catch:{ JSONException -> 0x00f9 }
        r5.put(r6, r4);	 Catch:{ JSONException -> 0x00f9 }
        r4 = r3 instanceof android.widget.TextView;	 Catch:{ JSONException -> 0x00f9 }
        if (r4 == 0) goto L_0x00ee;	 Catch:{ JSONException -> 0x00f9 }
    L_0x00d0:
        r3 = (android.widget.TextView) r3;	 Catch:{ JSONException -> 0x00f9 }
        r4 = "text_color";	 Catch:{ JSONException -> 0x00f9 }
        r6 = r3.getCurrentTextColor();	 Catch:{ JSONException -> 0x00f9 }
        r5.put(r4, r6);	 Catch:{ JSONException -> 0x00f9 }
        r4 = "font_size";	 Catch:{ JSONException -> 0x00f9 }
        r6 = r3.getTextSize();	 Catch:{ JSONException -> 0x00f9 }
        r6 = (double) r6;	 Catch:{ JSONException -> 0x00f9 }
        r5.put(r4, r6);	 Catch:{ JSONException -> 0x00f9 }
        r4 = "text";	 Catch:{ JSONException -> 0x00f9 }
        r3 = r3.getText();	 Catch:{ JSONException -> 0x00f9 }
        r5.put(r4, r3);	 Catch:{ JSONException -> 0x00f9 }
    L_0x00ee:
        r2 = r2.getKey();	 Catch:{ JSONException -> 0x00f9 }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x00f9 }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x00f9 }
        goto L_0x0018;
    L_0x00f9:
        r2 = "Unable to get asset views information";	 Catch:{ all -> 0x0102 }
        com.google.android.gms.internal.ads.mt.m19924e(r2);	 Catch:{ all -> 0x0102 }
        goto L_0x0018;	 Catch:{ all -> 0x0102 }
    L_0x0100:
        monitor-exit(r13);	 Catch:{ all -> 0x0102 }
        return r0;	 Catch:{ all -> 0x0102 }
    L_0x0102:
        r14 = move-exception;	 Catch:{ all -> 0x0102 }
        monitor-exit(r13);	 Catch:{ all -> 0x0102 }
        throw r14;
    L_0x0105:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.a(java.util.Map, android.view.View):org.json.JSONObject");
    }

    /* renamed from: a */
    private final void m30204a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6) {
        C2872v.b("Invalid call from a non-UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.f23803g);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            jSONObject = new JSONObject();
            jSONObject.put("asset_id", str);
            jSONObject.put("template", this.f23805i.mo6085k());
            ax.g();
            jSONObject.put("is_privileged_process", kc.m19754e());
            boolean z = true;
            if (((Boolean) aph.m18688f().m18889a(asp.ck)).booleanValue() && this.f23802f.m18936a() != null && this.f23803g.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject.put("timestamp", ax.l().a());
            jSONObject.put("has_custom_click_handler", this.f23800d.m18975b(this.f23805i.mo6086l()) != null);
            String str2 = "has_custom_click_handler";
            if (this.f23800d.m18975b(this.f23805i.mo6086l()) == null) {
                z = false;
            }
            jSONObject7.put(str2, z);
            try {
                jSONObject2 = this.f23803g.optJSONObject("tracking_urls_and_actions");
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject.put("click_signals", this.f23806j.m18432a().mo3811a(this.f23801e, jSONObject2.optString("click_string"), view));
            } catch (Throwable e) {
                mt.m19919b("Exception obtaining click signals", e);
            }
            jSONObject7.put("click", jSONObject);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.f23808l);
            nb.m19936a(this.f23804h.mo4224b(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (Throwable e2) {
            mt.m19919b("Unable to create click JSON.", e2);
        }
    }

    /* renamed from: a */
    private final boolean m30205a(String str) {
        JSONObject optJSONObject = this.f23803g == null ? null : this.f23803g.optJSONObject("allow_pub_event_reporting");
        return optJSONObject == null ? false : optJSONObject.optBoolean(str, false);
    }

    /* renamed from: a */
    private final boolean m30206a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        C2872v.b("Invalid call from a non-UI thread.");
        if (this.f23797a) {
            return true;
        }
        this.f23797a = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f23803g);
            jSONObject6.put("ads_id", this.f23808l);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            nb.m19936a(this.f23804h.mo4226c(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.f23800d.m18974a((auf) this);
            this.f23800d.m18966B();
            mo3990j();
            return true;
        } catch (Throwable e) {
            mt.m19919b("Unable to create impression JSON.", e);
            return false;
        }
    }

    /* renamed from: e */
    private static boolean m30207e(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    /* renamed from: f */
    private static int[] m30208f(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    /* renamed from: g */
    private final org.json.JSONObject m30209g(android.view.View r8) {
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
        r7 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r8 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = m30208f(r8);	 Catch:{ Exception -> 0x0091 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0091 }
        r2.<init>();	 Catch:{ Exception -> 0x0091 }
        r3 = "width";	 Catch:{ Exception -> 0x0091 }
        r4 = r8.getMeasuredWidth();	 Catch:{ Exception -> 0x0091 }
        r4 = r7.m30201a(r4);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0091 }
        r3 = "height";	 Catch:{ Exception -> 0x0091 }
        r4 = r8.getMeasuredHeight();	 Catch:{ Exception -> 0x0091 }
        r4 = r7.m30201a(r4);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0091 }
        r3 = "x";	 Catch:{ Exception -> 0x0091 }
        r4 = 0;	 Catch:{ Exception -> 0x0091 }
        r5 = r1[r4];	 Catch:{ Exception -> 0x0091 }
        r5 = r7.m30201a(r5);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r5);	 Catch:{ Exception -> 0x0091 }
        r3 = "y";	 Catch:{ Exception -> 0x0091 }
        r5 = 1;	 Catch:{ Exception -> 0x0091 }
        r6 = r1[r5];	 Catch:{ Exception -> 0x0091 }
        r6 = r7.m30201a(r6);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r6);	 Catch:{ Exception -> 0x0091 }
        r3 = "relative_to";	 Catch:{ Exception -> 0x0091 }
        r6 = "window";	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r6);	 Catch:{ Exception -> 0x0091 }
        r3 = "frame";	 Catch:{ Exception -> 0x0091 }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x0091 }
        r2 = new android.graphics.Rect;	 Catch:{ Exception -> 0x0091 }
        r2.<init>();	 Catch:{ Exception -> 0x0091 }
        r8 = r8.getGlobalVisibleRect(r2);	 Catch:{ Exception -> 0x0091 }
        if (r8 == 0) goto L_0x005f;	 Catch:{ Exception -> 0x0091 }
    L_0x005a:
        r8 = r7.m30202a(r2);	 Catch:{ Exception -> 0x0091 }
        goto L_0x008b;	 Catch:{ Exception -> 0x0091 }
    L_0x005f:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0091 }
        r8.<init>();	 Catch:{ Exception -> 0x0091 }
        r2 = "width";	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r4);	 Catch:{ Exception -> 0x0091 }
        r2 = "height";	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r4);	 Catch:{ Exception -> 0x0091 }
        r2 = "x";	 Catch:{ Exception -> 0x0091 }
        r3 = r1[r4];	 Catch:{ Exception -> 0x0091 }
        r3 = r7.m30201a(r3);	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r3);	 Catch:{ Exception -> 0x0091 }
        r2 = "y";	 Catch:{ Exception -> 0x0091 }
        r1 = r1[r5];	 Catch:{ Exception -> 0x0091 }
        r1 = r7.m30201a(r1);	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r1);	 Catch:{ Exception -> 0x0091 }
        r1 = "relative_to";	 Catch:{ Exception -> 0x0091 }
        r2 = "window";	 Catch:{ Exception -> 0x0091 }
        r8.put(r1, r2);	 Catch:{ Exception -> 0x0091 }
    L_0x008b:
        r1 = "visible_bounds";	 Catch:{ Exception -> 0x0091 }
        r0.put(r1, r8);	 Catch:{ Exception -> 0x0091 }
        goto L_0x0096;
    L_0x0091:
        r8 = "Unable to get native ad view bounding box";
        com.google.android.gms.internal.ads.mt.m19924e(r8);
    L_0x0096:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.g(android.view.View):org.json.JSONObject");
    }

    /* renamed from: h */
    private static org.json.JSONObject m30210h(android.view.View r3) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r3 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ Exception -> 0x001a }
        r3 = com.google.android.gms.internal.ads.jw.m19721d(r3);	 Catch:{ Exception -> 0x001a }
        r1 = "contained_in_scroll_view";	 Catch:{ Exception -> 0x001a }
        r2 = -1;	 Catch:{ Exception -> 0x001a }
        if (r3 == r2) goto L_0x0016;	 Catch:{ Exception -> 0x001a }
    L_0x0014:
        r3 = 1;	 Catch:{ Exception -> 0x001a }
        goto L_0x0017;	 Catch:{ Exception -> 0x001a }
    L_0x0016:
        r3 = 0;	 Catch:{ Exception -> 0x001a }
    L_0x0017:
        r0.put(r1, r3);	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.h(android.view.View):org.json.JSONObject");
    }

    /* renamed from: i */
    private final org.json.JSONObject m30211i(android.view.View r3) {
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
        r2 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r3 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = "can_show_on_lock_screen";	 Catch:{ JSONException -> 0x0023 }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ JSONException -> 0x0023 }
        r3 = com.google.android.gms.internal.ads.jw.m19719c(r3);	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x0023 }
        r3 = "is_keyguard_locked";	 Catch:{ JSONException -> 0x0023 }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ JSONException -> 0x0023 }
        r1 = r2.f23801e;	 Catch:{ JSONException -> 0x0023 }
        r1 = com.google.android.gms.internal.ads.jw.m19732j(r1);	 Catch:{ JSONException -> 0x0023 }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x0023 }
        goto L_0x0028;
    L_0x0023:
        r3 = "Unable to get lock screen information";
        com.google.android.gms.internal.ads.mt.m19924e(r3);
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.i(android.view.View):org.json.JSONObject");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public android.view.View mo3969a(android.view.View.OnClickListener r7, boolean r8) {
        /*
        r6 = this;
        r0 = r6.f23805i;
        r0 = r0.mo6087m();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r7 = 0;
        return r7;
    L_0x000a:
        r1 = new android.widget.RelativeLayout$LayoutParams;
        r2 = -2;
        r1.<init>(r2, r2);
        if (r8 != 0) goto L_0x0038;
    L_0x0012:
        r8 = r0.m37025h();
        r2 = 9;
        r3 = 10;
        if (r8 == 0) goto L_0x0032;
    L_0x001c:
        r4 = 12;
        r5 = 11;
        switch(r8) {
            case 2: goto L_0x002e;
            case 3: goto L_0x002a;
            default: goto L_0x0023;
        };
    L_0x0023:
        r1.addRule(r3);
    L_0x0026:
        r1.addRule(r5);
        goto L_0x0038;
    L_0x002a:
        r1.addRule(r4);
        goto L_0x0035;
    L_0x002e:
        r1.addRule(r4);
        goto L_0x0026;
    L_0x0032:
        r1.addRule(r3);
    L_0x0035:
        r1.addRule(r2);
    L_0x0038:
        r8 = new com.google.android.gms.internal.ads.ats;
        r2 = r6.f23801e;
        r8.<init>(r2, r0, r1);
        r8.setOnClickListener(r7);
        r7 = com.google.android.gms.internal.ads.asp.ce;
        r0 = com.google.android.gms.internal.ads.aph.m18688f();
        r7 = r0.m18889a(r7);
        r7 = (java.lang.CharSequence) r7;
        r8.setContentDescription(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.a(android.view.View$OnClickListener, boolean):android.view.View");
    }

    /* renamed from: a */
    public final void mo3970a(MotionEvent motionEvent) {
        this.f23806j.m18433a(motionEvent);
    }

    /* renamed from: a */
    public void mo3971a(View view) {
        if (!((Boolean) aph.m18688f().m18889a(asp.ck)).booleanValue()) {
            return;
        }
        if (this.f23803g.optBoolean("custom_one_point_five_click_enabled", false)) {
            Object obj = this.f23802f;
            if (view != null) {
                view.setOnClickListener(obj);
                view.setClickable(true);
                obj.f14994c = new WeakReference(view);
            }
            return;
        }
        mt.m19924e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
    }

    /* renamed from: a */
    public final void mo3972a(android.view.View r4, com.google.android.gms.internal.ads.aud r5) {
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
        r3 = this;
        r5 = r3.m30228b(r4, r5);
        if (r5 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r5 = new android.widget.FrameLayout$LayoutParams;
        r0 = -1;
        r5.<init>(r0, r0);
        r0 = r4;
        r0 = (android.widget.FrameLayout) r0;
        r0.removeAllViews();
        r0 = r3.f23805i;
        r0 = r0 instanceof com.google.android.gms.internal.ads.auj;
        if (r0 != 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r0 = r3.f23805i;
        r0 = (com.google.android.gms.internal.ads.auj) r0;
        r1 = r0.mo4011b();
        if (r1 == 0) goto L_0x006b;
    L_0x0024:
        r1 = r0.mo4011b();
        r1 = r1.size();
        if (r1 <= 0) goto L_0x006b;
    L_0x002e:
        r0 = r0.mo4011b();
        r1 = 0;
        r0 = r0.get(r1);
        r1 = r0 instanceof android.os.IBinder;
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r0 = (android.os.IBinder) r0;
        r0 = com.google.android.gms.internal.ads.ave.m30251a(r0);
        goto L_0x0043;
    L_0x0042:
        r0 = 0;
    L_0x0043:
        if (r0 == 0) goto L_0x006b;
    L_0x0045:
        r0 = r0.mo3996a();	 Catch:{ RemoteException -> 0x0066 }
        if (r0 == 0) goto L_0x0065;	 Catch:{ RemoteException -> 0x0066 }
    L_0x004b:
        r0 = com.google.android.gms.p174b.C4757d.a(r0);	 Catch:{ RemoteException -> 0x0066 }
        r0 = (android.graphics.drawable.Drawable) r0;	 Catch:{ RemoteException -> 0x0066 }
        r1 = new android.widget.ImageView;	 Catch:{ RemoteException -> 0x0066 }
        r2 = r3.f23801e;	 Catch:{ RemoteException -> 0x0066 }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x0066 }
        r1.setImageDrawable(r0);	 Catch:{ RemoteException -> 0x0066 }
        r0 = android.widget.ImageView.ScaleType.CENTER_INSIDE;	 Catch:{ RemoteException -> 0x0066 }
        r1.setScaleType(r0);	 Catch:{ RemoteException -> 0x0066 }
        r4 = (android.widget.FrameLayout) r4;	 Catch:{ RemoteException -> 0x0066 }
        r4.addView(r1, r5);	 Catch:{ RemoteException -> 0x0066 }
    L_0x0065:
        return;
    L_0x0066:
        r4 = "Could not get drawable from image";
        com.google.android.gms.internal.ads.mt.m19924e(r4);
    L_0x006b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.a(android.view.View, com.google.android.gms.internal.ads.aud):void");
    }

    /* renamed from: a */
    public final void mo3973a(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2) {
        JSONObject jSONObject;
        Throwable e;
        JSONObject a = m30203a((Map) map, view2);
        JSONObject g = m30209g(view2);
        JSONObject h = m30210h(view2);
        JSONObject i = m30211i(view2);
        JSONObject jSONObject2 = null;
        try {
            JSONObject a2 = ax.e().m19736a(bundle, null);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("click_point", a2);
                jSONObject3.put("asset_id", str);
                jSONObject = jSONObject3;
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject3;
                mt.m19919b("Error occurred while grabbing click signals.", e);
                jSONObject = jSONObject2;
                m30204a(view, g, a, h, i, str, jSONObject, null);
            }
        } catch (Exception e3) {
            e = e3;
            mt.m19919b("Error occurred while grabbing click signals.", e);
            jSONObject = jSONObject2;
            m30204a(view, g, a, h, i, str, jSONObject, null);
        }
        m30204a(view, g, a, h, i, str, jSONObject, null);
    }

    /* renamed from: a */
    public void mo3974a(View view, Map<String, WeakReference<View>> map) {
        m30206a(m30209g(view), m30203a((Map) map, view), m30210h(view), m30211i(view), null);
    }

    /* renamed from: a */
    public void mo3975a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        String str;
        C2872v.b("Invalid call from a non-UI thread.");
        if (map != null) {
            synchronized (map) {
                for (Entry entry : map.entrySet()) {
                    if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                        mo3973a(view, (String) entry.getKey(), bundle, (Map) map, view2);
                        return;
                    }
                }
            }
        }
        if ("6".equals(this.f23805i.mo6085k())) {
            str = "3099";
        } else if ("2".equals(this.f23805i.mo6085k())) {
            str = "2099";
        } else {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f23805i.mo6085k())) {
                mo3973a(view, "1099", bundle, (Map) map, view2);
            }
            return;
        }
        mo3973a(view, str, bundle, (Map) map, view2);
    }

    /* renamed from: a */
    public void mo6089a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) aph.m18688f().m18889a(asp.cb)).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        View view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(onTouchListener);
                            view2.setClickable(true);
                            view2.setOnClickListener(onClickListener);
                        }
                    }
                }
            }
            if (map2 != null) {
                synchronized (map2) {
                    for (Entry value2 : map2.entrySet()) {
                        View view3 = (View) ((WeakReference) value2.getValue()).get();
                        if (view3 != null) {
                            view3.setOnTouchListener(onTouchListener);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3976a(awx awx) {
        if (!((Boolean) aph.m18688f().m18889a(asp.ck)).booleanValue()) {
            return;
        }
        if (this.f23803g.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f23802f.m18937a(awx);
        } else {
            mt.m19924e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    /* renamed from: a */
    public final void m30221a(Map<String, WeakReference<View>> map) {
        if (this.f23805i.mo6088o() != null) {
            if ("2".equals(this.f23805i.mo6085k())) {
                ax.i().m30847l().m19652a(this.f23800d.m18967C(), this.f23805i.mo6085k(), map.containsKey("2011"));
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f23805i.mo6085k())) {
                ax.i().m30847l().m19652a(this.f23800d.m18967C(), this.f23805i.mo6085k(), map.containsKey("1009"));
            }
        }
    }

    /* renamed from: a */
    public boolean mo3977a() {
        atp m = this.f23805i.mo6087m();
        return m != null && m.m37026i();
    }

    /* renamed from: a */
    public final boolean mo3978a(Bundle bundle) {
        if (m30205a("impression_reporting")) {
            return m30206a(null, null, null, null, ax.e().m19736a(bundle, null));
        }
        mt.m19920c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    /* renamed from: b */
    public final void mo3979b(Bundle bundle) {
        if (bundle == null) {
            mt.m19918b("Click data is null. No click is reported.");
        } else if (m30205a("click_reporting")) {
            m30204a(null, null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, ax.e().m19736a(bundle, null));
        } else {
            mt.m19920c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        }
    }

    /* renamed from: b */
    public final void mo3980b(View view) {
        if (((Boolean) aph.m18688f().m18889a(asp.bG)).booleanValue() && this.f23806j != null) {
            ahe a = this.f23806j.m18432a();
            if (a != null) {
                a.mo3815a(view);
            }
        }
    }

    /* renamed from: b */
    public void mo3981b(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) aph.m18688f().m18889a(asp.ca)).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        View view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(null);
                            view2.setClickable(false);
                            view2.setOnClickListener(null);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo3982b() {
        return this.f23803g != null && this.f23803g.optBoolean("allow_pub_owned_ad_view", false);
    }

    /* renamed from: b */
    public final boolean m30228b(View view, aud aud) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        View o = this.f23805i.mo6088o();
        if (o == null) {
            return false;
        }
        ViewParent parent = o.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(o);
        }
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.removeAllViews();
        frameLayout.addView(o, layoutParams);
        this.f23800d.m18973a(aud);
        return true;
    }

    /* renamed from: c */
    public void mo3983c() {
        if (!((Boolean) aph.m18688f().m18889a(asp.ck)).booleanValue()) {
            return;
        }
        if (this.f23803g.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f23802f.m18938b();
        } else {
            mt.m19924e("Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    /* renamed from: c */
    public final void mo3984c(Bundle bundle) {
        if (bundle == null) {
            mt.m19918b("Touch event data is null. No touch event is reported.");
        } else if (m30205a("touch_reporting")) {
            this.f23806j.m18432a().mo3813a((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
        } else {
            mt.m19920c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        }
    }

    /* renamed from: c */
    public final void mo3985c(View view) {
        this.f23810n = new WeakReference(view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final void mo3986c(android.view.View r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5) {
        /*
        r3 = this;
        r0 = r3.f23799c;
        monitor-enter(r0);
        r1 = r3.f23797a;	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0009:
        r1 = m30207e(r4);	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0014;
    L_0x000f:
        r3.mo3974a(r4, r5);	 Catch:{ all -> 0x005e }
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0014:
        r1 = com.google.android.gms.internal.ads.asp.cj;	 Catch:{ all -> 0x005e }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x005e }
        r1 = r2.m18889a(r1);	 Catch:{ all -> 0x005e }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x005e }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x005c;
    L_0x0026:
        if (r5 == 0) goto L_0x005c;
    L_0x0028:
        monitor-enter(r5);	 Catch:{ all -> 0x005e }
        r1 = r5.entrySet();	 Catch:{ all -> 0x0059 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0059 }
    L_0x0031:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0057;
    L_0x0037:
        r2 = r1.next();	 Catch:{ all -> 0x0059 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x0059 }
        r2 = r2.getValue();	 Catch:{ all -> 0x0059 }
        r2 = (java.lang.ref.WeakReference) r2;	 Catch:{ all -> 0x0059 }
        r2 = r2.get();	 Catch:{ all -> 0x0059 }
        r2 = (android.view.View) r2;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0031;
    L_0x004b:
        r2 = m30207e(r2);	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0031;
    L_0x0051:
        r3.mo3974a(r4, r5);	 Catch:{ all -> 0x0059 }
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0057:
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        goto L_0x005c;
    L_0x0059:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        throw r4;	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x005e:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.c(android.view.View, java.util.Map):void");
    }

    /* renamed from: d */
    public void mo3987d() {
        C2872v.b("Invalid call from a non-UI thread.");
        if (!this.f23798b) {
            this.f23798b = true;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad", this.f23803g);
                jSONObject.put("ads_id", this.f23808l);
                nb.m19936a(this.f23804h.mo4227d(jSONObject), "NativeAdEngineImpl.recordDownloadedImpression");
            } catch (Throwable e) {
                mt.m19919b("", e);
            }
        }
    }

    /* renamed from: d */
    public final void m30234d(View view) {
        this.f23800d.m18976b(view);
    }

    /* renamed from: g */
    public qo mo6090g() {
        if (this.f23803g != null) {
            if (this.f23803g.optJSONObject("overlay") != null) {
                ax.f();
                Context context = this.f23801e;
                aou a = aou.m36925a(this.f23801e);
                qo a2 = qv.m20039a(context, sc.m20090a(a), a.f28279a, false, false, this.f23806j, this.f23807k, null, null, null, amx.m18642a());
                if (a2 != null) {
                    a2.getView().setVisibility(8);
                    new aum(a2).m18987a(this.f23804h);
                }
                return a2;
            }
        }
        return null;
    }

    /* renamed from: h */
    public void mo3988h() {
        this.f23804h.mo4221a();
    }

    /* renamed from: i */
    public void mo3989i() {
        this.f23800d.m18969O();
    }

    /* renamed from: j */
    public void mo3990j() {
        this.f23800d.m18968K();
    }

    /* renamed from: k */
    public void mo3991k() {
        this.f23800d.m18970P();
    }

    /* renamed from: l */
    public final View mo3992l() {
        return this.f23810n != null ? (View) this.f23810n.get() : null;
    }

    /* renamed from: m */
    public final Context mo3993m() {
        return this.f23801e;
    }

    /* renamed from: n */
    public final ih m30242n() {
        if (!ax.B().m19545c(this.f23801e)) {
            return null;
        }
        if (this.f23809m == null) {
            this.f23809m = new ih(this.f23801e, this.f23800d.m18967C());
        }
        return this.f23809m;
    }
}
