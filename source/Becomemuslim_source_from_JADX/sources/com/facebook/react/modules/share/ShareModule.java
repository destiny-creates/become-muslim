package com.facebook.react.modules.share;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "ShareModule")
public class ShareModule extends ReactContextBaseJavaModule {
    static final String ACTION_SHARED = "sharedAction";
    static final String ERROR_INVALID_CONTENT = "E_INVALID_CONTENT";
    static final String ERROR_UNABLE_TO_OPEN_DIALOG = "E_UNABLE_TO_OPEN_DIALOG";

    public String getName() {
        return "ShareModule";
    }

    public ShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @com.facebook.react.bridge.ReactMethod
    public void share(com.facebook.react.bridge.ReadableMap r4, java.lang.String r5, com.facebook.react.bridge.Promise r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        if (r4 != 0) goto L_0x000a;
    L_0x0002:
        r4 = "E_INVALID_CONTENT";
        r5 = "Content cannot be null";
        r6.reject(r4, r5);
        return;
    L_0x000a:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0065 }
        r1 = "android.intent.action.SEND";	 Catch:{ Exception -> 0x0065 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = "text/plain";	 Catch:{ Exception -> 0x0065 }
        r0.setTypeAndNormalize(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = "title";	 Catch:{ Exception -> 0x0065 }
        r1 = r4.hasKey(r1);	 Catch:{ Exception -> 0x0065 }
        if (r1 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x0065 }
    L_0x001e:
        r1 = "android.intent.extra.SUBJECT";	 Catch:{ Exception -> 0x0065 }
        r2 = "title";	 Catch:{ Exception -> 0x0065 }
        r2 = r4.getString(r2);	 Catch:{ Exception -> 0x0065 }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x0065 }
    L_0x0029:
        r1 = "message";	 Catch:{ Exception -> 0x0065 }
        r1 = r4.hasKey(r1);	 Catch:{ Exception -> 0x0065 }
        if (r1 == 0) goto L_0x003c;	 Catch:{ Exception -> 0x0065 }
    L_0x0031:
        r1 = "android.intent.extra.TEXT";	 Catch:{ Exception -> 0x0065 }
        r2 = "message";	 Catch:{ Exception -> 0x0065 }
        r4 = r4.getString(r2);	 Catch:{ Exception -> 0x0065 }
        r0.putExtra(r1, r4);	 Catch:{ Exception -> 0x0065 }
    L_0x003c:
        r4 = android.content.Intent.createChooser(r0, r5);	 Catch:{ Exception -> 0x0065 }
        r5 = "android.intent.category.DEFAULT";	 Catch:{ Exception -> 0x0065 }
        r4.addCategory(r5);	 Catch:{ Exception -> 0x0065 }
        r5 = r3.getCurrentActivity();	 Catch:{ Exception -> 0x0065 }
        if (r5 == 0) goto L_0x004f;	 Catch:{ Exception -> 0x0065 }
    L_0x004b:
        r5.startActivity(r4);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0056;	 Catch:{ Exception -> 0x0065 }
    L_0x004f:
        r5 = r3.getReactApplicationContext();	 Catch:{ Exception -> 0x0065 }
        r5.startActivity(r4);	 Catch:{ Exception -> 0x0065 }
    L_0x0056:
        r4 = com.facebook.react.bridge.Arguments.createMap();	 Catch:{ Exception -> 0x0065 }
        r5 = "action";	 Catch:{ Exception -> 0x0065 }
        r0 = "sharedAction";	 Catch:{ Exception -> 0x0065 }
        r4.putString(r5, r0);	 Catch:{ Exception -> 0x0065 }
        r6.resolve(r4);	 Catch:{ Exception -> 0x0065 }
        goto L_0x006c;
    L_0x0065:
        r4 = "E_UNABLE_TO_OPEN_DIALOG";
        r5 = "Failed to open share dialog";
        r6.reject(r4, r5);
    L_0x006c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.share.ShareModule.share(com.facebook.react.bridge.ReadableMap, java.lang.String, com.facebook.react.bridge.Promise):void");
    }
}
