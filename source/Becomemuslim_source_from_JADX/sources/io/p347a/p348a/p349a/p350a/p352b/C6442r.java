package io.p347a.p348a.p349a.p350a.p352b;

import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: ResponseParser */
/* renamed from: io.a.a.a.a.b.r */
public class C6442r {
    /* renamed from: a */
    public static int m26446a(int i) {
        return (i < HttpStatus.HTTP_OK || i > 299) ? (i < 300 || i > 399) ? (i < 400 || i > 499) ? i >= HttpStatus.HTTP_INTERNAL_SERVER_ERROR ? 1 : 1 : 0 : 1 : 0;
    }
}
