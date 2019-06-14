package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.C0254u.C0253c;
import android.support.transition.C3148b.C0226a;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Visibility */
public abstract class at extends C0254u {
    /* renamed from: g */
    private static final String[] f8088g = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    /* renamed from: h */
    private int f8089h = 3;

    /* compiled from: Visibility */
    /* renamed from: android.support.transition.at$b */
    private static class C0225b {
        /* renamed from: a */
        boolean f563a;
        /* renamed from: b */
        boolean f564b;
        /* renamed from: c */
        int f565c;
        /* renamed from: d */
        int f566d;
        /* renamed from: e */
        ViewGroup f567e;
        /* renamed from: f */
        ViewGroup f568f;

        private C0225b() {
        }
    }

    /* compiled from: Visibility */
    /* renamed from: android.support.transition.at$a */
    private static class C3147a extends AnimatorListenerAdapter implements C0226a, C0253c {
        /* renamed from: a */
        boolean f8082a = false;
        /* renamed from: b */
        private final View f8083b;
        /* renamed from: c */
        private final int f8084c;
        /* renamed from: d */
        private final ViewGroup f8085d;
        /* renamed from: e */
        private final boolean f8086e;
        /* renamed from: f */
        private boolean f8087f;

        /* renamed from: d */
        public void mo102d(C0254u c0254u) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        C3147a(View view, int i, boolean z) {
            this.f8083b = view;
            this.f8084c = i;
            this.f8085d = (ViewGroup) view.getParent();
            this.f8086e = z;
            m9318a(true);
        }

        public void onAnimationPause(Animator animator) {
            if (this.f8082a == null) {
                am.m577a(this.f8083b, this.f8084c);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (this.f8082a == null) {
                am.m577a(this.f8083b, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f8082a = true;
        }

        public void onAnimationEnd(Animator animator) {
            m9317a();
        }

        /* renamed from: a */
        public void mo99a(C0254u c0254u) {
            m9317a();
            c0254u.mo151b((C0253c) this);
        }

        /* renamed from: b */
        public void mo100b(C0254u c0254u) {
            m9318a((boolean) null);
        }

        /* renamed from: c */
        public void mo101c(C0254u c0254u) {
            m9318a(true);
        }

        /* renamed from: a */
        private void m9317a() {
            if (!this.f8082a) {
                am.m577a(this.f8083b, this.f8084c);
                if (this.f8085d != null) {
                    this.f8085d.invalidate();
                }
            }
            m9318a(false);
        }

        /* renamed from: a */
        private void m9318a(boolean z) {
            if (this.f8086e && this.f8087f != z && this.f8085d != null) {
                this.f8087f = z;
                af.m559a(this.f8085d, z);
            }
        }
    }

    /* renamed from: a */
    public Animator mo2653a(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        return null;
    }

    /* renamed from: b */
    public Animator mo2654b(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        return null;
    }

    /* renamed from: a */
    public void m9328a(int i) {
        if ((i & -4) == 0) {
            this.f8089h = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    /* renamed from: a */
    public String[] mo137a() {
        return f8088g;
    }

    /* renamed from: d */
    private void m9324d(aa aaVar) {
        aaVar.f541a.put("android:visibility:visibility", Integer.valueOf(aaVar.f542b.getVisibility()));
        aaVar.f541a.put("android:visibility:parent", aaVar.f542b.getParent());
        Object obj = new int[2];
        aaVar.f542b.getLocationOnScreen(obj);
        aaVar.f541a.put("android:visibility:screenLocation", obj);
    }

    /* renamed from: a */
    public void mo135a(aa aaVar) {
        m9324d(aaVar);
    }

    /* renamed from: b */
    public void mo138b(aa aaVar) {
        m9324d(aaVar);
    }

    /* renamed from: b */
    private C0225b m9323b(aa aaVar, aa aaVar2) {
        C0225b c0225b = new C0225b();
        c0225b.f563a = false;
        c0225b.f564b = false;
        if (aaVar == null || !aaVar.f541a.containsKey("android:visibility:visibility")) {
            c0225b.f565c = -1;
            c0225b.f567e = null;
        } else {
            c0225b.f565c = ((Integer) aaVar.f541a.get("android:visibility:visibility")).intValue();
            c0225b.f567e = (ViewGroup) aaVar.f541a.get("android:visibility:parent");
        }
        if (aaVar2 == null || !aaVar2.f541a.containsKey("android:visibility:visibility")) {
            c0225b.f566d = -1;
            c0225b.f568f = null;
        } else {
            c0225b.f566d = ((Integer) aaVar2.f541a.get("android:visibility:visibility")).intValue();
            c0225b.f568f = (ViewGroup) aaVar2.f541a.get("android:visibility:parent");
        }
        if (aaVar == null || aaVar2 == null) {
            if (aaVar == null && c0225b.f566d == null) {
                c0225b.f564b = true;
                c0225b.f563a = true;
            } else if (aaVar2 == null && c0225b.f565c == null) {
                c0225b.f564b = false;
                c0225b.f563a = true;
            }
        } else if (c0225b.f565c == c0225b.f566d && c0225b.f567e == c0225b.f568f) {
            return c0225b;
        } else {
            if (c0225b.f565c != c0225b.f566d) {
                if (c0225b.f565c == null) {
                    c0225b.f564b = false;
                    c0225b.f563a = true;
                } else if (c0225b.f566d == null) {
                    c0225b.f564b = true;
                    c0225b.f563a = true;
                }
            } else if (c0225b.f568f == null) {
                c0225b.f564b = false;
                c0225b.f563a = true;
            } else if (c0225b.f567e == null) {
                c0225b.f564b = true;
                c0225b.f563a = true;
            }
        }
        return c0225b;
    }

    /* renamed from: a */
    public Animator mo134a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        C0225b b = m9323b(aaVar, aaVar2);
        if (!b.f563a || (b.f567e == null && b.f568f == null)) {
            return null;
        }
        if (b.f564b) {
            return m9325a(viewGroup, aaVar, b.f565c, aaVar2, b.f566d);
        }
        return m9332b(viewGroup, aaVar, b.f565c, aaVar2, b.f566d);
    }

    /* renamed from: a */
    public Animator m9325a(ViewGroup viewGroup, aa aaVar, int i, aa aaVar2, int i2) {
        if ((this.f8089h & 1) == 1) {
            if (aaVar2 != null) {
                if (aaVar == null) {
                    View view = (View) aaVar2.f542b.getParent();
                    if (m9323b(m655b(view, false), m640a(view, false)).f563a != 0) {
                        return null;
                    }
                }
                return mo2653a(viewGroup, aaVar2.f542b, aaVar, aaVar2);
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public android.animation.Animator m9332b(android.view.ViewGroup r7, android.support.transition.aa r8, int r9, android.support.transition.aa r10, int r11) {
        /*
        r6 = this;
        r9 = r6.f8089h;
        r0 = 2;
        r9 = r9 & r0;
        r1 = 0;
        if (r9 == r0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        if (r8 == 0) goto L_0x000d;
    L_0x000a:
        r9 = r8.f542b;
        goto L_0x000e;
    L_0x000d:
        r9 = r1;
    L_0x000e:
        if (r10 == 0) goto L_0x0013;
    L_0x0010:
        r2 = r10.f542b;
        goto L_0x0014;
    L_0x0013:
        r2 = r1;
    L_0x0014:
        r3 = 1;
        if (r2 == 0) goto L_0x0026;
    L_0x0017:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r4 = 4;
        if (r11 != r4) goto L_0x0022;
    L_0x0021:
        goto L_0x0024;
    L_0x0022:
        if (r9 != r2) goto L_0x0029;
    L_0x0024:
        r9 = r1;
        goto L_0x0073;
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r9 = r2;
    L_0x0029:
        r2 = r1;
        goto L_0x0073;
    L_0x002b:
        if (r9 == 0) goto L_0x0071;
    L_0x002d:
        r2 = r9.getParent();
        if (r2 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0029;
    L_0x0034:
        r2 = r9.getParent();
        r2 = r2 instanceof android.view.View;
        if (r2 == 0) goto L_0x0071;
    L_0x003c:
        r2 = r9.getParent();
        r2 = (android.view.View) r2;
        r4 = r6.m640a(r2, r3);
        r5 = r6.m655b(r2, r3);
        r4 = r6.m9323b(r4, r5);
        r4 = r4.f563a;
        if (r4 != 0) goto L_0x0057;
    L_0x0052:
        r9 = android.support.transition.C0258z.m687a(r7, r9, r2);
        goto L_0x0029;
    L_0x0057:
        r4 = r2.getParent();
        if (r4 != 0) goto L_0x006f;
    L_0x005d:
        r2 = r2.getId();
        r4 = -1;
        if (r2 == r4) goto L_0x006f;
    L_0x0064:
        r2 = r7.findViewById(r2);
        if (r2 == 0) goto L_0x006f;
    L_0x006a:
        r2 = r6.e;
        if (r2 == 0) goto L_0x006f;
    L_0x006e:
        goto L_0x0029;
    L_0x006f:
        r9 = r1;
        goto L_0x0029;
    L_0x0071:
        r9 = r1;
        r2 = r9;
    L_0x0073:
        r4 = 0;
        if (r9 == 0) goto L_0x00bb;
    L_0x0076:
        if (r8 == 0) goto L_0x00bb;
    L_0x0078:
        r11 = r8.f541a;
        r1 = "android:visibility:screenLocation";
        r11 = r11.get(r1);
        r11 = (int[]) r11;
        r1 = r11[r4];
        r11 = r11[r3];
        r0 = new int[r0];
        r7.getLocationOnScreen(r0);
        r2 = r0[r4];
        r1 = r1 - r2;
        r2 = r9.getLeft();
        r1 = r1 - r2;
        r9.offsetLeftAndRight(r1);
        r0 = r0[r3];
        r11 = r11 - r0;
        r0 = r9.getTop();
        r11 = r11 - r0;
        r9.offsetTopAndBottom(r11);
        r11 = android.support.transition.af.m558a(r7);
        r11.mo2651a(r9);
        r7 = r6.mo2654b(r7, r9, r8, r10);
        if (r7 != 0) goto L_0x00b2;
    L_0x00ae:
        r11.mo2652b(r9);
        goto L_0x00ba;
    L_0x00b2:
        r8 = new android.support.transition.at$1;
        r8.<init>(r6, r11, r9);
        r7.addListener(r8);
    L_0x00ba:
        return r7;
    L_0x00bb:
        if (r2 == 0) goto L_0x00dd;
    L_0x00bd:
        r9 = r2.getVisibility();
        android.support.transition.am.m577a(r2, r4);
        r7 = r6.mo2654b(r7, r2, r8, r10);
        if (r7 == 0) goto L_0x00d9;
    L_0x00ca:
        r8 = new android.support.transition.at$a;
        r8.<init>(r2, r11, r3);
        r7.addListener(r8);
        android.support.transition.C0219a.m556a(r7, r8);
        r6.mo146a(r8);
        goto L_0x00dc;
    L_0x00d9:
        android.support.transition.am.m577a(r2, r9);
    L_0x00dc:
        return r7;
    L_0x00dd:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.at.b(android.view.ViewGroup, android.support.transition.aa, int, android.support.transition.aa, int):android.animation.Animator");
    }

    /* renamed from: a */
    public boolean mo136a(aa aaVar, aa aaVar2) {
        boolean z = false;
        if (aaVar == null && aaVar2 == null) {
            return false;
        }
        if (aaVar != null && aaVar2 != null && aaVar2.f541a.containsKey("android:visibility:visibility") != aaVar.f541a.containsKey("android:visibility:visibility")) {
            return false;
        }
        aaVar = m9323b(aaVar, aaVar2);
        if (aaVar.f563a != null && (aaVar.f565c == null || aaVar.f566d == null)) {
            z = true;
        }
        return z;
    }
}
