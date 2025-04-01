package com.example.saude_sem_fronteiras.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.ui.graphics.Color
import com.example.saude_sem_fronteiras.data.mocks.WeekDaysMock
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme


@Composable
fun WeekDaySelector(
    selectedDays: List<String>,
    onDaySelected: (String, Boolean) -> Unit
) {
    val daysOfWeek = WeekDaysMock.daysOfWeek
    SaudesemfronteirasTheme{
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                daysOfWeek.forEach { day ->
                    Text(
                        text = day,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                daysOfWeek.forEach { day ->
                    Checkbox(
                        checked = selectedDays.contains(day),
                        onCheckedChange = { isChecked -> onDaySelected(day, isChecked) },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.White,
                            uncheckedColor = Color.LightGray,
                            checkmarkColor = Color.Black
                        )
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DaySelectorPreview() {
    var selectedDays by remember { mutableStateOf(listOf<String>()) }
    SaudesemfronteirasTheme {
        WeekDaySelector(
            selectedDays = selectedDays,
            onDaySelected = { day, isChecked ->
                selectedDays = if (isChecked) selectedDays + day else selectedDays - day
            }
        )
    }
}