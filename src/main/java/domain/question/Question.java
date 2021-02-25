package domain.question;

public class Question {

    private QuestionType questionType;
    private QuestionCategory questionCategory;
    private QuestionCategorySubcategory questionCategorySubcategory;

    public Question(String id) {
        String arr[] = id.split("\\.");

        if(arr.length > 0) {
            questionType = QuestionType.valueOfQuestionType(arr[0]);
        }

        if(arr.length > 1) {
            questionCategory = QuestionCategory.valueOfQuestionCategory(arr[1]);
        }

        if(arr.length > 2) {
            questionCategorySubcategory = QuestionCategorySubcategory.valueOfQuestionCategorySubcategory(arr[2]);
        }
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public QuestionCategorySubcategory getQuestionCategorySubcategory() {
        return questionCategorySubcategory;
    }
}
