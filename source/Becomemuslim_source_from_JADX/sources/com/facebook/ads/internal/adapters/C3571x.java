package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.p099n.C1430l;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.x */
public class C3571x extends C1323b {
    /* renamed from: c */
    private final C3572y f9536c;
    /* renamed from: d */
    private C1430l f9537d;
    /* renamed from: e */
    private boolean f9538e;
    /* renamed from: f */
    private boolean f9539f;
    /* renamed from: g */
    private boolean f9540g;
    /* renamed from: h */
    private boolean f9541h;
    /* renamed from: i */
    private boolean f9542i;
    /* renamed from: j */
    private View f9543j;
    /* renamed from: k */
    private List<View> f9544k;
    /* renamed from: l */
    private C1345a f9545l = C1345a.ALL;

    /* renamed from: com.facebook.ads.internal.adapters.x$a */
    public enum C1345a {
        ALL("all"),
        NONE(ViewProps.NONE),
        MANUAL("manual");
        
        /* renamed from: d */
        private final String f3907d;

        private C1345a(String str) {
            this.f3907d = str;
        }

        public String toString() {
            return this.f3907d;
        }
    }

    public C3571x(Context context, C1324c c1324c, C1545a c1545a, C3572y c3572y) {
        super(context, c1324c, c1545a);
        this.f9536c = c3572y;
    }

    /* renamed from: b */
    private java.lang.String m11580b(android.view.View r1) {
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
        r0 = this;
        r1 = r0.m11581c(r1);	 Catch:{ JSONException -> 0x0009 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = "Json exception";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.x.b(android.view.View):java.lang.String");
    }

    /* renamed from: c */
    private JSONObject m11581c(View view) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        r4 = new Object[2];
        int i = 0;
        r4[0] = Integer.valueOf(view.getTop());
        boolean z = true;
        r4[1] = Integer.valueOf(view.getLeft());
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", r4));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f9544k == null || !this.f9544k.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = "unknown";
        if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof ImageView) {
            obj = MessengerShareContentUtility.MEDIA_IMAGE;
        } else if (view instanceof MediaView) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt("type", obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m11581c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    /* renamed from: d */
    private java.lang.String m11582d(android.view.View r4) {
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
        r0 = r4.getWidth();
        if (r0 <= 0) goto L_0x004d;
    L_0x0006:
        r0 = r4.getHeight();
        if (r0 > 0) goto L_0x000d;
    L_0x000c:
        goto L_0x004d;
    L_0x000d:
        r0 = r4.getWidth();	 Catch:{ Exception -> 0x004a }
        r1 = r4.getHeight();	 Catch:{ Exception -> 0x004a }
        r2 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x004a }
        r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2);	 Catch:{ Exception -> 0x004a }
        r1 = r4.getResources();	 Catch:{ Exception -> 0x004a }
        r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x004a }
        r1 = r1.densityDpi;	 Catch:{ Exception -> 0x004a }
        r0.setDensity(r1);	 Catch:{ Exception -> 0x004a }
        r1 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x004a }
        r1.<init>(r0);	 Catch:{ Exception -> 0x004a }
        r4.draw(r1);	 Catch:{ Exception -> 0x004a }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004a }
        r4.<init>();	 Catch:{ Exception -> 0x004a }
        r1 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x004a }
        r2 = r3.f9536c;	 Catch:{ Exception -> 0x004a }
        r2 = r2.mo2839h();	 Catch:{ Exception -> 0x004a }
        r0.compress(r1, r2, r4);	 Catch:{ Exception -> 0x004a }
        r4 = r4.toByteArray();	 Catch:{ Exception -> 0x004a }
        r0 = 0;	 Catch:{ Exception -> 0x004a }
        r4 = android.util.Base64.encodeToString(r4, r0);	 Catch:{ Exception -> 0x004a }
        return r4;
    L_0x004a:
        r4 = "";
        return r4;
    L_0x004d:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.x.d(android.view.View):java.lang.String");
    }

    /* renamed from: a */
    public void m11583a(View view) {
        this.f9543j = view;
    }

    /* renamed from: a */
    public void m11584a(C1345a c1345a) {
        this.f9545l = c1345a;
    }

    /* renamed from: a */
    public void m11585a(C1430l c1430l) {
        this.f9537d = c1430l;
    }

    /* renamed from: a */
    public void m11586a(List<View> list) {
        this.f9544k = list;
    }

    /* renamed from: a */
    protected void mo920a(Map<String, String> map) {
        if (this.f9536c != null) {
            if (this.f9537d != null) {
                map.put("nti", String.valueOf(this.f9537d.m5050c()));
            }
            if (this.f9538e) {
                map.put("nhs", Boolean.TRUE.toString());
            }
            if (this.f9539f) {
                map.put("nmv", Boolean.TRUE.toString());
            }
            if (this.f9540g) {
                map.put("nmvap", Boolean.TRUE.toString());
            }
            if (this.f9543j != null && this.f9536c.mo2836e()) {
                map.put("view", m11580b(this.f9543j));
            }
            if (this.f9543j != null && this.f9536c.mo2835d()) {
                map.put("snapshot", m11582d(this.f9543j));
            }
            if (this.f9541h) {
                map.put("niv", Boolean.TRUE.toString());
            }
            if (this.f9545l != null) {
                map.put("precache_media", this.f9545l.toString());
            }
            if (this.f9542i) {
                map.put("ucvr", Boolean.TRUE.toString());
            }
            this.f9536c.mo2830a((Map) map);
        }
    }

    /* renamed from: a */
    public void m11588a(boolean z) {
        this.f9538e = z;
    }

    /* renamed from: b */
    public void m11589b(boolean z) {
        this.f9539f = z;
    }

    /* renamed from: c */
    public void m11590c(boolean z) {
        this.f9540g = z;
    }

    /* renamed from: d */
    public void m11591d(boolean z) {
        this.f9541h = z;
    }

    /* renamed from: e */
    public void m11592e(boolean z) {
        this.f9542i = z;
    }
}
