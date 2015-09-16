package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

/**
 * Parcelable Creator class that uses GSON to convert a Parcel to an Object
 *
 * @author Phil Brown
 * @since 1:27 PM Aug 14, 2015
 */
public abstract class GsonCreator<T extends GsonParcelable> implements Parcelable.Creator<T> {

    /**
     * The class that will be unmarshalled from the Parcel object
     */
    private Class<T> clazz;

    /**
     * Constructor
     * @param clazz the class that will be created from the Parcel
     */
    public GsonCreator(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Constructor. No class is required as the parameter, as it will be determined automatically.
     */
    public GsonCreator() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T createFromParcel(Parcel parcel) {
        return getGson().fromJson(parcel.readString(), clazz);
    }

    @Override
    public T[] newArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

    /**
     * Subclasses must return the GSON instance that should be used. Simple objects can just use
     * the default GSON, however it is recommended to have a static copy so unparceling does not
     * create a new instance every time:
     * <pre>
     *     public class Person extends GsonParcelable {
     *         private static Gson sGson = new Gson();
     *
     *         public static final GsonCreator<Person> CREATOR = new GsonCreator<Person>(Person.class) {
     *               @Override
     *               public Gson getGson() {
     *                  return sGson;
     *               }
     *         };
     *
     *         @Override
     *         public GsonCreator getCREATOR() {
     *              return CREATOR;
     *         }
     *     }
     * </pre>
     * More complex objects (such as objects containing other models) can use more complex Gson instances.
     * @return
     */
    public abstract Gson getGson();
}
