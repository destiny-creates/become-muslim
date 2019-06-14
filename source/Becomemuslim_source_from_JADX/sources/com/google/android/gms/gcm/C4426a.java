package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.iid.C3069o;
import com.google.android.gms.internal.p209h.C4984i;
import com.google.android.gms.internal.p209h.C4985j;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* renamed from: com.google.android.gms.gcm.a */
public class C4426a extends C3069o {
    /* renamed from: b */
    private C4984i f11793b = C4985j.f16223a;

    /* renamed from: a */
    public void m14707a() {
    }

    /* renamed from: a */
    public void m14708a(String str) {
    }

    /* renamed from: a */
    public void m14709a(String str, Bundle bundle) {
    }

    /* renamed from: a */
    public void m14710a(String str, String str2) {
    }

    public void onCreate() {
        super.onCreate();
        C4985j.a();
        getClass();
        this.f11793b = C4985j.f16223a;
    }

    public void handleIntent(Intent intent) {
        String stringExtra;
        String string;
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            stringExtra = intent.getStringExtra("message_type");
            if (stringExtra == null) {
                stringExtra = "gcm";
            }
            Object obj = -1;
            int hashCode = stringExtra.hashCode();
            Object obj2 = null;
            if (hashCode != -2062414158) {
                if (hashCode != 102161) {
                    if (hashCode != 814694033) {
                        if (hashCode == 814800675) {
                            if (stringExtra.equals("send_event")) {
                                obj = 2;
                            }
                        }
                    } else if (stringExtra.equals("send_error")) {
                        obj = 3;
                    }
                } else if (stringExtra.equals("gcm")) {
                    obj = null;
                }
            } else if (stringExtra.equals("deleted_messages")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    Object obj3;
                    int myPid;
                    List<RunningAppProcessInfo> runningAppProcesses;
                    Iterator it;
                    Bundle bundle;
                    String str;
                    String string2;
                    Bundle extras = intent.getExtras();
                    extras.remove("message_type");
                    extras.remove("android.support.content.wakelockid");
                    if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(C3058d.m8927a(extras, "gcm.n.e"))) {
                        if (C3058d.m8927a(extras, "gcm.n.icon") == null) {
                            obj3 = null;
                            if (obj3 != null) {
                                if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                                    myPid = Process.myPid();
                                    runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                                    if (runningAppProcesses != null) {
                                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                            if (runningAppProcessInfo.pid == myPid) {
                                                if (runningAppProcessInfo.importance == 100) {
                                                    obj2 = 1;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (obj2 != null) {
                                    C3058d.m8926a((Context) this).m8929a(extras);
                                    return;
                                }
                                bundle = new Bundle();
                                it = extras.keySet().iterator();
                                while (it.hasNext()) {
                                    str = (String) it.next();
                                    string2 = extras.getString(str);
                                    if (str.startsWith("gcm.notification.")) {
                                        str = str.replace("gcm.notification.", "gcm.n.");
                                    }
                                    if (!str.startsWith("gcm.n.")) {
                                        if (!"gcm.n.e".equals(str)) {
                                            bundle.putString(str.substring(6), string2);
                                        }
                                        it.remove();
                                    }
                                }
                                string = bundle.getString("sound2");
                                if (string != null) {
                                    bundle.remove("sound2");
                                    bundle.putString("sound", string);
                                }
                                if (!bundle.isEmpty()) {
                                    extras.putBundle("notification", bundle);
                                }
                            }
                            stringExtra = extras.getString("from");
                            extras.remove("from");
                            C4426a.m14706a(extras);
                            this.f11793b.a("onMessageReceived");
                            m14709a(stringExtra, extras);
                            return;
                        }
                    }
                    obj3 = 1;
                    if (obj3 != null) {
                        if (((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                            myPid = Process.myPid();
                            runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                            if (runningAppProcesses != null) {
                                for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                                    if (runningAppProcessInfo2.pid == myPid) {
                                        if (runningAppProcessInfo2.importance == 100) {
                                            obj2 = 1;
                                        }
                                    }
                                }
                            }
                        }
                        if (obj2 != null) {
                            bundle = new Bundle();
                            it = extras.keySet().iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                string2 = extras.getString(str);
                                if (str.startsWith("gcm.notification.")) {
                                    str = str.replace("gcm.notification.", "gcm.n.");
                                }
                                if (!str.startsWith("gcm.n.")) {
                                    if ("gcm.n.e".equals(str)) {
                                        bundle.putString(str.substring(6), string2);
                                    }
                                    it.remove();
                                }
                            }
                            string = bundle.getString("sound2");
                            if (string != null) {
                                bundle.remove("sound2");
                                bundle.putString("sound", string);
                            }
                            if (bundle.isEmpty()) {
                                extras.putBundle("notification", bundle);
                            }
                        } else {
                            C3058d.m8926a((Context) this).m8929a(extras);
                            return;
                        }
                    }
                    stringExtra = extras.getString("from");
                    extras.remove("from");
                    C4426a.m14706a(extras);
                    this.f11793b.a("onMessageReceived");
                    m14709a(stringExtra, extras);
                    return;
                case 1:
                    m14707a();
                    return;
                case 2:
                    m14708a(intent.getStringExtra("google.message_id"));
                    return;
                case 3:
                    stringExtra = intent.getStringExtra("google.message_id");
                    if (stringExtra == null) {
                        stringExtra = intent.getStringExtra("message_id");
                    }
                    m14710a(stringExtra, intent.getStringExtra("error"));
                    return;
                default:
                    intent = "GcmListenerService";
                    string = "Received message with unknown type: ";
                    stringExtra = String.valueOf(stringExtra);
                    if (stringExtra.length() != 0) {
                        stringExtra = string.concat(stringExtra);
                    } else {
                        stringExtra = new String(string);
                    }
                    Log.w(intent, stringExtra);
                    return;
            }
        }
        stringExtra = "GcmListenerService";
        string = "Unknown intent action: ";
        intent = String.valueOf(intent.getAction());
        Log.w(stringExtra, intent.length() != 0 ? string.concat(intent) : new String(string));
    }

    /* renamed from: a */
    static void m14706a(Bundle bundle) {
        bundle = bundle.keySet().iterator();
        while (bundle.hasNext()) {
            String str = (String) bundle.next();
            if (str != null && str.startsWith("google.c.")) {
                bundle.remove();
            }
        }
    }
}
