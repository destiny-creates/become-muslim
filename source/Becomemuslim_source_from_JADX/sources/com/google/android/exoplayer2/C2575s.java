package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p162j.C2485g;

/* compiled from: Player */
/* renamed from: com.google.android.exoplayer2.s */
public interface C2575s {

    /* compiled from: Player */
    /* renamed from: com.google.android.exoplayer2.s$a */
    public interface C2574a {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(C2573r c2573r);

        void onPlayerError(C2330e c2330e);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        void onSeekProcessed();

        void onTimelineChanged(C2589y c2589y, Object obj);

        void onTracksChanged(C2439q c2439q, C2485g c2485g);
    }

    /* renamed from: a */
    int mo3225a();

    /* renamed from: a */
    void mo3226a(int i);

    /* renamed from: a */
    void mo3227a(long j);

    /* renamed from: a */
    void mo3229a(C2573r c2573r);

    /* renamed from: a */
    void mo3230a(C2574a c2574a);

    /* renamed from: a */
    void mo3231a(boolean z);

    /* renamed from: b */
    boolean mo3234b();

    /* renamed from: c */
    void mo3235c();

    /* renamed from: d */
    void mo3236d();

    /* renamed from: e */
    void mo3237e();

    /* renamed from: h */
    long mo3238h();

    /* renamed from: i */
    long mo3239i();

    /* renamed from: j */
    long mo3240j();

    /* renamed from: k */
    int mo3241k();
}
