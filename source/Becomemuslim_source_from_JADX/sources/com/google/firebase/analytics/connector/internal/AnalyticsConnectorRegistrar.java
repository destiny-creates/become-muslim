package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Keep;
import com.google.firebase.C5335b;
import com.google.firebase.analytics.connector.C5328a;
import com.google.firebase.components.C5340a;
import com.google.firebase.components.C5343d;
import com.google.firebase.components.C5344e;
import java.util.Collections;
import java.util.List;

@Keep
public class AnalyticsConnectorRegistrar implements C5343d {
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<C5340a<?>> getComponents() {
        return Collections.singletonList(C5340a.m22635a(C5328a.class).m22632a(C5344e.m22648a(C5335b.class)).m22632a(C5344e.m22648a(Context.class)).m22631a(C6898a.f24717a).m22633b().m22634c());
    }
}
