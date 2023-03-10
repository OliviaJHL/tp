package seedu.fitbook.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.fitbook.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.fitbook.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_GENDER_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_WEIGHT_BOB;

import org.junit.jupiter.api.Test;

import seedu.fitbook.logic.commands.EditCommand.EditClientDescriptor;
import seedu.fitbook.testutil.client.EditClientDescriptorBuilder;

public class EditClientDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditClientDescriptor descriptorWithSameValues = new EditClientDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditClientDescriptor editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different weight -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withWeight(VALID_WEIGHT_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different gender -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withGender(VALID_GENDER_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditClientDescriptorBuilder(DESC_AMY).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }
}
