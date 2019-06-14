package org.spongycastle.crypto.tls;

import java.util.Hashtable;
import org.spongycastle.util.Integers;

public class TlsExtensionsUtils {
    /* renamed from: a */
    public static final Integer f22584a = Integers.m29396a(22);
    /* renamed from: b */
    public static final Integer f22585b = Integers.m29396a(23);
    /* renamed from: c */
    public static final Integer f22586c = Integers.m29396a(15);
    /* renamed from: d */
    public static final Integer f22587d = Integers.m29396a(1);
    /* renamed from: e */
    public static final Integer f22588e = Integers.m29396a(0);
    /* renamed from: f */
    public static final Integer f22589f = Integers.m29396a(5);
    /* renamed from: g */
    public static final Integer f22590g = Integers.m29396a(4);

    /* renamed from: a */
    public static Hashtable m27681a(Hashtable hashtable) {
        return hashtable == null ? new Hashtable() : hashtable;
    }

    /* renamed from: b */
    public static void m27686b(Hashtable hashtable) {
        hashtable.put(f22584a, m27688b());
    }

    /* renamed from: c */
    public static void m27690c(Hashtable hashtable) {
        hashtable.put(f22585b, m27691c());
    }

    /* renamed from: a */
    public static void m27682a(Hashtable hashtable, short s) {
        hashtable.put(f22587d, m27685a(s));
    }

    /* renamed from: d */
    public static void m27692d(Hashtable hashtable) {
        hashtable.put(f22590g, m27694d());
    }

    /* renamed from: e */
    public static short m27695e(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22587d);
        if (a == null) {
            return (short) -1;
        }
        return m27689c(a);
    }

    /* renamed from: f */
    public static boolean m27697f(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22584a);
        if (a == null) {
            return null;
        }
        return m27683a(a);
    }

    /* renamed from: g */
    public static boolean m27698g(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22585b);
        if (a == null) {
            return null;
        }
        return m27687b(a);
    }

    /* renamed from: h */
    public static boolean m27699h(Hashtable hashtable) {
        byte[] a = TlsUtils.m27827a(hashtable, f22590g);
        if (a == null) {
            return null;
        }
        return m27693d(a);
    }

    /* renamed from: a */
    public static byte[] m27684a() {
        return TlsUtils.f22634a;
    }

    /* renamed from: b */
    public static byte[] m27688b() {
        return m27684a();
    }

    /* renamed from: c */
    public static byte[] m27691c() {
        return m27684a();
    }

    /* renamed from: a */
    public static byte[] m27685a(short s) {
        TlsUtils.m27816a(s);
        byte[] bArr = new byte[1];
        TlsUtils.m27818a(s, bArr, 0);
        return bArr;
    }

    /* renamed from: d */
    public static byte[] m27694d() {
        return m27684a();
    }

    /* renamed from: e */
    private static boolean m27696e(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        } else if (bArr.length == null) {
            return 1;
        } else {
            throw new TlsFatalAlert((short) 47);
        }
    }

    /* renamed from: a */
    public static boolean m27683a(byte[] bArr) {
        return m27696e(bArr);
    }

    /* renamed from: b */
    public static boolean m27687b(byte[] bArr) {
        return m27696e(bArr);
    }

    /* renamed from: c */
    public static short m27689c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        } else if (bArr.length == 1) {
            return TlsUtils.m27804a(bArr, 0);
        } else {
            throw new TlsFatalAlert((short) 50);
        }
    }

    /* renamed from: d */
    public static boolean m27693d(byte[] bArr) {
        return m27696e(bArr);
    }
}
