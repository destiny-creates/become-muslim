package com.p064b.p065a.p066a;

import android.content.Context;
import android.os.Looper;
import io.p347a.p348a.p349a.p350a.p352b.C7607s;
import io.p347a.p348a.p349a.p350a.p355d.C8182g;
import io.p347a.p348a.p349a.p350a.p357f.C6489a;

/* compiled from: AnswersFilesManagerProvider */
/* renamed from: com.b.a.a.c */
class C0988c {
    /* renamed from: a */
    final Context f2753a;
    /* renamed from: b */
    final C6489a f2754b;

    public C0988c(Context context, C6489a c6489a) {
        this.f2753a = context;
        this.f2754b = c6489a;
    }

    /* renamed from: a */
    public C3409o m3426a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new C3409o(this.f2753a, new C3413u(), new C7607s(), new C8182g(this.f2753a, this.f2754b.a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
