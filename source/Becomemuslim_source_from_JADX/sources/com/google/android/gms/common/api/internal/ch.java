package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2872v;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ch extends cj {
    /* renamed from: e */
    private final SparseArray<C4348a> f13185e = new SparseArray();

    /* renamed from: com.google.android.gms.common.api.internal.ch$a */
    private class C4348a implements C2776c {
        /* renamed from: a */
        public final int f11488a;
        /* renamed from: b */
        public final GoogleApiClient f11489b;
        /* renamed from: c */
        public final C2776c f11490c;
        /* renamed from: d */
        private final /* synthetic */ ch f11491d;

        public C4348a(ch chVar, int i, GoogleApiClient googleApiClient, C2776c c2776c) {
            this.f11491d = chVar;
            this.f11488a = i;
            this.f11489b = googleApiClient;
            this.f11490c = c2776c;
            googleApiClient.mo2403a((C2776c) this);
        }

        public final void onConnectionFailed(C4775b c4775b) {
            String valueOf = String.valueOf(c4775b);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
            stringBuilder.append("beginFailureResolution for ");
            stringBuilder.append(valueOf);
            Log.d("AutoManageHelper", stringBuilder.toString());
            this.f11491d.m14206b(c4775b, this.f11488a);
        }
    }

    /* renamed from: b */
    public static ch m16757b(C2800f c2800f) {
        c2800f = LifecycleCallback.m7970a(c2800f);
        ch chVar = (ch) c2800f.mo2449a("AutoManageHelper", ch.class);
        if (chVar != null) {
            return chVar;
        }
        return new ch(c2800f);
    }

    private ch(C2801g c2801g) {
        super(c2801g);
        this.a.mo2450a("AutoManageHelper", (LifecycleCallback) this);
    }

    /* renamed from: a */
    public final void m16759a(int i, GoogleApiClient googleApiClient, C2776c c2776c) {
        C2872v.m8381a((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.f13185e.indexOfKey(i) < 0;
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Already managing a GoogleApiClient with id ");
        stringBuilder.append(i);
        C2872v.m8387a(z, stringBuilder.toString());
        ck ckVar = (ck) this.c.get();
        boolean z2 = this.b;
        String valueOf = String.valueOf(ckVar);
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        stringBuilder2.append("starting AutoManage for client ");
        stringBuilder2.append(i);
        stringBuilder2.append(" ");
        stringBuilder2.append(z2);
        stringBuilder2.append(" ");
        stringBuilder2.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder2.toString());
        this.f13185e.put(i, new C4348a(this, i, googleApiClient, c2776c));
        if (this.b != 0 && ckVar == null) {
            c2776c = String.valueOf(googleApiClient);
            StringBuilder stringBuilder3 = new StringBuilder(String.valueOf(c2776c).length() + 11);
            stringBuilder3.append("connecting ");
            stringBuilder3.append(c2776c);
            Log.d("AutoManageHelper", stringBuilder3.toString());
            googleApiClient.connect();
        }
    }

    /* renamed from: a */
    public final void m16758a(int i) {
        C2776c c2776c = (C4348a) this.f13185e.get(i);
        this.f13185e.remove(i);
        if (c2776c != null) {
            c2776c.f11489b.mo2410b(c2776c);
            c2776c.f11489b.disconnect();
        }
    }

    /* renamed from: b */
    public void mo2433b() {
        super.mo2433b();
        boolean z = this.b;
        String valueOf = String.valueOf(this.f13185e);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 14);
        stringBuilder.append("onStart ");
        stringBuilder.append(z);
        stringBuilder.append(" ");
        stringBuilder.append(valueOf);
        Log.d("AutoManageHelper", stringBuilder.toString());
        if (this.c.get() == null) {
            for (int i = 0; i < this.f13185e.size(); i++) {
                C4348a b = m16756b(i);
                if (b != null) {
                    b.f11489b.connect();
                }
            }
        }
    }

    /* renamed from: d */
    public void mo2435d() {
        super.mo2435d();
        for (int i = 0; i < this.f13185e.size(); i++) {
            C4348a b = m16756b(i);
            if (b != null) {
                b.f11489b.disconnect();
            }
        }
    }

    /* renamed from: a */
    public void mo3286a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f13185e.size(); i++) {
            C4348a b = m16756b(i);
            if (b != null) {
                printWriter.append(str).append("GoogleApiClient #").print(b.f11488a);
                printWriter.println(":");
                b.f11489b.mo2406a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* renamed from: a */
    protected final void mo3285a(C4775b c4775b, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C4348a c4348a = (C4348a) this.f13185e.get(i);
        if (c4348a != null) {
            m16758a(i);
            i = c4348a.f11490c;
            if (i != 0) {
                i.onConnectionFailed(c4775b);
            }
        }
    }

    /* renamed from: f */
    protected final void mo3287f() {
        for (int i = 0; i < this.f13185e.size(); i++) {
            C4348a b = m16756b(i);
            if (b != null) {
                b.f11489b.connect();
            }
        }
    }

    /* renamed from: b */
    private final C4348a m16756b(int i) {
        if (this.f13185e.size() <= i) {
            return 0;
        }
        return (C4348a) this.f13185e.get(this.f13185e.keyAt(i));
    }
}
