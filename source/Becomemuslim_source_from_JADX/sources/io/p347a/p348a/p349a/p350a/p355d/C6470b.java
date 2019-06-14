package io.p347a.p348a.p349a.p350a.p355d;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager */
/* renamed from: io.a.a.a.a.d.b */
public abstract class C6470b<T> {
    /* renamed from: a */
    protected final Context f20869a;
    /* renamed from: b */
    protected final C6467a<T> f20870b;
    /* renamed from: c */
    protected final C6430k f20871c;
    /* renamed from: d */
    protected final C6471c f20872d;
    /* renamed from: e */
    protected volatile long f20873e;
    /* renamed from: f */
    protected final List<C6472d> f20874f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private final int f20875g;

    /* compiled from: EventsFilesManager */
    /* renamed from: io.a.a.a.a.d.b$1 */
    class C64681 implements Comparator<C6469a> {
        /* renamed from: a */
        final /* synthetic */ C6470b f20866a;

        C64681(C6470b c6470b) {
            this.f20866a = c6470b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m26494a((C6469a) obj, (C6469a) obj2);
        }

        /* renamed from: a */
        public int m26494a(C6469a c6469a, C6469a c6469a2) {
            return (int) (c6469a.f20868b - c6469a2.f20868b);
        }
    }

    /* compiled from: EventsFilesManager */
    /* renamed from: io.a.a.a.a.d.b$a */
    static class C6469a {
        /* renamed from: a */
        final File f20867a;
        /* renamed from: b */
        final long f20868b;

        public C6469a(File file, long j) {
            this.f20867a = file;
            this.f20868b = j;
        }
    }

    /* renamed from: a */
    protected abstract String m26498a();

    /* renamed from: c */
    protected int m26503c() {
        return 8000;
    }

    public C6470b(Context context, C6467a<T> c6467a, C6430k c6430k, C6471c c6471c, int i) {
        this.f20869a = context.getApplicationContext();
        this.f20870b = c6467a;
        this.f20872d = c6471c;
        this.f20871c = c6430k;
        this.f20873e = this.f20871c.mo5438a();
        this.f20875g = i;
    }

    /* renamed from: a */
    public void m26500a(T t) {
        byte[] a = this.f20870b.m26493a(t);
        m26495a(a.length);
        this.f20872d.mo5451a(a);
    }

    /* renamed from: a */
    public void m26499a(C6472d c6472d) {
        if (c6472d != null) {
            this.f20874f.add(c6472d);
        }
    }

    /* renamed from: d */
    public boolean m26504d() {
        String str;
        boolean z = true;
        if (this.f20872d.mo5453b()) {
            str = null;
            z = false;
        } else {
            str = m26498a();
            this.f20872d.mo5449a(str);
            C6428i.m26363a(this.f20869a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f20873e = this.f20871c.mo5438a();
        }
        m26496b(str);
        return z;
    }

    /* renamed from: a */
    private void m26495a(int i) {
        if (!this.f20872d.mo5452a(i, m26503c())) {
            C6428i.m26363a(this.f20869a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f20872d.mo5447a()), Integer.valueOf(i), Integer.valueOf(m26503c())}));
            m26504d();
        }
    }

    /* renamed from: b */
    protected int m26502b() {
        return this.f20875g;
    }

    /* renamed from: b */
    private void m26496b(String str) {
        for (C6472d a : this.f20874f) {
            try {
                a.m26517a(str);
            } catch (Throwable e) {
                C6428i.m26365a(this.f20869a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    /* renamed from: e */
    public List<File> m26505e() {
        return this.f20872d.mo5448a(1);
    }

    /* renamed from: a */
    public void m26501a(List<File> list) {
        this.f20872d.mo5450a((List) list);
    }

    /* renamed from: f */
    public void m26506f() {
        this.f20872d.mo5450a(this.f20872d.mo5454c());
        this.f20872d.mo5455d();
    }

    /* renamed from: g */
    public void m26507g() {
        List<File> c = this.f20872d.mo5454c();
        int b = m26502b();
        if (c.size() > b) {
            int size = c.size() - b;
            C6428i.m26364a(this.f20869a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C64681(this));
            for (File file : c) {
                treeSet.add(new C6469a(file, m26497a(file.getName())));
            }
            List c2 = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                c2.add(((C6469a) it.next()).f20867a);
                if (c2.size() == size) {
                    break;
                }
            }
            this.f20872d.mo5450a(c2);
        }
    }

    /* renamed from: a */
    public long m26497a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = "_";
        r6 = r6.split(r0);
        r0 = r6.length;
        r1 = 0;
        r3 = 3;
        if (r0 == r3) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = 2;
        r6 = r6[r0];	 Catch:{ NumberFormatException -> 0x0019 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ NumberFormatException -> 0x0019 }
        r3 = r6.longValue();	 Catch:{ NumberFormatException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.d.b.a(java.lang.String):long");
    }
}
