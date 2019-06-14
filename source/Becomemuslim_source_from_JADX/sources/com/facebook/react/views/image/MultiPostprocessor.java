package com.facebook.react.views.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.LinkedList;
import java.util.List;

public class MultiPostprocessor implements Postprocessor {
    private final List<Postprocessor> mPostprocessors;

    public static Postprocessor from(List<Postprocessor> list) {
        switch (list.size()) {
            case 0:
                return null;
            case 1:
                return (Postprocessor) list.get(0);
            default:
                return new MultiPostprocessor(list);
        }
    }

    private MultiPostprocessor(List<Postprocessor> list) {
        this.mPostprocessors = new LinkedList(list);
    }

    public String getName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Postprocessor postprocessor : this.mPostprocessors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(postprocessor.getName());
        }
        stringBuilder.insert(0, "MultiPostProcessor (");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CacheKey getPostprocessorCacheKey() {
        List linkedList = new LinkedList();
        for (Postprocessor postprocessorCacheKey : this.mPostprocessors) {
            linkedList.push(postprocessorCacheKey.getPostprocessorCacheKey());
        }
        return new MultiCacheKey(linkedList);
    }

    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference closeableReference = null;
        try {
            CloseableReference closeableReference2 = null;
            for (Postprocessor process : this.mPostprocessors) {
                CloseableReference process2 = process.process(closeableReference2 != null ? (Bitmap) closeableReference2.get() : bitmap, platformBitmapFactory);
                try {
                    CloseableReference.closeSafely(closeableReference2);
                    closeableReference2 = process2.clone();
                    closeableReference = process2;
                } catch (Throwable th) {
                    bitmap = th;
                    closeableReference = process2;
                }
            }
            bitmap = closeableReference.clone();
            CloseableReference.closeSafely(closeableReference);
            return bitmap;
        } catch (Throwable th2) {
            bitmap = th2;
            CloseableReference.closeSafely(closeableReference);
            throw bitmap;
        }
    }
}
