package com.polidea.p254a.p256b.p262f;

import android.util.Pair;
import java.util.UUID;

/* compiled from: CharacteristicNotificationId */
/* renamed from: com.polidea.a.b.f.e */
public class C5602e extends Pair<UUID, Integer> {
    public C5602e(UUID uuid, Integer num) {
        super(uuid, num);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicNotificationId{UUID=");
        stringBuilder.append(((UUID) this.first).toString());
        stringBuilder.append(", instanceId=");
        stringBuilder.append(((Integer) this.second).toString());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
