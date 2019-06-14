package com.facebook.ads.internal.p096k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.share.internal.MessengerShareContentUtility;

/* renamed from: com.facebook.ads.internal.k.a */
public class C1404a {
    /* renamed from: a */
    private final Context f4095a;
    /* renamed from: b */
    private final String f4096b;
    /* renamed from: c */
    private final String f4097c;
    /* renamed from: d */
    private boolean f4098d = false;
    /* renamed from: e */
    private Messenger f4099e;
    /* renamed from: f */
    private final ServiceConnection f4100f = new C14031(this);

    /* renamed from: com.facebook.ads.internal.k.a$1 */
    class C14031 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ C1404a f4094a;

        C14031(C1404a c1404a) {
            this.f4094a = c1404a;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f4094a.f4098d = true;
            this.f4094a.f4099e = new Messenger(iBinder);
            Message obtain = Message.obtain(null, 1);
            obtain.setData(this.f4094a.m4814b());
            try {
                this.f4094a.f4099e.send(obtain);
            } catch (Exception e) {
                C1540a.m5396a(this.f4094a.f4095a, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, C1541b.f4568m, e);
            }
            this.f4094a.f4095a.unbindService(this);
        }

        public void onServiceDisconnected(android.content.ComponentName r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r1 = this;
            r2 = r1.f4094a;	 Catch:{ IllegalArgumentException -> 0x0009 }
            r2 = r2.f4095a;	 Catch:{ IllegalArgumentException -> 0x0009 }
            r2.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x0009 }
        L_0x0009:
            r2 = r1.f4094a;
            r0 = 0;
            r2.f4099e = r0;
            r2 = r1.f4094a;
            r0 = 0;
            r2.f4098d = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.k.a.1.onServiceDisconnected(android.content.ComponentName):void");
        }
    }

    public C1404a(Context context, String str, String str2) {
        this.f4095a = context;
        this.f4096b = str;
        this.f4097c = str2;
    }

    /* renamed from: b */
    private Bundle m4814b() {
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_PROTOCOL_VERSION", 1);
        bundle.putString("PARAM_AN_UUID", this.f4097c);
        bundle.putString("PARAM_REQUEST_ID", this.f4096b);
        return bundle;
    }

    /* renamed from: a */
    public void m4817a() {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.audiencenetwork.AudienceNetworkService");
        try {
            if (!this.f4095a.bindService(intent, this.f4100f, 1)) {
                this.f4095a.unbindService(this.f4100f);
            }
        } catch (Exception e) {
            C1540a.m5396a(this.f4095a, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, C1541b.f4569n, e);
        }
    }
}
