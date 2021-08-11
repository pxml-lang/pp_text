package dev.pp.text.utilities.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextIndentTest {

    @Test
    public void testRemoveIndentAtStart() {

        assertEquals ( "foo", TextIndent.removeIndentAtStart ( "foo" ) );
        assertEquals ( "foo", TextIndent.removeIndentAtStart ( " foo" ) );
        assertEquals ( "foo", TextIndent.removeIndentAtStart ( " \t foo" ) );
        assertEquals ( "a", TextIndent.removeIndentAtStart ( " a" ) );
        assertEquals ( "a ", TextIndent.removeIndentAtStart ( " a " ) );
        assertNull ( TextIndent.removeIndentAtStart ( " " ) );
        assertNull ( TextIndent.removeIndentAtStart ( " \t " ) );
    }
}