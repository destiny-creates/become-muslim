package com.google.android.gms.internal.p210i;

import com.facebook.internal.NativeProtocol;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.internal.i.iz */
public final class iz {
    /* renamed from: a */
    private final ByteBuffer f16772a;
    /* renamed from: b */
    private eq f16773b;
    /* renamed from: c */
    private int f16774c;

    private iz(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: d */
    public static int m20968d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    private iz(ByteBuffer byteBuffer) {
        this.f16772a = byteBuffer;
        this.f16772a.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    public static iz m20958a(byte[] bArr) {
        return iz.m20959a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static iz m20959a(byte[] bArr, int i, int i2) {
        return new iz(bArr, 0, i2);
    }

    /* renamed from: b */
    private final eq m20967b() {
        if (this.f16773b == null) {
            this.f16773b = eq.m31436a(this.f16772a);
            this.f16774c = this.f16772a.position();
        } else if (this.f16774c != this.f16772a.position()) {
            this.f16773b.mo6190b(this.f16772a.array(), this.f16774c, this.f16772a.position() - this.f16774c);
            this.f16774c = this.f16772a.position();
        }
        return this.f16773b;
    }

    /* renamed from: a */
    public final void m20972a(int i, long j) {
        m20980c(i, 0);
        m20960a(j);
    }

    /* renamed from: a */
    public final void m20971a(int i, int i2) {
        m20980c(i, 0);
        if (i2 >= 0) {
            m20979c(i2);
        } else {
            m20960a((long) i2);
        }
    }

    /* renamed from: a */
    public final void m20976a(int i, boolean z) {
        m20980c(i, 0);
        i = (byte) z;
        if (this.f16772a.hasRemaining()) {
            this.f16772a.put(i);
            return;
        }
        throw new ja(this.f16772a.position(), this.f16772a.limit());
    }

    /* renamed from: a */
    public final void m20975a(int i, String str) {
        m20980c(i, 2);
        try {
            i = iz.m20968d(str.length());
            if (i == iz.m20968d(str.length() * 3)) {
                int position = this.f16772a.position();
                if (this.f16772a.remaining() >= i) {
                    this.f16772a.position(position + i);
                    iz.m20961a((CharSequence) str, this.f16772a);
                    str = this.f16772a.position();
                    this.f16772a.position(position);
                    m20979c((str - position) - i);
                    this.f16772a.position(str);
                    return;
                }
                throw new ja(position + i, this.f16772a.limit());
            }
            m20979c(iz.m20956a((CharSequence) str));
            iz.m20961a((CharSequence) str, this.f16772a);
        } catch (int i2) {
            str = new ja(this.f16772a.position(), this.f16772a.limit());
            str.initCause(i2);
            throw str;
        }
    }

    /* renamed from: a */
    public final void m20974a(int i, jh jhVar) {
        m20980c(i, 2);
        m20977a(jhVar);
    }

    /* renamed from: a */
    public final void m20973a(int i, gt gtVar) {
        eq b = m20967b();
        b.mo6175a(i, gtVar);
        b.mo6169a();
        this.f16774c = this.f16772a.position();
    }

    /* renamed from: a */
    private static int m20956a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) >= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
                                i2++;
                            } else {
                                StringBuilder stringBuilder = new StringBuilder(39);
                                stringBuilder.append("Unpaired surrogate at index ");
                                stringBuilder.append(i2);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 >= length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                StringBuilder stringBuilder2 = new StringBuilder(54);
                stringBuilder2.append("UTF-8 length does not fit in int: ");
                stringBuilder2.append(j);
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        StringBuilder stringBuilder22 = new StringBuilder(54);
        stringBuilder22.append("UTF-8 length does not fit in int: ");
        stringBuilder22.append(j2);
        throw new IllegalArgumentException(stringBuilder22.toString());
    }

    /* renamed from: a */
    private static void m20961a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i = 0;
        int remaining;
        char charAt;
        if (byteBuffer.hasArray()) {
            try {
                int i2;
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                remaining = byteBuffer.remaining();
                int length = charSequence.length();
                remaining += arrayOffset;
                while (i < length) {
                    i2 = i + arrayOffset;
                    if (i2 >= remaining) {
                        break;
                    }
                    char charAt2 = charSequence.charAt(i);
                    if (charAt2 >= '') {
                        break;
                    }
                    array[i2] = (byte) charAt2;
                    i++;
                }
                if (i == length) {
                    arrayOffset += length;
                } else {
                    arrayOffset += i;
                    while (i < length) {
                        int i3;
                        char charAt3 = charSequence.charAt(i);
                        if (charAt3 < '' && arrayOffset < remaining) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) charAt3;
                        } else if (charAt3 < 'ࠀ' && arrayOffset <= remaining - 2) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) ((charAt3 >>> 6) | 960);
                            arrayOffset = i3 + 1;
                            array[i3] = (byte) ((charAt3 & 63) | 128);
                            i++;
                        } else if ((charAt3 < '?' || '?' < charAt3) && arrayOffset <= remaining - 3) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) ((charAt3 >>> 12) | 480);
                            arrayOffset = i3 + 1;
                            array[i3] = (byte) (((charAt3 >>> 6) & 63) | 128);
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) ((charAt3 & 63) | 128);
                        } else if (arrayOffset <= remaining - 4) {
                            i3 = i + 1;
                            if (i3 != charSequence.length()) {
                                charAt = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(charAt3, charAt)) {
                                    i = Character.toCodePoint(charAt3, charAt);
                                    i2 = arrayOffset + 1;
                                    array[arrayOffset] = (byte) ((i >>> 18) | 240);
                                    arrayOffset = i2 + 1;
                                    array[i2] = (byte) (((i >>> 12) & 63) | 128);
                                    i2 = arrayOffset + 1;
                                    array[arrayOffset] = (byte) (((i >>> 6) & 63) | 128);
                                    arrayOffset = i2 + 1;
                                    array[i2] = (byte) ((i & 63) | 128);
                                    i = i3;
                                    i++;
                                } else {
                                    i = i3;
                                }
                            }
                            i--;
                            byteBuffer = new StringBuilder(39);
                            byteBuffer.append("Unpaired surrogate at index ");
                            byteBuffer.append(i);
                            throw new IllegalArgumentException(byteBuffer.toString());
                        } else {
                            StringBuilder stringBuilder = new StringBuilder(37);
                            stringBuilder.append("Failed writing ");
                            stringBuilder.append(charAt3);
                            stringBuilder.append(" at index ");
                            stringBuilder.append(arrayOffset);
                            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                        }
                        arrayOffset = i3;
                        i++;
                    }
                }
                byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                return;
            } catch (CharSequence charSequence2) {
                byteBuffer = new BufferOverflowException();
                byteBuffer.initCause(charSequence2);
                throw byteBuffer;
            }
        }
        int length2 = charSequence2.length();
        while (i < length2) {
            char charAt4 = charSequence2.charAt(i);
            if (charAt4 < '') {
                byteBuffer.put((byte) charAt4);
            } else if (charAt4 < 'ࠀ') {
                byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                byteBuffer.put((byte) ((charAt4 & 63) | 128));
            } else {
                if (charAt4 >= '?') {
                    if ('?' >= charAt4) {
                        remaining = i + 1;
                        if (remaining != charSequence2.length()) {
                            charAt = charSequence2.charAt(remaining);
                            if (Character.isSurrogatePair(charAt4, charAt)) {
                                i = Character.toCodePoint(charAt4, charAt);
                                byteBuffer.put((byte) ((i >>> 18) | 240));
                                byteBuffer.put((byte) (((i >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((i >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((i & 63) | 128));
                                i = remaining;
                            } else {
                                i = remaining;
                            }
                        }
                        i--;
                        byteBuffer = new StringBuilder(39);
                        byteBuffer.append("Unpaired surrogate at index ");
                        byteBuffer.append(i);
                        throw new IllegalArgumentException(byteBuffer.toString());
                    }
                }
                byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt4 & 63) | 128));
            }
            i++;
        }
    }

    /* renamed from: a */
    public final void m20977a(jh jhVar) {
        m20979c(jhVar.m21016d());
        jhVar.mo4622a(this);
    }

    /* renamed from: b */
    public static int m20964b(int i, long j) {
        i = iz.m20962b(i);
        j = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        return i + j;
    }

    /* renamed from: b */
    public static int m20963b(int i, int i2) {
        return iz.m20962b(i) + iz.m20955a(i2);
    }

    /* renamed from: b */
    public static int m20966b(int i, String str) {
        return iz.m20962b(i) + iz.m20957a(str);
    }

    /* renamed from: b */
    public static int m20965b(int i, jh jhVar) {
        i = iz.m20962b(i);
        jhVar = jhVar.m21017e();
        return i + (iz.m20968d(jhVar) + jhVar);
    }

    /* renamed from: a */
    public static int m20955a(int i) {
        return i >= 0 ? iz.m20968d(i) : 10;
    }

    /* renamed from: a */
    public static int m20957a(String str) {
        str = iz.m20956a((CharSequence) str);
        return iz.m20968d(str) + str;
    }

    /* renamed from: a */
    public final void m20970a() {
        if (this.f16772a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.f16772a.remaining())}));
        }
    }

    /* renamed from: f */
    private final void m20969f(int i) {
        i = (byte) i;
        if (this.f16772a.hasRemaining()) {
            this.f16772a.put(i);
            return;
        }
        throw new ja(this.f16772a.position(), this.f16772a.limit());
    }

    /* renamed from: b */
    public final void m20978b(byte[] bArr) {
        int length = bArr.length;
        if (this.f16772a.remaining() >= length) {
            this.f16772a.put(bArr, 0, length);
            return;
        }
        throw new ja(this.f16772a.position(), this.f16772a.limit());
    }

    /* renamed from: c */
    public final void m20980c(int i, int i2) {
        m20979c((i << 3) | i2);
    }

    /* renamed from: b */
    public static int m20962b(int i) {
        return iz.m20968d(i << 3);
    }

    /* renamed from: c */
    public final void m20979c(int i) {
        while ((i & -128) != 0) {
            m20969f((i & 127) | 128);
            i >>>= 7;
        }
        m20969f(i);
    }

    /* renamed from: a */
    private final void m20960a(long j) {
        while ((-128 & j) != 0) {
            m20969f((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m20969f((int) j);
    }

    /* renamed from: e */
    public final void m20981e(int i) {
        if (this.f16772a.remaining() >= 4) {
            this.f16772a.putInt(i);
            return;
        }
        throw new ja(this.f16772a.position(), this.f16772a.limit());
    }
}
