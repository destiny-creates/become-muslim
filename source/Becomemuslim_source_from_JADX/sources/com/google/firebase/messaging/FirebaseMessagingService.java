package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2958j;
import com.google.firebase.iid.C5356e;
import com.google.firebase.iid.C5370y;
import com.google.firebase.iid.ad;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class FirebaseMessagingService extends ad {
    /* renamed from: b */
    private static final Queue<String> f24759b = new ArrayDeque(10);

    /* renamed from: a */
    public void m32410a() {
    }

    /* renamed from: a */
    public void mo6409a(C7917d c7917d) {
    }

    /* renamed from: a */
    public void m32412a(String str) {
    }

    /* renamed from: a */
    public void m32413a(String str, Exception exception) {
    }

    /* renamed from: b */
    public void mo6410b(String str) {
    }

    /* renamed from: a */
    protected final Intent mo4882a(Intent intent) {
        return C5370y.m22798a().m22804b();
    }

    /* renamed from: c */
    public final boolean mo4896c(android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "com.google.firebase.messaging.NOTIFICATION_OPEN";
        r1 = r3.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x002c;
    L_0x000c:
        r0 = "pending_intent";
        r0 = r3.getParcelableExtra(r0);
        r0 = (android.app.PendingIntent) r0;
        if (r0 == 0) goto L_0x0021;
    L_0x0016:
        r0.send();	 Catch:{ CanceledException -> 0x001a }
        goto L_0x0021;
    L_0x001a:
        r0 = "FirebaseMessaging";
        r1 = "Notification pending intent canceled";
        android.util.Log.e(r0, r1);
    L_0x0021:
        r0 = com.google.firebase.messaging.C5373b.m22820e(r3);
        if (r0 == 0) goto L_0x002a;
    L_0x0027:
        com.google.firebase.messaging.C5373b.m22817b(r3);
    L_0x002a:
        r3 = 1;
        return r3;
    L_0x002c:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.c(android.content.Intent):boolean");
    }

    /* renamed from: b */
    public final void mo4883b(Intent intent) {
        C2954g a;
        Object obj;
        int hashCode;
        Bundle extras;
        String str;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            if (!"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
                if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
                    if (C5373b.m22820e(intent)) {
                        C5373b.m22818c(intent);
                        return;
                    }
                } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                    mo6410b(intent.getStringExtra("token"));
                    return;
                } else {
                    action = "FirebaseMessaging";
                    String str2 = "Unknown intent action: ";
                    intent = String.valueOf(intent.getAction());
                    Log.d(action, intent.length() != 0 ? str2.concat(intent) : new String(str2));
                }
                return;
            }
        }
        CharSequence stringExtra = intent.getStringExtra("google.message_id");
        int i = 2;
        if (TextUtils.isEmpty(stringExtra)) {
            a = C2958j.a(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            a = C5356e.m22761a((Context) this).m22763a(2, bundle);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            if (f24759b.contains(stringExtra)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    String str3 = "FirebaseMessaging";
                    String str4 = "Received duplicate message: ";
                    action = String.valueOf(stringExtra);
                    Log.d(str3, action.length() != 0 ? str4.concat(action) : new String(str4));
                }
                obj = 1;
                if (obj == null) {
                    action = intent.getStringExtra("message_type");
                    if (action == null) {
                        action = "gcm";
                    }
                    hashCode = action.hashCode();
                    if (hashCode != -2062414158) {
                        if (action.equals("deleted_messages")) {
                            i = 1;
                            switch (i) {
                                case 0:
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22815a(intent);
                                    }
                                    extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("android.support.content.wakelockid");
                                    if (C5377f.m22826a(extras)) {
                                        if (!new C5377f(this).m22832c(extras)) {
                                            if (C5373b.m22820e(intent)) {
                                                C5373b.m22819d(intent);
                                            }
                                        }
                                    }
                                    mo6409a(new C7917d(extras));
                                    break;
                                case 1:
                                    m32410a();
                                    break;
                                case 2:
                                    m32412a(intent.getStringExtra("google.message_id"));
                                    break;
                                case 3:
                                    action = intent.getStringExtra("google.message_id");
                                    if (action == null) {
                                        action = intent.getStringExtra("message_id");
                                    }
                                    m32413a(action, new C5376e(intent.getStringExtra("error")));
                                    break;
                                default:
                                    intent = "FirebaseMessaging";
                                    str = "Received message with unknown type: ";
                                    action = String.valueOf(action);
                                    if (action.length() == 0) {
                                        action = new String(str);
                                    } else {
                                        action = str.concat(action);
                                    }
                                    Log.w(intent, action);
                                    break;
                            }
                        }
                    } else if (hashCode != 102161) {
                        if (action.equals("gcm")) {
                            i = 0;
                            switch (i) {
                                case 0:
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22815a(intent);
                                    }
                                    extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("android.support.content.wakelockid");
                                    if (C5377f.m22826a(extras)) {
                                        if (new C5377f(this).m22832c(extras)) {
                                            if (C5373b.m22820e(intent)) {
                                                C5373b.m22819d(intent);
                                            }
                                        }
                                    }
                                    mo6409a(new C7917d(extras));
                                    break;
                                case 1:
                                    m32410a();
                                    break;
                                case 2:
                                    m32412a(intent.getStringExtra("google.message_id"));
                                    break;
                                case 3:
                                    action = intent.getStringExtra("google.message_id");
                                    if (action == null) {
                                        action = intent.getStringExtra("message_id");
                                    }
                                    m32413a(action, new C5376e(intent.getStringExtra("error")));
                                    break;
                                default:
                                    intent = "FirebaseMessaging";
                                    str = "Received message with unknown type: ";
                                    action = String.valueOf(action);
                                    if (action.length() == 0) {
                                        action = str.concat(action);
                                    } else {
                                        action = new String(str);
                                    }
                                    Log.w(intent, action);
                                    break;
                            }
                        }
                    } else if (hashCode != 814694033) {
                        if (action.equals("send_error")) {
                            i = 3;
                            switch (i) {
                                case 0:
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22815a(intent);
                                    }
                                    extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("android.support.content.wakelockid");
                                    if (C5377f.m22826a(extras)) {
                                        if (new C5377f(this).m22832c(extras)) {
                                            if (C5373b.m22820e(intent)) {
                                                C5373b.m22819d(intent);
                                            }
                                        }
                                    }
                                    mo6409a(new C7917d(extras));
                                    break;
                                case 1:
                                    m32410a();
                                    break;
                                case 2:
                                    m32412a(intent.getStringExtra("google.message_id"));
                                    break;
                                case 3:
                                    action = intent.getStringExtra("google.message_id");
                                    if (action == null) {
                                        action = intent.getStringExtra("message_id");
                                    }
                                    m32413a(action, new C5376e(intent.getStringExtra("error")));
                                    break;
                                default:
                                    intent = "FirebaseMessaging";
                                    str = "Received message with unknown type: ";
                                    action = String.valueOf(action);
                                    if (action.length() == 0) {
                                        action = new String(str);
                                    } else {
                                        action = str.concat(action);
                                    }
                                    Log.w(intent, action);
                                    break;
                            }
                        }
                    } else if (hashCode != 814800675) {
                        if (action.equals("send_event")) {
                            switch (i) {
                                case 0:
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22815a(intent);
                                    }
                                    extras = intent.getExtras();
                                    if (extras == null) {
                                        extras = new Bundle();
                                    }
                                    extras.remove("android.support.content.wakelockid");
                                    if (C5377f.m22826a(extras)) {
                                        if (new C5377f(this).m22832c(extras)) {
                                            if (C5373b.m22820e(intent)) {
                                                C5373b.m22819d(intent);
                                            }
                                        }
                                    }
                                    mo6409a(new C7917d(extras));
                                    break;
                                case 1:
                                    m32410a();
                                    break;
                                case 2:
                                    m32412a(intent.getStringExtra("google.message_id"));
                                    break;
                                case 3:
                                    action = intent.getStringExtra("google.message_id");
                                    if (action == null) {
                                        action = intent.getStringExtra("message_id");
                                    }
                                    m32413a(action, new C5376e(intent.getStringExtra("error")));
                                    break;
                                default:
                                    intent = "FirebaseMessaging";
                                    str = "Received message with unknown type: ";
                                    action = String.valueOf(action);
                                    if (action.length() == 0) {
                                        action = str.concat(action);
                                    } else {
                                        action = new String(str);
                                    }
                                    Log.w(intent, action);
                                    break;
                            }
                        }
                    }
                    i = -1;
                    switch (i) {
                        case 0:
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22815a(intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (C5377f.m22826a(extras)) {
                                if (new C5377f(this).m22832c(extras)) {
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22819d(intent);
                                    }
                                }
                            }
                            mo6409a(new C7917d(extras));
                            break;
                        case 1:
                            m32410a();
                            break;
                        case 2:
                            m32412a(intent.getStringExtra("google.message_id"));
                            break;
                        case 3:
                            action = intent.getStringExtra("google.message_id");
                            if (action == null) {
                                action = intent.getStringExtra("message_id");
                            }
                            m32413a(action, new C5376e(intent.getStringExtra("error")));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str = "Received message with unknown type: ";
                            action = String.valueOf(action);
                            if (action.length() == 0) {
                                action = str.concat(action);
                            } else {
                                action = new String(str);
                            }
                            Log.w(intent, action);
                            break;
                    }
                }
                C2958j.a(a, 1, TimeUnit.SECONDS);
            }
            if (f24759b.size() >= 10) {
                f24759b.remove();
            }
            f24759b.add(stringExtra);
        }
        obj = null;
        if (obj == null) {
            action = intent.getStringExtra("message_type");
            if (action == null) {
                action = "gcm";
            }
            hashCode = action.hashCode();
            if (hashCode != -2062414158) {
                if (action.equals("deleted_messages")) {
                    i = 1;
                    switch (i) {
                        case 0:
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22815a(intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (C5377f.m22826a(extras)) {
                                if (new C5377f(this).m22832c(extras)) {
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22819d(intent);
                                    }
                                }
                            }
                            mo6409a(new C7917d(extras));
                            break;
                        case 1:
                            m32410a();
                            break;
                        case 2:
                            m32412a(intent.getStringExtra("google.message_id"));
                            break;
                        case 3:
                            action = intent.getStringExtra("google.message_id");
                            if (action == null) {
                                action = intent.getStringExtra("message_id");
                            }
                            m32413a(action, new C5376e(intent.getStringExtra("error")));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str = "Received message with unknown type: ";
                            action = String.valueOf(action);
                            if (action.length() == 0) {
                                action = new String(str);
                            } else {
                                action = str.concat(action);
                            }
                            Log.w(intent, action);
                            break;
                    }
                }
            } else if (hashCode != 102161) {
                if (action.equals("gcm")) {
                    i = 0;
                    switch (i) {
                        case 0:
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22815a(intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (C5377f.m22826a(extras)) {
                                if (new C5377f(this).m22832c(extras)) {
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22819d(intent);
                                    }
                                }
                            }
                            mo6409a(new C7917d(extras));
                            break;
                        case 1:
                            m32410a();
                            break;
                        case 2:
                            m32412a(intent.getStringExtra("google.message_id"));
                            break;
                        case 3:
                            action = intent.getStringExtra("google.message_id");
                            if (action == null) {
                                action = intent.getStringExtra("message_id");
                            }
                            m32413a(action, new C5376e(intent.getStringExtra("error")));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str = "Received message with unknown type: ";
                            action = String.valueOf(action);
                            if (action.length() == 0) {
                                action = str.concat(action);
                            } else {
                                action = new String(str);
                            }
                            Log.w(intent, action);
                            break;
                    }
                }
            } else if (hashCode != 814694033) {
                if (action.equals("send_error")) {
                    i = 3;
                    switch (i) {
                        case 0:
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22815a(intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (C5377f.m22826a(extras)) {
                                if (new C5377f(this).m22832c(extras)) {
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22819d(intent);
                                    }
                                }
                            }
                            mo6409a(new C7917d(extras));
                            break;
                        case 1:
                            m32410a();
                            break;
                        case 2:
                            m32412a(intent.getStringExtra("google.message_id"));
                            break;
                        case 3:
                            action = intent.getStringExtra("google.message_id");
                            if (action == null) {
                                action = intent.getStringExtra("message_id");
                            }
                            m32413a(action, new C5376e(intent.getStringExtra("error")));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str = "Received message with unknown type: ";
                            action = String.valueOf(action);
                            if (action.length() == 0) {
                                action = new String(str);
                            } else {
                                action = str.concat(action);
                            }
                            Log.w(intent, action);
                            break;
                    }
                }
            } else if (hashCode != 814800675) {
                if (action.equals("send_event")) {
                    switch (i) {
                        case 0:
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22815a(intent);
                            }
                            extras = intent.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.remove("android.support.content.wakelockid");
                            if (C5377f.m22826a(extras)) {
                                if (new C5377f(this).m22832c(extras)) {
                                    if (C5373b.m22820e(intent)) {
                                        C5373b.m22819d(intent);
                                    }
                                }
                            }
                            mo6409a(new C7917d(extras));
                            break;
                        case 1:
                            m32410a();
                            break;
                        case 2:
                            m32412a(intent.getStringExtra("google.message_id"));
                            break;
                        case 3:
                            action = intent.getStringExtra("google.message_id");
                            if (action == null) {
                                action = intent.getStringExtra("message_id");
                            }
                            m32413a(action, new C5376e(intent.getStringExtra("error")));
                            break;
                        default:
                            intent = "FirebaseMessaging";
                            str = "Received message with unknown type: ";
                            action = String.valueOf(action);
                            if (action.length() == 0) {
                                action = str.concat(action);
                            } else {
                                action = new String(str);
                            }
                            Log.w(intent, action);
                            break;
                    }
                }
            }
            i = -1;
            switch (i) {
                case 0:
                    if (C5373b.m22820e(intent)) {
                        C5373b.m22815a(intent);
                    }
                    extras = intent.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.remove("android.support.content.wakelockid");
                    if (C5377f.m22826a(extras)) {
                        if (new C5377f(this).m22832c(extras)) {
                            if (C5373b.m22820e(intent)) {
                                C5373b.m22819d(intent);
                            }
                        }
                    }
                    mo6409a(new C7917d(extras));
                    break;
                case 1:
                    m32410a();
                    break;
                case 2:
                    m32412a(intent.getStringExtra("google.message_id"));
                    break;
                case 3:
                    action = intent.getStringExtra("google.message_id");
                    if (action == null) {
                        action = intent.getStringExtra("message_id");
                    }
                    m32413a(action, new C5376e(intent.getStringExtra("error")));
                    break;
                default:
                    intent = "FirebaseMessaging";
                    str = "Received message with unknown type: ";
                    action = String.valueOf(action);
                    if (action.length() == 0) {
                        action = new String(str);
                    } else {
                        action = str.concat(action);
                    }
                    Log.w(intent, action);
                    break;
            }
        }
        try {
            C2958j.a(a, 1, TimeUnit.SECONDS);
        } catch (Intent intent2) {
            intent2 = String.valueOf(intent2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(intent2).length() + 20);
            stringBuilder.append("Message ack failed: ");
            stringBuilder.append(intent2);
            Log.w("FirebaseMessaging", stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static void m32408a(Bundle bundle) {
        bundle = bundle.keySet().iterator();
        while (bundle.hasNext()) {
            String str = (String) bundle.next();
            if (str != null && str.startsWith("google.c.")) {
                bundle.remove();
            }
        }
    }
}
