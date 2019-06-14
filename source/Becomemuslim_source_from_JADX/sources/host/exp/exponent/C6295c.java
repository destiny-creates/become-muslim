package host.exp.exponent;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import host.exp.exponent.C6369g.C6360b;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p337d.C6299a;
import host.exp.exponent.p339f.C6339i;
import host.exp.exponent.p344h.C6371c;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6263a;
import javax.inject.C6562a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppLoader */
/* renamed from: host.exp.exponent.c */
public abstract class C6295c {
    /* renamed from: d */
    private static final String f20470d = "c";
    @C6562a
    /* renamed from: a */
    C6369g f20471a;
    @C6562a
    /* renamed from: b */
    C6373d f20472b;
    @C6562a
    /* renamed from: c */
    C6356f f20473c;
    /* renamed from: e */
    private String f20474e;
    /* renamed from: f */
    private JSONObject f20475f;
    /* renamed from: g */
    private JSONObject f20476g;
    /* renamed from: h */
    private String f20477h;
    /* renamed from: i */
    private boolean f20478i = false;
    /* renamed from: j */
    private final boolean f20479j;
    /* renamed from: k */
    private Runnable f20480k;

    /* compiled from: AppLoader */
    /* renamed from: host.exp.exponent.c$1 */
    class C62931 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C6295c f20457a;

        C62931(C6295c c6295c) {
            this.f20457a = c6295c;
        }

        public void run() {
            this.f20457a.m25982f();
        }
    }

    /* compiled from: AppLoader */
    /* renamed from: host.exp.exponent.c$2 */
    class C75152 implements C6360b {
        /* renamed from: a */
        final /* synthetic */ C6295c f26072a;

        C75152(C6295c c6295c) {
            this.f26072a = c6295c;
        }

        public void onCompleted(JSONObject jSONObject) {
            this.f26072a.f20476g = jSONObject;
            this.f26072a.m25971a(true, true);
        }

        public void onError(Exception exception) {
            this.f26072a.m25974b(exception);
        }

        public void onError(String str) {
            this.f26072a.m25974b(new Exception(str));
        }
    }

    /* compiled from: AppLoader */
    /* renamed from: host.exp.exponent.c$3 */
    class C75163 implements C6360b {
        /* renamed from: a */
        final /* synthetic */ C6295c f26073a;

        C75163(C6295c c6295c) {
            this.f26073a = c6295c;
        }

        public void onCompleted(JSONObject jSONObject) {
            Exception e;
            int i;
            this.f26073a.f20475f = jSONObject;
            int i2 = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
            String optString;
            int equals;
            try {
                if (C6369g.m26131b(this.f26073a.f20475f)) {
                    this.f26073a.m25987b();
                    return;
                }
                String string = this.f26073a.f20475f.getString("id");
                optString = this.f26073a.f20475f.optString("sdkVersion", null);
                try {
                    jSONObject = this.f26073a.f20475f.optJSONObject("updates");
                    if (jSONObject != null) {
                        equals = jSONObject.optString("checkAutomatically", "ON_LOAD").equals("ON_ERROR_RECOVERY") ^ 1;
                        try {
                            i2 = jSONObject.optInt("fallbackToCacheTimeout", HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                        } catch (JSONException e2) {
                            e = e2;
                            onError(e);
                            i = 0;
                            if (C6301d.m26001a() != null) {
                                equals = 1;
                            } else {
                                i2 = 0;
                            }
                            if (this.f26073a.f20479j == null) {
                                i = equals;
                            }
                            if (i == 0) {
                                this.f26073a.m25982f();
                            } else {
                                this.f26073a.m25964a(i2);
                            }
                        }
                    }
                    equals = 1;
                    jSONObject = this.f26073a.f20472b.m26165e(string);
                    if (!(jSONObject == null || jSONObject.optBoolean("loadingError") == null)) {
                        equals = 1;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    equals = 1;
                    onError(e);
                    i = 0;
                    if (C6301d.m26001a() != null) {
                        i2 = 0;
                    } else {
                        equals = 1;
                    }
                    if (this.f26073a.f20479j == null) {
                        i = equals;
                    }
                    if (i == 0) {
                        this.f26073a.m25964a(i2);
                    } else {
                        this.f26073a.m25982f();
                    }
                }
                i = 0;
                if (C6301d.m26001a() != null) {
                    equals = 1;
                } else if (optString != null && C6290a.m25954a(optString) < C6290a.m25954a("26.0.0")) {
                    i2 = 0;
                }
                if (this.f26073a.f20479j == null) {
                    i = equals;
                }
                if (i == 0) {
                    this.f26073a.m25964a(i2);
                } else {
                    this.f26073a.m25982f();
                }
            } catch (JSONException e4) {
                e = e4;
                optString = null;
                equals = 1;
                onError(e);
                i = 0;
                if (C6301d.m26001a() != null) {
                    equals = 1;
                } else {
                    i2 = 0;
                }
                if (this.f26073a.f20479j == null) {
                    i = equals;
                }
                if (i == 0) {
                    this.f26073a.m25982f();
                } else {
                    this.f26073a.m25964a(i2);
                }
            }
        }

        public void onError(Exception exception) {
            String c = C6295c.f20470d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error fetching cached manifest, falling back to default timeout: ");
            stringBuilder.append(C6299a.m25994a(exception).m26055b());
            C6289b.m25953c(c, stringBuilder.toString());
            this.f26073a.m25977d();
        }

        public void onError(String str) {
            String c = C6295c.f20470d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error fetching cached manifest, falling back to default timeout: ");
            stringBuilder.append(str);
            C6289b.m25953c(c, stringBuilder.toString());
            this.f26073a.m25977d();
        }
    }

    /* compiled from: AppLoader */
    /* renamed from: host.exp.exponent.c$4 */
    class C75174 implements C6360b {
        /* renamed from: a */
        final /* synthetic */ C6295c f26074a;

        C75174(C6295c c6295c) {
            this.f26074a = c6295c;
        }

        public void onCompleted(JSONObject jSONObject) {
            this.f26074a.f20476g = jSONObject;
            if (!(C6369g.m26131b(jSONObject) || this.f26074a.f20478i)) {
                this.f26074a.mo5386a(jSONObject);
            }
            this.f26074a.m25970a(false);
        }

        public void onError(Exception exception) {
            this.f26074a.m25974b(exception);
        }

        public void onError(String str) {
            this.f26074a.m25974b(new Exception(str));
        }
    }

    /* renamed from: a */
    public abstract void mo5384a(Exception exception);

    /* renamed from: a */
    public abstract void mo5385a(String str);

    /* renamed from: a */
    public abstract void mo5386a(JSONObject jSONObject);

    /* renamed from: b */
    public abstract void mo5387b(String str);

    /* renamed from: b */
    public abstract void mo5388b(JSONObject jSONObject);

    /* renamed from: c */
    public abstract void mo5389c(JSONObject jSONObject);

    public C6295c(String str, boolean z) {
        C6294a.m25957a().m25961b(C6295c.class, this);
        this.f20474e = str;
        this.f20479j = z;
        this.f20480k = new C62931(this);
    }

    /* renamed from: a */
    public void m25983a() {
        if (C6301d.f20505k || C6263a.f20400b) {
            if (!this.f20471a.m26143b(this.f20474e, new C75163(this))) {
                m25987b();
            }
            return;
        }
        this.f20471a.m26144c(this.f20474e, new C75152(this));
    }

    /* renamed from: d */
    private void m25977d() {
        m25964a((int) HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
    }

    /* renamed from: a */
    private void m25964a(int i) {
        this.f20473c.m26076a(this.f20480k, (long) i);
        m25987b();
    }

    /* renamed from: b */
    public void m25987b() {
        this.f20471a.m26141a(this.f20474e, new C75174(this));
    }

    /* renamed from: e */
    private void m25979e() {
        this.f20473c.m26077b(this.f20480k);
    }

    /* renamed from: f */
    private void m25982f() {
        m25974b(null);
    }

    /* renamed from: b */
    private void m25974b(Exception exception) {
        if (!this.f20478i) {
            if (this.f20476g != null && this.f20477h != null) {
                m25979e();
                this.f20478i = true;
                try {
                    exception = C6339i.m26062a(this.f20476g.getString("bundleUrl"));
                    C6288a.m25941a(C6287a.FINISHED_FETCHING_MANIFEST);
                    this.f20472b.m26152a(this.f20474e, this.f20476g, exception);
                    C6371c.m26148a(this.f20474e, this.f20476g, exception);
                    mo5388b(this.f20476g);
                    if (C6369g.m26131b(this.f20476g) == null) {
                        mo5385a(this.f20477h);
                    }
                } catch (Exception exception2) {
                    mo5384a(exception2);
                }
            } else if (this.f20475f != null) {
                this.f20476g = this.f20475f;
                this.f20475f = null;
                m25970a(true);
            } else {
                this.f20478i = true;
                if (exception2 != null) {
                    String str = f20470d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not load app: ");
                    stringBuilder.append(C6299a.m25994a(exception2).m26055b());
                    C6289b.m25953c(str, stringBuilder.toString());
                    mo5384a(exception2);
                } else {
                    exception2 = new StringBuilder();
                    exception2.append("Could not load request from ");
                    exception2.append(this.f20474e);
                    exception2.append(": the request timed out");
                    mo5387b(exception2.toString());
                }
            }
        }
    }

    /* renamed from: a */
    private void m25970a(boolean z) {
        m25971a(z, false);
    }

    /* renamed from: a */
    private void m25971a(boolean r14, boolean r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = r13.f20476g;
        r0 = host.exp.exponent.C6369g.m26131b(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r14 = "";
        r13.f20477h = r14;
        r13.m25982f();
        return;
    L_0x0010:
        r0 = 0;
        r1 = r13.f20472b;	 Catch:{ Throwable -> 0x0026 }
        r2 = r13.f20474e;	 Catch:{ Throwable -> 0x0026 }
        r1 = r1.m26160c(r2);	 Catch:{ Throwable -> 0x0026 }
        r1 = r1.f20639a;	 Catch:{ Throwable -> 0x0026 }
        r2 = "bundleUrl";	 Catch:{ Throwable -> 0x0026 }
        r1 = r1.getString(r2);	 Catch:{ Throwable -> 0x0026 }
        r0 = r1;
        goto L_0x002d;
    L_0x0023:
        r14 = move-exception;
        goto L_0x0097;
    L_0x0026:
        r1 = f20470d;	 Catch:{ Exception -> 0x0023 }
        r2 = "Couldn't get old manifest from shared preferences";	 Catch:{ Exception -> 0x0023 }
        host.exp.exponent.p334a.C6289b.m25953c(r1, r2);	 Catch:{ Exception -> 0x0023 }
    L_0x002d:
        r1 = r13.f20476g;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r2 = "bundleUrl";	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r5 = r1.getString(r2);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r0 = r5.equals(r0);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r0 = r0 ^ 1;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r1 = r13.f20476g;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r2 = "id";	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r2 = r13.f20476g;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r3 = "sdkVersion";	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r2 = r2.getString(r3);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r11 = r13.f20476g;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r3 = host.exp.p333a.C6271b.m25897a();	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r4 = r13.f20476g;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r6 = host.exp.p333a.C6271b.m25897a();	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r1 = r6.m25923c(r1);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r12 = new host.exp.exponent.c$5;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r6 = r12;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r7 = r13;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r8 = r15;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r9 = r14;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r10 = r0;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r6.<init>(r7, r8, r9, r10, r11);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r6 = r1;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r7 = r2;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r8 = r12;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r9 = r0;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r10 = r14;	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        r3.m25919a(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ JSONException -> 0x008d, Exception -> 0x006e }
        goto L_0x00b4;
    L_0x006e:
        r14 = move-exception;
        r15 = f20470d;	 Catch:{ Exception -> 0x0023 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0023 }
        r0.<init>();	 Catch:{ Exception -> 0x0023 }
        r1 = "Couldn't load bundle: ";	 Catch:{ Exception -> 0x0023 }
        r0.append(r1);	 Catch:{ Exception -> 0x0023 }
        r1 = r14.toString();	 Catch:{ Exception -> 0x0023 }
        r0.append(r1);	 Catch:{ Exception -> 0x0023 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0023 }
        host.exp.exponent.p334a.C6289b.m25953c(r15, r0);	 Catch:{ Exception -> 0x0023 }
        r13.m25974b(r14);	 Catch:{ Exception -> 0x0023 }
        goto L_0x00b4;	 Catch:{ Exception -> 0x0023 }
    L_0x008d:
        r14 = move-exception;	 Catch:{ Exception -> 0x0023 }
        r15 = f20470d;	 Catch:{ Exception -> 0x0023 }
        host.exp.exponent.p334a.C6289b.m25950a(r15, r14);	 Catch:{ Exception -> 0x0023 }
        r13.m25974b(r14);	 Catch:{ Exception -> 0x0023 }
        goto L_0x00b4;
    L_0x0097:
        r15 = f20470d;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Couldn't load manifest: ";
        r0.append(r1);
        r1 = r14.toString();
        r0.append(r1);
        r0 = r0.toString();
        host.exp.exponent.p334a.C6289b.m25953c(r15, r0);
        r13.m25974b(r14);
    L_0x00b4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.c.a(boolean, boolean):void");
    }
}
