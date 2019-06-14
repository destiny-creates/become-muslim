package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

@cm
public final class pv implements ae<pn> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        pn pnVar = (pn) obj;
        if (((Boolean) aph.m18688f().m18889a(asp.bu)).booleanValue()) {
            re b = pnVar.mo6127b();
            if (b == null) {
                try {
                    re reVar = new re(pnVar, Float.parseFloat((String) map.get("duration")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("customControlsAllowed")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("clickToExpandAllowed")));
                    pnVar.mo6126a(reVar);
                    b = reVar;
                } catch (Throwable e) {
                    mt.m19919b("Unable to parse videoMeta message.", e);
                    ax.i().m30834a(e, "VideoMetaGmsgHandler.onGmsg");
                }
            }
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("muted"));
            float parseFloat = Float.parseFloat((String) map.get("currentTime"));
            int parseInt = Integer.parseInt((String) map.get("playbackState"));
            if (parseInt < 0 || 3 < parseInt) {
                parseInt = 0;
            }
            String str = (String) map.get(ViewProps.ASPECT_RATIO);
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (mt.m19917a(3)) {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 79);
                stringBuilder.append("Video Meta GMSG: isMuted : ");
                stringBuilder.append(equals);
                stringBuilder.append(" , playbackState : ");
                stringBuilder.append(parseInt);
                stringBuilder.append(" , aspectRatio : ");
                stringBuilder.append(str);
                mt.m19918b(stringBuilder.toString());
            }
            b.m37635a(parseFloat, parseInt, equals, parseFloat2);
        }
    }
}
