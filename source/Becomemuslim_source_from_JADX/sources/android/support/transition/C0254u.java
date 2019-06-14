package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.support.v4.util.C0452f;
import android.support.v4.util.C3211a;
import android.support.v4.view.C0517s;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Transition */
/* renamed from: android.support.transition.u */
public abstract class C0254u implements Cloneable {
    /* renamed from: g */
    private static final int[] f613g = new int[]{2, 1, 3, 4};
    /* renamed from: h */
    private static final C0241l f614h = new C31551();
    /* renamed from: z */
    private static ThreadLocal<C3211a<Animator, C0251a>> f615z = new ThreadLocal();
    /* renamed from: A */
    private ViewGroup f616A = null;
    /* renamed from: B */
    private ArrayList<Animator> f617B = new ArrayList();
    /* renamed from: C */
    private int f618C = 0;
    /* renamed from: D */
    private boolean f619D = false;
    /* renamed from: E */
    private boolean f620E = false;
    /* renamed from: F */
    private ArrayList<C0253c> f621F = null;
    /* renamed from: G */
    private ArrayList<Animator> f622G = new ArrayList();
    /* renamed from: H */
    private C0252b f623H;
    /* renamed from: I */
    private C3211a<String, String> f624I;
    /* renamed from: J */
    private C0241l f625J = f614h;
    /* renamed from: a */
    long f626a = -1;
    /* renamed from: b */
    ArrayList<Integer> f627b = new ArrayList();
    /* renamed from: c */
    ArrayList<View> f628c = new ArrayList();
    /* renamed from: d */
    C3157y f629d = null;
    /* renamed from: e */
    boolean f630e = false;
    /* renamed from: f */
    C0257x f631f;
    /* renamed from: i */
    private String f632i = getClass().getName();
    /* renamed from: j */
    private long f633j = -1;
    /* renamed from: k */
    private TimeInterpolator f634k = null;
    /* renamed from: l */
    private ArrayList<String> f635l = null;
    /* renamed from: m */
    private ArrayList<Class> f636m = null;
    /* renamed from: n */
    private ArrayList<Integer> f637n = null;
    /* renamed from: o */
    private ArrayList<View> f638o = null;
    /* renamed from: p */
    private ArrayList<Class> f639p = null;
    /* renamed from: q */
    private ArrayList<String> f640q = null;
    /* renamed from: r */
    private ArrayList<Integer> f641r = null;
    /* renamed from: s */
    private ArrayList<View> f642s = null;
    /* renamed from: t */
    private ArrayList<Class> f643t = null;
    /* renamed from: u */
    private ab f644u = new ab();
    /* renamed from: v */
    private ab f645v = new ab();
    /* renamed from: w */
    private int[] f646w = f613g;
    /* renamed from: x */
    private ArrayList<aa> f647x;
    /* renamed from: y */
    private ArrayList<aa> f648y;

    /* compiled from: Transition */
    /* renamed from: android.support.transition.u$3 */
    class C02503 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C0254u f607a;

        C02503(C0254u c0254u) {
            this.f607a = c0254u;
        }

        public void onAnimationEnd(Animator animator) {
            this.f607a.m672k();
            animator.removeListener(this);
        }
    }

    /* compiled from: Transition */
    /* renamed from: android.support.transition.u$a */
    private static class C0251a {
        /* renamed from: a */
        View f608a;
        /* renamed from: b */
        String f609b;
        /* renamed from: c */
        aa f610c;
        /* renamed from: d */
        aw f611d;
        /* renamed from: e */
        C0254u f612e;

        C0251a(View view, String str, C0254u c0254u, aw awVar, aa aaVar) {
            this.f608a = view;
            this.f609b = str;
            this.f610c = aaVar;
            this.f611d = awVar;
            this.f612e = c0254u;
        }
    }

    /* compiled from: Transition */
    /* renamed from: android.support.transition.u$b */
    public static abstract class C0252b {
    }

    /* compiled from: Transition */
    /* renamed from: android.support.transition.u$c */
    public interface C0253c {
        /* renamed from: a */
        void mo99a(C0254u c0254u);

        /* renamed from: b */
        void mo100b(C0254u c0254u);

        /* renamed from: c */
        void mo101c(C0254u c0254u);

        /* renamed from: d */
        void mo102d(C0254u c0254u);
    }

    /* compiled from: Transition */
    /* renamed from: android.support.transition.u$1 */
    static class C31551 extends C0241l {
        C31551() {
        }

        /* renamed from: a */
        public Path mo144a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* renamed from: a */
    public Animator mo134a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        return null;
    }

    /* renamed from: a */
    public abstract void mo135a(aa aaVar);

    /* renamed from: a */
    public String[] mo137a() {
        return null;
    }

    /* renamed from: b */
    public abstract void mo138b(aa aaVar);

    public /* synthetic */ Object clone() {
        return mo159m();
    }

    /* renamed from: a */
    public C0254u mo145a(long j) {
        this.f626a = j;
        return this;
    }

    /* renamed from: b */
    public long m654b() {
        return this.f626a;
    }

    /* renamed from: b */
    public C0254u mo150b(long j) {
        this.f633j = j;
        return this;
    }

    /* renamed from: c */
    public long m660c() {
        return this.f633j;
    }

    /* renamed from: d */
    public TimeInterpolator m663d() {
        return this.f634k;
    }

    /* renamed from: a */
    private void m631a(C3211a<View, aa> c3211a, C3211a<View, aa> c3211a2) {
        for (int size = c3211a.size() - 1; size >= 0; size--) {
            View view = (View) c3211a.m1462b(size);
            if (view != null && m652a(view)) {
                aa aaVar = (aa) c3211a2.remove(view);
                if (!(aaVar == null || aaVar.f542b == null || !m652a(aaVar.f542b))) {
                    this.f647x.add((aa) c3211a.m1464d(size));
                    this.f648y.add(aaVar);
                }
            }
        }
    }

    /* renamed from: a */
    private void m633a(C3211a<View, aa> c3211a, C3211a<View, aa> c3211a2, C0452f<View> c0452f, C0452f<View> c0452f2) {
        int b = c0452f.m1415b();
        for (int i = 0; i < b; i++) {
            View view = (View) c0452f.m1420c(i);
            if (view != null && m652a(view)) {
                View view2 = (View) c0452f2.m1412a(c0452f.m1416b(i));
                if (view2 != null && m652a(view2)) {
                    aa aaVar = (aa) c3211a.get(view);
                    aa aaVar2 = (aa) c3211a2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.f647x.add(aaVar);
                        this.f648y.add(aaVar2);
                        c3211a.remove(view);
                        c3211a2.remove(view2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m634a(C3211a<View, aa> c3211a, C3211a<View, aa> c3211a2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null && m652a(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && m652a(view2)) {
                    aa aaVar = (aa) c3211a.get(view);
                    aa aaVar2 = (aa) c3211a2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.f647x.add(aaVar);
                        this.f648y.add(aaVar2);
                        c3211a.remove(view);
                        c3211a2.remove(view2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m632a(C3211a<View, aa> c3211a, C3211a<View, aa> c3211a2, C3211a<String, View> c3211a3, C3211a<String, View> c3211a4) {
        int size = c3211a3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c3211a3.m1463c(i);
            if (view != null && m652a(view)) {
                View view2 = (View) c3211a4.get(c3211a3.m1462b(i));
                if (view2 != null && m652a(view2)) {
                    aa aaVar = (aa) c3211a.get(view);
                    aa aaVar2 = (aa) c3211a2.get(view2);
                    if (!(aaVar == null || aaVar2 == null)) {
                        this.f647x.add(aaVar);
                        this.f648y.add(aaVar2);
                        c3211a.remove(view);
                        c3211a2.remove(view2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m636b(C3211a<View, aa> c3211a, C3211a<View, aa> c3211a2) {
        for (int i = 0; i < c3211a.size(); i++) {
            aa aaVar = (aa) c3211a.m1463c(i);
            if (m652a(aaVar.f542b)) {
                this.f647x.add(aaVar);
                this.f648y.add(null);
            }
        }
        for (int i2 = 0; i2 < c3211a2.size(); i2++) {
            aa aaVar2 = (aa) c3211a2.m1463c(i2);
            if (m652a(aaVar2.f542b)) {
                this.f648y.add(aaVar2);
                this.f647x.add(null);
            }
        }
    }

    /* renamed from: a */
    private void m629a(ab abVar, ab abVar2) {
        C3211a c3211a = new C3211a(abVar.f544a);
        C3211a c3211a2 = new C3211a(abVar2.f544a);
        for (int i : this.f646w) {
            switch (i) {
                case 1:
                    m631a(c3211a, c3211a2);
                    break;
                case 2:
                    m632a(c3211a, c3211a2, abVar.f547d, abVar2.f547d);
                    break;
                case 3:
                    m634a(c3211a, c3211a2, abVar.f545b, abVar2.f545b);
                    break;
                case 4:
                    m633a(c3211a, c3211a2, abVar.f546c, abVar2.f546c);
                    break;
                default:
                    break;
            }
        }
        m636b(c3211a, c3211a2);
    }

    /* renamed from: a */
    protected void mo149a(ViewGroup viewGroup, ab abVar, ab abVar2, ArrayList<aa> arrayList, ArrayList<aa> arrayList2) {
        C0254u c0254u = this;
        ViewGroup viewGroup2 = viewGroup;
        C3211a o = C0254u.mo160o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Clock.MAX_TIME;
        int i = 0;
        while (i < size) {
            int i2;
            int i3;
            aa aaVar = (aa) arrayList.get(i);
            aa aaVar2 = (aa) arrayList2.get(i);
            if (!(aaVar == null || aaVar.f543c.contains(c0254u))) {
                aaVar = null;
            }
            if (!(aaVar2 == null || aaVar2.f543c.contains(c0254u))) {
                aaVar2 = null;
            }
            if (!(aaVar == null && aaVar2 == null)) {
                Object obj;
                Animator a;
                View view;
                String[] a2;
                aa aaVar3;
                Animator animator;
                aa aaVar4;
                Object obj2;
                long a3;
                long j2;
                if (!(aaVar == null || aaVar2 == null)) {
                    if (!mo136a(aaVar, aaVar2)) {
                        obj = null;
                        if (obj != null) {
                            a = mo134a(viewGroup2, aaVar, aaVar2);
                            if (a != null) {
                                if (aaVar2 == null) {
                                    view = aaVar2.f542b;
                                    a2 = mo137a();
                                    if (view != null || a2 == null || a2.length <= 0) {
                                        i2 = size;
                                        i3 = i;
                                        a = a;
                                        aaVar3 = null;
                                    } else {
                                        aaVar3 = new aa();
                                        aaVar3.f542b = view;
                                        animator = a;
                                        i2 = size;
                                        aaVar4 = (aa) abVar2.f544a.get(view);
                                        if (aaVar4 != null) {
                                            size = 0;
                                            while (size < a2.length) {
                                                i3 = i;
                                                aa aaVar5 = aaVar4;
                                                aaVar3.f541a.put(a2[size], aaVar4.f541a.get(a2[size]));
                                                size++;
                                                i = i3;
                                                aaVar4 = aaVar5;
                                                ArrayList<aa> arrayList3 = arrayList2;
                                            }
                                        }
                                        i3 = i;
                                        int size2 = o.size();
                                        for (int i4 = 0; i4 < size2; i4++) {
                                            C0251a c0251a = (C0251a) o.get((Animator) o.m1462b(i4));
                                            if (c0251a.f610c != null && c0251a.f608a == view && c0251a.f609b.equals(m675n()) && c0251a.f610c.equals(aaVar3)) {
                                                a = null;
                                                break;
                                            }
                                        }
                                        a = animator;
                                    }
                                    obj2 = a;
                                    aaVar4 = aaVar3;
                                } else {
                                    animator = a;
                                    i2 = size;
                                    i3 = i;
                                    view = aaVar.f542b;
                                    obj2 = animator;
                                    aaVar4 = null;
                                }
                                if (obj2 == null) {
                                    if (c0254u.f631f != null) {
                                        a3 = c0254u.f631f.m682a(viewGroup2, c0254u, aaVar, aaVar2);
                                        sparseIntArray.put(c0254u.f622G.size(), (int) a3);
                                        j = Math.min(a3, j);
                                    }
                                    j2 = j;
                                    o.put(obj2, new C0251a(view, m675n(), this, am.m580b(viewGroup), aaVar4));
                                    c0254u.f622G.add(obj2);
                                    j = j2;
                                }
                                i = i3 + 1;
                                size = i2;
                            }
                        }
                    }
                }
                obj = 1;
                if (obj != null) {
                    a = mo134a(viewGroup2, aaVar, aaVar2);
                    if (a != null) {
                        if (aaVar2 == null) {
                            animator = a;
                            i2 = size;
                            i3 = i;
                            view = aaVar.f542b;
                            obj2 = animator;
                            aaVar4 = null;
                        } else {
                            view = aaVar2.f542b;
                            a2 = mo137a();
                            if (view != null) {
                            }
                            i2 = size;
                            i3 = i;
                            a = a;
                            aaVar3 = null;
                            obj2 = a;
                            aaVar4 = aaVar3;
                        }
                        if (obj2 == null) {
                            if (c0254u.f631f != null) {
                                a3 = c0254u.f631f.m682a(viewGroup2, c0254u, aaVar, aaVar2);
                                sparseIntArray.put(c0254u.f622G.size(), (int) a3);
                                j = Math.min(a3, j);
                            }
                            j2 = j;
                            o.put(obj2, new C0251a(view, m675n(), this, am.m580b(viewGroup), aaVar4));
                            c0254u.f622G.add(obj2);
                            j = j2;
                        }
                        i = i3 + 1;
                        size = i2;
                    }
                }
            }
            i2 = size;
            i3 = i;
            i = i3 + 1;
            size = i2;
        }
        if (j != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator2 = (Animator) c0254u.f622G.get(sparseIntArray.keyAt(i5));
                animator2.setStartDelay((((long) sparseIntArray.valueAt(i5)) - j) + animator2.getStartDelay());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    boolean m652a(android.view.View r6) {
        /*
        r5 = this;
        r0 = r6.getId();
        r1 = r5.f637n;
        r2 = 0;
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r1 = r5.f637n;
        r3 = java.lang.Integer.valueOf(r0);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r5.f638o;
        if (r1 == 0) goto L_0x0023;
    L_0x001a:
        r1 = r5.f638o;
        r1 = r1.contains(r6);
        if (r1 == 0) goto L_0x0023;
    L_0x0022:
        return r2;
    L_0x0023:
        r1 = r5.f639p;
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r5.f639p;
        r1 = r1.size();
        r3 = 0;
    L_0x002e:
        if (r3 >= r1) goto L_0x0042;
    L_0x0030:
        r4 = r5.f639p;
        r4 = r4.get(r3);
        r4 = (java.lang.Class) r4;
        r4 = r4.isInstance(r6);
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        return r2;
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x002e;
    L_0x0042:
        r1 = r5.f640q;
        if (r1 == 0) goto L_0x0059;
    L_0x0046:
        r1 = android.support.v4.view.C0517s.m1719m(r6);
        if (r1 == 0) goto L_0x0059;
    L_0x004c:
        r1 = r5.f640q;
        r3 = android.support.v4.view.C0517s.m1719m(r6);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0059;
    L_0x0058:
        return r2;
    L_0x0059:
        r1 = r5.f627b;
        r1 = r1.size();
        r3 = 1;
        if (r1 != 0) goto L_0x0083;
    L_0x0062:
        r1 = r5.f628c;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0083;
    L_0x006a:
        r1 = r5.f636m;
        if (r1 == 0) goto L_0x0076;
    L_0x006e:
        r1 = r5.f636m;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0076:
        r1 = r5.f635l;
        if (r1 == 0) goto L_0x0082;
    L_0x007a:
        r1 = r5.f635l;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0082:
        return r3;
    L_0x0083:
        r1 = r5.f627b;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r1.contains(r0);
        if (r0 != 0) goto L_0x00c9;
    L_0x008f:
        r0 = r5.f628c;
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0098;
    L_0x0097:
        goto L_0x00c9;
    L_0x0098:
        r0 = r5.f635l;
        if (r0 == 0) goto L_0x00a9;
    L_0x009c:
        r0 = r5.f635l;
        r1 = android.support.v4.view.C0517s.m1719m(r6);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x00a9;
    L_0x00a8:
        return r3;
    L_0x00a9:
        r0 = r5.f636m;
        if (r0 == 0) goto L_0x00c8;
    L_0x00ad:
        r0 = 0;
    L_0x00ae:
        r1 = r5.f636m;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00c8;
    L_0x00b6:
        r1 = r5.f636m;
        r1 = r1.get(r0);
        r1 = (java.lang.Class) r1;
        r1 = r1.isInstance(r6);
        if (r1 == 0) goto L_0x00c5;
    L_0x00c4:
        return r3;
    L_0x00c5:
        r0 = r0 + 1;
        goto L_0x00ae;
    L_0x00c8:
        return r2;
    L_0x00c9:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.u.a(android.view.View):boolean");
    }

    /* renamed from: o */
    private static C3211a<Animator, C0251a> mo160o() {
        C3211a<Animator, C0251a> c3211a = (C3211a) f615z.get();
        if (c3211a != null) {
            return c3211a;
        }
        c3211a = new C3211a();
        f615z.set(c3211a);
        return c3211a;
    }

    /* renamed from: e */
    protected void mo157e() {
        m671j();
        C3211a o = C0254u.mo160o();
        Iterator it = this.f622G.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (o.containsKey(animator)) {
                m671j();
                m628a(animator, o);
            }
        }
        this.f622G.clear();
        m672k();
    }

    /* renamed from: a */
    private void m628a(Animator animator, final C3211a<Animator, C0251a> c3211a) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter(this) {
                /* renamed from: b */
                final /* synthetic */ C0254u f606b;

                public void onAnimationStart(Animator animator) {
                    this.f606b.f617B.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    c3211a.remove(animator);
                    this.f606b.f617B.remove(animator);
                }
            });
            m644a(animator);
        }
    }

    /* renamed from: b */
    public C0254u mo152b(View view) {
        this.f628c.add(view);
        return this;
    }

    /* renamed from: c */
    public C0254u mo153c(View view) {
        this.f628c.remove(view);
        return this;
    }

    /* renamed from: f */
    public List<Integer> m667f() {
        return this.f627b;
    }

    /* renamed from: g */
    public List<View> m668g() {
        return this.f628c;
    }

    /* renamed from: h */
    public List<String> m669h() {
        return this.f635l;
    }

    /* renamed from: i */
    public List<Class> m670i() {
        return this.f636m;
    }

    /* renamed from: a */
    void m649a(ViewGroup viewGroup, boolean z) {
        m650a(z);
        if ((this.f627b.size() > 0 || this.f628c.size() > 0) && (this.f635l == null || this.f635l.isEmpty())) {
            int i;
            View view;
            if (this.f636m != null) {
                if (this.f636m.isEmpty()) {
                }
            }
            for (i = 0; i < this.f627b.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) this.f627b.get(i)).intValue());
                if (findViewById != null) {
                    aa aaVar = new aa();
                    aaVar.f542b = findViewById;
                    if (z) {
                        mo135a(aaVar);
                    } else {
                        mo138b(aaVar);
                    }
                    aaVar.f543c.add(this);
                    mo154c(aaVar);
                    if (z) {
                        C0254u.m630a(this.f644u, findViewById, aaVar);
                    } else {
                        C0254u.m630a(this.f645v, findViewById, aaVar);
                    }
                }
            }
            for (viewGroup = null; viewGroup < this.f628c.size(); viewGroup++) {
                view = (View) this.f628c.get(viewGroup);
                aa aaVar2 = new aa();
                aaVar2.f542b = view;
                if (z) {
                    mo135a(aaVar2);
                } else {
                    mo138b(aaVar2);
                }
                aaVar2.f543c.add(this);
                mo154c(aaVar2);
                if (z) {
                    C0254u.m630a(this.f644u, view, aaVar2);
                } else {
                    C0254u.m630a(this.f645v, view, aaVar2);
                }
            }
            if (!z && this.f624I != null) {
                viewGroup = this.f624I.size();
                z = new ArrayList(viewGroup);
                for (i = 0; i < viewGroup; i++) {
                    z.add(this.f644u.f547d.remove((String) this.f624I.m1462b(i)));
                }
                for (int i2 = 0; i2 < viewGroup; i2++) {
                    view = (View) z.get(i2);
                    if (view != null) {
                        this.f644u.f547d.put((String) this.f624I.m1463c(i2), view);
                    }
                }
                return;
            }
        }
        m637c(viewGroup, z);
        if (!z) {
        }
    }

    /* renamed from: a */
    private static void m630a(ab abVar, View view, aa aaVar) {
        abVar.f544a.put(view, aaVar);
        aaVar = view.getId();
        if (aaVar >= null) {
            if (abVar.f545b.indexOfKey(aaVar) >= 0) {
                abVar.f545b.put(aaVar, null);
            } else {
                abVar.f545b.put(aaVar, view);
            }
        }
        aaVar = C0517s.m1719m(view);
        if (aaVar != null) {
            if (abVar.f547d.containsKey(aaVar)) {
                abVar.f547d.put(aaVar, null);
            } else {
                abVar.f547d.put(aaVar, view);
            }
        }
        if ((view.getParent() instanceof ListView) != null) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (abVar.f546c.m1419c(itemIdAtPosition) >= null) {
                    view = (View) abVar.f546c.m1412a(itemIdAtPosition);
                    if (view != null) {
                        C0517s.m1700a(view, (boolean) null);
                        abVar.f546c.m1418b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                C0517s.m1700a(view, true);
                abVar.f546c.m1418b(itemIdAtPosition, view);
            }
        }
    }

    /* renamed from: a */
    void m650a(boolean z) {
        if (z) {
            this.f644u.f544a.clear();
            this.f644u.f545b.clear();
            this.f644u.f546c.m1421c();
            return;
        }
        this.f645v.f544a.clear();
        this.f645v.f545b.clear();
        this.f645v.f546c.m1421c();
    }

    /* renamed from: c */
    private void m637c(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.f637n != null && this.f637n.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.f638o == null || !this.f638o.contains(view)) {
                int size;
                if (this.f639p != null) {
                    size = this.f639p.size();
                    int i = 0;
                    while (i < size) {
                        if (!((Class) this.f639p.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    aa aaVar = new aa();
                    aaVar.f542b = view;
                    if (z) {
                        mo135a(aaVar);
                    } else {
                        mo138b(aaVar);
                    }
                    aaVar.f543c.add(this);
                    mo154c(aaVar);
                    if (z) {
                        C0254u.m630a(this.f644u, view, aaVar);
                    } else {
                        C0254u.m630a(this.f645v, view, aaVar);
                    }
                }
                if ((view instanceof ViewGroup) && (this.f641r == null || !this.f641r.contains(Integer.valueOf(id)))) {
                    if (this.f642s == null || !this.f642s.contains(view)) {
                        if (this.f643t != null) {
                            id = this.f643t.size();
                            size = 0;
                            while (size < id) {
                                if (!((Class) this.f643t.get(size)).isInstance(view)) {
                                    size++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            m637c(viewGroup.getChildAt(i2), z);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public aa m640a(View view, boolean z) {
        if (this.f629d != null) {
            return this.f629d.m640a(view, z);
        }
        return (aa) (z ? this.f644u : this.f645v).f544a.get(view);
    }

    /* renamed from: b */
    aa m655b(View view, boolean z) {
        if (this.f629d != null) {
            return this.f629d.m655b(view, z);
        }
        ArrayList arrayList = z ? this.f647x : this.f648y;
        aa aaVar = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            aa aaVar2 = (aa) arrayList.get(i2);
            if (aaVar2 == null) {
                return null;
            }
            if (aaVar2.f542b == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            aaVar = (aa) (z ? this.f648y : this.f647x).get(i);
        }
        return aaVar;
    }

    /* renamed from: d */
    public void mo156d(View view) {
        if (!this.f620E) {
            C3211a o = C0254u.mo160o();
            int size = o.size();
            view = am.m580b(view);
            for (size--; size >= 0; size--) {
                C0251a c0251a = (C0251a) o.m1463c(size);
                if (c0251a.f608a != null && view.equals(c0251a.f611d)) {
                    C0219a.m555a((Animator) o.m1462b(size));
                }
            }
            if (this.f621F != null && this.f621F.size() > null) {
                ArrayList arrayList = (ArrayList) this.f621F.clone();
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    ((C0253c) arrayList.get(size)).mo100b(this);
                }
            }
            this.f619D = true;
        }
    }

    /* renamed from: e */
    public void mo158e(View view) {
        if (this.f619D) {
            if (!this.f620E) {
                C3211a o = C0254u.mo160o();
                int size = o.size();
                view = am.m580b(view);
                for (size--; size >= 0; size--) {
                    C0251a c0251a = (C0251a) o.m1463c(size);
                    if (c0251a.f608a != null && view.equals(c0251a.f611d)) {
                        C0219a.m557b((Animator) o.m1462b(size));
                    }
                }
                if (this.f621F != null && this.f621F.size() > null) {
                    ArrayList arrayList = (ArrayList) this.f621F.clone();
                    int size2 = arrayList.size();
                    for (size = 0; size < size2; size++) {
                        ((C0253c) arrayList.get(size)).mo101c(this);
                    }
                }
            }
            this.f619D = false;
        }
    }

    /* renamed from: a */
    void m647a(ViewGroup viewGroup) {
        this.f647x = new ArrayList();
        this.f648y = new ArrayList();
        m629a(this.f644u, this.f645v);
        C3211a o = C0254u.mo160o();
        int size = o.size();
        aw b = am.m580b(viewGroup);
        for (size--; size >= 0; size--) {
            Animator animator = (Animator) o.m1462b(size);
            if (animator != null) {
                C0251a c0251a = (C0251a) o.get(animator);
                if (!(c0251a == null || c0251a.f608a == null || !b.equals(c0251a.f611d))) {
                    aa aaVar = c0251a.f610c;
                    View view = c0251a.f608a;
                    aa a = m640a(view, true);
                    aa b2 = m655b(view, true);
                    Object obj = (!(a == null && b2 == null) && c0251a.f612e.mo136a(aaVar, b2)) ? 1 : null;
                    if (obj != null) {
                        if (!animator.isRunning()) {
                            if (!animator.isStarted()) {
                                o.remove(animator);
                            }
                        }
                        animator.cancel();
                    }
                }
            }
        }
        mo149a(viewGroup, this.f644u, this.f645v, this.f647x, this.f648y);
        mo157e();
    }

    /* renamed from: a */
    public boolean mo136a(aa aaVar, aa aaVar2) {
        if (aaVar == null || aaVar2 == null) {
            return false;
        }
        String[] a = mo137a();
        if (a != null) {
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!C0254u.m635a(aaVar, aaVar2, a[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String a2 : aaVar.f541a.keySet()) {
            if (C0254u.m635a(aaVar, aaVar2, a2)) {
            }
        }
        return false;
        return true;
    }

    /* renamed from: a */
    private static boolean m635a(aa aaVar, aa aaVar2, String str) {
        aaVar = aaVar.f541a.get(str);
        aaVar2 = aaVar2.f541a.get(str);
        if (aaVar == null && aaVar2 == null) {
            return null;
        }
        if (aaVar == null) {
            return true;
        }
        if (aaVar2 == null) {
            return true;
        }
        return 1 ^ aaVar.equals(aaVar2);
    }

    /* renamed from: a */
    protected void m644a(Animator animator) {
        if (animator == null) {
            m672k();
            return;
        }
        if (m654b() >= 0) {
            animator.setDuration(m654b());
        }
        if (m660c() >= 0) {
            animator.setStartDelay(m660c());
        }
        if (m663d() != null) {
            animator.setInterpolator(m663d());
        }
        animator.addListener(new C02503(this));
        animator.start();
    }

    /* renamed from: j */
    protected void m671j() {
        if (this.f618C == 0) {
            if (this.f621F != null && this.f621F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f621F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C0253c) arrayList.get(i)).mo102d(this);
                }
            }
            this.f620E = false;
        }
        this.f618C++;
    }

    /* renamed from: k */
    protected void m672k() {
        this.f618C--;
        if (this.f618C == 0) {
            int i;
            View view;
            if (this.f621F != null && this.f621F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f621F.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((C0253c) arrayList.get(i2)).mo99a(this);
                }
            }
            for (i = 0; i < this.f644u.f546c.m1415b(); i++) {
                view = (View) this.f644u.f546c.m1420c(i);
                if (view != null) {
                    C0517s.m1700a(view, false);
                }
            }
            for (i = 0; i < this.f645v.f546c.m1415b(); i++) {
                view = (View) this.f645v.f546c.m1420c(i);
                if (view != null) {
                    C0517s.m1700a(view, false);
                }
            }
            this.f620E = true;
        }
    }

    /* renamed from: a */
    public C0254u mo146a(C0253c c0253c) {
        if (this.f621F == null) {
            this.f621F = new ArrayList();
        }
        this.f621F.add(c0253c);
        return this;
    }

    /* renamed from: b */
    public C0254u mo151b(C0253c c0253c) {
        if (this.f621F == null) {
            return this;
        }
        this.f621F.remove(c0253c);
        if (this.f621F.size() == null) {
            this.f621F = null;
        }
        return this;
    }

    /* renamed from: l */
    public C0241l m673l() {
        return this.f625J;
    }

    /* renamed from: a */
    public void mo148a(C0252b c0252b) {
        this.f623H = c0252b;
    }

    /* renamed from: c */
    void mo154c(aa aaVar) {
        if (!(this.f631f == null || aaVar.f541a.isEmpty())) {
            String[] a = this.f631f.m684a();
            if (a != null) {
                Object obj = null;
                for (Object containsKey : a) {
                    if (!aaVar.f541a.containsKey(containsKey)) {
                        break;
                    }
                }
                obj = 1;
                if (obj == null) {
                    this.f631f.m683a(aaVar);
                }
            }
        }
    }

    public String toString() {
        return mo147a("");
    }

    /* renamed from: m */
    public android.support.transition.C0254u mo159m() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1 = (android.support.transition.C0254u) r1;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new java.util.ArrayList;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f622G = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new android.support.transition.ab;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f644u = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new android.support.transition.ab;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f645v = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f647x = r0;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f648y = r0;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        return r1;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.u.m():android.support.transition.u");
    }

    /* renamed from: n */
    public String m675n() {
        return this.f632i;
    }

    /* renamed from: a */
    String mo147a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(": ");
        str = stringBuilder.toString();
        if (this.f626a != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dur(");
            stringBuilder.append(this.f626a);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f633j != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dly(");
            stringBuilder.append(this.f633j);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f634k != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("interp(");
            stringBuilder.append(this.f634k);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f627b.size() <= 0 && this.f628c.size() <= 0) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("tgts(");
        str = stringBuilder.toString();
        if (this.f627b.size() > 0) {
            String str2 = str;
            for (str = null; str < this.f627b.size(); str++) {
                StringBuilder stringBuilder2;
                if (str > null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(", ");
                    str2 = stringBuilder2.toString();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(this.f627b.get(str));
                str2 = stringBuilder2.toString();
            }
            str = str2;
        }
        if (this.f628c.size() > 0) {
            for (int i = 0; i < this.f628c.size(); i++) {
                if (i > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    str = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.f628c.get(i));
                str = stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
