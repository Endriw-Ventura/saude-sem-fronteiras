package com.example.saude_sem_fronteiras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.data.mocks.MockOptions
import com.example.saude_sem_fronteiras.model.Option
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun CustomSelect(
    options: List<Option>,
    selectedOption: Option?,
    onOptionSelected: (Option) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    SaudesemfronteirasTheme {
        CustomButton (
            selectedOption?.label ?: "Selecione uma opção",
            onClickFun = { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.Black)
                .border(2.dp, Color.White)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.label) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomSelectPreview() {
    val options = MockOptions.options
    SaudesemfronteirasTheme {
        CustomSelect(options, null, {})
    }
}