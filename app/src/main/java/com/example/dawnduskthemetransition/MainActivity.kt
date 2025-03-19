package com.example.dawnduskthemetransition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dawnduskthemetransition.ui.theme.DawnDuskThemeTransitionTheme
import com.example.dawnduskthemetransition.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DawnDuskThemeTransitionTheme {
                val colors = MaterialTheme.colorScheme

                val isDarkMode = isSystemInDarkTheme()

                val backgroundImage: ImageClass = if (isDarkMode) {
                    ImageClass(
                        painter = painterResource(id = R.drawable.moon),
                        alignment = Alignment.TopEnd
                    )
                } else {
                    ImageClass(
                        painter = painterResource(id = R.drawable.sun),
                        alignment = Alignment.TopStart
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(colors.primary, colors.background)
                            )
                        ),
                ) {
                    Image(
                        modifier = Modifier
                            .align(backgroundImage.alignment)
                            .padding(
                                vertical = 113.dp,
                                horizontal = 32.dp
                            ),
                        painter = backgroundImage.painter,
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "How was your day?",
                            style = Typography.titleLarge.copy(color = colors.onBackground)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.textButtonColors(containerColor = colors.onPrimary)
                        ) {
                            val list = listOf(true, true, true, true, false)
                            LazyRow {
                                items(list) {
                                    if (!it) {
                                        Icon(
                                            painter = painterResource(R.drawable.star),
                                            contentDescription = null,
                                            tint = Color(0xFFD7E4F7)
                                        )
                                    } else {
                                        Icon(
                                            painter = painterResource(R.drawable.star),
                                            contentDescription = null,
                                            tint = Color(0xFFFF9334)
                                        )
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

data class ImageClass(val painter: Painter, val alignment: Alignment)
