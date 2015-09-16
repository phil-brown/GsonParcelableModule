package self.philbrown.gsonparceable;

import com.google.gson.Gson;

/**
 * Simple Object to parcel/unparcel in tests
 *
 * @author Phil Brown
 * @since 1:51 PM Aug 14, 2015
 */
public class Contact extends GsonParcelable {

    private static Gson sGson = new Gson();

    public String name;
    public String phone;
    public String email;
    public boolean favorite;

    public static final GsonCreator<Contact> CREATOR = new GsonCreator<Contact>(Contact.class) {
        @Override
        public Gson getGson() {
            return sGson;
        }
    };

    @Override
    public GsonCreator getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (favorite != contact.favorite) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        return !(email != null ? !email.equals(contact.email) : contact.email != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (favorite ? 1 : 0);
        return result;
    }
}
