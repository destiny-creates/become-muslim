package versioned.host.exp.exponent.modules.api.av.player;

import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2514v;
import com.google.android.exoplayer2.p163k.C4250r.C2505f;
import com.google.android.exoplayer2.p163k.C4250r.C4733a;
import com.google.android.exoplayer2.p201d.p202a.C4691a;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6216e.C6215a;
import java.util.Map;
import java.util.Map.Entry;

public class CustomHeadersOkHttpDataSourceFactory extends C4733a {
    private final C6214d mCacheControl = null;
    private final C6215a mCallFactory;
    private final C2514v<? super C2498g> mListener = null;
    private final String mUserAgent;

    public CustomHeadersOkHttpDataSourceFactory(C6215a c6215a, String str, Map<String, Object> map) {
        this.mCallFactory = c6215a;
        this.mUserAgent = str;
        updateRequestProperties(getDefaultRequestProperties(), map);
    }

    protected void updateRequestProperties(C2505f c2505f, Map<String, Object> map) {
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                if (entry.getValue() instanceof String) {
                    c2505f.a((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
    }

    protected C4691a createDataSourceInternal(C2505f c2505f) {
        return new C4691a(this.mCallFactory, this.mUserAgent, null, this.mListener, this.mCacheControl, c2505f);
    }
}
