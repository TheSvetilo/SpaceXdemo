package dev.vbogd.spacexdemo.presentation.rockets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vbogd.spacexdemo.R
import dev.vbogd.spacexdemo.domain.components.rockets.RocketStageUiModel
import dev.vbogd.spacexdemo.domain.components.rockets.RocketUiModel

@Composable
fun RocketContent(
    rocket: RocketUiModel,
    onShowSettingsClick: () -> Unit,
    onShowLaunchesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Color.Black),
        )
        Column(
            modifier = Modifier
                .offset(y = (-32).dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color.White)
                .padding(horizontal = 32.dp, vertical = 24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Text(
                    text = rocket.name,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        letterSpacing = 0.sp
                    ),
                )
                IconButton(onClick = onShowSettingsClick) {
                    Icon(painterResource(id = R.drawable.settings), contentDescription = null)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RocketContentPreview() {
    RocketContent(
        rocket = RocketUiModel(
            id = "1",
            name = "Falcon 1",
            params = listOf(),
            firstFlight = "24 March, 2006",
            country = "Republic of the Marshall Islands",
            costPerLaunch = "$6 m.",
            firstStage = RocketStageUiModel(
                engines = "1",
                fuelAmountTons = "44.3",
                burnTimeSec = "169"
            ),
            secondStage = RocketStageUiModel(
                engines = "1",
                fuelAmountTons = "3.38",
                burnTimeSec = "378"
            ),
            flickrImage = ""
        ),
        {}, {}
    )
}