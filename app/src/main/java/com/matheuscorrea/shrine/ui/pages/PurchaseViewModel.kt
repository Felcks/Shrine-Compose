package com.matheuscorrea.shrine.ui.pages

import androidx.lifecycle.ViewModel
import com.matheuscorrea.shrine.ItemData
import com.matheuscorrea.shrine.SampleItemsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PurchaseViewModel : ViewModel() {
    private val _state = MutableStateFlow<List<ItemData>>(SampleItemsData)

    val state: StateFlow<List<ItemData>>
        get() = _state

    fun removeItem(itemData: ItemData) {
        _state.value = state.value.toMutableList().also { it.remove(itemData) }
    }
}