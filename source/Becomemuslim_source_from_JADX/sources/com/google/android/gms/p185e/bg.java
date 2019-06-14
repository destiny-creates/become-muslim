package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import java.util.Set;

/* renamed from: com.google.android.gms.e.bg */
final class bg extends aq {
    /* renamed from: a */
    private static final String f11632a = C4992a.f16284z.toString();
    /* renamed from: b */
    private static final String f11633b = ab.f16318f.toString();
    /* renamed from: c */
    private static final String f11634c = ab.f16335w.toString();
    /* renamed from: d */
    private static final String f11635d = ab.f16336x.toString();
    /* renamed from: e */
    private static final String f11636e = ab.f16328p.toString();

    public bg() {
        super(f11632a, f11633b);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.ct mo2506a(java.util.Map<java.lang.String, com.google.android.gms.internal.p210i.ct> r10) {
        /*
        r9 = this;
        r0 = f11633b;
        r0 = r10.get(r0);
        r0 = (com.google.android.gms.internal.p210i.ct) r0;
        if (r0 != 0) goto L_0x000f;
    L_0x000a:
        r10 = com.google.android.gms.p185e.eu.m8736g();
        return r10;
    L_0x000f:
        r1 = f11634c;
        r1 = r10.get(r1);
        r1 = (com.google.android.gms.internal.p210i.ct) r1;
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r1 = com.google.android.gms.p185e.eu.m8719a(r1);
        goto L_0x0020;
    L_0x001e:
        r1 = "";
    L_0x0020:
        r2 = f11635d;
        r2 = r10.get(r2);
        r2 = (com.google.android.gms.internal.p210i.ct) r2;
        if (r2 == 0) goto L_0x002f;
    L_0x002a:
        r2 = com.google.android.gms.p185e.eu.m8719a(r2);
        goto L_0x0031;
    L_0x002f:
        r2 = "=";
    L_0x0031:
        r3 = com.google.android.gms.p185e.bi.f7470a;
        r4 = f11636e;
        r10 = r10.get(r4);
        r10 = (com.google.android.gms.internal.p210i.ct) r10;
        r4 = 0;
        if (r10 == 0) goto L_0x008a;
    L_0x003e:
        r10 = com.google.android.gms.p185e.eu.m8719a(r10);
        r3 = "url";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x004d;
    L_0x004a:
        r3 = com.google.android.gms.p185e.bi.f7471b;
        goto L_0x008a;
    L_0x004d:
        r3 = "backslash";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x006c;
    L_0x0055:
        r3 = com.google.android.gms.p185e.bi.f7472c;
        r4 = new java.util.HashSet;
        r4.<init>();
        com.google.android.gms.p185e.bg.m14454a(r4, r1);
        com.google.android.gms.p185e.bg.m14454a(r4, r2);
        r10 = 92;
        r10 = java.lang.Character.valueOf(r10);
        r4.remove(r10);
        goto L_0x008a;
    L_0x006c:
        r0 = "Joiner: unsupported escape type: ";
        r10 = java.lang.String.valueOf(r10);
        r1 = r10.length();
        if (r1 == 0) goto L_0x007d;
    L_0x0078:
        r10 = r0.concat(r10);
        goto L_0x0082;
    L_0x007d:
        r10 = new java.lang.String;
        r10.<init>(r0);
    L_0x0082:
        com.google.android.gms.p185e.bs.m8582a(r10);
        r10 = com.google.android.gms.p185e.eu.m8736g();
        return r10;
    L_0x008a:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r5 = r0.f28857a;
        r6 = 0;
        switch(r5) {
            case 2: goto L_0x00c3;
            case 3: goto L_0x009d;
            default: goto L_0x0095;
        };
    L_0x0095:
        r0 = com.google.android.gms.p185e.eu.m8719a(r0);
        com.google.android.gms.p185e.bg.m14453a(r10, r0, r3, r4);
        goto L_0x00dd;
    L_0x009d:
        r5 = r0.f28860d;
        r5 = r5.length;
        if (r6 >= r5) goto L_0x00dd;
    L_0x00a2:
        if (r6 <= 0) goto L_0x00a7;
    L_0x00a4:
        r10.append(r1);
    L_0x00a7:
        r5 = r0.f28860d;
        r5 = r5[r6];
        r5 = com.google.android.gms.p185e.eu.m8719a(r5);
        r7 = r0.f28861e;
        r7 = r7[r6];
        r7 = com.google.android.gms.p185e.eu.m8719a(r7);
        com.google.android.gms.p185e.bg.m14453a(r10, r5, r3, r4);
        r10.append(r2);
        com.google.android.gms.p185e.bg.m14453a(r10, r7, r3, r4);
        r6 = r6 + 1;
        goto L_0x009d;
    L_0x00c3:
        r0 = r0.f28859c;
        r2 = r0.length;
        r5 = 1;
        r5 = 0;
        r7 = 1;
    L_0x00c9:
        if (r5 >= r2) goto L_0x00dd;
    L_0x00cb:
        r8 = r0[r5];
        if (r7 != 0) goto L_0x00d2;
    L_0x00cf:
        r10.append(r1);
    L_0x00d2:
        r7 = com.google.android.gms.p185e.eu.m8719a(r8);
        com.google.android.gms.p185e.bg.m14453a(r10, r7, r3, r4);
        r5 = r5 + 1;
        r7 = 0;
        goto L_0x00c9;
    L_0x00dd:
        r10 = r10.toString();
        r10 = com.google.android.gms.p185e.eu.m8716a(r10);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.bg.a(java.util.Map):com.google.android.gms.internal.i.ct");
    }

    /* renamed from: a */
    private static void m14454a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* renamed from: a */
    private static void m14453a(StringBuilder stringBuilder, String str, Integer num, Set<Character> set) {
        stringBuilder.append(bg.m14452a(str, num, set));
    }

    /* renamed from: a */
    private static String m14452a(String str, Integer num, Set<Character> set) {
        switch (bh.f7469a[num - 1]) {
            case 1:
                try {
                    return ey.m8744a(str);
                } catch (Integer num2) {
                    bs.m8583a("Joiner: unsupported encoding", num2);
                    return str;
                }
            case 2:
                str = str.replace("\\", "\\\\");
                for (Character ch : set) {
                    set = ch.toString();
                    String str2 = "\\";
                    String valueOf = String.valueOf(set);
                    str = str.replace(set, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return str;
            default:
                return str;
        }
    }
}
