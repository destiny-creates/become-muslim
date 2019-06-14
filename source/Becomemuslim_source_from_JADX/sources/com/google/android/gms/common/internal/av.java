package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class av {
    /* renamed from: a */
    private static final Uri f7244a;
    /* renamed from: b */
    private static final Uri f7245b;

    /* renamed from: a */
    public static Intent m8228a(String str) {
        str = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(str);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8229a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        str = Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(str2)) {
            str.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(str.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    /* renamed from: a */
    public static Intent m8227a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        f7244a = parse;
        f7245b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
