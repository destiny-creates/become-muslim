package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.am.C5464i;

public class ADMMessageHandler extends ADMMessageHandlerBase {
    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    protected void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        if (!C5529q.m23531a(applicationContext, extras).m23528a()) {
            C5538t c5538t = new C5538t(applicationContext);
            c5538t.f18577b = C5529q.m23532a(extras);
            C5529q.m23529a(c5538t);
        }
    }

    protected void onRegistered(String str) {
        C5464i c5464i = C5464i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM registration ID: ");
        stringBuilder.append(str);
        am.m23187b(c5464i, stringBuilder.toString());
        av.m32609a(str);
    }

    protected void onRegistrationError(String str) {
        C5464i c5464i = C5464i.ERROR;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM:onRegistrationError: ");
        stringBuilder.append(str);
        am.m23187b(c5464i, stringBuilder.toString());
        if ("INVALID_SENDER".equals(str) != null) {
            am.m23187b(C5464i.ERROR, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        av.m32609a(null);
    }

    protected void onUnregistered(String str) {
        C5464i c5464i = C5464i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM:onUnregistered: ");
        stringBuilder.append(str);
        am.m23187b(c5464i, stringBuilder.toString());
    }
}
