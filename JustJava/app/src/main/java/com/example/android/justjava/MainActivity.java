package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText edit_text = (EditText) findViewById(R.id.name_edit_text_view);
        boolean hasWhippedCream = whippedCream.isChecked();
        boolean hasChocolate = chocolate.isChecked();
        String name = edit_text.getText().toString();
        int price = calculatePrice(quantity, hasChocolate, hasWhippedCream);
        String summary = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        String subject = "Just Java order for " + name;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
//        displayMessage(summary);

    }

    public void increment(View view) {
        quantity = quantity + 1;
        if (quantity > 100) {
            quantity = 100;
        }
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity < 1) {
            quantity = 1;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(int quantity, boolean chocolate, boolean cream) {
        int price;
        if (cream && chocolate) {
            price = quantity * 8;
        }
        else if (cream) {
            price = quantity * 6;
        }
        else if (chocolate) {
            price = quantity * 7;
        }
        else {
            price = quantity * 5;
        }

        return price;
    }

    private String createOrderSummary(int price, boolean whippedCream, boolean chocolate, String name){
        return "Name: "+name+"\nAdd Whipped Cream? "+whippedCream+"\nAdd Chocolate? "+chocolate+"\nQuantity: "+quantity+"\nTotal: $"+price+"\nThank You!";
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryView.setText(message);
//    }
}