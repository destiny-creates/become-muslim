package com.google.android.gms.p174b;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.google.android.gms.b.i */
final class C2763i implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ Context f7055a;
    /* renamed from: b */
    private final /* synthetic */ Intent f7056b;

    C2763i(Context context, Intent intent) {
        this.f7055a = context;
        this.f7056b = intent;
    }

    public final void onClick(View view) {
        try {
            this.f7055a.startActivity(this.f7056b);
        } catch (View view2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", view2);
        }
    }
}
