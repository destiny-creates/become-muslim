package expo.modules.constants;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.device.yearclass.YearClass;
import com.facebook.share.internal.MessengerShareContentUtility;
import expo.p304a.p305a.C5998e;
import expo.p307b.p310c.C6023a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ConstantsService implements C5998e, C6023a {
    protected Context mContext;
    private String mSessionId = UUID.randomUUID().toString();
    protected int mStatusBarHeight = 0;

    public String getAppOwnership() {
        return "guest";
    }

    private static int convertPixelsToDp(float f, Context context) {
        return (int) (f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public ConstantsService(Context context) {
        this.mContext = context;
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mStatusBarHeight = convertPixelsToDp((float) context.getResources().getDimensionPixelSize(identifier), context);
        }
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6023a.class);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("sessionId", this.mSessionId);
        hashMap.put("statusBarHeight", Integer.valueOf(getStatusBarHeight()));
        hashMap.put("deviceYearClass", Integer.valueOf(getDeviceYearClass()));
        hashMap.put("deviceName", getDeviceName());
        hashMap.put("isDevice", Boolean.valueOf(getIsDevice()));
        hashMap.put("systemFonts", getSystemFonts());
        hashMap.put("systemVersion", getSystemVersion());
        Map hashMap2 = new HashMap();
        hashMap2.put("android", new HashMap());
        hashMap.put("platform", hashMap2);
        return hashMap;
    }

    public String getAppId() {
        return this.mContext.getPackageName();
    }

    public String getDeviceName() {
        return Build.MODEL;
    }

    public int getDeviceYearClass() {
        return YearClass.get(this.mContext);
    }

    public boolean getIsDevice() {
        return (isRunningOnGenymotion() || isRunningOnStockEmulator()) ? false : true;
    }

    public int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    public String getSystemVersion() {
        return VERSION.RELEASE;
    }

    public List<String> getSystemFonts() {
        List<String> arrayList = new ArrayList();
        arrayList.add("normal");
        arrayList.add("notoserif");
        arrayList.add("sans-serif");
        arrayList.add("sans-serif-light");
        arrayList.add("sans-serif-thin");
        arrayList.add("sans-serif-condensed");
        arrayList.add("sans-serif-medium");
        arrayList.add("serif");
        arrayList.add("Roboto");
        arrayList.add("monospace");
        return arrayList;
    }

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
    }
}
