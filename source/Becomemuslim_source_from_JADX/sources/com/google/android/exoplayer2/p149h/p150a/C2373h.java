package com.google.android.exoplayer2.p149h.p150a;

import android.util.Log;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C4250r.C4249e;

/* compiled from: ChunkedTrackBlacklistUtil */
/* renamed from: com.google.android.exoplayer2.h.a.h */
public final class C2373h {
    /* renamed from: a */
    public static boolean m6564a(C2484f c2484f, int i, Exception exception) {
        return C2373h.m6565a(c2484f, i, exception, 60000);
    }

    /* renamed from: a */
    public static boolean m6565a(C2484f c2484f, int i, Exception exception, long j) {
        if (!C2373h.m6566a(exception)) {
            return null;
        }
        boolean a = c2484f.mo2300a(i, j);
        exception = ((C4249e) exception).f11212c;
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Blacklisted: duration=");
            stringBuilder.append(j);
            stringBuilder.append(", responseCode=");
            stringBuilder.append(exception);
            stringBuilder.append(", format=");
            stringBuilder.append(c2484f.mo2299a(i));
            Log.w("ChunkedTrackBlacklist", stringBuilder.toString());
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
            stringBuilder2.append(exception);
            stringBuilder2.append(", format=");
            stringBuilder2.append(c2484f.mo2299a(i));
            Log.w("ChunkedTrackBlacklist", stringBuilder2.toString());
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m6566a(Exception exception) {
        boolean z = false;
        if (!(exception instanceof C4249e)) {
            return false;
        }
        exception = ((C4249e) exception).f11212c;
        if (exception == 404 || exception == 410) {
            z = true;
        }
        return z;
    }
}
