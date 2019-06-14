package com.google.firebase.components;

import com.google.android.gms.common.internal.C2872v;
import com.google.firebase.p244a.C5320a;
import com.google.firebase.p244a.C5321b;
import com.google.firebase.p244a.C5322c;
import com.google.firebase.p244a.C5323d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.o */
class C6906o implements C5322c, C5323d {
    /* renamed from: a */
    private final Map<Class<?>, ConcurrentHashMap<C5321b<Object>, Executor>> f24721a = new HashMap();
    /* renamed from: b */
    private Queue<C5320a<?>> f24722b = new ArrayDeque();
    /* renamed from: c */
    private final Executor f24723c;

    C6906o(Executor executor) {
        this.f24723c = executor;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m32369a(com.google.firebase.p244a.C5320a<?> r4) {
        /*
        r3 = this;
        com.google.android.gms.common.internal.C2872v.a(r4);
        monitor-enter(r3);
        r0 = r3.f24722b;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r3.f24722b;	 Catch:{ all -> 0x0033 }
        r0.add(r4);	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        return;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        r0 = r3.m32367b(r4);
        r0 = r0.iterator();
    L_0x0018:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0032;
    L_0x001e:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getValue();
        r2 = (java.util.concurrent.Executor) r2;
        r1 = com.google.firebase.components.C5348p.m22660a(r1, r4);
        r2.execute(r1);
        goto L_0x0018;
    L_0x0032:
        return;
    L_0x0033:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.o.a(com.google.firebase.a.a):void");
    }

    /* renamed from: b */
    private synchronized Set<Entry<C5321b<Object>, Executor>> m32367b(C5320a<?> c5320a) {
        Map map = (Map) this.f24721a.get(c5320a.m22586a());
        if (map == null) {
            return Collections.emptySet();
        }
        return map.entrySet();
    }

    /* renamed from: a */
    public synchronized <T> void m32371a(Class<T> cls, Executor executor, C5321b<? super T> c5321b) {
        C2872v.a(cls);
        C2872v.a(c5321b);
        C2872v.a(executor);
        if (!this.f24721a.containsKey(cls)) {
            this.f24721a.put(cls, new ConcurrentHashMap());
        }
        ((ConcurrentHashMap) this.f24721a.get(cls)).put(c5321b, executor);
    }

    /* renamed from: a */
    public <T> void mo4880a(Class<T> cls, C5321b<? super T> c5321b) {
        m32371a(cls, this.f24723c, c5321b);
    }

    /* renamed from: a */
    final void m32368a() {
        synchronized (this) {
            Queue queue;
            if (this.f24722b != null) {
                queue = this.f24722b;
                this.f24722b = null;
            } else {
                queue = null;
            }
        }
        if (r0 != null) {
            for (C5320a a : r0) {
                m32369a(a);
            }
        }
    }
}
