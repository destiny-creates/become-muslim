package host.exp.exponent.p343g;

import android.content.Context;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpStatus;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C7497e;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6301d.C6297a;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p343g.C6368f.C6367a;
import host.exp.exponent.p344h.C6373d;
import java.io.IOException;
import org.apache.p371a.p376c.C6646d;
import org.json.JSONObject;

/* compiled from: ExponentHttpClient */
/* renamed from: host.exp.exponent.g.e */
public class C6366e {
    /* renamed from: b */
    private static final String f20623b = "e";
    /* renamed from: a */
    C6373d f20624a;
    /* renamed from: c */
    private Context f20625c;
    /* renamed from: d */
    private C6367a f20626d;

    /* compiled from: ExponentHttpClient */
    /* renamed from: host.exp.exponent.g.e$a */
    public interface C6365a {
        /* renamed from: a */
        void mo5372a(C6364d c6364d);

        /* renamed from: a */
        void mo5373a(C6364d c6364d, boolean z);

        /* renamed from: a */
        void mo5374a(IOException iOException);
    }

    protected C6366e(Context context, C6373d c6373d, C6367a c6367a) {
        this.f20625c = context;
        this.f20626d = c6367a;
        this.f20624a = c6373d;
    }

    /* renamed from: a */
    public void m26103a(C6246z c6246z, final C6363c c6363c) {
        this.f20626d.mo5418a().mo5339a(c6246z).mo5341a(new C6217f(this) {
            /* renamed from: b */
            final /* synthetic */ C6366e f26208b;

            public void onFailure(C6216e c6216e, IOException iOException) {
                c6363c.mo5371a(iOException);
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                c6363c.mo5370a(new C7579g(abVar));
            }
        });
    }

    /* renamed from: a */
    public void m26104a(final C6246z c6246z, final C6365a c6365a) {
        final String c6237r = c6246z.m25821a().toString();
        this.f20626d.mo5418a().mo5339a(c6246z).mo5341a(new C6217f(this) {
            /* renamed from: d */
            final /* synthetic */ C6366e f26212d;

            public void onFailure(C6216e c6216e, IOException iOException) {
                this.f26212d.m26105a(c6237r, c6246z, c6365a, null, iOException);
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                if (abVar.m25581d() != null) {
                    c6365a.mo5372a(new C7579g(abVar));
                } else {
                    this.f26212d.m26105a(c6237r, c6246z, c6365a, abVar, null);
                }
            }
        });
    }

    /* renamed from: b */
    public void m26106b(final C6246z c6246z, final C6365a c6365a) {
        m26105a(c6246z.m25821a().toString(), c6246z, new C6365a(this) {
            /* renamed from: c */
            final /* synthetic */ C6366e f26216c;

            /* compiled from: ExponentHttpClient */
            /* renamed from: host.exp.exponent.g.e$3$1 */
            class C75691 implements C6363c {
                /* renamed from: a */
                final /* synthetic */ C75703 f26213a;

                C75691(C75703 c75703) {
                    this.f26213a = c75703;
                }

                /* renamed from: a */
                public void mo5371a(IOException iOException) {
                    c6365a.mo5374a(iOException);
                }

                /* renamed from: a */
                public void mo5370a(C6364d c6364d) {
                    c6365a.mo5372a(c6364d);
                }
            }

            /* renamed from: a */
            public void mo5374a(IOException iOException) {
                this.f26216c.m26103a(c6246z, new C75691(this));
            }

            /* renamed from: a */
            public void mo5372a(C6364d c6364d) {
                c6365a.mo5372a(c6364d);
            }

            /* renamed from: a */
            public void mo5373a(C6364d c6364d, boolean z) {
                c6365a.mo5373a(c6364d, z);
            }
        }, null, null);
    }

    /* renamed from: a */
    public void m26105a(String str, C6246z c6246z, C6365a c6365a, ab abVar, IOException iOException) {
        final String str2 = str;
        final C6365a c6365a2 = c6365a;
        final ab abVar2 = abVar;
        final IOException iOException2 = iOException;
        this.f20626d.mo5418a().mo5339a(c6246z.m25828f().m25810a(C6214d.f20164b).m25816a("exponentignoreinterceptors", "blah").m25820b()).mo5341a(new C6217f(this) {
            /* renamed from: e */
            final /* synthetic */ C6366e f26221e;

            public void onFailure(C6216e c6216e, IOException iOException) {
                this.f26221e.m26099a(str2, c6216e, c6365a2, abVar2, iOException2);
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                if (abVar.m25581d()) {
                    c6365a2.mo5373a(new C7579g(abVar), null);
                    this.f26221e.m26100a("HTTP_USED_CACHE_RESPONSE", str2);
                    return;
                }
                this.f26221e.m26099a(str2, c6216e, c6365a2, abVar2, iOException2);
            }
        });
    }

    /* renamed from: b */
    private static java.lang.String m26101b(java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r0.<init>(r10);	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r1 = r0.getPort();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r2 = -1;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        if (r1 != r2) goto L_0x002e;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x000c:
        r2 = r0.getProtocol();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r3 = "http";	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r2 = r2.equals(r3);	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        if (r2 == 0) goto L_0x001d;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x0018:
        r1 = 80;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r6 = 80;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        goto L_0x002f;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x001d:
        r2 = r0.getProtocol();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r3 = "https";	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r2 = r2.equals(r3);	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        if (r2 == 0) goto L_0x002e;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x0029:
        r1 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r6 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        goto L_0x002f;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x002e:
        r6 = r1;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
    L_0x002f:
        r1 = new java.net.URI;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r3 = r0.getProtocol();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r4 = r0.getUserInfo();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r5 = r0.getHost();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r7 = r0.getPath();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r8 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r9 = r0.getRef();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r2 = r1;	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        r0 = r1.toString();	 Catch:{ MalformedURLException -> 0x0052, MalformedURLException -> 0x0052 }
        return r0;
    L_0x0052:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.g.e.b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public String m26102a(String str) {
        try {
            for (C6297a c6297a : C6301d.f20501g) {
                if (C6366e.m26101b(str).equals(C6366e.m26101b(c6297a.f20482a))) {
                    str = c6297a.f20483b;
                    if (str.startsWith("assets://")) {
                        str = str.substring("assets://".length());
                    }
                    return C6646d.m27055a(this.f20625c.getAssets().open(str), Utf8Charset.NAME);
                }
            }
        } catch (Throwable th) {
            C6289b.m25950a(f20623b, th);
        }
        return null;
    }

    /* renamed from: a */
    private void m26099a(String str, C6216e c6216e, C6365a c6365a, ab abVar, IOException iOException) {
        try {
            for (C6297a c6297a : C6301d.f20501g) {
                if (C6366e.m26101b(str).equals(C6366e.m26101b(c6297a.f20482a))) {
                    c6365a.mo5373a(new C7579g(new C6208a().m25567a(c6216e.mo5340a()).m25566a(C6244x.HTTP_1_1).m25560a((int) HttpStatus.HTTP_OK).m25568a("OK").m25563a(m26096a(c6297a.f20483b, C6240u.m25781a(c6297a.f20484c))).m25570a()), true);
                    m26100a("HTTP_USED_EMBEDDED_RESPONSE", str);
                    return;
                }
            }
        } catch (Throwable th) {
            C6289b.m25950a(f20623b, th);
        }
        if (abVar != null) {
            c6365a.mo5372a(new C7579g(abVar));
        } else if (iOException != null) {
            c6365a.mo5374a(iOException);
        } else {
            c6365a.mo5374a(new IOException("No hard coded response found"));
        }
    }

    /* renamed from: a */
    private ac m26096a(String str, final C6240u c6240u) {
        try {
            if (str.startsWith("assets://")) {
                str = str.substring("assets://".length());
            }
            str = C6252l.m25859a(C6252l.m25865a(this.f20625c.getAssets().open(str)));
            return new ac(this) {
                /* renamed from: c */
                final /* synthetic */ C6366e f26224c;

                public long contentLength() {
                    return -1;
                }

                public C6240u contentType() {
                    return c6240u;
                }

                public C7497e source() {
                    return str;
                }
            };
        } catch (Throwable e) {
            C6289b.m25950a(f20623b, e);
            return null;
        } catch (Throwable e2) {
            C6289b.m25950a(f20623b, e2);
            return null;
        }
    }

    /* renamed from: a */
    private void m26100a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("URI", str2);
            C6288a.m25945a(str, jSONObject);
        } catch (Throwable e) {
            C6289b.m25950a(f20623b, e);
        }
    }
}
