package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.p095j.C1400d;

/* renamed from: com.facebook.ads.internal.view.a */
public interface C1566a {

    /* renamed from: com.facebook.ads.internal.view.a$a */
    public interface C1551a {
        /* renamed from: a */
        void mo853a(View view);

        /* renamed from: a */
        void mo854a(String str);

        /* renamed from: a */
        void mo855a(String str, C1400d c1400d);
    }

    /* renamed from: a */
    void mo1010a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity);

    /* renamed from: a */
    void mo1011a(Bundle bundle);

    /* renamed from: i */
    void mo1012i();

    /* renamed from: j */
    void mo1013j();

    void onDestroy();

    void setListener(C1551a c1551a);
}
