package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0714t.C0712a;
import android.support.v7.widget.RecyclerView.C0714t.C0713b;
import android.support.v7.widget.RecyclerView.C0715u;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: PagerSnapHelper */
public class az extends bi {
    /* renamed from: b */
    private ay f12072b;
    /* renamed from: c */
    private ay f12073c;

    /* renamed from: a */
    public int[] mo2778a(C0701i c0701i, View view) {
        int[] iArr = new int[2];
        if (c0701i.canScrollHorizontally()) {
            iArr[0] = m15174a(c0701i, view, m15178e(c0701i));
        } else {
            iArr[0] = 0;
        }
        if (c0701i.canScrollVertically()) {
            iArr[1] = m15174a(c0701i, view, m15177d(c0701i));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* renamed from: a */
    public View mo2777a(C0701i c0701i) {
        if (c0701i.canScrollVertically()) {
            return m15175a(c0701i, m15177d(c0701i));
        }
        return c0701i.canScrollHorizontally() ? m15175a(c0701i, m15178e(c0701i)) : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public int mo2776a(android.support.v7.widget.RecyclerView.C0701i r6, int r7, int r8) {
        /*
        r5 = this;
        r0 = r6.getItemCount();
        r1 = -1;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = 0;
        r3 = r6.canScrollVertically();
        if (r3 == 0) goto L_0x0018;
    L_0x000f:
        r2 = r5.m15177d(r6);
        r2 = r5.m15176b(r6, r2);
        goto L_0x0026;
    L_0x0018:
        r3 = r6.canScrollHorizontally();
        if (r3 == 0) goto L_0x0026;
    L_0x001e:
        r2 = r5.m15178e(r6);
        r2 = r5.m15176b(r6, r2);
    L_0x0026:
        if (r2 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = r6.getPosition(r2);
        if (r2 != r1) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r1 = r6.canScrollHorizontally();
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x003e;
    L_0x0038:
        if (r7 <= 0) goto L_0x003c;
    L_0x003a:
        r7 = 1;
        goto L_0x0041;
    L_0x003c:
        r7 = 0;
        goto L_0x0041;
    L_0x003e:
        if (r8 <= 0) goto L_0x003c;
    L_0x0040:
        goto L_0x003a;
    L_0x0041:
        r8 = r6 instanceof android.support.v7.widget.RecyclerView.C0714t.C0713b;
        if (r8 == 0) goto L_0x005c;
    L_0x0045:
        r6 = (android.support.v7.widget.RecyclerView.C0714t.C0713b) r6;
        r0 = r0 - r4;
        r6 = r6.computeScrollVectorForPosition(r0);
        if (r6 == 0) goto L_0x005c;
    L_0x004e:
        r8 = r6.x;
        r0 = 0;
        r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r8 < 0) goto L_0x005b;
    L_0x0055:
        r6 = r6.y;
        r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r6 >= 0) goto L_0x005c;
    L_0x005b:
        r3 = 1;
    L_0x005c:
        if (r3 == 0) goto L_0x0063;
    L_0x005e:
        if (r7 == 0) goto L_0x0067;
    L_0x0060:
        r2 = r2 + -1;
        goto L_0x0067;
    L_0x0063:
        if (r7 == 0) goto L_0x0067;
    L_0x0065:
        r2 = r2 + 1;
    L_0x0067:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.az.a(android.support.v7.widget.RecyclerView$i, int, int):int");
    }

    /* renamed from: b */
    protected at mo2779b(C0701i c0701i) {
        if ((c0701i instanceof C0713b) == null) {
            return null;
        }
        return new at(this, this.a.getContext()) {
            /* renamed from: a */
            final /* synthetic */ az f12071a;

            protected void onTargetFound(View view, C0715u c0715u, C0712a c0712a) {
                view = this.f12071a.mo2778a(this.f12071a.a.getLayoutManager(), view);
                c0715u = view[null];
                view = view[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(c0715u), Math.abs(view)));
                if (calculateTimeForDeceleration > 0) {
                    c0712a.m2392a(c0715u, view, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            protected int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }
        };
    }

    /* renamed from: a */
    private int m15174a(C0701i c0701i, View view, ay ayVar) {
        int a = ayVar.mo647a(view) + (ayVar.mo655e(view) / 2);
        if (c0701i.getClipToPadding() != null) {
            c0701i = ayVar.mo650c() + (ayVar.mo656f() / 2);
        } else {
            c0701i = ayVar.mo654e() / 2;
        }
        return a - c0701i;
    }

    /* renamed from: a */
    private View m15175a(C0701i c0701i, ay ayVar) {
        int childCount = c0701i.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int c;
        if (c0701i.getClipToPadding()) {
            c = ayVar.mo650c() + (ayVar.mo656f() / 2);
        } else {
            c = ayVar.mo654e() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c0701i.getChildAt(i2);
            int abs = Math.abs((ayVar.mo647a(childAt) + (ayVar.mo655e(childAt) / 2)) - c);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    /* renamed from: b */
    private View m15176b(C0701i c0701i, ay ayVar) {
        int childCount = c0701i.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = c0701i.getChildAt(i2);
            int a = ayVar.mo647a(childAt);
            if (a < i) {
                view = childAt;
                i = a;
            }
        }
        return view;
    }

    /* renamed from: d */
    private ay m15177d(C0701i c0701i) {
        if (this.f12072b == null || this.f12072b.f2052a != c0701i) {
            this.f12072b = ay.m2689b(c0701i);
        }
        return this.f12072b;
    }

    /* renamed from: e */
    private ay m15178e(C0701i c0701i) {
        if (this.f12073c == null || this.f12073c.f2052a != c0701i) {
            this.f12073c = ay.m2687a(c0701i);
        }
        return this.f12073c;
    }
}
