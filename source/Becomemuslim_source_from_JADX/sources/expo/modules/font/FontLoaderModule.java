package expo.modules.font;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p307b.p313f.C6028a;
import java.io.File;

public class FontLoaderModule extends C6006c implements C6001h {
    private static final String ASSET_SCHEME = "asset://";
    private static final String EXPORTED_NAME = "ExpoFontLoader";
    private C6007d mModuleRegistry;

    public String getName() {
        return EXPORTED_NAME;
    }

    public FontLoaderModule(Context context) {
        super(context);
    }

    @C5996c
    public void loadAsync(String str, String str2, C6009f c6009f) {
        try {
            if (str2.startsWith(ASSET_SCHEME)) {
                str2 = Typeface.createFromAsset(getContext().getAssets(), str2.substring(ASSET_SCHEME.length() + 1));
            } else {
                str2 = Typeface.createFromFile(new File(Uri.parse(str2).getPath()));
            }
            C6028a c6028a = (C6028a) this.mModuleRegistry.m25133a(C6028a.class);
            if (c6028a == null) {
                c6009f.m25152a("E_NO_FONT_MANAGER", "There is no FontManager in module registry. Are you sure all the dependencies of expo-font are installed and linked?");
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ExpoFont-");
            stringBuilder.append(str);
            c6028a.mo5143a(stringBuilder.toString(), 0, str2);
            c6009f.mo5137a((Object) null);
        } catch (String str3) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Font.loadAsync unexpected exception: ");
            stringBuilder2.append(str3.getMessage());
            c6009f.mo5138a("E_UNEXPECTED", stringBuilder2.toString(), str3);
        }
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }
}
