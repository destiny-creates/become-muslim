package com.facebook.react.views.imagehelper;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.List;

public class MultiSourceHelper {

    public static class MultiSourceResult {
        private final ImageSource bestResult;
        private final ImageSource bestResultInCache;

        private MultiSourceResult(ImageSource imageSource, ImageSource imageSource2) {
            this.bestResult = imageSource;
            this.bestResultInCache = imageSource2;
        }

        public ImageSource getBestResult() {
            return this.bestResult;
        }

        public ImageSource getBestResultInCache() {
            return this.bestResultInCache;
        }
    }

    public static MultiSourceResult getBestSourceForSize(int i, int i2, List<ImageSource> list) {
        return getBestSourceForSize(i, i2, list, 1.0d);
    }

    public static MultiSourceResult getBestSourceForSize(int i, int i2, List<ImageSource> list, double d) {
        if (list.isEmpty()) {
            return new MultiSourceResult(null, null);
        }
        if (list.size() == 1) {
            return new MultiSourceResult((ImageSource) list.get(0), null);
        }
        if (i > 0) {
            if (i2 > 0) {
                ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
                i = ((double) (i * i2)) * d;
                d = Double.MAX_VALUE;
                double d2 = Double.MAX_VALUE;
                ImageSource imageSource = null;
                ImageSource imageSource2 = imageSource;
                for (ImageSource imageSource3 : list) {
                    double abs = Math.abs(1.0d - (imageSource3.getSize() / i));
                    if (abs < d) {
                        imageSource2 = imageSource3;
                        d = abs;
                    }
                    if (abs < d2 && (imagePipeline.isInBitmapMemoryCache(imageSource3.getUri()) || imagePipeline.isInDiskCacheSync(imageSource3.getUri()))) {
                        imageSource = imageSource3;
                        d2 = abs;
                    }
                }
                if (!(imageSource == null || imageSource2 == null || imageSource.getSource().equals(imageSource2.getSource()) == 0)) {
                    imageSource = null;
                }
                return new MultiSourceResult(imageSource2, imageSource);
            }
        }
        return new MultiSourceResult(null, null);
    }
}
