package com.p064b.p065a.p068c;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6441q;
import io.p347a.p348a.p349a.p350a.p352b.C6441q.C6440c;
import java.io.File;
import java.io.InputStream;

/* compiled from: QueueFileLogStore */
/* renamed from: com.b.a.c.y */
class C3442y implements C1060s {
    /* renamed from: a */
    private final File f9158a;
    /* renamed from: b */
    private final int f9159b;
    /* renamed from: c */
    private C6441q f9160c;

    public C3442y(File file, int i) {
        this.f9158a = file;
        this.f9159b = i;
    }

    /* renamed from: a */
    public C1017b mo754a() {
        if (!this.f9158a.exists()) {
            return null;
        }
        m11010d();
        if (this.f9160c == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.f9160c.a()];
        try {
            this.f9160c.a(new C6440c(this) {
                /* renamed from: c */
                final /* synthetic */ C3442y f9157c;

                /* renamed from: a */
                public void m11009a(InputStream inputStream, int i) {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            C6514c.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C1017b.m3495a(bArr, 0, iArr[0]);
    }

    /* renamed from: b */
    public void mo755b() {
        C6428i.a(this.f9160c, "There was a problem closing the Crashlytics log file.");
        this.f9160c = null;
    }

    /* renamed from: c */
    public void mo756c() {
        mo755b();
        this.f9158a.delete();
    }

    /* renamed from: d */
    private void m11010d() {
        if (this.f9160c == null) {
            try {
                this.f9160c = new C6441q(this.f9158a);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not open log file: ");
                stringBuilder.append(this.f9158a);
                C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
            }
        }
    }
}
