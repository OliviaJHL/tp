package seedu.fitbook.model.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_APPOINTMENT_DATE_ONE;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_APPOINTMENT_DATE_TWO;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_CALORIE_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_WEIGHT_BOB;
import static seedu.fitbook.testutil.Assert.assertThrows;
import static seedu.fitbook.testutil.client.TypicalClients.ALICE;
import static seedu.fitbook.testutil.client.TypicalClients.BOB;

import org.junit.jupiter.api.Test;

import seedu.fitbook.testutil.client.ClientBuilder;

public class ClientTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Client client = new ClientBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> client.getTags().remove(0));
    }

    @Test
    public void isSameClient() {
        // same object -> returns true
        assertTrue(ALICE.isSameClient(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameClient(null));

        // same name, all other attributes different -> returns true
        Client editedAlice = new ClientBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .withAppointments(VALID_APPOINTMENT_DATE_ONE).withCalorie(VALID_CALORIE_BOB).build();
        assertTrue(ALICE.isSameClient(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new ClientBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameClient(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Client editedBob = new ClientBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(BOB.isSameClient(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new ClientBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSameClient(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Client aliceCopy = new ClientBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different client -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Client editedAlice = new ClientBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new ClientBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new ClientBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new ClientBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different calorie -> returns false
        editedAlice = new ClientBuilder(ALICE).withCalorie(VALID_CALORIE_BOB).build();

        //different weight -> returns false
        editedAlice = new ClientBuilder(ALICE).withWeight(VALID_WEIGHT_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        //different gender -> returns false
        editedAlice = new ClientBuilder(ALICE).withGender("f").build();
        assertFalse(ALICE.equals(editedAlice));

        // different appointments -> returns false
        editedAlice = new ClientBuilder(ALICE).withAppointments(VALID_APPOINTMENT_DATE_TWO).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new ClientBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }

    @Test
    public void test_equalsSymmetric() {
        Client clientA = ALICE;
        Client clientB = ALICE;
        assertTrue(clientA.equals(clientB) && clientB.equals(clientA));
        assertTrue(clientA.hashCode() == clientB.hashCode());
    }
}
