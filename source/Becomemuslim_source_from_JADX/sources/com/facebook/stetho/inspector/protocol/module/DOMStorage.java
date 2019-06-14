package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.facebook.stetho.inspector.domstorage.DOMStoragePeerManager;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class DOMStorage implements ChromeDevtoolsDomain {
    private final Context mContext;
    private final DOMStoragePeerManager mDOMStoragePeerManager;
    private final ObjectMapper mObjectMapper = new ObjectMapper();

    private static class DOMStorageAssignmentException extends Exception {
        public DOMStorageAssignmentException(String str) {
            super(str);
        }
    }

    public static class DomStorageItemAddedParams {
        @JsonProperty(required = true)
        public String key;
        @JsonProperty(required = true)
        public String newValue;
        @JsonProperty(required = true)
        public StorageId storageId;
    }

    public static class DomStorageItemRemovedParams {
        @JsonProperty(required = true)
        public String key;
        @JsonProperty(required = true)
        public StorageId storageId;
    }

    public static class DomStorageItemUpdatedParams {
        @JsonProperty(required = true)
        public String key;
        @JsonProperty(required = true)
        public String newValue;
        @JsonProperty(required = true)
        public String oldValue;
        @JsonProperty(required = true)
        public StorageId storageId;
    }

    public static class DomStorageItemsClearedParams {
        @JsonProperty(required = true)
        public StorageId storageId;
    }

    public static class StorageId {
        @JsonProperty(required = true)
        public boolean isLocalStorage;
        @JsonProperty(required = true)
        public String securityOrigin;
    }

    private static class GetDOMStorageItemsResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<List<String>> entries;

        private GetDOMStorageItemsResult() {
        }
    }

    public DOMStorage(Context context) {
        this.mContext = context;
        this.mDOMStoragePeerManager = new DOMStoragePeerManager(context);
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMStoragePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDOMStoragePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDOMStorageItems(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        StorageId storageId = (StorageId) this.mObjectMapper.convertValue(jSONObject.getJSONObject("storageId"), StorageId.class);
        jSONObject = new ArrayList();
        String str = storageId.securityOrigin;
        if (storageId.isLocalStorage != null) {
            for (Entry entry : this.mContext.getSharedPreferences(str, 0).getAll().entrySet()) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(entry.getKey());
                arrayList.add(SharedPreferencesHelper.valueToString(entry.getValue()));
                jSONObject.add(arrayList);
            }
        }
        jsonRpcPeer = new GetDOMStorageItemsResult();
        jsonRpcPeer.entries = jSONObject;
        return jsonRpcPeer;
    }

    @com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod
    public void setDOMStorageItem(com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer r10, org.json.JSONObject r11) {
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
        r9 = this;
        r10 = r9.mObjectMapper;
        r0 = "storageId";
        r0 = r11.getJSONObject(r0);
        r1 = com.facebook.stetho.inspector.protocol.module.DOMStorage.StorageId.class;
        r10 = r10.convertValue(r0, r1);
        r10 = (com.facebook.stetho.inspector.protocol.module.DOMStorage.StorageId) r10;
        r0 = "key";
        r0 = r11.getString(r0);
        r1 = "value";
        r11 = r11.getString(r1);
        r1 = r10.isLocalStorage;
        if (r1 == 0) goto L_0x00a2;
    L_0x0020:
        r1 = r9.mContext;
        r2 = r10.securityOrigin;
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);
        r2 = r1.getAll();
        r2 = r2.get(r0);
        if (r2 == 0) goto L_0x0063;
    L_0x0033:
        r4 = r1.edit();	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r5 = com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper.valueFromString(r11, r2);	 Catch:{ IllegalArgumentException -> 0x0042 }
        assignByType(r4, r0, r5);	 Catch:{ IllegalArgumentException -> 0x0042 }
        r4.apply();	 Catch:{ IllegalArgumentException -> 0x0042 }
        goto L_0x00a2;
    L_0x0042:
        r4 = new com.facebook.stetho.inspector.protocol.module.DOMStorage$DOMStorageAssignmentException;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r5 = java.util.Locale.US;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r6 = "Type mismatch setting %s to %s (expected %s)";	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r7 = 3;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r7 = new java.lang.Object[r7];	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r7[r3] = r0;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r3 = 1;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r7[r3] = r11;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r3 = 2;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r8 = r2.getClass();	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r8 = r8.getSimpleName();	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r7[r3] = r8;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r3 = java.lang.String.format(r5, r6, r7);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4.<init>(r3);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        throw r4;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
    L_0x0063:
        r3 = new com.facebook.stetho.inspector.protocol.module.DOMStorage$DOMStorageAssignmentException;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4 = new java.lang.StringBuilder;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4.<init>();	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r5 = "Unsupported: cannot add new key ";	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4.append(r5);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4.append(r0);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r5 = " due to lack of type inference";	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4.append(r5);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r4 = r4.toString();	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        r3.<init>(r4);	 Catch:{ DOMStorageAssignmentException -> 0x007f }
        throw r3;	 Catch:{ DOMStorageAssignmentException -> 0x007f }
    L_0x007f:
        r3 = move-exception;
        r4 = r9.mDOMStoragePeerManager;
        r5 = com.facebook.stetho.inspector.protocol.module.Console.MessageLevel.ERROR;
        r6 = com.facebook.stetho.inspector.protocol.module.Console.MessageSource.STORAGE;
        r3 = r3.getMessage();
        com.facebook.stetho.inspector.console.CLog.writeToConsole(r4, r5, r6, r3);
        r1 = r1.contains(r0);
        if (r1 == 0) goto L_0x009d;
    L_0x0093:
        r1 = r9.mDOMStoragePeerManager;
        r2 = com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper.valueToString(r2);
        r1.signalItemUpdated(r10, r0, r11, r2);
        goto L_0x00a2;
    L_0x009d:
        r11 = r9.mDOMStoragePeerManager;
        r11.signalItemRemoved(r10, r0);
    L_0x00a2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.protocol.module.DOMStorage.setDOMStorageItem(com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer, org.json.JSONObject):void");
    }

    @ChromeDevtoolsMethod
    public void removeDOMStorageItem(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        StorageId storageId = (StorageId) this.mObjectMapper.convertValue(jSONObject.getJSONObject("storageId"), StorageId.class);
        jSONObject = jSONObject.getString("key");
        if (storageId.isLocalStorage) {
            this.mContext.getSharedPreferences(storageId.securityOrigin, 0).edit().remove(jSONObject).apply();
        }
    }

    private static void assignByType(Editor editor, String str, Object obj) {
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else if (obj instanceof Set) {
            putStringSet(editor, str, (Set) obj);
        } else {
            str = new StringBuilder();
            str.append("Unsupported type=");
            str.append(obj.getClass().getName());
            throw new IllegalArgumentException(str.toString());
        }
    }

    @TargetApi(11)
    private static void putStringSet(Editor editor, String str, Set<String> set) {
        editor.putStringSet(str, set);
    }
}
