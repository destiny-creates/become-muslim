package versioned.host.exp.exponent.modules.universal;

import android.content.Context;
import expo.modules.filesystem.FileSystemModule;
import host.exp.exponent.C6301d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.p371a.p376c.C6646d;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScopedFileSystemModule extends FileSystemModule {
    private static final String SHELL_APP_EMBEDDED_MANIFEST_PATH = "shell-app-manifest.json";

    public ScopedFileSystemModule(Context context) {
        super(context);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap(super.getConstants());
        hashMap.put("bundledAssets", getBundledAssets());
        return hashMap;
    }

    private List<String> getBundledAssets() {
        if (!C6301d.m26001a()) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(C6646d.m27063b(getContext().getAssets().open(SHELL_APP_EMBEDDED_MANIFEST_PATH))).getJSONArray("bundledAssets");
            if (jSONArray == null) {
                return null;
            }
            List<String> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
