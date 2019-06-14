package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
@cm
public abstract class ox extends TextureView implements ps {
    /* renamed from: a */
    protected final pg f24197a = new pg();
    /* renamed from: b */
    protected final pq f24198b;

    public ox(Context context) {
        super(context);
        this.f24198b = new pq(context, this);
    }

    /* renamed from: a */
    public abstract String mo6112a();

    /* renamed from: a */
    public abstract void mo6113a(float f, float f2);

    /* renamed from: a */
    public abstract void mo6114a(int i);

    /* renamed from: a */
    public abstract void mo6115a(ow owVar);

    /* renamed from: b */
    public abstract void mo6116b();

    /* renamed from: c */
    public abstract void mo6117c();

    /* renamed from: d */
    public abstract void mo6118d();

    /* renamed from: e */
    public abstract void mo4324e();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setVideoPath(String str);
}
