package pca.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Problem {

    @Id
    private String problemName;
    private String problemStatement;

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }
}
