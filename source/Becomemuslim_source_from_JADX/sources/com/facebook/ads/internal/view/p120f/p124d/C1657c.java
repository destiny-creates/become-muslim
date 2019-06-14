package com.facebook.ads.internal.view.p120f.p124d;

import android.net.Uri;
import android.view.View;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;

/* renamed from: com.facebook.ads.internal.view.f.d.c */
public interface C1657c {
    /* renamed from: a */
    void mo1039a(int i);

    /* renamed from: a */
    void mo1040a(C1624a c1624a);

    /* renamed from: a */
    void mo1041a(boolean z);

    /* renamed from: b */
    void mo1042b();

    /* renamed from: c */
    void mo1043c();

    /* renamed from: d */
    boolean mo1044d();

    /* renamed from: e */
    void mo1045e();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    C1624a getStartReason();

    C1658d getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(C1659e c1659e);

    void setup(Uri uri);
}
