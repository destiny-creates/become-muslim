package com.facebook.ads.internal.view.p114c.p115a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C4636t;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p123c.C3675d;
import com.facebook.ads.internal.view.p120f.p123c.C3675d.C1640a;
import com.facebook.ads.internal.view.p120f.p123c.C3676f;
import com.facebook.ads.internal.view.p120f.p123c.C4589b;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p123c.C4611l;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.c.a.e */
public class C1583e extends FrameLayout {
    /* renamed from: a */
    private static final int f4730a = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: b */
    private final C1412c f4731b;
    /* renamed from: c */
    private C4636t f4732c;
    /* renamed from: d */
    private C3676f f4733d;
    /* renamed from: e */
    private C4611l f4734e;
    /* renamed from: f */
    private C4597g f4735f;
    /* renamed from: g */
    private C4584b f4736g;

    /* renamed from: com.facebook.ads.internal.view.c.a.e$1 */
    class C15821 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C1583e f4729a;

        C15821(C1583e c1583e) {
            this.f4729a = c1583e;
        }

        public void onClick(View view) {
            this.f4729a.f4734e.performClick();
        }
    }

    public C1583e(Context context, C1412c c1412c) {
        super(context);
        this.f4731b = c1412c;
        setUpView(context);
    }

    private void setUpPlugins(Context context) {
        this.f4732c.m11919d();
        this.f4735f = new C4597g(context);
        this.f4732c.m11915a(this.f4735f);
        this.f4733d = new C3676f(context);
        this.f4732c.m11915a(new C4589b(context));
        this.f4732c.m11915a(this.f4733d);
        this.f4734e = new C4611l(context, true);
        this.f4732c.m11915a(this.f4734e);
        this.f4732c.m11915a(new C3675d(this.f4734e, C1640a.FADE_OUT_ON_PLAY, true, true));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(f4730a, f4730a, f4730a, f4730a);
        this.f4733d.setLayoutParams(layoutParams);
        this.f4732c.addView(this.f4733d);
    }

    private void setUpVideo(Context context) {
        this.f4732c = new C4636t(context);
        this.f4732c.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        C1523w.m5341a(this.f4732c);
        addView(this.f4732c);
        setOnClickListener(new C15821(this));
    }

    private void setUpView(Context context) {
        setUpVideo(context);
        setUpPlugins(context);
    }

    /* renamed from: a */
    public void m5517a() {
        this.f4732c.m11917a(true);
    }

    /* renamed from: a */
    public void m5518a(C1402f c1402f) {
        this.f4732c.getEventBus().m4805a(c1402f);
    }

    /* renamed from: a */
    public void m5519a(C1412c c1412c, String str, Map<String, String> map) {
        m5522c();
        this.f4736g = new C4584b(getContext(), c1412c, this.f4732c, str, (Map) map);
    }

    /* renamed from: a */
    public void m5520a(C1624a c1624a) {
        this.f4732c.m11914a(c1624a);
    }

    /* renamed from: b */
    public boolean m5521b() {
        return this.f4732c.m11924i();
    }

    /* renamed from: c */
    public void m5522c() {
        if (this.f4736g != null) {
            this.f4736g.mo2876a();
            this.f4736g = null;
        }
    }

    public float getVolume() {
        return this.f4732c.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.f4735f.setImage(str);
    }

    public void setVideoURI(String str) {
        this.f4732c.setVideoURI(str);
    }

    public void setVolume(float f) {
        this.f4732c.setVolume(f);
        this.f4733d.m12000a();
    }
}
