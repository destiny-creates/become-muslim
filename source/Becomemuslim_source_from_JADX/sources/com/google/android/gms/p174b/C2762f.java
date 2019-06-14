package com.google.android.gms.p174b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.b.f */
public abstract class C2762f<T> {
    /* renamed from: a */
    private final String f7053a;
    /* renamed from: b */
    private T f7054b;

    /* renamed from: com.google.android.gms.b.f$a */
    public static class C2761a extends Exception {
        public C2761a(String str) {
            super(str);
        }

        public C2761a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C2762f(String str) {
        this.f7053a = str;
    }

    /* renamed from: b */
    protected abstract T mo2481b(IBinder iBinder);

    /* renamed from: a */
    protected final T m7875a(Context context) {
        if (this.f7054b == null) {
            C2872v.m8380a((Object) context);
            context = C2832i.getRemoteContext(context);
            if (context != null) {
                try {
                    this.f7054b = mo2481b((IBinder) context.getClassLoader().loadClass(this.f7053a).newInstance());
                } catch (Context context2) {
                    throw new C2761a("Could not load creator class.", context2);
                } catch (Context context22) {
                    throw new C2761a("Could not instantiate creator.", context22);
                } catch (Context context222) {
                    throw new C2761a("Could not access creator.", context222);
                }
            }
            throw new C2761a("Could not get remote context.");
        }
        return this.f7054b;
    }
}
