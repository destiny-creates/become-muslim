package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import java.io.IOException;

final class ab implements Runnable {
    /* renamed from: a */
    private final long f18047a;
    /* renamed from: b */
    private final WakeLock f18048b = ((PowerManager) m22702a().getSystemService("power")).newWakeLock(1, "fiid-sync");
    /* renamed from: c */
    private final FirebaseInstanceId f18049c;
    /* renamed from: d */
    private final C5366q f18050d;
    /* renamed from: e */
    private final ae f18051e;

    ab(FirebaseInstanceId firebaseInstanceId, C5366q c5366q, ae aeVar, long j) {
        this.f18049c = firebaseInstanceId;
        this.f18050d = c5366q;
        this.f18051e = aeVar;
        this.f18047a = j;
        this.f18048b.setReferenceCounted(null);
    }

    public final void run() {
        this.f18048b.acquire();
        try {
            this.f18049c.m22682a(true);
            if (!this.f18049c.m22691j()) {
                this.f18049c.m22682a(false);
            } else if (m22703b()) {
                if (m22700c() && m22701d() && this.f18051e.m22714a(this.f18049c)) {
                    this.f18049c.m22682a(false);
                } else {
                    this.f18049c.m22678a(this.f18047a);
                }
                this.f18048b.release();
            } else {
                new ac(this).m22704a();
                this.f18048b.release();
            }
        } finally {
            this.f18048b.release();
        }
    }

    /* renamed from: c */
    private final boolean m22700c() {
        try {
            if (!this.f18049c.m22692k()) {
                this.f18049c.m22693l();
            }
            return true;
        } catch (IOException e) {
            String str = "FirebaseInstanceId";
            String str2 = "Build channel failed: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return false;
        }
    }

    /* renamed from: d */
    private final boolean m22701d() {
        aa f = this.f18049c.m22688f();
        if (f != null && !f.m22699b(this.f18050d.m22783b())) {
            return true;
        }
        String g;
        try {
            g = this.f18049c.m22689g();
            if (g == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (f == null || !(f == null || g.equals(f.f18044a))) {
                Context a = m22702a();
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", g);
                C5370y.m22801b(a, intent);
                C5370y.m22799a(a, new Intent("com.google.firebase.iid.TOKEN_REFRESH"));
            }
            return true;
        } catch (Exception e) {
            String str = "FirebaseInstanceId";
            g = "Token retrieval failed: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.e(str, valueOf.length() == 0 ? new String(g) : g.concat(valueOf));
            return false;
        }
    }

    /* renamed from: a */
    final Context m22702a() {
        return this.f18049c.m22683b().m22611a();
    }

    /* renamed from: b */
    final boolean m22703b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) m22702a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
