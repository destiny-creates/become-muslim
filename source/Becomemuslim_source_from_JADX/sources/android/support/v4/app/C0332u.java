package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.C3176c.C0292a;
import android.support.v4.util.C3211a;
import android.support.v4.view.C0517s;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition */
/* renamed from: android.support.v4.app.u */
class C0332u {
    /* renamed from: a */
    private static final int[] f899a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    /* renamed from: b */
    private static final C0340w f900b = (VERSION.SDK_INT >= 21 ? new C3186v() : null);
    /* renamed from: c */
    private static final C0340w f901c = C0332u.m966a();

    /* compiled from: FragmentTransition */
    /* renamed from: android.support.v4.app.u$a */
    static class C0331a {
        /* renamed from: a */
        public C3178i f893a;
        /* renamed from: b */
        public boolean f894b;
        /* renamed from: c */
        public C3176c f895c;
        /* renamed from: d */
        public C3178i f896d;
        /* renamed from: e */
        public boolean f897e;
        /* renamed from: f */
        public C3176c f898f;

        C0331a() {
        }
    }

    /* renamed from: a */
    private static android.support.v4.app.C0340w m966a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = "android.support.transition.FragmentTransitionSupport";	 Catch:{ Exception -> 0x0016 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0016 }
        r1 = 0;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Exception -> 0x0016 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = (android.support.v4.app.C0340w) r0;	 Catch:{ Exception -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.u.a():android.support.v4.app.w");
    }

    /* renamed from: a */
    static void m981a(C3184o c3184o, ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (c3184o.f8209l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C3176c c3176c = (C3176c) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    C0332u.m994b(c3176c, sparseArray, z);
                } else {
                    C0332u.m978a(c3176c, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(c3184o.f8210m.m9498i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C3211a a = C0332u.m968a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    C0331a c0331a = (C0331a) sparseArray.valueAt(i4);
                    if (z) {
                        C0332u.m980a(c3184o, keyAt, c0331a, view, a);
                    } else {
                        C0332u.m996b(c3184o, keyAt, c0331a, view, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C3211a<String, String> m968a(int i, ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        C3211a<String, String> c3211a = new C3211a();
        for (i3--; i3 >= i2; i3--) {
            C3176c c3176c = (C3176c) arrayList.get(i3);
            if (c3176c.m9470b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
                if (c3176c.f8166r != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = c3176c.f8166r.size();
                    if (booleanValue) {
                        arrayList3 = c3176c.f8166r;
                        arrayList4 = c3176c.f8167s;
                    } else {
                        ArrayList arrayList5 = c3176c.f8166r;
                        arrayList3 = c3176c.f8167s;
                        arrayList4 = arrayList5;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        String str = (String) arrayList4.get(i4);
                        String str2 = (String) arrayList3.get(i4);
                        String str3 = (String) c3211a.remove(str2);
                        if (str3 != null) {
                            c3211a.put(str, str3);
                        } else {
                            c3211a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c3211a;
    }

    /* renamed from: a */
    private static void m980a(C3184o c3184o, int i, C0331a c0331a, View view, C3211a<String, String> c3211a) {
        C3184o c3184o2 = c3184o;
        C0331a c0331a2 = c0331a;
        View view2 = view;
        View view3 = c3184o2.f8211n.mo196a() ? (ViewGroup) c3184o2.f8211n.mo195a(i) : null;
        if (view3 != null) {
            C3178i c3178i = c0331a2.f893a;
            C3178i c3178i2 = c0331a2.f896d;
            C0340w a = C0332u.m967a(c3178i2, c3178i);
            if (a != null) {
                boolean z = c0331a2.f894b;
                boolean z2 = c0331a2.f897e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a2 = C0332u.m972a(a, c3178i, z);
                Object b = C0332u.m991b(a, c3178i2, z2);
                Object obj = a2;
                View view4 = view3;
                ArrayList arrayList3 = arrayList2;
                Object a3 = C0332u.m973a(a, (ViewGroup) view3, view, (C3211a) c3211a, c0331a, arrayList2, arrayList, a2, b);
                Object obj2 = obj;
                if (obj2 == null && a3 == null) {
                    a2 = b;
                    if (a2 == null) {
                        return;
                    }
                }
                a2 = b;
                ArrayList b2 = C0332u.m993b(a, a2, c3178i2, arrayList3, view2);
                ArrayList b3 = C0332u.m993b(a, obj2, c3178i, arrayList, view2);
                C0332u.m997b(b3, 4);
                C3178i c3178i3 = c3178i;
                ArrayList arrayList4 = b2;
                Object a4 = C0332u.m974a(a, obj2, a2, a3, c3178i3, z);
                if (a4 != null) {
                    C0332u.m983a(a, a2, c3178i2, arrayList4);
                    ArrayList a5 = a.m1004a(arrayList);
                    a.mo108a(a4, obj2, b3, a2, arrayList4, a3, arrayList);
                    View view5 = view4;
                    a.mo104a((ViewGroup) view5, a4);
                    a.m1006a(view5, arrayList3, arrayList, a5, c3211a);
                    C0332u.m997b(b3, 0);
                    a.mo110a(a3, arrayList3, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m983a(C0340w c0340w, Object obj, C3178i c3178i, final ArrayList<View> arrayList) {
        if (c3178i != null && obj != null && c3178i.mAdded && c3178i.mHidden && c3178i.mHiddenChanged) {
            c3178i.setHideReplaced(true);
            c0340w.mo115b(obj, c3178i.getView(), (ArrayList) arrayList);
            ag.m835a(c3178i.mContainer, new Runnable() {
                public void run() {
                    C0332u.m997b(arrayList, 4);
                }
            });
        }
    }

    /* renamed from: b */
    private static void m996b(C3184o c3184o, int i, C0331a c0331a, View view, C3211a<String, String> c3211a) {
        C3184o c3184o2 = c3184o;
        C0331a c0331a2 = c0331a;
        View view2 = view;
        Map map = c3211a;
        ViewGroup viewGroup = c3184o2.f8211n.mo196a() ? (ViewGroup) c3184o2.f8211n.mo195a(i) : null;
        if (viewGroup != null) {
            C3178i c3178i = c0331a2.f893a;
            C3178i c3178i2 = c0331a2.f896d;
            C0340w a = C0332u.m967a(c3178i2, c3178i);
            if (a != null) {
                Object obj;
                Object obj2;
                Object a2;
                C0340w c0340w;
                ArrayList arrayList;
                boolean z = c0331a2.f894b;
                boolean z2 = c0331a2.f897e;
                Object a3 = C0332u.m972a(a, c3178i, z);
                Object b = C0332u.m991b(a, c3178i2, z2);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                Object obj3 = b;
                Object obj4 = a3;
                C0340w c0340w2 = a;
                b = C0332u.m992b(a, viewGroup, view, c3211a, c0331a, arrayList2, arrayList3, a3, obj3);
                Object obj5 = obj4;
                if (obj5 == null && b == null) {
                    obj = obj3;
                    if (obj == null) {
                        return;
                    }
                }
                obj = obj3;
                ArrayList b2 = C0332u.m993b(c0340w2, obj, c3178i2, arrayList4, view2);
                if (b2 != null) {
                    if (!b2.isEmpty()) {
                        obj2 = obj;
                        c0340w2.mo114b(obj5, view2);
                        a2 = C0332u.m974a(c0340w2, obj5, obj2, b, c3178i, c0331a2.f894b);
                        if (a2 != null) {
                            arrayList4 = new ArrayList();
                            c0340w = c0340w2;
                            c0340w.mo108a(a2, obj5, arrayList4, obj2, b2, b, arrayList3);
                            C0332u.m982a(c0340w, viewGroup, c3178i, view, arrayList3, obj5, arrayList4, obj2, b2);
                            arrayList = arrayList3;
                            c0340w2.m1007a((View) viewGroup, arrayList, map);
                            c0340w2.mo104a(viewGroup, a2);
                            c0340w2.m1009a(viewGroup, arrayList, map);
                        }
                    }
                }
                obj2 = null;
                c0340w2.mo114b(obj5, view2);
                a2 = C0332u.m974a(c0340w2, obj5, obj2, b, c3178i, c0331a2.f894b);
                if (a2 != null) {
                    arrayList4 = new ArrayList();
                    c0340w = c0340w2;
                    c0340w.mo108a(a2, obj5, arrayList4, obj2, b2, b, arrayList3);
                    C0332u.m982a(c0340w, viewGroup, c3178i, view, arrayList3, obj5, arrayList4, obj2, b2);
                    arrayList = arrayList3;
                    c0340w2.m1007a((View) viewGroup, arrayList, map);
                    c0340w2.mo104a(viewGroup, a2);
                    c0340w2.m1009a(viewGroup, arrayList, map);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m982a(C0340w c0340w, ViewGroup viewGroup, C3178i c3178i, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final C0340w c0340w2 = c0340w;
        final View view2 = view;
        final C3178i c3178i2 = c3178i;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        Runnable c03282 = new Runnable() {
            public void run() {
                if (obj3 != null) {
                    c0340w2.mo118c(obj3, view2);
                    arrayList5.addAll(C0332u.m993b(c0340w2, obj3, c3178i2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        c0340w2.mo116b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        };
        ViewGroup viewGroup2 = viewGroup;
        ag.m835a(viewGroup, c03282);
    }

    /* renamed from: a */
    private static C0340w m967a(C3178i c3178i, C3178i c3178i2) {
        List arrayList = new ArrayList();
        if (c3178i != null) {
            Object exitTransition = c3178i.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = c3178i.getReturnTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            c3178i = c3178i.getSharedElementReturnTransition();
            if (c3178i != null) {
                arrayList.add(c3178i);
            }
        }
        if (c3178i2 != null) {
            c3178i = c3178i2.getEnterTransition();
            if (c3178i != null) {
                arrayList.add(c3178i);
            }
            c3178i = c3178i2.getReenterTransition();
            if (c3178i != null) {
                arrayList.add(c3178i);
            }
            c3178i = c3178i2.getSharedElementEnterTransition();
            if (c3178i != null) {
                arrayList.add(c3178i);
            }
        }
        if (arrayList.isEmpty() != null) {
            return null;
        }
        if (f900b != null && C0332u.m988a(f900b, arrayList) != null) {
            return f900b;
        }
        if (f901c != null && C0332u.m988a(f901c, arrayList) != null) {
            return f901c;
        }
        if (f900b == null && f901c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static boolean m988a(C0340w c0340w, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!c0340w.mo111a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m971a(C0340w c0340w, C3178i c3178i, C3178i c3178i2, boolean z) {
        if (c3178i != null) {
            if (c3178i2 != null) {
                if (z) {
                    c3178i = c3178i2.getSharedElementReturnTransition();
                } else {
                    c3178i = c3178i.getSharedElementEnterTransition();
                }
                return c0340w.mo117c(c0340w.mo112b(c3178i));
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Object m972a(C0340w c0340w, C3178i c3178i, boolean z) {
        if (c3178i == null) {
            return null;
        }
        if (z) {
            c3178i = c3178i.getReenterTransition();
        } else {
            c3178i = c3178i.getEnterTransition();
        }
        return c0340w.mo112b(c3178i);
    }

    /* renamed from: b */
    private static Object m991b(C0340w c0340w, C3178i c3178i, boolean z) {
        if (c3178i == null) {
            return null;
        }
        if (z) {
            c3178i = c3178i.getReturnTransition();
        } else {
            c3178i = c3178i.getExitTransition();
        }
        return c0340w.mo112b(c3178i);
    }

    /* renamed from: a */
    private static Object m973a(C0340w c0340w, ViewGroup viewGroup, View view, C3211a<String, String> c3211a, C0331a c0331a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        C0340w c0340w2 = c0340w;
        View view2 = view;
        C3211a c3211a2 = c3211a;
        C0331a c0331a2 = c0331a;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        Object obj3 = obj;
        C3178i c3178i = c0331a2.f893a;
        C3178i c3178i2 = c0331a2.f896d;
        if (c3178i != null) {
            c3178i.getView().setVisibility(0);
        }
        if (c3178i != null) {
            if (c3178i2 != null) {
                Object obj4;
                Object obj5;
                boolean z = c0331a2.f894b;
                if (c3211a.isEmpty()) {
                    obj4 = null;
                } else {
                    obj4 = C0332u.m971a(c0340w2, c3178i, c3178i2, z);
                }
                C3211a b = C0332u.m989b(c0340w2, c3211a2, obj4, c0331a2);
                C3211a c = C0332u.m998c(c0340w2, c3211a2, obj4, c0331a2);
                if (c3211a.isEmpty()) {
                    if (b != null) {
                        b.clear();
                    }
                    if (c != null) {
                        c.clear();
                    }
                    obj5 = null;
                } else {
                    C0332u.m987a(arrayList3, b, c3211a.keySet());
                    C0332u.m987a(arrayList4, c, c3211a.values());
                    obj5 = obj4;
                }
                if (obj3 == null && obj2 == null && obj5 == null) {
                    return null;
                }
                Rect rect;
                View view3;
                C0332u.m995b(c3178i, c3178i2, z, b, true);
                if (obj5 != null) {
                    arrayList4.add(view2);
                    c0340w2.mo107a(obj5, view2, arrayList3);
                    C0332u.m984a(c0340w, obj5, obj2, b, c0331a2.f897e, c0331a2.f898f);
                    Rect rect2 = new Rect();
                    View b2 = C0332u.m990b(c, c0331a2, obj3, z);
                    if (b2 != null) {
                        c0340w2.mo105a(obj3, rect2);
                    }
                    rect = rect2;
                    view3 = b2;
                } else {
                    view3 = null;
                    rect = view3;
                }
                final C3178i c3178i3 = c3178i;
                final C3178i c3178i4 = c3178i2;
                final boolean z2 = z;
                final C3211a c3211a3 = c;
                c0340w2 = c0340w;
                ag.m835a(viewGroup, new Runnable() {
                    public void run() {
                        C0332u.m995b(c3178i3, c3178i4, z2, c3211a3, false);
                        if (view3 != null) {
                            c0340w2.m1005a(view3, rect);
                        }
                    }
                });
                return obj5;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m987a(ArrayList<View> arrayList, C3211a<String, View> c3211a, Collection<String> collection) {
        for (int size = c3211a.size() - 1; size >= 0; size--) {
            View view = (View) c3211a.m1463c(size);
            if (collection.contains(C0517s.m1719m(view))) {
                arrayList.add(view);
            }
        }
    }

    /* renamed from: b */
    private static Object m992b(C0340w c0340w, ViewGroup viewGroup, View view, C3211a<String, String> c3211a, C0331a c0331a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        C0340w c0340w2 = c0340w;
        C0331a c0331a2 = c0331a;
        ArrayList arrayList3 = arrayList;
        Object obj3 = obj;
        C3178i c3178i = c0331a2.f893a;
        C3178i c3178i2 = c0331a2.f896d;
        if (c3178i != null) {
            if (c3178i2 != null) {
                C3211a c3211a2;
                Object obj4;
                Object obj5;
                boolean z = c0331a2.f894b;
                if (c3211a.isEmpty()) {
                    c3211a2 = c3211a;
                    obj4 = null;
                } else {
                    obj4 = C0332u.m971a(c0340w2, c3178i, c3178i2, z);
                    c3211a2 = c3211a;
                }
                C3211a b = C0332u.m989b(c0340w2, c3211a2, obj4, c0331a2);
                if (c3211a.isEmpty()) {
                    obj5 = null;
                } else {
                    arrayList3.addAll(b.values());
                    obj5 = obj4;
                }
                if (obj3 == null && obj2 == null && obj5 == null) {
                    return null;
                }
                Rect rect;
                C0332u.m995b(c3178i, c3178i2, z, b, true);
                if (obj5 != null) {
                    rect = new Rect();
                    c0340w2.mo107a(obj5, view, arrayList3);
                    C0332u.m984a(c0340w, obj5, obj2, b, c0331a2.f897e, c0331a2.f898f);
                    if (obj3 != null) {
                        c0340w2.mo105a(obj3, rect);
                    }
                } else {
                    rect = null;
                }
                final C0340w c0340w3 = c0340w;
                final C3211a<String, String> c3211a3 = c3211a;
                final Object obj6 = obj5;
                final C0331a c0331a3 = c0331a;
                C03304 c03304 = r0;
                final ArrayList<View> arrayList4 = arrayList2;
                final View view2 = view;
                final C3178i c3178i3 = c3178i;
                c3178i = c3178i2;
                final boolean z2 = z;
                final ArrayList<View> arrayList5 = arrayList;
                obj3 = obj;
                final Rect rect2 = rect;
                C03304 c033042 = new Runnable() {
                    public void run() {
                        C3211a a = C0332u.m998c(c0340w3, c3211a3, obj6, c0331a3);
                        if (a != null) {
                            arrayList4.addAll(a.values());
                            arrayList4.add(view2);
                        }
                        C0332u.m995b(c3178i3, c3178i, z2, a, false);
                        if (obj6 != null) {
                            c0340w3.mo110a(obj6, arrayList5, arrayList4);
                            View a2 = C0332u.m990b(a, c0331a3, obj3, z2);
                            if (a2 != null) {
                                c0340w3.m1005a(a2, rect2);
                            }
                        }
                    }
                };
                ag.m835a(viewGroup, c03304);
                return obj5;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static C3211a<String, View> m989b(C0340w c0340w, C3211a<String, String> c3211a, Object obj, C0331a c0331a) {
        if (!c3211a.isEmpty()) {
            if (obj != null) {
                List list;
                obj = c0331a.f896d;
                Map c3211a2 = new C3211a();
                c0340w.m1017a(c3211a2, obj.getView());
                c0340w = c0331a.f898f;
                if (c0331a.f897e != null) {
                    obj = obj.getEnterTransitionCallback();
                    list = c0340w.f8167s;
                } else {
                    obj = obj.getExitTransitionCallback();
                    list = c0340w.f8166r;
                }
                c3211a2.m9768a(list);
                if (obj != null) {
                    obj.m855a(list, c3211a2);
                    for (obj = list.size() - 1; obj >= null; obj--) {
                        String str = (String) list.get(obj);
                        View view = (View) c3211a2.get(str);
                        if (view == null) {
                            c3211a.remove(str);
                        } else if (!str.equals(C0517s.m1719m(view))) {
                            c3211a.put(C0517s.m1719m(view), (String) c3211a.remove(str));
                        }
                    }
                } else {
                    c3211a.m9768a(c3211a2.keySet());
                }
                return c3211a2;
            }
        }
        c3211a.clear();
        return null;
    }

    /* renamed from: c */
    private static C3211a<String, View> m998c(C0340w c0340w, C3211a<String, String> c3211a, Object obj, C0331a c0331a) {
        C3178i c3178i = c0331a.f893a;
        View view = c3178i.getView();
        if (!(c3211a.isEmpty() || obj == null)) {
            if (view != null) {
                List list;
                C3211a c3211a2 = new C3211a();
                c0340w.m1017a((Map) c3211a2, view);
                c0340w = c0331a.f895c;
                if (c0331a.f894b != null) {
                    c0331a = c3178i.getExitTransitionCallback();
                    list = c0340w.f8166r;
                } else {
                    c0331a = c3178i.getEnterTransitionCallback();
                    list = c0340w.f8167s;
                }
                if (list != null) {
                    c3211a2.m9768a(list);
                    c3211a2.m9768a(c3211a.values());
                }
                if (c0331a != null) {
                    c0331a.m855a(list, (Map) c3211a2);
                    for (c0331a = list.size() - 1; c0331a >= null; c0331a--) {
                        String str = (String) list.get(c0331a);
                        view = (View) c3211a2.get(str);
                        if (view == null) {
                            str = C0332u.m975a((C3211a) c3211a, str);
                            if (str != null) {
                                c3211a.remove(str);
                            }
                        } else if (!str.equals(C0517s.m1719m(view))) {
                            str = C0332u.m975a((C3211a) c3211a, str);
                            if (str != null) {
                                c3211a.put(str, C0517s.m1719m(view));
                            }
                        }
                    }
                } else {
                    C0332u.m985a((C3211a) c3211a, c3211a2);
                }
                return c3211a2;
            }
        }
        c3211a.clear();
        return null;
    }

    /* renamed from: a */
    private static String m975a(C3211a<String, String> c3211a, String str) {
        int size = c3211a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c3211a.m1463c(i))) {
                return (String) c3211a.m1462b(i);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static View m990b(C3211a<String, View> c3211a, C0331a c0331a, Object obj, boolean z) {
        c0331a = c0331a.f895c;
        if (obj == null || c3211a == null || c0331a.f8166r == null || c0331a.f8166r.isEmpty() != null) {
            return null;
        }
        if (z) {
            c0331a = (String) c0331a.f8166r.get(0);
        } else {
            c0331a = (String) c0331a.f8167s.get(0);
        }
        return (View) c3211a.get(c0331a);
    }

    /* renamed from: a */
    private static void m984a(C0340w c0340w, Object obj, Object obj2, C3211a<String, View> c3211a, boolean z, C3176c c3176c) {
        if (c3176c.f8166r != null && !c3176c.f8166r.isEmpty()) {
            if (z) {
                z = (String) c3176c.f8167s.get(0);
            } else {
                z = (String) c3176c.f8166r.get(0);
            }
            View view = (View) c3211a.get(z);
            c0340w.mo106a(obj, view);
            if (obj2 != null) {
                c0340w.mo106a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    private static void m985a(C3211a<String, String> c3211a, C3211a<String, View> c3211a2) {
        for (int size = c3211a.size() - 1; size >= 0; size--) {
            if (!c3211a2.containsKey((String) c3211a.m1463c(size))) {
                c3211a.m1464d(size);
            }
        }
    }

    /* renamed from: b */
    private static void m995b(C3178i c3178i, C3178i c3178i2, boolean z, C3211a<String, View> c3211a, boolean z2) {
        if (z) {
            c3178i = c3178i2.getEnterTransitionCallback();
        } else {
            c3178i = c3178i.getEnterTransitionCallback();
        }
        if (c3178i != null) {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i2 = 0;
            if (c3211a == null) {
                i = 0;
            } else {
                i = c3211a.size();
            }
            while (i2 < i) {
                arrayList2.add(c3211a.m1462b(i2));
                arrayList.add(c3211a.m1463c(i2));
                i2++;
            }
            if (z2) {
                c3178i.m854a(arrayList2, arrayList, null);
            } else {
                c3178i.m856b(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: b */
    private static ArrayList<View> m993b(C0340w c0340w, Object obj, C3178i c3178i, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = c3178i.getView();
        if (view2 != null) {
            c0340w.m1016a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty() != null) {
            return arrayList2;
        }
        arrayList2.add(view);
        c0340w.mo109a(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: b */
    private static void m997b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m974a(C0340w c0340w, Object obj, Object obj2, Object obj3, C3178i c3178i, boolean z) {
        c3178i = (obj == null || obj2 == null || c3178i == null) ? true : z ? c3178i.getAllowReturnTransitionOverlap() : c3178i.getAllowEnterTransitionOverlap();
        if (c3178i != null) {
            return c0340w.mo103a(obj2, obj, obj3);
        }
        return c0340w.mo113b(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m978a(C3176c c3176c, SparseArray<C0331a> sparseArray, boolean z) {
        int size = c3176c.f8150b.size();
        for (int i = 0; i < size; i++) {
            C0332u.m977a(c3176c, (C0292a) c3176c.f8150b.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    /* renamed from: b */
    public static void m994b(C3176c c3176c, SparseArray<C0331a> sparseArray, boolean z) {
        if (c3176c.f8149a.f8211n.mo196a()) {
            for (int size = c3176c.f8150b.size() - 1; size >= 0; size--) {
                C0332u.m977a(c3176c, (C0292a) c3176c.f8150b.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m977a(android.support.v4.app.C3176c r15, android.support.v4.app.C3176c.C0292a r16, android.util.SparseArray<android.support.v4.app.C0332u.C0331a> r17, boolean r18, boolean r19) {
        /*
        r0 = r15;
        r1 = r16;
        r2 = r17;
        r3 = r18;
        r10 = r1.f778b;
        if (r10 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r11 = r10.mContainerId;
        if (r11 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        if (r3 == 0) goto L_0x001a;
    L_0x0013:
        r4 = f899a;
        r1 = r1.f777a;
        r1 = r4[r1];
        goto L_0x001c;
    L_0x001a:
        r1 = r1.f777a;
    L_0x001c:
        r4 = 0;
        r5 = 1;
        if (r1 == r5) goto L_0x007c;
    L_0x0020:
        switch(r1) {
            case 3: goto L_0x0052;
            case 4: goto L_0x003a;
            case 5: goto L_0x0028;
            case 6: goto L_0x0052;
            case 7: goto L_0x007c;
            default: goto L_0x0023;
        };
    L_0x0023:
        r1 = 0;
    L_0x0024:
        r12 = 0;
        r13 = 0;
        goto L_0x008f;
    L_0x0028:
        if (r19 == 0) goto L_0x0037;
    L_0x002a:
        r1 = r10.mHiddenChanged;
        if (r1 == 0) goto L_0x008b;
    L_0x002e:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x008b;
    L_0x0032:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x008b;
    L_0x0036:
        goto L_0x0089;
    L_0x0037:
        r1 = r10.mHidden;
        goto L_0x008c;
    L_0x003a:
        if (r19 == 0) goto L_0x0049;
    L_0x003c:
        r1 = r10.mHiddenChanged;
        if (r1 == 0) goto L_0x006d;
    L_0x0040:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006d;
    L_0x0044:
        r1 = r10.mHidden;
        if (r1 == 0) goto L_0x006d;
    L_0x0048:
        goto L_0x006b;
    L_0x0049:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006d;
    L_0x004d:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x006d;
    L_0x0051:
        goto L_0x0048;
    L_0x0052:
        if (r19 == 0) goto L_0x006f;
    L_0x0054:
        r1 = r10.mAdded;
        if (r1 != 0) goto L_0x006d;
    L_0x0058:
        r1 = r10.mView;
        if (r1 == 0) goto L_0x006d;
    L_0x005c:
        r1 = r10.mView;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x006d;
    L_0x0064:
        r1 = r10.mPostponedAlpha;
        r6 = 0;
        r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r1 < 0) goto L_0x006d;
    L_0x006b:
        r1 = 1;
        goto L_0x0078;
    L_0x006d:
        r1 = 0;
        goto L_0x0078;
    L_0x006f:
        r1 = r10.mAdded;
        if (r1 == 0) goto L_0x006d;
    L_0x0073:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x006d;
    L_0x0077:
        goto L_0x006b;
    L_0x0078:
        r13 = r1;
        r1 = 0;
        r12 = 1;
        goto L_0x008f;
    L_0x007c:
        if (r19 == 0) goto L_0x0081;
    L_0x007e:
        r1 = r10.mIsNewlyAdded;
        goto L_0x008c;
    L_0x0081:
        r1 = r10.mAdded;
        if (r1 != 0) goto L_0x008b;
    L_0x0085:
        r1 = r10.mHidden;
        if (r1 != 0) goto L_0x008b;
    L_0x0089:
        r1 = 1;
        goto L_0x008c;
    L_0x008b:
        r1 = 0;
    L_0x008c:
        r4 = r1;
        r1 = 1;
        goto L_0x0024;
    L_0x008f:
        r6 = r2.get(r11);
        r6 = (android.support.v4.app.C0332u.C0331a) r6;
        if (r4 == 0) goto L_0x00a1;
    L_0x0097:
        r6 = android.support.v4.app.C0332u.m965a(r6, r2, r11);
        r6.f893a = r10;
        r6.f894b = r3;
        r6.f895c = r0;
    L_0x00a1:
        r14 = r6;
        r9 = 0;
        if (r19 != 0) goto L_0x00c9;
    L_0x00a5:
        if (r1 == 0) goto L_0x00c9;
    L_0x00a7:
        if (r14 == 0) goto L_0x00af;
    L_0x00a9:
        r1 = r14.f896d;
        if (r1 != r10) goto L_0x00af;
    L_0x00ad:
        r14.f896d = r9;
    L_0x00af:
        r4 = r0.f8149a;
        r1 = r10.mState;
        if (r1 >= r5) goto L_0x00c9;
    L_0x00b5:
        r1 = r4.f8209l;
        if (r1 < r5) goto L_0x00c9;
    L_0x00b9:
        r1 = r0.f8168t;
        if (r1 != 0) goto L_0x00c9;
    L_0x00bd:
        r4.m9592f(r10);
        r6 = 1;
        r7 = 0;
        r8 = 0;
        r1 = 0;
        r5 = r10;
        r9 = r1;
        r4.m9554a(r5, r6, r7, r8, r9);
    L_0x00c9:
        if (r13 == 0) goto L_0x00db;
    L_0x00cb:
        if (r14 == 0) goto L_0x00d1;
    L_0x00cd:
        r1 = r14.f896d;
        if (r1 != 0) goto L_0x00db;
    L_0x00d1:
        r14 = android.support.v4.app.C0332u.m965a(r14, r2, r11);
        r14.f896d = r10;
        r14.f897e = r3;
        r14.f898f = r0;
    L_0x00db:
        if (r19 != 0) goto L_0x00e8;
    L_0x00dd:
        if (r12 == 0) goto L_0x00e8;
    L_0x00df:
        if (r14 == 0) goto L_0x00e8;
    L_0x00e1:
        r0 = r14.f893a;
        if (r0 != r10) goto L_0x00e8;
    L_0x00e5:
        r0 = 0;
        r14.f893a = r0;
    L_0x00e8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.u.a(android.support.v4.app.c, android.support.v4.app.c$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    private static C0331a m965a(C0331a c0331a, SparseArray<C0331a> sparseArray, int i) {
        if (c0331a != null) {
            return c0331a;
        }
        c0331a = new C0331a();
        sparseArray.put(i, c0331a);
        return c0331a;
    }
}
