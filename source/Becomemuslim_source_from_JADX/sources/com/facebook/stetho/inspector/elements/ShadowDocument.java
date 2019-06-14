package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class ShadowDocument implements DocumentView {
    private final IdentityHashMap<Object, ElementInfo> mElementToInfoMap = new IdentityHashMap();
    private boolean mIsUpdating;
    private final Object mRootElement;

    public final class UpdateBuilder {
        private HashSet<Object> mCachedNotNewChildrenSet;
        private final Map<Object, ElementInfo> mElementToInfoChangesMap = new LinkedHashMap();
        private final HashSet<Object> mRootElementChanges = new HashSet();

        public void setElementChildren(Object obj, List<Object> list) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo == null || !ListUtil.identityEquals(list, elementInfo.children)) {
                ElementInfo elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                if (elementInfo != null || elementInfo2 == null || !ListUtil.identityEquals(list, elementInfo2.children)) {
                    int size;
                    if (elementInfo == null || elementInfo2 == null || elementInfo2.parentElement != elementInfo.parentElement || !ListUtil.identityEquals(list, elementInfo2.children)) {
                        Object obj2 = elementInfo != null ? elementInfo.parentElement : elementInfo2 != null ? elementInfo2.parentElement : null;
                        ElementInfo elementInfo3 = new ElementInfo(obj, obj2, list);
                        this.mElementToInfoChangesMap.put(obj, elementInfo3);
                        list = elementInfo3;
                    } else {
                        list = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                        this.mElementToInfoChangesMap.remove(obj);
                    }
                    HashSet acquireNotNewChildrenHashSet = acquireNotNewChildrenHashSet();
                    if (!(elementInfo2 == null || elementInfo2.children == list.children)) {
                        size = elementInfo2.children.size();
                        for (int i = 0; i < size; i++) {
                            acquireNotNewChildrenHashSet.add(elementInfo2.children.get(i));
                        }
                    }
                    if (!(elementInfo == null || elementInfo.children == list.children)) {
                        int size2 = elementInfo.children.size();
                        for (size = 0; size < size2; size++) {
                            acquireNotNewChildrenHashSet.add(elementInfo.children.get(size));
                        }
                    }
                    int size3 = list.children.size();
                    for (int i2 = 0; i2 < size3; i2++) {
                        Object obj3 = list.children.get(i2);
                        setElementParent(obj3, obj);
                        acquireNotNewChildrenHashSet.remove(obj3);
                    }
                    list = acquireNotNewChildrenHashSet.iterator();
                    while (list.hasNext()) {
                        Object next = list.next();
                        elementInfo2 = (ElementInfo) this.mElementToInfoChangesMap.get(next);
                        if (elementInfo2 == null || elementInfo2.parentElement == obj) {
                            elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(next);
                            if (elementInfo2 != null && elementInfo2.parentElement == obj) {
                                setElementParent(next, null);
                            }
                        }
                    }
                    releaseNotNewChildrenHashSet(acquireNotNewChildrenHashSet);
                }
            }
        }

        private void setElementParent(Object obj, Object obj2) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo == null || obj2 != elementInfo.parentElement) {
                ElementInfo elementInfo2 = (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
                if (elementInfo != null || elementInfo2 == null || obj2 != elementInfo2.parentElement) {
                    if (elementInfo == null || elementInfo2 == null || obj2 != elementInfo2.parentElement || !ListUtil.identityEquals(elementInfo2.children, elementInfo.children)) {
                        List emptyList = elementInfo != null ? elementInfo.children : elementInfo2 != null ? elementInfo2.children : Collections.emptyList();
                        this.mElementToInfoChangesMap.put(obj, new ElementInfo(obj, obj2, emptyList));
                        if (obj2 == null) {
                            this.mRootElementChanges.add(obj);
                        } else {
                            this.mRootElementChanges.remove(obj);
                        }
                        return;
                    }
                    this.mElementToInfoChangesMap.remove(obj);
                    if (obj2 == null) {
                        this.mRootElementChanges.remove(obj);
                    }
                }
            }
        }

        public Update build() {
            return new Update(this.mElementToInfoChangesMap, this.mRootElementChanges);
        }

        private HashSet<Object> acquireNotNewChildrenHashSet() {
            HashSet<Object> hashSet = this.mCachedNotNewChildrenSet;
            if (hashSet == null) {
                hashSet = new HashSet();
            }
            this.mCachedNotNewChildrenSet = null;
            return hashSet;
        }

        private void releaseNotNewChildrenHashSet(HashSet<Object> hashSet) {
            hashSet.clear();
            if (this.mCachedNotNewChildrenSet == null) {
                this.mCachedNotNewChildrenSet = hashSet;
            }
        }
    }

    public final class Update implements DocumentView {
        private final Map<Object, ElementInfo> mElementToInfoChangesMap;
        private final Set<Object> mRootElementChangesSet;

        public Update(Map<Object, ElementInfo> map, Set<Object> set) {
            this.mElementToInfoChangesMap = map;
            this.mRootElementChangesSet = set;
        }

        public boolean isEmpty() {
            return this.mElementToInfoChangesMap.isEmpty();
        }

        public boolean isElementChanged(Object obj) {
            return this.mElementToInfoChangesMap.containsKey(obj);
        }

        public Object getRootElement() {
            return ShadowDocument.this.getRootElement();
        }

        public ElementInfo getElementInfo(Object obj) {
            ElementInfo elementInfo = (ElementInfo) this.mElementToInfoChangesMap.get(obj);
            if (elementInfo != null) {
                return elementInfo;
            }
            return (ElementInfo) ShadowDocument.this.mElementToInfoMap.get(obj);
        }

        public void getChangedElements(Accumulator<Object> accumulator) {
            for (Object store : this.mElementToInfoChangesMap.keySet()) {
                accumulator.store(store);
            }
        }

        public void getGarbageElements(Accumulator<Object> accumulator) {
            Queue arrayDeque = new ArrayDeque();
            for (Object next : this.mRootElementChangesSet) {
                Object next2;
                ElementInfo elementInfo = getElementInfo(next2);
                if (next2 != ShadowDocument.this.mRootElement && elementInfo.parentElement == null) {
                    arrayDeque.add(next2);
                    arrayDeque.add(next2);
                }
            }
            while (!arrayDeque.isEmpty()) {
                Object remove = arrayDeque.remove();
                next2 = arrayDeque.remove();
                if (remove == next2) {
                    next2 = null;
                }
                if (getElementInfo(remove).parentElement == next2) {
                    accumulator.store(remove);
                    ElementInfo elementInfo2 = ShadowDocument.this.getElementInfo(remove);
                    if (elementInfo2 != null) {
                        int size = elementInfo2.children.size();
                        for (int i = 0; i < size; i++) {
                            arrayDeque.add(elementInfo2.children.get(i));
                            arrayDeque.add(remove);
                        }
                    }
                }
            }
        }

        public void abandon() {
            if (ShadowDocument.this.mIsUpdating) {
                ShadowDocument.this.mIsUpdating = false;
                return;
            }
            throw new IllegalStateException();
        }

        public void commit() {
            if (ShadowDocument.this.mIsUpdating) {
                ShadowDocument.this.mElementToInfoMap.putAll(this.mElementToInfoChangesMap);
                for (Object removeSubTree : this.mRootElementChangesSet) {
                    removeSubTree(ShadowDocument.this.mElementToInfoMap, removeSubTree);
                }
                ShadowDocument.this.mIsUpdating = false;
                return;
            }
            throw new IllegalStateException();
        }

        private void removeSubTree(Map<Object, ElementInfo> map, Object obj) {
            ElementInfo elementInfo = (ElementInfo) map.get(obj);
            map.remove(obj);
            obj = elementInfo.children.size();
            for (int i = 0; i < obj; i++) {
                removeSubTree(map, elementInfo.children.get(i));
            }
        }
    }

    public ShadowDocument(Object obj) {
        this.mRootElement = Util.throwIfNull(obj);
    }

    public Object getRootElement() {
        return this.mRootElement;
    }

    public ElementInfo getElementInfo(Object obj) {
        return (ElementInfo) this.mElementToInfoMap.get(obj);
    }

    public UpdateBuilder beginUpdate() {
        if (this.mIsUpdating) {
            throw new IllegalStateException();
        }
        this.mIsUpdating = true;
        return new UpdateBuilder();
    }
}
