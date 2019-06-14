package expo.modules.ads.admob;

import android.content.Context;
import expo.p304a.C6006c;
import expo.p304a.C6012g;
import expo.p304a.C7369b;
import java.util.Arrays;
import java.util.List;

public class AdMobPackage extends C7369b {
    public List<C6006c> createExportedModules(Context context) {
        return Arrays.asList(new C6006c[]{new AdMobInterstitialAdModule(context), new AdMobRewardedVideoAdModule(context)});
    }

    public List<C6012g> createViewManagers(Context context) {
        return Arrays.asList(new C6012g[]{new AdMobBannerViewManager(), new PublisherBannerViewManager()});
    }
}
