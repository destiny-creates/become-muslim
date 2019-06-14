package com.polidea.p254a.p256b.p262f;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import p289e.C5974e;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;
import p289e.p292c.p293a.C8106m;

@TargetApi(19)
/* compiled from: LocationServicesOkObservableApi23 */
/* renamed from: com.polidea.a.b.f.m */
public class C7079m extends C5974e<Boolean> {

    /* compiled from: LocationServicesOkObservableApi23 */
    /* renamed from: com.polidea.a.b.f.m$1 */
    class C70781 implements C5914b<C7332c<Boolean>> {
        /* renamed from: a */
        final /* synthetic */ C5607o f25055a;
        /* renamed from: b */
        final /* synthetic */ Context f25056b;

        C70781(C5607o c5607o, Context context) {
            this.f25055a = c5607o;
            this.f25056b = context;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32975a((C7332c) obj);
        }

        /* renamed from: a */
        public void m32975a(final C7332c<Boolean> c7332c) {
            boolean b = this.f25055a.mo5020b();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(b);
            c7332c.mo5000a((Object) Boolean.valueOf(b));
            final BroadcastReceiver c56061 = new BroadcastReceiver(this) {
                /* renamed from: c */
                final /* synthetic */ C70781 f18740c;

                public void onReceive(Context context, Intent intent) {
                    context = this.f18740c.f25055a.mo5020b();
                    if (atomicBoolean.compareAndSet(context ^ 1, context) != null) {
                        c7332c.mo5000a((Object) Boolean.valueOf(context));
                    }
                }
            };
            this.f25056b.registerReceiver(c56061, new IntentFilter("android.location.MODE_CHANGED"));
            c7332c.mo6330a(new C5917e(this) {
                /* renamed from: b */
                final /* synthetic */ C70781 f25054b;

                /* renamed from: a */
                public void mo4973a() {
                    this.f25054b.f25056b.unregisterReceiver(c56061);
                }
            });
        }
    }

    C7079m(Context context, C5607o c5607o) {
        super(new C8106m(new C70781(c5607o, context), C5922a.LATEST));
    }
}
