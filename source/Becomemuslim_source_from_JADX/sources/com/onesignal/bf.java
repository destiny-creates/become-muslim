package com.onesignal;

/* compiled from: UserStateEmail */
class bf extends be {
    /* renamed from: a */
    protected void mo4944a() {
    }

    /* renamed from: b */
    boolean mo4945b() {
        return true;
    }

    bf(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("email");
        stringBuilder.append(str);
        super(stringBuilder.toString(), z);
    }

    /* renamed from: a */
    be mo4943a(String str) {
        return new bf(str, false);
    }
}
