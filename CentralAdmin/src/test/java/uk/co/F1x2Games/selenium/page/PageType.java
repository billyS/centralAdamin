package uk.co.F1x2Games.selenium.page;

public enum PageType {

    PAGETYPE_SKILLS(1), PAGETYPE_ADMIN(2);

    private final int value;

    private PageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
