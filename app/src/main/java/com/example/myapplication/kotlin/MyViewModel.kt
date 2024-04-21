import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {


    // 使用 StateFlow 来表示数据的状态
    private val _data = MutableStateFlow<String?>(null)
    val data: StateFlow<String?> get() = _data

    init {
        // 在 ViewModel 初始化时启动协程
        viewModelScope.launch {
            fetchData()
        }
    }

    // 使用协程异步获取数据
    private suspend fun fetchData() {
        try {

            // 更新数据状态
            _data.value = ""
        } catch (e: Exception) {
            // 处理异常
            _data.value = "Error: ${e.message}"
        }
    }
}
