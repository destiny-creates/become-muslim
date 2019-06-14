package versioned.host.exp.exponent.modules.api;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import host.exp.exponent.p346j.C6385c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MailComposerModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private boolean mComposerOpened = null;
    private Promise mPromise;

    public String getName() {
        return "ExponentMailComposer";
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public MailComposerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @ReactMethod
    public void composeAsync(ReadableMap readableMap, Promise promise) {
        Spanned fromHtml;
        ReadableArray array;
        int i;
        List<ResolveInfo> queryIntentActivities;
        List arrayList;
        Intent createChooser;
        MailComposerModule mailComposerModule = this;
        ReadableMap readableMap2 = readableMap;
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        String[] strArr = new String[0];
        String[] strArr2 = new String[0];
        String[] strArr3 = new String[0];
        String str = "";
        String str2 = "";
        ArrayList arrayList2 = new ArrayList();
        if (readableMap2.hasKey("recipients")) {
            strArr = (String[]) readableMap2.getArray("recipients").toArrayList().toArray(new String[0]);
        }
        if (readableMap2.hasKey("ccRecipients")) {
            strArr2 = (String[]) readableMap2.getArray("ccRecipients").toArrayList().toArray(new String[0]);
        }
        if (readableMap2.hasKey("bccRecipients")) {
            strArr3 = (String[]) readableMap2.getArray("bccRecipients").toArrayList().toArray(new String[0]);
        }
        if (readableMap2.hasKey("subject")) {
            str = readableMap2.getString("subject");
        }
        Object obj = (readableMap2.hasKey("isHtml") && readableMap2.getBoolean("isHtml")) ? 1 : null;
        if (readableMap2.hasKey("body")) {
            if (obj != null) {
                fromHtml = Html.fromHtml(readableMap2.getString("body"));
                if (readableMap2.hasKey("attachments")) {
                    array = readableMap2.getArray("attachments");
                    for (i = 0; i < array.size(); i++) {
                        arrayList2.add(C6385c.m26195b(new File(Uri.parse(readableMap2.getArray("attachments").getString(i)).getPath())));
                    }
                }
                queryIntentActivities = getReactApplicationContext().getPackageManager().queryIntentActivities(intent, 0);
                arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
                    intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    intent2.putExtra("android.intent.extra.EMAIL", strArr);
                    intent2.putExtra("android.intent.extra.CC", strArr2);
                    intent2.putExtra("android.intent.extra.BCC", strArr3);
                    intent2.putExtra("android.intent.extra.SUBJECT", str);
                    intent2.putExtra("android.intent.extra.TEXT", obj == null ? fromHtml : str2);
                    intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
                    arrayList.add(new LabeledIntent(intent2, resolveInfo.activityInfo.packageName, resolveInfo.loadLabel(getReactApplicationContext().getPackageManager()), resolveInfo.icon));
                }
                createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), null);
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
                mailComposerModule.mPromise = promise;
                createChooser.addFlags(268435456);
                createChooser.addFlags(1);
                getReactApplicationContext().startActivity(createChooser);
                mailComposerModule.mComposerOpened = true;
            }
            str2 = readableMap2.getString("body");
        }
        fromHtml = null;
        if (readableMap2.hasKey("attachments")) {
            array = readableMap2.getArray("attachments");
            for (i = 0; i < array.size(); i++) {
                arrayList2.add(C6385c.m26195b(new File(Uri.parse(readableMap2.getArray("attachments").getString(i)).getPath())));
            }
        }
        queryIntentActivities = getReactApplicationContext().getPackageManager().queryIntentActivities(intent, 0);
        arrayList = new ArrayList();
        for (ResolveInfo resolveInfo2 : queryIntentActivities) {
            Intent intent22 = new Intent("android.intent.action.SEND_MULTIPLE");
            intent22.setComponent(new ComponentName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name));
            intent22.putExtra("android.intent.extra.EMAIL", strArr);
            intent22.putExtra("android.intent.extra.CC", strArr2);
            intent22.putExtra("android.intent.extra.BCC", strArr3);
            intent22.putExtra("android.intent.extra.SUBJECT", str);
            if (obj == null) {
            }
            intent22.putExtra("android.intent.extra.TEXT", obj == null ? fromHtml : str2);
            intent22.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
            arrayList.add(new LabeledIntent(intent22, resolveInfo2.activityInfo.packageName, resolveInfo2.loadLabel(getReactApplicationContext().getPackageManager()), resolveInfo2.icon));
        }
        createChooser = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), null);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
        mailComposerModule.mPromise = promise;
        createChooser.addFlags(268435456);
        createChooser.addFlags(1);
        getReactApplicationContext().startActivity(createChooser);
        mailComposerModule.mComposerOpened = true;
    }

    public void onHostResume() {
        if (this.mComposerOpened) {
            this.mComposerOpened = false;
            WritableMap createMap = Arguments.createMap();
            createMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "sent");
            this.mPromise.resolve(createMap);
        }
    }
}
