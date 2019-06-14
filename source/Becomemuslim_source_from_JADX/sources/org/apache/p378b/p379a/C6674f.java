package org.apache.p378b.p379a;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.p378b.p379a.p381c.C6656j;
import org.apache.p378b.p379a.p381c.C7688k;
import org.apache.p378b.p379a.p382d.C8277c;

/* compiled from: ThreadContext */
/* renamed from: org.apache.b.a.f */
public final class C6674f {
    /* renamed from: a */
    public static final Map<String, String> f21425a = Collections.emptyMap();
    /* renamed from: b */
    public static final C7688k f21426b = new C8195c();
    /* renamed from: c */
    private static boolean f21427c;
    /* renamed from: d */
    private static boolean f21428d;
    /* renamed from: e */
    private static boolean f21429e;
    /* renamed from: f */
    private static C6656j f21430f;
    /* renamed from: g */
    private static C7688k f21431g;
    /* renamed from: h */
    private static final C6657c f21432h = C8277c.m42922c();

    /* compiled from: ThreadContext */
    /* renamed from: org.apache.b.a.f$a */
    public interface C6672a extends Serializable, Collection<String> {
        /* renamed from: a */
        List<String> mo6436a();
    }

    /* compiled from: ThreadContext */
    /* renamed from: org.apache.b.a.f$b */
    private static class C6673b<E> implements Iterator<E> {
        public boolean hasNext() {
            return false;
        }

        public void remove() {
        }

        private C6673b() {
        }

        public E next() {
            throw new NoSuchElementException("This is an empty iterator!");
        }
    }

    /* compiled from: ThreadContext */
    /* renamed from: org.apache.b.a.f$c */
    private static class C8195c extends AbstractCollection<String> implements C7688k {
        /* renamed from: a */
        private static final Iterator<String> f30418a = new C6673b();
        private static final long serialVersionUID = 1;

        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        public int hashCode() {
            return 1;
        }

        public int size() {
            return 0;
        }

        private C8195c() {
        }

        public /* synthetic */ boolean add(Object obj) {
            return m39797a((String) obj);
        }

        /* renamed from: a */
        public List<String> mo6436a() {
            return Collections.emptyList();
        }

        public boolean equals(Object obj) {
            return (!(obj instanceof Collection) || ((Collection) obj).isEmpty() == null) ? null : true;
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: a */
        public boolean m39797a(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends String> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public Iterator<String> iterator() {
            return f30418a;
        }
    }

    static {
        C6674f.m27136a();
    }

    /* renamed from: a */
    static void m27136a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        f21430f = r0;
        r0 = org.apache.p378b.p379a.p383e.C6666b.m27118a();
        r1 = "disableThreadContext";
        r1 = r0.m27123b(r1);
        f21427c = r1;
        r1 = "disableThreadContextStack";
        r1 = r0.m27123b(r1);
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x001f;
    L_0x0019:
        r1 = f21427c;
        if (r1 != 0) goto L_0x001f;
    L_0x001d:
        r1 = 1;
        goto L_0x0020;
    L_0x001f:
        r1 = 0;
    L_0x0020:
        f21429e = r1;
        r1 = "disableThreadContextMap";
        r1 = r0.m27123b(r1);
        if (r1 != 0) goto L_0x0030;
    L_0x002a:
        r1 = f21427c;
        if (r1 != 0) goto L_0x0030;
    L_0x002e:
        r1 = 1;
        goto L_0x0031;
    L_0x0030:
        r1 = 0;
    L_0x0031:
        f21428d = r1;
        r1 = new org.apache.b.a.c.c;
        r4 = f21429e;
        r1.<init>(r4);
        f21431g = r1;
        r1 = "log4j2.threadContextMap";
        r0 = r0.m27120a(r1);
        r1 = org.apache.p378b.p379a.p383e.C6667c.m27129d();
        r4 = 2;
        if (r0 == 0) goto L_0x0078;
    L_0x0049:
        r1 = r1.loadClass(r0);	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        r5 = org.apache.p378b.p379a.p381c.C6656j.class;	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        r5 = r5.isAssignableFrom(r1);	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        if (r5 == 0) goto L_0x0078;	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
    L_0x0055:
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        r1 = (org.apache.p378b.p379a.p381c.C6656j) r1;	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        f21430f = r1;	 Catch:{ ClassNotFoundException -> 0x006d, Exception -> 0x005e }
        goto L_0x0078;
    L_0x005e:
        r1 = move-exception;
        r5 = f21432h;
        r6 = "Unable to create configured ThreadContextMap {}";
        r7 = new java.lang.Object[r4];
        r7[r3] = r0;
        r7[r2] = r1;
        r5.mo6431b(r6, r7);
        goto L_0x0078;
    L_0x006d:
        r1 = f21432h;
        r5 = "Unable to locate configured ThreadContextMap {}";
        r6 = new java.lang.Object[r2];
        r6[r3] = r0;
        r1.mo6431b(r5, r6);
    L_0x0078:
        r0 = f21430f;
        if (r0 != 0) goto L_0x00d7;
    L_0x007c:
        r0 = org.apache.p378b.p379a.p383e.C6667c.m27127b();
        if (r0 == 0) goto L_0x00d7;
    L_0x0082:
        r0 = org.apache.p378b.p379a.C6650b.m27076a();
        r0 = r0.getClass();
        r0 = r0.getName();
        r1 = org.apache.p378b.p379a.p383e.C6667c.m27124a();
        r1 = r1.iterator();
    L_0x0096:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x00d7;
    L_0x009c:
        r5 = r1.next();
        r5 = (org.apache.p378b.p379a.p381c.C6654h) r5;
        r6 = r5.m27082b();
        r6 = r0.equals(r6);
        if (r6 == 0) goto L_0x0096;
    L_0x00ac:
        r6 = r5.m27085e();
        if (r6 == 0) goto L_0x0096;
    L_0x00b2:
        r6 = r6.newInstance();	 Catch:{ Exception -> 0x00bb }
        r6 = (org.apache.p378b.p379a.p381c.C6656j) r6;	 Catch:{ Exception -> 0x00bb }
        f21430f = r6;	 Catch:{ Exception -> 0x00bb }
        goto L_0x00d7;
    L_0x00bb:
        r6 = move-exception;
        r7 = f21432h;
        r8 = "Unable to locate or load configured ThreadContextMap {}";
        r9 = new java.lang.Object[r4];
        r5 = r5.m27084d();
        r9[r3] = r5;
        r9[r2] = r6;
        r7.mo6431b(r8, r9);
        r5 = new org.apache.b.a.c.b;
        r6 = f21428d;
        r5.<init>(r6);
        f21430f = r5;
        goto L_0x0096;
    L_0x00d7:
        r0 = f21430f;
        if (r0 != 0) goto L_0x00e4;
    L_0x00db:
        r0 = new org.apache.b.a.c.b;
        r1 = f21428d;
        r0.<init>(r1);
        f21430f = r0;
    L_0x00e4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.f.a():void");
    }

    /* renamed from: b */
    public static Map<String, String> m27137b() {
        return f21430f.mo5704a();
    }
}
