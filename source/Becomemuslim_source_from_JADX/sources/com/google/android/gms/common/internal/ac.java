package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.C2875k.C2874a;

public class ac {
    /* renamed from: a */
    private final Resources f7235a;
    /* renamed from: b */
    private final String f7236b = this.f7235a.getResourcePackageName(C2874a.common_google_play_services_unknown_issue);

    public ac(Context context) {
        C2872v.m8380a((Object) context);
        this.f7235a = context.getResources();
    }

    /* renamed from: a */
    public String m8216a(String str) {
        str = this.f7235a.getIdentifier(str, "string", this.f7236b);
        if (str == null) {
            return null;
        }
        return this.f7235a.getString(str);
    }
}
