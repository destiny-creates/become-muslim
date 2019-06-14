package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;

public class ObjectIdMapper {
    private SparseArray<Object> mIdToObjectMap = new SparseArray();
    private int mNextId = 1;
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    protected final Object mSync = new Object();

    protected void onMapped(Object obj, int i) {
    }

    protected void onUnmapped(Object obj, int i) {
    }

    public void clear() {
        SparseArray sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray();
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            onUnmapped(sparseArray.valueAt(i), sparseArray.keyAt(i));
        }
    }

    public boolean containsId(int i) {
        synchronized (this.mSync) {
            i = this.mIdToObjectMap.get(i) != 0 ? 1 : 0;
        }
        return i;
    }

    public boolean containsObject(Object obj) {
        synchronized (this.mSync) {
            obj = this.mObjectToIdMap.containsKey(obj);
        }
        return obj;
    }

    public Object getObjectForId(int i) {
        synchronized (this.mSync) {
            i = this.mIdToObjectMap.get(i);
        }
        return i;
    }

    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = (Integer) this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = (Integer) this.mObjectToIdMap.get(obj);
            if (num != null) {
                obj = num.intValue();
                return obj;
            }
            int i = this.mNextId;
            this.mNextId = i + 1;
            num = Integer.valueOf(i);
            this.mObjectToIdMap.put(obj, num);
            this.mIdToObjectMap.put(num.intValue(), obj);
            onMapped(obj, num.intValue());
            return num.intValue();
        }
    }

    public Object removeObjectById(int i) {
        synchronized (this.mSync) {
            Object obj = this.mIdToObjectMap.get(i);
            if (obj == null) {
                return 0;
            }
            this.mIdToObjectMap.remove(i);
            this.mObjectToIdMap.remove(obj);
            onUnmapped(obj, i);
            return obj;
        }
    }

    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = (Integer) this.mObjectToIdMap.remove(obj);
            if (num == null) {
                return null;
            }
            this.mIdToObjectMap.remove(num.intValue());
            onUnmapped(obj, num.intValue());
            return num;
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }
}
