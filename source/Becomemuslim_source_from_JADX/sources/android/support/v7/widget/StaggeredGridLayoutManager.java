package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0483b.C0482c;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0701i.C0699a;
import android.support.v7.widget.RecyclerView.C0702j;
import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0714t.C0713b;
import android.support.v7.widget.RecyclerView.C0715u;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0701i implements C0713b {
    /* renamed from: a */
    C0733e[] f8678a;
    /* renamed from: b */
    ay f8679b;
    /* renamed from: c */
    ay f8680c;
    /* renamed from: d */
    boolean f8681d = false;
    /* renamed from: e */
    boolean f8682e = false;
    /* renamed from: f */
    int f8683f = -1;
    /* renamed from: g */
    int f8684g = LinearLayoutManager.INVALID_OFFSET;
    /* renamed from: h */
    C0730c f8685h = new C0730c();
    /* renamed from: i */
    private int f8686i = -1;
    /* renamed from: j */
    private int f8687j;
    /* renamed from: k */
    private int f8688k;
    /* renamed from: l */
    private final ar f8689l;
    /* renamed from: m */
    private BitSet f8690m;
    /* renamed from: n */
    private int f8691n = 2;
    /* renamed from: o */
    private boolean f8692o;
    /* renamed from: p */
    private boolean f8693p;
    /* renamed from: q */
    private C0732d f8694q;
    /* renamed from: r */
    private int f8695r;
    /* renamed from: s */
    private final Rect f8696s = new Rect();
    /* renamed from: t */
    private final C0727a f8697t = new C0727a(this);
    /* renamed from: u */
    private boolean f8698u = false;
    /* renamed from: v */
    private boolean f8699v = true;
    /* renamed from: w */
    private int[] f8700w;
    /* renamed from: x */
    private final Runnable f8701x = new C07261(this);

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$1 */
    class C07261 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ StaggeredGridLayoutManager f1874a;

        C07261(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1874a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f1874a.m10340a();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$a */
    class C0727a {
        /* renamed from: a */
        int f1875a;
        /* renamed from: b */
        int f1876b;
        /* renamed from: c */
        boolean f1877c;
        /* renamed from: d */
        boolean f1878d;
        /* renamed from: e */
        boolean f1879e;
        /* renamed from: f */
        int[] f1880f;
        /* renamed from: g */
        final /* synthetic */ StaggeredGridLayoutManager f1881g;

        C0727a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f1881g = staggeredGridLayoutManager;
            m2426a();
        }

        /* renamed from: a */
        void m2426a() {
            this.f1875a = -1;
            this.f1876b = LinearLayoutManager.INVALID_OFFSET;
            this.f1877c = false;
            this.f1878d = false;
            this.f1879e = false;
            if (this.f1880f != null) {
                Arrays.fill(this.f1880f, -1);
            }
        }

        /* renamed from: a */
        void m2428a(C0733e[] c0733eArr) {
            int length = c0733eArr.length;
            if (this.f1880f == null || this.f1880f.length < length) {
                this.f1880f = new int[this.f1881g.f8678a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f1880f[i] = c0733eArr[i].m2452a((int) LinearLayoutManager.INVALID_OFFSET);
            }
        }

        /* renamed from: b */
        void m2429b() {
            int d;
            if (this.f1877c) {
                d = this.f1881g.f8679b.mo652d();
            } else {
                d = this.f1881g.f8679b.mo650c();
            }
            this.f1876b = d;
        }

        /* renamed from: a */
        void m2427a(int i) {
            if (this.f1877c) {
                this.f1876b = this.f1881g.f8679b.mo652d() - i;
            } else {
                this.f1876b = this.f1881g.f8679b.mo650c() + i;
            }
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$c */
    static class C0730c {
        /* renamed from: a */
        int[] f1886a;
        /* renamed from: b */
        List<C0729a> f1887b;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$c$a */
        static class C0729a implements Parcelable {
            public static final Creator<C0729a> CREATOR = new C07281();
            /* renamed from: a */
            int f1882a;
            /* renamed from: b */
            int f1883b;
            /* renamed from: c */
            int[] f1884c;
            /* renamed from: d */
            boolean f1885d;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$c$a$1 */
            static class C07281 implements Creator<C0729a> {
                C07281() {
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m2430a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m2431a(i);
                }

                /* renamed from: a */
                public C0729a m2430a(Parcel parcel) {
                    return new C0729a(parcel);
                }

                /* renamed from: a */
                public C0729a[] m2431a(int i) {
                    return new C0729a[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            C0729a(Parcel parcel) {
                this.f1882a = parcel.readInt();
                this.f1883b = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f1885d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1884c = new int[readInt];
                    parcel.readIntArray(this.f1884c);
                }
            }

            C0729a() {
            }

            /* renamed from: a */
            int m2432a(int i) {
                return this.f1884c == null ? 0 : this.f1884c[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1882a);
                parcel.writeInt(this.f1883b);
                parcel.writeInt(this.f1885d);
                if (this.f1884c == 0 || this.f1884c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f1884c.length);
                parcel.writeIntArray(this.f1884c);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("FullSpanItem{mPosition=");
                stringBuilder.append(this.f1882a);
                stringBuilder.append(", mGapDir=");
                stringBuilder.append(this.f1883b);
                stringBuilder.append(", mHasUnwantedGapAfter=");
                stringBuilder.append(this.f1885d);
                stringBuilder.append(", mGapPerSpan=");
                stringBuilder.append(Arrays.toString(this.f1884c));
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
        }

        C0730c() {
        }

        /* renamed from: a */
        int m2436a(int i) {
            if (this.f1887b != null) {
                for (int size = this.f1887b.size() - 1; size >= 0; size--) {
                    if (((C0729a) this.f1887b.get(size)).f1882a >= i) {
                        this.f1887b.remove(size);
                    }
                }
            }
            return m2442b(i);
        }

        /* renamed from: b */
        int m2442b(int i) {
            if (this.f1886a == null || i >= this.f1886a.length) {
                return -1;
            }
            int g = m2435g(i);
            if (g == -1) {
                Arrays.fill(this.f1886a, i, this.f1886a.length, -1);
                return this.f1886a.length;
            }
            g++;
            Arrays.fill(this.f1886a, i, g, -1);
            return g;
        }

        /* renamed from: c */
        int m2444c(int i) {
            if (this.f1886a != null) {
                if (i < this.f1886a.length) {
                    return this.f1886a[i];
                }
            }
            return -1;
        }

        /* renamed from: a */
        void m2440a(int i, C0733e c0733e) {
            m2446e(i);
            this.f1886a[i] = c0733e.f1902e;
        }

        /* renamed from: d */
        int m2445d(int i) {
            int length = this.f1886a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: e */
        void m2446e(int i) {
            if (this.f1886a == null) {
                this.f1886a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1886a, -1);
            } else if (i >= this.f1886a.length) {
                Object obj = this.f1886a;
                this.f1886a = new int[m2445d(i)];
                System.arraycopy(obj, 0, this.f1886a, 0, obj.length);
                Arrays.fill(this.f1886a, obj.length, this.f1886a.length, -1);
            }
        }

        /* renamed from: a */
        void m2438a() {
            if (this.f1886a != null) {
                Arrays.fill(this.f1886a, -1);
            }
            this.f1887b = null;
        }

        /* renamed from: a */
        void m2439a(int i, int i2) {
            if (this.f1886a != null) {
                if (i < this.f1886a.length) {
                    int i3 = i + i2;
                    m2446e(i3);
                    System.arraycopy(this.f1886a, i3, this.f1886a, i, (this.f1886a.length - i) - i2);
                    Arrays.fill(this.f1886a, this.f1886a.length - i2, this.f1886a.length, -1);
                    m2433c(i, i2);
                }
            }
        }

        /* renamed from: c */
        private void m2433c(int i, int i2) {
            if (this.f1887b != null) {
                int i3 = i + i2;
                for (int size = this.f1887b.size() - 1; size >= 0; size--) {
                    C0729a c0729a = (C0729a) this.f1887b.get(size);
                    if (c0729a.f1882a >= i) {
                        if (c0729a.f1882a < i3) {
                            this.f1887b.remove(size);
                        } else {
                            c0729a.f1882a -= i2;
                        }
                    }
                }
            }
        }

        /* renamed from: b */
        void m2443b(int i, int i2) {
            if (this.f1886a != null) {
                if (i < this.f1886a.length) {
                    int i3 = i + i2;
                    m2446e(i3);
                    System.arraycopy(this.f1886a, i, this.f1886a, i3, (this.f1886a.length - i) - i2);
                    Arrays.fill(this.f1886a, i, i3, -1);
                    m2434d(i, i2);
                }
            }
        }

        /* renamed from: d */
        private void m2434d(int i, int i2) {
            if (this.f1887b != null) {
                for (int size = this.f1887b.size() - 1; size >= 0; size--) {
                    C0729a c0729a = (C0729a) this.f1887b.get(size);
                    if (c0729a.f1882a >= i) {
                        c0729a.f1882a += i2;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m2435g(int i) {
            if (this.f1887b == null) {
                return -1;
            }
            C0729a f = m2447f(i);
            if (f != null) {
                this.f1887b.remove(f);
            }
            int size = this.f1887b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((C0729a) this.f1887b.get(i2)).f1882a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            C0729a c0729a = (C0729a) this.f1887b.get(i2);
            this.f1887b.remove(i2);
            return c0729a.f1882a;
        }

        /* renamed from: a */
        public void m2441a(C0729a c0729a) {
            if (this.f1887b == null) {
                this.f1887b = new ArrayList();
            }
            int size = this.f1887b.size();
            for (int i = 0; i < size; i++) {
                C0729a c0729a2 = (C0729a) this.f1887b.get(i);
                if (c0729a2.f1882a == c0729a.f1882a) {
                    this.f1887b.remove(i);
                }
                if (c0729a2.f1882a >= c0729a.f1882a) {
                    this.f1887b.add(i, c0729a);
                    return;
                }
            }
            this.f1887b.add(c0729a);
        }

        /* renamed from: f */
        public C0729a m2447f(int i) {
            if (this.f1887b == null) {
                return null;
            }
            for (int size = this.f1887b.size() - 1; size >= 0; size--) {
                C0729a c0729a = (C0729a) this.f1887b.get(size);
                if (c0729a.f1882a == i) {
                    return c0729a;
                }
            }
            return null;
        }

        /* renamed from: a */
        public C0729a m2437a(int i, int i2, int i3, boolean z) {
            if (this.f1887b == null) {
                return null;
            }
            int size = this.f1887b.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0729a c0729a = (C0729a) this.f1887b.get(i4);
                if (c0729a.f1882a >= i2) {
                    return null;
                }
                if (c0729a.f1882a >= i && (i3 == 0 || c0729a.f1883b == i3 || (z && c0729a.f1885d))) {
                    return c0729a;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d */
    public static class C0732d implements Parcelable {
        public static final Creator<C0732d> CREATOR = new C07311();
        /* renamed from: a */
        int f1888a;
        /* renamed from: b */
        int f1889b;
        /* renamed from: c */
        int f1890c;
        /* renamed from: d */
        int[] f1891d;
        /* renamed from: e */
        int f1892e;
        /* renamed from: f */
        int[] f1893f;
        /* renamed from: g */
        List<C0729a> f1894g;
        /* renamed from: h */
        boolean f1895h;
        /* renamed from: i */
        boolean f1896i;
        /* renamed from: j */
        boolean f1897j;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$d$1 */
        static class C07311 implements Creator<C0732d> {
            C07311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2448a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2449a(i);
            }

            /* renamed from: a */
            public C0732d m2448a(Parcel parcel) {
                return new C0732d(parcel);
            }

            /* renamed from: a */
            public C0732d[] m2449a(int i) {
                return new C0732d[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        C0732d(Parcel parcel) {
            this.f1888a = parcel.readInt();
            this.f1889b = parcel.readInt();
            this.f1890c = parcel.readInt();
            if (this.f1890c > 0) {
                this.f1891d = new int[this.f1890c];
                parcel.readIntArray(this.f1891d);
            }
            this.f1892e = parcel.readInt();
            if (this.f1892e > 0) {
                this.f1893f = new int[this.f1892e];
                parcel.readIntArray(this.f1893f);
            }
            boolean z = false;
            this.f1895h = parcel.readInt() == 1;
            this.f1896i = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.f1897j = z;
            this.f1894g = parcel.readArrayList(C0729a.class.getClassLoader());
        }

        public C0732d(C0732d c0732d) {
            this.f1890c = c0732d.f1890c;
            this.f1888a = c0732d.f1888a;
            this.f1889b = c0732d.f1889b;
            this.f1891d = c0732d.f1891d;
            this.f1892e = c0732d.f1892e;
            this.f1893f = c0732d.f1893f;
            this.f1895h = c0732d.f1895h;
            this.f1896i = c0732d.f1896i;
            this.f1897j = c0732d.f1897j;
            this.f1894g = c0732d.f1894g;
        }

        /* renamed from: a */
        void m2450a() {
            this.f1891d = null;
            this.f1890c = 0;
            this.f1892e = 0;
            this.f1893f = null;
            this.f1894g = null;
        }

        /* renamed from: b */
        void m2451b() {
            this.f1891d = null;
            this.f1890c = 0;
            this.f1888a = -1;
            this.f1889b = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1888a);
            parcel.writeInt(this.f1889b);
            parcel.writeInt(this.f1890c);
            if (this.f1890c > 0) {
                parcel.writeIntArray(this.f1891d);
            }
            parcel.writeInt(this.f1892e);
            if (this.f1892e > 0) {
                parcel.writeIntArray(this.f1893f);
            }
            parcel.writeInt(this.f1895h);
            parcel.writeInt(this.f1896i);
            parcel.writeInt(this.f1897j);
            parcel.writeList(this.f1894g);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$e */
    class C0733e {
        /* renamed from: a */
        ArrayList<View> f1898a = new ArrayList();
        /* renamed from: b */
        int f1899b = LinearLayoutManager.INVALID_OFFSET;
        /* renamed from: c */
        int f1900c = LinearLayoutManager.INVALID_OFFSET;
        /* renamed from: d */
        int f1901d = null;
        /* renamed from: e */
        final int f1902e;
        /* renamed from: f */
        final /* synthetic */ StaggeredGridLayoutManager f1903f;

        C0733e(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f1903f = staggeredGridLayoutManager;
            this.f1902e = i;
        }

        /* renamed from: a */
        int m2452a(int i) {
            if (this.f1899b != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1899b;
            }
            if (this.f1898a.size() == 0) {
                return i;
            }
            m2456a();
            return this.f1899b;
        }

        /* renamed from: a */
        void m2456a() {
            View view = (View) this.f1898a.get(0);
            C3297b c = m2462c(view);
            this.f1899b = this.f1903f.f8679b.mo647a(view);
            if (c.f8677b) {
                C0729a f = this.f1903f.f8685h.m2447f(c.m2328f());
                if (f != null && f.f1883b == -1) {
                    this.f1899b -= f.m2432a(this.f1902e);
                }
            }
        }

        /* renamed from: b */
        int m2459b() {
            if (this.f1899b != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1899b;
            }
            m2456a();
            return this.f1899b;
        }

        /* renamed from: b */
        int m2460b(int i) {
            if (this.f1900c != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1900c;
            }
            if (this.f1898a.size() == 0) {
                return i;
            }
            m2463c();
            return this.f1900c;
        }

        /* renamed from: c */
        void m2463c() {
            View view = (View) this.f1898a.get(this.f1898a.size() - 1);
            C3297b c = m2462c(view);
            this.f1900c = this.f1903f.f8679b.mo649b(view);
            if (c.f8677b) {
                C0729a f = this.f1903f.f8685h.m2447f(c.m2328f());
                if (f != null && f.f1883b == 1) {
                    this.f1900c += f.m2432a(this.f1902e);
                }
            }
        }

        /* renamed from: d */
        int m2465d() {
            if (this.f1900c != LinearLayoutManager.INVALID_OFFSET) {
                return this.f1900c;
            }
            m2463c();
            return this.f1900c;
        }

        /* renamed from: a */
        void m2457a(View view) {
            C3297b c = m2462c(view);
            c.f8676a = this;
            this.f1898a.add(0, view);
            this.f1899b = LinearLayoutManager.INVALID_OFFSET;
            if (this.f1898a.size() == 1) {
                this.f1900c = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m2326d() || c.m2327e()) {
                this.f1901d += this.f1903f.f8679b.mo655e(view);
            }
        }

        /* renamed from: b */
        void m2461b(View view) {
            C3297b c = m2462c(view);
            c.f8676a = this;
            this.f1898a.add(view);
            this.f1900c = LinearLayoutManager.INVALID_OFFSET;
            if (this.f1898a.size() == 1) {
                this.f1899b = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m2326d() || c.m2327e()) {
                this.f1901d += this.f1903f.f8679b.mo655e(view);
            }
        }

        /* renamed from: a */
        void m2458a(boolean z, int i) {
            int b;
            if (z) {
                b = m2460b((int) LinearLayoutManager.INVALID_OFFSET);
            } else {
                b = m2452a((int) LinearLayoutManager.INVALID_OFFSET);
            }
            m2467e();
            if (b != LinearLayoutManager.INVALID_OFFSET) {
                if ((!z || b >= this.f1903f.f8679b.mo652d()) && (z || b <= this.f1903f.f8679b.mo650c())) {
                    if (i != LinearLayoutManager.INVALID_OFFSET) {
                        b += i;
                    }
                    this.f1900c = b;
                    this.f1899b = b;
                }
            }
        }

        /* renamed from: e */
        void m2467e() {
            this.f1898a.clear();
            m2468f();
            this.f1901d = 0;
        }

        /* renamed from: f */
        void m2468f() {
            this.f1899b = LinearLayoutManager.INVALID_OFFSET;
            this.f1900c = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: c */
        void m2464c(int i) {
            this.f1899b = i;
            this.f1900c = i;
        }

        /* renamed from: g */
        void m2469g() {
            int size = this.f1898a.size();
            View view = (View) this.f1898a.remove(size - 1);
            C3297b c = m2462c(view);
            c.f8676a = null;
            if (c.m2326d() || c.m2327e()) {
                this.f1901d -= this.f1903f.f8679b.mo655e(view);
            }
            if (size == 1) {
                this.f1899b = LinearLayoutManager.INVALID_OFFSET;
            }
            this.f1900c = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: h */
        void m2470h() {
            View view = (View) this.f1898a.remove(0);
            C3297b c = m2462c(view);
            c.f8676a = null;
            if (this.f1898a.size() == 0) {
                this.f1900c = LinearLayoutManager.INVALID_OFFSET;
            }
            if (c.m2326d() || c.m2327e()) {
                this.f1901d -= this.f1903f.f8679b.mo655e(view);
            }
            this.f1899b = LinearLayoutManager.INVALID_OFFSET;
        }

        /* renamed from: i */
        public int m2471i() {
            return this.f1901d;
        }

        /* renamed from: c */
        C3297b m2462c(View view) {
            return (C3297b) view.getLayoutParams();
        }

        /* renamed from: d */
        void m2466d(int i) {
            if (this.f1899b != LinearLayoutManager.INVALID_OFFSET) {
                this.f1899b += i;
            }
            if (this.f1900c != LinearLayoutManager.INVALID_OFFSET) {
                this.f1900c += i;
            }
        }

        /* renamed from: j */
        public int m2472j() {
            if (this.f1903f.f8681d) {
                return m2453a(this.f1898a.size() - 1, -1, true);
            }
            return m2453a(0, this.f1898a.size(), true);
        }

        /* renamed from: k */
        public int m2473k() {
            if (this.f1903f.f8681d) {
                return m2453a(0, this.f1898a.size(), true);
            }
            return m2453a(this.f1898a.size() - 1, -1, true);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        int m2454a(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            /*
            r10 = this;
            r0 = r10.f1903f;
            r0 = r0.f8679b;
            r0 = r0.mo650c();
            r1 = r10.f1903f;
            r1 = r1.f8679b;
            r1 = r1.mo652d();
            r2 = -1;
            r3 = 1;
            if (r12 <= r11) goto L_0x0016;
        L_0x0014:
            r4 = 1;
            goto L_0x0017;
        L_0x0016:
            r4 = -1;
        L_0x0017:
            if (r11 == r12) goto L_0x006f;
        L_0x0019:
            r5 = r10.f1898a;
            r5 = r5.get(r11);
            r5 = (android.view.View) r5;
            r6 = r10.f1903f;
            r6 = r6.f8679b;
            r6 = r6.mo647a(r5);
            r7 = r10.f1903f;
            r7 = r7.f8679b;
            r7 = r7.mo649b(r5);
            r8 = 0;
            if (r15 == 0) goto L_0x003a;
        L_0x0034:
            if (r6 > r1) goto L_0x0038;
        L_0x0036:
            r9 = 1;
            goto L_0x003d;
        L_0x0038:
            r9 = 0;
            goto L_0x003d;
        L_0x003a:
            if (r6 >= r1) goto L_0x0038;
        L_0x003c:
            goto L_0x0036;
        L_0x003d:
            if (r15 == 0) goto L_0x0043;
        L_0x003f:
            if (r7 < r0) goto L_0x0046;
        L_0x0041:
            r8 = 1;
            goto L_0x0046;
        L_0x0043:
            if (r7 <= r0) goto L_0x0046;
        L_0x0045:
            goto L_0x0041;
        L_0x0046:
            if (r9 == 0) goto L_0x006d;
        L_0x0048:
            if (r8 == 0) goto L_0x006d;
        L_0x004a:
            if (r13 == 0) goto L_0x0059;
        L_0x004c:
            if (r14 == 0) goto L_0x0059;
        L_0x004e:
            if (r6 < r0) goto L_0x006d;
        L_0x0050:
            if (r7 > r1) goto L_0x006d;
        L_0x0052:
            r11 = r10.f1903f;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x0059:
            if (r14 == 0) goto L_0x0062;
        L_0x005b:
            r11 = r10.f1903f;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x0062:
            if (r6 < r0) goto L_0x0066;
        L_0x0064:
            if (r7 <= r1) goto L_0x006d;
        L_0x0066:
            r11 = r10.f1903f;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x006d:
            r11 = r11 + r4;
            goto L_0x0017;
        L_0x006f:
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.e.a(int, int, boolean, boolean, boolean):int");
        }

        /* renamed from: a */
        int m2453a(int i, int i2, boolean z) {
            return m2454a(i, i2, false, false, z);
        }

        /* renamed from: a */
        public View m2455a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                i2 = this.f1898a.size() - 1;
                while (i2 >= 0) {
                    View view2 = (View) this.f1898a.get(i2);
                    if (!this.f1903f.f8681d || this.f1903f.getPosition(view2) < i) {
                        if (this.f1903f.f8681d || this.f1903f.getPosition(view2) > i) {
                            if (!view2.hasFocusable()) {
                                break;
                            }
                            i2--;
                            view = view2;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            i2 = this.f1898a.size();
            int i3 = 0;
            while (i3 < i2) {
                View view3 = (View) this.f1898a.get(i3);
                if (!this.f1903f.f8681d || this.f1903f.getPosition(view3) > i) {
                    if (this.f1903f.f8681d || this.f1903f.getPosition(view3) < i) {
                        if (!view3.hasFocusable()) {
                            break;
                        }
                        i3++;
                        view = view3;
                    } else {
                        break;
                    }
                }
                break;
            }
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager$b */
    public static class C3297b extends C0702j {
        /* renamed from: a */
        C0733e f8676a;
        /* renamed from: b */
        boolean f8677b;

        public C3297b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3297b(int i, int i2) {
            super(i, i2);
        }

        public C3297b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C3297b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public boolean m10294a() {
            return this.f8677b;
        }

        /* renamed from: b */
        public final int m10295b() {
            if (this.f8676a == null) {
                return -1;
            }
            return this.f8676a.f1902e;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        context = C0701i.getProperties(context, attributeSet, i, i2);
        m10343b(context.f1810a);
        m10336a(context.f1811b);
        m10339a(context.f1812c);
        this.f8689l = new ar();
        m10327j();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.f8687j = i2;
        m10336a(i);
        this.f8689l = new ar();
        m10327j();
    }

    public boolean isAutoMeasureEnabled() {
        return this.f8691n != 0;
    }

    /* renamed from: j */
    private void m10327j() {
        this.f8679b = ay.m2688a(this, this.f8687j);
        this.f8680c = ay.m2688a(this, 1 - this.f8687j);
    }

    /* renamed from: a */
    boolean m10340a() {
        if (!(getChildCount() == 0 || this.f8691n == 0)) {
            if (isAttachedToWindow()) {
                int h;
                int i;
                if (this.f8682e) {
                    h = m10352h();
                    i = m10353i();
                } else {
                    h = m10353i();
                    i = m10352h();
                }
                if (h == 0 && m10341b() != null) {
                    this.f8685h.m2438a();
                    requestSimpleAnimationsInNextLayout();
                    requestLayout();
                    return true;
                } else if (!this.f8698u) {
                    return false;
                } else {
                    int i2 = this.f8682e ? -1 : 1;
                    i++;
                    C0729a a = this.f8685h.m2437a(h, i, i2, true);
                    if (a == null) {
                        this.f8698u = false;
                        this.f8685h.m2436a(i);
                        return false;
                    }
                    C0729a a2 = this.f8685h.m2437a(h, a.f1882a, i2 * -1, true);
                    if (a2 == null) {
                        this.f8685h.m2436a(a.f1882a);
                    } else {
                        this.f8685h.m2436a(a2.f1882a + 1);
                    }
                    requestSimpleAnimationsInNextLayout();
                    requestLayout();
                    return true;
                }
            }
        }
        return false;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m10340a();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, C0709p c0709p) {
        super.onDetachedFromWindow(recyclerView, c0709p);
        removeCallbacks(this.f8701x);
        for (c0709p = null; c0709p < this.f8686i; c0709p++) {
            this.f8678a[c0709p].m2467e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    android.view.View m10341b() {
        /*
        r12 = this;
        r0 = r12.getChildCount();
        r1 = 1;
        r0 = r0 - r1;
        r2 = new java.util.BitSet;
        r3 = r12.f8686i;
        r2.<init>(r3);
        r3 = r12.f8686i;
        r4 = 0;
        r2.set(r4, r3, r1);
        r3 = r12.f8687j;
        r5 = -1;
        if (r3 != r1) goto L_0x0020;
    L_0x0018:
        r3 = r12.m10348d();
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        r3 = 1;
        goto L_0x0021;
    L_0x0020:
        r3 = -1;
    L_0x0021:
        r6 = r12.f8682e;
        if (r6 == 0) goto L_0x0027;
    L_0x0025:
        r6 = -1;
        goto L_0x002b;
    L_0x0027:
        r0 = r0 + 1;
        r6 = r0;
        r0 = 0;
    L_0x002b:
        if (r0 >= r6) goto L_0x002e;
    L_0x002d:
        r5 = 1;
    L_0x002e:
        if (r0 == r6) goto L_0x00ab;
    L_0x0030:
        r7 = r12.getChildAt(r0);
        r8 = r7.getLayoutParams();
        r8 = (android.support.v7.widget.StaggeredGridLayoutManager.C3297b) r8;
        r9 = r8.f8676a;
        r9 = r9.f1902e;
        r9 = r2.get(r9);
        if (r9 == 0) goto L_0x0054;
    L_0x0044:
        r9 = r8.f8676a;
        r9 = r12.m10310a(r9);
        if (r9 == 0) goto L_0x004d;
    L_0x004c:
        return r7;
    L_0x004d:
        r9 = r8.f8676a;
        r9 = r9.f1902e;
        r2.clear(r9);
    L_0x0054:
        r9 = r8.f8677b;
        if (r9 == 0) goto L_0x0059;
    L_0x0058:
        goto L_0x00a9;
    L_0x0059:
        r9 = r0 + r5;
        if (r9 == r6) goto L_0x00a9;
    L_0x005d:
        r9 = r12.getChildAt(r9);
        r10 = r12.f8682e;
        if (r10 == 0) goto L_0x0077;
    L_0x0065:
        r10 = r12.f8679b;
        r10 = r10.mo649b(r7);
        r11 = r12.f8679b;
        r11 = r11.mo649b(r9);
        if (r10 >= r11) goto L_0x0074;
    L_0x0073:
        return r7;
    L_0x0074:
        if (r10 != r11) goto L_0x008a;
    L_0x0076:
        goto L_0x0088;
    L_0x0077:
        r10 = r12.f8679b;
        r10 = r10.mo647a(r7);
        r11 = r12.f8679b;
        r11 = r11.mo647a(r9);
        if (r10 <= r11) goto L_0x0086;
    L_0x0085:
        return r7;
    L_0x0086:
        if (r10 != r11) goto L_0x008a;
    L_0x0088:
        r10 = 1;
        goto L_0x008b;
    L_0x008a:
        r10 = 0;
    L_0x008b:
        if (r10 == 0) goto L_0x00a9;
    L_0x008d:
        r9 = r9.getLayoutParams();
        r9 = (android.support.v7.widget.StaggeredGridLayoutManager.C3297b) r9;
        r8 = r8.f8676a;
        r8 = r8.f1902e;
        r9 = r9.f8676a;
        r9 = r9.f1902e;
        r8 = r8 - r9;
        if (r8 >= 0) goto L_0x00a0;
    L_0x009e:
        r8 = 1;
        goto L_0x00a1;
    L_0x00a0:
        r8 = 0;
    L_0x00a1:
        if (r3 >= 0) goto L_0x00a5;
    L_0x00a3:
        r9 = 1;
        goto L_0x00a6;
    L_0x00a5:
        r9 = 0;
    L_0x00a6:
        if (r8 == r9) goto L_0x00a9;
    L_0x00a8:
        return r7;
    L_0x00a9:
        r0 = r0 + r5;
        goto L_0x002e;
    L_0x00ab:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.b():android.view.View");
    }

    /* renamed from: a */
    private boolean m10310a(C0733e c0733e) {
        if (this.f8682e) {
            if (c0733e.m2465d() < this.f8679b.mo652d()) {
                return c0733e.m2462c((View) c0733e.f1898a.get(c0733e.f1898a.size() - 1)).f8677b ^ 1;
            }
        } else if (c0733e.m2459b() > this.f8679b.mo650c()) {
            return c0733e.m2462c((View) c0733e.f1898a.get(0)).f8677b ^ 1;
        }
        return false;
    }

    /* renamed from: a */
    public void m10336a(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.f8686i) {
            m10346c();
            this.f8686i = i;
            this.f8690m = new BitSet(this.f8686i);
            this.f8678a = new C0733e[this.f8686i];
            for (i = 0; i < this.f8686i; i++) {
                this.f8678a[i] = new C0733e(this, i);
            }
            requestLayout();
        }
    }

    /* renamed from: b */
    public void m10343b(int i) {
        if (i != 0) {
            if (i != 1) {
                throw new IllegalArgumentException("invalid orientation.");
            }
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.f8687j) {
            this.f8687j = i;
            i = this.f8679b;
            this.f8679b = this.f8680c;
            this.f8680c = i;
            requestLayout();
        }
    }

    /* renamed from: a */
    public void m10339a(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.f8694q == null || this.f8694q.f1895h == z)) {
            this.f8694q.f1895h = z;
        }
        this.f8681d = z;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f8694q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* renamed from: c */
    public void m10346c() {
        this.f8685h.m2438a();
        requestLayout();
    }

    /* renamed from: k */
    private void m10328k() {
        if (this.f8687j != 1) {
            if (m10348d()) {
                this.f8682e = this.f8681d ^ true;
                return;
            }
        }
        this.f8682e = this.f8681d;
    }

    /* renamed from: d */
    boolean m10348d() {
        return getLayoutDirection() == 1;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f8687j == 1) {
            rect = C0701i.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i = C0701i.chooseSize(i, (this.f8688k * this.f8686i) + paddingLeft, getMinimumWidth());
        } else {
            i = C0701i.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            rect = C0701i.chooseSize(i2, (this.f8688k * this.f8686i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i, rect);
    }

    public void onLayoutChildren(C0709p c0709p, C0715u c0715u) {
        m10302a(c0709p, c0715u, true);
    }

    /* renamed from: a */
    private void m10302a(C0709p c0709p, C0715u c0715u, boolean z) {
        C0727a c0727a = this.f8697t;
        if (!(this.f8694q == null && this.f8683f == -1) && c0715u.m2402e() == 0) {
            removeAndRecycleAllViews(c0709p);
            c0727a.m2426a();
            return;
        }
        Object obj;
        int i;
        boolean z2 = true;
        if (c0727a.f1879e && this.f8683f == -1) {
            if (this.f8694q == null) {
                obj = null;
                if (obj != null) {
                    c0727a.m2426a();
                    if (this.f8694q == null) {
                        m10304a(c0727a);
                    } else {
                        m10328k();
                        c0727a.f1877c = this.f8682e;
                    }
                    m10338a(c0715u, c0727a);
                    c0727a.f1879e = true;
                }
                if (this.f8694q == null && this.f8683f == -1 && !(c0727a.f1877c == this.f8692o && m10348d() == this.f8693p)) {
                    this.f8685h.m2438a();
                    c0727a.f1878d = true;
                }
                if (getChildCount() > 0 && (this.f8694q == null || this.f8694q.f1890c < 1)) {
                    if (c0727a.f1878d) {
                        if (obj == null) {
                            if (this.f8697t.f1880f == null) {
                                for (i = 0; i < this.f8686i; i++) {
                                    C0733e c0733e = this.f8678a[i];
                                    c0733e.m2467e();
                                    c0733e.m2464c(this.f8697t.f1880f[i]);
                                }
                            }
                        }
                        for (i = 0; i < this.f8686i; i++) {
                            this.f8678a[i].m2458a(this.f8682e, c0727a.f1876b);
                        }
                        this.f8697t.m2428a(this.f8678a);
                    } else {
                        for (i = 0; i < this.f8686i; i++) {
                            this.f8678a[i].m2467e();
                            if (c0727a.f1876b != LinearLayoutManager.INVALID_OFFSET) {
                                this.f8678a[i].m2464c(c0727a.f1876b);
                            }
                        }
                    }
                }
                detachAndScrapAttachedViews(c0709p);
                this.f8689l.f2018a = false;
                this.f8698u = false;
                m10347c(this.f8680c.mo656f());
                m10313b(c0727a.f1875a, c0715u);
                if (c0727a.f1877c) {
                    m10320d(1);
                    m10297a(c0709p, this.f8689l, c0715u);
                    m10320d(-1);
                    this.f8689l.f2020c = c0727a.f1875a + this.f8689l.f2021d;
                    m10297a(c0709p, this.f8689l, c0715u);
                } else {
                    m10320d(-1);
                    m10297a(c0709p, this.f8689l, c0715u);
                    m10320d(1);
                    this.f8689l.f2020c = c0727a.f1875a + this.f8689l.f2021d;
                    m10297a(c0709p, this.f8689l, c0715u);
                }
                m10331l();
                if (getChildCount() > 0) {
                    if (this.f8682e) {
                        m10318c(c0709p, c0715u, true);
                        m10315b(c0709p, c0715u, false);
                    } else {
                        m10315b(c0709p, c0715u, true);
                        m10318c(c0709p, c0715u, false);
                    }
                }
                if (z && !c0715u.m2398a()) {
                    z = this.f8691n && getChildCount() <= false && (this.f8698u || m10341b());
                    if (z) {
                        removeCallbacks(this.f8701x);
                        if (m10340a()) {
                            if (c0715u.m2398a()) {
                                this.f8697t.m2426a();
                            }
                            this.f8692o = c0727a.f1877c;
                            this.f8693p = m10348d();
                            if (z2) {
                                this.f8697t.m2426a();
                                m10302a(c0709p, c0715u, false);
                            }
                        }
                    }
                }
                z2 = false;
                if (c0715u.m2398a()) {
                    this.f8697t.m2426a();
                }
                this.f8692o = c0727a.f1877c;
                this.f8693p = m10348d();
                if (z2) {
                    this.f8697t.m2426a();
                    m10302a(c0709p, c0715u, false);
                }
            }
        }
        obj = 1;
        if (obj != null) {
            c0727a.m2426a();
            if (this.f8694q == null) {
                m10328k();
                c0727a.f1877c = this.f8682e;
            } else {
                m10304a(c0727a);
            }
            m10338a(c0715u, c0727a);
            c0727a.f1879e = true;
        }
        this.f8685h.m2438a();
        c0727a.f1878d = true;
        if (c0727a.f1878d) {
            if (obj == null) {
                if (this.f8697t.f1880f == null) {
                    for (i = 0; i < this.f8686i; i++) {
                        C0733e c0733e2 = this.f8678a[i];
                        c0733e2.m2467e();
                        c0733e2.m2464c(this.f8697t.f1880f[i]);
                    }
                }
            }
            for (i = 0; i < this.f8686i; i++) {
                this.f8678a[i].m2458a(this.f8682e, c0727a.f1876b);
            }
            this.f8697t.m2428a(this.f8678a);
        } else {
            for (i = 0; i < this.f8686i; i++) {
                this.f8678a[i].m2467e();
                if (c0727a.f1876b != LinearLayoutManager.INVALID_OFFSET) {
                    this.f8678a[i].m2464c(c0727a.f1876b);
                }
            }
        }
        detachAndScrapAttachedViews(c0709p);
        this.f8689l.f2018a = false;
        this.f8698u = false;
        m10347c(this.f8680c.mo656f());
        m10313b(c0727a.f1875a, c0715u);
        if (c0727a.f1877c) {
            m10320d(1);
            m10297a(c0709p, this.f8689l, c0715u);
            m10320d(-1);
            this.f8689l.f2020c = c0727a.f1875a + this.f8689l.f2021d;
            m10297a(c0709p, this.f8689l, c0715u);
        } else {
            m10320d(-1);
            m10297a(c0709p, this.f8689l, c0715u);
            m10320d(1);
            this.f8689l.f2020c = c0727a.f1875a + this.f8689l.f2021d;
            m10297a(c0709p, this.f8689l, c0715u);
        }
        m10331l();
        if (getChildCount() > 0) {
            if (this.f8682e) {
                m10318c(c0709p, c0715u, true);
                m10315b(c0709p, c0715u, false);
            } else {
                m10315b(c0709p, c0715u, true);
                m10318c(c0709p, c0715u, false);
            }
        }
        if (!this.f8691n) {
        }
        if (z) {
            removeCallbacks(this.f8701x);
            if (m10340a()) {
                if (c0715u.m2398a()) {
                    this.f8697t.m2426a();
                }
                this.f8692o = c0727a.f1877c;
                this.f8693p = m10348d();
                if (z2) {
                    this.f8697t.m2426a();
                    m10302a(c0709p, c0715u, false);
                }
            }
        }
        z2 = false;
        if (c0715u.m2398a()) {
            this.f8697t.m2426a();
        }
        this.f8692o = c0727a.f1877c;
        this.f8693p = m10348d();
        if (z2) {
            this.f8697t.m2426a();
            m10302a(c0709p, c0715u, false);
        }
    }

    public void onLayoutCompleted(C0715u c0715u) {
        super.onLayoutCompleted(c0715u);
        this.f8683f = -1;
        this.f8684g = LinearLayoutManager.INVALID_OFFSET;
        this.f8694q = null;
        this.f8697t.m2426a();
    }

    /* renamed from: l */
    private void m10331l() {
        if (this.f8680c.mo659h() != 1073741824) {
            int i;
            int childCount = getChildCount();
            float f = 0.0f;
            for (i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                float e = (float) this.f8680c.mo655e(childAt);
                if (e >= f) {
                    if (((C3297b) childAt.getLayoutParams()).m10294a()) {
                        e = (e * 1.0f) / ((float) this.f8686i);
                    }
                    f = Math.max(f, e);
                }
            }
            i = this.f8688k;
            int round = Math.round(f * ((float) this.f8686i));
            if (this.f8680c.mo659h() == LinearLayoutManager.INVALID_OFFSET) {
                round = Math.min(round, this.f8680c.mo656f());
            }
            m10347c(round);
            if (this.f8688k != i) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = getChildAt(i2);
                    C3297b c3297b = (C3297b) childAt2.getLayoutParams();
                    if (!c3297b.f8677b) {
                        if (m10348d() && this.f8687j == 1) {
                            childAt2.offsetLeftAndRight(((-((this.f8686i - 1) - c3297b.f8676a.f1902e)) * this.f8688k) - ((-((this.f8686i - 1) - c3297b.f8676a.f1902e)) * i));
                        } else {
                            int i3 = c3297b.f8676a.f1902e * this.f8688k;
                            int i4 = c3297b.f8676a.f1902e * i;
                            if (this.f8687j == 1) {
                                childAt2.offsetLeftAndRight(i3 - i4);
                            } else {
                                childAt2.offsetTopAndBottom(i3 - i4);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m10304a(C0727a c0727a) {
        if (this.f8694q.f1890c > 0) {
            if (this.f8694q.f1890c == this.f8686i) {
                for (int i = 0; i < this.f8686i; i++) {
                    this.f8678a[i].m2467e();
                    int i2 = this.f8694q.f1891d[i];
                    if (i2 != LinearLayoutManager.INVALID_OFFSET) {
                        if (this.f8694q.f1896i) {
                            i2 += this.f8679b.mo652d();
                        } else {
                            i2 += this.f8679b.mo650c();
                        }
                    }
                    this.f8678a[i].m2464c(i2);
                }
            } else {
                this.f8694q.m2450a();
                this.f8694q.f1888a = this.f8694q.f1889b;
            }
        }
        this.f8693p = this.f8694q.f1897j;
        m10339a(this.f8694q.f1895h);
        m10328k();
        if (this.f8694q.f1888a != -1) {
            this.f8683f = this.f8694q.f1888a;
            c0727a.f1877c = this.f8694q.f1896i;
        } else {
            c0727a.f1877c = this.f8682e;
        }
        if (this.f8694q.f1892e > 1) {
            this.f8685h.f1886a = this.f8694q.f1893f;
            this.f8685h.f1887b = this.f8694q.f1894g;
        }
    }

    /* renamed from: a */
    void m10338a(C0715u c0715u, C0727a c0727a) {
        if (!m10344b(c0715u, c0727a) && m10319c(c0715u, c0727a) == null) {
            c0727a.m2429b();
            c0727a.f1875a = null;
        }
    }

    /* renamed from: c */
    private boolean m10319c(C0715u c0715u, C0727a c0727a) {
        if (this.f8692o) {
            c0715u = m10333n(c0715u.m2402e());
        } else {
            c0715u = m10332m(c0715u.m2402e());
        }
        c0727a.f1875a = c0715u;
        c0727a.f1876b = LinearLayoutManager.INVALID_OFFSET;
        return true;
    }

    /* renamed from: b */
    boolean m10344b(C0715u c0715u, C0727a c0727a) {
        boolean z = false;
        if (!c0715u.m2398a()) {
            if (this.f8683f != -1) {
                if (this.f8683f >= 0) {
                    if (this.f8683f < c0715u.m2402e()) {
                        if (!(this.f8694q == null || this.f8694q.f1888a == -1)) {
                            if (this.f8694q.f1890c >= 1) {
                                c0727a.f1876b = LinearLayoutManager.INVALID_OFFSET;
                                c0727a.f1875a = this.f8683f;
                                return true;
                            }
                        }
                        View findViewByPosition = findViewByPosition(this.f8683f);
                        if (findViewByPosition != null) {
                            int h;
                            if (this.f8682e) {
                                h = m10352h();
                            } else {
                                h = m10353i();
                            }
                            c0727a.f1875a = h;
                            if (this.f8684g != LinearLayoutManager.INVALID_OFFSET) {
                                if (c0727a.f1877c) {
                                    c0727a.f1876b = (this.f8679b.mo652d() - this.f8684g) - this.f8679b.mo649b(findViewByPosition);
                                } else {
                                    c0727a.f1876b = (this.f8679b.mo650c() + this.f8684g) - this.f8679b.mo647a(findViewByPosition);
                                }
                                return true;
                            } else if (this.f8679b.mo655e(findViewByPosition) > this.f8679b.mo656f()) {
                                if (c0727a.f1877c != null) {
                                    c0715u = this.f8679b.mo652d();
                                } else {
                                    c0715u = this.f8679b.mo650c();
                                }
                                c0727a.f1876b = c0715u;
                                return true;
                            } else {
                                h = this.f8679b.mo647a(findViewByPosition) - this.f8679b.mo650c();
                                if (h < 0) {
                                    c0727a.f1876b = -h;
                                    return true;
                                }
                                h = this.f8679b.mo652d() - this.f8679b.mo649b(findViewByPosition);
                                if (h < 0) {
                                    c0727a.f1876b = h;
                                    return true;
                                }
                                c0727a.f1876b = LinearLayoutManager.INVALID_OFFSET;
                            }
                        } else {
                            c0727a.f1875a = this.f8683f;
                            if (this.f8684g == -2147483648) {
                                if (m10330l(c0727a.f1875a) == 1) {
                                    z = true;
                                }
                                c0727a.f1877c = z;
                                c0727a.m2429b();
                            } else {
                                c0727a.m2427a(this.f8684g);
                            }
                            c0727a.f1878d = true;
                        }
                        return true;
                    }
                }
                this.f8683f = -1;
                this.f8684g = LinearLayoutManager.INVALID_OFFSET;
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    void m10347c(int i) {
        this.f8688k = i / this.f8686i;
        this.f8695r = MeasureSpec.makeMeasureSpec(i, this.f8680c.mo659h());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f8694q == null;
    }

    public int computeHorizontalScrollOffset(C0715u c0715u) {
        return m10298a(c0715u);
    }

    /* renamed from: a */
    private int m10298a(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        return bf.m2744a(c0715u, this.f8679b, m10342b(this.f8699v ^ 1), m10345c(this.f8699v ^ 1), this, this.f8699v, this.f8682e);
    }

    public int computeVerticalScrollOffset(C0715u c0715u) {
        return m10298a(c0715u);
    }

    public int computeHorizontalScrollExtent(C0715u c0715u) {
        return m10311b(c0715u);
    }

    /* renamed from: b */
    private int m10311b(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        return bf.m2743a(c0715u, this.f8679b, m10342b(this.f8699v ^ 1), m10345c(this.f8699v ^ 1), this, this.f8699v);
    }

    public int computeVerticalScrollExtent(C0715u c0715u) {
        return m10311b(c0715u);
    }

    public int computeHorizontalScrollRange(C0715u c0715u) {
        return m10317c(c0715u);
    }

    /* renamed from: c */
    private int m10317c(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        return bf.m2745b(c0715u, this.f8679b, m10342b(this.f8699v ^ 1), m10345c(this.f8699v ^ 1), this, this.f8699v);
    }

    public int computeVerticalScrollRange(C0715u c0715u) {
        return m10317c(c0715u);
    }

    /* renamed from: a */
    private void m10309a(View view, C3297b c3297b, boolean z) {
        if (c3297b.f8677b) {
            if (this.f8687j == 1) {
                m10307a(view, this.f8695r, C0701i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), c3297b.height, true), z);
            } else {
                m10307a(view, C0701i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), c3297b.width, true), this.f8695r, z);
            }
        } else if (this.f8687j == 1) {
            m10307a(view, C0701i.getChildMeasureSpec(this.f8688k, getWidthMode(), 0, c3297b.width, false), C0701i.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), c3297b.height, true), z);
        } else {
            m10307a(view, C0701i.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), c3297b.width, true), C0701i.getChildMeasureSpec(this.f8688k, getHeightMode(), 0, c3297b.height, false), z);
        }
    }

    /* renamed from: a */
    private void m10307a(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.f8696s);
        C3297b c3297b = (C3297b) view.getLayoutParams();
        i = m10296a(i, c3297b.leftMargin + this.f8696s.left, c3297b.rightMargin + this.f8696s.right);
        i2 = m10296a(i2, c3297b.topMargin + this.f8696s.top, c3297b.bottomMargin + this.f8696s.bottom);
        if (z) {
            z = shouldReMeasureChild(view, i, i2, c3297b);
        } else {
            z = shouldMeasureChild(view, i, i2, c3297b);
        }
        if (z) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private int m10296a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode != LinearLayoutManager.INVALID_OFFSET) {
            if (mode != 1073741824) {
                return i;
            }
        }
        return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0732d) {
            this.f8694q = (C0732d) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f8694q != null) {
            return new C0732d(this.f8694q);
        }
        Parcelable c0732d = new C0732d();
        c0732d.f1895h = this.f8681d;
        c0732d.f1896i = this.f8692o;
        c0732d.f1897j = this.f8693p;
        int i = 0;
        if (this.f8685h == null || this.f8685h.f1886a == null) {
            c0732d.f1892e = 0;
        } else {
            c0732d.f1893f = this.f8685h.f1886a;
            c0732d.f1892e = c0732d.f1893f.length;
            c0732d.f1894g = this.f8685h.f1887b;
        }
        if (getChildCount() > 0) {
            int h;
            if (this.f8692o) {
                h = m10352h();
            } else {
                h = m10353i();
            }
            c0732d.f1888a = h;
            c0732d.f1889b = m10349e();
            c0732d.f1890c = this.f8686i;
            c0732d.f1891d = new int[this.f8686i];
            while (i < this.f8686i) {
                if (this.f8692o) {
                    h = this.f8678a[i].m2460b((int) LinearLayoutManager.INVALID_OFFSET);
                    if (h != LinearLayoutManager.INVALID_OFFSET) {
                        h -= this.f8679b.mo652d();
                    }
                } else {
                    h = this.f8678a[i].m2452a((int) LinearLayoutManager.INVALID_OFFSET);
                    if (h != LinearLayoutManager.INVALID_OFFSET) {
                        h -= this.f8679b.mo650c();
                    }
                }
                c0732d.f1891d[i] = h;
                i++;
            }
        } else {
            c0732d.f1888a = -1;
            c0732d.f1889b = -1;
            c0732d.f1890c = 0;
        }
        return c0732d;
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0709p c0709p, C0715u c0715u, View view, C0483b c0483b) {
        c0709p = view.getLayoutParams();
        if ((c0709p instanceof C3297b) == null) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c0483b);
            return;
        }
        C3297b c3297b = (C3297b) c0709p;
        if (this.f8687j == null) {
            c0483b.m1513b(C0482c.m1497a(c3297b.m10295b(), c3297b.f8677b != null ? this.f8686i : 1, -1, -1, c3297b.f8677b, false));
        } else {
            c0483b.m1513b(C0482c.m1497a(-1, -1, c3297b.m10295b(), c3297b.f8677b != null ? this.f8686i : 1, c3297b.f8677b, false));
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b = m10342b(false);
            View c = m10345c(false);
            if (b != null) {
                if (c != null) {
                    int position = getPosition(b);
                    int position2 = getPosition(c);
                    if (position < position2) {
                        accessibilityEvent.setFromIndex(position);
                        accessibilityEvent.setToIndex(position2);
                    } else {
                        accessibilityEvent.setFromIndex(position2);
                        accessibilityEvent.setToIndex(position);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    int m10349e() {
        View c;
        if (this.f8682e) {
            c = m10345c(true);
        } else {
            c = m10342b(true);
        }
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    public int getRowCountForAccessibility(C0709p c0709p, C0715u c0715u) {
        if (this.f8687j == 0) {
            return this.f8686i;
        }
        return super.getRowCountForAccessibility(c0709p, c0715u);
    }

    public int getColumnCountForAccessibility(C0709p c0709p, C0715u c0715u) {
        if (this.f8687j == 1) {
            return this.f8686i;
        }
        return super.getColumnCountForAccessibility(c0709p, c0715u);
    }

    /* renamed from: b */
    View m10342b(boolean z) {
        int c = this.f8679b.mo650c();
        int d = this.f8679b.mo652d();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int a = this.f8679b.mo647a(childAt);
            if (this.f8679b.mo649b(childAt) > c) {
                if (a < d) {
                    if (a < c) {
                        if (z) {
                            if (view == null) {
                                view = childAt;
                            }
                        }
                    }
                    return childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: c */
    View m10345c(boolean z) {
        int c = this.f8679b.mo650c();
        int d = this.f8679b.mo652d();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a = this.f8679b.mo647a(childAt);
            int b = this.f8679b.mo649b(childAt);
            if (b > c) {
                if (a < d) {
                    if (b > d) {
                        if (z) {
                            if (view == null) {
                                view = childAt;
                            }
                        }
                    }
                    return childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    private void m10315b(C0709p c0709p, C0715u c0715u, boolean z) {
        int i = m10325i(LinearLayoutManager.INVALID_OFFSET);
        if (i != LinearLayoutManager.INVALID_OFFSET) {
            int d = this.f8679b.mo652d() - i;
            if (d > 0) {
                d -= -m10335a(-d, c0709p, c0715u);
                if (z && d > 0) {
                    this.f8679b.mo648a(d);
                }
            }
        }
    }

    /* renamed from: c */
    private void m10318c(C0709p c0709p, C0715u c0715u, boolean z) {
        int h = m10324h(Integer.MAX_VALUE);
        if (h != Integer.MAX_VALUE) {
            h -= this.f8679b.mo650c();
            if (h > 0) {
                h -= m10335a(h, c0709p, c0715u);
                if (z && h > 0) {
                    this.f8679b.mo648a(-h);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10313b(int i, C0715u c0715u) {
        boolean z = false;
        this.f8689l.f2019b = 0;
        this.f8689l.f2020c = i;
        if (isSmoothScrolling()) {
            c0715u = c0715u.m2400c();
            if (c0715u != -1) {
                if (this.f8682e == (c0715u < i)) {
                    c0715u = this.f8679b.mo656f();
                    i = 0;
                    if (getClipToPadding()) {
                        this.f8689l.f2023f = this.f8679b.mo650c() - i;
                        this.f8689l.f2024g = this.f8679b.mo652d() + c0715u;
                    } else {
                        this.f8689l.f2024g = this.f8679b.mo654e() + c0715u;
                        this.f8689l.f2023f = -i;
                    }
                    this.f8689l.f2025h = false;
                    this.f8689l.f2018a = true;
                    i = this.f8689l;
                    if (this.f8679b.mo659h() == null && this.f8679b.mo654e() == null) {
                        z = true;
                    }
                    i.f2026i = z;
                }
                i = this.f8679b.mo656f();
                c0715u = null;
                if (getClipToPadding()) {
                    this.f8689l.f2024g = this.f8679b.mo654e() + c0715u;
                    this.f8689l.f2023f = -i;
                } else {
                    this.f8689l.f2023f = this.f8679b.mo650c() - i;
                    this.f8689l.f2024g = this.f8679b.mo652d() + c0715u;
                }
                this.f8689l.f2025h = false;
                this.f8689l.f2018a = true;
                i = this.f8689l;
                z = true;
                i.f2026i = z;
            }
        }
        i = 0;
        c0715u = null;
        if (getClipToPadding()) {
            this.f8689l.f2023f = this.f8679b.mo650c() - i;
            this.f8689l.f2024g = this.f8679b.mo652d() + c0715u;
        } else {
            this.f8689l.f2024g = this.f8679b.mo654e() + c0715u;
            this.f8689l.f2023f = -i;
        }
        this.f8689l.f2025h = false;
        this.f8689l.f2018a = true;
        i = this.f8689l;
        z = true;
        i.f2026i = z;
    }

    /* renamed from: d */
    private void m10320d(int i) {
        this.f8689l.f2022e = i;
        ar arVar = this.f8689l;
        int i2 = 1;
        if (this.f8682e != (i == -1)) {
            i2 = -1;
        }
        arVar.f2021d = i2;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f8686i; i2++) {
            this.f8678a[i2].m2466d(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f8686i; i2++) {
            this.f8678a[i2].m2466d(i);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m10312b(i, i2, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m10312b(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f8685h.m2438a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m10312b(i, i2, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m10312b(i, i2, 4);
    }

    /* renamed from: b */
    private void m10312b(int i, int i2, int i3) {
        int i4;
        int i5;
        int h = this.f8682e ? m10352h() : m10353i();
        if (i3 != 8) {
            i4 = i + i2;
        } else if (i < i2) {
            i4 = i2 + 1;
        } else {
            i5 = i + 1;
            i4 = i2;
            this.f8685h.m2442b(i4);
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        this.f8685h.m2443b(i, i2);
                        break;
                    case 2:
                        this.f8685h.m2439a(i, i2);
                        break;
                    default:
                        break;
                }
            }
            this.f8685h.m2439a(i, 1);
            this.f8685h.m2443b(i2, 1);
            if (i5 <= h) {
                if (i4 <= (this.f8682e == 0 ? m10353i() : m10352h())) {
                    requestLayout();
                }
            }
        }
        i5 = i4;
        i4 = i;
        this.f8685h.m2442b(i4);
        if (i3 != 8) {
            switch (i3) {
                case 1:
                    this.f8685h.m2443b(i, i2);
                    break;
                case 2:
                    this.f8685h.m2439a(i, i2);
                    break;
                default:
                    break;
            }
        }
        this.f8685h.m2439a(i, 1);
        this.f8685h.m2443b(i2, 1);
        if (i5 <= h) {
            if (this.f8682e == 0) {
            }
            if (i4 <= (this.f8682e == 0 ? m10353i() : m10352h())) {
                requestLayout();
            }
        }
    }

    /* renamed from: a */
    private int m10297a(C0709p c0709p, ar arVar, C0715u c0715u) {
        int i;
        int i2;
        C0709p c0709p2 = c0709p;
        ar arVar2 = arVar;
        boolean z = false;
        this.f8690m.set(0, this.f8686i, true);
        if (this.f8689l.f2026i) {
            i = arVar2.f2022e == 1 ? Integer.MAX_VALUE : LinearLayoutManager.INVALID_OFFSET;
        } else {
            if (arVar2.f2022e == 1) {
                i2 = arVar2.f2024g + arVar2.f2019b;
            } else {
                i2 = arVar2.f2023f - arVar2.f2019b;
            }
            i = i2;
        }
        m10300a(arVar2.f2022e, i);
        if (r6.f8682e) {
            i2 = r6.f8679b.mo652d();
        } else {
            i2 = r6.f8679b.mo650c();
        }
        int i3 = i2;
        Object obj = null;
        while (arVar.m2655a(c0715u) && (r6.f8689l.f2026i || !r6.f8690m.isEmpty())) {
            C0733e a;
            int e;
            int i4;
            int i5;
            int e2;
            View a2 = arVar2.m2654a(c0709p2);
            C3297b c3297b = (C3297b) a2.getLayoutParams();
            i2 = c3297b.m2328f();
            int c = r6.f8685h.m2444c(i2);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                a = c3297b.f8677b ? r6.f8678a[z] : m10299a(arVar2);
                r6.f8685h.m2440a(i2, a);
            } else {
                a = r6.f8678a[c];
            }
            C0733e c0733e = a;
            c3297b.f8676a = c0733e;
            if (arVar2.f2022e == 1) {
                addView(a2);
            } else {
                addView(a2, z);
            }
            m10309a(a2, c3297b, z);
            C0729a e3;
            if (arVar2.f2022e == 1) {
                if (c3297b.f8677b) {
                    c = m10325i(i3);
                } else {
                    c = c0733e.m2460b(i3);
                }
                e = r6.f8679b.mo655e(a2) + c;
                if (obj2 != null && c3297b.f8677b) {
                    e3 = m10321e(c);
                    e3.f1883b = -1;
                    e3.f1882a = i2;
                    r6.f8685h.m2441a(e3);
                }
                i4 = e;
                e = c;
            } else {
                if (c3297b.f8677b) {
                    c = m10324h(i3);
                } else {
                    c = c0733e.m2452a(i3);
                }
                e = c - r6.f8679b.mo655e(a2);
                if (obj2 != null && c3297b.f8677b) {
                    e3 = m10322f(c);
                    e3.f1883b = 1;
                    e3.f1882a = i2;
                    r6.f8685h.m2441a(e3);
                }
                i4 = c;
            }
            if (c3297b.f8677b && arVar2.f2021d == -1) {
                if (obj2 != null) {
                    r6.f8698u = true;
                } else {
                    if (arVar2.f2022e == 1) {
                        c = m10350f();
                    } else {
                        c = m10351g();
                    }
                    if ((c ^ 1) != 0) {
                        C0729a f = r6.f8685h.m2447f(i2);
                        if (f != null) {
                            f.f1885d = true;
                        }
                        r6.f8698u = true;
                    }
                }
            }
            m10308a(a2, c3297b, arVar2);
            if (m10348d() && r6.f8687j == 1) {
                if (c3297b.f8677b) {
                    i2 = r6.f8680c.mo652d();
                } else {
                    i2 = r6.f8680c.mo652d() - (((r6.f8686i - 1) - c0733e.f1902e) * r6.f8688k);
                }
                i5 = i2;
                e2 = i2 - r6.f8680c.mo655e(a2);
            } else {
                if (c3297b.f8677b) {
                    i2 = r6.f8680c.mo650c();
                } else {
                    i2 = (c0733e.f1902e * r6.f8688k) + r6.f8680c.mo650c();
                }
                e2 = i2;
                i5 = r6.f8680c.mo655e(a2) + i2;
            }
            if (r6.f8687j == 1) {
                layoutDecoratedWithMargins(a2, e2, e, i5, i4);
            } else {
                layoutDecoratedWithMargins(a2, e, e2, i4, i5);
            }
            if (c3297b.f8677b) {
                m10300a(r6.f8689l.f2022e, i);
            } else {
                m10305a(c0733e, r6.f8689l.f2022e, i);
            }
            m10303a(c0709p2, r6.f8689l);
            if (r6.f8689l.f2025h && a2.hasFocusable()) {
                if (c3297b.f8677b) {
                    r6.f8690m.clear();
                } else {
                    r6.f8690m.set(c0733e.f1902e, false);
                    obj = 1;
                    z = false;
                }
            }
            obj = 1;
            z = false;
        }
        if (obj == null) {
            m10303a(c0709p2, r6.f8689l);
        }
        if (r6.f8689l.f2022e == -1) {
            c = r6.f8679b.mo650c() - m10324h(r6.f8679b.mo650c());
        } else {
            c = m10325i(r6.f8679b.mo652d()) - r6.f8679b.mo652d();
        }
        if (c > 0) {
            return Math.min(arVar2.f2019b, c);
        }
        return 0;
    }

    /* renamed from: e */
    private C0729a m10321e(int i) {
        C0729a c0729a = new C0729a();
        c0729a.f1884c = new int[this.f8686i];
        for (int i2 = 0; i2 < this.f8686i; i2++) {
            c0729a.f1884c[i2] = i - this.f8678a[i2].m2460b(i);
        }
        return c0729a;
    }

    /* renamed from: f */
    private C0729a m10322f(int i) {
        C0729a c0729a = new C0729a();
        c0729a.f1884c = new int[this.f8686i];
        for (int i2 = 0; i2 < this.f8686i; i2++) {
            c0729a.f1884c[i2] = this.f8678a[i2].m2452a(i) - i;
        }
        return c0729a;
    }

    /* renamed from: a */
    private void m10308a(View view, C3297b c3297b, ar arVar) {
        if (arVar.f2022e == 1) {
            if (c3297b.f8677b != null) {
                m10306a(view);
            } else {
                c3297b.f8676a.m2461b(view);
            }
        } else if (c3297b.f8677b != null) {
            m10316b(view);
        } else {
            c3297b.f8676a.m2457a(view);
        }
    }

    /* renamed from: a */
    private void m10303a(C0709p c0709p, ar arVar) {
        if (arVar.f2018a) {
            if (!arVar.f2026i) {
                if (arVar.f2019b == 0) {
                    if (arVar.f2022e == -1) {
                        m10314b(c0709p, arVar.f2024g);
                    } else {
                        m10301a(c0709p, arVar.f2023f);
                    }
                } else if (arVar.f2022e == -1) {
                    r0 = arVar.f2023f - m10323g(arVar.f2023f);
                    if (r0 < 0) {
                        r4 = arVar.f2024g;
                    } else {
                        r4 = arVar.f2024g - Math.min(r0, arVar.f2019b);
                    }
                    m10314b(c0709p, r4);
                } else {
                    r0 = m10326j(arVar.f2024g) - arVar.f2024g;
                    if (r0 < 0) {
                        r4 = arVar.f2023f;
                    } else {
                        r4 = Math.min(r0, arVar.f2019b) + arVar.f2023f;
                    }
                    m10301a(c0709p, r4);
                }
            }
        }
    }

    /* renamed from: a */
    private void m10306a(View view) {
        for (int i = this.f8686i - 1; i >= 0; i--) {
            this.f8678a[i].m2461b(view);
        }
    }

    /* renamed from: b */
    private void m10316b(View view) {
        for (int i = this.f8686i - 1; i >= 0; i--) {
            this.f8678a[i].m2457a(view);
        }
    }

    /* renamed from: a */
    private void m10300a(int i, int i2) {
        for (int i3 = 0; i3 < this.f8686i; i3++) {
            if (!this.f8678a[i3].f1898a.isEmpty()) {
                m10305a(this.f8678a[i3], i, i2);
            }
        }
    }

    /* renamed from: a */
    private void m10305a(C0733e c0733e, int i, int i2) {
        int i3 = c0733e.m2471i();
        if (i == -1) {
            if (c0733e.m2459b() + i3 <= i2) {
                this.f8690m.set(c0733e.f1902e, false);
            }
        } else if (c0733e.m2465d() - i3 >= i2) {
            this.f8690m.set(c0733e.f1902e, false);
        }
    }

    /* renamed from: g */
    private int m10323g(int i) {
        int a = this.f8678a[0].m2452a(i);
        for (int i2 = 1; i2 < this.f8686i; i2++) {
            int a2 = this.f8678a[i2].m2452a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: h */
    private int m10324h(int i) {
        int a = this.f8678a[0].m2452a(i);
        for (int i2 = 1; i2 < this.f8686i; i2++) {
            int a2 = this.f8678a[i2].m2452a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: f */
    boolean m10350f() {
        int b = this.f8678a[0].m2460b((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f8686i; i++) {
            if (this.f8678a[i].m2460b((int) LinearLayoutManager.INVALID_OFFSET) != b) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    boolean m10351g() {
        int a = this.f8678a[0].m2452a((int) LinearLayoutManager.INVALID_OFFSET);
        for (int i = 1; i < this.f8686i; i++) {
            if (this.f8678a[i].m2452a((int) LinearLayoutManager.INVALID_OFFSET) != a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    private int m10325i(int i) {
        int b = this.f8678a[0].m2460b(i);
        for (int i2 = 1; i2 < this.f8686i; i2++) {
            int b2 = this.f8678a[i2].m2460b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: j */
    private int m10326j(int i) {
        int b = this.f8678a[0].m2460b(i);
        for (int i2 = 1; i2 < this.f8686i; i2++) {
            int b2 = this.f8678a[i2].m2460b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: a */
    private void m10301a(C0709p c0709p, int i) {
        while (getChildCount() > 0) {
            int i2 = 0;
            View childAt = getChildAt(0);
            if (this.f8679b.mo649b(childAt) <= i && this.f8679b.mo651c(childAt) <= i) {
                C3297b c3297b = (C3297b) childAt.getLayoutParams();
                if (c3297b.f8677b) {
                    int i3 = 0;
                    while (i3 < this.f8686i) {
                        if (this.f8678a[i3].f1898a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    while (i2 < this.f8686i) {
                        this.f8678a[i2].m2470h();
                        i2++;
                    }
                } else if (c3297b.f8676a.f1898a.size() != 1) {
                    c3297b.f8676a.m2470h();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, c0709p);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m10314b(C0709p c0709p, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f8679b.mo647a(childAt) >= i && this.f8679b.mo653d(childAt) >= i) {
                C3297b c3297b = (C3297b) childAt.getLayoutParams();
                if (c3297b.f8677b) {
                    int i2 = 0;
                    while (i2 < this.f8686i) {
                        if (this.f8678a[i2].f1898a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f8686i; i3++) {
                        this.f8678a[i3].m2469g();
                    }
                } else if (c3297b.f8676a.f1898a.size() != 1) {
                    c3297b.f8676a.m2469g();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, c0709p);
                childCount--;
            } else {
                return;
            }
        }
    }

    /* renamed from: k */
    private boolean m10329k(int i) {
        boolean z = false;
        if (this.f8687j == 0) {
            if ((i == -1) != this.f8682e) {
                z = true;
            }
            return z;
        }
        if (((i == -1) == this.f8682e) == m10348d()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private C0733e m10299a(ar arVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m10329k(arVar.f2022e)) {
            i = this.f8686i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f8686i;
            i2 = 1;
        }
        C0733e c0733e = null;
        int c;
        C0733e c0733e2;
        int b;
        if (arVar.f2022e == 1) {
            arVar = Integer.MAX_VALUE;
            c = this.f8679b.mo650c();
            while (i != i3) {
                c0733e2 = this.f8678a[i];
                b = c0733e2.m2460b(c);
                if (b < arVar) {
                    c0733e = c0733e2;
                    arVar = b;
                }
                i += i2;
            }
            return c0733e;
        }
        arVar = LinearLayoutManager.INVALID_OFFSET;
        c = this.f8679b.mo652d();
        while (i != i3) {
            c0733e2 = this.f8678a[i];
            b = c0733e2.m2452a(c);
            if (b > arVar) {
                c0733e = c0733e2;
                arVar = b;
            }
            i += i2;
        }
        return c0733e;
    }

    public boolean canScrollVertically() {
        return this.f8687j == 1;
    }

    public boolean canScrollHorizontally() {
        return this.f8687j == 0;
    }

    public int scrollHorizontallyBy(int i, C0709p c0709p, C0715u c0715u) {
        return m10335a(i, c0709p, c0715u);
    }

    public int scrollVerticallyBy(int i, C0709p c0709p, C0715u c0715u) {
        return m10335a(i, c0709p, c0715u);
    }

    /* renamed from: l */
    private int m10330l(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            if (this.f8682e != 0) {
                i2 = 1;
            }
            return i2;
        }
        if ((i < m10353i()) == this.f8682e) {
            i2 = 1;
        }
        return i2;
    }

    public PointF computeScrollVectorForPosition(int i) {
        i = m10330l(i);
        PointF pointF = new PointF();
        if (i == 0) {
            return 0;
        }
        if (this.f8687j == 0) {
            pointF.x = (float) i;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) i;
        }
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0715u c0715u, int i) {
        c0715u = new at(recyclerView.getContext());
        c0715u.setTargetPosition(i);
        startSmoothScroll(c0715u);
    }

    public void scrollToPosition(int i) {
        if (!(this.f8694q == null || this.f8694q.f1888a == i)) {
            this.f8694q.m2451b();
        }
        this.f8683f = i;
        this.f8684g = LinearLayoutManager.INVALID_OFFSET;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, C0715u c0715u, C0699a c0699a) {
        if (this.f8687j != 0) {
            i = i2;
        }
        if (getChildCount() != 0) {
            if (i != 0) {
                m10337a(i, c0715u);
                if (this.f8700w == 0 || this.f8700w.length < this.f8686i) {
                    this.f8700w = new int[this.f8686i];
                }
                i = 0;
                int i3 = 0;
                for (i2 = 0; i2 < this.f8686i; i2++) {
                    int a;
                    if (this.f8689l.f2021d == -1) {
                        a = this.f8689l.f2023f - this.f8678a[i2].m2452a(this.f8689l.f2023f);
                    } else {
                        a = this.f8678a[i2].m2460b(this.f8689l.f2024g) - this.f8689l.f2024g;
                    }
                    if (a >= 0) {
                        this.f8700w[i3] = a;
                        i3++;
                    }
                }
                Arrays.sort(this.f8700w, 0, i3);
                while (i < i3 && this.f8689l.m2655a(c0715u) != 0) {
                    c0699a.mo629b(this.f8689l.f2020c, this.f8700w[i]);
                    i2 = this.f8689l;
                    i2.f2020c += this.f8689l.f2021d;
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    void m10337a(int i, C0715u c0715u) {
        int h;
        int i2;
        if (i > 0) {
            h = m10352h();
            i2 = 1;
        } else {
            h = m10353i();
            i2 = -1;
        }
        this.f8689l.f2018a = true;
        m10313b(h, c0715u);
        m10320d(i2);
        this.f8689l.f2020c = h + this.f8689l.f2021d;
        this.f8689l.f2019b = Math.abs(i);
    }

    /* renamed from: a */
    int m10335a(int i, C0709p c0709p, C0715u c0715u) {
        if (getChildCount() != 0) {
            if (i != 0) {
                m10337a(i, c0715u);
                c0715u = m10297a(c0709p, this.f8689l, c0715u);
                if (this.f8689l.f2019b >= c0715u) {
                    i = i < 0 ? -c0715u : c0715u;
                }
                this.f8679b.mo648a(-i);
                this.f8692o = this.f8682e;
                this.f8689l.f2019b = 0;
                m10303a(c0709p, this.f8689l);
                return i;
            }
        }
        return 0;
    }

    /* renamed from: h */
    int m10352h() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* renamed from: i */
    int m10353i() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: m */
    private int m10332m(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: n */
    private int m10333n(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    public C0702j generateDefaultLayoutParams() {
        if (this.f8687j == 0) {
            return new C3297b(-2, -1);
        }
        return new C3297b(-1, -2);
    }

    public C0702j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C3297b(context, attributeSet);
    }

    public C0702j generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new C3297b((MarginLayoutParams) layoutParams);
        }
        return new C3297b(layoutParams);
    }

    public boolean checkLayoutParams(C0702j c0702j) {
        return c0702j instanceof C3297b;
    }

    public View onFocusSearchFailed(View view, int i, C0709p c0709p, C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        C0715u findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        m10328k();
        i = m10334o(i);
        if (i == LinearLayoutManager.INVALID_OFFSET) {
            return null;
        }
        int h;
        C3297b c3297b = (C3297b) findContainingItemView.getLayoutParams();
        boolean z = c3297b.f8677b;
        C0733e c0733e = c3297b.f8676a;
        if (i == 1) {
            h = m10352h();
        } else {
            h = m10353i();
        }
        m10313b(h, c0715u);
        m10320d(i);
        this.f8689l.f2020c = this.f8689l.f2021d + h;
        this.f8689l.f2019b = (int) (((float) this.f8679b.mo656f()) * 0.33333334f);
        this.f8689l.f2025h = true;
        int i2 = 0;
        this.f8689l.f2018a = false;
        m10297a(c0709p, this.f8689l, c0715u);
        this.f8692o = this.f8682e;
        if (!z) {
            c0709p = c0733e.m2455a(h, i);
            if (!(c0709p == null || c0709p == findContainingItemView)) {
                return c0709p;
            }
        }
        if (m10329k(i) != null) {
            for (c0709p = this.f8686i - 1; c0709p >= null; c0709p--) {
                c0715u = this.f8678a[c0709p].m2455a(h, i);
                if (c0715u != null && c0715u != findContainingItemView) {
                    return c0715u;
                }
            }
        } else {
            for (c0709p = null; c0709p < this.f8686i; c0709p++) {
                c0715u = this.f8678a[c0709p].m2455a(h, i);
                if (c0715u != null && c0715u != findContainingItemView) {
                    return c0715u;
                }
            }
        }
        c0709p = (this.f8681d ^ 1) == (i == -1 ? true : null) ? true : null;
        if (!z) {
            if (c0709p != null) {
                c0715u = c0733e.m2472j();
            } else {
                c0715u = c0733e.m2473k();
            }
            c0715u = findViewByPosition(c0715u);
            if (!(c0715u == null || c0715u == findContainingItemView)) {
                return c0715u;
            }
        }
        if (m10329k(i) != 0) {
            for (i = this.f8686i - 1; i >= 0; i--) {
                if (i != c0733e.f1902e) {
                    if (c0709p != null) {
                        c0715u = this.f8678a[i].m2472j();
                    } else {
                        c0715u = this.f8678a[i].m2473k();
                    }
                    c0715u = findViewByPosition(c0715u);
                    if (!(c0715u == null || c0715u == findContainingItemView)) {
                        return c0715u;
                    }
                }
            }
        } else {
            while (i2 < this.f8686i) {
                if (c0709p != null) {
                    i = this.f8678a[i2].m2472j();
                } else {
                    i = this.f8678a[i2].m2473k();
                }
                i = findViewByPosition(i);
                if (i != 0 && i != findContainingItemView) {
                    return i;
                }
                i2++;
            }
        }
        return null;
    }

    /* renamed from: o */
    private int m10334o(int i) {
        int i2 = -1;
        int i3 = LinearLayoutManager.INVALID_OFFSET;
        if (i == 17) {
            if (this.f8687j != 0) {
                i2 = LinearLayoutManager.INVALID_OFFSET;
            }
            return i2;
        } else if (i == 33) {
            if (this.f8687j != 1) {
                i2 = LinearLayoutManager.INVALID_OFFSET;
            }
            return i2;
        } else if (i == 66) {
            if (this.f8687j == 0) {
                i3 = 1;
            }
            return i3;
        } else if (i != 130) {
            switch (i) {
                case 1:
                    return (this.f8687j == 1 || m10348d() == 0) ? -1 : 1;
                case 2:
                    return (this.f8687j == 1 || m10348d() == 0) ? 1 : -1;
                default:
                    return LinearLayoutManager.INVALID_OFFSET;
            }
        } else {
            if (this.f8687j == 1) {
                i3 = 1;
            }
            return i3;
        }
    }
}
