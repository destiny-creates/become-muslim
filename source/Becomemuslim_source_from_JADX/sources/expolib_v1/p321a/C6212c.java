package expolib_v1.p321a;

import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.p322a.p323a.C6139b;
import expolib_v1.p321a.p322a.p323a.C6141c;
import expolib_v1.p321a.p322a.p323a.C6146d;
import expolib_v1.p321a.p322a.p323a.C6146d.C6143a;
import expolib_v1.p321a.p322a.p323a.C6146d.C6145c;
import expolib_v1.p321a.p322a.p323a.C6147f;
import expolib_v1.p321a.p322a.p325c.C6160e;
import expolib_v1.p321a.p322a.p325c.C6163k;
import expolib_v1.p321a.p322a.p328f.C6188a;
import expolib_v1.p321a.p322a.p329g.C6192e;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C7498g;
import expolib_v1.p332b.C7499h;
import expolib_v1.p332b.C8170c;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Cache */
/* renamed from: expolib_v1.a.c */
public final class C6212c implements Closeable, Flushable {
    /* renamed from: a */
    final C6147f f20149a;
    /* renamed from: b */
    final C6146d f20150b;
    /* renamed from: c */
    int f20151c;
    /* renamed from: d */
    int f20152d;
    /* renamed from: e */
    private int f20153e;
    /* renamed from: f */
    private int f20154f;
    /* renamed from: g */
    private int f20155g;

    /* compiled from: Cache */
    /* renamed from: expolib_v1.a.c$c */
    private static final class C6211c {
        /* renamed from: a */
        private static final String f20137a;
        /* renamed from: b */
        private static final String f20138b;
        /* renamed from: c */
        private final String f20139c;
        /* renamed from: d */
        private final C6234q f20140d;
        /* renamed from: e */
        private final String f20141e;
        /* renamed from: f */
        private final C6244x f20142f;
        /* renamed from: g */
        private final int f20143g;
        /* renamed from: h */
        private final String f20144h;
        /* renamed from: i */
        private final C6234q f20145i;
        /* renamed from: j */
        private final C6232p f20146j;
        /* renamed from: k */
        private final long f20147k;
        /* renamed from: l */
        private final long f20148l;

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C6192e.m25495b().m25507c());
            stringBuilder.append("-Sent-Millis");
            f20137a = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(C6192e.m25495b().m25507c());
            stringBuilder.append("-Received-Millis");
            f20138b = stringBuilder.toString();
        }

        public C6211c(C6258s c6258s) {
            try {
                C7497e a = C6252l.m25859a(c6258s);
                this.f20139c = a.mo6401s();
                this.f20141e = a.mo6401s();
                C6233a c6233a = new C6233a();
                int a2 = C6212c.m25607a(a);
                for (int i = 0; i < a2; i++) {
                    c6233a.m25707a(a.mo6401s());
                }
                this.f20140d = c6233a.m25709a();
                C6163k a3 = C6163k.m25301a(a.mo6401s());
                this.f20142f = a3.f19904a;
                this.f20143g = a3.f19905b;
                this.f20144h = a3.f19906c;
                c6233a = new C6233a();
                a2 = C6212c.m25607a(a);
                for (int i2 = 0; i2 < a2; i2++) {
                    c6233a.m25707a(a.mo6401s());
                }
                String c = c6233a.m25713c(f20137a);
                String c2 = c6233a.m25713c(f20138b);
                c6233a.m25710b(f20137a);
                c6233a.m25710b(f20138b);
                long j = 0;
                this.f20147k = c != null ? Long.parseLong(c) : 0;
                if (c2 != null) {
                    j = Long.parseLong(c2);
                }
                this.f20148l = j;
                this.f20145i = c6233a.m25709a();
                ae aeVar = null;
                if (m25603a()) {
                    String s = a.mo6401s();
                    if (s.length() <= 0) {
                        C6221h a4 = C6221h.m25646a(a.mo6401s());
                        List a5 = m25601a(a);
                        List a6 = m25601a(a);
                        if (!a.mo6382f()) {
                            aeVar = ae.m25595a(a.mo6401s());
                        }
                        this.f20146j = C6232p.m25700a(aeVar, a4, a5, a6);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected \"\" but was \"");
                        stringBuilder.append(s);
                        stringBuilder.append("\"");
                        throw new IOException(stringBuilder.toString());
                    }
                }
                this.f20146j = null;
                c6258s.close();
            } catch (Throwable th) {
                c6258s.close();
            }
        }

        public C6211c(ab abVar) {
            this.f20139c = abVar.m25576a().m25821a().toString();
            this.f20140d = C6160e.m25289c(abVar);
            this.f20141e = abVar.m25576a().m25823b();
            this.f20142f = abVar.m25579b();
            this.f20143g = abVar.m25580c();
            this.f20144h = abVar.m25582e();
            this.f20145i = abVar.m25584g();
            this.f20146j = abVar.m25583f();
            this.f20147k = abVar.m25589l();
            this.f20148l = abVar.m25590m();
        }

        /* renamed from: a */
        public void m25605a(C6143a c6143a) {
            int i = 0;
            C7496d a = C6252l.m25858a(c6143a.m25184a(0));
            a.mo6373b(this.f20139c).mo6389i(10);
            a.mo6373b(this.f20141e).mo6389i(10);
            a.mo6394m((long) this.f20140d.m25716a()).mo6389i(10);
            int a2 = this.f20140d.m25716a();
            for (int i2 = 0; i2 < a2; i2++) {
                a.mo6373b(this.f20140d.m25717a(i2)).mo6373b(": ").mo6373b(this.f20140d.m25720b(i2)).mo6389i(10);
            }
            a.mo6373b(new C6163k(this.f20142f, this.f20143g, this.f20144h).toString()).mo6389i(10);
            a.mo6394m((long) (this.f20145i.m25716a() + 2)).mo6389i(10);
            a2 = this.f20145i.m25716a();
            while (i < a2) {
                a.mo6373b(this.f20145i.m25717a(i)).mo6373b(": ").mo6373b(this.f20145i.m25720b(i)).mo6389i(10);
                i++;
            }
            a.mo6373b(f20137a).mo6373b(": ").mo6394m(this.f20147k).mo6389i(10);
            a.mo6373b(f20138b).mo6373b(": ").mo6394m(this.f20148l).mo6389i(10);
            if (m25603a()) {
                a.mo6389i(10);
                a.mo6373b(this.f20146j.m25703b().m25648a()).mo6389i(10);
                m25602a(a, this.f20146j.m25704c());
                m25602a(a, this.f20146j.m25705d());
                if (this.f20146j.m25702a() != null) {
                    a.mo6373b(this.f20146j.m25702a().m25596a()).mo6389i(10);
                }
            }
            a.close();
        }

        /* renamed from: a */
        private boolean m25603a() {
            return this.f20139c.startsWith("https://");
        }

        /* renamed from: a */
        private List<Certificate> m25601a(C7497e c7497e) {
            int a = C6212c.m25607a(c7497e);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String s = c7497e.mo6401s();
                    C8170c c8170c = new C8170c();
                    c8170c.m39590a(C6251f.m25839b(s));
                    arrayList.add(instance.generateCertificate(c8170c.mo6384g()));
                }
                return arrayList;
            } catch (C7497e c7497e2) {
                throw new IOException(c7497e2.getMessage());
            }
        }

        /* renamed from: a */
        private void m25602a(C7496d c7496d, List<Certificate> list) {
            try {
                c7496d.mo6394m((long) list.size()).mo6389i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    c7496d.mo6373b(C6251f.m25838a(((Certificate) list.get(i)).getEncoded()).mo5359b()).mo6389i(10);
                }
            } catch (C7496d c7496d2) {
                throw new IOException(c7496d2.getMessage());
            }
        }

        /* renamed from: a */
        public boolean m25606a(C6246z c6246z, ab abVar) {
            return (this.f20139c.equals(c6246z.m25821a().toString()) && this.f20141e.equals(c6246z.m25823b()) && C6160e.m25285a(abVar, this.f20140d, c6246z) != null) ? true : null;
        }

        /* renamed from: a */
        public ab m25604a(C6145c c6145c) {
            String a = this.f20145i.m25718a(HttpHeaders.CONTENT_TYPE);
            String a2 = this.f20145i.m25718a(HttpHeaders.CONTENT_LENGTH);
            return new C6208a().m25567a(new C6245a().m25814a(this.f20139c).m25815a(this.f20141e, null).m25811a(this.f20140d).m25820b()).m25566a(this.f20142f).m25560a(this.f20143g).m25568a(this.f20144h).m25565a(this.f20145i).m25563a(new C7484b(c6145c, a, a2)).m25564a(this.f20146j).m25561a(this.f20147k).m25571b(this.f20148l).m25570a();
        }
    }

    /* compiled from: Cache */
    /* renamed from: expolib_v1.a.c$1 */
    class C74821 implements C6147f {
        /* renamed from: a */
        final /* synthetic */ C6212c f25968a;

        C74821(C6212c c6212c) {
            this.f25968a = c6212c;
        }

        /* renamed from: a */
        public ab mo5318a(C6246z c6246z) {
            return this.f25968a.m25611a(c6246z);
        }

        /* renamed from: a */
        public C6139b mo5317a(ab abVar) {
            return this.f25968a.m25610a(abVar);
        }

        /* renamed from: b */
        public void mo5322b(C6246z c6246z) {
            this.f25968a.m25615b(c6246z);
        }

        /* renamed from: a */
        public void mo5321a(ab abVar, ab abVar2) {
            this.f25968a.m25614a(abVar, abVar2);
        }

        /* renamed from: a */
        public void mo5319a() {
            this.f25968a.m25612a();
        }

        /* renamed from: a */
        public void mo5320a(C6141c c6141c) {
            this.f25968a.m25613a(c6141c);
        }
    }

    /* compiled from: Cache */
    /* renamed from: expolib_v1.a.c$a */
    private final class C7483a implements C6139b {
        /* renamed from: a */
        boolean f25969a;
        /* renamed from: b */
        final /* synthetic */ C6212c f25970b;
        /* renamed from: c */
        private final C6143a f25971c;
        /* renamed from: d */
        private C6257r f25972d;
        /* renamed from: e */
        private C6257r f25973e;

        public C7483a(final C6212c c6212c, final C6143a c6143a) {
            this.f25970b = c6212c;
            this.f25971c = c6143a;
            this.f25972d = c6143a.m25184a(1);
            this.f25973e = new C7498g(this, this.f25972d) {
                /* renamed from: c */
                final /* synthetic */ C7483a f30348c;

                public void close() {
                    synchronized (this.f30348c.f25970b) {
                        if (this.f30348c.f25969a) {
                            return;
                        }
                        this.f30348c.f25969a = true;
                        C6212c c6212c = this.f30348c.f25970b;
                        c6212c.f20151c++;
                        super.close();
                        c6143a.m25186b();
                    }
                }
            };
        }

        /* renamed from: a */
        public void mo5323a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f25970b;
            monitor-enter(r0);
            r1 = r4.f25969a;	 Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0009;	 Catch:{ all -> 0x001f }
        L_0x0007:
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            return;	 Catch:{ all -> 0x001f }
        L_0x0009:
            r1 = 1;	 Catch:{ all -> 0x001f }
            r4.f25969a = r1;	 Catch:{ all -> 0x001f }
            r2 = r4.f25970b;	 Catch:{ all -> 0x001f }
            r3 = r2.f20152d;	 Catch:{ all -> 0x001f }
            r3 = r3 + r1;	 Catch:{ all -> 0x001f }
            r2.f20152d = r3;	 Catch:{ all -> 0x001f }
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            r0 = r4.f25972d;
            expolib_v1.p321a.p322a.C6165c.m25315a(r0);
            r0 = r4.f25971c;	 Catch:{ IOException -> 0x001e }
            r0.m25187c();	 Catch:{ IOException -> 0x001e }
        L_0x001e:
            return;
        L_0x001f:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.a.a():void");
        }

        /* renamed from: b */
        public C6257r mo5324b() {
            return this.f25973e;
        }
    }

    /* compiled from: Cache */
    /* renamed from: expolib_v1.a.c$b */
    private static class C7484b extends ac {
        /* renamed from: a */
        final C6145c f25974a;
        /* renamed from: b */
        private final C7497e f25975b;
        /* renamed from: c */
        private final String f25976c;
        /* renamed from: d */
        private final String f25977d;

        public C7484b(final C6145c c6145c, String str, String str2) {
            this.f25974a = c6145c;
            this.f25976c = str;
            this.f25977d = str2;
            this.f25975b = C6252l.m25859a(new C7499h(this, c6145c.m25193a(1)) {
                /* renamed from: b */
                final /* synthetic */ C7484b f30350b;

                public void close() {
                    c6145c.close();
                    super.close();
                }
            });
        }

        public C6240u contentType() {
            return this.f25976c != null ? C6240u.m25781a(this.f25976c) : null;
        }

        public long contentLength() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = -1;
            r2 = r4.f25977d;	 Catch:{ NumberFormatException -> 0x000e }
            if (r2 == 0) goto L_0x000d;	 Catch:{ NumberFormatException -> 0x000e }
        L_0x0006:
            r2 = r4.f25977d;	 Catch:{ NumberFormatException -> 0x000e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x000e }
            r0 = r2;
        L_0x000d:
            return r0;
        L_0x000e:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.b.contentLength():long");
        }

        public C7497e source() {
            return this.f25975b;
        }
    }

    public C6212c(File file, long j) {
        this(file, j, C6188a.f20033a);
    }

    C6212c(File file, long j, C6188a c6188a) {
        this.f20149a = new C74821(this);
        this.f20150b = C6146d.m25194a(c6188a, file, 201105, 2, j);
    }

    /* renamed from: a */
    public static String m25608a(C6237r c6237r) {
        return C6251f.m25837a(c6237r.toString()).mo5360c().mo5364f();
    }

    /* renamed from: a */
    expolib_v1.p321a.ab m25611a(expolib_v1.p321a.C6246z r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5.m25821a();
        r0 = expolib_v1.p321a.C6212c.m25608a(r0);
        r1 = 0;
        r2 = r4.f20150b;	 Catch:{ IOException -> 0x0033 }
        r0 = r2.m25202a(r0);	 Catch:{ IOException -> 0x0033 }
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = new expolib_v1.a.c$c;	 Catch:{ IOException -> 0x002f }
        r3 = 0;	 Catch:{ IOException -> 0x002f }
        r3 = r0.m25193a(r3);	 Catch:{ IOException -> 0x002f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002f }
        r0 = r2.m25604a(r0);
        r5 = r2.m25606a(r5, r0);
        if (r5 != 0) goto L_0x002e;
    L_0x0026:
        r5 = r0.m25585h();
        expolib_v1.p321a.p322a.C6165c.m25315a(r5);
        return r1;
    L_0x002e:
        return r0;
    L_0x002f:
        expolib_v1.p321a.p322a.C6165c.m25315a(r0);
        return r1;
    L_0x0033:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.a(expolib_v1.a.z):expolib_v1.a.ab");
    }

    /* renamed from: a */
    expolib_v1.p321a.p322a.p323a.C6139b m25610a(expolib_v1.p321a.ab r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4.m25576a();
        r0 = r0.m25823b();
        r1 = r4.m25576a();
        r1 = r1.m25823b();
        r1 = expolib_v1.p321a.p322a.p325c.C6161f.m25293a(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0017:
        r4 = r4.m25576a();	 Catch:{ IOException -> 0x001e }
        r3.m25615b(r4);	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        return r2;
    L_0x001f:
        r1 = "GET";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = expolib_v1.p321a.p322a.p325c.C6160e.m25287b(r4);
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        return r2;
    L_0x002f:
        r0 = new expolib_v1.a.c$c;
        r0.<init>(r4);
        r1 = r3.f20150b;	 Catch:{ IOException -> 0x0052 }
        r4 = r4.m25576a();	 Catch:{ IOException -> 0x0052 }
        r4 = r4.m25821a();	 Catch:{ IOException -> 0x0052 }
        r4 = expolib_v1.p321a.C6212c.m25608a(r4);	 Catch:{ IOException -> 0x0052 }
        r4 = r1.m25206b(r4);	 Catch:{ IOException -> 0x0052 }
        if (r4 != 0) goto L_0x0049;
    L_0x0048:
        return r2;
    L_0x0049:
        r0.m25605a(r4);	 Catch:{ IOException -> 0x0053 }
        r0 = new expolib_v1.a.c$a;	 Catch:{ IOException -> 0x0053 }
        r0.<init>(r3, r4);	 Catch:{ IOException -> 0x0053 }
        return r0;
    L_0x0052:
        r4 = r2;
    L_0x0053:
        r3.m25609a(r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.a(expolib_v1.a.ab):expolib_v1.a.a.a.b");
    }

    /* renamed from: b */
    void m25615b(C6246z c6246z) {
        this.f20150b.m25209c(C6212c.m25608a(c6246z.m25821a()));
    }

    /* renamed from: a */
    void m25614a(expolib_v1.p321a.ab r2, expolib_v1.p321a.ab r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new expolib_v1.a.c$c;
        r0.<init>(r3);
        r2 = r2.m25585h();
        r2 = (expolib_v1.p321a.C6212c.C7484b) r2;
        r2 = r2.f25974a;
        r2 = r2.m25192a();	 Catch:{ IOException -> 0x001a }
        if (r2 == 0) goto L_0x001e;
    L_0x0013:
        r0.m25605a(r2);	 Catch:{ IOException -> 0x001b }
        r2.m25186b();	 Catch:{ IOException -> 0x001b }
        goto L_0x001e;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1.m25609a(r2);
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.a(expolib_v1.a.ab, expolib_v1.a.ab):void");
    }

    /* renamed from: a */
    private void m25609a(expolib_v1.p321a.p322a.p323a.C6146d.C6143a r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0005;
    L_0x0002:
        r1.m25187c();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.c.a(expolib_v1.a.a.a.d$a):void");
    }

    public void flush() {
        this.f20150b.flush();
    }

    public void close() {
        this.f20150b.close();
    }

    /* renamed from: a */
    synchronized void m25613a(C6141c c6141c) {
        this.f20155g++;
        if (c6141c.f19826a != null) {
            this.f20153e++;
        } else if (c6141c.f19827b != null) {
            this.f20154f++;
        }
    }

    /* renamed from: a */
    synchronized void m25612a() {
        this.f20154f++;
    }

    /* renamed from: a */
    static int m25607a(C7497e c7497e) {
        try {
            long o = c7497e.mo6398o();
            c7497e = c7497e.mo6401s();
            if (o >= 0 && o <= 2147483647L && c7497e.isEmpty()) {
                return (int) o;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected an int but was \"");
            stringBuilder.append(o);
            stringBuilder.append(c7497e);
            stringBuilder.append("\"");
            throw new IOException(stringBuilder.toString());
        } catch (C7497e c7497e2) {
            throw new IOException(c7497e2.getMessage());
        }
    }
}
