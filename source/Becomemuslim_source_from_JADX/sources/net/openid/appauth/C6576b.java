package net.openid.appauth;

import net.openid.appauth.p368a.C6569c;
import net.openid.appauth.p368a.C7637a;
import net.openid.appauth.p369b.C6575a;
import net.openid.appauth.p369b.C7639b;

/* compiled from: AppAuthConfiguration */
/* renamed from: net.openid.appauth.b */
public class C6576b {
    /* renamed from: a */
    public static final C6576b f21114a = new C6574a().m26796a();
    /* renamed from: b */
    private final C6569c f21115b;
    /* renamed from: c */
    private final C6575a f21116c;

    /* compiled from: AppAuthConfiguration */
    /* renamed from: net.openid.appauth.b$a */
    public static class C6574a {
        /* renamed from: a */
        private C6569c f21112a = C7637a.f26407a;
        /* renamed from: b */
        private C6575a f21113b = C7639b.f26409a;

        /* renamed from: a */
        public C6574a m26795a(C6575a c6575a) {
            C6605p.m26933a((Object) c6575a, (Object) "connectionBuilder cannot be null");
            this.f21113b = c6575a;
            return this;
        }

        /* renamed from: a */
        public C6576b m26796a() {
            return new C6576b(this.f21112a, this.f21113b);
        }
    }

    private C6576b(C6569c c6569c, C6575a c6575a) {
        this.f21115b = c6569c;
        this.f21116c = c6575a;
    }

    /* renamed from: a */
    public C6569c m26797a() {
        return this.f21115b;
    }

    /* renamed from: b */
    public C6575a m26798b() {
        return this.f21116c;
    }
}
