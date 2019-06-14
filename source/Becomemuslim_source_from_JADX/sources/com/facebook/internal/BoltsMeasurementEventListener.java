package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0373d;
import com.facebook.appevents.AppEventsLogger;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    private void open() {
        C0373d.m1138a(this.applicationContext).m1142a(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
    }

    private void close() {
        C0373d.m1138a(this.applicationContext).m1141a((BroadcastReceiver) this);
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        if (_instance != null) {
            return _instance;
        }
        _instance = new BoltsMeasurementEventListener(context);
        _instance.open();
        return _instance;
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        context = AppEventsLogger.newLogger(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BOLTS_MEASUREMENT_EVENT_PREFIX);
        stringBuilder.append(intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY));
        String stringBuilder2 = stringBuilder.toString();
        intent = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
        Bundle bundle = new Bundle();
        for (String str : intent.keySet()) {
            bundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) intent.get(str));
        }
        context.logEvent(stringBuilder2, bundle);
    }
}
