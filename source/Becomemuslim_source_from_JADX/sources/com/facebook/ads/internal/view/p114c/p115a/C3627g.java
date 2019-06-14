package com.facebook.ads.internal.view.p114c.p115a;

import android.support.v7.widget.RecyclerView.C0718x;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b;
import com.facebook.ads.internal.view.component.p116a.p117a.C3630b.C1588a;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.c.a.g */
class C3627g extends C0718x {
    /* renamed from: a */
    private final C3630b f9698a;
    /* renamed from: b */
    private final int f9699b;
    /* renamed from: c */
    private final int f9700c;
    /* renamed from: d */
    private final int f9701d;
    /* renamed from: e */
    private final int f9702e;
    /* renamed from: f */
    private boolean f9703f = false;
    /* renamed from: g */
    private C1545a f9704g;
    /* renamed from: h */
    private C1544a f9705h;
    /* renamed from: i */
    private C1545a f9706i;

    C3627g(C3630b c3630b, C1545a c1545a, int i, int i2, int i3, int i4) {
        super(c3630b);
        this.f9698a = c3630b;
        this.f9706i = c1545a;
        this.f9699b = i;
        this.f9700c = i2;
        this.f9701d = i3;
        this.f9702e = i4;
    }

    /* renamed from: a */
    private String m11847a(C1364b c1364b, String str) {
        Object b = (c1364b == null || str == null) ? "" : c1364b.m4660b(str);
        return !TextUtils.isEmpty(b) ? b : str;
    }

    /* renamed from: a */
    private void m11848a(C1412c c1412c, C1520t c1520t, String str, final C1580b c1580b) {
        if (!this.f9703f) {
            if (this.f9704g != null) {
                this.f9704g.m5436c();
                this.f9704g = null;
            }
            final Map a = c1580b.m5512a();
            final String str2 = str;
            final C1520t c1520t2 = c1520t;
            final C1412c c1412c2 = c1412c;
            this.f9705h = new C1544a(this) {
                /* renamed from: e */
                final /* synthetic */ C3627g f9695e;

                /* renamed from: a */
                public void mo925a() {
                    if (!(this.f9695e.f9706i.m5435b() || TextUtils.isEmpty(str2))) {
                        if (this.f9695e.f9704g != null) {
                            this.f9695e.f9704g.m5433a(a);
                        }
                        a.put("touch", C1508k.m5306a(c1520t2.m5335e()));
                        c1412c2.mo945a(str2, a);
                    }
                    this.f9695e.f9703f = true;
                }
            };
            this.f9704g = new C1545a(this.f9698a, 10, this.f9705h);
            this.f9704g.m5432a(100);
            this.f9704g.m5434b(100);
            this.f9698a.setOnAssetsLoadedListener(new C1588a(this) {
                /* renamed from: b */
                final /* synthetic */ C3627g f9697b;

                /* renamed from: a */
                public void mo1022a() {
                    if (c1580b.m5513b() == 0) {
                        this.f9697b.f9706i.m5431a();
                    }
                    this.f9697b.f9704g.m5431a();
                }
            });
        }
    }

    /* renamed from: a */
    void m11851a(C1580b c1580b, C1412c c1412c, C1364b c1364b, C1520t c1520t, String str, boolean z) {
        int b = c1580b.m5513b();
        this.f9698a.setTag(-1593835536, Integer.valueOf(b));
        LayoutParams marginLayoutParams = new MarginLayoutParams(this.f9699b, -2);
        marginLayoutParams.setMargins(b == 0 ? this.f9700c : this.f9701d, 0, b >= this.f9702e + -1 ? this.f9700c : this.f9701d, 0);
        String g = c1580b.m5514c().m4535c().m4491g();
        String a = c1580b.m5514c().m4535c().m4484a();
        this.f9698a.setIsVideo(TextUtils.isEmpty(a) ^ 1);
        if (this.f9698a.m11865f()) {
            this.f9698a.setVideoPlaceholderUrl(g);
            this.f9698a.setVideoUrl(m11847a(c1364b, a));
            if (z) {
                this.f9698a.m11867h();
            }
        } else {
            this.f9698a.setImageUrl(g);
        }
        this.f9698a.setLayoutParams(marginLayoutParams);
        this.f9698a.m11860a(c1580b.m5514c().m4533a().m4502a(), c1580b.m5514c().m4533a().m4504c());
        this.f9698a.m11861a(c1580b.m5514c().m4534b().m4515b(), c1580b.m5514c().m4534b().m4514a(), c1580b.m5512a());
        this.f9698a.m11862a(c1580b.m5512a());
        m11848a(c1412c, c1520t, str, c1580b);
    }
}
