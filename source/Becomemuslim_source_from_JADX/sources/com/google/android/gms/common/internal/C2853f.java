package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.support.v4.util.C0448b;
import android.view.View;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.GoogleApiClient.C2774a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p175c.C4882a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.f */
public final class C2853f {
    /* renamed from: a */
    private final Account f7301a;
    /* renamed from: b */
    private final Set<Scope> f7302b;
    /* renamed from: c */
    private final Set<Scope> f7303c;
    /* renamed from: d */
    private final Map<C2781a<?>, C2852b> f7304d;
    /* renamed from: e */
    private final int f7305e;
    /* renamed from: f */
    private final View f7306f;
    /* renamed from: g */
    private final String f7307g;
    /* renamed from: h */
    private final String f7308h;
    /* renamed from: i */
    private final C4882a f7309i;
    /* renamed from: j */
    private Integer f7310j;

    /* renamed from: com.google.android.gms.common.internal.f$a */
    public static final class C2851a {
        /* renamed from: a */
        private Account f7292a;
        /* renamed from: b */
        private C0448b<Scope> f7293b;
        /* renamed from: c */
        private Map<C2781a<?>, C2852b> f7294c;
        /* renamed from: d */
        private int f7295d = 0;
        /* renamed from: e */
        private View f7296e;
        /* renamed from: f */
        private String f7297f;
        /* renamed from: g */
        private String f7298g;
        /* renamed from: h */
        private C4882a f7299h = C4882a.f13966a;

        /* renamed from: a */
        public final C2851a m8311a(Account account) {
            this.f7292a = account;
            return this;
        }

        /* renamed from: a */
        public final C2851a m8313a(Collection<Scope> collection) {
            if (this.f7293b == null) {
                this.f7293b = new C0448b();
            }
            this.f7293b.addAll(collection);
            return this;
        }

        /* renamed from: a */
        public final C2851a m8312a(String str) {
            this.f7297f = str;
            return this;
        }

        /* renamed from: b */
        public final C2851a m8315b(String str) {
            this.f7298g = str;
            return this;
        }

        /* renamed from: a */
        public final C2853f m8314a() {
            return new C2853f(this.f7292a, this.f7293b, this.f7294c, this.f7295d, this.f7296e, this.f7297f, this.f7298g, this.f7299h);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.f$b */
    public static final class C2852b {
        /* renamed from: a */
        public final Set<Scope> f7300a;
    }

    /* renamed from: a */
    public static C2853f m8316a(Context context) {
        return new C2774a(context).m7908a();
    }

    public C2853f(Account account, Set<Scope> set, Map<C2781a<?>, C2852b> map, int i, View view, String str, String str2, C4882a c4882a) {
        this.f7301a = account;
        this.f7302b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.f7304d = map;
        this.f7306f = view;
        this.f7305e = i;
        this.f7307g = str;
        this.f7308h = str2;
        this.f7309i = c4882a;
        account = new HashSet(this.f7302b);
        set = this.f7304d.values().iterator();
        while (set.hasNext() != null) {
            account.addAll(((C2852b) set.next()).f7300a);
        }
        this.f7303c = Collections.unmodifiableSet(account);
    }

    @Deprecated
    /* renamed from: a */
    public final String m8317a() {
        return this.f7301a != null ? this.f7301a.name : null;
    }

    /* renamed from: b */
    public final Account m8320b() {
        return this.f7301a;
    }

    /* renamed from: c */
    public final Account m8321c() {
        if (this.f7301a != null) {
            return this.f7301a;
        }
        return new Account("<<default account>>", "com.google");
    }

    /* renamed from: d */
    public final Set<Scope> m8322d() {
        return this.f7302b;
    }

    /* renamed from: e */
    public final Set<Scope> m8323e() {
        return this.f7303c;
    }

    /* renamed from: f */
    public final Map<C2781a<?>, C2852b> m8324f() {
        return this.f7304d;
    }

    /* renamed from: g */
    public final String m8325g() {
        return this.f7307g;
    }

    /* renamed from: h */
    public final String m8326h() {
        return this.f7308h;
    }

    /* renamed from: i */
    public final C4882a m8327i() {
        return this.f7309i;
    }

    /* renamed from: j */
    public final Integer m8328j() {
        return this.f7310j;
    }

    /* renamed from: a */
    public final void m8319a(Integer num) {
        this.f7310j = num;
    }

    /* renamed from: a */
    public final Set<Scope> m8318a(C2781a<?> c2781a) {
        C2852b c2852b = (C2852b) this.f7304d.get(c2781a);
        if (c2852b != null) {
            if (!c2852b.f7300a.isEmpty()) {
                Set<Scope> hashSet = new HashSet(this.f7302b);
                hashSet.addAll(c2852b.f7300a);
                return hashSet;
            }
        }
        return this.f7302b;
    }
}
