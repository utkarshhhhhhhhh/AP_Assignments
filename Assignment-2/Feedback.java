package org.example;

public class Feedback {
    private Visitor visitor;
    private String feedback;

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Feedback(Visitor visitor, String feedback) {
        this.visitor = visitor;
        this.feedback = feedback;
    }


    public Visitor getVisitor() {
        return visitor;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
