package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Collections;
import java.util.List;

public class ZukHomeBadger implements C5534a {
    /* renamed from: a */
    private final Uri f24851a = Uri.parse("content://com.android.badge/badge");

    @TargetApi(11)
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        componentName = new Bundle();
        componentName.putInt("app_badge_count", i);
        context.getContentResolver().call(this.f24851a, "setAppBadgeCount", null, componentName);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Collections.singletonList("com.zui.launcher");
    }
}
