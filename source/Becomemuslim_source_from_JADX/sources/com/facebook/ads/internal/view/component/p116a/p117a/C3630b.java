package com.facebook.ads.internal.view.component.p116a.p117a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1676s;
import com.facebook.ads.internal.view.component.p116a.C1593b;
import com.facebook.ads.internal.view.component.p116a.C1597d;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;
import com.facebook.ads.internal.view.p114c.p115a.C1583e;
import com.facebook.ads.internal.view.p114c.p115a.C3621a;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p122b.C3668v;
import com.facebook.ads.internal.view.p120f.p122b.C3669w;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.component.a.a.b */
public abstract class C3630b extends C1593b {
    /* renamed from: c */
    private static final int f9709c = ((int) (C1523w.f4503b * 1.0f));
    /* renamed from: d */
    private static final int f9710d = ((int) (C1523w.f4503b * 4.0f));
    /* renamed from: e */
    private static final int f9711e = ((int) (C1523w.f4503b * 6.0f));
    /* renamed from: f */
    private C1676s f9712f;
    /* renamed from: g */
    private C1583e f9713g;
    /* renamed from: h */
    private RelativeLayout f9714h;
    /* renamed from: i */
    private final String f9715i;
    /* renamed from: j */
    private final Paint f9716j;
    /* renamed from: k */
    private boolean f9717k;
    /* renamed from: l */
    private C3621a f9718l;
    /* renamed from: m */
    private final Path f9719m = new Path();
    /* renamed from: n */
    private final RectF f9720n = new RectF();
    /* renamed from: o */
    private boolean f9721o;
    /* renamed from: p */
    private boolean f9722p;
    /* renamed from: q */
    private C1588a f9723q;
    /* renamed from: r */
    private final C3669w f9724r = new C45721(this);
    /* renamed from: s */
    private final C3649c f9725s = new C45732(this);
    /* renamed from: t */
    private final C3657k f9726t = new C45743(this);
    /* renamed from: u */
    private final C3655i f9727u = new C45754(this);
    /* renamed from: v */
    private final C3659m f9728v = new C45765(this);

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$a */
    public interface C1588a {
        /* renamed from: a */
        void mo1022a();
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$c */
    public interface C1589c {
        /* renamed from: a */
        void mo1018a(int i);
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$d */
    public interface C1590d {
        /* renamed from: a */
        void mo1019a(View view);

        /* renamed from: b */
        void mo1020b(View view);
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$e */
    public interface C1591e {
        /* renamed from: a */
        float mo1016a();

        /* renamed from: a */
        void mo1017a(float f);
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$b */
    private static class C3629b implements C1578e {
        /* renamed from: a */
        final WeakReference<C3630b> f9708a;

        private C3629b(C3630b c3630b) {
            this.f9708a = new WeakReference(c3630b);
        }

        /* renamed from: a */
        public void mo841a(boolean z) {
            C3630b c3630b = (C3630b) this.f9708a.get();
            if (c3630b != null) {
                c3630b.f9721o = z;
                c3630b.m11858k();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$1 */
    class C45721 extends C3669w {
        /* renamed from: a */
        final /* synthetic */ C3630b f12456a;

        C45721(C3630b c3630b) {
            this.f12456a = c3630b;
        }

        /* renamed from: a */
        public void m15775a(C3668v c3668v) {
            this.f12456a.f9718l.m11836a().mo1017a(this.f12456a.getVideoView().getVolume());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$2 */
    class C45732 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3630b f12457a;

        C45732(C3630b c3630b) {
            this.f12457a = c3630b;
        }

        /* renamed from: a */
        public void m15777a(C3648b c3648b) {
            this.f12457a.f9718l.m11838b().mo1018a(((Integer) this.f12457a.getTag(-1593835536)).intValue());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$3 */
    class C45743 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C3630b f12458a;

        C45743(C3630b c3630b) {
            this.f12458a = c3630b;
        }

        /* renamed from: a */
        public void m15779a(C3656j c3656j) {
            this.f12458a.f9718l.m11839c().mo1019a(this.f12458a);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$4 */
    class C45754 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C3630b f12459a;

        C45754(C3630b c3630b) {
            this.f12459a = c3630b;
        }

        /* renamed from: a */
        public void m15781a(C3654h c3654h) {
            this.f12459a.f9718l.m11839c().mo1020b(this.f12459a);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.component.a.a.b$5 */
    class C45765 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C3630b f12460a;

        C45765(C3630b c3630b) {
            this.f12460a = c3630b;
        }

        /* renamed from: a */
        public void m15783a(C3658l c3658l) {
            this.f12460a.f9722p = true;
            this.f12460a.m11858k();
        }
    }

    C3630b(C1597d c1597d, C1312d c1312d, boolean z, String str, C3621a c3621a) {
        super(c1597d, c1312d, z);
        this.f9718l = c3621a;
        this.f9715i = str;
        setGravity(17);
        setPadding(f9709c, 0, f9709c, f9709c);
        C1523w.m5342a((View) this, 0);
        setUpView(getContext());
        this.f9716j = new Paint();
        this.f9716j.setColor(-16777216);
        this.f9716j.setStyle(Style.FILL);
        this.f9716j.setAlpha(16);
        this.f9716j.setAntiAlias(true);
        if (VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* renamed from: a */
    private void m11854a(View view) {
        view.setLayoutParams(new LayoutParams(-1, -2));
        C1523w.m5341a(view);
    }

    /* renamed from: k */
    private void m11858k() {
        if (this.f9723q != null) {
            if ((m11865f() && this.f9722p) || (!m11865f() && this.f9721o)) {
                this.f9723q.mo1022a();
            }
        }
    }

    private void setUpView(Context context) {
        setUpImageView(context);
        setUpVideoView(context);
        setUpMediaContainer(context);
        this.f9714h.addView(this.f9712f);
        this.f9714h.addView(this.f9713g);
        mo2873a(context);
    }

    /* renamed from: a */
    protected abstract void mo2873a(Context context);

    /* renamed from: a */
    public void m11860a(String str, String str2) {
        getTitleDescContainer().m5586a(str, str2, true, false);
    }

    /* renamed from: a */
    public void m11861a(String str, String str2, Map<String, String> map) {
        getCtaButton().m5583a(str, str2, this.f9715i, map);
    }

    /* renamed from: a */
    public void m11862a(Map<String, String> map) {
        this.f9713g.m5522c();
        if (m11865f()) {
            this.f9713g.m5519a(getAdEventManager(), this.f9715i, map);
        }
    }

    /* renamed from: a */
    public boolean mo1023a() {
        return false;
    }

    /* renamed from: e */
    protected boolean mo1024e() {
        return false;
    }

    /* renamed from: f */
    public boolean m11865f() {
        return this.f9717k;
    }

    /* renamed from: g */
    public boolean m11866g() {
        return m11865f() && this.f9713g.m5521b();
    }

    protected final RelativeLayout getMediaContainer() {
        return this.f9714h;
    }

    protected final C1583e getVideoView() {
        return this.f9713g;
    }

    /* renamed from: h */
    public void m11867h() {
        if (m11865f()) {
            m11869j();
            this.f9713g.m5520a(C1624a.AUTO_STARTED);
        }
    }

    /* renamed from: i */
    public void m11868i() {
        if (m11865f()) {
            this.f9713g.m5517a();
        }
    }

    /* renamed from: j */
    public void m11869j() {
        float a = this.f9718l.m11836a().mo1016a();
        if (m11865f() && a != this.f9713g.getVolume()) {
            this.f9713g.setVolume(a);
        }
    }

    protected void onDraw(Canvas canvas) {
        this.f9719m.reset();
        this.f9720n.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        this.f9719m.addRoundRect(this.f9720n, (float) f9711e, (float) f9711e, Direction.CW);
        canvas.drawPath(this.f9719m, this.f9716j);
        this.f9720n.set((float) f9709c, 0.0f, (float) (getWidth() - f9709c), (float) (getHeight() - f9709c));
        this.f9719m.addRoundRect(this.f9720n, (float) f9710d, (float) f9710d, Direction.CW);
        canvas.clipPath(this.f9719m);
        super.onDraw(canvas);
    }

    public void setImageUrl(String str) {
        this.f9712f.setVisibility(0);
        this.f9713g.setVisibility(8);
        new C1577d(this.f9712f).m5504a().m5506a(new C3629b()).m5508a(str);
    }

    public void setIsVideo(boolean z) {
        this.f9717k = z;
    }

    public void setOnAssetsLoadedListener(C1588a c1588a) {
        this.f9723q = c1588a;
    }

    protected void setUpImageView(Context context) {
        this.f9712f = new C1676s(context);
        m11854a(this.f9712f);
    }

    protected void setUpMediaContainer(Context context) {
        this.f9714h = new RelativeLayout(context);
        m11854a(this.f9714h);
    }

    protected void setUpVideoView(Context context) {
        this.f9713g = new C1583e(context, getAdEventManager());
        m11854a(this.f9713g);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.f9713g.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.f9712f.setVisibility(8);
        this.f9713g.setVisibility(0);
        this.f9713g.setVideoURI(str);
        this.f9713g.m5518a(this.f9724r);
        this.f9713g.m5518a(this.f9725s);
        this.f9713g.m5518a(this.f9726t);
        this.f9713g.m5518a(this.f9727u);
        this.f9713g.m5518a(this.f9728v);
    }
}
