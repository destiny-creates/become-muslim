package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionMapper {

    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    public static <T> void iterate(final Collection<T> collection, ValueMapper valueMapper, final OnMapperCompleteListener onMapperCompleteListener) {
        final Mutable mutable = new Mutable(Boolean.valueOf(false));
        final Mutable mutable2 = new Mutable(Integer.valueOf(1));
        final OnMapperCompleteListener c46621 = new OnMapperCompleteListener() {
            public void onComplete() {
                if (!((Boolean) mutable.value).booleanValue()) {
                    Mutable mutable = mutable2;
                    Integer valueOf = Integer.valueOf(((Integer) mutable2.value).intValue() - 1);
                    mutable.value = valueOf;
                    if (valueOf.intValue() == 0) {
                        onMapperCompleteListener.onComplete();
                    }
                }
            }

            public void onError(FacebookException facebookException) {
                if (!((Boolean) mutable.value).booleanValue()) {
                    mutable.value = Boolean.valueOf(true);
                    onMapperCompleteListener.onError(facebookException);
                }
            }
        };
        onMapperCompleteListener = collection.keyIterator();
        List linkedList = new LinkedList();
        while (onMapperCompleteListener.hasNext()) {
            linkedList.add(onMapperCompleteListener.next());
        }
        for (final Object next : linkedList) {
            Object obj = collection.get(next);
            OnMapValueCompleteListener c46632 = new OnMapValueCompleteListener() {
                public void onComplete(Object obj) {
                    collection.set(next, obj, c46621);
                    c46621.onComplete();
                }

                public void onError(FacebookException facebookException) {
                    c46621.onError(facebookException);
                }
            };
            Integer num = (Integer) mutable2.value;
            mutable2.value = Integer.valueOf(((Integer) mutable2.value).intValue() + 1);
            valueMapper.mapValue(obj, c46632);
        }
        c46621.onComplete();
    }

    private CollectionMapper() {
    }
}
