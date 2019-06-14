package android.support.transition;

import android.support.v4.util.C3211a;
import android.support.v4.view.C0517s;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
/* renamed from: android.support.transition.w */
public class C0256w {
    /* renamed from: a */
    private static C0254u f651a = new C4446e();
    /* renamed from: b */
    private static ThreadLocal<WeakReference<C3211a<ViewGroup, ArrayList<C0254u>>>> f652b = new ThreadLocal();
    /* renamed from: c */
    private static ArrayList<ViewGroup> f653c = new ArrayList();

    /* compiled from: TransitionManager */
    /* renamed from: android.support.transition.w$a */
    private static class C0255a implements OnAttachStateChangeListener, OnPreDrawListener {
        /* renamed from: a */
        C0254u f649a;
        /* renamed from: b */
        ViewGroup f650b;

        public void onViewAttachedToWindow(View view) {
        }

        C0255a(C0254u c0254u, ViewGroup viewGroup) {
            this.f649a = c0254u;
            this.f650b = viewGroup;
        }

        /* renamed from: a */
        private void m676a() {
            this.f650b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f650b.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            m676a();
            C0256w.f653c.remove(this.f650b);
            ArrayList arrayList = (ArrayList) C0256w.m677a().get(this.f650b);
            if (arrayList != null && arrayList.size() > 0) {
                view = arrayList.iterator();
                while (view.hasNext()) {
                    ((C0254u) view.next()).mo158e(this.f650b);
                }
            }
            this.f649a.m650a(true);
        }

        public boolean onPreDraw() {
            m676a();
            if (!C0256w.f653c.remove(this.f650b)) {
                return true;
            }
            final C3211a a = C0256w.m677a();
            ArrayList arrayList = (ArrayList) a.get(this.f650b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(this.f650b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f649a);
            this.f649a.mo146a(new C3156v(this) {
                /* renamed from: b */
                final /* synthetic */ C0255a f11895b;

                /* renamed from: a */
                public void mo99a(C0254u c0254u) {
                    ((ArrayList) a.get(this.f11895b.f650b)).remove(c0254u);
                }
            });
            this.f649a.m649a(this.f650b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C0254u) it.next()).mo158e(this.f650b);
                }
            }
            this.f649a.m647a(this.f650b);
            return true;
        }
    }

    /* renamed from: a */
    static C3211a<ViewGroup, ArrayList<C0254u>> m677a() {
        WeakReference weakReference = (WeakReference) f652b.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference weakReference2 = new WeakReference(new C3211a());
            f652b.set(weakReference2);
            weakReference = weakReference2;
        }
        return (C3211a) weakReference.get();
    }

    /* renamed from: b */
    private static void m680b(ViewGroup viewGroup, C0254u c0254u) {
        if (c0254u != null && viewGroup != null) {
            Object c0255a = new C0255a(c0254u, viewGroup);
            viewGroup.addOnAttachStateChangeListener(c0255a);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(c0255a);
        }
    }

    /* renamed from: c */
    private static void m681c(ViewGroup viewGroup, C0254u c0254u) {
        ArrayList arrayList = (ArrayList) C0256w.m677a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0254u) it.next()).mo156d(viewGroup);
            }
        }
        if (c0254u != null) {
            c0254u.m649a(viewGroup, true);
        }
        viewGroup = C0248t.m620a(viewGroup);
        if (viewGroup != null) {
            viewGroup.m622a();
        }
    }

    /* renamed from: a */
    public static void m678a(ViewGroup viewGroup, C0254u c0254u) {
        if (!f653c.contains(viewGroup) && C0517s.m1730x(viewGroup)) {
            f653c.add(viewGroup);
            if (c0254u == null) {
                c0254u = f651a;
            }
            c0254u = c0254u.mo159m();
            C0256w.m681c(viewGroup, c0254u);
            C0248t.m621a(viewGroup, null);
            C0256w.m680b(viewGroup, c0254u);
        }
    }
}
