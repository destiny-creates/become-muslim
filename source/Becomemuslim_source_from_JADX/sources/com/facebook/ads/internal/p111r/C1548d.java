package com.facebook.ads.internal.p111r;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.p105q.p106a.C1493a;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* renamed from: com.facebook.ads.internal.r.d */
class C1548d {
    /* renamed from: a */
    static Float m5443a(View view) {
        Activity a = C1493a.m5262a();
        if (a == null) {
            return null;
        }
        View findViewById = a.findViewById(16908290);
        if (findViewById == null) {
            findViewById = a.getWindow().getDecorView().findViewById(16908290);
        }
        if (!(findViewById == null || view == null)) {
            if (view.getId() != -1) {
                return findViewById.findViewById(view.getId()) == null ? Float.valueOf(-1.0f) : C1548d.m5444a(findViewById, view);
            }
        }
        return null;
    }

    /* renamed from: a */
    static Float m5444a(View view, View view2) {
        if (view != null) {
            if (view2 != null) {
                if (view2.getVisibility() != 0) {
                    return Float.valueOf(0.0f);
                }
                float f;
                List<View> b = C1548d.m5446b(view, view2);
                if (b.isEmpty()) {
                    f = 1.0f;
                } else {
                    Rect rect = new Rect();
                    if (!view2.getGlobalVisibleRect(rect)) {
                        return Float.valueOf(0.0f);
                    }
                    int width = rect.width() * rect.height();
                    Set hashSet = new HashSet();
                    hashSet.add(rect);
                    for (View view3 : b) {
                        Rect rect2 = new Rect();
                        if (view3.getGlobalVisibleRect(rect2)) {
                            Set hashSet2 = new HashSet();
                            for (Rect a : r1) {
                                hashSet2.addAll(C1548d.m5445a(a, rect2));
                            }
                            hashSet = hashSet2;
                        }
                    }
                    int i = 0;
                    for (Rect rect3 : r1) {
                        i += rect3.width() * rect3.height();
                    }
                    f = ((float) i) / ((float) width);
                }
                return Float.valueOf(f);
            }
        }
        return null;
    }

    /* renamed from: a */
    static Set<Rect> m5445a(Rect rect, Rect rect2) {
        Set<Rect> hashSet = new HashSet();
        if (rect2.intersect(rect)) {
            hashSet.add(new Rect(rect.left, rect.top, rect2.left, rect.bottom));
            hashSet.add(new Rect(rect2.left, rect.top, rect2.right, rect2.top));
            hashSet.add(new Rect(rect2.right, rect.top, rect.right, rect.bottom));
            hashSet.add(new Rect(rect2.left, rect2.bottom, rect2.right, rect.bottom));
            Set<Rect> hashSet2 = new HashSet();
            for (Rect rect3 : hashSet) {
                if (rect3.width() > 0 && rect3.height() > 0) {
                    hashSet2.add(rect3);
                }
            }
            return hashSet2;
        }
        hashSet.add(rect);
        return hashSet;
    }

    /* renamed from: b */
    private static List<View> m5446b(View view, View view2) {
        List<View> linkedList = new LinkedList();
        Stack stack = new Stack();
        stack.push(view);
        Object obj = null;
        while (!stack.empty()) {
            View view3 = (View) stack.pop();
            if (view3.getVisibility() == 0) {
                if (view3 == view2) {
                    obj = 1;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        stack.push(viewGroup.getChildAt(childCount));
                    }
                } else if (obj != null || (VERSION.SDK_INT >= 21 && view3.getZ() > view2.getZ())) {
                    linkedList.add(view3);
                }
            }
        }
        return linkedList;
    }
}
