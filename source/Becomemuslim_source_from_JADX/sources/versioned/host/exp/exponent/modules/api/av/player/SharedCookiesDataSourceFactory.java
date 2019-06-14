package versioned.host.exp.exponent.modules.api.av.player;

import android.net.Uri;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C4244n;
import java.util.Map;

public class SharedCookiesDataSourceFactory implements C2497a {
    private final C2497a mDataSourceFactory;

    public SharedCookiesDataSourceFactory(Uri uri, ReactContext reactContext, String str, Map<String, Object> map) {
        this.mDataSourceFactory = new C4244n(reactContext, null, new CustomHeadersOkHttpDataSourceFactory(((NetworkingModule) reactContext.getNativeModule(NetworkingModule.class)).mClient, str, map));
    }

    public C2498g createDataSource() {
        return this.mDataSourceFactory.createDataSource();
    }
}
