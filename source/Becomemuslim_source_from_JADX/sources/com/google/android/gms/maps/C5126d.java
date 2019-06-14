package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.maps.p216a.C5093c;
import com.google.android.gms.maps.p216a.C6834f;
import com.google.android.gms.maps.p216a.aj;
import com.google.android.gms.p174b.C2757a;
import com.google.android.gms.p174b.C2760e;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.d */
public class C5126d extends FrameLayout {
    private final C6845b zzbf;

    /* renamed from: com.google.android.gms.maps.d$b */
    static class C6845b extends C2757a<C7843a> {
        /* renamed from: a */
        private final ViewGroup f24645a;
        /* renamed from: b */
        private final Context f24646b;
        /* renamed from: c */
        private C2760e<C7843a> f24647c;
        /* renamed from: d */
        private final GoogleMapOptions f24648d;
        /* renamed from: e */
        private final List<C5128f> f24649e = new ArrayList();

        C6845b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f24645a = viewGroup;
            this.f24646b = context;
            this.f24648d = googleMapOptions;
        }

        /* renamed from: a */
        protected final void m32208a(com.google.android.gms.p174b.C2760e<com.google.android.gms.maps.C5126d.C7843a> r4) {
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
            r3 = this;
            r3.f24647c = r4;
            r4 = r3.f24647c;
            if (r4 == 0) goto L_0x005b;
        L_0x0006:
            r4 = r3.a();
            if (r4 != 0) goto L_0x005b;
        L_0x000c:
            r4 = r3.f24646b;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            com.google.android.gms.maps.C5127e.m21739a(r4);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4 = r3.f24646b;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4 = com.google.android.gms.maps.p216a.ak.m21594a(r4);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r0 = r3.f24646b;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r0 = com.google.android.gms.p174b.C4757d.a(r0);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1 = r3.f24648d;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4 = r4.mo4793a(r0, r1);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            if (r4 != 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
        L_0x0025:
            return;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
        L_0x0026:
            r0 = r3.f24647c;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1 = new com.google.android.gms.maps.d$a;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r2 = r3.f24645a;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1.<init>(r2, r4);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r0.a(r1);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4 = r3.f24649e;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4 = r4.iterator();	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
        L_0x0038:
            r0 = r4.hasNext();	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            if (r0 == 0) goto L_0x004e;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
        L_0x003e:
            r0 = r4.next();	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r0 = (com.google.android.gms.maps.C5128f) r0;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1 = r3.a();	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1 = (com.google.android.gms.maps.C5126d.C7843a) r1;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r1.m38263a(r0);	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            goto L_0x0038;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
        L_0x004e:
            r4 = r3.f24649e;	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            r4.clear();	 Catch:{ RemoteException -> 0x0054, g -> 0x005b }
            return;
        L_0x0054:
            r4 = move-exception;
            r0 = new com.google.android.gms.maps.model.u;
            r0.<init>(r4);
            throw r0;
        L_0x005b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.d.b.a(com.google.android.gms.b.e):void");
        }

        /* renamed from: a */
        public final void m32209a(C5128f c5128f) {
            if (a() != null) {
                ((C7843a) a()).m38263a(c5128f);
            } else {
                this.f24649e.add(c5128f);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.d$a */
    static class C7843a implements C6834f {
        /* renamed from: a */
        private final ViewGroup f29221a;
        /* renamed from: b */
        private final C5093c f29222b;
        /* renamed from: c */
        private View f29223c;

        public C7843a(ViewGroup viewGroup, C5093c c5093c) {
            this.f29222b = (C5093c) C2872v.a(c5093c);
            this.f29221a = (ViewGroup) C2872v.a(viewGroup);
        }

        /* renamed from: a */
        public final void m38261a() {
            try {
                this.f29222b.mo4845g();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: a */
        public final void m38262a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                aj.m21592a(bundle, bundle2);
                this.f29222b.mo4836a(bundle2);
                aj.m21592a(bundle2, bundle);
                this.f29223c = (View) C4757d.a(this.f29222b.mo4843e());
                this.f29221a.removeAllViews();
                this.f29221a.addView(this.f29223c);
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: a */
        public final void m38263a(C5128f c5128f) {
            try {
                this.f29222b.mo4837a(new C7845l(this, c5128f));
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: b */
        public final void m38264b() {
            try {
                this.f29222b.mo4835a();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: b */
        public final void m38265b(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                aj.m21592a(bundle, bundle2);
                this.f29222b.mo4839b(bundle2);
                aj.m21592a(bundle2, bundle);
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: c */
        public final void m38266c() {
            try {
                this.f29222b.mo4838b();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: c */
        public final void m38267c(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                aj.m21592a(bundle, bundle2);
                this.f29222b.mo4841c(bundle2);
                aj.m21592a(bundle2, bundle);
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: d */
        public final void m38268d() {
            try {
                this.f29222b.mo4846h();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: e */
        public final void m38269e() {
            try {
                this.f29222b.mo4840c();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: f */
        public final void m38270f() {
            try {
                this.f29222b.mo4842d();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }

        /* renamed from: g */
        public final void m38271g() {
            try {
                this.f29222b.mo4844f();
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
    }

    public C5126d(Context context) {
        super(context);
        this.zzbf = new C6845b(this, context, null);
        setClickable(true);
    }

    public C5126d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbf = new C6845b(this, context, GoogleMapOptions.m38234a(context, attributeSet));
        setClickable(true);
    }

    public C5126d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbf = new C6845b(this, context, GoogleMapOptions.m38234a(context, attributeSet));
        setClickable(true);
    }

    public C5126d(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.zzbf = new C6845b(this, context, googleMapOptions);
        setClickable(true);
    }

    public void getMapAsync(C5128f c5128f) {
        C2872v.b("getMapAsync() must be called on the main thread");
        this.zzbf.m32209a(c5128f);
    }

    public final void onCreate(Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            this.zzbf.a(bundle);
            if (this.zzbf.a() == null) {
                C2757a.a(this);
            }
            StrictMode.setThreadPolicy(threadPolicy);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void onDestroy() {
        this.zzbf.f();
    }

    public final void onEnterAmbient(Bundle bundle) {
        C2872v.b("onEnterAmbient() must be called on the main thread");
        C6845b c6845b = this.zzbf;
        if (c6845b.a() != null) {
            ((C7843a) c6845b.a()).m38267c(bundle);
        }
    }

    public final void onExitAmbient() {
        C2872v.b("onExitAmbient() must be called on the main thread");
        C6845b c6845b = this.zzbf;
        if (c6845b.a() != null) {
            ((C7843a) c6845b.a()).m38271g();
        }
    }

    public final void onLowMemory() {
        this.zzbf.g();
    }

    public final void onPause() {
        this.zzbf.d();
    }

    public final void onResume() {
        this.zzbf.c();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzbf.b(bundle);
    }

    public final void onStart() {
        this.zzbf.b();
    }

    public final void onStop() {
        this.zzbf.e();
    }
}
