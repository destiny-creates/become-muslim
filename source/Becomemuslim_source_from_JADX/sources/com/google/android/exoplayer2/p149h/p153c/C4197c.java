package com.google.android.exoplayer2.p149h.p153c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.p140d.C4112e;
import com.google.android.exoplayer2.p137e.p142g.C4127a;
import com.google.android.exoplayer2.p137e.p142g.C4130c;
import com.google.android.exoplayer2.p137e.p142g.C4132e;
import com.google.android.exoplayer2.p137e.p142g.C4149v;
import com.google.android.exoplayer2.p137e.p196c.C4105b;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2537s;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultHlsExtractorFactory */
/* renamed from: com.google.android.exoplayer2.h.c.c */
public final class C4197c implements C2406f {
    /* renamed from: a */
    public Pair<C2303e, Boolean> mo2272a(C2303e c2303e, Uri uri, C2515k c2515k, List<C2515k> list, C2255a c2255a, C2537s c2537s) {
        uri = uri.getLastPathSegment();
        boolean z = false;
        if (!("text/vtt".equals(c2515k.f6380f) || uri.endsWith(".webvtt"))) {
            if (!uri.endsWith(".vtt")) {
                if (uri.endsWith(".aac")) {
                    c2303e = new C4130c();
                } else {
                    if (!uri.endsWith(".ac3")) {
                        if (!uri.endsWith(".ec3")) {
                            if (uri.endsWith(".mp3")) {
                                c2303e = new C4105b(0, null);
                            } else {
                                if (c2303e == null) {
                                    if (uri.endsWith(".mp4") == null && uri.startsWith(".m4", uri.length() - 4) == null) {
                                        if (uri.startsWith(".mp4", uri.length() - 5) == null) {
                                            c2303e = 16;
                                            if (list != null) {
                                                c2303e = 48;
                                            } else {
                                                list = Collections.emptyList();
                                            }
                                            uri = c2515k.f6377c;
                                            if (TextUtils.isEmpty(uri) == null) {
                                                if ("audio/mp4a-latm".equals(C2524i.m7054e(uri)) == null) {
                                                    c2303e |= 2;
                                                }
                                                if ("video/avc".equals(C2524i.m7053d(uri)) == null) {
                                                    c2303e |= 4;
                                                }
                                            }
                                            c2303e = new C4149v(2, c2537s, new C4132e(c2303e, list));
                                        }
                                    }
                                    if (list == null) {
                                        list = Collections.emptyList();
                                    }
                                    C2303e c4112e = new C4112e(0, c2537s, null, c2255a, list);
                                }
                                return Pair.create(c2303e, Boolean.valueOf(z));
                            }
                        }
                    }
                    c2303e = new C4127a();
                }
                z = true;
                return Pair.create(c2303e, Boolean.valueOf(z));
            }
        }
        c2303e = new C4202n(c2515k.f6399y, c2537s);
        return Pair.create(c2303e, Boolean.valueOf(z));
    }
}
