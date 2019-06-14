package expolib_v1.p332b;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: ByteString */
/* renamed from: expolib_v1.b.f */
public class C6251f implements Serializable, Comparable<C6251f> {
    /* renamed from: a */
    static final char[] f20377a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    public static final C6251f f20378b = C6251f.m25838a(new byte[0]);
    private static final long serialVersionUID = 1;
    /* renamed from: c */
    final byte[] f20379c;
    /* renamed from: d */
    transient int f20380d;
    /* renamed from: e */
    transient String f20381e;

    public /* synthetic */ int compareTo(Object obj) {
        return m25849b((C6251f) obj);
    }

    C6251f(byte[] bArr) {
        this.f20379c = bArr;
    }

    /* renamed from: a */
    public static C6251f m25838a(byte... bArr) {
        if (bArr != null) {
            return new C6251f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static C6251f m25837a(String str) {
        if (str != null) {
            C6251f c6251f = new C6251f(str.getBytes(C6260u.f20398a));
            c6251f.f20381e = str;
            return c6251f;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public String mo5355a() {
        String str = this.f20381e;
        if (str != null) {
            return str;
        }
        str = new String(this.f20379c, C6260u.f20398a);
        this.f20381e = str;
        return str;
    }

    /* renamed from: b */
    public String mo5359b() {
        return C6248b.m25831a(this.f20379c);
    }

    /* renamed from: c */
    public C6251f mo5360c() {
        return m25841d("MD5");
    }

    /* renamed from: d */
    public C6251f mo5361d() {
        return m25841d("SHA-1");
    }

    /* renamed from: e */
    public C6251f mo5362e() {
        return m25841d("SHA-256");
    }

    /* renamed from: d */
    private C6251f m25841d(String str) {
        try {
            return C6251f.m25838a(MessageDigest.getInstance(str).digest(this.f20379c));
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    /* renamed from: b */
    public static C6251f m25839b(String str) {
        if (str != null) {
            str = C6248b.m25833a(str);
            return str != null ? new C6251f(str) : null;
        } else {
            throw new IllegalArgumentException("base64 == null");
        }
    }

    /* renamed from: f */
    public String mo5364f() {
        char[] cArr = new char[(this.f20379c.length * 2)];
        int i = 0;
        for (byte b : this.f20379c) {
            int i2 = i + 1;
            cArr[i] = f20377a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f20377a[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public static C6251f m25840c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((C6251f.m25834a(str.charAt(i2)) << 4) + C6251f.m25834a(str.charAt(i2 + 1)));
            }
            return C6251f.m25838a(bArr);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static int m25834a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static C6251f m25836a(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new C6251f(bArr);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: g */
    public C6251f mo5365g() {
        for (int i = 0; i < this.f20379c.length; i++) {
            byte b = this.f20379c[i];
            if (b >= (byte) 65) {
                if (b <= (byte) 90) {
                    byte[] bArr = (byte[]) this.f20379c.clone();
                    bArr[i] = (byte) (b + 32);
                    for (int i2 = i + 1; i2 < bArr.length; i2++) {
                        byte b2 = bArr[i2];
                        if (b2 >= (byte) 65) {
                            if (b2 <= (byte) 90) {
                                bArr[i2] = (byte) (b2 + 32);
                            }
                        }
                    }
                    return new C6251f(bArr);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    public C6251f mo5354a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 <= this.f20379c.length) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f20379c.length) {
                return this;
            } else {
                i2 = new byte[i3];
                System.arraycopy(this.f20379c, i, i2, 0, i3);
                return new C6251f(i2);
            }
        } else {
            i2 = new StringBuilder();
            i2.append("endIndex > length(");
            i2.append(this.f20379c.length);
            i2.append(")");
            throw new IllegalArgumentException(i2.toString());
        }
    }

    /* renamed from: a */
    public byte mo5353a(int i) {
        return this.f20379c[i];
    }

    /* renamed from: h */
    public int mo5366h() {
        return this.f20379c.length;
    }

    /* renamed from: i */
    public byte[] mo5368i() {
        return (byte[]) this.f20379c.clone();
    }

    /* renamed from: a */
    void mo5356a(C8170c c8170c) {
        c8170c.m39605b(this.f20379c, 0, this.f20379c.length);
    }

    /* renamed from: a */
    public boolean mo5357a(int i, C6251f c6251f, int i2, int i3) {
        return c6251f.mo5358a(i2, this.f20379c, i, i3);
    }

    /* renamed from: a */
    public boolean mo5358a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f20379c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C6260u.m25889a(this.f20379c, i, bArr, i2, i3) != 0;
    }

    /* renamed from: a */
    public final boolean m25848a(C6251f c6251f) {
        return mo5357a(0, c6251f, 0, c6251f.mo5366h());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6251f) {
            C6251f c6251f = (C6251f) obj;
            if (c6251f.mo5366h() == this.f20379c.length && c6251f.mo5358a(0, this.f20379c, 0, this.f20379c.length) != null) {
                return z;
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int i = this.f20380d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f20379c);
        this.f20380d = i;
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public int m25849b(expolib_v1.p332b.C6251f r10) {
        /*
        r9 = this;
        r0 = r9.mo5366h();
        r1 = r10.mo5366h();
        r2 = java.lang.Math.min(r0, r1);
        r3 = 0;
        r4 = 0;
    L_0x000e:
        r5 = -1;
        r6 = 1;
        if (r4 >= r2) goto L_0x0028;
    L_0x0012:
        r7 = r9.mo5353a(r4);
        r7 = r7 & 255;
        r8 = r10.mo5353a(r4);
        r8 = r8 & 255;
        if (r7 != r8) goto L_0x0023;
    L_0x0020:
        r4 = r4 + 1;
        goto L_0x000e;
    L_0x0023:
        if (r7 >= r8) goto L_0x0026;
    L_0x0025:
        goto L_0x0027;
    L_0x0026:
        r5 = 1;
    L_0x0027:
        return r5;
    L_0x0028:
        if (r0 != r1) goto L_0x002b;
    L_0x002a:
        return r3;
    L_0x002b:
        if (r0 >= r1) goto L_0x002e;
    L_0x002d:
        goto L_0x002f;
    L_0x002e:
        r5 = 1;
    L_0x002f:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.b.f.b(expolib_v1.b.f):int");
    }

    public String toString() {
        if (this.f20379c.length == 0) {
            return "[size=0]";
        }
        String a = mo5355a();
        int a2 = C6251f.m25835a(a, 64);
        StringBuilder stringBuilder;
        if (a2 == -1) {
            if (this.f20379c.length <= 64) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[hex=");
                stringBuilder.append(mo5364f());
                stringBuilder.append("]");
                a = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[size=");
                stringBuilder.append(this.f20379c.length);
                stringBuilder.append(" hex=");
                stringBuilder.append(mo5354a(0, 64).mo5364f());
                stringBuilder.append("…]");
                a = stringBuilder.toString();
            }
            return a;
        }
        String replace = a.substring(0, a2).replace("\\", "\\\\").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\\n").replace("\r", "\\r");
        if (a2 < a.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[size=");
            stringBuilder.append(this.f20379c.length);
            stringBuilder.append(" text=");
            stringBuilder.append(replace);
            stringBuilder.append("…]");
            a = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[text=");
            stringBuilder.append(replace);
            stringBuilder.append("]");
            a = stringBuilder.toString();
        }
        return a;
    }

    /* renamed from: a */
    static int m25835a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(java.io.ObjectInputStream r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.readInt();
        r3 = expolib_v1.p332b.C6251f.m25836a(r3, r0);
        r0 = expolib_v1.p332b.C6251f.class;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = "c";	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r3 = r3.f20379c;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.set(r2, r3);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        return;
    L_0x001a:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
    L_0x0020:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.b.f.readObject(java.io.ObjectInputStream):void");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f20379c.length);
        objectOutputStream.write(this.f20379c);
    }
}
