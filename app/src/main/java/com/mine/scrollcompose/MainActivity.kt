package com.mine.scrollcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mine.scrollcompose.ui.theme.ScrollComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OptimizedRowList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScrollComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun ScrollableList(modifier: Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())){
        repeat(50) { index ->
            Text("Item $index", modifier = Modifier.padding(16.dp).fillMaxWidth())
        }
    }
}

@Composable
fun HorizontalList(modifier: Modifier) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState())
    ) {
        repeat(20) { index ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text("Card $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun OptimizedList(modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(1000) { index ->
            Text(
                text = "Optimized Item $index",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun OptimizedRowList(modifier: Modifier){
    LazyRow(modifier = modifier) {
        items(50) { index ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text("Card $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}