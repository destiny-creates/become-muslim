package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@cm
public final class auw extends avo implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: a */
    static final String[] f28406a = new String[]{"2011", "1009", "3010"};
    /* renamed from: b */
    private final Object f28407b = new Object();
    /* renamed from: c */
    private final WeakReference<View> f28408c;
    /* renamed from: d */
    private final Map<String, WeakReference<View>> f28409d = new HashMap();
    /* renamed from: e */
    private final Map<String, WeakReference<View>> f28410e = new HashMap();
    /* renamed from: f */
    private final Map<String, WeakReference<View>> f28411f = new HashMap();
    /* renamed from: g */
    private auf f28412g;
    /* renamed from: h */
    private View f28413h;
    /* renamed from: i */
    private Point f28414i = new Point();
    /* renamed from: j */
    private Point f28415j = new Point();
    /* renamed from: k */
    private WeakReference<aks> f28416k = new WeakReference(null);

    public auw(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        ax.A();
        oh.m19964a(view, (OnGlobalLayoutListener) this);
        ax.A();
        oh.m19965a(view, (OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.f28408c = new WeakReference(view);
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.f28409d.put(str, new WeakReference(view2));
                if (!("1098".equals(str) || "3011".equals(str))) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.f28411f.putAll(this.f28409d);
        for (Entry entry2 : hashMap2.entrySet()) {
            view2 = (View) entry2.getValue();
            if (view2 != null) {
                this.f28410e.put((String) entry2.getKey(), new WeakReference(view2));
                view2.setOnTouchListener(this);
            }
        }
        this.f28411f.putAll(this.f28410e);
        asp.m18892a(view.getContext());
    }

    /* renamed from: a */
    private final int m37152a(int i) {
        synchronized (this.f28407b) {
            aph.m18683a();
            i = mi.m19874b(this.f28412g.mo3993m(), i);
        }
        return i;
    }

    /* renamed from: a */
    private final void m37153a(View view) {
        synchronized (this.f28407b) {
            if (this.f28412g != null) {
                auf f = this.f28412g instanceof aue ? ((aue) this.f28412g).m37137f() : this.f28412g;
                if (f != null) {
                    f.mo3985c(view);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m37154a(com.google.android.gms.internal.ads.auk r7) {
        /*
        r6 = this;
        r0 = r6.f28407b;
        monitor-enter(r0);
        r1 = f28406a;	 Catch:{ all -> 0x003b }
        r2 = r1.length;	 Catch:{ all -> 0x003b }
        r3 = 0;
    L_0x0007:
        if (r3 >= r2) goto L_0x001f;
    L_0x0009:
        r4 = r1[r3];	 Catch:{ all -> 0x003b }
        r5 = r6.f28411f;	 Catch:{ all -> 0x003b }
        r4 = r5.get(r4);	 Catch:{ all -> 0x003b }
        r4 = (java.lang.ref.WeakReference) r4;	 Catch:{ all -> 0x003b }
        if (r4 == 0) goto L_0x001c;
    L_0x0015:
        r1 = r4.get();	 Catch:{ all -> 0x003b }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x003b }
        goto L_0x0020;
    L_0x001c:
        r3 = r3 + 1;
        goto L_0x0007;
    L_0x001f:
        r1 = 0;
    L_0x0020:
        r2 = r1 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x003b }
        if (r2 != 0) goto L_0x0029;
    L_0x0024:
        r7.mo3989i();	 Catch:{ all -> 0x003b }
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        return;
    L_0x0029:
        r2 = new com.google.android.gms.internal.ads.auy;	 Catch:{ all -> 0x003b }
        r2.<init>(r6, r1);	 Catch:{ all -> 0x003b }
        r3 = r7 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x003b }
        if (r3 == 0) goto L_0x0036;
    L_0x0032:
        r7.m30228b(r1, r2);	 Catch:{ all -> 0x003b }
        goto L_0x0039;
    L_0x0036:
        r7.mo3972a(r1, r2);	 Catch:{ all -> 0x003b }
    L_0x0039:
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        return;
    L_0x003b:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auw.a(com.google.android.gms.internal.ads.auk):void");
    }

    /* renamed from: a */
    private final boolean m37157a(String[] strArr) {
        for (Object obj : strArr) {
            if (this.f28409d.get(obj) != null) {
                return true;
            }
        }
        for (Object obj2 : strArr) {
            if (this.f28410e.get(obj2) != null) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo4006a() {
        synchronized (this.f28407b) {
            this.f28413h = null;
            this.f28412g = null;
            this.f28414i = null;
            this.f28415j = null;
        }
    }

    /* renamed from: a */
    public final void mo4007a(C2758b c2758b) {
        synchronized (this.f28407b) {
            ViewGroup viewGroup = null;
            m37153a(null);
            Object a = C4757d.a(c2758b);
            if (a instanceof auk) {
                auf auf = (auk) a;
                if (auf.mo3982b()) {
                    int i;
                    View view;
                    View view2 = (View) this.f28408c.get();
                    if (!(this.f28412g == null || view2 == null)) {
                        if (((Boolean) aph.m18688f().m18889a(asp.bZ)).booleanValue()) {
                            this.f28412g.mo3981b(view2, this.f28411f);
                        }
                    }
                    synchronized (this.f28407b) {
                        i = 0;
                        if (this.f28412g instanceof auk) {
                            auk auk = (auk) this.f28412g;
                            View view3 = (View) this.f28408c.get();
                            if (!(auk == null || auk.mo3993m() == null || view3 == null || !ax.B().m19545c(view3.getContext()))) {
                                akw n = auk.m30242n();
                                if (n != null) {
                                    n.m30815a(false);
                                }
                                aks aks = (aks) this.f28416k.get();
                                if (!(aks == null || n == null)) {
                                    aks.m18558b(n);
                                }
                            }
                        }
                    }
                    if ((this.f28412g instanceof aue) && ((aue) this.f28412g).m37136e()) {
                        ((aue) this.f28412g).m37129a(auf);
                    } else {
                        this.f28412g = auf;
                        if (auf instanceof aue) {
                            ((aue) auf).m37129a(null);
                        }
                    }
                    String[] strArr = new String[]{"1098", "3011"};
                    while (i < 2) {
                        WeakReference weakReference = (WeakReference) this.f28411f.get(strArr[i]);
                        if (weakReference != null) {
                            view = (View) weakReference.get();
                            break;
                        }
                        i++;
                    }
                    view = null;
                    if (view == null) {
                        mt.m19924e("Ad choices asset view is not provided.");
                    } else {
                        if (view instanceof ViewGroup) {
                            viewGroup = (ViewGroup) view;
                        }
                        if (viewGroup != null) {
                            this.f28413h = auf.mo3969a((OnClickListener) this, true);
                            if (this.f28413h != null) {
                                this.f28411f.put("1007", new WeakReference(this.f28413h));
                                this.f28409d.put("1007", new WeakReference(this.f28413h));
                                viewGroup.removeAllViews();
                                viewGroup.addView(this.f28413h);
                            }
                        }
                    }
                    auf.mo6089a(view2, this.f28409d, this.f28410e, (OnTouchListener) this, (OnClickListener) this);
                    jw.f15691a.post(new aux(this, auf));
                    m37153a(view2);
                    this.f28412g.mo3980b(view2);
                    synchronized (this.f28407b) {
                        if (this.f28412g instanceof auk) {
                            auk auk2 = (auk) this.f28412g;
                            view = (View) this.f28408c.get();
                            if (!(auk2 == null || auk2.mo3993m() == null || view == null || !ax.B().m19545c(view.getContext()))) {
                                aks aks2 = (aks) this.f28416k.get();
                                if (aks2 == null) {
                                    aks2 = new aks(view.getContext(), view);
                                    this.f28416k = new WeakReference(aks2);
                                }
                                aks2.m18557a(auk2.m30242n());
                            }
                        }
                    }
                    return;
                }
                mt.m19920c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            mt.m19924e("Not an instance of native engine. This is most likely a transient error");
        }
    }

    /* renamed from: b */
    public final void mo4008b(C2758b c2758b) {
        synchronized (this.f28407b) {
            this.f28412g.mo3971a((View) C4757d.a(c2758b));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r9) {
        /*
        r8 = this;
        r0 = r8.f28407b;
        monitor-enter(r0);
        r1 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0009:
        r1 = r8.f28408c;	 Catch:{ all -> 0x0090 }
        r1 = r1.get();	 Catch:{ all -> 0x0090 }
        r7 = r1;
        r7 = (android.view.View) r7;	 Catch:{ all -> 0x0090 }
        if (r7 != 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0016:
        r5 = new android.os.Bundle;	 Catch:{ all -> 0x0090 }
        r5.<init>();	 Catch:{ all -> 0x0090 }
        r1 = "x";
        r2 = r8.f28414i;	 Catch:{ all -> 0x0090 }
        r2 = r2.x;	 Catch:{ all -> 0x0090 }
        r2 = r8.m37152a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "y";
        r2 = r8.f28414i;	 Catch:{ all -> 0x0090 }
        r2 = r2.y;	 Catch:{ all -> 0x0090 }
        r2 = r8.m37152a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "start_x";
        r2 = r8.f28415j;	 Catch:{ all -> 0x0090 }
        r2 = r2.x;	 Catch:{ all -> 0x0090 }
        r2 = r8.m37152a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "start_y";
        r2 = r8.f28415j;	 Catch:{ all -> 0x0090 }
        r2 = r2.y;	 Catch:{ all -> 0x0090 }
        r2 = r8.m37152a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = r8.f28413h;	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0087;
    L_0x0057:
        r1 = r8.f28413h;	 Catch:{ all -> 0x0090 }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0087;
    L_0x005f:
        r1 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        r1 = r1 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0080;
    L_0x0065:
        r1 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        r1 = (com.google.android.gms.internal.ads.aue) r1;	 Catch:{ all -> 0x0090 }
        r1 = r1.m37137f();	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x008e;
    L_0x006f:
        r1 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        r1 = (com.google.android.gms.internal.ads.aue) r1;	 Catch:{ all -> 0x0090 }
        r2 = r1.m37137f();	 Catch:{ all -> 0x0090 }
        r4 = "1007";
        r6 = r8.f28411f;	 Catch:{ all -> 0x0090 }
    L_0x007b:
        r3 = r9;
        r2.mo3973a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0090 }
        goto L_0x008e;
    L_0x0080:
        r2 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        r4 = "1007";
        r6 = r8.f28411f;	 Catch:{ all -> 0x0090 }
        goto L_0x007b;
    L_0x0087:
        r1 = r8.f28412g;	 Catch:{ all -> 0x0090 }
        r2 = r8.f28411f;	 Catch:{ all -> 0x0090 }
        r1.mo3975a(r9, r2, r5, r7);	 Catch:{ all -> 0x0090 }
    L_0x008e:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0090:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auw.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.f28407b) {
            if (this.f28412g != null) {
                View view = (View) this.f28408c.get();
                if (view != null) {
                    this.f28412g.mo3986c(view, this.f28411f);
                }
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.f28407b) {
            if (this.f28412g != null) {
                View view = (View) this.f28408c.get();
                if (view != null) {
                    this.f28412g.mo3986c(view, this.f28411f);
                }
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f28407b) {
            if (this.f28412g == null) {
                return false;
            }
            View view2 = (View) this.f28408c.get();
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
            this.f28414i = point;
            if (motionEvent.getAction() == 0) {
                this.f28415j = point;
            }
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setLocation((float) point.x, (float) point.y);
            this.f28412g.mo3970a(motionEvent);
            motionEvent.recycle();
            return false;
        }
    }
}
