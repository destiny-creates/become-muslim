package com.google.android.gms.internal.p210i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.bm */
class bm extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f16425a = "com.google.android.gms.internal.i.bm";
    /* renamed from: b */
    private final C5008q f16426b;
    /* renamed from: c */
    private boolean f16427c;
    /* renamed from: d */
    private boolean f16428d;

    bm(C5008q c5008q) {
        C2872v.a(c5008q);
        this.f16426b = c5008q;
    }

    public void onReceive(Context context, Intent intent) {
        m20336e();
        context = intent.getAction();
        this.f16426b.m21063e().m21026a("NetworkBroadcastReceiver received action", context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context)) {
            Intent f = m20337f();
            if (this.f16428d != f) {
                this.f16428d = f;
                intent = this.f16426b.m21066h();
                intent.m21026a("Network connectivity status changed", Boolean.valueOf(f));
                intent.m21047n().a(new C4998h(intent, f));
            }
        } else if ("com.google.analytics.RADIO_POWERED".equals(context)) {
            if (intent.hasExtra(f16425a) == null) {
                context = this.f16426b.m21066h();
                context.m21036e("Radio powered up");
                context.m37942d();
            }
        } else {
            this.f16426b.m21063e().m21034d("NetworkBroadcastReceiver received unknown action", context);
        }
    }

    /* renamed from: a */
    public final void m20338a() {
        m20336e();
        if (!this.f16427c) {
            Context a = this.f16426b.m21059a();
            a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(a.getPackageName());
            a.registerReceiver(this, intentFilter);
            this.f16428d = m20337f();
            this.f16426b.m21063e().m21026a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f16428d));
            this.f16427c = true;
        }
    }

    /* renamed from: e */
    private final void m20336e() {
        this.f16426b.m21063e();
        this.f16426b.m21066h();
    }

    /* renamed from: b */
    public final void m20339b() {
        if (this.f16427c) {
            this.f16426b.m21063e().m21036e("Unregistering connectivity change receiver");
            this.f16427c = false;
            this.f16428d = false;
            try {
                this.f16426b.m21059a().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f16426b.m21063e().m21037e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    /* renamed from: c */
    public final void m20340c() {
        Context a = this.f16426b.m21059a();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(a.getPackageName());
        intent.putExtra(f16425a, true);
        a.sendOrderedBroadcast(intent, null);
    }

    /* renamed from: d */
    public final boolean m20341d() {
        if (!this.f16427c) {
            this.f16426b.m21063e().m21040h("Connectivity unknown. Receiver not registered");
        }
        return this.f16428d;
    }

    /* renamed from: f */
    private final boolean m20337f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.f16426b;
        r0 = r0.m21059a();
        r1 = "connectivity";
        r0 = r0.getSystemService(r1);
        r0 = (android.net.ConnectivityManager) r0;
        r1 = 0;
        r0 = r0.getActiveNetworkInfo();	 Catch:{ SecurityException -> 0x001e }
        if (r0 == 0) goto L_0x001d;	 Catch:{ SecurityException -> 0x001e }
    L_0x0015:
        r0 = r0.isConnected();	 Catch:{ SecurityException -> 0x001e }
        if (r0 == 0) goto L_0x001d;
    L_0x001b:
        r0 = 1;
        return r0;
    L_0x001d:
        return r1;
    L_0x001e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bm.f():boolean");
    }
}
