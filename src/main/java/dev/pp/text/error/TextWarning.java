package dev.pp.text.error;

import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.token.TextToken;

public class TextWarning extends TextErrorOrWarning {

    public static final java.lang.String LABEL = "Warning";

    public static @NotNull java.lang.String toString (
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextToken token ) {

        return TextErrorOrWarning.toString ( LABEL, id, message, token );
    }

    public static @NotNull java.lang.String toLogString (
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextToken token ) {

        return TextErrorOrWarning.toLogString ( LABEL, id, message, token );
    }


    public TextWarning ( @Nullable java.lang.String id, @NotNull java.lang.String message, @Nullable TextToken token ) {

        super ( id, message, token );
    }


    public @NotNull java.lang.String getLabel() { return LABEL; };

    public @NotNull java.lang.String toString() { return toString ( id, message, token ); }

    public @NotNull java.lang.String toLogString () { return toLogString ( id, message, token ); }

    // public @NotNull String getLabel() { return LABEL; }
}
