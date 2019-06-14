package com.google.android.p133a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.google.android.p133a.C2200f.C2199a;

@TargetApi(23)
/* compiled from: Camera2Api23 */
/* renamed from: com.google.android.a.d */
class C4689d extends C4072c {
    C4689d(C2199a c2199a, C2205i c2205i, Context context) {
        super(c2199a, c2205i, context);
    }

    /* renamed from: a */
    protected void mo3176a(C2211l c2211l, StreamConfigurationMap streamConfigurationMap) {
        if (streamConfigurationMap.getHighResolutionOutputSizes(256) != null) {
            for (Size size : streamConfigurationMap.getHighResolutionOutputSizes(256)) {
                c2211l.m6103a(new C2210k(size.getWidth(), size.getHeight()));
            }
        }
        if (c2211l.m6106c()) {
            super.mo3176a(c2211l, streamConfigurationMap);
        }
    }
}
