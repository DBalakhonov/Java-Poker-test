package org.example.enums;

public enum Ranks {
    Two("2"), Three("3"), Four("4"), Five("5"), Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("T"), J("J"), Q("Q"), K("K"), A("A"),
    ;
    private final String displayName;

    Ranks(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
