package com.google.android.gms.p190g;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.g.b */
public class C3052b {
    /* renamed from: a */
    private C3042b f7776a;
    /* renamed from: b */
    private ByteBuffer f7777b;
    /* renamed from: c */
    private Bitmap f7778c;

    /* renamed from: com.google.android.gms.g.b$a */
    public static class C3041a {
        /* renamed from: a */
        private C3052b f7750a = new C3052b();

        /* renamed from: a */
        public C3041a m8873a(int i) {
            this.f7750a.m8910a().f7755e = i;
            return this;
        }

        /* renamed from: a */
        public C3041a m8874a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.f7750a.f7778c = bitmap;
            C3042b a = this.f7750a.m8910a();
            a.f7751a = width;
            a.f7752b = height;
            return this;
        }

        /* renamed from: a */
        public C3041a m8875a(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() >= i * i2) {
                if (i3 != 842094169) {
                    switch (i3) {
                        case 16:
                        case 17:
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder(37);
                            stringBuilder.append("Unsupported image format: ");
                            stringBuilder.append(i3);
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                this.f7750a.f7777b = byteBuffer;
                C3042b a = this.f7750a.m8910a();
                a.f7751a = i;
                a.f7752b = i2;
                a.f7756f = i3;
                return this;
            } else {
                throw new IllegalArgumentException("Invalid image data size.");
            }
        }

        /* renamed from: a */
        public C3052b m8876a() {
            if (this.f7750a.f7777b == null) {
                if (this.f7750a.f7778c == null) {
                    throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
                }
            }
            return this.f7750a;
        }
    }

    /* renamed from: com.google.android.gms.g.b$b */
    public static class C3042b {
        /* renamed from: a */
        private int f7751a;
        /* renamed from: b */
        private int f7752b;
        /* renamed from: c */
        private int f7753c;
        /* renamed from: d */
        private long f7754d;
        /* renamed from: e */
        private int f7755e;
        /* renamed from: f */
        private int f7756f = -1;

        /* renamed from: a */
        public int m8881a() {
            return this.f7751a;
        }

        /* renamed from: b */
        public int m8882b() {
            return this.f7752b;
        }

        /* renamed from: c */
        public int m8883c() {
            return this.f7753c;
        }

        /* renamed from: d */
        public long m8884d() {
            return this.f7754d;
        }

        /* renamed from: e */
        public int m8885e() {
            return this.f7755e;
        }
    }

    private C3052b() {
        this.f7776a = new C3042b();
        this.f7777b = null;
        this.f7778c = null;
    }

    /* renamed from: a */
    public C3042b m8910a() {
        return this.f7776a;
    }

    /* renamed from: b */
    public ByteBuffer m8911b() {
        if (this.f7778c == null) {
            return this.f7777b;
        }
        int width = this.f7778c.getWidth();
        int height = this.f7778c.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        this.f7778c.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArr[i2] = (byte) ((int) (((((float) Color.red(iArr[i2])) * 0.299f) + (((float) Color.green(iArr[i2])) * 0.587f)) + (((float) Color.blue(iArr[i2])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: c */
    public Bitmap m8912c() {
        return this.f7778c;
    }
}
