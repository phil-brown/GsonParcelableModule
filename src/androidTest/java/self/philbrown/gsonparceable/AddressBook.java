package self.philbrown.gsonparceable;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * Complex Model to parcel/unparcel in tests
 * Copyright 2015
 *
 * @author Phil Brown
 * @since 8:58 AM Sep 09, 2015
 */
public class AddressBook extends GsonParcelable {

    /**
     * Contains other GsonParcelable objects
     */
    private ArrayList<Contact> contacts;

    /**
     * Just use the basic Gson
     */
    private static Gson sGson = new Gson();

    /**
     * Constructor
     */
    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Use the CREATOR constructor that requires no arguments.
     */
    public static final GsonCreator<AddressBook> CREATOR = new GsonCreator<AddressBook>() {
        @Override
        public Gson getGson() {
            return sGson;
        }
    };

    @Override
    public GsonCreator getCREATOR() {
        return CREATOR;
    }

    /**
     * Add a contact to this address book
     * @param contact   the contact to add
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBook that = (AddressBook) o;

        return !(contacts != null ? !contacts.equals(that.contacts) : that.contacts != null);

    }

    @Override
    public int hashCode() {
        return contacts != null ? contacts.hashCode() : 0;
    }
}
