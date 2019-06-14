package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.api.C2781a.C4340f;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;
import com.google.android.gms.common.internal.C2857k.C2856a;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.j */
public abstract class C4785j<T extends IInterface> extends C2850d<T> implements C4340f, C2856a {
    /* renamed from: e */
    private final C2853f f13235e;
    /* renamed from: f */
    private final Set<Scope> f13236f;
    /* renamed from: g */
    private final Account f13237g;

    /* renamed from: a */
    protected Set<Scope> m16846a(Set<Scope> set) {
        return set;
    }

    protected C4785j(Context context, Looper looper, int i, C2853f c2853f, C2775b c2775b, C2776c c2776c) {
        this(context, looper, C2859l.m8356a(context), C4361e.m14332a(), i, c2853f, (C2775b) C2872v.m8380a((Object) c2775b), (C2776c) C2872v.m8380a((Object) c2776c));
    }

    protected C4785j(Context context, Looper looper, C2859l c2859l, C4361e c4361e, int i, C2853f c2853f, C2775b c2775b, C2776c c2776c) {
        super(context, looper, c2859l, c4361e, i, C4785j.m16843a(c2775b), C4785j.m16844a(c2776c), c2853f.m8326h());
        this.f13235e = c2853f;
        this.f13237g = c2853f.m8320b();
        this.f13236f = m16845b(c2853f.m8323e());
    }

    /* renamed from: b */
    private final Set<Scope> m16845b(Set<Scope> set) {
        Set<Scope> a = m16846a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* renamed from: s */
    public final Account mo3294s() {
        return this.f13237g;
    }

    /* renamed from: z */
    protected final C2853f mo3296z() {
        return this.f13235e;
    }

    /* renamed from: y */
    protected final Set<Scope> mo3295y() {
        return this.f13236f;
    }

    /* renamed from: a */
    private static C2844a m16843a(C2775b c2775b) {
        return c2775b == null ? null : new ah(c2775b);
    }

    /* renamed from: a */
    private static C2845b m16844a(C2776c c2776c) {
        return c2776c == null ? null : new ai(c2776c);
    }

    /* renamed from: f */
    public int mo3293f() {
        return super.mo3293f();
    }
}
