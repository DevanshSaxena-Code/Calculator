package com.devansh_saxena.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView question = this.findViewById(R.id.question);
        ImageButton clearScreen = this.findViewById(R.id.clearScreen);
        clearScreen.setOnClickListener(e->{
            String questionField = question.getText().toString();
            if (questionField.length() == 1 || questionField.isBlank())
                question.setText("");
            else
                question.setText(questionField.substring(0,questionField.length()-1));
        });
        AppCompatButton clearAll = this.findViewById(R.id.clearAll);
        clearAll.setOnClickListener(e->question.setText(""));
        AppCompatButton divide = this.findViewById(R.id.divide);
        divide.setOnClickListener(e->
            question.setText(question.getText().toString()+"/"));
        AppCompatButton multiply = this.findViewById(R.id.multiply);
        multiply.setOnClickListener(e->
                question.setText(question.getText().toString()+"*"));
        AppCompatButton seven = this.findViewById(R.id.seven);
        seven.setOnClickListener(e->
                question.setText(question.getText().toString()+"7"));
        AppCompatButton eight = this.findViewById(R.id.eight);
        eight.setOnClickListener(e->
                question.setText(question.getText().toString()+"8"));
        AppCompatButton nine = this.findViewById(R.id.nine);
        nine.setOnClickListener(e->
                question.setText(question.getText().toString()+"9"));
        AppCompatButton minus = this.findViewById(R.id.minus);
        minus.setOnClickListener(e->
                question.setText(question.getText().toString()+"-"));
        AppCompatButton four = this.findViewById(R.id.four);
        four.setOnClickListener(e->
                question.setText(question.getText().toString()+"4"));
        AppCompatButton five = this.findViewById(R.id.five);
        five.setOnClickListener(e->
                question.setText(question.getText().toString()+"5"));
        AppCompatButton six = this.findViewById(R.id.six);
        six.setOnClickListener(e->
                question.setText(question.getText().toString()+"6"));
        AppCompatButton plus = this.findViewById(R.id.plus);
        plus.setOnClickListener(e->
                question.setText(question.getText().toString()+"+"));
        AppCompatButton one = this.findViewById(R.id.one);
        one.setOnClickListener(e->
                question.setText(question.getText().toString()+"1"));
        AppCompatButton two = this.findViewById(R.id.two);
        two.setOnClickListener(e->
                question.setText(question.getText().toString()+"2"));
        AppCompatButton three = this.findViewById(R.id.three);
        three.setOnClickListener(e->
                question.setText(question.getText().toString()+"3"));
        AppCompatButton equal = this.findViewById(R.id.equal);
        equal.setOnClickListener(e->{
            String questionField = question.getText().toString();
            String answer;
            try {
                answer = CalculatorExpressionParser.evaluate(questionField) + "";
            } catch (ArithmeticException exception) {
                answer = "Cannot Divide By Zero";
            } catch (Exception exception) {
                answer = "Syntax Error";
            }
            question.setText(questionField+"\n = "+answer);
        });
        AppCompatButton zero = this.findViewById(R.id.zero);
        zero.setOnClickListener(e->
                question.setText(question.getText().toString()+"0"));
        AppCompatButton point = this.findViewById(R.id.point);
        point.setOnClickListener(e->
                question.setText(question.getText().toString()+"."));
    }
}