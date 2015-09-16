package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Superclass for simple Parceling with Gson.
 *
 * @author Phil Brown
 * @since 1:26 PM Aug 14, 2015
 */
public abstract class GsonParcelable implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getCREATOR().getGson().toJson(this));
    }

    /**
     * Get the CREATOR object used for unmarshalling the Parcel.
     * @return
     */
    public abstract GsonCreator getCREATOR();
}
