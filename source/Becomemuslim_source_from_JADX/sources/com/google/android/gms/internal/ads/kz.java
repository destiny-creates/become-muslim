package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.google.android.gms.ads.internal.ax;

final class kz implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ ky f15742a;

    kz(ky kyVar) {
        this.f15742a = kyVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ax.e();
        jw.m19697a(this.f15742a.f15738a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
