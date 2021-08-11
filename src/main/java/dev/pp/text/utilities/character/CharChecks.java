package dev.pp.text.utilities.character;

public class CharChecks {

    public static boolean isSpaceOrTab ( char c ) {

        return c == ' '
            || c == '\t';
    }

    public static boolean isNotSpaceOrTab ( char c ) { return ! isSpaceOrTab ( c ); }

    public static boolean isNewLine ( char c ) {

        return c == '\n'
            || c == '\r';
    }

    public static boolean isNotNewLine ( char c ) { return ! isNewLine ( c ); }

    public static boolean isSpaceOrTabOrNewLine ( char c ) {

        return c == ' '
            || c == '\n'
            || c == '\r'
            || c == '\t';
    }
}
