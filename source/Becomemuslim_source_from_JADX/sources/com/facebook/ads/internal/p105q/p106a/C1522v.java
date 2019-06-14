package com.facebook.ads.internal.p105q.p106a;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.q.a.v */
public class C1522v {
    /* renamed from: a */
    public static float m5337a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume > 0) {
                return (((float) streamVolume) * 1.0f) / ((float) streamMaxVolume);
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    public static void m5338a(Map<String, String> map, boolean z, boolean z2) {
        map.put(AudienceNetworkActivity.AUTOPLAY, z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        map.put("inline", z2 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }
}
