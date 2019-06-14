package com.google.p217b.p231e.p232a.p233a;

import com.google.p217b.p222b.C5196a;
import java.util.List;

/* compiled from: BitArrayBuilder */
/* renamed from: com.google.b.e.a.a.a */
final class C5243a {
    /* renamed from: a */
    static C5196a m22214a(List<C5244b> list) {
        int size = (list.size() << 1) - 1;
        if (((C5244b) list.get(list.size() - 1)).m22218b() == null) {
            size--;
        }
        C5196a c5196a = new C5196a(size * 12);
        int a = ((C5244b) list.get(0)).m22218b().m22224a();
        int i = 0;
        for (size = 11; size >= 0; size--) {
            if (((1 << size) & a) != 0) {
                c5196a.m21962b(i);
            }
            i++;
        }
        for (size = 1; size < list.size(); size++) {
            C5244b c5244b = (C5244b) list.get(size);
            int a2 = c5244b.m22217a().m22224a();
            int i2 = i;
            for (i = 11; i >= 0; i--) {
                if (((1 << i) & a2) != 0) {
                    c5196a.m21962b(i2);
                }
                i2++;
            }
            if (c5244b.m22218b() != null) {
                a = c5244b.m22218b().m22224a();
                for (i = 11; i >= 0; i--) {
                    if (((1 << i) & a) != 0) {
                        c5196a.m21962b(i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        return c5196a;
    }
}
