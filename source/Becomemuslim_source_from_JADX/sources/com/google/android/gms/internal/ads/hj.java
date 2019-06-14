package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class hj implements qs {
    /* renamed from: a */
    public abstract pr mo6095a(awi<?> awi, Map<String, String> map);

    @Deprecated
    /* renamed from: b */
    public final HttpResponse mo4275b(awi<?> awi, Map<String, String> map) {
        pr a = mo6095a(awi, map);
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), a.m20024a(), ""));
        List arrayList = new ArrayList();
        for (aqg aqg : a.m20025b()) {
            arrayList.add(new BasicHeader(aqg.m18748a(), aqg.m18749b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream d = a.m20027d();
        if (d != null) {
            HttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(d);
            basicHttpEntity.setContentLength((long) a.m20026c());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
