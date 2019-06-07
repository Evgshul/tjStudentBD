package lv.tsi.javacourses.entity;

public enum Evaluation {

    _1_("1"),
    _2_("2"),
    _3_("3"),
    _4_("4"),
    _5_("5"),
    _6_("6"),
    _7_("7"),
    _8_("8"),
    _9_("9"),
    _10_("10"),
    OK("OK"),
    NONE("NONE");

    private final String label;

    private Evaluation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}



