package android.support.v7.widget;

import android.support.v4.p030f.C0397h;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0701i.C0699a;
import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0718x;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker */
final class aq implements Runnable {
    /* renamed from: a */
    static final ThreadLocal<aq> f2012a = new ThreadLocal();
    /* renamed from: e */
    static Comparator<C0761b> f2013e = new C07601();
    /* renamed from: b */
    ArrayList<RecyclerView> f2014b = new ArrayList();
    /* renamed from: c */
    long f2015c;
    /* renamed from: d */
    long f2016d;
    /* renamed from: f */
    private ArrayList<C0761b> f2017f = new ArrayList();

    /* compiled from: GapWorker */
    /* renamed from: android.support.v7.widget.aq$1 */
    static class C07601 implements Comparator<C0761b> {
        C07601() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m2642a((C0761b) obj, (C0761b) obj2);
        }

        /* renamed from: a */
        public int m2642a(C0761b c0761b, C0761b c0761b2) {
            int i = 1;
            if ((c0761b.f2010d == null ? 1 : null) != (c0761b2.f2010d == null ? 1 : null)) {
                if (c0761b.f2010d != null) {
                    i = -1;
                }
                return i;
            } else if (c0761b.f2007a != c0761b2.f2007a) {
                if (c0761b.f2007a != null) {
                    i = -1;
                }
                return i;
            } else {
                int i2 = c0761b2.f2008b - c0761b.f2008b;
                if (i2 != 0) {
                    return i2;
                }
                c0761b = c0761b.f2009c - c0761b2.f2009c;
                if (c0761b != null) {
                    return c0761b;
                }
                return 0;
            }
        }
    }

    /* compiled from: GapWorker */
    /* renamed from: android.support.v7.widget.aq$b */
    static class C0761b {
        /* renamed from: a */
        public boolean f2007a;
        /* renamed from: b */
        public int f2008b;
        /* renamed from: c */
        public int f2009c;
        /* renamed from: d */
        public RecyclerView f2010d;
        /* renamed from: e */
        public int f2011e;

        C0761b() {
        }

        /* renamed from: a */
        public void m2643a() {
            this.f2007a = false;
            this.f2008b = 0;
            this.f2009c = 0;
            this.f2010d = null;
            this.f2011e = 0;
        }
    }

    /* compiled from: GapWorker */
    /* renamed from: android.support.v7.widget.aq$a */
    static class C3307a implements C0699a {
        /* renamed from: a */
        int f8750a;
        /* renamed from: b */
        int f8751b;
        /* renamed from: c */
        int[] f8752c;
        /* renamed from: d */
        int f8753d;

        C3307a() {
        }

        /* renamed from: a */
        void m10438a(int i, int i2) {
            this.f8750a = i;
            this.f8751b = i2;
        }

        /* renamed from: a */
        void m10439a(RecyclerView recyclerView, boolean z) {
            this.f8753d = 0;
            if (this.f8752c != null) {
                Arrays.fill(this.f8752c, -1);
            }
            C0701i c0701i = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && c0701i != null && c0701i.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.m10618d()) {
                        c0701i.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    c0701i.collectAdjacentPrefetchPositions(this.f8750a, this.f8751b, recyclerView.mState, this);
                }
                if (this.f8753d > c0701i.mPrefetchMaxCountObserved) {
                    c0701i.mPrefetchMaxCountObserved = this.f8753d;
                    c0701i.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.m2366b();
                }
            }
        }

        /* renamed from: b */
        public void mo629b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f8753d * 2;
                if (this.f8752c == null) {
                    this.f8752c = new int[4];
                    Arrays.fill(this.f8752c, -1);
                } else if (i3 >= this.f8752c.length) {
                    Object obj = this.f8752c;
                    this.f8752c = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.f8752c, 0, obj.length);
                }
                this.f8752c[i3] = i;
                this.f8752c[i3 + 1] = i2;
                this.f8753d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* renamed from: a */
        boolean m10440a(int i) {
            if (this.f8752c != null) {
                int i2 = this.f8753d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f8752c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: a */
        void m10437a() {
            if (this.f8752c != null) {
                Arrays.fill(this.f8752c, -1);
            }
            this.f8753d = 0;
        }
    }

    aq() {
    }

    /* renamed from: a */
    public void m2651a(RecyclerView recyclerView) {
        this.f2014b.add(recyclerView);
    }

    /* renamed from: b */
    public void m2653b(RecyclerView recyclerView) {
        this.f2014b.remove(recyclerView);
    }

    /* renamed from: a */
    void m2652a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2015c == 0) {
            this.f2015c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.m10438a(i, i2);
    }

    /* renamed from: a */
    private void m2645a() {
        int i;
        int size = this.f2014b.size();
        int i2 = 0;
        for (i = 0; i < size; i++) {
            RecyclerView recyclerView = (RecyclerView) this.f2014b.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.m10439a(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f8753d;
            }
        }
        this.f2017f.ensureCapacity(i2);
        i2 = 0;
        for (i = 0; i < size; i++) {
            recyclerView = (RecyclerView) this.f2014b.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                C3307a c3307a = recyclerView.mPrefetchRegistry;
                int abs = Math.abs(c3307a.f8750a) + Math.abs(c3307a.f8751b);
                int i3 = i2;
                for (i2 = 0; i2 < c3307a.f8753d * 2; i2 += 2) {
                    C0761b c0761b;
                    if (i3 >= this.f2017f.size()) {
                        c0761b = new C0761b();
                        this.f2017f.add(c0761b);
                    } else {
                        c0761b = (C0761b) this.f2017f.get(i3);
                    }
                    int i4 = c3307a.f8752c[i2 + 1];
                    c0761b.f2007a = i4 <= abs;
                    c0761b.f2008b = abs;
                    c0761b.f2009c = i4;
                    c0761b.f2010d = recyclerView;
                    c0761b.f2011e = c3307a.f8752c[i2];
                    i3++;
                }
                i2 = i3;
            }
        }
        Collections.sort(this.f2017f, f2013e);
    }

    /* renamed from: a */
    static boolean m2648a(RecyclerView recyclerView, int i) {
        int c = recyclerView.mChildHelper.m2564c();
        for (int i2 = 0; i2 < c; i2++) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m2567d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private C0718x m2644a(RecyclerView recyclerView, int i, long j) {
        if (m2648a(recyclerView, i)) {
            return null;
        }
        C0709p c0709p = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            C0718x a = c0709p.m2351a(i, false, j);
            if (a != null) {
                if (a.isBound() == null || a.isInvalid() != null) {
                    c0709p.m2361a(a, false);
                } else {
                    c0709p.m2362a(a.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return a;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* renamed from: a */
    private void m2646a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.m2564c() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            C3307a c3307a = recyclerView.mPrefetchRegistry;
            c3307a.m10439a(recyclerView, true);
            if (c3307a.f8753d != 0) {
                try {
                    C0397h.m1177a("RV Nested Prefetch");
                    recyclerView.mState.m2397a(recyclerView.mAdapter);
                    for (int i = 0; i < c3307a.f8753d * 2; i += 2) {
                        m2644a(recyclerView, c3307a.f8752c[i], j);
                    }
                } finally {
                    C0397h.m1176a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m2647a(C0761b c0761b, long j) {
        c0761b = m2644a(c0761b.f2010d, c0761b.f2011e, c0761b.f2007a ? Clock.MAX_TIME : j);
        if (c0761b != null && c0761b.mNestedRecyclerView != null && c0761b.isBound() && !c0761b.isInvalid()) {
            m2646a((RecyclerView) c0761b.mNestedRecyclerView.get(), j);
        }
    }

    /* renamed from: b */
    private void m2649b(long j) {
        int i = 0;
        while (i < this.f2017f.size()) {
            C0761b c0761b = (C0761b) this.f2017f.get(i);
            if (c0761b.f2010d != null) {
                m2647a(c0761b, j);
                c0761b.m2643a();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    void m2650a(long j) {
        m2645a();
        m2649b(j);
    }

    public void run() {
        try {
            C0397h.m1177a("RV Prefetch");
            if (!this.f2014b.isEmpty()) {
                int size = this.f2014b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.f2014b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.f2015c = 0;
                    C0397h.m1176a();
                    return;
                }
                m2650a(TimeUnit.MILLISECONDS.toNanos(j) + this.f2016d);
                this.f2015c = 0;
                C0397h.m1176a();
            }
        } finally {
            this.f2015c = 0;
            C0397h.m1176a();
        }
    }
}
