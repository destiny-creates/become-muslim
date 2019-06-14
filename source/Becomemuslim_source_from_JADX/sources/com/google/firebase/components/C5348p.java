package com.google.firebase.components;

import com.google.firebase.p244a.C5320a;
import com.google.firebase.p244a.C5321b;
import java.util.Map.Entry;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.p */
final /* synthetic */ class C5348p implements Runnable {
    /* renamed from: a */
    private final Entry f18025a;
    /* renamed from: b */
    private final C5320a f18026b;

    private C5348p(Entry entry, C5320a c5320a) {
        this.f18025a = entry;
        this.f18026b = c5320a;
    }

    /* renamed from: a */
    public static Runnable m22660a(Entry entry, C5320a c5320a) {
        return new C5348p(entry, c5320a);
    }

    public final void run() {
        ((C5321b) this.f18025a.getKey()).mo4885a(this.f18026b);
    }
}
