package p289e.p292c.p295e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import p289e.p290a.C5902a;

/* compiled from: ExceptionsUtils */
/* renamed from: e.c.e.d */
public enum C5960d {
    ;
    
    /* renamed from: a */
    private static final Throwable f19709a = null;

    static {
        f19709a = new Throwable("Terminated");
    }

    /* renamed from: a */
    public static boolean m24929a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Object obj;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f19709a) {
                return false;
            }
            if (th2 == null) {
                obj = th;
            } else if (th2 instanceof C5902a) {
                Collection arrayList = new ArrayList(((C5902a) th2).m24787a());
                arrayList.add(th);
                obj = new C5902a(arrayList);
            } else {
                obj = new C5902a(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, obj));
        return true;
    }

    /* renamed from: a */
    public static Throwable m24927a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        return th != f19709a ? (Throwable) atomicReference.getAndSet(f19709a) : th;
    }

    /* renamed from: a */
    public static boolean m24928a(Throwable th) {
        return th == f19709a ? true : null;
    }
}
