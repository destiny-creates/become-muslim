package com.facebook.ads.internal.view.p120f;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.p087b.C1347b;
import com.facebook.ads.internal.p087b.C1349c;
import com.facebook.ads.internal.p087b.C1349c.C1348a;
import com.facebook.ads.internal.p087b.C3573a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1513p;
import com.facebook.ads.internal.p105q.p106a.C1522v;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.f.c */
public class C3684c implements C1513p<Bundle> {
    /* renamed from: a */
    private final String f9838a;
    /* renamed from: b */
    private boolean f9839b;
    /* renamed from: c */
    private final Context f9840c;
    /* renamed from: d */
    private final C1412c f9841d;
    /* renamed from: e */
    private final C1628a f9842e;
    /* renamed from: f */
    private final C3573a f9843f;
    /* renamed from: g */
    private int f9844g;
    /* renamed from: h */
    private int f9845h;
    /* renamed from: i */
    private final C1661e f9846i;
    /* renamed from: j */
    private final Map<String, String> f9847j;

    /* renamed from: com.facebook.ads.internal.view.f.c$a */
    public interface C1628a {
        /* renamed from: g */
        boolean mo1033g();

        int getCurrentPositionInMillis();

        boolean getGlobalVisibleRect(Rect rect);

        long getInitialBufferTime();

        int getMeasuredHeight();

        int getMeasuredWidth();

        C1624a getVideoStartReason();

        float getVolume();

        /* renamed from: h */
        boolean mo1038h();
    }

    /* renamed from: com.facebook.ads.internal.view.f.c$b */
    protected enum C1629b {
        PLAY(0),
        SKIP(1),
        TIME(2),
        MRC(3),
        PAUSE(4),
        RESUME(5),
        MUTE(6),
        UNMUTE(7),
        VIEWABLE_IMPRESSION(10);
        
        /* renamed from: j */
        public final int f4899j;

        private C1629b(int i) {
            this.f4899j = i;
        }
    }

    public C3684c(Context context, C1412c c1412c, C1628a c1628a, List<C1347b> list, String str) {
        this(context, c1412c, c1628a, list, str, null);
    }

    public C3684c(Context context, C1412c c1412c, C1628a c1628a, List<C1347b> list, String str, Bundle bundle) {
        this(context, c1412c, c1628a, list, str, bundle, null);
    }

    public C3684c(Context context, C1412c c1412c, C1628a c1628a, List<C1347b> list, String str, Bundle bundle, Map<String, String> map) {
        C1628a c1628a2 = c1628a;
        List<C1347b> list2 = list;
        Bundle bundle2 = bundle;
        this.f9839b = true;
        this.f9844g = 0;
        this.f9845h = 0;
        this.f9840c = context;
        this.f9841d = c1412c;
        this.f9842e = c1628a2;
        this.f9838a = str;
        this.f9847j = map;
        list2.add(new C1347b(this, 0.5d, -1.0d, 2.0d, true) {
            /* renamed from: a */
            final /* synthetic */ C3684c f9788a;

            /* renamed from: a */
            protected void mo932a(boolean z, boolean z2, C1349c c1349c) {
                if (z2) {
                    this.f9788a.f9841d.mo950e(this.f9788a.f9838a, this.f9788a.m12038a(C1629b.MRC));
                }
            }
        });
        list2.add(new C1347b(this, 1.0E-7d, -1.0d, 0.001d, false) {
            /* renamed from: a */
            final /* synthetic */ C3684c f9789a;

            /* renamed from: a */
            protected void mo932a(boolean z, boolean z2, C1349c c1349c) {
                if (z2) {
                    this.f9789a.f9841d.mo950e(this.f9789a.f9838a, this.f9789a.m12038a(C1629b.VIEWABLE_IMPRESSION));
                }
            }
        });
        if (bundle2 != null) {
            r9.f9843f = new C3573a((View) c1628a2, list2, bundle2.getBundle("adQualityManager"));
            r9.f9844g = bundle2.getInt("lastProgressTimeMS");
            r9.f9845h = bundle2.getInt("lastBoundaryTimeMS");
        } else {
            r9.f9843f = new C3573a((View) c1628a2, list2);
        }
        r9.f9846i = new C1661e(new Handler(), this);
    }

    /* renamed from: a */
    private Map<String, String> m12038a(C1629b c1629b) {
        return m12039a(c1629b, this.f9842e.getCurrentPositionInMillis());
    }

    /* renamed from: a */
    private Map<String, String> m12039a(C1629b c1629b, int i) {
        Map<String, String> c = m12048c(i);
        c.put(NativeProtocol.WEB_DIALOG_ACTION, String.valueOf(c1629b.f4899j));
        return c;
    }

    /* renamed from: a */
    private void mo2876a() {
        this.f9841d.mo950e(this.f9838a, m12038a(C1629b.MUTE));
    }

    /* renamed from: a */
    private void m12042a(int i, boolean z) {
        if (((double) i) > 0.0d) {
            if (i >= this.f9844g) {
                if (i > this.f9844g) {
                    this.f9843f.m11635a((double) (((float) (i - this.f9844g)) / 1000.0f), (double) m12056d());
                    this.f9844g = i;
                    if (i - this.f9845h >= 5000) {
                        this.f9841d.mo950e(this.f9838a, m12039a(C1629b.TIME, i));
                        this.f9845h = this.f9844g;
                        this.f9843f.m11634a();
                        return;
                    }
                }
                if (z) {
                    this.f9841d.mo950e(this.f9838a, m12039a(C1629b.TIME, i));
                }
            }
        }
    }

    /* renamed from: a */
    private void m12043a(HashMap<String, String> hashMap) {
        if (this.f9847j != null) {
            hashMap.putAll(this.f9847j);
        }
    }

    /* renamed from: a */
    private void m12044a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.f9842e.mo1033g()));
        map.put("prep", Long.toString(this.f9842e.getInitialBufferTime()));
    }

    /* renamed from: a */
    private void m12045a(Map<String, String> map, int i) {
        map.put("ptime", String.valueOf(((float) this.f9845h) / 1000.0f));
        map.put("time", String.valueOf(((float) i) / 1000.0f));
    }

    /* renamed from: b */
    private void m12047b(Map<String, String> map) {
        C1349c c = this.f9843f.m11637c();
        C1348a c2 = c.m4631c();
        map.put("vwa", String.valueOf(c2.m4622d()));
        map.put("vwm", String.valueOf(c2.m4621c()));
        map.put("vwmax", String.valueOf(c2.m4623e()));
        map.put("vtime_ms", String.valueOf(c2.m4625g() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(c2.m4626h() * 1000.0d));
        C1348a d = c.m4632d();
        map.put("vla", String.valueOf(d.m4622d()));
        map.put("vlm", String.valueOf(d.m4621c()));
        map.put("vlmax", String.valueOf(d.m4623e()));
        map.put("atime_ms", String.valueOf(d.m4625g() * 1000.0d));
        map.put("mcat_ms", String.valueOf(d.m4626h() * 1000.0d));
    }

    /* renamed from: c */
    private Map<String, String> m12048c(int i) {
        HashMap hashMap = new HashMap();
        C1522v.m5338a(hashMap, this.f9842e.getVideoStartReason() == C1624a.AUTO_STARTED, this.f9842e.mo1038h() ^ true);
        m12044a((Map) hashMap);
        m12047b((Map) hashMap);
        m12045a((Map) hashMap, i);
        m12049c((Map) hashMap);
        m12043a(hashMap);
        return hashMap;
    }

    /* renamed from: c */
    private void m12049c(Map<String, String> map) {
        Rect rect = new Rect();
        this.f9842e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put("pl", String.valueOf(rect.left));
        map.put(UserDataStore.PHONE, String.valueOf(this.f9842e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.f9842e.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.f9840c.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    /* renamed from: k */
    private void m12050k() {
        this.f9841d.mo950e(this.f9838a, m12038a(C1629b.UNMUTE));
    }

    /* renamed from: a */
    void m12051a(int i) {
        m12042a(i, false);
    }

    /* renamed from: a */
    void m12052a(int i, int i2) {
        m12042a(i, true);
        this.f9845h = i2;
        this.f9844g = i2;
        this.f9843f.m11634a();
        this.f9843f.m11636b();
    }

    /* renamed from: b */
    public void m12053b() {
        this.f9840c.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f9846i);
    }

    /* renamed from: b */
    public void m12054b(int i) {
        m12042a(i, true);
        this.f9845h = 0;
        this.f9844g = 0;
        this.f9843f.m11634a();
        this.f9843f.m11636b();
    }

    /* renamed from: c */
    public void m12055c() {
        this.f9840c.getContentResolver().unregisterContentObserver(this.f9846i);
    }

    /* renamed from: d */
    protected float m12056d() {
        return C1522v.m5337a(this.f9840c) * this.f9842e.getVolume();
    }

    /* renamed from: e */
    void m12057e() {
        boolean z;
        if (((double) m12056d()) < 0.05d) {
            if (this.f9839b) {
                mo2876a();
                z = false;
            } else {
                return;
            }
        } else if (!this.f9839b) {
            m12050k();
            z = true;
        } else {
            return;
        }
        this.f9839b = z;
    }

    /* renamed from: f */
    void m12058f() {
        this.f9841d.mo950e(this.f9838a, m12038a(C1629b.SKIP));
    }

    /* renamed from: g */
    public Bundle mo937g() {
        m12052a(m12062j(), m12062j());
        Bundle bundle = new Bundle();
        bundle.putInt("lastProgressTimeMS", this.f9844g);
        bundle.putInt("lastBoundaryTimeMS", this.f9845h);
        bundle.putBundle("adQualityManager", this.f9843f.mo937g());
        return bundle;
    }

    /* renamed from: h */
    void m12060h() {
        this.f9841d.mo950e(this.f9838a, m12038a(C1629b.PAUSE));
    }

    /* renamed from: i */
    void m12061i() {
        this.f9841d.mo950e(this.f9838a, m12038a(C1629b.RESUME));
    }

    /* renamed from: j */
    public int m12062j() {
        return this.f9844g;
    }
}
