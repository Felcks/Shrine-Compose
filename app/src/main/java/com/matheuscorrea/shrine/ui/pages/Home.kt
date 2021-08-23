package com.matheuscorrea.shrine.ui.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material.icons.rounded.FormatListBulleted
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.matheuscorrea.shrine.R
import com.matheuscorrea.shrine.ui.theme.ShrineTheme

@ExperimentalAnimationApi
@Composable
private fun HomeSearchBar(
    hint: String,
    showingTextField: Boolean = false,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val (searchText, onValueChange) = remember { mutableStateOf("") }
    val animatedPadding by animateDpAsState(
        targetValue = if (showingTextField) 0.dp else 24.dp, animationSpec = tween(
            300,
        )
    )
    val animatedAlpha by animateFloatAsState(targetValue = if (showingTextField) 0f else 1f)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.secondary,
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.height(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FormatListBulleted,
                        contentDescription = "search bar left icon",
                        modifier = Modifier
                            .alpha(animatedAlpha)
                            .fillMaxHeight()
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_diamond_stone),
                        contentDescription = "search bar left icon 2",
                        modifier = Modifier
                            .padding(start = animatedPadding)
                            .fillMaxHeight()
                    )
                    Text(
                        "Shrine".uppercase(),
                        style = MaterialTheme.typography.subtitle1,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .padding(start = 48.dp)
                            .alpha(animatedAlpha)
                            .align(Alignment.CenterStart)
                    )
                    TextField(
                        searchText,
                        modifier = Modifier
                            .padding(start = 48.dp)
                            .fillMaxWidth()
                            .focusable(showingTextField)
                            .onFocusChanged {
//                                onSearch.invoke("")
                            },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = MaterialTheme.colors.onPrimary,
                        ),
                        onValueChange = onValueChange,
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    onSearch.invoke("")
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = "search bar right icon"
                                )
                            }
                        }
                    )
                }

            }
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun HomeSearchBarPreview() {
    ShrineTheme {
        HomeSearchBar(hint = "", showingTextField = false, onSearch = { value -> print(value) })
    }
}

@Composable
private fun MainPage(navController: NavController, modifier: Modifier = Modifier) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterAlt,
                        contentDescription = "Filter item"
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card {
                Image(
                    painter = painterResource(id = R.drawable.photo_0),
                    contentDescription = "Image for: ${0}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { navController.navigate("cart") }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo_1),
                    contentDescription = "Image for: ${0}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(80.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card() {
                Image(
                    painter = painterResource(id = R.drawable.photo_2),
                    contentDescription = "Image for: ${0}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(80.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo_3),
                    contentDescription = "Image for: ${0}",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MainPagePreview() {
    MaterialTheme {
        val navController = rememberNavController()
        Box(
        ) {
            MainPage(navController = navController)
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun CategoryItem(
    text: String,
    position: Int,
    selectedPosition: Int,
    navController: NavController,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .size(48.dp)
            .clickable {
                onClick.invoke(position)
            }
    ) {
        AnimatedVisibility(
            visible = selectedPosition == position,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Icon(
                imageVector = Icons.Outlined.WarningAmber,
                contentDescription = "Icon behind category item $position",
                tint = MaterialTheme.colors.primaryVariant,

                modifier = Modifier
                    .fillMaxWidth()
                    .size(48.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text.uppercase(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            modifier = modifier
                .align(Alignment.Center)
        )
    }

}

@ExperimentalAnimationApi
@Preview
@Composable
fun CategoryItemPreview() {
    ShrineTheme {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colors.secondary) {
            CategoryItem(
                text = "featured",
                navController = navController,
                position = 0,
                selectedPosition = 0,
                onClick = {})
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun HomeScreen(
    navController: NavController
) {
    var categoriesVisibility by remember { mutableStateOf(false) }
    val alpha: Float by animateFloatAsState(targetValue = if (categoriesVisibility) 0.5F else 1F)
    val (position, onCategoryClick) = remember { mutableStateOf(0) }

    Scaffold {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                HomeSearchBar(
                    hint = "",
                    showingTextField = categoriesVisibility,
                    onSearch = { _ -> categoriesVisibility = !categoriesVisibility })
            }
            item {
                AnimatedVisibility(
                    visible = categoriesVisibility, enter = expandVertically(
                        Alignment.Top
                    ) + fadeIn(), exit = shrinkVertically(
                        Alignment.Bottom
                    ) + fadeOut()
                ) {
                    Column(modifier = Modifier.padding(vertical = 16.dp)) {
                        CategoryItem(
                            text = "Featured",
                            position = 0,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Apartment",
                            position = 1,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Accessories",
                            position = 2,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Shoes",
                            position = 3,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Tops",
                            position = 4,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Bottoms",
                            position = 5,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                        CategoryItem(
                            text = "Dresses",
                            position = 6,
                            navController = navController,
                            selectedPosition = position,
                            onClick = onCategoryClick
                        )
                    }
                }
            }
            item {
                MainPage(
                    navController,
                    Modifier
                        .alpha(alpha)
                        .clickable {
                            if (categoriesVisibility) categoriesVisibility = !categoriesVisibility
                        })
            }
        }
    }
}