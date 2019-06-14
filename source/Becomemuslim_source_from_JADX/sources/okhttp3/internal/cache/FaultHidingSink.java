package okhttp3.internal.cache;

import java.io.IOException;
import p286d.C5875s;
import p286d.C7205g;
import p286d.C8037c;

class FaultHidingSink extends C7205g {
    private boolean hasErrors;

    protected void onException(IOException iOException) {
    }

    FaultHidingSink(C5875s c5875s) {
        super(c5875s);
    }

    public void write(C8037c c8037c, long j) {
        if (this.hasErrors) {
            c8037c.mo6309i(j);
            return;
        }
        try {
            super.write(c8037c, j);
        } catch (C8037c c8037c2) {
            this.hasErrors = 1;
            onException(c8037c2);
        }
    }

    public void flush() {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    public void close() {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }
}
