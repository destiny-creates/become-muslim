package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;

class GlyphPathBag {
    private final int[][] data = new int[256][];
    private final Paint paint;
    private final ArrayList<Path> paths = new ArrayList();

    GlyphPathBag(Paint paint) {
        this.paint = paint;
        this.paths.add(new Path());
    }

    Path getOrCreateAndCache(char c, String str) {
        int index = getIndex(c);
        if (index != 0) {
            c = (Path) this.paths.get(index);
        } else {
            Path path = new Path();
            this.paint.getTextPath(str, 0, 1, 0.0f, 0.0f, path);
            index = c >> 8;
            str = this.data[index];
            if (str == null) {
                int[] iArr = new int[256];
                this.data[index] = iArr;
                str = iArr;
            }
            str[c & JfifUtil.MARKER_FIRST_BYTE] = this.paths.size();
            this.paths.add(path);
            c = path;
        }
        str = new Path();
        str.addPath(c);
        return str;
    }

    private int getIndex(char c) {
        int[] iArr = this.data[c >> 8];
        if (iArr == null) {
            return '\u0000';
        }
        return iArr[c & JfifUtil.MARKER_FIRST_BYTE];
    }
}
