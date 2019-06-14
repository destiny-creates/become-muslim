package p289e.p290a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: CompositeException */
/* renamed from: e.a.a */
public final class C5902a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    /* renamed from: a */
    private final List<Throwable> f19626a;
    /* renamed from: b */
    private final String f19627b;
    /* renamed from: c */
    private Throwable f19628c;

    /* compiled from: CompositeException */
    /* renamed from: e.a.a$a */
    static final class C5900a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        C5900a() {
        }
    }

    /* compiled from: CompositeException */
    /* renamed from: e.a.a$b */
    static abstract class C5901b {
        /* renamed from: a */
        abstract Object mo5117a();

        /* renamed from: a */
        abstract void mo5118a(Object obj);

        C5901b() {
        }
    }

    /* compiled from: CompositeException */
    /* renamed from: e.a.a$c */
    static final class C7231c extends C5901b {
        /* renamed from: a */
        private final PrintStream f25514a;

        C7231c(PrintStream printStream) {
            this.f25514a = printStream;
        }

        /* renamed from: a */
        Object mo5117a() {
            return this.f25514a;
        }

        /* renamed from: a */
        void mo5118a(Object obj) {
            this.f25514a.println(obj);
        }
    }

    /* compiled from: CompositeException */
    /* renamed from: e.a.a$d */
    static final class C7232d extends C5901b {
        /* renamed from: a */
        private final PrintWriter f25515a;

        C7232d(PrintWriter printWriter) {
            this.f25515a = printWriter;
        }

        /* renamed from: a */
        Object mo5117a() {
            return this.f25515a;
        }

        /* renamed from: a */
        void mo5118a(Object obj) {
            this.f25515a.println(obj);
        }
    }

    @Deprecated
    public C5902a(String str, Collection<? extends Throwable> collection) {
        str = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof C5902a) {
                    str.addAll(((C5902a) th).m24787a());
                } else if (th != null) {
                    str.add(th);
                } else {
                    str.add(new NullPointerException());
                }
            }
        } else {
            str.add(new NullPointerException());
        }
        arrayList.addAll(str);
        this.f19626a = Collections.unmodifiableList(arrayList);
        str = new StringBuilder();
        str.append(this.f19626a.size());
        str.append(" exceptions occurred. ");
        this.f19627b = str.toString();
    }

    public C5902a(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public C5902a(Throwable... thArr) {
        Collection linkedHashSet = new LinkedHashSet();
        List arrayList = new ArrayList();
        if (thArr != null) {
            for (Object obj : thArr) {
                if (obj instanceof C5902a) {
                    linkedHashSet.addAll(((C5902a) obj).m24787a());
                } else if (obj != null) {
                    linkedHashSet.add(obj);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.f19626a = Collections.unmodifiableList(arrayList);
        thArr = new StringBuilder();
        thArr.append(this.f19626a.size());
        thArr.append(" exceptions occurred. ");
        this.f19627b = thArr.toString();
    }

    /* renamed from: a */
    public List<Throwable> m24787a() {
        return this.f19626a;
    }

    public String getMessage() {
        return this.f19627b;
    }

    public synchronized java.lang.Throwable getCause() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f19628c;	 Catch:{ all -> 0x0060 }
        if (r0 != 0) goto L_0x005c;	 Catch:{ all -> 0x0060 }
    L_0x0005:
        r0 = new e.a.a$a;	 Catch:{ all -> 0x0060 }
        r0.<init>();	 Catch:{ all -> 0x0060 }
        r1 = new java.util.HashSet;	 Catch:{ all -> 0x0060 }
        r1.<init>();	 Catch:{ all -> 0x0060 }
        r2 = r8.f19626a;	 Catch:{ all -> 0x0060 }
        r2 = r2.iterator();	 Catch:{ all -> 0x0060 }
        r3 = r0;	 Catch:{ all -> 0x0060 }
    L_0x0016:
        r4 = r2.hasNext();	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x005a;	 Catch:{ all -> 0x0060 }
    L_0x001c:
        r4 = r2.next();	 Catch:{ all -> 0x0060 }
        r4 = (java.lang.Throwable) r4;	 Catch:{ all -> 0x0060 }
        r5 = r1.contains(r4);	 Catch:{ all -> 0x0060 }
        if (r5 == 0) goto L_0x0029;	 Catch:{ all -> 0x0060 }
    L_0x0028:
        goto L_0x0016;	 Catch:{ all -> 0x0060 }
    L_0x0029:
        r1.add(r4);	 Catch:{ all -> 0x0060 }
        r5 = r8.m24783a(r4);	 Catch:{ all -> 0x0060 }
        r5 = r5.iterator();	 Catch:{ all -> 0x0060 }
    L_0x0034:
        r6 = r5.hasNext();	 Catch:{ all -> 0x0060 }
        if (r6 == 0) goto L_0x0052;	 Catch:{ all -> 0x0060 }
    L_0x003a:
        r6 = r5.next();	 Catch:{ all -> 0x0060 }
        r6 = (java.lang.Throwable) r6;	 Catch:{ all -> 0x0060 }
        r7 = r1.contains(r6);	 Catch:{ all -> 0x0060 }
        if (r7 == 0) goto L_0x004e;	 Catch:{ all -> 0x0060 }
    L_0x0046:
        r4 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0060 }
        r6 = "Duplicate found in causal chain so cropping to prevent loop ...";	 Catch:{ all -> 0x0060 }
        r4.<init>(r6);	 Catch:{ all -> 0x0060 }
        goto L_0x0034;	 Catch:{ all -> 0x0060 }
    L_0x004e:
        r1.add(r6);	 Catch:{ all -> 0x0060 }
        goto L_0x0034;
    L_0x0052:
        r3.initCause(r4);	 Catch:{ Throwable -> 0x0055 }
    L_0x0055:
        r3 = r8.m24786b(r3);	 Catch:{ all -> 0x0060 }
        goto L_0x0016;	 Catch:{ all -> 0x0060 }
    L_0x005a:
        r8.f19628c = r0;	 Catch:{ all -> 0x0060 }
    L_0x005c:
        r0 = r8.f19628c;	 Catch:{ all -> 0x0060 }
        monitor-exit(r8);
        return r0;
    L_0x0060:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.getCause():java.lang.Throwable");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        m24784a(new C7231c(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        m24784a(new C7232d(printWriter));
    }

    /* renamed from: a */
    private void m24784a(C5901b c5901b) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (Object obj : getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        int i = 1;
        for (Throwable th : this.f19626a) {
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(i);
            stringBuilder.append(" :\n");
            m24785a(stringBuilder, th, "\t");
            i++;
        }
        synchronized (c5901b.mo5117a()) {
            c5901b.mo5118a(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private void m24785a(StringBuilder stringBuilder, Throwable th, String str) {
        stringBuilder.append(str);
        stringBuilder.append(th);
        stringBuilder.append('\n');
        for (Object obj : th.getStackTrace()) {
            stringBuilder.append("\t\tat ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
        if (th.getCause() != null) {
            stringBuilder.append("\tCaused by: ");
            m24785a(stringBuilder, th.getCause(), "");
        }
    }

    /* renamed from: a */
    private List<Throwable> m24783a(Throwable th) {
        List<Throwable> arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null) {
            if (cause != th) {
                while (true) {
                    arrayList.add(cause);
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private Throwable m24786b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            if (cause != th) {
                while (true) {
                    th = cause.getCause();
                    if (th == null) {
                        break;
                    } else if (th == cause) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                }
                return cause;
            }
        }
        return th;
    }
}
