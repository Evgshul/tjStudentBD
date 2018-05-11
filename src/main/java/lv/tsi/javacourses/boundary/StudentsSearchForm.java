package lv.tsi.javacourses.boundary;

import lv.tsi.javacourses.entity.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class StudentsSearchForm {

    private String cond;
    private List<Student> searchResult;

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public List<Student> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Student> searchResult) {
        this.searchResult = searchResult;
    }
}
