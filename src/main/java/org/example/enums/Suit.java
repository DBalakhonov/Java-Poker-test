package org.example.enums;

public enum Suit {
    H("H"), D("D"), C("C"), S("S");

    private final String displayName;

    Suit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
