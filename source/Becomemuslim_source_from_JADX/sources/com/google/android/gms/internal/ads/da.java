package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@cm
public final class da {
    /* renamed from: b */
    private static boolean m19377b(Context context, boolean z) {
        if (!z) {
            return true;
        }
        int b = DynamiteModule.b(context, ModuleDescriptor.MODULE_ID);
        return b != 0 && b <= DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }
}
