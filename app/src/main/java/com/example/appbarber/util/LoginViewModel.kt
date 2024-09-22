import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun loginWithEmail(onLoginSuccess: () -> Unit) {
        val email = _email.value
        val password = _password.value

        viewModelScope.launch {
            _isLoading.value = true
            delay(2000) // Simula o tempo de resposta do servidor
            _isLoading.value = false
            if (email.isNotEmpty() && password.isNotEmpty()) {
                onLoginSuccess()
            } else {
                // Tratar erro de login
            }
        }
    }
}
