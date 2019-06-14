package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class afg {
    /* renamed from: a */
    private final ByteBuffer f14418a;

    private afg(ByteBuffer byteBuffer) {
        this.f14418a = byteBuffer;
        this.f14418a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private afg(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    public static int m18342a(int i) {
        return i >= 0 ? m18357d(i) : 10;
    }

    /* renamed from: a */
    public static int m18343a(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: a */
    private static int m18344a(CharSequence charSequence) {
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
    public static int m18345a(String str) {
        int a = m18344a((CharSequence) str);
        return m18357d(a) + a;
    }

    /* renamed from: a */
    public static afg m18346a(byte[] bArr) {
        return m18347a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static afg m18347a(byte[] bArr, int i, int i2) {
        return new afg(bArr, 0, i2);
    }

    /* renamed from: a */
    private static void m18348a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i = 0;
        int arrayOffset;
        int remaining;
        char charAt;
        if (byteBuffer.hasArray()) {
            try {
                int i2;
                byte[] array = byteBuffer.array();
                arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
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
                            StringBuilder stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(i);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder(37);
                            stringBuilder2.append("Failed writing ");
                            stringBuilder2.append(charAt3);
                            stringBuilder2.append(" at index ");
                            stringBuilder2.append(arrayOffset);
                            throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
                        }
                        arrayOffset = i3;
                        i++;
                    }
                }
                byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                return;
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        int length2 = charSequence.length();
        while (i < length2) {
            arrayOffset = charSequence.charAt(i);
            if (arrayOffset >= 128) {
                if (arrayOffset < 2048) {
                    remaining = (arrayOffset >>> 6) | 960;
                } else {
                    if (arrayOffset >= 55296) {
                        if (57343 >= arrayOffset) {
                            remaining = i + 1;
                            if (remaining != charSequence.length()) {
                                charAt = charSequence.charAt(remaining);
                                if (Character.isSurrogatePair(arrayOffset, charAt)) {
                                    i = Character.toCodePoint(arrayOffset, charAt);
                                    byteBuffer.put((byte) ((i >>> 18) | 240));
                                    byteBuffer.put((byte) (((i >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((i >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((i & 63) | 128));
                                    i = remaining;
                                    i++;
                                } else {
                                    i = remaining;
                                }
                            }
                            i--;
                            stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(i);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    byteBuffer.put((byte) ((arrayOffset >>> 12) | 480));
                    remaining = ((arrayOffset >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) remaining);
                arrayOffset = (arrayOffset & 63) | 128;
            }
            byteBuffer.put((byte) arrayOffset);
            i++;
        }
    }

    /* renamed from: b */
    public static int m18349b(int i) {
        return m18357d(i << 3);
    }

    /* renamed from: b */
    public static int m18350b(int i, int i2) {
        return m18349b(i) + m18342a(i2);
    }

    /* renamed from: b */
    public static int m18351b(int i, afo afo) {
        i = m18349b(i);
        int d = afo.m18393d();
        return i + (m18357d(d) + d);
    }

    /* renamed from: b */
    public static int m18352b(int i, String str) {
        return m18349b(i) + m18345a(str);
    }

    /* renamed from: b */
    public static int m18353b(int i, byte[] bArr) {
        return m18349b(i) + m18354b(bArr);
    }

    /* renamed from: b */
    public static int m18354b(byte[] bArr) {
        return m18357d(bArr.length) + bArr.length;
    }

    /* renamed from: b */
    private final void m18355b(long j) {
        while ((-128 & j) != 0) {
            m18359e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m18359e((int) j);
    }

    /* renamed from: c */
    public static int m18356c(int i, long j) {
        return m18349b(i) + m18343a(j);
    }

    /* renamed from: d */
    public static int m18357d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: d */
    public static int m18358d(int i, long j) {
        return m18349b(i) + m18343a(j);
    }

    /* renamed from: e */
    private final void m18359e(int i) {
        byte b = (byte) i;
        if (this.f14418a.hasRemaining()) {
            this.f14418a.put(b);
            return;
        }
        throw new afh(this.f14418a.position(), this.f14418a.limit());
    }

    /* renamed from: a */
    public final void m18360a() {
        if (this.f14418a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.f14418a.remaining())}));
        }
    }

    /* renamed from: a */
    public final void m18361a(int i, int i2) {
        m18369c(i, 0);
        if (i2 >= 0) {
            m18368c(i2);
        } else {
            m18355b((long) i2);
        }
    }

    /* renamed from: a */
    public final void m18362a(int i, long j) {
        m18369c(i, 0);
        m18355b(j);
    }

    /* renamed from: a */
    public final void m18363a(int i, afo afo) {
        m18369c(i, 2);
        if (afo.f14431Z < 0) {
            afo.m18393d();
        }
        m18368c(afo.f14431Z);
        afo.mo3804a(this);
    }

    /* renamed from: a */
    public final void m18364a(int i, String str) {
        m18369c(i, 2);
        try {
            i = m18357d(str.length());
            if (i == m18357d(str.length() * 3)) {
                int position = this.f14418a.position();
                if (this.f14418a.remaining() >= i) {
                    this.f14418a.position(position + i);
                    m18348a((CharSequence) str, this.f14418a);
                    int position2 = this.f14418a.position();
                    this.f14418a.position(position);
                    m18368c((position2 - position) - i);
                    this.f14418a.position(position2);
                    return;
                }
                throw new afh(position + i, this.f14418a.limit());
            }
            m18368c(m18344a((CharSequence) str));
            m18348a((CharSequence) str, this.f14418a);
        } catch (Throwable e) {
            afh afh = new afh(this.f14418a.position(), this.f14418a.limit());
            afh.initCause(e);
            throw afh;
        }
    }

    /* renamed from: a */
    public final void m18365a(int i, boolean z) {
        m18369c(i, 0);
        byte b = (byte) z;
        if (this.f14418a.hasRemaining()) {
            this.f14418a.put(b);
            return;
        }
        throw new afh(this.f14418a.position(), this.f14418a.limit());
    }

    /* renamed from: a */
    public final void m18366a(int i, byte[] bArr) {
        m18369c(i, 2);
        m18368c(bArr.length);
        m18370c(bArr);
    }

    /* renamed from: b */
    public final void m18367b(int i, long j) {
        m18369c(i, 0);
        m18355b(j);
    }

    /* renamed from: c */
    public final void m18368c(int i) {
        while ((i & -128) != 0) {
            m18359e((i & 127) | 128);
            i >>>= 7;
        }
        m18359e(i);
    }

    /* renamed from: c */
    public final void m18369c(int i, int i2) {
        m18368c((i << 3) | i2);
    }

    /* renamed from: c */
    public final void m18370c(byte[] bArr) {
        int length = bArr.length;
        if (this.f14418a.remaining() >= length) {
            this.f14418a.put(bArr, 0, length);
            return;
        }
        throw new afh(this.f14418a.position(), this.f14418a.limit());
    }
}
