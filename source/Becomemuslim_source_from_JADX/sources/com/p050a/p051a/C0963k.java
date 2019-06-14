package com.p050a.p051a;

import android.support.v4.util.C0448b;
import android.support.v4.util.C0461j;
import com.p050a.p051a.p061e.C0946d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker */
/* renamed from: com.a.a.k */
public class C0963k {
    /* renamed from: a */
    private boolean f2726a = false;
    /* renamed from: b */
    private final Set<C0962a> f2727b = new C0448b();
    /* renamed from: c */
    private final Map<String, C0946d> f2728c = new HashMap();
    /* renamed from: d */
    private final Comparator<C0461j<String, Float>> f2729d = new C09611(this);

    /* compiled from: PerformanceTracker */
    /* renamed from: com.a.a.k$1 */
    class C09611 implements Comparator<C0461j<String, Float>> {
        /* renamed from: a */
        final /* synthetic */ C0963k f2725a;

        C09611(C0963k c0963k) {
            this.f2725a = c0963k;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3405a((C0461j) obj, (C0461j) obj2);
        }

        /* renamed from: a */
        public int m3405a(C0461j<String, Float> c0461j, C0461j<String, Float> c0461j2) {
            c0461j = ((Float) c0461j.f1190b).floatValue();
            c0461j2 = ((Float) c0461j2.f1190b).floatValue();
            if (c0461j2 > c0461j) {
                return 1;
            }
            return c0461j > c0461j2 ? -1 : null;
        }
    }

    /* compiled from: PerformanceTracker */
    /* renamed from: com.a.a.k$a */
    public interface C0962a {
        /* renamed from: a */
        void m3406a(float f);
    }

    /* renamed from: a */
    void m3408a(boolean z) {
        this.f2726a = z;
    }

    /* renamed from: a */
    public void m3407a(String str, float f) {
        if (this.f2726a) {
            C0946d c0946d = (C0946d) this.f2728c.get(str);
            if (c0946d == null) {
                c0946d = new C0946d();
                this.f2728c.put(str, c0946d);
            }
            c0946d.m3300a(f);
            if (str.equals("__container") != null) {
                for (C0962a a : this.f2727b) {
                    a.m3406a(f);
                }
            }
        }
    }
}
