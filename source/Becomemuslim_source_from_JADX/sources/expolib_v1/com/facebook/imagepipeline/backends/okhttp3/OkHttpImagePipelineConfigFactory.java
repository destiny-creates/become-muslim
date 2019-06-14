package expolib_v1.com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import expolib_v1.p321a.C7490w;

public class OkHttpImagePipelineConfigFactory {
    public static Builder newBuilder(Context context, C7490w c7490w) {
        return ImagePipelineConfig.newBuilder(context).setNetworkFetcher(new OkHttpNetworkFetcher(c7490w));
    }
}
