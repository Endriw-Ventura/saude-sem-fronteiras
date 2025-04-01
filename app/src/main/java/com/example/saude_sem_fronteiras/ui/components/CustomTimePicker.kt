package com.example.saude_sem_fronteiras.ui.components

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme
import java.util.Calendar

@Composable
fun CustomTimePicker(label: String, value: String, onChangeFun:(String) -> Unit) {
    var time by remember { mutableStateOf("00:00") }
    var isDialogOpen by remember { mutableStateOf(false) }

    SaudesemfronteirasTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            CustomButton(
                text = time,
                onClickFun = {
                    isDialogOpen = !isDialogOpen
                }
            )

            if (isDialogOpen) {
                TimePickerDialog(
                    LocalContext.current,
                    TimePickerDialog.OnTimeSetListener { _: TimePicker,
                                                         hourOfDay: Int, minute: Int ->
                        time = String.format("%02d:%02d", hourOfDay, minute)
                        isDialogOpen = false
                    },
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                    Calendar.getInstance().get(Calendar.MINUTE),
                    true
                ).show()
            }
        }
    }
}