package com.google.android.gms.internal.p210i;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.hn */
final class hn extends hm<FieldDescriptorType, Object> {
    hn(int i) {
        super(i);
    }

    /* renamed from: a */
    public final void mo4581a() {
        if (!m20752b()) {
            Entry b;
            for (int i = 0; i < m20753c(); i++) {
                b = m20751b(i);
                if (((fc) b.getKey()).m20547d()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry b2 : m20754d()) {
                if (((fc) b2.getKey()).m20547d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
        }
        super.mo4581a();
    }
}
