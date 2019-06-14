package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0520u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: FragmentTransitionImpl */
/* renamed from: android.support.v4.app.w */
public abstract class C0340w {
    /* renamed from: a */
    public abstract Object mo103a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public abstract void mo104a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo105a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo106a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo107a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo108a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo109a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo110a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo111a(Object obj);

    /* renamed from: b */
    public abstract Object mo112b(Object obj);

    /* renamed from: b */
    public abstract Object mo113b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo114b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo115b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo116b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo117c(Object obj);

    /* renamed from: c */
    public abstract void mo118c(Object obj, View view);

    /* renamed from: a */
    protected void m1005a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: a */
    ArrayList<String> m1004a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(C0517s.m1719m(view));
            C0517s.m1699a(view, null);
        }
        return arrayList2;
    }

    /* renamed from: a */
    void m1006a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String m = C0517s.m1719m(view2);
            arrayList4.add(m);
            if (m != null) {
                C0517s.m1699a(view2, null);
                String str = (String) map.get(m);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        C0517s.m1699a((View) arrayList2.get(i2), m);
                        break;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        ag.m835a(view, new Runnable(this) {
            /* renamed from: f */
            final /* synthetic */ C0340w f921f;

            public void run() {
                for (int i = 0; i < size; i++) {
                    C0517s.m1699a((View) arrayList5.get(i), (String) arrayList6.get(i));
                    C0517s.m1699a((View) arrayList7.get(i), (String) arrayList4.get(i));
                }
            }
        });
    }

    /* renamed from: a */
    void m1016a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0520u.m1737a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m1016a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* renamed from: a */
    void m1017a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String m = C0517s.m1719m(view);
            if (m != null) {
                map.put(m, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1017a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    void m1007a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        ag.m835a(view, new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C0340w f924c;

            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    String m = C0517s.m1719m(view);
                    if (m != null) {
                        C0517s.m1699a(view, C0340w.m999a(map, m));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    void m1009a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        ag.m835a(viewGroup, new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C0340w f927c;

            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    C0517s.m1699a(view, (String) map.get(C0517s.m1719m(view)));
                }
            }
        });
    }

    /* renamed from: a */
    protected static void m1000a(List<View> list, View view) {
        int size = list.size();
        if (!C0340w.m1002a((List) list, view, size)) {
            list.add(view);
            for (view = size; view < list.size(); view++) {
                View view2 = (View) list.get(view);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (!C0340w.m1002a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m1002a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m1001a(List list) {
        if (list != null) {
            if (list.isEmpty() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    static String m999a(Map<String, String> map, String str) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }
}
