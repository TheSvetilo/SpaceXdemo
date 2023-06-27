package dev.vbogd.spacexdemo.presentation.general

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vbogd.spacexdemo.R

@Composable
fun EmptyStub(
    title: String,
    modifier: Modifier = Modifier,
    button: @Composable () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.spacex_rocket),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .padding(12.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = 0.15.sp
            ),
            modifier = Modifier.padding(top = 48.dp)
        )
        button()
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyStubPreview() {
    EmptyStub("Something wrong", button = {})
}