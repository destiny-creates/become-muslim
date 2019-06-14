package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0704l;
import android.support.v7.widget.RecyclerView.C0706n;
import android.support.v7.widget.RecyclerView.C0714t;
import android.support.v7.widget.RecyclerView.C0714t.C0712a;
import android.support.v7.widget.RecyclerView.C0714t.C0713b;
import android.support.v7.widget.RecyclerView.C0715u;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* compiled from: SnapHelper */
public abstract class bi extends C0704l {
    /* renamed from: a */
    RecyclerView f8800a;
    /* renamed from: b */
    private Scroller f8801b;
    /* renamed from: c */
    private final C0706n f8802c = new C33121(this);

    /* compiled from: SnapHelper */
    /* renamed from: android.support.v7.widget.bi$1 */
    class C33121 extends C0706n {
        /* renamed from: a */
        boolean f8798a = null;
        /* renamed from: b */
        final /* synthetic */ bi f8799b;

        C33121(bi biVar) {
            this.f8799b = biVar;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f8798a != null) {
                this.f8798a = null;
                this.f8799b.m10538a();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f8798a = true;
            }
        }
    }

    /* renamed from: a */
    public abstract int mo2776a(C0701i c0701i, int i, int i2);

    /* renamed from: a */
    public abstract View mo2777a(C0701i c0701i);

    /* renamed from: a */
    public abstract int[] mo2778a(C0701i c0701i, View view);

    /* renamed from: a */
    public boolean mo667a(int i, int i2) {
        C0701i layoutManager = this.f8800a.getLayoutManager();
        boolean z = false;
        if (layoutManager == null || this.f8800a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f8800a.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && m10534b(layoutManager, i, i2) != 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void m10539a(RecyclerView recyclerView) {
        if (this.f8800a != recyclerView) {
            if (this.f8800a != null) {
                m10535c();
            }
            this.f8800a = recyclerView;
            if (this.f8800a != null) {
                m10533b();
                this.f8801b = new Scroller(this.f8800a.getContext(), new DecelerateInterpolator());
                m10538a();
            }
        }
    }

    /* renamed from: b */
    private void m10533b() {
        if (this.f8800a.getOnFlingListener() == null) {
            this.f8800a.addOnScrollListener(this.f8802c);
            this.f8800a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    /* renamed from: c */
    private void m10535c() {
        this.f8800a.removeOnScrollListener(this.f8802c);
        this.f8800a.setOnFlingListener(null);
    }

    /* renamed from: b */
    private boolean m10534b(C0701i c0701i, int i, int i2) {
        if (!(c0701i instanceof C0713b)) {
            return false;
        }
        C0714t c = m10543c(c0701i);
        if (c == null) {
            return false;
        }
        i = mo2776a(c0701i, i, i2);
        if (i == -1) {
            return false;
        }
        c.setTargetPosition(i);
        c0701i.startSmoothScroll(c);
        return true;
    }

    /* renamed from: a */
    void m10538a() {
        if (this.f8800a != null) {
            C0701i layoutManager = this.f8800a.getLayoutManager();
            if (layoutManager != null) {
                View a = mo2777a(layoutManager);
                if (a != null) {
                    int[] a2 = mo2778a(layoutManager, a);
                    if (!(a2[0] == 0 && a2[1] == 0)) {
                        this.f8800a.smoothScrollBy(a2[0], a2[1]);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    protected C0714t m10543c(C0701i c0701i) {
        return mo2779b(c0701i);
    }

    @Deprecated
    /* renamed from: b */
    protected at mo2779b(C0701i c0701i) {
        if ((c0701i instanceof C0713b) == null) {
            return null;
        }
        return new at(this, this.f8800a.getContext()) {
            /* renamed from: a */
            final /* synthetic */ bi f12074a;

            protected void onTargetFound(View view, C0715u c0715u, C0712a c0712a) {
                if (this.f12074a.f8800a != null) {
                    view = this.f12074a.mo2778a(this.f12074a.f8800a.getLayoutManager(), view);
                    c0715u = view[null];
                    view = view[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(c0715u), Math.abs(view)));
                    if (calculateTimeForDeceleration > 0) {
                        c0712a.m2392a(c0715u, view, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
