package dev.pp.text.utilities.text;

import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.utilities.character.CharChecks;
import dev.pp.text.utilities.string.StringFinder;

public class TextIndent {

    public static int firstNonIndentIndexAtStart ( @NotNull String string ) {

        return StringFinder.findFirstIndex ( string, CharChecks::isNotSpaceOrTab );
    }

    public static @Nullable String removeIndentAtStart ( @NotNull String string ) {

        int firstNonIndentIndex = firstNonIndentIndexAtStart ( string );

        if ( firstNonIndentIndex == -1 ) {
            return null;
        } else if ( firstNonIndentIndex == 0 ) {
            return string;
        } else {
            return string.substring ( firstNonIndentIndex );
        }
    }
}
