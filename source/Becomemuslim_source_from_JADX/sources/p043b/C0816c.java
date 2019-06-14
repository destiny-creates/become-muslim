package p043b;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;

/* compiled from: AppLinks */
/* renamed from: b.c */
public final class C0816c {
    /* renamed from: a */
    public static Bundle m2964a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    /* renamed from: b */
    public static Bundle m2965b(Intent intent) {
        intent = C0816c.m2964a(intent);
        if (intent == null) {
            return null;
        }
        return intent.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }
}
