package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class gi extends hj {
    /* renamed from: a */
    private final qs f28661a;

    gi(qs qsVar) {
        this.f28661a = qsVar;
    }

    /* renamed from: a */
    public final pr mo6095a(awi<?> awi, Map<String, String> map) {
        try {
            HttpResponse b = this.f28661a.mo4275b(awi, map);
            int statusCode = b.getStatusLine().getStatusCode();
            Header[] allHeaders = b.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new aqg(header.getName(), header.getValue()));
            }
            if (b.getEntity() == null) {
                return new pr(statusCode, arrayList);
            }
            long contentLength = b.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new pr(statusCode, arrayList, (int) b.getEntity().getContentLength(), b.getEntity().getContent());
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Response too large: ");
            stringBuilder.append(contentLength);
            throw new IOException(stringBuilder.toString());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
