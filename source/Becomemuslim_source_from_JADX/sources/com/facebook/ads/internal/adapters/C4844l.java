package com.facebook.ads.internal.adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkActivity.BackButtonInterceptor;
import com.facebook.ads.internal.adapters.C4562k.C1331a;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1566a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p114c.C1584a;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3666t;
import com.facebook.ads.internal.view.p120f.p123c.C3675d;
import com.facebook.ads.internal.view.p120f.p123c.C3675d.C1640a;
import com.facebook.ads.internal.view.p120f.p123c.C3680j;
import com.facebook.ads.internal.view.p120f.p123c.C3682n;
import com.facebook.ads.internal.view.p120f.p123c.C4585a.C1635a;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p123c.C4607k;
import com.facebook.ads.internal.view.p120f.p123c.C4611l;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.l */
public class C4844l extends C4561j implements OnTouchListener, C1566a {
    /* renamed from: i */
    static final /* synthetic */ boolean f13746i = (C4844l.class.desiredAssertionStatus() ^ 1);
    /* renamed from: j */
    private static final String f13747j = C4844l.class.getSimpleName();
    /* renamed from: A */
    private int f13748A = -12286980;
    /* renamed from: B */
    private boolean f13749B = false;
    /* renamed from: C */
    private C1624a f13750C;
    /* renamed from: f */
    final int f13751f = 64;
    /* renamed from: g */
    final int f13752g = 64;
    /* renamed from: h */
    final int f13753h = 16;
    /* renamed from: k */
    private C1551a f13754k;
    /* renamed from: l */
    private Activity f13755l;
    /* renamed from: m */
    private BackButtonInterceptor f13756m = new C35661(this);
    /* renamed from: n */
    private final OnTouchListener f13757n = new C13322(this);
    /* renamed from: o */
    private C1331a f13758o = C1331a.UNSPECIFIED;
    /* renamed from: p */
    private C1584a f13759p;
    /* renamed from: q */
    private TextView f13760q;
    /* renamed from: r */
    private TextView f13761r;
    /* renamed from: s */
    private ImageView f13762s;
    /* renamed from: t */
    private C1635a f13763t;
    /* renamed from: u */
    private C3682n f13764u;
    /* renamed from: v */
    private ViewGroup f13765v;
    /* renamed from: w */
    private C3675d f13766w;
    /* renamed from: x */
    private C3680j f13767x;
    /* renamed from: y */
    private int f13768y = -1;
    /* renamed from: z */
    private int f13769z = -10525069;

    /* renamed from: com.facebook.ads.internal.adapters.l$2 */
    class C13322 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C4844l f3881a;

        C13322(C4844l c4844l) {
            this.f3881a = c4844l;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return true;
            }
            if (this.f3881a.f13767x != null) {
                if (!this.f3881a.f13767x.m12018a()) {
                    return true;
                }
                if (!(this.f3881a.f13767x.getSkipSeconds() == 0 || this.f3881a.b == null)) {
                    this.f3881a.b.m11920e();
                }
                if (this.f3881a.b != null) {
                    this.f3881a.b.m11921f();
                }
            }
            this.f3881a.f13755l.finish();
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.l$1 */
    class C35661 implements BackButtonInterceptor {
        /* renamed from: a */
        final /* synthetic */ C4844l f9517a;

        C35661(C4844l c4844l) {
            this.f9517a = c4844l;
        }

        public boolean interceptBackButton() {
            if (this.f9517a.f13767x == null) {
                return false;
            }
            if (!this.f9517a.f13767x.m12018a()) {
                return true;
            }
            if (!(this.f9517a.f13767x.getSkipSeconds() == 0 || this.f9517a.b == null)) {
                this.f9517a.b.m11920e();
            }
            if (this.f9517a.b != null) {
                this.f9517a.b.m11921f();
            }
            return false;
        }
    }

    /* renamed from: a */
    private void m17214a(int i) {
        View view;
        int i2;
        int i3 = i;
        float f = C1523w.f4503b;
        int i4 = (int) (56.0f * f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i5 = (int) (16.0f * f);
        this.f13767x.setPadding(i5, i5, i5, i5);
        this.f13767x.setLayoutParams(layoutParams);
        C1640a c1640a = mo3349h() ? C1640a.FADE_OUT_ON_PLAY : C1640a.VISIBLE;
        int id = r0.b.getId();
        Drawable gradientDrawable;
        LayoutParams layoutParams2;
        int i6;
        if (i3 == 1 && (m17219m() || m17220n())) {
            gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
            gradientDrawable.setCornerRadius(0.0f);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(10);
            r0.b.setLayoutParams(layoutParams3);
            m17215a(r0.b);
            m17215a(r0.f13767x);
            if (r0.f13763t != null) {
                m17215a(r0.f13763t);
            }
            layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (((float) (((((r0.f13759p != null ? 64 : 0) + 60) + 16) + 16) + 16)) * f));
            layoutParams3.addRule(12);
            View relativeLayout = new RelativeLayout(r0.d);
            C1523w.m5343a(relativeLayout, gradientDrawable);
            relativeLayout.setLayoutParams(layoutParams3);
            relativeLayout.setPadding(i5, 0, i5, (int) (((float) (((r0.f13759p != null ? 64 : 0) + 16) + 16)) * f));
            r0.f13765v = relativeLayout;
            if (!r0.f13749B) {
                r0.f13766w.m11990a(relativeLayout, c1640a);
            }
            m17215a(relativeLayout);
            if (r0.f13764u != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (6.0f * f));
                layoutParams2.addRule(12);
                layoutParams2.topMargin = (int) (-6.0f * f);
                r0.f13764u.setLayoutParams(layoutParams2);
                m17215a(r0.f13764u);
            }
            if (r0.f13759p != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (64.0f * f));
                layoutParams2.bottomMargin = i5;
                layoutParams2.leftMargin = i5;
                layoutParams2.rightMargin = i5;
                layoutParams2.addRule(1);
                layoutParams2.addRule(12);
                r0.f13759p.setLayoutParams(layoutParams2);
                m17215a(r0.f13759p);
            }
            if (r0.f13762s != null) {
                i6 = (int) (60.0f * f);
                layoutParams2 = new RelativeLayout.LayoutParams(i6, i6);
                layoutParams2.addRule(12);
                layoutParams2.addRule(9);
                r0.f13762s.setLayoutParams(layoutParams2);
                m17216a(relativeLayout, r0.f13762s);
            }
            if (r0.f13760q != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.bottomMargin = (int) (36.0f * f);
                layoutParams2.addRule(12);
                layoutParams2.addRule(9);
                r0.f13760q.setEllipsize(TruncateAt.END);
                r0.f13760q.setGravity(8388611);
                r0.f13760q.setLayoutParams(layoutParams2);
                r0.f13760q.setMaxLines(1);
                r0.f13760q.setPadding((int) (72.0f * f), 0, 0, 0);
                r0.f13760q.setTextColor(-1);
                r0.f13760q.setTextSize(18.0f);
                m17216a(relativeLayout, r0.f13760q);
            }
            if (r0.f13761r != null) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(12);
                layoutParams2.addRule(9);
                layoutParams2.bottomMargin = (int) (4.0f * f);
                r0.f13761r.setEllipsize(TruncateAt.END);
                r0.f13761r.setGravity(8388611);
                r0.f13761r.setLayoutParams(layoutParams2);
                r0.f13761r.setMaxLines(1);
                r0.f13761r.setPadding((int) (f * 72.0f), 0, 0, 0);
                r0.f13761r.setTextColor(-1);
                m17216a(relativeLayout, r0.f13761r);
            }
            view = (View) r0.b.getParent();
            i2 = -16777216;
        } else {
            if (i3 == 1) {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(10);
                r0.b.setLayoutParams(layoutParams2);
                m17215a(r0.b);
                m17215a(r0.f13767x);
                if (r0.f13763t != null) {
                    m17215a(r0.f13763t);
                }
                view = new LinearLayout(r0.d);
                r0.f13765v = view;
                view.setGravity(112);
                view.setOrientation(1);
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                i4 = (int) (33.0f * f);
                layoutParams.leftMargin = i4;
                layoutParams.rightMargin = i4;
                layoutParams.topMargin = (int) (8.0f * f);
                if (r0.f13759p == null) {
                    layoutParams.bottomMargin = i5;
                } else {
                    layoutParams.bottomMargin = (int) (f * 80.0f);
                }
                layoutParams.addRule(3, id);
                view.setLayoutParams(layoutParams);
                m17215a(view);
                if (r0.f13759p != null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, (int) (f * 64.0f));
                    layoutParams.bottomMargin = i5;
                    layoutParams.leftMargin = i4;
                    layoutParams.rightMargin = i4;
                    layoutParams.addRule(1);
                    layoutParams.addRule(12);
                    r0.f13759p.setLayoutParams(layoutParams);
                    m17215a(r0.f13759p);
                }
                if (r0.f13760q != null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.weight = 2.0f;
                    layoutParams.gravity = 17;
                    r0.f13760q.setEllipsize(TruncateAt.END);
                    r0.f13760q.setGravity(17);
                    r0.f13760q.setLayoutParams(layoutParams);
                    r0.f13760q.setMaxLines(2);
                    r0.f13760q.setPadding(0, 0, 0, 0);
                    r0.f13760q.setTextColor(r0.f13769z);
                    r0.f13760q.setTextSize(24.0f);
                    m17216a(view, r0.f13760q);
                }
                if (r0.f13762s != null) {
                    i4 = (int) (64.0f * f);
                    layoutParams = new LinearLayout.LayoutParams(i4, i4);
                    layoutParams.weight = 0.0f;
                    layoutParams.gravity = 17;
                    r0.f13762s.setLayoutParams(layoutParams);
                    m17216a(view, r0.f13762s);
                }
                if (r0.f13761r != null) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 2.0f;
                    layoutParams.gravity = 16;
                    r0.f13761r.setEllipsize(TruncateAt.END);
                    r0.f13761r.setGravity(16);
                    r0.f13761r.setLayoutParams(layoutParams);
                    r0.f13761r.setMaxLines(2);
                    r0.f13761r.setPadding(0, 0, 0, 0);
                    r0.f13761r.setTextColor(r0.f13769z);
                    m17216a(view, r0.f13761r);
                }
                if (r0.f13764u != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (f * 6.0f));
                    layoutParams2.addRule(3, id);
                    r0.f13764u.setLayoutParams(layoutParams2);
                    view = r0.f13764u;
                }
                view = (View) r0.b.getParent();
                i2 = r0.f13768y;
            } else if (!m17221o() || m17220n()) {
                TextView textView;
                int i7;
                gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
                gradientDrawable.setCornerRadius(0.0f);
                r0.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                m17215a(r0.b);
                m17215a(r0.f13767x);
                if (r0.f13763t != null) {
                    m17215a(r0.f13763t);
                }
                LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (124.0f * f));
                layoutParams4.addRule(12);
                View relativeLayout2 = new RelativeLayout(r0.d);
                C1523w.m5343a(relativeLayout2, gradientDrawable);
                relativeLayout2.setLayoutParams(layoutParams4);
                relativeLayout2.setPadding(i5, 0, i5, i5);
                r0.f13765v = relativeLayout2;
                if (!r0.f13749B) {
                    r0.f13766w.m11990a(relativeLayout2, c1640a);
                }
                m17215a(relativeLayout2);
                if (r0.f13759p != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams((int) (110.0f * f), i4);
                    layoutParams2.rightMargin = i5;
                    layoutParams2.bottomMargin = i5;
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(11);
                    r0.f13759p.setLayoutParams(layoutParams2);
                    m17215a(r0.f13759p);
                }
                if (r0.f13762s != null) {
                    i6 = (int) (64.0f * f);
                    layoutParams2 = new RelativeLayout.LayoutParams(i6, i6);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(9);
                    layoutParams2.bottomMargin = (int) (8.0f * f);
                    r0.f13762s.setLayoutParams(layoutParams2);
                    m17216a(relativeLayout2, r0.f13762s);
                }
                if (r0.f13760q != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.bottomMargin = (int) (48.0f * f);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(9);
                    r0.f13760q.setEllipsize(TruncateAt.END);
                    r0.f13760q.setGravity(8388611);
                    r0.f13760q.setLayoutParams(layoutParams2);
                    r0.f13760q.setMaxLines(1);
                    textView = r0.f13760q;
                    i6 = (int) (f * 80.0f);
                    if (r0.f13759p != null) {
                        i7 = (int) (126.0f * f);
                        i4 = 0;
                    } else {
                        i4 = 0;
                        i7 = 0;
                    }
                    textView.setPadding(i6, i4, i7, i4);
                    r0.f13760q.setTextColor(-1);
                    r0.f13760q.setTextSize(24.0f);
                    m17216a(relativeLayout2, r0.f13760q);
                }
                if (r0.f13761r != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(9);
                    r0.f13761r.setEllipsize(TruncateAt.END);
                    r0.f13761r.setGravity(8388611);
                    r0.f13761r.setLayoutParams(layoutParams2);
                    r0.f13761r.setMaxLines(2);
                    r0.f13761r.setTextColor(-1);
                    textView = r0.f13761r;
                    i6 = (int) (f * 80.0f);
                    if (r0.f13759p != null) {
                        i7 = (int) (126.0f * f);
                        i4 = 0;
                    } else {
                        i4 = 0;
                        i7 = 0;
                    }
                    textView.setPadding(i6, i4, i7, i4);
                    m17216a(relativeLayout2, r0.f13761r);
                }
                if (r0.f13764u != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (f * 6.0f));
                    layoutParams2.addRule(12);
                    r0.f13764u.setLayoutParams(layoutParams2);
                    m17215a(r0.f13764u);
                }
                view = (View) r0.b.getParent();
                i2 = -16777216;
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams2.addRule(9);
                r0.b.setLayoutParams(layoutParams2);
                m17215a(r0.b);
                m17215a(r0.f13767x);
                if (r0.f13763t != null) {
                    m17215a(r0.f13763t);
                }
                view = new LinearLayout(r0.d);
                r0.f13765v = view;
                view.setGravity(112);
                view.setOrientation(1);
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.leftMargin = i5;
                layoutParams.rightMargin = i5;
                layoutParams.topMargin = (int) (8.0f * f);
                layoutParams.bottomMargin = (int) (f * 80.0f);
                layoutParams.addRule(1, id);
                view.setLayoutParams(layoutParams);
                m17215a(view);
                if (r0.f13764u != null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, (int) (f * 6.0f));
                    layoutParams.addRule(5, id);
                    layoutParams.addRule(7, id);
                    layoutParams.addRule(3, id);
                    layoutParams.topMargin = (int) (-6.0f * f);
                    r0.f13764u.setLayoutParams(layoutParams);
                    m17215a(r0.f13764u);
                }
                if (r0.f13760q != null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.weight = 2.0f;
                    layoutParams.gravity = 17;
                    r0.f13760q.setEllipsize(TruncateAt.END);
                    r0.f13760q.setGravity(17);
                    r0.f13760q.setLayoutParams(layoutParams);
                    r0.f13760q.setMaxLines(10);
                    r0.f13760q.setPadding(0, 0, 0, 0);
                    r0.f13760q.setTextColor(r0.f13769z);
                    r0.f13760q.setTextSize(24.0f);
                    m17216a(view, r0.f13760q);
                }
                if (r0.f13762s != null) {
                    i4 = (int) (f * 64.0f);
                    layoutParams = new LinearLayout.LayoutParams(i4, i4);
                    layoutParams.weight = 0.0f;
                    layoutParams.gravity = 17;
                    r0.f13762s.setLayoutParams(layoutParams);
                    m17216a(view, r0.f13762s);
                }
                if (r0.f13761r != null) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 2.0f;
                    layoutParams.gravity = 16;
                    r0.f13761r.setEllipsize(TruncateAt.END);
                    r0.f13761r.setGravity(17);
                    r0.f13761r.setLayoutParams(layoutParams);
                    r0.f13761r.setMaxLines(10);
                    r0.f13761r.setPadding(0, 0, 0, 0);
                    r0.f13761r.setTextColor(r0.f13769z);
                    m17216a(view, r0.f13761r);
                }
                if (r0.f13759p != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (f * 64.0f));
                    layoutParams2.bottomMargin = i5;
                    layoutParams2.leftMargin = i5;
                    layoutParams2.rightMargin = i5;
                    layoutParams2.addRule(1);
                    layoutParams2.addRule(12);
                    layoutParams2.addRule(1, id);
                    r0.f13759p.setLayoutParams(layoutParams2);
                    view = r0.f13759p;
                }
                view = (View) r0.b.getParent();
                i2 = r0.f13768y;
            }
            m17215a(view);
            view = (View) r0.b.getParent();
            i2 = r0.f13768y;
        }
        C1523w.m5342a(view, i2);
        view = r0.b.getRootView();
        if (view != null) {
            view.setOnTouchListener(r0);
        }
    }

    /* renamed from: a */
    private void m17215a(View view) {
        if (this.f13754k != null) {
            this.f13754k.mo853a(view);
        }
    }

    /* renamed from: a */
    private void m17216a(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    /* renamed from: b */
    private void m17218b(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    /* renamed from: m */
    private boolean m17219m() {
        return ((double) (this.b.getVideoHeight() > 0 ? ((float) this.b.getVideoWidth()) / ((float) this.b.getVideoHeight()) : -1.0f)) <= 0.9d;
    }

    /* renamed from: n */
    private boolean m17220n() {
        boolean z = false;
        if (this.b.getVideoHeight() <= 0) {
            return false;
        }
        Rect rect = new Rect();
        this.f13755l.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.width() > rect.height()) {
            if (((float) (rect.width() - ((rect.height() * this.b.getVideoWidth()) / this.b.getVideoHeight()))) - (C1523w.f4503b * 192.0f) < 0.0f) {
                z = true;
            }
            return z;
        }
        if (((((float) (rect.height() - ((rect.width() * this.b.getVideoHeight()) / this.b.getVideoWidth()))) - (C1523w.f4503b * 64.0f)) - (C1523w.f4503b * 64.0f)) - (C1523w.f4503b * 40.0f) < 0.0f) {
            z = true;
        }
        return z;
    }

    /* renamed from: o */
    private boolean m17221o() {
        double videoWidth = (double) (this.b.getVideoHeight() > 0 ? ((float) this.b.getVideoWidth()) / ((float) this.b.getVideoHeight()) : -1.0f);
        return videoWidth > 0.9d && videoWidth < 1.1d;
    }

    /* renamed from: p */
    private void m17222p() {
        m17218b(this.b);
        m17218b(this.f13759p);
        m17218b(this.f13760q);
        m17218b(this.f13761r);
        m17218b(this.f13762s);
        m17218b(this.f13764u);
        m17218b(this.f13765v);
        m17218b(this.f13767x);
        if (this.f13763t != null) {
            m17218b(this.f13763t);
        }
    }

    /* renamed from: a */
    protected void mo3348a() {
        if (this.c == null) {
            Log.e(f13747j, "Unable to add UI without a valid ad response.");
            return;
        }
        JSONObject jSONObject;
        String string = this.c.getString(UserDataStore.CITY);
        String optString = this.c.getJSONObject("context").optString("orientation");
        if (!optString.isEmpty()) {
            this.f13758o = C1331a.m4602a(Integer.parseInt(optString));
        }
        if (this.c.has("layout") && !this.c.isNull("layout")) {
            jSONObject = this.c.getJSONObject("layout");
            this.f13768y = (int) jSONObject.optLong("bgColor", (long) this.f13768y);
            this.f13769z = (int) jSONObject.optLong("textColor", (long) this.f13769z);
            this.f13748A = (int) jSONObject.optLong("accentColor", (long) this.f13748A);
            this.f13749B = jSONObject.optBoolean("persistentAdDetails", this.f13749B);
        }
        jSONObject = this.c.getJSONObject("text");
        this.b.setId(VERSION.SDK_INT >= 17 ? View.generateViewId() : C1523w.m5339a());
        int c = m15573c();
        Context context = this.d;
        if (c < 0) {
            c = 0;
        }
        this.f13767x = new C3680j(context, c, this.f13748A);
        this.f13767x.setOnTouchListener(this.f13757n);
        this.b.m11915a(this.f13767x);
        if (this.c.has("cta") && !this.c.isNull("cta")) {
            JSONObject jSONObject2 = this.c.getJSONObject("cta");
            this.f13759p = new C1584a(this.d, jSONObject2.getString("url"), jSONObject2.getString("text"), this.f13748A, this.b, this.a, string);
            C1298c.m4444a(this.d, this.a, string, Uri.parse(jSONObject2.getString("url")), new HashMap());
        }
        if (this.c.has("icon") && !this.c.isNull("icon")) {
            JSONObject jSONObject3 = this.c.getJSONObject("icon");
            this.f13762s = new ImageView(this.d);
            new C1577d(this.f13762s).m5505a((int) (C1523w.f4503b * 64.0f), (int) (C1523w.f4503b * 64.0f)).m5508a(jSONObject3.getString("url"));
        }
        if (this.c.has(MessengerShareContentUtility.MEDIA_IMAGE) && !this.c.isNull(MessengerShareContentUtility.MEDIA_IMAGE)) {
            jSONObject3 = this.c.getJSONObject(MessengerShareContentUtility.MEDIA_IMAGE);
            C1625b c4597g = new C4597g(this.d);
            this.b.m11915a(c4597g);
            c4597g.setImage(jSONObject3.getString("url"));
        }
        CharSequence optString2 = jSONObject.optString("title");
        if (!optString2.isEmpty()) {
            this.f13760q = new TextView(this.d);
            this.f13760q.setText(optString2);
            this.f13760q.setTypeface(Typeface.defaultFromStyle(1));
        }
        CharSequence optString3 = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
        if (!optString3.isEmpty()) {
            this.f13761r = new TextView(this.d);
            this.f13761r.setText(optString3);
            this.f13761r.setTextSize(16.0f);
        }
        this.f13764u = new C3682n(this.d);
        this.b.m11915a(this.f13764u);
        Object d = m15574d();
        if (!TextUtils.isEmpty(d)) {
            this.f13763t = new C1635a(this.d, "AdChoices", d, new float[]{0.0f, 0.0f, 8.0f, 0.0f}, string);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            this.f13763t.setLayoutParams(layoutParams);
        }
        this.b.m11915a(new C4607k(this.d));
        C1625b c4611l = new C4611l(this.d);
        this.b.m11915a(c4611l);
        C1640a c1640a = mo3349h() ? C1640a.FADE_OUT_ON_PLAY : C1640a.VISIBLE;
        this.b.m11915a(new C3675d(c4611l, c1640a));
        this.f13766w = new C3675d(new RelativeLayout(this.d), c1640a);
        this.b.m11915a(this.f13766w);
    }

    @TargetApi(17)
    /* renamed from: a */
    public void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        this.f13755l = audienceNetworkActivity;
        if (!f13746i) {
            if (this.f13754k == null) {
                throw new AssertionError();
            }
        }
        audienceNetworkActivity.addBackButtonInterceptor(this.f13756m);
        m17222p();
        m17214a(this.f13755l.getResources().getConfiguration().orientation);
        if (mo3349h()) {
            mo2861e();
        } else {
            m15576f();
        }
    }

    /* renamed from: a */
    public void m17225a(Configuration configuration) {
        m17222p();
        m17214a(configuration.orientation);
    }

    /* renamed from: a */
    public void mo1011a(Bundle bundle) {
    }

    /* renamed from: h */
    protected boolean mo3349h() {
        if (!f13746i) {
            if (this.c == null) {
                throw new AssertionError();
            }
        }
        try {
            return this.c.getJSONObject("video").getBoolean(AudienceNetworkActivity.AUTOPLAY);
        } catch (Throwable e) {
            Log.w(String.valueOf(C4844l.class), "Invalid JSON", e);
            return true;
        }
    }

    /* renamed from: i */
    public void mo1012i() {
        if (this.b != null && this.b.getState() == C1658d.STARTED) {
            this.f13750C = this.b.getVideoStartReason();
            this.b.m11917a(false);
        }
    }

    /* renamed from: j */
    public void mo1013j() {
        if (this.b != null && this.f13750C != null) {
            this.b.m11914a(this.f13750C);
        }
    }

    /* renamed from: k */
    public C1331a m17230k() {
        return this.f13758o;
    }

    /* renamed from: l */
    public void m17231l() {
        if (this.f13755l != null) {
            this.f13755l.finish();
        }
    }

    public void onDestroy() {
        if (!(this.c == null || this.a == null)) {
            Object optString = this.c.optString(UserDataStore.CITY);
            if (!TextUtils.isEmpty(optString)) {
                this.a.mo954i(optString, new HashMap());
            }
        }
        if (this.b != null) {
            this.b.m11921f();
        }
        C4562k.m15582a((C1566a) this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.b != null) {
            this.b.getEventBus().m4803a(new C3666t(view, motionEvent));
        }
        return true;
    }

    public void setListener(C1551a c1551a) {
        this.f13754k = c1551a;
    }
}
