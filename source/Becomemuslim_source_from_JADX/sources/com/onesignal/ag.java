package com.onesignal;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OSObservable */
class ag<ObserverType, StateType> {
    /* renamed from: a */
    private String f18313a;
    /* renamed from: b */
    private List<Object> f18314b = new ArrayList();
    /* renamed from: c */
    private boolean f18315c;

    ag(String str, boolean z) {
        this.f18313a = str;
        this.f18315c = z;
    }

    /* renamed from: a */
    void m23072a(ObserverType observerType) {
        this.f18314b.add(new WeakReference(observerType));
    }

    /* renamed from: b */
    void m23073b(ObserverType observerType) {
        this.f18314b.add(observerType);
    }

    /* renamed from: c */
    boolean m23074c(final StateType stateType) {
        boolean z = false;
        for (Object next : this.f18314b) {
            Object next2;
            if (next2 instanceof WeakReference) {
                next2 = ((WeakReference) next2).get();
            }
            if (next2 != null) {
                try {
                    final Method declaredMethod = next2.getClass().getDeclaredMethod(this.f18313a, new Class[]{stateType.getClass()});
                    declaredMethod.setAccessible(true);
                    if (this.f18315c) {
                        al.m23090a(new Runnable(this) {
                            /* renamed from: d */
                            final /* synthetic */ ag f18312d;

                            public void run() {
                                try {
                                    declaredMethod.invoke(next2, new Object[]{stateType});
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        });
                    } else {
                        declaredMethod.invoke(next2, new Object[]{stateType});
                    }
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }
}
