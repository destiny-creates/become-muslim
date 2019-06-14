package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class adu extends adt<FieldDescriptorType, Object> {
    adu(int i) {
        super(i);
    }

    /* renamed from: a */
    public final void mo3767a() {
        if (!m18163b()) {
            Entry b;
            for (int i = 0; i < m18164c(); i++) {
                b = m18162b(i);
                if (((abk) b.getKey()).m17926d()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry b2 : m18165d()) {
                if (((abk) b2.getKey()).m17926d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
        }
        super.mo3767a();
    }
}
