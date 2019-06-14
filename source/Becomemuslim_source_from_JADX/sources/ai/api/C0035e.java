package ai.api;

import java.util.TimeZone;
import java.util.UUID;

/* compiled from: AIServiceContextBuilder */
/* renamed from: ai.api.e */
public class C0035e {
    /* renamed from: a */
    private String f125a;
    /* renamed from: b */
    private TimeZone f126b;

    /* compiled from: AIServiceContextBuilder */
    /* renamed from: ai.api.e$a */
    private static class C3098a implements C0028d {
        /* renamed from: a */
        static final /* synthetic */ boolean f7911a = (C0035e.class.desiredAssertionStatus() ^ 1);
        /* renamed from: b */
        private final String f7912b;
        /* renamed from: c */
        private final TimeZone f7913c;

        public C3098a(String str, TimeZone timeZone) {
            if (!f7911a) {
                if (str == null) {
                    throw new AssertionError();
                }
            }
            this.f7912b = str;
            this.f7913c = timeZone;
        }

        /* renamed from: a */
        public String mo2a() {
            return this.f7912b;
        }

        /* renamed from: b */
        public TimeZone mo3b() {
            return this.f7913c;
        }
    }

    /* renamed from: a */
    public C0035e m108a() {
        this.f125a = C0035e.m107c();
        return this;
    }

    /* renamed from: b */
    public C0028d m109b() {
        if (this.f125a != null) {
            return new C3098a(this.f125a, this.f126b);
        }
        throw new IllegalStateException("Session id is undefined");
    }

    /* renamed from: c */
    private static String m107c() {
        return UUID.randomUUID().toString();
    }
}
