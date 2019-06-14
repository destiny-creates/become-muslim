package com.polidea.p254a.p255a;

import java.util.UUID;

/* compiled from: BleConflictingNotificationAlreadySetException */
/* renamed from: com.polidea.a.a.e */
public class C6972e extends C5548g {
    /* renamed from: a */
    private final UUID f24858a;
    /* renamed from: b */
    private final boolean f24859b;

    public C6972e(UUID uuid, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Characteristic ");
        stringBuilder.append(uuid);
        stringBuilder.append(" notification already set to ");
        stringBuilder.append(z ? "indication" : "notification");
        super(stringBuilder.toString());
        this.f24858a = uuid;
        this.f24859b = z;
    }

    /* renamed from: a */
    public UUID m32745a() {
        return this.f24858a;
    }
}
