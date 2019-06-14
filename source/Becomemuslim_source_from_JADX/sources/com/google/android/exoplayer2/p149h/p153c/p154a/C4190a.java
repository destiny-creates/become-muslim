package com.google.android.exoplayer2.p149h.p153c.p154a;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.C2515k;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsMasterPlaylist */
/* renamed from: com.google.android.exoplayer2.h.c.a.a */
public final class C4190a extends C2396c {
    /* renamed from: a */
    public final List<C2394a> f10906a;
    /* renamed from: b */
    public final List<C2394a> f10907b;
    /* renamed from: c */
    public final List<C2394a> f10908c;
    /* renamed from: d */
    public final C2515k f10909d;
    /* renamed from: e */
    public final List<C2515k> f10910e;

    /* compiled from: HlsMasterPlaylist */
    /* renamed from: com.google.android.exoplayer2.h.c.a.a$a */
    public static final class C2394a {
        /* renamed from: a */
        public final String f5897a;
        /* renamed from: b */
        public final C2515k f5898b;

        /* renamed from: a */
        public static C2394a m6604a(String str) {
            return new C2394a(str, C2515k.m7004b(AppEventsConstants.EVENT_PARAM_VALUE_NO, "application/x-mpegURL", null, null, -1, 0, null));
        }

        public C2394a(String str, C2515k c2515k) {
            this.f5897a = str;
            this.f5898b = c2515k;
        }
    }

    public C4190a(String str, List<String> list, List<C2394a> list2, List<C2394a> list3, List<C2394a> list4, C2515k c2515k, List<C2515k> list5) {
        super(str, list);
        this.f10906a = Collections.unmodifiableList(list2);
        this.f10907b = Collections.unmodifiableList(list3);
        this.f10908c = Collections.unmodifiableList(list4);
        this.f10909d = c2515k;
        this.f10910e = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    /* renamed from: a */
    public static C4190a m13437a(String str) {
        List singletonList = Collections.singletonList(C2394a.m6604a(str));
        List emptyList = Collections.emptyList();
        return new C4190a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
    }
}
