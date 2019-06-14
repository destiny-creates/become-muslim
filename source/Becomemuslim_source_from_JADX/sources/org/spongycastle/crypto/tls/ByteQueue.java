package org.spongycastle.crypto.tls;

public class ByteQueue {
    /* renamed from: a */
    private byte[] f22461a;
    /* renamed from: b */
    private int f22462b;
    /* renamed from: c */
    private int f22463c;

    /* renamed from: a */
    public static int m27535a(int i) {
        i |= i >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        return (i | (i >> 16)) + 1;
    }

    public ByteQueue() {
        this(1024);
    }

    public ByteQueue(int i) {
        this.f22462b = 0;
        this.f22463c = 0;
        this.f22461a = new byte[i];
    }

    /* renamed from: a */
    public void m27538a(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length - i < i2) {
            i3 = new StringBuilder();
            i3.append("Buffer size of ");
            i3.append(bArr.length);
            i3.append(" is too small for a read of ");
            i3.append(i2);
            i3.append(" bytes");
            throw new IllegalArgumentException(i3.toString());
        } else if (this.f22463c - i3 >= i2) {
            System.arraycopy(this.f22461a, this.f22462b + i3, bArr, i, i2);
        } else {
            throw new IllegalStateException("Not enough data to read");
        }
    }

    /* renamed from: a */
    public void m27537a(byte[] bArr, int i, int i2) {
        if ((this.f22462b + this.f22463c) + i2 > this.f22461a.length) {
            int a = m27535a(this.f22463c + i2);
            if (a > this.f22461a.length) {
                Object obj = new byte[a];
                System.arraycopy(this.f22461a, this.f22462b, obj, 0, this.f22463c);
                this.f22461a = obj;
            } else {
                System.arraycopy(this.f22461a, this.f22462b, this.f22461a, 0, this.f22463c);
            }
            this.f22462b = 0;
        }
        System.arraycopy(bArr, i, this.f22461a, this.f22462b + this.f22463c, i2);
        this.f22463c += i2;
    }

    /* renamed from: b */
    public void m27540b(int i) {
        if (i <= this.f22463c) {
            this.f22463c -= i;
            this.f22462b += i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot remove ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes, only got ");
        stringBuilder.append(this.f22463c);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: b */
    public void m27541b(byte[] bArr, int i, int i2, int i3) {
        m27538a(bArr, i, i2, i3);
        m27540b(i3 + i2);
    }

    /* renamed from: a */
    public byte[] m27539a(int i, int i2) {
        byte[] bArr = new byte[i];
        m27541b(bArr, 0, i, i2);
        return bArr;
    }

    /* renamed from: a */
    public int m27536a() {
        return this.f22463c;
    }
}
