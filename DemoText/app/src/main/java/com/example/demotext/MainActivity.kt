package com.example.demotext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demotext.ui.theme.DemoTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScream()
                }
            }
        }
    }
}
val custumh1: TextStyle
    get() = TextStyle(
        color = Color.Blue
    )

@Composable
fun HomeScream() {
    Column(modifier = Modifier.padding(24.dp)) {
        GreetingText()
        Spacer(modifier = Modifier.height(24.dp))
        MultipleStylesText()
    }
}
@Composable
fun GreetingText() {
//    Text (text = "Hello Luan")
    Text(text = stringResource(id = R.string.app_name),
        color = Color.Red, // Đổi màu
        fontSize = 18.sp, // kích thước chữ
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold, // Độ đậm
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.tiktok_regular)),
        textDecoration = TextDecoration.LineThrough, // Gạch giữa và gạch dưới
//        style = MaterialTheme.typography.titleMedium
        style = custumh1,
        maxLines = 2, // giới hạn hiển thị dòng
        overflow = TextOverflow.Ellipsis, // hiển thị ... nếu thừa dòng
    )
}

@Composable
fun MultipleStylesText() {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle()){
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)){
                append("H")
            }
            append("an")
            withStyle(style = SpanStyle(color = Color.Cyan)){
                append("L")
            }
            append("uan")
        }
        
    })
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DemoTextTheme {
        HomeScream()
    }
}