package com.bugsnag;

import com.bugsnag.android.C1082i;
import com.bugsnag.android.Severity;
import com.bugsnag.android.ai;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BugsnagReactNative */
/* renamed from: com.bugsnag.b */
class C3452b implements C1082i {
    /* renamed from: a */
    private final Severity f9227a;
    /* renamed from: b */
    private final String f9228b;
    /* renamed from: c */
    private final String f9229c;
    /* renamed from: d */
    private final Map<String, Object> f9230d;
    /* renamed from: e */
    private final String f9231e;
    /* renamed from: f */
    private final String f9232f;

    C3452b(String str, String str2, ReadableMap readableMap) {
        this.f9231e = str;
        this.f9232f = str2;
        this.f9227a = m11096a(readableMap.getString("severity"));
        this.f9230d = m11097a(readableMap.getMap("metadata"));
        if (readableMap.hasKey("context") != null) {
            this.f9228b = readableMap.getString("context");
        } else {
            this.f9228b = null;
        }
        if (readableMap.hasKey("groupingHash") != null) {
            this.f9229c = readableMap.getString("groupingHash");
        } else {
            this.f9229c = null;
        }
    }

    /* renamed from: a */
    Severity m11096a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 3237038) {
            if (hashCode != 96784904) {
                if (hashCode == 1124446108) {
                    if (str.equals("warning") != null) {
                        str = 2;
                        switch (str) {
                            case null:
                                return Severity.ERROR;
                            case 1:
                                return Severity.INFO;
                            default:
                                return Severity.WARNING;
                        }
                    }
                }
            } else if (str.equals("error") != null) {
                str = null;
                switch (str) {
                    case null:
                        return Severity.ERROR;
                    case 1:
                        return Severity.INFO;
                    default:
                        return Severity.WARNING;
                }
            }
        } else if (str.equals("info") != null) {
            str = true;
            switch (str) {
                case null:
                    return Severity.ERROR;
                case 1:
                    return Severity.INFO;
                default:
                    return Severity.WARNING;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return Severity.ERROR;
            case 1:
                return Severity.INFO;
            default:
                return Severity.WARNING;
        }
    }

    /* renamed from: a */
    Map<String, Object> m11097a(ReadableMap readableMap) {
        Map<String, Object> hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            String string = map.getString("type");
            Object obj = -1;
            int hashCode = string.hashCode();
            if (hashCode != -1034364087) {
                if (hashCode != -891985903) {
                    if (hashCode != 107868) {
                        if (hashCode == 64711720) {
                            if (string.equals("boolean")) {
                                obj = null;
                            }
                        }
                    } else if (string.equals("map")) {
                        obj = 3;
                    }
                } else if (string.equals("string")) {
                    obj = 2;
                }
            } else if (string.equals("number")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    hashMap.put(nextKey, Boolean.valueOf(map.getBoolean("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, Double.valueOf(map.getDouble("value")));
                    break;
                case 2:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 3:
                    hashMap.put(nextKey, m11097a(map.getMap("value")));
                    break;
                default:
                    break;
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo763a(ai aiVar) {
        aiVar.m11040b().m11038c("Bugsnag for React Native");
        aiVar.m11040b().m11037b("https://github.com/bugsnag/bugsnag-react-native");
        aiVar.m11040b().m11036a(String.format("%s (Android %s)", new Object[]{this.f9231e, this.f9232f}));
        if (this.f9229c != null && this.f9229c.length() > 0) {
            aiVar.m11039a().m11070b(this.f9229c);
        }
        if (this.f9228b != null && this.f9228b.length() > 0) {
            aiVar.m11039a().m11067a(this.f9228b);
        }
        if (this.f9230d != null) {
            aiVar = aiVar.m11039a().m11069b();
            for (String str : this.f9230d.keySet()) {
                Object obj = this.f9230d.get(str);
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str2 : map.keySet()) {
                        aiVar.m11033a(str, str2, map.get(str2));
                    }
                }
            }
        }
    }
}
