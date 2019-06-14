package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.bc.C8329b;
import com.google.android.gms.internal.p210i.bc.C8333d;
import com.google.android.gms.internal.p210i.bc.C8335e;
import com.google.android.gms.internal.p210i.co.C7811a;
import com.google.android.gms.p185e.bs;
import com.google.android.gms.p185e.eu;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.i.cx */
public final class cx {
    /* renamed from: a */
    public static db m20401a(cq cqVar) {
        int i;
        ct[] ctVarArr = new ct[cqVar.f28833b.length];
        int i2 = 0;
        for (int i3 = 0; i3 < cqVar.f28833b.length; i3++) {
            cx.m20398a(i3, cqVar, ctVarArr, new HashSet(0));
        }
        dc a = db.m20413a();
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < cqVar.f28836e.length; i4++) {
            arrayList.add(cx.m20400a(cqVar.f28836e[i4], cqVar, ctVarArr, i4));
        }
        List arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < cqVar.f28837f.length; i5++) {
            arrayList2.add(cx.m20400a(cqVar.f28837f[i5], cqVar, ctVarArr, i5));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < cqVar.f28835d.length; i++) {
            cz a2 = cx.m20400a(cqVar.f28835d[i], cqVar, ctVarArr, i);
            a.m20419a(a2);
            arrayList3.add(a2);
        }
        C8335e[] c8335eArr = cqVar.f28838g;
        i = c8335eArr.length;
        while (i2 < i) {
            C8335e c8335e = c8335eArr[i2];
            de deVar = new de();
            for (Integer intValue : c8335e.m43871a()) {
                deVar.m20429a((cz) arrayList2.get(intValue.intValue()));
            }
            for (Integer intValue2 : c8335e.m43872b()) {
                deVar.m20431b((cz) arrayList2.get(intValue2.intValue()));
            }
            for (Integer intValue22 : c8335e.m43873c()) {
                deVar.m20433c((cz) arrayList.get(intValue22.intValue()));
            }
            for (Integer intValue222 : c8335e.m43875e()) {
                deVar.m20430a(cqVar.f28833b[intValue222.intValue()].f28858b);
            }
            for (Integer intValue2222 : c8335e.m43874d()) {
                deVar.m20435d((cz) arrayList.get(intValue2222.intValue()));
            }
            for (Integer intValue22222 : c8335e.m43876f()) {
                deVar.m20432b(cqVar.f28833b[intValue22222.intValue()].f28858b);
            }
            for (Integer intValue222222 : c8335e.m43877g()) {
                deVar.m20437e((cz) arrayList3.get(intValue222222.intValue()));
            }
            for (Integer intValue2222222 : c8335e.m43879i()) {
                deVar.m20434c(cqVar.f28833b[intValue2222222.intValue()].f28858b);
            }
            for (Integer intValue22222222 : c8335e.m43878h()) {
                deVar.m20438f((cz) arrayList3.get(intValue22222222.intValue()));
            }
            for (Integer intValue3 : c8335e.m43880j()) {
                deVar.m20436d(cqVar.f28833b[intValue3.intValue()].f28858b);
            }
            a.m20420a(deVar.m20428a());
            i2++;
        }
        a.m20421a(cqVar.f28839h);
        a.m20418a(cqVar.f28840i);
        return a.m20417a();
    }

    /* renamed from: a */
    public static ct m20399a(ct ctVar) {
        ct ctVar2 = new ct();
        ctVar2.f28857a = ctVar.f28857a;
        ctVar2.f28867k = (int[]) ctVar.f28867k.clone();
        if (ctVar.f28868l) {
            ctVar2.f28868l = ctVar.f28868l;
        }
        return ctVar2;
    }

    /* renamed from: a */
    private static ct m20398a(int i, cq cqVar, ct[] ctVarArr, Set<Integer> set) {
        if (set.contains(Integer.valueOf(i))) {
            String valueOf = String.valueOf(set);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 90);
            stringBuilder.append("Value cycle detected.  Current value reference: ");
            stringBuilder.append(i);
            stringBuilder.append(".  Previous value references: ");
            stringBuilder.append(valueOf);
            stringBuilder.append(".");
            cx.m20404a(stringBuilder.toString());
        }
        ct ctVar = (ct) cx.m20402a(cqVar.f28833b, i, "values");
        if (ctVarArr[i] != null) {
            return ctVarArr[i];
        }
        ct ctVar2 = null;
        set.add(Integer.valueOf(i));
        int i2 = 0;
        int length;
        int i3;
        int i4;
        C7811a b;
        int[] iArr;
        switch (ctVar.f28857a) {
            case 1:
            case 5:
            case 6:
            case 8:
                ctVar2 = ctVar;
                break;
            case 2:
                C7811a b2 = cx.m20405b(ctVar);
                ct a = cx.m20399a(ctVar);
                a.f28859c = new ct[b2.f28822b.length];
                int[] iArr2 = b2.f28822b;
                length = iArr2.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    a.f28859c[i3] = cx.m20398a(iArr2[i2], cqVar, ctVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                ctVar2 = a;
                break;
            case 3:
                ctVar2 = cx.m20399a(ctVar);
                b = cx.m20405b(ctVar);
                if (b.f28823c.length != b.f28824d.length) {
                    length = b.f28823c.length;
                    i3 = b.f28824d.length;
                    StringBuilder stringBuilder2 = new StringBuilder(58);
                    stringBuilder2.append("Uneven map keys (");
                    stringBuilder2.append(length);
                    stringBuilder2.append(") and map values (");
                    stringBuilder2.append(i3);
                    stringBuilder2.append(")");
                    cx.m20404a(stringBuilder2.toString());
                }
                ctVar2.f28860d = new ct[b.f28823c.length];
                ctVar2.f28861e = new ct[b.f28823c.length];
                int[] iArr3 = b.f28823c;
                i3 = iArr3.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i3) {
                    int i7 = i6 + 1;
                    ctVar2.f28860d[i6] = cx.m20398a(iArr3[i5], cqVar, ctVarArr, (Set) set);
                    i5++;
                    i6 = i7;
                }
                iArr = b.f28824d;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    ctVar2.f28861e[i3] = cx.m20398a(iArr[i2], cqVar, ctVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                ctVar2 = cx.m20399a(ctVar);
                ctVar2.f28862f = eu.a(cx.m20398a(cx.m20405b(ctVar).f28826f, cqVar, ctVarArr, (Set) set));
                break;
            case 7:
                ctVar2 = cx.m20399a(ctVar);
                b = cx.m20405b(ctVar);
                ctVar2.f28866j = new ct[b.f28825e.length];
                iArr = b.f28825e;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    ctVar2.f28866j[i3] = cx.m20398a(iArr[i2], cqVar, ctVarArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            default:
                break;
        }
        if (ctVar2 == null) {
            cqVar = String.valueOf(ctVar);
            stringBuilder = new StringBuilder(String.valueOf(cqVar).length() + 15);
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(cqVar);
            cx.m20404a(stringBuilder.toString());
        }
        ctVarArr[i] = ctVar2;
        set.remove(Integer.valueOf(i));
        return ctVar2;
    }

    /* renamed from: b */
    private static C7811a m20405b(ct ctVar) {
        if (((C7811a) ctVar.m31764a(C7811a.f28820a)) == null) {
            String valueOf = String.valueOf(ctVar);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 54);
            stringBuilder.append("Expected a ServingValue and didn't get one. Value is: ");
            stringBuilder.append(valueOf);
            cx.m20404a(stringBuilder.toString());
        }
        return (C7811a) ctVar.m31764a(C7811a.f28820a);
    }

    /* renamed from: a */
    private static void m20404a(String str) {
        bs.a(str);
        throw new df(str);
    }

    /* renamed from: a */
    private static <T> T m20402a(T[] tArr, int i, String str) {
        if (i < 0 || i >= tArr.length) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
            stringBuilder.append("Index out of bounds detected: ");
            stringBuilder.append(i);
            stringBuilder.append(" in ");
            stringBuilder.append(str);
            cx.m20404a(stringBuilder.toString());
        }
        return tArr[i];
    }

    /* renamed from: a */
    private static cz m20400a(C8329b c8329b, cq cqVar, ct[] ctVarArr, int i) {
        i = cz.m20406a();
        for (Integer intValue : c8329b.m43853a()) {
            C8333d c8333d = (C8333d) cx.m20402a(cqVar.f28834c, intValue.intValue(), "properties");
            String str = (String) cx.m20402a(cqVar.f28832a, c8333d.m43865a(), "keys");
            ct ctVar = (ct) cx.m20402a(ctVarArr, c8333d.m43867b(), "values");
            if (ab.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                i.m20411a(ctVar);
            } else {
                i.m20412a(str, ctVar);
            }
        }
        return i.m20410a();
    }

    /* renamed from: a */
    public static void m20403a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
