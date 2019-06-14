package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;

/* renamed from: com.facebook.ads.internal.view.f.c.g */
public class C4597g extends C3639c {
    /* renamed from: a */
    private final ImageView f12509a;
    /* renamed from: b */
    private final C1402f<C3656j> f12510b = new C36771(this);
    /* renamed from: c */
    private final C1402f<C3648b> f12511c = new C36782(this);

    /* renamed from: com.facebook.ads.internal.view.f.c.g$1 */
    class C36771 extends C1402f<C3656j> {
        /* renamed from: a */
        final /* synthetic */ C4597g f9806a;

        C36771(C4597g c4597g) {
            this.f9806a = c4597g;
        }

        /* renamed from: a */
        public Class<C3656j> mo930a() {
            return C3656j.class;
        }

        /* renamed from: a */
        public void m12005a(C3656j c3656j) {
            this.f9806a.setVisibility(8);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.c.g$2 */
    class C36782 extends C1402f<C3648b> {
        /* renamed from: a */
        final /* synthetic */ C4597g f9807a;

        C36782(C4597g c4597g) {
            this.f9807a = c4597g;
        }

        /* renamed from: a */
        public Class<C3648b> mo930a() {
            return C3648b.class;
        }

        /* renamed from: a */
        public void m12008a(C3648b c3648b) {
            this.f9807a.setVisibility(0);
        }
    }

    public C4597g(Context context) {
        super(context);
        this.f12509a = new ImageView(context);
        this.f12509a.setScaleType(ScaleType.FIT_CENTER);
        C1523w.m5342a(this.f12509a, -16777216);
        this.f12509a.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.f12509a);
    }

    /* renamed from: a */
    protected void mo2877a() {
        super.mo2877a();
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4804a(this.f12510b, this.f12511c);
        }
    }

    /* renamed from: a */
    public void m15852a(String str, C1578e c1578e) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        C1577d a = new C1577d(this.f12509a).m5504a();
        if (c1578e != null) {
            a.m5506a(c1578e);
        }
        a.m5508a(str);
    }

    /* renamed from: b */
    protected void mo2878b() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().m4806b(this.f12511c, this.f12510b);
        }
        super.mo2878b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f12509a.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setImage(String str) {
        m15852a(str, null);
    }
}
