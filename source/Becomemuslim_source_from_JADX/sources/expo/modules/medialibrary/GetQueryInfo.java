package expo.modules.medialibrary;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class GetQueryInfo {
    private Map<String, Object> mInput;
    private int mLimit;
    private int mOffset;
    private StringBuilder mOrder;
    private StringBuilder mSelection;

    GetQueryInfo(Map<String, Object> map) {
        this.mInput = map;
    }

    int getLimit() {
        return this.mLimit;
    }

    int getOffset() {
        return this.mOffset;
    }

    String getSelection() {
        return this.mSelection.toString();
    }

    String getOrder() {
        return this.mOrder.toString();
    }

    public GetQueryInfo invoke() {
        this.mLimit = this.mInput.containsKey("first") ? ((Double) this.mInput.get("first")).intValue() : 20;
        this.mSelection = new StringBuilder();
        if (this.mInput.containsKey("album")) {
            StringBuilder stringBuilder = this.mSelection;
            stringBuilder.append("bucket_id");
            stringBuilder.append(" = ");
            stringBuilder.append(this.mInput.get("album"));
            this.mSelection.append(" AND ");
        }
        List<Object> list = this.mInput.containsKey("mediaType") ? (List) this.mInput.get("mediaType") : null;
        int i = 0;
        if (list == null || list.contains("all")) {
            stringBuilder = this.mSelection;
            stringBuilder.append(MessengerShareContentUtility.MEDIA_TYPE);
            stringBuilder.append(" != ");
            stringBuilder.append(0);
        } else {
            Iterable arrayList = new ArrayList();
            for (Object obj : list) {
                arrayList.add(MediaLibraryUtils.convertMediaType(obj.toString()));
            }
            stringBuilder = this.mSelection;
            stringBuilder.append(MessengerShareContentUtility.MEDIA_TYPE);
            stringBuilder.append(" IN (");
            stringBuilder.append(TextUtils.join(",", arrayList));
            stringBuilder.append(")");
        }
        this.mOrder = new StringBuilder();
        if (!this.mInput.containsKey("sortBy") || ((List) this.mInput.get("sortBy")).size() <= 0) {
            this.mOrder.append("bucket_display_name");
        } else {
            this.mOrder.append(MediaLibraryUtils.mapOrderDescriptor((List) this.mInput.get("sortBy")));
        }
        if (this.mInput.containsKey("after")) {
            i = Integer.parseInt((String) this.mInput.get("after"));
        }
        this.mOffset = i;
        return this;
    }
}
