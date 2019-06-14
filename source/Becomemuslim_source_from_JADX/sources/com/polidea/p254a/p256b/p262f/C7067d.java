package com.polidea.p254a.p256b.p262f;

import java.util.Arrays;
import java.util.UUID;

/* compiled from: CharacteristicChangedEvent */
/* renamed from: com.polidea.a.b.f.d */
public class C7067d extends C5602e {
    /* renamed from: a */
    public final byte[] f25041a;

    public C7067d(UUID uuid, Integer num, byte[] bArr) {
        super(uuid, num);
        this.f25041a = bArr;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7067d)) {
            if (!(obj instanceof C5602e) || super.equals(obj) == null) {
                z = false;
            }
            return z;
        } else if (!super.equals(obj)) {
            return false;
        } else {
            return Arrays.equals(this.f25041a, ((C7067d) obj).f25041a);
        }
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.f25041a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicChangedEvent{UUID=");
        stringBuilder.append(((UUID) this.first).toString());
        stringBuilder.append(", instanceId=");
        stringBuilder.append(((Integer) this.second).toString());
        stringBuilder.append(", data=");
        stringBuilder.append(Arrays.toString(this.f25041a));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
