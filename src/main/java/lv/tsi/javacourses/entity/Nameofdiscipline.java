package lv.tsi.javacourses.entity;

public enum Nameofdiscipline {

    dscipl_1("displine01"),
    dscipl_2("displine02"),
    dscipl_3("displine03"),
    dscipl_4("displine04"),
    dscipl_5("displine05"),
    dscipl_6("displine06"),
    dscipl_7("displine07"),
    dscipl_8("displine08"),
    dscipl_9("displine09"),
    dscipl_10("displine10");



    private final String label;

    private Nameofdiscipline(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
