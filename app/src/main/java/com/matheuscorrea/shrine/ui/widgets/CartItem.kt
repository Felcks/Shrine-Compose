package com.matheuscorrea.shrine.ui.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.matheuscorrea.shrine.ItemData
import com.matheuscorrea.shrine.SampleItemsData
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@Composable
fun CartItem(
    item: ItemData, bottomDividerThickness: Dp = 0.dp,
    onRemoveClick: (itemData: ItemData) -> Unit
) {
    val animatedProgress = remember {
        Animatable(initialValue = 0.7f)
    }
    LaunchedEffect(key1 = Unit) {
        animatedProgress.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        )
    }

    val animatedModifier = Modifier.graphicsLayer(
        scaleX = animatedProgress.value,
        scaleY = animatedProgress.value
    )

    Row(
        modifier = animatedModifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onRemoveClick.invoke(item) }
        ) {
            Icon(
                imageVector = Icons.Default.RemoveCircleOutline,
                contentDescription = "Remove item icon"
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Divider(color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 20.dp),
            ) {
                Image(
                    painter = painterResource(id = item.photoResId),
                    contentDescription = "Image for: ${item.title}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            item.vendor.name.uppercase(),
                            style = MaterialTheme.typography.body2,
                        )
                        Text(
                            "$${item.price}",
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Text(
                        item.title.uppercase(),
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
            Divider(
                color = MaterialTheme.colors.onSecondary.copy(alpha = 0.3f),
                thickness = bottomDividerThickness
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemPreview() {
    ShrineTheme {
        Surface(
            color = MaterialTheme.colors.secondary
        ) {
            CartItem(SampleItemsData.first(), 0.dp, {})
        }
    }
}