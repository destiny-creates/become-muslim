package com.google.android.exoplayer2.p134a;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p134a.C2222d.C2221a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ResamplingAudioProcessor */
/* renamed from: com.google.android.exoplayer2.a.k */
final class C4082k implements C2222d {
    /* renamed from: b */
    private int f10287b = -1;
    /* renamed from: c */
    private int f10288c = -1;
    /* renamed from: d */
    private int f10289d = 0;
    /* renamed from: e */
    private ByteBuffer f10290e = a;
    /* renamed from: f */
    private ByteBuffer f10291f = a;
    /* renamed from: g */
    private boolean f10292g;

    /* renamed from: c */
    public int mo2112c() {
        return 2;
    }

    /* renamed from: a */
    public boolean mo2110a(int i, int i2, int i3) {
        if (!(i3 == 3 || i3 == 2 || i3 == LinearLayoutManager.INVALID_OFFSET)) {
            if (i3 != 1073741824) {
                throw new C2221a(i, i2, i3);
            }
        }
        if (this.f10287b == i && this.f10288c == i2 && this.f10289d == i3) {
            return false;
        }
        this.f10287b = i;
        this.f10288c = i2;
        this.f10289d = i3;
        if (i3 == 2) {
            this.f10290e = a;
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo2109a() {
        return (this.f10289d == 0 || this.f10289d == 2) ? false : true;
    }

    /* renamed from: b */
    public int mo2111b() {
        return this.f10288c;
    }

    /* renamed from: d */
    public int mo2113d() {
        return this.f10287b;
    }

    /* renamed from: a */
    public void mo2108a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.f10289d;
        if (i2 == LinearLayoutManager.INVALID_OFFSET) {
            i = (i / 3) * 2;
        } else if (i2 == 3) {
            i *= 2;
        } else if (i2 == 1073741824) {
            i /= 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.f10290e.capacity() < i) {
            this.f10290e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f10290e.clear();
        }
        i = this.f10289d;
        if (i == LinearLayoutManager.INVALID_OFFSET) {
            while (position < limit) {
                this.f10290e.put(byteBuffer.get(position + 1));
                this.f10290e.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i == 3) {
            while (position < limit) {
                this.f10290e.put((byte) 0);
                this.f10290e.put((byte) ((byteBuffer.get(position) & JfifUtil.MARKER_FIRST_BYTE) - 128));
                position++;
            }
        } else if (i == 1073741824) {
            while (position < limit) {
                this.f10290e.put(byteBuffer.get(position + 2));
                this.f10290e.put(byteBuffer.get(position + 3));
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        this.f10290e.flip();
        this.f10291f = this.f10290e;
    }

    /* renamed from: e */
    public void mo2114e() {
        this.f10292g = true;
    }

    /* renamed from: f */
    public ByteBuffer mo2115f() {
        ByteBuffer byteBuffer = this.f10291f;
        this.f10291f = a;
        return byteBuffer;
    }

    /* renamed from: g */
    public boolean mo2116g() {
        return this.f10292g && this.f10291f == a;
    }

    /* renamed from: h */
    public void mo2117h() {
        this.f10291f = a;
        this.f10292g = false;
    }

    /* renamed from: i */
    public void mo2118i() {
        mo2117h();
        this.f10290e = a;
        this.f10287b = -1;
        this.f10288c = -1;
        this.f10289d = 0;
    }
}
