package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.C4890j;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ac.C3171c;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.C2801g;
import com.google.android.gms.common.api.internal.bi;
import com.google.android.gms.common.api.internal.bj;
import com.google.android.gms.common.internal.C2854g;
import com.google.android.gms.common.internal.C2855h;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.internal.p205d.C4956e;
import com.google.android.gms.p166a.C2594a.C2591b;
import com.google.android.gms.p166a.C2594a.C2592c;

/* renamed from: com.google.android.gms.common.e */
public class C4361e extends C2830f {
    /* renamed from: a */
    public static final int f11563a = C2830f.f7233b;
    /* renamed from: c */
    private static final Object f11564c = new Object();
    /* renamed from: d */
    private static final C4361e f11565d = new C4361e();
    /* renamed from: e */
    private String f11566e;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.gms.common.e$a */
    private class C4360a extends C4956e {
        /* renamed from: a */
        private final Context f11561a;
        /* renamed from: b */
        private final /* synthetic */ C4361e f11562b;

        public C4360a(C4361e c4361e, Context context) {
            this.f11562b = c4361e;
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f11561a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            if (message.what != 1) {
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(50);
                stringBuilder.append("Don't know how to handle this message: ");
                stringBuilder.append(message);
                Log.w("GoogleApiAvailability", stringBuilder.toString());
            } else {
                int a = this.f11562b.mo2455a(this.f11561a);
                if (this.f11562b.mo2458a(a)) {
                    this.f11562b.m14343a(this.f11561a, a);
                }
            }
        }
    }

    /* renamed from: a */
    public static C4361e m14332a() {
        return f11565d;
    }

    C4361e() {
    }

    /* renamed from: a */
    public Dialog m14337a(Activity activity, int i, int i2) {
        return m14338a(activity, i, i2, null);
    }

    /* renamed from: a */
    public Dialog m14338a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return C4361e.m14331a((Context) activity, i, C2855h.m8338a(activity, mo2457a((Context) activity, i, "d"), i2), onCancelListener);
    }

    /* renamed from: a */
    public final boolean m14345a(Activity activity, C2801g c2801g, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = C4361e.m14331a((Context) activity, i, C2855h.m8340a(c2801g, mo2457a((Context) activity, i, "d"), 2), onCancelListener);
        if (a == null) {
            return null;
        }
        C4361e.m14333a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: b */
    public boolean m14350b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m14338a(activity, i, i2, onCancelListener);
        if (a == 0) {
            return null;
        }
        C4361e.m14333a(activity, a, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: a */
    public void m14343a(Context context, int i) {
        m14334a(context, i, null, m8137a(context, i, 0, "n"));
    }

    /* renamed from: a */
    public final boolean m14346a(Context context, C4775b c4775b, int i) {
        PendingIntent a = m14340a(context, c4775b);
        if (a == null) {
            return null;
        }
        m14334a(context, c4775b.m16827c(), null, GoogleApiActivity.m7899a(context, a, i));
        return true;
    }

    /* renamed from: a */
    public static Dialog m14330a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(C2854g.m8335c(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        C4361e.m14333a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    /* renamed from: a */
    public final bi m14342a(Context context, bj bjVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver biVar = new bi(bjVar);
        context.registerReceiver(biVar, intentFilter);
        biVar.m8006a(context);
        if (m8140a(context, "com.google.android.gms") != null) {
            return biVar;
        }
        bjVar.mo2423a();
        biVar.m8005a();
        return null;
    }

    /* renamed from: c */
    private final String m14335c() {
        String str;
        synchronized (f11564c) {
            str = this.f11566e;
        }
        return str;
    }

    /* renamed from: a */
    public int mo2455a(Context context) {
        return super.mo2455a(context);
    }

    /* renamed from: b */
    public int mo2459b(Context context, int i) {
        return super.mo2459b(context, i);
    }

    /* renamed from: a */
    public final boolean mo2458a(int i) {
        return super.mo2458a(i);
    }

    /* renamed from: a */
    public Intent mo2457a(Context context, int i, String str) {
        return super.mo2457a(context, i, str);
    }

    /* renamed from: a */
    public PendingIntent mo2456a(Context context, int i, int i2) {
        return super.mo2456a(context, i, i2);
    }

    /* renamed from: a */
    public PendingIntent m14340a(Context context, C4775b c4775b) {
        if (c4775b.m16825a()) {
            return c4775b.m16828d();
        }
        return mo2456a(context, c4775b.m16827c(), 0);
    }

    /* renamed from: b */
    public final String mo2460b(int i) {
        return super.mo2460b(i);
    }

    /* renamed from: a */
    static Dialog m14331a(Context context, int i, C2855h c2855h, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C2854g.m8335c(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        onCancelListener = C2854g.m8337e(context, i);
        if (onCancelListener != null) {
            builder.setPositiveButton(onCancelListener, c2855h);
        }
        context = C2854g.m8330a(context, i);
        if (context != null) {
            builder.setTitle(context);
        }
        return builder.create();
    }

    /* renamed from: a */
    static void m14333a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        if (activity instanceof C4890j) {
            C4886m.m17512a(dialog, onCancelListener).show(((C4890j) activity).getSupportFragmentManager(), str);
            return;
        }
        C2826c.m8120a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    /* renamed from: a */
    private final void m14334a(Context context, int i, String str, PendingIntent pendingIntent) {
        if (i == 18) {
            m14349b(context);
        } else if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            CharSequence b = C2854g.m8334b(context, i);
            CharSequence d = C2854g.m8336d(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            str = new C0279d(context).m798e(true).m796d(true).m783a(b).m781a(new C3171c().m9438a(d));
            if (C2898i.m8442a(context)) {
                C2872v.m8386a(C2904o.m8462h());
                str.m772a(context.getApplicationInfo().icon).m795d(2);
                if (C2898i.m8443b(context)) {
                    str.m774a(C2591b.common_full_open_on_phone, resources.getString(C2592c.common_open_on_phone), pendingIntent);
                } else {
                    str.m776a(pendingIntent);
                }
            } else {
                str.m772a(17301642).m793c(resources.getString(C2592c.common_google_play_services_notification_ticker)).m775a(System.currentTimeMillis()).m776a(pendingIntent).m789b(d);
            }
            if (C2904o.m8466l() != null) {
                C2872v.m8386a(C2904o.m8466l());
                String c = m14335c();
                if (c == null) {
                    c = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(c);
                    context = C2854g.m8333b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(c, context, 4));
                    } else if (!context.equals(notificationChannel.getName())) {
                        notificationChannel.setName(context);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                str.m790b(c);
            }
            context = str.m771a();
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i = 10436;
                    C2832i.sCanceledAvailabilityNotification.set(null);
                    break;
                default:
                    i = 39789;
                    break;
            }
            notificationManager.notify(i, context);
        }
    }

    /* renamed from: b */
    final void m14349b(Context context) {
        new C4360a(this, context).sendEmptyMessageDelayed(1, 120000);
    }
}
