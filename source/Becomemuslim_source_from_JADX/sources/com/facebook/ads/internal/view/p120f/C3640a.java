package com.facebook.ads.internal.view.p120f;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.p095j.C1400d;
import com.facebook.ads.internal.p095j.C1401e;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.p120f.C3684c.C1628a;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3662p;
import com.facebook.ads.internal.view.p120f.p122b.C3664r;
import com.facebook.ads.internal.view.p120f.p122b.C3665s;
import com.facebook.ads.internal.view.p120f.p122b.C3666t;
import com.facebook.ads.internal.view.p120f.p122b.C3668v;
import com.facebook.ads.internal.view.p120f.p122b.C3670x;
import com.facebook.ads.internal.view.p120f.p122b.C3671y;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p124d.C1657c;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;
import com.facebook.ads.internal.view.p120f.p124d.C1659e;
import com.facebook.ads.internal.view.p120f.p124d.C3685b;
import com.facebook.ads.internal.view.p120f.p124d.C4618a;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.view.f.a */
public class C3640a extends RelativeLayout implements C1628a, C1659e {
    /* renamed from: b */
    private static final C3658l f9748b = new C3658l();
    /* renamed from: c */
    private static final C3650d f9749c = new C3650d();
    /* renamed from: d */
    private static final C3664r f9750d = new C3664r();
    /* renamed from: e */
    private static final C3654h f9751e = new C3654h();
    /* renamed from: f */
    private static final C3665s f9752f = new C3665s();
    /* renamed from: g */
    private static final C3656j f9753g = new C3656j();
    /* renamed from: h */
    private static final C3668v f9754h = new C3668v();
    /* renamed from: i */
    private static final C3671y f9755i = new C3671y();
    /* renamed from: j */
    private static final C3670x f9756j = new C3670x();
    /* renamed from: a */
    protected final C1657c f9757a;
    /* renamed from: k */
    private C1660d f9758k;
    /* renamed from: l */
    private final List<C1625b> f9759l = new ArrayList();
    /* renamed from: m */
    private final Handler f9760m = new Handler();
    /* renamed from: n */
    private final Handler f9761n = new Handler();
    /* renamed from: o */
    private final C1401e<C1402f, C1400d> f9762o = new C1401e();
    /* renamed from: p */
    private boolean f9763p;
    /* renamed from: q */
    private boolean f9764q;
    /* renamed from: r */
    private boolean f9765r = false;
    /* renamed from: s */
    private int f9766s = HttpStatus.HTTP_OK;
    /* renamed from: t */
    private final OnTouchListener f9767t = new C16224(this);

    /* renamed from: com.facebook.ads.internal.view.f.a$1 */
    class C16191 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3640a f4863a;

        C16191(C3640a c3640a) {
            this.f4863a = c3640a;
        }

        public void run() {
            if (!this.f4863a.f9763p) {
                this.f4863a.f9762o.m4803a(new C3660n(this.f4863a.getCurrentPositionInMillis()));
                this.f4863a.f9760m.postDelayed(this, (long) this.f4863a.f9766s);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.a$4 */
    class C16224 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C3640a f4871a;

        C16224(C3640a c3640a) {
            this.f4871a = c3640a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f4871a.f9762o.m4803a(new C3666t(view, motionEvent));
            return false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.a$5 */
    class C16235 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3640a f4872a;

        C16235(C3640a c3640a) {
            this.f4872a = c3640a;
        }

        public void run() {
            this.f4872a.getEventBus().m4803a(C3640a.f9750d);
        }
    }

    public C3640a(Context context) {
        super(context);
        this.f9757a = C1405a.m4819a(context) ? new C4618a(context) : new C3685b(context);
        mo2891a();
    }

    public C3640a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9757a = C1405a.m4819a(context) ? new C4618a(context, attributeSet) : new C3685b(context, attributeSet);
        mo2891a();
    }

    public C3640a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9757a = C1405a.m4819a(context) ? new C4618a(context, attributeSet, i) : new C3685b(context, attributeSet, i);
        mo2891a();
    }

    @TargetApi(21)
    public C3640a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f9757a = C1405a.m4819a(context) ? new C4618a(context, attributeSet, i, i2) : new C3685b(context, attributeSet, i, i2);
        mo2891a();
    }

    /* renamed from: a */
    private void mo2891a() {
        if (mo1033g() && (this.f9757a instanceof C4618a)) {
            ((C4618a) this.f9757a).setTestMode(AdInternalSettings.isTestMode(getContext()));
        }
        this.f9757a.setRequestedVolume(1.0f);
        this.f9757a.setVideoStateChangeListener(this);
        this.f9758k = new C1660d(getContext(), this.f9757a);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.f9758k, layoutParams);
        setOnTouchListener(this.f9767t);
    }

    /* renamed from: a */
    private void m11897a(C3639c c3639c) {
        if (c3639c.getParent() != null) {
            return;
        }
        if (c3639c instanceof C4597g) {
            this.f9758k.m5634a(c3639c);
        } else {
            addView(c3639c);
        }
    }

    /* renamed from: b */
    private void mo2892b() {
        this.f9760m.postDelayed(new C16191(this), (long) this.f9766s);
    }

    /* renamed from: b */
    private void m11902b(C3639c c3639c) {
        if (c3639c instanceof C4597g) {
            this.f9758k.m5635b(c3639c);
        } else {
            C1523w.m5346b(c3639c);
        }
    }

    /* renamed from: a */
    public void m11912a(int i) {
        this.f9760m.removeCallbacksAndMessages(null);
        this.f9757a.mo1039a(i);
    }

    /* renamed from: a */
    public void mo1031a(final int i, final int i2) {
        this.f9761n.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C3640a f4870c;

            public void run() {
                this.f4870c.f9762o.m4803a(new C3662p(i, i2));
            }
        });
        mo2892b();
    }

    /* renamed from: a */
    public void m11914a(C1624a c1624a) {
        if (this.f9763p && this.f9757a.getState() == C1658d.PLAYBACK_COMPLETED) {
            this.f9763p = false;
        }
        this.f9757a.mo1040a(c1624a);
    }

    /* renamed from: a */
    public void m11915a(C1625b c1625b) {
        this.f9759l.add(c1625b);
    }

    /* renamed from: a */
    public void mo1032a(final C1658d c1658d) {
        final int currentPositionInMillis = getCurrentPositionInMillis();
        final int duration = getDuration();
        this.f9761n.post(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C3640a f4867d;

            public void run() {
                C1401e b;
                C1400d n;
                if (c1658d == C1658d.PREPARED) {
                    b = this.f4867d.f9762o;
                    n = C3640a.f9748b;
                } else if (c1658d == C1658d.ERROR) {
                    this.f4867d.f9763p = true;
                    b = this.f4867d.f9762o;
                    n = C3640a.f9749c;
                } else if (c1658d == C1658d.PLAYBACK_COMPLETED) {
                    this.f4867d.f9763p = true;
                    this.f4867d.f9760m.removeCallbacksAndMessages(null);
                    b = this.f4867d.f9762o;
                    n = new C3648b(currentPositionInMillis, duration);
                } else if (c1658d == C1658d.STARTED) {
                    this.f4867d.f9762o.m4803a(C3640a.f9753g);
                    this.f4867d.f9760m.removeCallbacksAndMessages(null);
                    this.f4867d.mo2892b();
                    return;
                } else {
                    if (c1658d == C1658d.PAUSED) {
                        b = this.f4867d.f9762o;
                        n = C3640a.f9751e;
                    } else if (c1658d == C1658d.IDLE) {
                        b = this.f4867d.f9762o;
                        n = C3640a.f9752f;
                    } else {
                        return;
                    }
                    b.m4803a(n);
                    this.f4867d.f9760m.removeCallbacksAndMessages(null);
                    return;
                }
                b.m4803a(n);
            }
        });
    }

    /* renamed from: a */
    public void m11917a(boolean z) {
        if (!m11927l()) {
            this.f9757a.mo1041a(z);
            this.f9765r = z;
        }
    }

    /* renamed from: c */
    public void m11918c() {
        for (C1625b c1625b : this.f9759l) {
            if (c1625b instanceof C3639c) {
                m11897a((C3639c) c1625b);
            }
            c1625b.mo1029a(this);
        }
    }

    /* renamed from: d */
    public void m11919d() {
        for (C1625b c1625b : this.f9759l) {
            if (c1625b instanceof C3639c) {
                m11902b((C3639c) c1625b);
            }
            c1625b.mo1030b(this);
        }
    }

    /* renamed from: e */
    public void m11920e() {
        this.f9761n.post(new C16235(this));
        this.f9757a.mo1042b();
    }

    /* renamed from: f */
    public void m11921f() {
        this.f9757a.mo1043c();
    }

    /* renamed from: g */
    public boolean mo1033g() {
        return C1405a.m4819a(getContext());
    }

    public int getCurrentPositionInMillis() {
        return this.f9757a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f9757a.getDuration();
    }

    public C1401e<C1402f, C1400d> getEventBus() {
        return this.f9762o;
    }

    public long getInitialBufferTime() {
        return this.f9757a.getInitialBufferTime();
    }

    public C1658d getState() {
        return this.f9757a.getState();
    }

    protected Handler getStateHandler() {
        return this.f9761n;
    }

    public TextureView getTextureView() {
        return (TextureView) this.f9757a;
    }

    public int getVideoHeight() {
        return this.f9757a.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.f9766s;
    }

    public C1624a getVideoStartReason() {
        return this.f9757a.getStartReason();
    }

    public View getVideoView() {
        return this.f9758k;
    }

    public int getVideoWidth() {
        return this.f9757a.getVideoWidth();
    }

    public float getVolume() {
        return this.f9757a.getVolume();
    }

    /* renamed from: h */
    public boolean mo1038h() {
        return this.f9764q;
    }

    /* renamed from: i */
    public boolean m11924i() {
        return getState() == C1658d.STARTED;
    }

    /* renamed from: j */
    public boolean m11925j() {
        return this.f9757a.mo1044d();
    }

    /* renamed from: k */
    public void m11926k() {
        this.f9757a.setVideoStateChangeListener(null);
        this.f9757a.mo1045e();
    }

    /* renamed from: l */
    public boolean m11927l() {
        return getState() == C1658d.PAUSED;
    }

    /* renamed from: m */
    public boolean m11928m() {
        return m11927l() && this.f9765r;
    }

    protected void onAttachedToWindow() {
        this.f9762o.m4803a(f9756j);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        this.f9762o.m4803a(f9755i);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        if (this.f9757a != null) {
            this.f9757a.setControlsAnchorView(view);
        }
    }

    public void setIsFullScreen(boolean z) {
        this.f9764q = z;
        this.f9757a.setFullScreen(z);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.f9757a.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i) {
        this.f9766s = i;
    }

    public void setVideoURI(Uri uri) {
        if (uri == null) {
            m11919d();
        } else {
            m11918c();
            this.f9757a.setup(uri);
        }
        this.f9763p = false;
    }

    public void setVideoURI(String str) {
        setVideoURI(str != null ? Uri.parse(str) : null);
    }

    public void setVolume(float f) {
        this.f9757a.setRequestedVolume(f);
        getEventBus().m4803a(f9754h);
    }
}
