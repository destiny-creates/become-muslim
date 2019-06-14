package com.facebook.ads.internal.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.p020a.C0264a;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1319i;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p107b.C1527b;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.ads.internal.p105q.p108c.C1539g;
import com.facebook.ads.internal.view.component.CircularProgressView;
import com.facebook.ads.internal.view.p114c.C1586c;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3661o;

/* renamed from: com.facebook.ads.internal.view.f */
public class C3686f extends LinearLayout implements C1625b {
    /* renamed from: c */
    private static final float f9872c = Resources.getSystem().getDisplayMetrics().density;
    /* renamed from: d */
    private static final int f9873d = ((int) (f9872c * 40.0f));
    /* renamed from: e */
    private static final int f9874e = ((int) (f9872c * 44.0f));
    /* renamed from: f */
    private static final int f9875f = ((int) (f9872c * 10.0f));
    /* renamed from: g */
    private static final int f9876g = ((int) (f9872c * 16.0f));
    /* renamed from: h */
    private static final int f9877h = (f9876g - f9875f);
    /* renamed from: i */
    private static final int f9878i = ((f9876g * 2) - f9875f);
    /* renamed from: a */
    private final C3661o f9879a = new C45801(this);
    /* renamed from: b */
    private final C3649c f9880b = new C45812(this);
    /* renamed from: j */
    private final ImageView f9881j;
    /* renamed from: k */
    private final FrameLayout f9882k;
    /* renamed from: l */
    private final ImageView f9883l;
    /* renamed from: m */
    private final CircularProgressView f9884m;
    /* renamed from: n */
    private final C1586c f9885n;
    /* renamed from: o */
    private final PopupMenu f9886o;
    /* renamed from: p */
    private C1618a f9887p;
    /* renamed from: q */
    private C3640a f9888q;
    /* renamed from: r */
    private int f9889r = 0;
    /* renamed from: s */
    private boolean f9890s = false;
    /* renamed from: t */
    private boolean f9891t = false;
    /* renamed from: u */
    private OnDismissListener f9892u;

    /* renamed from: com.facebook.ads.internal.view.f$3 */
    class C16143 implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ C3686f f4857a;

        C16143(C3686f c3686f) {
            this.f4857a = c3686f;
        }

        public void onDismiss(PopupMenu popupMenu) {
            this.f4857a.f9890s = false;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f$4 */
    class C16154 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3686f f4858a;

        C16154(C3686f c3686f) {
            this.f4858a = c3686f;
        }

        public void onClick(View view) {
            if (this.f4858a.f9887p != null && this.f4858a.f9891t) {
                this.f4858a.f9887p.mo1062a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f$5 */
    class C16165 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3686f f4859a;

        C16165(C3686f c3686f) {
            this.f4859a = c3686f;
        }

        public void onClick(View view) {
            this.f4859a.f9886o.show();
            this.f4859a.f9890s = true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f$a */
    public interface C1618a {
        /* renamed from: a */
        void mo1062a();
    }

    /* renamed from: com.facebook.ads.internal.view.f$1 */
    class C45801 extends C3661o {
        /* renamed from: a */
        final /* synthetic */ C3686f f12468a;

        C45801(C3686f c3686f) {
            this.f12468a = c3686f;
        }

        /* renamed from: a */
        public void m15792a(C3660n c3660n) {
            if (this.f12468a.f9888q != null && this.f12468a.f9889r != 0) {
                if (this.f12468a.f9884m.isShown()) {
                    float currentPositionInMillis = ((float) this.f12468a.f9888q.getCurrentPositionInMillis()) / Math.min(((float) this.f12468a.f9889r) * 1000.0f, (float) this.f12468a.f9888q.getDuration());
                    this.f12468a.setProgress(100.0f * currentPositionInMillis);
                    if (currentPositionInMillis >= 1.0f) {
                        this.f12468a.m12091a(true);
                        this.f12468a.f9888q.getEventBus().m4806b(this.f12468a.f9879a, this.f12468a.f9880b);
                    }
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f$2 */
    class C45812 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C3686f f12469a;

        C45812(C3686f c3686f) {
            this.f12469a = c3686f;
        }

        /* renamed from: a */
        public void m15794a(C3648b c3648b) {
            if (this.f12469a.f9888q != null && this.f12469a.f9889r != 0) {
                if (!this.f12469a.f9884m.isShown()) {
                    return;
                }
                if (!this.f12469a.f9891t) {
                    this.f12469a.m12091a(true);
                    this.f12469a.f9888q.getEventBus().m4806b(this.f12469a.f9879a, this.f12469a.f9880b);
                }
            }
        }
    }

    public C3686f(Context context) {
        super(context);
        setGravity(16);
        if (VERSION.SDK_INT >= 14) {
            this.f9892u = new C16143(this);
        }
        this.f9883l = new ImageView(context);
        this.f9883l.setPadding(f9875f, f9875f, f9875f, f9875f);
        this.f9883l.setScaleType(ScaleType.FIT_CENTER);
        this.f9883l.setImageBitmap(C1528c.m5354a(C1527b.INTERSTITIAL_CLOSE));
        this.f9883l.setOnClickListener(new C16154(this));
        this.f9884m = new CircularProgressView(context);
        this.f9884m.setPadding(f9875f, f9875f, f9875f, f9875f);
        this.f9884m.setProgress(0.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(f9877h, f9877h, f9878i, f9877h);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f9874e, f9874e);
        this.f9882k = new FrameLayout(context);
        this.f9882k.setLayoutTransition(new LayoutTransition());
        this.f9882k.addView(this.f9883l, layoutParams2);
        this.f9882k.addView(this.f9884m, layoutParams2);
        addView(this.f9882k, layoutParams);
        this.f9885n = new C1586c(context);
        layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        addView(this.f9885n, layoutParams);
        this.f9881j = new ImageView(context);
        this.f9881j.setPadding(f9875f, f9875f, f9875f, f9875f);
        this.f9881j.setScaleType(ScaleType.FIT_CENTER);
        this.f9881j.setImageBitmap(C1528c.m5354a(C1527b.INTERSTITIAL_AD_CHOICES));
        this.f9881j.setOnClickListener(new C16165(this));
        this.f9886o = new PopupMenu(context, this.f9881j);
        this.f9886o.getMenu().add("Ad Choices");
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f9873d, f9873d);
        layoutParams3.setMargins(0, f9876g / 2, f9876g / 2, f9876g / 2);
        addView(this.f9881j, layoutParams3);
    }

    /* renamed from: a */
    public void m12088a(C1312d c1312d, boolean z) {
        int a = c1312d.m4506a(z);
        this.f9885n.m5525a(c1312d.m4512g(z), a);
        this.f9881j.setColorFilter(a);
        this.f9883l.setColorFilter(a);
        this.f9884m.m5527a(C0264a.m717b(a, 77), a);
        if (z) {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            C1523w.m5343a((View) this, gradientDrawable);
            return;
        }
        C1523w.m5342a((View) this, 0);
    }

    /* renamed from: a */
    public void m12089a(final C1319i c1319i, final String str, int i) {
        this.f9889r = i;
        this.f9885n.setPageDetails(c1319i);
        this.f9886o.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            /* renamed from: c */
            final /* synthetic */ C3686f f4862c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f4862c.f9890s = false;
                if (!TextUtils.isEmpty(c1319i.m4547c())) {
                    C1539g.m5388a(new C1539g(), this.f4862c.getContext(), Uri.parse(c1319i.m4547c()), str);
                }
                return true;
            }
        });
        if (VERSION.SDK_INT >= 14) {
            this.f9886o.setOnDismissListener(this.f9892u);
        }
        m12091a(i <= 0);
    }

    /* renamed from: a */
    public void mo1029a(C3640a c3640a) {
        this.f9888q = c3640a;
        this.f9888q.getEventBus().m4804a(this.f9879a, this.f9880b);
    }

    /* renamed from: a */
    public void m12091a(boolean z) {
        this.f9891t = z;
        int i = 0;
        this.f9882k.setVisibility(0);
        this.f9884m.setVisibility(z ? 4 : 0);
        ImageView imageView = this.f9883l;
        if (!z) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    /* renamed from: a */
    public boolean m12092a() {
        return this.f9891t;
    }

    /* renamed from: b */
    public void m12093b() {
        this.f9891t = false;
        this.f9882k.setVisibility(4);
        this.f9884m.setVisibility(4);
        this.f9883l.setVisibility(4);
    }

    /* renamed from: b */
    public void mo1030b(C3640a c3640a) {
        if (this.f9888q != null) {
            this.f9888q.getEventBus().m4806b(this.f9879a, this.f9880b);
            this.f9888q = null;
        }
    }

    /* renamed from: c */
    public void m12095c() {
        this.f9885n.setVisibility(4);
    }

    /* renamed from: d */
    public void m12096d() {
        if (VERSION.SDK_INT >= 14) {
            this.f9886o.setOnDismissListener(null);
        }
        this.f9886o.dismiss();
        if (VERSION.SDK_INT >= 14) {
            this.f9886o.setOnDismissListener(this.f9892u);
        }
    }

    /* renamed from: e */
    public void m12097e() {
        if (this.f9890s && VERSION.SDK_INT >= 14) {
            this.f9886o.show();
        }
    }

    public void setProgress(float f) {
        this.f9884m.setProgressWithAnimation(f);
    }

    public void setShowPageDetails(boolean z) {
        this.f9885n.setVisibility(z ? 0 : 4);
    }

    public void setToolbarListener(C1618a c1618a) {
        this.f9887p = c1618a;
    }
}
