package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class ReactFontManager {
    private static final String[] EXTENSIONS = new String[]{"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = new String[]{".ttf", ".otf"};
    private static final String FONTS_ASSET_PATH = "fonts/";
    private static ReactFontManager sReactFontManagerInstance;
    private Map<String, FontFamily> mFontCache = new HashMap();

    private static class FontFamily {
        private SparseArray<Typeface> mTypefaceSparseArray;

        private FontFamily() {
            this.mTypefaceSparseArray = new SparseArray(4);
        }

        public Typeface getTypeface(int i) {
            return (Typeface) this.mTypefaceSparseArray.get(i);
        }

        public void setTypeface(int i, Typeface typeface) {
            this.mTypefaceSparseArray.put(i, typeface);
        }
    }

    private ReactFontManager() {
    }

    public static ReactFontManager getInstance() {
        if (sReactFontManagerInstance == null) {
            sReactFontManagerInstance = new ReactFontManager();
        }
        return sReactFontManagerInstance;
    }

    public Typeface getTypeface(String str, int i, AssetManager assetManager) {
        FontFamily fontFamily = (FontFamily) this.mFontCache.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily();
            this.mFontCache.put(str, fontFamily);
        }
        Typeface typeface = fontFamily.getTypeface(i);
        if (typeface == null) {
            typeface = createTypeface(str, i, assetManager);
            if (typeface != null) {
                fontFamily.setTypeface(i, typeface);
            }
        }
        return typeface;
    }

    public void setTypeface(String str, int i, Typeface typeface) {
        if (typeface != null) {
            FontFamily fontFamily = (FontFamily) this.mFontCache.get(str);
            if (fontFamily == null) {
                fontFamily = new FontFamily();
                this.mFontCache.put(str, fontFamily);
            }
            fontFamily.setTypeface(i, typeface);
        }
    }

    private static android.graphics.Typeface createTypeface(java.lang.String r7, int r8, android.content.res.AssetManager r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = EXTENSIONS;
        r0 = r0[r8];
        r1 = FILE_EXTENSIONS;
        r2 = r1.length;
        r3 = 0;
    L_0x0008:
        if (r3 >= r2) goto L_0x002b;
    L_0x000a:
        r4 = r1[r3];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "fonts/";
        r5.append(r6);
        r5.append(r7);
        r5.append(r0);
        r5.append(r4);
        r4 = r5.toString();
        r4 = android.graphics.Typeface.createFromAsset(r9, r4);	 Catch:{ RuntimeException -> 0x0028 }
        return r4;
    L_0x0028:
        r3 = r3 + 1;
        goto L_0x0008;
    L_0x002b:
        r7 = android.graphics.Typeface.create(r7, r8);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactFontManager.createTypeface(java.lang.String, int, android.content.res.AssetManager):android.graphics.Typeface");
    }
}
