package com.example.mariuspilgrim.wwuapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContactResultActivity extends ActionBarActivity {

    public ContactResultActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.fragment_contact_results);

            // Set a Toolbar to replace the ActionBar.
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            Intent intent = getIntent();
            String messageFirstName = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_FIRST_NAME);
            String messageLastName = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_LAST_NAME);
            String messageEmail = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_EMAIL);
            String messageMessage= intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_MESSAGE);

            TextView textViewFirstName = (TextView) findViewById(R.id.result_first_name);
            TextView textViewLastName = (TextView) findViewById(R.id.result_last_name);
            TextView textViewEmail = (TextView) findViewById(R.id.result_email);
            TextView textViewMessage = (TextView) findViewById(R.id.result_message);

            String textViewFirstNameHtml = "<b>" + getResources().getString(R.string.result_first_name) + "</b>" + messageFirstName;
            String textViewLastNameHtml = "<b>" + getResources().getString(R.string.result_last_name) + "</b>" + messageLastName;
            String textViewEmailHtml = "<b>" + getResources().getString(R.string.result_email) + "</b>" + messageEmail;
            String textViewMessageHtml = "<b>" + getResources().getString(R.string.result_message) + "</b>" + messageMessage;

            textViewFirstName.append(Html.fromHtml(textViewFirstNameHtml));
            textViewLastName.append(Html.fromHtml(textViewLastNameHtml));
            textViewEmail.append(Html.fromHtml(textViewEmailHtml));
            textViewMessage.append(Html.fromHtml(textViewMessageHtml));

            //throw new RuntimeException();
        } catch (Exception ex) {
            messageBox(getResources().getString(R.string.error_oncreate_ContactResultFragmentActivity), ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Uncomment to inflate menu items to Action Bar
        inflater.inflate(R.menu.menu_contact_result, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.

        // Handle action buttons
        switch(item.getItemId()) {
            case R.id.action_go_back_contact_result:
                backToSendMessage(findViewById(R.id.home));
                return true;
            case R.id.action_settings_contact_result:
                openAndroidSettings();
                return true;
            case R.id.action_browser_contact_result:
                openAndroidBrowser();
                return true;
            case R.id.action_map_contact_result:
                goToGoogleMapsActionBar();
                return true;
            case R.id.action_list_contact_result:
                openExpandableList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Go back to message input
     */
    public void backToSendMessage(View view) {
        setContentView(R.layout.fragment_contact);
        finish();
    }

    /**
     * Opens Android device settings
     */
    public void openAndroidSettings() {
        startActivityForResult(new Intent(Settings.ACTION_SETTINGS), 0);
    }

    /**
     * Opens Android device browser
     */
    public void openAndroidBrowser() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.browser_default_address)));
        startActivity(browserIntent);
    }

    /**
     * Opens google maps fragment activity
     */
    public void goToGoogleMapsActionBar() {
        Intent intent = new Intent(this, MapsFragmentActivity.class);
        startActivity(intent);
    }

    /**
     * Opens expandable list
     */
    public void openExpandableList() {
        Intent intent = new Intent(this, NewAuditActivityList.class);
        startActivity(intent);
    }

    public void sendAsEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","mariuspilgrim@icloud.com", null)); //This should be the ERCIS email address

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.contact_email_subject));

        Intent intent = getIntent();
        String messageFirstName = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_FIRST_NAME);
        String messageLastName = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_LAST_NAME);
        String messageEmail = intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_EMAIL);
        String messageMessage= intent.getStringExtra(ContactFragment.EXTRA_MESSAGE_MESSAGE);

        String completeEmailMessage = "<b>" + messageFirstName + "</b><br/><b>" + messageLastName + "</b><br/><b>" + messageEmail + "</b><br/>" + messageMessage;

            emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(completeEmailMessage));
        startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.email_chooser)));
    }

    /**
     * Creating exception handling box
     * @param method
     * @param message
     */
    private void messageBox(String method, String message) {
        AlertDialog.Builder messageBox = new AlertDialog.Builder(this);
        messageBox.setTitle(method);
        messageBox.setMessage(message);
        messageBox.setCancelable(false);
        messageBox.setNeutralButton("OK", null);
        messageBox.show();
    }

}