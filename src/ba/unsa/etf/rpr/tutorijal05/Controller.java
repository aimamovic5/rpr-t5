package ba.unsa.etf.rpr.tutorijal05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    private double oldData = 0;
    private double newData = 0;
    private String operation = new String("+");
    private boolean newRound = false;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private TextField display;
    @FXML
    private Button bttn_percentage;
    @FXML
    private Button bttn_divide;
    @FXML
    private Button bttn_multiply;
    @FXML
    private Button bttn_minus;
    @FXML
    private Button bttn_dot;
    @FXML
    private Button bttn_plus;
    @FXML
    private Button bttn_equality;


    @FXML
    void handleNumbers(ActionEvent actionEvent) {
        if (newRound) {
            display.setText("");
            oldData = 0;
            newData = 0;
            newRound = false;
        }
        String text = ((Button)actionEvent.getSource()).getText();
        if (text.equals(".") && display.getText().equals("")) {
            display.setText("0" + text);
            newData = Double.parseDouble(display.getText());
        }

        else if (text.equals(".") && display.getText().equals("0")) {
            display.setText(display.getText() + text);
            newData = Double.parseDouble(display.getText());
        }

        else if (!text.equals("0") && display.getText().equals("0")) {
            display.setText(text);
            newData = Double.parseDouble(display.getText());
        }

        else if (!(text.equals("0") && display.getText().equals("0"))) {
            display.setText(display.getText() + text);
            newData = Double.parseDouble(display.getText());
        }


    }

    @FXML
    private void operationClick(ActionEvent actionEvent) {
        if ((((Button)actionEvent.getSource()).getText()).equals("=")) {
           newRound = true;
            double ans = oldData;
            switch(operation) {
                case "+":
                    ans += newData;
                    break;
                case "-":
                    ans -= newData;
                    break;
                case "x":
                    ans *= newData;
                    break;
                case "/":
                    ans /= newData;
                    break;
                case "%":
                    break;
            }
            String result = String.format("%.2f", ans);
            display.setText(result);
        }
        else {
            oldData = newData;
            operation = ((Button)actionEvent.getSource()).getText();
            display.setText("");
        }




    }
}
