package android.support.v4.view.p033a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
/* renamed from: android.support.v4.view.a.c */
public class C0485c {
    /* renamed from: a */
    private final Object f1254a;

    /* compiled from: AccessibilityNodeProviderCompat */
    /* renamed from: android.support.v4.view.a.c$a */
    static class C0484a extends AccessibilityNodeProvider {
        /* renamed from: a */
        final C0485c f1253a;

        C0484a(C0485c c0485c) {
            this.f1253a = c0485c;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            i = this.f1253a.m1551a(i);
            if (i == 0) {
                return 0;
            }
            return i.m1501a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            str = this.f1253a.m1553a(str, i);
            if (str == null) {
                return null;
            }
            i = new ArrayList();
            int size = str.size();
            for (int i2 = 0; i2 < size; i2++) {
                i.add(((C0483b) str.get(i2)).m1501a());
            }
            return i;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1253a.m1554a(i, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    /* renamed from: android.support.v4.view.a.c$b */
    static class C3217b extends C0484a {
        C3217b(C0485c c0485c) {
            super(c0485c);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            i = this.a.m1555b(i);
            if (i == 0) {
                return 0;
            }
            return i.m1501a();
        }
    }

    /* renamed from: a */
    public C0483b m1551a(int i) {
        return null;
    }

    /* renamed from: a */
    public List<C0483b> m1553a(String str, int i) {
        return null;
    }

    /* renamed from: a */
    public boolean m1554a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: b */
    public C0483b m1555b(int i) {
        return null;
    }

    public C0485c() {
        if (VERSION.SDK_INT >= 19) {
            this.f1254a = new C3217b(this);
        } else if (VERSION.SDK_INT >= 16) {
            this.f1254a = new C0484a(this);
        } else {
            this.f1254a = null;
        }
    }

    public C0485c(Object obj) {
        this.f1254a = obj;
    }

    /* renamed from: a */
    public Object m1552a() {
        return this.f1254a;
    }
}
