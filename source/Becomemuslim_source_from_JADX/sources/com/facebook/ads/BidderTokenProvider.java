package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.p094i.C1394c;

public final class BidderTokenProvider {
    public static String getBidderToken(Context context) {
        return new C1394c(context, true).m4790a();
    }
}
