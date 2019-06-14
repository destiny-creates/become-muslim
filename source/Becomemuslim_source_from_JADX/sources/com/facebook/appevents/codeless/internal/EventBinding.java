package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class EventBinding {
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    public static java.util.List<com.facebook.appevents.codeless.internal.EventBinding> parseArray(org.json.JSONArray r4) {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        if (r4 == 0) goto L_0x000d;
    L_0x0008:
        r2 = r4.length();	 Catch:{ JSONException -> 0x001e }
        goto L_0x000e;	 Catch:{ JSONException -> 0x001e }
    L_0x000d:
        r2 = 0;	 Catch:{ JSONException -> 0x001e }
    L_0x000e:
        if (r1 >= r2) goto L_0x001e;	 Catch:{ JSONException -> 0x001e }
    L_0x0010:
        r3 = r4.getJSONObject(r1);	 Catch:{ JSONException -> 0x001e }
        r3 = getInstanceFromJson(r3);	 Catch:{ JSONException -> 0x001e }
        r0.add(r3);	 Catch:{ JSONException -> 0x001e }
        r1 = r1 + 1;
        goto L_0x000e;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.EventBinding.parseArray(org.json.JSONArray):java.util.List<com.facebook.appevents.codeless.internal.EventBinding>");
    }

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) {
        String string = jSONObject.getString("event_name");
        MappingMethod valueOf = MappingMethod.valueOf(jSONObject.getString("method").toUpperCase());
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase());
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        List arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i)));
        }
        String optString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        jSONArray = jSONObject.optJSONArray("parameters");
        List arrayList2 = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList2.add(new ParameterComponent(jSONArray.getJSONObject(i2)));
            }
        }
        return new EventBinding(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
    }

    public List<PathComponent> getViewPath() {
        return Collections.unmodifiableList(this.path);
    }

    public List<ParameterComponent> getViewParameters() {
        return Collections.unmodifiableList(this.parameters);
    }

    public String getEventName() {
        return this.eventName;
    }

    public ActionType getType() {
        return this.type;
    }

    public MappingMethod getMethod() {
        return this.method;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getComponentId() {
        return this.componentId;
    }

    public String getPathType() {
        return this.pathType;
    }

    public String getActivityName() {
        return this.activityName;
    }
}
