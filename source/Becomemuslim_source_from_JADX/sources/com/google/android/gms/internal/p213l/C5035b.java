package com.google.android.gms.internal.p213l;

import com.facebook.internal.NativeProtocol;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: com.google.android.gms.internal.l.b */
public final class C5035b {
    /* renamed from: a */
    private final ByteBuffer f16960a;

    private C5035b(ByteBuffer byteBuffer) {
        this.f16960a = byteBuffer;
        this.f16960a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private C5035b(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* renamed from: a */
    public static int m21279a(int i) {
        return i >= 0 ? C5035b.m21292d(i) : 10;
    }

    /* renamed from: a */
    public static int m21280a(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: a */
    private static int m21281a(CharSequence charSequence) {
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
    public static int m21282a(String str) {
        int a = C5035b.m21281a((CharSequence) str);
        return C5035b.m21292d(a) + a;
    }

    /* renamed from: a */
    public static C5035b m21283a(byte[] bArr) {
        return C5035b.m21284a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C5035b m21284a(byte[] bArr, int i, int i2) {
        return new C5035b(bArr, 0, i2);
    }

    /* renamed from: a */
    private static void m21285a(CharSequence charSequence, ByteBuffer byteBuffer) {
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
    public static int m21286b(int i) {
        return C5035b.m21292d(i << 3);
    }

    /* renamed from: b */
    public static int m21287b(int i, int i2) {
        return C5035b.m21286b(i) + C5035b.m21279a(i2);
    }

    /* renamed from: b */
    public static int m21288b(int i, C5043j c5043j) {
        i = C5035b.m21286b(i);
        int d = c5043j.m21444d();
        return i + (C5035b.m21292d(d) + d);
    }

    /* renamed from: b */
    public static int m21289b(int i, String str) {
        return C5035b.m21286b(i) + C5035b.m21282a(str);
    }

    /* renamed from: b */
    private final void m21290b(long j) {
        while ((-128 & j) != 0) {
            m21293e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m21293e((int) j);
    }

    /* renamed from: c */
    public static int m21291c(int i, long j) {
        return C5035b.m21286b(i) + C5035b.m21280a(j);
    }

    /* renamed from: d */
    public static int m21292d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    /* renamed from: e */
    private final void m21293e(int i) {
        byte b = (byte) i;
        if (this.f16960a.hasRemaining()) {
            this.f16960a.put(b);
            return;
        }
        throw new C5036c(this.f16960a.position(), this.f16960a.limit());
    }

    /* renamed from: a */
    public final void m21294a() {
        if (this.f16960a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.f16960a.remaining())}));
        }
    }

    /* renamed from: a */
    public final void m21295a(int i, double d) {
        m21306c(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.f16960a.remaining() >= 8) {
            this.f16960a.putLong(doubleToLongBits);
            return;
        }
        throw new C5036c(this.f16960a.position(), this.f16960a.limit());
    }

    /* renamed from: a */
    public final void m21296a(int i, float f) {
        m21306c(i, 5);
        i = Float.floatToIntBits(f);
        if (this.f16960a.remaining() >= 4) {
            this.f16960a.putInt(i);
            return;
        }
        throw new C5036c(this.f16960a.position(), this.f16960a.limit());
    }

    /* renamed from: a */
    public final void m21297a(int i, int i2) {
        m21306c(i, 0);
        if (i2 >= 0) {
            m21305c(i2);
        } else {
            m21290b((long) i2);
        }
    }

    /* renamed from: a */
    public final void m21298a(int i, long j) {
        m21306c(i, 0);
        m21290b(j);
    }

    /* renamed from: a */
    public final void m21299a(int i, C5043j c5043j) {
        m21306c(i, 2);
        m21302a(c5043j);
    }

    /* renamed from: a */
    public final void m21300a(int i, String str) {
        m21306c(i, 2);
        try {
            i = C5035b.m21292d(str.length());
            if (i == C5035b.m21292d(str.length() * 3)) {
                int position = this.f16960a.position();
                if (this.f16960a.remaining() >= i) {
                    this.f16960a.position(position + i);
                    C5035b.m21285a((CharSequence) str, this.f16960a);
                    int position2 = this.f16960a.position();
                    this.f16960a.position(position);
                    m21305c((position2 - position) - i);
                    this.f16960a.position(position2);
                    return;
                }
                throw new C5036c(position + i, this.f16960a.limit());
            }
            m21305c(C5035b.m21281a((CharSequence) str));
            C5035b.m21285a((CharSequence) str, this.f16960a);
        } catch (Throwable e) {
            C5036c c5036c = new C5036c(this.f16960a.position(), this.f16960a.limit());
            c5036c.initCause(e);
            throw c5036c;
        }
    }

    /* renamed from: a */
    public final void m21301a(int i, boolean z) {
        m21306c(i, 0);
        byte b = (byte) z;
        if (this.f16960a.hasRemaining()) {
            this.f16960a.put(b);
            return;
        }
        throw new C5036c(this.f16960a.position(), this.f16960a.limit());
    }

    /* renamed from: a */
    public final void m21302a(C5043j c5043j) {
        m21305c(c5043j.m21443c());
        c5043j.mo4757a(this);
    }

    /* renamed from: b */
    public final void m21303b(int i, long j) {
        m21306c(i, 0);
        m21290b(j);
    }

    /* renamed from: b */
    public final void m21304b(byte[] bArr) {
        int length = bArr.length;
        if (this.f16960a.remaining() >= length) {
            this.f16960a.put(bArr, 0, length);
            return;
        }
        throw new C5036c(this.f16960a.position(), this.f16960a.limit());
    }

    /* renamed from: c */
    public final void m21305c(int i) {
        while ((i & -128) != 0) {
            m21293e((i & 127) | 128);
            i >>>= 7;
        }
        m21293e(i);
    }

    /* renamed from: c */
    public final void m21306c(int i, int i2) {
        m21305c((i << 3) | i2);
    }
}
