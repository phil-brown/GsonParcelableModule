package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.test.InstrumentationTestCase;

/**
 * TODO Description
 *
 * @author Phil Brown
 * @since 1:49 PM Aug 14, 2015
 */
public class ParcelingTest extends InstrumentationTestCase {

    private Contact mContact;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mContact = new Contact();
        mContact.setName("John Doe");
        mContact.setEmail("jdoe@fakedomain.com");
        mContact.setFavorite(true);
    }

    public void testSimpleParceling() {
        Parcel parcel = Parcel.obtain();
        mContact.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        Contact parceledContact = Contact.CREATOR.createFromParcel(parcel);
        assertEquals(mContact, parceledContact);
    }

    public void testComplexParceling() {
        Parcel parcel = Parcel.obtain();
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(mContact);
        addressBook.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        AddressBook parceledAddressBook = AddressBook.CREATOR.createFromParcel(parcel);
        assertEquals(addressBook, parceledAddressBook);
    }
}
