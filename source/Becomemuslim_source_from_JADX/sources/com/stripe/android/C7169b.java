package com.stripe.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.C0373d;
import com.facebook.share.internal.ShareConstants;
import com.stripe.android.C5734d.C5733b;
import com.stripe.android.p284a.C5711h;
import com.stripe.android.p285b.C7158d;
import com.stripe.android.p285b.C7160g;
import com.stripe.android.p285b.C7162i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CustomerSession */
/* renamed from: com.stripe.android.b */
public class C7169b implements C5733b {
    /* renamed from: a */
    private static final Set<String> f25407a = new HashSet(Arrays.asList(new String[]{"AddSourceActivity", "PaymentMethodsActivity", "PaymentFlowActivity", "PaymentSession", "ShippingInfoScreen", "ShippingMethodScreen"}));
    /* renamed from: n */
    private static final TimeUnit f25408n = TimeUnit.SECONDS;
    /* renamed from: o */
    private static final long f25409o = TimeUnit.MINUTES.toMillis(1);
    /* renamed from: p */
    private static C7169b f25410p;
    /* renamed from: b */
    private C7158d f25411b;
    /* renamed from: c */
    private long f25412c;
    /* renamed from: d */
    private WeakReference<Context> f25413d;
    /* renamed from: e */
    private C5717a f25414e;
    /* renamed from: f */
    private C5718b f25415f;
    /* renamed from: g */
    private C7170c f25416g;
    /* renamed from: h */
    private C5734d f25417h;
    /* renamed from: i */
    private Handler f25418i;
    /* renamed from: j */
    private Set<String> f25419j;
    /* renamed from: k */
    private Calendar f25420k;
    /* renamed from: l */
    private C5719c f25421l;
    /* renamed from: m */
    private ThreadPoolExecutor f25422m;

    /* compiled from: CustomerSession */
    /* renamed from: com.stripe.android.b$a */
    public interface C5717a {
        /* renamed from: a */
        void mo5077a(C7158d c7158d);
    }

    /* compiled from: CustomerSession */
    /* renamed from: com.stripe.android.b$b */
    public interface C5718b {
    }

    /* compiled from: CustomerSession */
    /* renamed from: com.stripe.android.b$c */
    interface C5719c {
        /* renamed from: a */
        C7158d m24165a(Context context, String str, String str2, List<String> list, C7160g c7160g, String str3);

        /* renamed from: a */
        C7158d m24166a(String str, String str2);

        /* renamed from: a */
        C7162i m24167a(Context context, String str, String str2, List<String> list, String str3, String str4, String str5);

        /* renamed from: b */
        C7158d m24168b(Context context, String str, String str2, List<String> list, String str3, String str4, String str5);
    }

    /* renamed from: a */
    public static C7169b m33350a() {
        if (f25410p != null) {
            return f25410p;
        }
        throw new IllegalStateException("Attempted to get instance of CustomerSession without initialization.");
    }

    /* renamed from: a */
    public void m33367a(String str) {
        if (str != null && f25407a.contains(str)) {
            this.f25419j.add(str);
        }
    }

    /* renamed from: a */
    public void m33365a(C5717a c5717a) {
        if (m33360d()) {
            c5717a.mo5077a(m33368b());
            return;
        }
        this.f25411b = null;
        this.f25414e = c5717a;
        this.f25417h.m24296a(null, null);
    }

    /* renamed from: b */
    public void m33369b(C5717a c5717a) {
        this.f25411b = null;
        this.f25414e = c5717a;
        this.f25417h.m24296a(null, null);
    }

    /* renamed from: b */
    public C7158d m33368b() {
        return m33360d() ? this.f25411b : null;
    }

    /* renamed from: a */
    public void m33364a(Context context, String str, String str2, C5718b c5718b) {
        this.f25413d = new WeakReference(context);
        context = new HashMap();
        context.put(ShareConstants.FEED_SOURCE_PARAM, str);
        context.put("source_type", str2);
        this.f25415f = c5718b;
        this.f25417h.m24296a("add_source", context);
    }

    /* renamed from: a */
    public void m33362a(Context context, C7160g c7160g) {
        this.f25413d = new WeakReference(context);
        context = new HashMap();
        context.put("shipping_info", c7160g);
        this.f25417h.m24296a("set_shipping_info", context);
    }

    /* renamed from: a */
    public void m33363a(Context context, String str, String str2, C5717a c5717a) {
        this.f25413d = new WeakReference(context);
        context = new HashMap();
        context.put(ShareConstants.FEED_SOURCE_PARAM, str);
        context.put("source_type", str2);
        this.f25414e = c5717a;
        this.f25417h.m24296a("default_source", context);
    }

    /* renamed from: c */
    void m33370c() {
        this.f25419j.clear();
    }

    /* renamed from: a */
    private void m33355a(WeakReference<Context> weakReference, C7170c c7170c, String str, String str2, List<String> list) {
        final WeakReference<Context> weakReference2 = weakReference;
        final C7170c c7170c2 = c7170c;
        final List<String> list2 = list;
        final String str3 = str;
        final String str4 = str2;
        m33352a(new Runnable(this) {
            /* renamed from: f */
            final /* synthetic */ C7169b f19028f;

            public void run() {
                try {
                    this.f19028f.f25418i.sendMessage(this.f19028f.f25418i.obtainMessage(13, C7169b.m33349a(weakReference2, c7170c2, new ArrayList(list2), str3, str4, this.f19028f.f25421l)));
                } catch (C5711h e) {
                    this.f19028f.f25418i.sendMessage(this.f19028f.f25418i.obtainMessage(17, e));
                    C7169b.m33353a(weakReference2, e);
                }
            }
        });
    }

    /* renamed from: d */
    private boolean m33360d() {
        return this.f25411b != null && m33361e().getTimeInMillis() - this.f25412c < f25409o;
    }

    /* renamed from: b */
    private void m33358b(WeakReference<Context> weakReference, C7170c c7170c, String str, String str2, List<String> list) {
        final WeakReference<Context> weakReference2 = weakReference;
        final C7170c c7170c2 = c7170c;
        final List<String> list2 = list;
        final String str3 = str;
        final String str4 = str2;
        m33352a(new Runnable(this) {
            /* renamed from: f */
            final /* synthetic */ C7169b f19034f;

            public void run() {
                try {
                    this.f19034f.f25418i.sendMessage(this.f19034f.f25418i.obtainMessage(7, C7169b.m33357b(weakReference2, c7170c2, new ArrayList(list2), str3, str4, this.f19034f.f25421l)));
                } catch (C5711h e) {
                    this.f19034f.f25418i.sendMessage(this.f19034f.f25418i.obtainMessage(11, e));
                    C7169b.m33353a(weakReference2, e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m33354a(WeakReference<Context> weakReference, C7170c c7170c, C7160g c7160g, List<String> list) {
        final WeakReference<Context> weakReference2 = weakReference;
        final C7170c c7170c2 = c7170c;
        final List<String> list2 = list;
        final C7160g c7160g2 = c7160g;
        m33352a(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ C7169b f19039e;

            public void run() {
                try {
                    this.f19039e.f25418i.sendMessage(this.f19039e.f25418i.obtainMessage(19, C7169b.m33348a(weakReference2, c7170c2, new ArrayList(list2), c7160g2, this.f19039e.f25421l)));
                } catch (C5711h e) {
                    this.f19039e.f25418i.sendMessage(this.f19039e.f25418i.obtainMessage(11, e));
                    C7169b.m33353a(weakReference2, e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m33351a(final C7170c c7170c) {
        m33352a(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C7169b f19041b;

            public void run() {
                try {
                    this.f19041b.f25418i.sendMessage(this.f19041b.f25418i.obtainMessage(7, C7169b.m33347a(this.f19041b.f25413d, c7170c, this.f19041b.f25421l)));
                } catch (C5711h e) {
                    this.f19041b.f25418i.sendMessage(this.f19041b.f25418i.obtainMessage(11, e));
                }
            }
        });
    }

    /* renamed from: a */
    private void m33352a(Runnable runnable) {
        if (this.f25421l != null) {
            runnable.run();
        } else {
            this.f25422m.execute(runnable);
        }
    }

    /* renamed from: a */
    public void mo5068a(C7170c c7170c, String str, Map<String, Object> map) {
        this.f25416g = c7170c;
        if (this.f25416g == null) {
            return;
        }
        if (str == null) {
            m33351a(this.f25416g);
        } else if ("add_source".equals(str) != null && this.f25413d != null && map != null && map.containsKey(ShareConstants.FEED_SOURCE_PARAM) != null && map.containsKey("source_type") != null) {
            m33355a(this.f25413d, this.f25416g, (String) map.get(ShareConstants.FEED_SOURCE_PARAM), (String) map.get("source_type"), new ArrayList(this.f25419j));
            m33370c();
        } else if ("default_source".equals(str) != null && this.f25413d != null && map != null && map.containsKey(ShareConstants.FEED_SOURCE_PARAM) != null && map.containsKey("source_type") != null) {
            m33358b(this.f25413d, this.f25416g, (String) map.get(ShareConstants.FEED_SOURCE_PARAM), (String) map.get("source_type"), new ArrayList(this.f25419j));
            m33370c();
        } else if ("set_shipping_info".equals(str) != null && this.f25413d != null && map != null && map.containsKey("shipping_info") != null) {
            m33354a(this.f25413d, this.f25416g, (C7160g) map.get("shipping_info"), new ArrayList(this.f25419j));
            m33370c();
        }
    }

    /* renamed from: e */
    private Calendar m33361e() {
        return this.f25420k == null ? Calendar.getInstance() : this.f25420k;
    }

    /* renamed from: a */
    static C7162i m33349a(WeakReference<Context> weakReference, C7170c c7170c, List<String> list, String str, String str2, C5719c c5719c) {
        if (c5719c != null) {
            return c5719c.m24167a((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), list, str, str2, c7170c.m33375e());
        }
        return C5770q.m24364a((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), list, str, str2, c7170c.m33375e(), null);
    }

    /* renamed from: a */
    static C7158d m33348a(WeakReference<Context> weakReference, C7170c c7170c, List<String> list, C7160g c7160g, C5719c c5719c) {
        if (c5719c != null) {
            return c5719c.m24165a((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), list, c7160g, c7170c.m33375e());
        }
        return C5770q.m24362a((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), (List) list, c7160g, c7170c.m33375e(), null);
    }

    /* renamed from: b */
    static C7158d m33357b(WeakReference<Context> weakReference, C7170c c7170c, List<String> list, String str, String str2, C5719c c5719c) {
        if (c5719c != null) {
            return c5719c.m24168b((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), list, str, str2, c7170c.m33375e());
        }
        return C5770q.m24389b((Context) weakReference.get(), c7170c.m33373c(), C5740i.m24307a().m24308b(), list, str, str2, c7170c.m33375e(), null);
    }

    /* renamed from: a */
    static C7158d m33347a(WeakReference<Context> weakReference, C7170c c7170c, C5719c c5719c) {
        if (c5719c != null) {
            return c5719c.m24166a(c7170c.m33373c(), c7170c.m33375e());
        }
        return C5770q.m24363a(c7170c.m33373c(), c7170c.m33375e());
    }

    /* renamed from: a */
    static void m33353a(WeakReference<Context> weakReference, C5711h c5711h) {
        if (weakReference != null) {
            if (weakReference.get() != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("exception", c5711h);
                c5711h = new Intent("action_api_exception");
                c5711h.putExtras(bundle);
                C0373d.a((Context) weakReference.get()).a(c5711h);
            }
        }
    }
}
