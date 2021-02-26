package domain.question;

public enum QuestionCategory {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    ELEVEN("11"),
    TWELVE("12"),
    THIRTEEN("13"),
    FOURTEEN("14"),
    FIFTEEN("15"),
    SIXTEEN("16"),
    SEVENTEEN("17"),
    EIGHTEEN("18"),
    NINETEEN("19"),
    TWENTY("20");

    private String questionCategoryId;

    QuestionCategory(String questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public static QuestionCategory valueOfQuestionCategory(String questionCategoryId) {
        for(QuestionCategory questionCategory : values()) {
            if(questionCategory.questionCategoryId.equals(questionCategoryId)) {
                return questionCategory;
            }
        }

        return null;
    }

    public String getQuestionCategoryId() {
        return questionCategoryId;
    }
}
