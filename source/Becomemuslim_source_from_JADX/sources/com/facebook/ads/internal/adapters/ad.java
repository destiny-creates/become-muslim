package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;

public class ad extends BroadcastReceiver {
    /* renamed from: a */
    private String f3842a;
    /* renamed from: b */
    private ac f3843b;
    /* renamed from: c */
    private ab f3844c;

    public ad(String str, ab abVar, ac acVar) {
        this.f3844c = abVar;
        this.f3843b = acVar;
        this.f3842a = str;
    }

    /* renamed from: a */
    public IntentFilter m4588a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1627z.REWARDED_VIDEO_COMPLETE.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARDED_VIDEO_ERROR.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARDED_VIDEO_AD_CLICK.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARDED_VIDEO_IMPRESSION.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARDED_VIDEO_CLOSED.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARD_SERVER_SUCCESS.m5611a(this.f3842a));
        intentFilter.addAction(C1627z.REWARD_SERVER_FAILED.m5611a(this.f3842a));
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C1627z.REWARDED_VIDEO_COMPLETE.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo906d(this.f3844c);
        } else if (C1627z.REWARDED_VIDEO_ERROR.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo903a(this.f3844c, AdError.INTERNAL_ERROR);
        } else if (C1627z.REWARDED_VIDEO_AD_CLICK.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo904b(this.f3844c);
        } else if (C1627z.REWARDED_VIDEO_IMPRESSION.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo905c(this.f3844c);
        } else if (C1627z.REWARDED_VIDEO_CLOSED.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo901a();
        } else if (C1627z.REWARD_SERVER_FAILED.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo907e(this.f3844c);
        } else if (C1627z.REWARD_SERVER_SUCCESS.m5611a(this.f3842a).equals(action)) {
            this.f3843b.mo908f(this.f3844c);
        }
    }
}
