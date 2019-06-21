package lv.tsi.javacourses.entity;

public enum Evaluation {

    _1("1"),
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _10("10"),
    _OK("OK"),
    _NONE("NONE");

    private final String label;

    private Evaluation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}



