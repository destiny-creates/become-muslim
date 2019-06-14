package com.raizlabs.android.dbflow.p281e;

/* compiled from: BaseFinalModel */
/* renamed from: com.raizlabs.android.dbflow.e.a */
abstract class C7137a implements C5698h {

    /* compiled from: BaseFinalModel */
    /* renamed from: com.raizlabs.android.dbflow.e.a$a */
    static class C5692a extends RuntimeException {
        C5692a(String str) {
            super(str);
        }
    }

    C7137a() {
    }

    /* renamed from: a */
    public void mo5063a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" is not saveable");
        throw new C5692a(stringBuilder.toString());
    }
}
