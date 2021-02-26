package domain.question;

public enum QuestionType {

    ALL("*"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private String questionTypeId;

    QuestionType(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public static QuestionType valueOfQuestionType(String questionTypeId) {
        for(QuestionType questionType : values()) {
            if(questionType.questionTypeId.equals(questionTypeId)) {
                return questionType;
            }
        }

        return null;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

}
