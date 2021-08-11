package dev.pp.text.utilities.string;

import dev.pp.text.utilities.string.StringBuilderUtilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderUtilitiesTest {

    @Test
    public void testRemoveOptionalNewLineAtEnd() {

        StringBuilder sb = new StringBuilder ( "abc\r\n\r\n" );
        assertEquals ( "abc\r\n", StringBuilderUtilities.removeOptionalNewLineAtEnd ( sb ).toString() );

        sb = new StringBuilder ( "abc\n\n" );
        assertEquals ( "abc\n", StringBuilderUtilities.removeOptionalNewLineAtEnd ( sb ).toString() );

        sb = new StringBuilder ( "abc\r\n" );
        assertEquals ( "abc", StringBuilderUtilities.removeOptionalNewLineAtEnd ( sb ).toString() );

        sb = new StringBuilder ( "abc\n" );
        assertEquals ( "abc", StringBuilderUtilities.removeOptionalNewLineAtEnd ( sb ).toString() );

        sb = new StringBuilder ( "abc" );
        assertEquals ( "abc", StringBuilderUtilities.removeOptionalNewLineAtEnd ( sb ).toString() );
    }
}