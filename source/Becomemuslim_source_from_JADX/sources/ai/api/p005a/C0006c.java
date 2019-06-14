package ai.api.p005a;

import ai.api.C0020c;
import ai.api.C0044j;
import ai.api.p005a.C3087a.C0005a;
import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;
import ai.api.p008d.C3096a;
import ai.api.p008d.C3097b;
import android.content.Context;

/* compiled from: AIService */
/* renamed from: ai.api.a.c */
public abstract class C0006c {
    /* renamed from: d */
    private static final String f27d = "ai.api.a.c";
    /* renamed from: a */
    protected final C3087a f28a;
    /* renamed from: b */
    protected final Context f29b;
    /* renamed from: c */
    protected final C3089b f30c;
    /* renamed from: e */
    private C0020c f31e;

    /* renamed from: a */
    public abstract void mo5a();

    /* renamed from: a */
    public abstract void mo6a(C0044j c0044j);

    /* renamed from: b */
    public abstract void mo7b();

    /* renamed from: c */
    public abstract void mo8c();

    /* renamed from: a */
    public static C0006c m9a(Context context, C3087a c3087a) {
        if (c3087a.m9028h() == C0005a.Google) {
            return new C3096a(context, c3087a);
        }
        if (c3087a.m9028h() == C0005a.System) {
            return new C3096a(context, c3087a);
        }
        if (c3087a.m9028h() == C0005a.Speaktoit) {
            return new C3097b(context, c3087a);
        }
        throw new UnsupportedOperationException("This engine still not supported");
    }

    protected C0006c(C3087a c3087a, Context context) {
        this.f28a = c3087a;
        this.f29b = context;
        this.f30c = new C3089b(context, c3087a);
    }

    /* renamed from: a */
    public void m14a(C0020c c0020c) {
        this.f31e = c0020c;
    }

    /* renamed from: a */
    protected void m13a(C0013c c0013c) {
        if (this.f31e != null) {
            this.f31e.onResult(c0013c);
        }
    }

    /* renamed from: a */
    protected void m12a(C0012a c0012a) {
        if (this.f31e != null) {
            this.f31e.onError(c0012a);
        }
    }

    /* renamed from: a */
    protected void m11a(float f) {
        if (this.f31e != null) {
            this.f31e.onAudioLevel(f);
        }
    }

    /* renamed from: d */
    protected void m18d() {
        if (this.f31e != null) {
            this.f31e.onListeningStarted();
        }
    }

    /* renamed from: e */
    protected void m19e() {
        if (this.f31e != null) {
            this.f31e.onListeningCanceled();
        }
    }

    /* renamed from: f */
    protected void m20f() {
        if (this.f31e != null) {
            this.f31e.onListeningFinished();
        }
    }

    /* renamed from: g */
    protected boolean m21g() {
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
        r3 = this;
        r0 = 1;
        r1 = r3.f29b;	 Catch:{ Throwable -> 0x000d }
        r2 = "android.permission.RECORD_AUDIO";	 Catch:{ Throwable -> 0x000d }
        r1 = android.support.v4.content.C0366b.m1109b(r1, r2);	 Catch:{ Throwable -> 0x000d }
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.a.c.g():boolean");
    }
}
