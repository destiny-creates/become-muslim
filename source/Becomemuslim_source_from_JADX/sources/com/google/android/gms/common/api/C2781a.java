package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2850d.C2846c;
import com.google.android.gms.common.internal.C2850d.C2847e;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C2862o;
import com.google.android.gms.common.internal.C2872v;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.a */
public final class C2781a<O extends C2779d> {
    /* renamed from: a */
    private final C4337a<?, O> f7098a;
    /* renamed from: b */
    private final C4343i<?, O> f7099b = null;
    /* renamed from: c */
    private final C4341g<?> f7100c;
    /* renamed from: d */
    private final C4344j<?> f7101d;
    /* renamed from: e */
    private final String f7102e;

    /* renamed from: com.google.android.gms.common.api.a$b */
    public interface C2777b {
    }

    /* renamed from: com.google.android.gms.common.api.a$c */
    public static class C2778c<C extends C2777b> {
    }

    /* renamed from: com.google.android.gms.common.api.a$d */
    public interface C2779d {

        /* renamed from: com.google.android.gms.common.api.a$d$c */
        public interface C4338c extends C2779d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d */
        public interface C4339d extends C2779d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$a */
        public interface C4765a extends C4338c, C4339d {
            /* renamed from: a */
            Account m16708a();
        }

        /* renamed from: com.google.android.gms.common.api.a$d$b */
        public interface C4766b extends C4338c {
            /* renamed from: a */
            GoogleSignInAccount m16709a();
        }

        /* renamed from: com.google.android.gms.common.api.a$d$e */
        public interface C4767e extends C4338c, C4339d {
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$e */
    public static abstract class C2780e<T extends C2777b, O> {
        /* renamed from: a */
        public int m7929a() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: a */
        public List<Scope> mo3264a(O o) {
            return Collections.emptyList();
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$a */
    public static abstract class C4337a<T extends C4340f, O> extends C2780e<T, O> {
        /* renamed from: a */
        public abstract T mo3263a(Context context, Looper looper, C2853f c2853f, O o, C2775b c2775b, C2776c c2776c);
    }

    /* renamed from: com.google.android.gms.common.api.a$f */
    public interface C4340f extends C2777b {
        /* renamed from: a */
        void m14038a(C2846c c2846c);

        /* renamed from: a */
        void m14039a(C2847e c2847e);

        /* renamed from: a */
        void m14040a(C2862o c2862o, Set<Scope> set);

        /* renamed from: a */
        void m14041a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        /* renamed from: c */
        boolean mo3450c();

        /* renamed from: d */
        Intent mo3451d();

        /* renamed from: f */
        int mo3293f();

        /* renamed from: g */
        void m14045g();

        /* renamed from: h */
        boolean m14046h();

        /* renamed from: i */
        boolean m14047i();

        /* renamed from: j */
        boolean mo3457j();

        /* renamed from: k */
        boolean m14049k();

        /* renamed from: l */
        IBinder m14050l();

        /* renamed from: m */
        String m14051m();

        /* renamed from: n */
        C4776d[] m14052n();
    }

    /* renamed from: com.google.android.gms.common.api.a$g */
    public static final class C4341g<C extends C4340f> extends C2778c<C> {
    }

    /* renamed from: com.google.android.gms.common.api.a$h */
    public interface C4342h<T extends IInterface> extends C2777b {
        /* renamed from: a */
        T m14053a(IBinder iBinder);

        /* renamed from: a */
        String m14054a();

        /* renamed from: a */
        void m14055a(int i, T t);

        /* renamed from: b */
        String m14056b();
    }

    /* renamed from: com.google.android.gms.common.api.a$i */
    public static abstract class C4343i<T extends C4342h, O> extends C2780e<T, O> {
    }

    /* renamed from: com.google.android.gms.common.api.a$j */
    public static final class C4344j<C extends C4342h> extends C2778c<C> {
    }

    public <C extends C4340f> C2781a(String str, C4337a<C, O> c4337a, C4341g<C> c4341g) {
        C2872v.m8381a((Object) c4337a, (Object) "Cannot construct an Api with a null ClientBuilder");
        C2872v.m8381a((Object) c4341g, (Object) "Cannot construct an Api with a null ClientKey");
        this.f7102e = str;
        this.f7098a = c4337a;
        this.f7100c = c4341g;
        this.f7101d = null;
    }

    /* renamed from: a */
    public final C2780e<?, O> m7931a() {
        return this.f7098a;
    }

    /* renamed from: b */
    public final C4337a<?, O> m7932b() {
        C2872v.m8387a(this.f7098a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f7098a;
    }

    /* renamed from: c */
    public final C2778c<?> m7933c() {
        if (this.f7100c != null) {
            return this.f7100c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    /* renamed from: d */
    public final String m7934d() {
        return this.f7102e;
    }
}
