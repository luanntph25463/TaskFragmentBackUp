package com.example.taskfragmentbackup

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AlertDialog
import androidx.preference.DialogPreference
import androidx.preference.PreferenceManager

class CustomDialogPreference(context: Context, attrs: AttributeSet) :
    DialogPreference(context, attrs) {

    init {
        setPositiveButtonText(android.R.string.ok)
        setNegativeButtonText(android.R.string.cancel)
    }

    override fun onClick() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val appCheckBoxValue = sharedPreferences.getBoolean("checkbox_preference", false)
        val appSwitchValue = sharedPreferences.getBoolean("switch_preference", false)
        val appDropdownValue = sharedPreferences.getString("list_preference", "")

        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle("Custom Dialog")
        dialogBuilder.setMessage(
            "Value of App CheckBoxPreference: $appCheckBoxValue\n" +
                    "Value of App SwitchPreference: $appSwitchValue\n" +
                    "Value of App ListPreference: $appDropdownValue"
        )
        dialogBuilder.setPositiveButton(positiveButtonText) { _, _ ->
            // Handle positive button click if needed
        }
        dialogBuilder.setNegativeButton(negativeButtonText) { _, _ ->
            // Handle negative button click if needed
        }

        dialogBuilder.show()
    }
}