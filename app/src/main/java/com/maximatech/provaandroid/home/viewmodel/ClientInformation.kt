package com.maximatech.provaandroid.home.viewmodel

internal data class ClientInformation(
    val data: ClientInformationData?,
    val error: ClientError?,
    val state: ClientInformationState,
) {
    constructor(
        data: ClientInformationData
    ) : this(
        data = data,
        error = null,
        state = ClientInformationState.Success
    )

    constructor(
        error: ClientError
    ) : this(
        data = null,
        error = error,
        state = ClientInformationState.Error
    )

    constructor() : this(
        data = null,
        error = null,
        state = ClientInformationState.Loading
    )
}

internal data class ClientInformationData(
    val name: String,
)

internal data class ClientError(
    val message: String,
)

sealed interface ClientInformationState {
    data object Loading : ClientInformationState
    data object Success : ClientInformationState
    data object Error : ClientInformationState
}


