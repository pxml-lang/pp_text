package dev.pp.text.utilities.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilitiesTest {

    @Test
    public void testReplaceQuoteWith2Quotes() {

        assertEquals ( "1", StringUtilities.replaceQuoteWith2Quotes ( "1" ) );
        assertEquals ( "1\"\"3", StringUtilities.replaceQuoteWith2Quotes ( "1\"3" ) );
        assertEquals ( "1\"\"3\"\"5", StringUtilities.replaceQuoteWith2Quotes ( "1\"3\"5" ) );
        assertEquals ( "\"\"\"\"\"\"", StringUtilities.replaceQuoteWith2Quotes ( "\"\"\"" ) );
    }
}