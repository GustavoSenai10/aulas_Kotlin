package br.senai.sp.jandira.bmicalc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicalc.model.Client
import br.senai.sp.jandira.bmicalc.model.Product
import br.senai.sp.jandira.bmicalc.ui.theme.BMICalcTheme
import java.time.LocalDate


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val p = Product()
        p.id = 100
        p.name = "ÄTA"
        p.price = 230.0

        val c = Client(
            100,
            "pedro",
            LocalDate.of(1999, 12, 18)
        )


        setContent {
            BMICalcTheme {
                CalculatorScreen()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorScreen() {
    var weightState = rememberSaveable() {
        mutableStateOf(" ")
    }

    var heightStyle = rememberSaveable() {
        mutableStateOf(" ")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            //Header
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.bmi),
                    contentDescription = " ",
                    modifier = Modifier.height(128.dp)
                )
                Text(
                    text = stringResource(id = R.string.title),
                    fontSize = 30.sp,
                    color = Color.Blue,
                    letterSpacing = 8.sp

                )
            }
            //Form
            Column(
                modifier = Modifier.padding(32.dp)

            ) {
                // texto do peso
                Text(
                    text = stringResource(
                        id = R.string.wight_label
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                OutlinedTextField(
                    value = weightState.value,
                    onValueChange = {
                        weightState.value = it
                        Log.i("DS2T", it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                //Texto da altura
                Text(
                    text = stringResource(
                        id = R.string.height_label
                    ),
                    modifier = Modifier.padding(bottom = 12.dp),
                )
                OutlinedTextField(
                    value = heightStyle.value,
                    onValueChange = {
                        heightStyle.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(32.dp))
                //Botão
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(16.dp)


                ) {

                    Text(
                        text = stringResource(id = R.string.button_text),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        color = Color.Green
                    )

                }
            }

            //Footer
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    color = Color(
                        red = 79,
                        green = 54,
                        blue = 232
                    ),
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = stringResource(id = R.string.your_score))
                        Text(
                            text = weightState.value,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(text = stringResource(id = R.string.ideal))
                        Row() {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.reset))
                            }
                            Spacer(modifier = Modifier.width(48.dp))
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.share))
                            }
                        }
                    }
                }
            }
        }
    }

}


