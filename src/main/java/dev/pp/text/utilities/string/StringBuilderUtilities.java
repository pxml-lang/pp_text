package dev.pp.text.utilities.string;

import dev.pp.text.annotations.NotNull;

public class StringBuilderUtilities {

    public static StringBuilder removeOptionalNewLineAtEnd ( @NotNull StringBuilder sb ) {

        if ( sb.length() == 0 ) return sb;

        int lastIndex = sb.length() - 1;
        if ( sb.charAt ( lastIndex ) != '\n' ) return sb;

        sb.deleteCharAt ( lastIndex );

        lastIndex = lastIndex - 1;
        if ( sb.charAt ( lastIndex ) == '\r' ) sb.deleteCharAt ( lastIndex );

        return sb;
    }
}
