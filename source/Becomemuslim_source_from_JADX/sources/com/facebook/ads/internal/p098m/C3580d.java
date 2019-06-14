package com.facebook.ads.internal.p098m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p090e.C1368a;
import com.facebook.ads.internal.p090e.C1372d;
import com.facebook.ads.internal.p094i.C1391a;
import com.facebook.ads.internal.p098m.C1407a.C1406a;
import com.facebook.ads.internal.p105q.p106a.C1511n;
import com.facebook.ads.internal.p105q.p108c.C1537e;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.m.d */
public class C3580d implements C1412c {
    /* renamed from: a */
    private static final String f9576a = "d";
    /* renamed from: b */
    private static double f9577b = 0.0d;
    /* renamed from: c */
    private static String f9578c = null;
    /* renamed from: d */
    private static volatile boolean f9579d = false;
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: h */
    private static C1412c f9580h;
    /* renamed from: e */
    private final C1411b f9581e;
    /* renamed from: f */
    private final C1372d f9582f;
    /* renamed from: g */
    private final Context f9583g;

    private C3580d(Context context) {
        this.f9583g = context.getApplicationContext();
        this.f9582f = new C1372d(context);
        this.f9581e = new C1411b(context, new C3581g(context, this.f9582f));
        this.f9581e.m4883b();
        C3580d.m11664b(context);
    }

    /* renamed from: a */
    public static synchronized C1412c m11662a(Context context) {
        C1412c c1412c;
        synchronized (C3580d.class) {
            if (f9580h == null) {
                f9580h = new C3580d(context.getApplicationContext());
            }
            c1412c = f9580h;
        }
        return c1412c;
    }

    /* renamed from: a */
    private void m11663a(final C1407a c1407a) {
        if (c1407a.m4864g()) {
            this.f9582f.m4688a(c1407a.m4858a(), c1407a.m4865h().f4137c, c1407a.m4866i().toString(), c1407a.m4859b(), c1407a.m4860c(), c1407a.m4861d(), c1407a.m4862e(), new C1368a<String>(this) {
                /* renamed from: b */
                final /* synthetic */ C3580d f9575b;

                /* renamed from: a */
                public void mo942a(int i, String str) {
                    super.mo942a(i, str);
                }

                /* renamed from: a */
                public void m11660a(String str) {
                    super.mo943a(str);
                    if (c1407a.m4863f()) {
                        this.f9575b.f9581e.m4882a();
                    } else {
                        this.f9575b.f9581e.m4883b();
                    }
                }
            });
            return;
        }
        String str = f9576a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempting to log an invalid ");
        stringBuilder.append(c1407a.m4866i());
        stringBuilder.append(" event.");
        Log.e(str, stringBuilder.toString());
    }

    /* renamed from: b */
    private static synchronized void m11664b(Context context) {
        synchronized (C3580d.class) {
            if (f9579d) {
                return;
            }
            C1391a.m4778a(context).m4779a();
            C1511n.m5312a();
            f9577b = C1511n.m5313b();
            f9578c = C1511n.m5314c();
            f9579d = true;
        }
    }

    /* renamed from: a */
    public void mo944a(String str) {
        new C1537e(this.f9583g).execute(new String[]{str});
    }

    /* renamed from: a */
    public void mo945a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.IMPRESSION).m4854a(true).m4855a());
        }
    }

    /* renamed from: a */
    public void mo946a(String str, Map<String, String> map, String str2, C1413e c1413e) {
        m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(c1413e).m4851a(C1414f.m4896a(str2)).m4854a(true).m4855a());
    }

    /* renamed from: b */
    public void mo947b(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.INVALIDATION).m4854a(false).m4855a());
        }
    }

    /* renamed from: c */
    public void mo948c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.OPEN_LINK).m4854a(true).m4855a());
        }
    }

    /* renamed from: d */
    public void mo949d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.DEFERRED).m4851a(C1414f.OFF_TARGET_CLICK).m4854a(true).m4855a());
        }
    }

    /* renamed from: e */
    public void mo950e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.VIDEO).m4854a(true).m4855a());
        }
    }

    /* renamed from: f */
    public void mo951f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.DEFERRED).m4851a(C1414f.NATIVE_VIEW).m4854a(false).m4855a());
        }
    }

    /* renamed from: g */
    public void mo952g(String str, Map<String, String> map) {
        m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.DEFERRED).m4851a(C1414f.BROWSER_SESSION).m4854a(false).m4855a());
    }

    /* renamed from: h */
    public void mo953h(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.STORE).m4854a(true).m4855a());
        }
    }

    /* renamed from: i */
    public void mo954i(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.DEFERRED).m4851a(C1414f.CLOSE).m4854a(true).m4855a());
        }
    }

    /* renamed from: j */
    public void mo955j(String str, Map<String, String> map) {
        m11663a(new C1406a().m4852a(str).m4849a(f9577b).m4856b(f9578c).m4853a((Map) map).m4850a(C1413e.IMMEDIATE).m4851a(C1414f.USER_RETURN).m4854a(true).m4855a());
    }
}
