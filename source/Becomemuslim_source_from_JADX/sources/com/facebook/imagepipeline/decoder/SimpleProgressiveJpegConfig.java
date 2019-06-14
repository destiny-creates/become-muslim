package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Collections;
import java.util.List;

public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    private final DynamicValueConfig mDynamicValueConfig;

    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    private static class DefaultDynamicValueConfig implements DynamicValueConfig {
        public int getGoodEnoughScanNumber() {
            return 0;
        }

        private DefaultDynamicValueConfig() {
        }

        public List<Integer> getScansToDecode() {
            return Collections.EMPTY_LIST;
        }
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig());
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(dynamicValueConfig);
    }

    public int getNextScanNumberToDecode(int i) {
        List scansToDecode = this.mDynamicValueConfig.getScansToDecode();
        if (scansToDecode != null) {
            if (!scansToDecode.isEmpty()) {
                for (int i2 = 0; i2 < scansToDecode.size(); i2++) {
                    if (((Integer) scansToDecode.get(i2)).intValue() > i) {
                        return ((Integer) scansToDecode.get(i2)).intValue();
                    }
                }
                return Integer.MAX_VALUE;
            }
        }
        return i + 1;
    }

    public QualityInfo getQualityInfo(int i) {
        return ImmutableQualityInfo.of(i, i >= this.mDynamicValueConfig.getGoodEnoughScanNumber(), false);
    }
}
