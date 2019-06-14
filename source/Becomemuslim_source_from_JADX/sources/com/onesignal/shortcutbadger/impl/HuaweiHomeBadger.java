package com.onesignal.shortcutbadger.impl;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Arrays;
import java.util.List;

public class HuaweiHomeBadger implements C5534a {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i);
        context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.huawei.android.launcher"});
    }
}
