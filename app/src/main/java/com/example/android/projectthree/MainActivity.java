package com.example.android.projectthree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score_1 = -1;
    int score_2 = -1;
    int score_3 = -1;
    int score_4 = -1;
    int score_5 = -1;
    int score_6 = -1;
    int score_7 = -1;
    double score_8 = 0;
    double score_9 = 5;
    int score_10 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calculate total scores,then create and show the result message.
     *
     * @param view is Button.
     */
    public void onClickSubmit(View view) {

        if (score_1 < 0 || score_2 < 0 || score_3 < 0 || score_4 < 0 || score_5 < 0 || score_6 < 0 || score_7 < 0) {
            showToast();
        } else {
            int totalSingleChoiceScore = calculateSingleChoiceScore();
            int totalMultipleChoiceScore = calculateMultipleChoiceScore();
            int totalEditTextScore = calculateEditTextScore();
            int totalScore = totalSingleChoiceScore + totalMultipleChoiceScore + totalEditTextScore;

            String resultMessage = createResultMessage(totalScore);
            displayResultMessage(resultMessage);
            showWrongIcon();
        }
    }

    /**
     * This method judge whether or not the single-choice has been checked.
     *
     * @param view is RadioButton.
     */
    public void onClickSingleChoice(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //        question1 answering, the correct answer is radio_button_1_4(D)
        switch (view.getId()) {
            case R.id.radio_button_1_1:
            case R.id.radio_button_1_2:
            case R.id.radio_button_1_3:
                if (checked)
                    score_1 = 0;
                break;

            case R.id.radio_button_1_4:
                if (checked)
                    score_1 = 10;
                break;
        }

        //        question2 answering, the correct answer is radio_button_2_2(B)
        switch (view.getId()) {
            case R.id.radio_button_2_1:
            case R.id.radio_button_2_3:
            case R.id.radio_button_2_4:
                if (checked)
                    score_2 = 0;
                break;

            case R.id.radio_button_2_2:
                if (checked)
                    score_2 = 10;
                break;
        }

        //        question3 answering, the correct answer is radio_button_3_4(D)
        switch (view.getId()) {
            case R.id.radio_button_3_1:
            case R.id.radio_button_3_2:
            case R.id.radio_button_3_3:
                if (checked)
                    score_3 = 0;
                break;

            case R.id.radio_button_3_4:
                if (checked)
                    score_3 = 10;
                break;
        }

        //        question4 answering, the correct answer is radio_button_4_4(D)
        switch (view.getId()) {
            case R.id.radio_button_4_1:
            case R.id.radio_button_4_2:
            case R.id.radio_button_4_3:
                if (checked)
                    score_4 = 0;
                break;

            case R.id.radio_button_4_4:
                if (checked)
                    score_4 = 10;
                break;
        }

        //        question5 answering, the correct answer is radio_button_5_1(A)
        switch (view.getId()) {
            case R.id.radio_button_5_2:
            case R.id.radio_button_5_3:
            case R.id.radio_button_5_4:
                if (checked)
                    score_5 = 0;
                break;

            case R.id.radio_button_5_1:
                if (checked)
                    score_5 = 10;
                break;
        }

        //        question6 answering, the correct answer is radio_button_6_2(B)
        switch (view.getId()) {
            case R.id.radio_button_6_1:
            case R.id.radio_button_6_3:
            case R.id.radio_button_6_4:
                if (checked)
                    score_6 = 0;
                break;

            case R.id.radio_button_6_2:
                if (checked)
                    score_6 = 10;
                break;
        }

        //        question7 answering, the correct answer is radio_button_7_3(C)
        switch (view.getId()) {
            case R.id.radio_button_7_1:
            case R.id.radio_button_7_2:
            case R.id.radio_button_7_4:
                if (checked)
                    score_7 = 0;
                break;

            case R.id.radio_button_7_3:
                if (checked)
                    score_7 = 10;
                break;
        }
    }


    /**
     * This method judge whether or not the multiple-choice has been checked .
     *
     * @param view is CheckBox.
     */
    public void onClickMultipleChoice(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        //        question8 answering, the correct answer is radio_button_8_1~4(A B C D)
        switch (view.getId()) {
            case R.id.check_box_8_1:
            case R.id.check_box_8_2:
            case R.id.check_box_8_3:
            case R.id.check_box_8_4:
                if (checked) {
                    score_8 += 2.5;
                } else {
                    score_8 -= 2.5;
                }
                break;

        }

        //        question9 answering, the correct answer is radio_button_9_2&4(B D)
        switch (view.getId()) {
            case R.id.check_box_9_2:
            case R.id.check_box_9_4:
                if (checked) {
                    score_9 += 2.5;
                } else {
                    score_9 -= 2.5;
                }
                break;
            case R.id.check_box_9_1:
            case R.id.check_box_9_3:
                if (checked) {
                    score_9 -= 2.5;
                } else {
                    score_9 += 2.5;
                }
                break;
        }
    }


    /**
     * This method calculate the total scores of all single-choices.
     */
    private int calculateSingleChoiceScore() {
        return score_1 + score_2 + score_3 + score_4 + score_5 + score_6 + score_7;
    }

    /**
     * This method calculate the total scores of all Multiple-choices.
     */
    private int calculateMultipleChoiceScore() {
        if (score_8 == 10 && score_9 == 10) {
            return (int) (score_8 + score_9);
        } else if (score_8 == 10) {
            return (int) score_8;
        } else if (score_9 == 10) {
            return (int) score_9;
        }
        return 0;
    }

    /**
     * This method calculate the total scores of all Edit-texts.
     * The correct answer is hot dog or hotdog.
     */
    private int calculateEditTextScore() {
        String editTextContent = ((EditText) findViewById(R.id.edit_text_10_1)).getText().toString();
        if (editTextContent.equalsIgnoreCase(getString(R.string.hot_dog)) || editTextContent.equalsIgnoreCase(getString(R.string.hotdog))) {
            return score_10 = 10;
        } else {
            return score_10 = 0;
        }
    }

    /**
     * This method create the result message.
     *
     * @param totalScore is the total scores of all questions.
     */
    private String createResultMessage(int totalScore) {
        String resultMessage = getString(R.string.congratulations);
        resultMessage += getString(R.string.total_scores, totalScore);
        return resultMessage;
    }

    /**
     * This method display the result message and correct answer.
     *
     * @param resultMessage is result message from createResultMessage() method.
     */
    private void displayResultMessage(String resultMessage) {
        ((TextView) findViewById(R.id.totalScore)).setText(resultMessage);
        findViewById(R.id.correct_answer).setVisibility(View.VISIBLE);
    }

    /**
     * This method show the toast of unchecked single-choice .
     */
    private void showToast() {
        Toast toast = Toast.makeText(this, R.string.toast_unchecked_single_choice, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * This method judge whether or not show the Wrong_icon(error) .
     */
    private void showWrongIcon() {
        if (score_1 != 10) {
            ((ImageView) findViewById(R.id.question_1_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_1_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_2 != 10) {
            ((ImageView) findViewById(R.id.question_2_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_2_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_3 != 10) {
            ((ImageView) findViewById(R.id.question_3_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_3_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_4 != 10) {
            ((ImageView) findViewById(R.id.question_4_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_4_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_5 != 10) {
            ((ImageView) findViewById(R.id.question_5_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_5_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_6 != 10) {
            ((ImageView) findViewById(R.id.question_6_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_6_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_7 != 10) {
            ((ImageView) findViewById(R.id.question_7_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_7_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_8 != 10) {
            ((ImageView) findViewById(R.id.question_8_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_8_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_9 != 10) {
            ((ImageView) findViewById(R.id.question_9_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_9_wrong_icon)).setImageResource(R.drawable.right);
        }
        if (score_10 != 10) {
            ((ImageView) findViewById(R.id.question_10_wrong_icon)).setImageResource(R.drawable.wrong);
        } else {
            ((ImageView) findViewById(R.id.question_10_wrong_icon)).setImageResource(R.drawable.right);
        }
        findViewById(R.id.question_1_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_2_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_3_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_4_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_5_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_6_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_7_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_8_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_9_wrong_icon).setVisibility(View.VISIBLE);
        findViewById(R.id.question_10_wrong_icon).setVisibility(View.VISIBLE);
    }
}
