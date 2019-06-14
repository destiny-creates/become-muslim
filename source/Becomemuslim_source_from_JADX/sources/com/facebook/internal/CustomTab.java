package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.p015c.C0107c;
import android.support.p015c.C0107c.C0106a;
import com.facebook.FacebookSdk;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FacebookSdk.getGraphApiVersion());
        stringBuilder.append("/");
        stringBuilder.append(ServerProtocol.DIALOG_PATH);
        stringBuilder.append(str);
        this.uri = Utility.buildUri(dialogAuthority, stringBuilder.toString(), bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        C0107c a = new C0106a().m215a();
        a.f240a.setPackage(str);
        a.f240a.addFlags(1073741824);
        a.m216a(activity, this.uri);
    }
}
