package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.List;
import java.util.Map;

class UIManagerModuleConstantsHelper {
    private static final String BUBBLING_EVENTS_KEY = "bubblingEventTypes";
    private static final String DIRECT_EVENTS_KEY = "directEventTypes";

    UIManagerModuleConstantsHelper() {
    }

    static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        constants.put("ViewManagerNames", viewManagerResolver.getViewManagerNames());
        return constants;
    }

    static Map<String, Object> getDefaultExportableEventTypes() {
        return MapBuilder.of(BUBBLING_EVENTS_KEY, UIManagerModuleConstants.getBubblingEventTypeConstants(), DIRECT_EVENTS_KEY, UIManagerModuleConstants.getDirectEventTypeConstants());
    }

    static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> constants = UIManagerModuleConstants.getConstants();
        Map bubblingEventTypeConstants = UIManagerModuleConstants.getBubblingEventTypeConstants();
        Map directEventTypeConstants = UIManagerModuleConstants.getDirectEventTypeConstants();
        if (map != null) {
            map.putAll(bubblingEventTypeConstants);
        }
        if (map2 != null) {
            map2.putAll(directEventTypeConstants);
        }
        for (ViewManager viewManager : list) {
            Object name = viewManager.getName();
            SystraceMessage.beginSection(0, "UIManagerModuleConstantsHelper.createConstants").arg("ViewManager", name).arg("Lazy", Boolean.valueOf(false)).flush();
            try {
                Map createConstantsForViewManager = createConstantsForViewManager(viewManager, null, null, map, map2);
                if (!createConstantsForViewManager.isEmpty()) {
                    constants.put(name, createConstantsForViewManager);
                }
                Systrace.endSection(0);
            } catch (Throwable th) {
                Systrace.endSection(0);
            }
        }
        constants.put("genericBubblingEventTypes", bubblingEventTypeConstants);
        constants.put("genericDirectEventTypes", directEventTypeConstants);
        return constants;
    }

    static Map<String, Object> createConstantsForViewManager(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        Map<String, Object> newHashMap = MapBuilder.newHashMap();
        Map exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            recursiveMerge(map3, exportedCustomBubblingEventTypeConstants);
            recursiveMerge(exportedCustomBubblingEventTypeConstants, map);
            newHashMap.put(BUBBLING_EVENTS_KEY, exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            newHashMap.put(BUBBLING_EVENTS_KEY, map);
        }
        map = viewManager.getExportedCustomDirectEventTypeConstants();
        if (map != null) {
            recursiveMerge(map4, map);
            recursiveMerge(map, map2);
            newHashMap.put(DIRECT_EVENTS_KEY, map);
        } else if (map2 != null) {
            newHashMap.put(DIRECT_EVENTS_KEY, map2);
        }
        map = viewManager.getExportedViewConstants();
        if (map != null) {
            newHashMap.put("Constants", map);
        }
        map = viewManager.getCommandsMap();
        if (map != null) {
            newHashMap.put("Commands", map);
        }
        viewManager = viewManager.getNativeProps();
        if (viewManager.isEmpty() == null) {
            newHashMap.put("NativeProps", viewManager);
        }
        return newHashMap;
    }

    private static void recursiveMerge(Map map, Map map2) {
        if (!(map == null || map2 == null)) {
            if (!map2.isEmpty()) {
                for (Object next : map2.keySet()) {
                    Object obj = map2.get(next);
                    Object obj2 = map.get(next);
                    if (obj2 != null && (obj instanceof Map) && (obj2 instanceof Map)) {
                        recursiveMerge((Map) obj2, (Map) obj);
                    } else {
                        map.put(next, obj);
                    }
                }
            }
        }
    }
}
