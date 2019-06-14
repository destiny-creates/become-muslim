package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* compiled from: ThreadState */
class ap implements C1071a {
    /* renamed from: a */
    private final C3446h[] f9190a;

    /* compiled from: ThreadState */
    /* renamed from: com.bugsnag.android.ap$1 */
    class C10741 implements Comparator<Thread> {
        /* renamed from: a */
        final /* synthetic */ ap f3027a;

        C10741(ap apVar) {
            this.f3027a = apVar;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3763a((Thread) obj, (Thread) obj2);
        }

        /* renamed from: a */
        public int m3763a(Thread thread, Thread thread2) {
            return Long.valueOf(thread.getId()).compareTo(Long.valueOf(thread2.getId()));
        }
    }

    public ap(C1091l c1091l, Thread thread, Map<Thread, StackTraceElement[]> map, Throwable th) {
        ap apVar = this;
        Thread thread2 = thread;
        Map<Thread, StackTraceElement[]> map2 = map;
        if (!map2.containsKey(thread2)) {
            map2.put(thread2, thread.getStackTrace());
        }
        if (th != null) {
            map2.put(thread2, th.getStackTrace());
        }
        long id = thread.getId();
        Thread[] a = m11051a(map2);
        apVar.f9190a = new C3446h[a.length];
        for (int i = 0; i < a.length; i++) {
            Thread thread3 = a[i];
            apVar.f9190a[i] = new C3446h(c1091l, thread3.getId(), thread3.getName(), "android", thread3.getId() == id, (StackTraceElement[]) map2.get(thread3));
        }
    }

    ap(C3446h[] c3446hArr) {
        this.f9190a = c3446hArr;
    }

    /* renamed from: a */
    private Thread[] m11051a(Map<Thread, StackTraceElement[]> map) {
        map = map.keySet();
        Thread[] threadArr = (Thread[]) map.toArray(new Thread[map.size()]);
        Arrays.sort(threadArr, new C10741(this));
        return threadArr;
    }

    public void toStream(ab abVar) {
        abVar.mo776e();
        for (C1071a a : this.f9190a) {
            abVar.m11021a(a);
        }
        abVar.mo775d();
    }
}
