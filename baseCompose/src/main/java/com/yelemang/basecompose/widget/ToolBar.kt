package com.yelemang.basecompose.widget

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolBar(
    @DrawableRes leftIcon: Int,
    title: String,
    rightStr: String? = "",
    @DrawableRes rightIcon: Int? = null,
    leftIconClick: () -> Unit,
    rightClick: (() -> Unit)? = null,
    leftIconPadding:Int = 13,
    rightPadding:Int = 13,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    titleTextSize:Int = 18,
    rightTextSize:Int = 14,
    titleColor:Color = Color.White,
    rightTextColor:Color = Color.White
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = leftIcon),
            contentDescription = null,
            modifier = Modifier
                .padding(leftIconPadding.dp)
                .clickable {
                    leftIconClick.invoke()
                }
        )
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = titleColor,
            textAlign = TextAlign.Center,
            fontSize = titleTextSize.sp
        )
        if (rightStr != null) {
            Text(
                text = rightStr,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = rightPadding.dp)
                    .clickable {
                        rightClick?.invoke()
                    },
                color = rightTextColor,
                textAlign = TextAlign.Center,
                fontSize = rightTextSize.sp
            )
        }
        if (rightIcon != null) {
            Image(
                painter = painterResource(id = rightIcon),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(rightPadding.dp)
                    .clickable { rightClick?.invoke() }
            )
        }
    }
}