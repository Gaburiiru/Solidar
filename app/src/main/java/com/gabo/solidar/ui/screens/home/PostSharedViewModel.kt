package com.gabo.solidar.ui.screens.home

import PostModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PostSharedViewModel : ViewModel() {
    private val _selectedPost = mutableStateOf<PostModel?>(null)
    val selectedPost: State<PostModel?> = _selectedPost

    fun setPost(post: PostModel) {
        _selectedPost.value = post
    }
}
