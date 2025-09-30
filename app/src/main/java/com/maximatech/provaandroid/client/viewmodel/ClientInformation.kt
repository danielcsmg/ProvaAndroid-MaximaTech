package com.maximatech.provaandroid.client.viewmodel

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

data class ClientInformationData(
    val id: Int,
    val code: String,
    val corporateName: String,
    val tradeName: String,
    val cnpj: String,
    val businessActivity: String,
    val address: String,
    val status: String,
    val contacts: List<ContactData>
)

data class ContactData(
    val name: String,
    val phone: String?,
    val cellPhone: String?,
    val spouseName: String?,
    val type: String,
    val team: String?,
    val email: String,
    val birthDate: String,
    val spouseBirthDate: String?
)
internal data class ClientError(
    val message: String,
)

sealed interface ClientInformationState {
    data object Loading : ClientInformationState
    data object Success : ClientInformationState
    data object Error : ClientInformationState
}


