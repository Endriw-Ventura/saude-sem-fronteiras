package com.example.saude_sem_fronteiras.ui.registration.userRegistration

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.saude_sem_fronteiras.ui.registration.userRegistration.steps.StepOne
import com.example.saude_sem_fronteiras.ui.registration.userRegistration.steps.StepThree
import com.example.saude_sem_fronteiras.ui.registration.userRegistration.steps.StepTwo
import com.example.saude_sem_fronteiras.ui.theme.SaudesemfronteirasTheme

@Composable
fun UserRegistrationPager(pagerState: PagerState, viewModel: UserRegistrationViewModel) {
    SaudesemfronteirasTheme {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) { page ->
            when (page) {
                0 -> StepOne(viewModel)
                1 -> StepTwo(viewModel)
                2 -> StepThree(viewModel)
            }
        }
    }
}

