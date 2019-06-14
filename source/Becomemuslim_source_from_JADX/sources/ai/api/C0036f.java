package ai.api;

import ai.api.p007c.C0013c;
import ai.api.p009e.C0031c;

/* compiled from: AIServiceException */
/* renamed from: ai.api.f */
public class C0036f extends Exception {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private final C0013c f127a;

    public C0036f() {
        this.f127a = null;
    }

    public C0036f(String str, Throwable th) {
        super(str, th);
        this.f127a = null;
    }

    public C0036f(String str) {
        super(str);
        this.f127a = null;
    }

    public C0036f(C0013c c0013c) {
        this.f127a = c0013c;
    }

    /* renamed from: a */
    public C0013c m110a() {
        return this.f127a;
    }

    public String getMessage() {
        if (!(this.f127a == null || this.f127a.m50a() == null)) {
            Object b = this.f127a.m50a().m69b();
            if (!C0031c.m89a(b)) {
                return b;
            }
        }
        return super.getMessage();
    }
}
