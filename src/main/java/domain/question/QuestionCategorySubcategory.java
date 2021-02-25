package domain.question;

public enum QuestionCategorySubcategory {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");

    private String questionCategorySubcategoryId;

    QuestionCategorySubcategory(String questionCategorySubcategoryId) {
        this.questionCategorySubcategoryId = questionCategorySubcategoryId;
    }

    public static QuestionCategorySubcategory valueOfQuestionCategorySubcategory(String questionCategorySubcategoryId) {
        for(QuestionCategorySubcategory questionCategorySubcategory : values()) {
            if(questionCategorySubcategory.questionCategorySubcategoryId.equals(questionCategorySubcategoryId)) {
                return questionCategorySubcategory;
            }
        }

        return null;
    }

    public String getQuestionCategorySubcategoryId() {
        return questionCategorySubcategoryId;
    }
}
