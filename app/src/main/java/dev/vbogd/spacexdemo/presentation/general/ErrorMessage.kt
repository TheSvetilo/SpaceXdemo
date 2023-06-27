package dev.vbogd.spacexdemo.presentation.general

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vbogd.spacexdemo.R

@Composable
fun ErrorMessage(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    EmptyStub(
        title = stringResource(R.string.error_stub_text),
        modifier = modifier
    ) {
        AppButton(
            onClick = onClick,
            modifier = Modifier.padding(48.dp)
        ) {
            Text(stringResource(R.string.error_stub_repeat_btn))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ErrorMessagePreview() {
    ErrorMessage({})
}