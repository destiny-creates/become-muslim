package com.polidea.p254a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import p289e.C5974e;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;
import p289e.p292c.p293a.C8106m;

/* compiled from: RxBleAdapterStateObservable */
/* renamed from: com.polidea.a.aa */
public class aa extends C5974e<C5552a> {

    /* compiled from: RxBleAdapterStateObservable */
    /* renamed from: com.polidea.a.aa$a */
    public static class C5552a {
        /* renamed from: a */
        public static final C5552a f18610a = new C5552a(true);
        /* renamed from: b */
        public static final C5552a f18611b = new C5552a(false);
        /* renamed from: c */
        public static final C5552a f18612c = new C5552a(false);
        /* renamed from: d */
        public static final C5552a f18613d = new C5552a(false);
        /* renamed from: e */
        private final boolean f18614e;

        private C5552a(boolean z) {
            this.f18614e = z;
        }

        /* renamed from: a */
        public boolean m23617a() {
            return this.f18614e;
        }
    }

    /* compiled from: RxBleAdapterStateObservable */
    /* renamed from: com.polidea.a.aa$1 */
    class C69781 implements C5914b<C7332c<C5552a>> {
        /* renamed from: a */
        final /* synthetic */ Context f24870a;

        C69781(Context context) {
            this.f24870a = context;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32759a((C7332c) obj);
        }

        /* renamed from: a */
        public void m32759a(final C7332c<C5552a> c7332c) {
            final BroadcastReceiver c55511 = new BroadcastReceiver(this) {
                /* renamed from: b */
                final /* synthetic */ C69781 f18609b;

                public void onReceive(Context context, Intent intent) {
                    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) != null) {
                        c7332c.mo5000a((Object) aa.m32764f(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)));
                    }
                }
            };
            this.f24870a.registerReceiver(c55511, aa.m32763b());
            c7332c.mo6330a(new C5917e(this) {
                /* renamed from: b */
                final /* synthetic */ C69781 f24869b;

                /* renamed from: a */
                public void mo4973a() {
                    this.f24869b.f24870a.unregisterReceiver(c55511);
                }
            });
        }
    }

    public aa(Context context) {
        super(new C8106m(new C69781(context), C5922a.LATEST));
    }

    /* renamed from: f */
    private static C5552a m32764f(int i) {
        switch (i) {
            case 11:
                return C5552a.f18612c;
            case 12:
                return C5552a.f18610a;
            case 13:
                return C5552a.f18613d;
            default:
                return C5552a.f18611b;
        }
    }

    /* renamed from: b */
    private static IntentFilter m32763b() {
        return new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
    }
}
