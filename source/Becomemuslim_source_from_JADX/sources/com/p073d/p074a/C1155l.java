package com.p073d.p074a;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/* compiled from: PayloadQueue */
/* renamed from: com.d.a.l */
abstract class C1155l implements Closeable {

    /* compiled from: PayloadQueue */
    /* renamed from: com.d.a.l$a */
    interface C1154a {
        /* renamed from: a */
        boolean mo793a(InputStream inputStream, int i);
    }

    /* compiled from: PayloadQueue */
    /* renamed from: com.d.a.l$b */
    static class C3479b extends C1155l {
        /* renamed from: a */
        final LinkedList<byte[]> f9269a = new LinkedList();

        public void close() {
        }

        C3479b() {
        }

        /* renamed from: a */
        int mo788a() {
            return this.f9269a.size();
        }

        /* renamed from: a */
        void mo789a(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                this.f9269a.remove();
            }
        }

        /* renamed from: a */
        void mo791a(byte[] bArr) {
            this.f9269a.add(bArr);
        }

        /* renamed from: a */
        void mo790a(C1154a c1154a) {
            int i = 0;
            while (i < this.f9269a.size()) {
                byte[] bArr = (byte[]) this.f9269a.get(i);
                if (c1154a.mo793a(new ByteArrayInputStream(bArr), bArr.length)) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: PayloadQueue */
    /* renamed from: com.d.a.l$c */
    static class C3480c extends C1155l {
        /* renamed from: a */
        final C1158o f9270a;

        C3480c(C1158o c1158o) {
            this.f9270a = c1158o;
        }

        /* renamed from: a */
        int mo788a() {
            return this.f9270a.m4109b();
        }

        /* renamed from: a */
        void mo789a(int i) {
            try {
                this.f9270a.m4110b(i);
            } catch (int i2) {
                throw new IOException(i2);
            }
        }

        /* renamed from: a */
        void mo791a(byte[] bArr) {
            this.f9270a.m4106a(bArr);
        }

        /* renamed from: a */
        void mo790a(C1154a c1154a) {
            this.f9270a.m4104a(c1154a);
        }

        public void close() {
            this.f9270a.close();
        }
    }

    /* renamed from: a */
    abstract int mo788a();

    /* renamed from: a */
    abstract void mo789a(int i);

    /* renamed from: a */
    abstract void mo790a(C1154a c1154a);

    /* renamed from: a */
    abstract void mo791a(byte[] bArr);

    C1155l() {
    }
}
