package com.maximatech.provaandroid.data.remote.entity

import com.google.gson.annotations.SerializedName


data class ClientResponse(
    @SerializedName("cliente") // Mapeia o campo "cliente" do JSON para esta propriedade
    val client: ClientInformationResponse
)

data class ClientInformationResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("codigo")
    val code: String,

    @SerializedName("razao_social")
    val corporateName: String,

    @SerializedName("nomeFantasia")
    val tradeName: String,

    @SerializedName("cnpj")
    val cnpj: String,

    @SerializedName("ramo_atividade")
    val businessActivity: String,

    @SerializedName("endereco")
    val address: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("contatos")
    val contacts: List<ContactResponse>
)

data class ContactResponse(
    @SerializedName("nome")
    val name: String,

    @SerializedName("telefone")
    val phone: String?, // Pode ser nulo ou ausente

    @SerializedName("celular")
    val cellPhone: String?, // Pode ser nulo ou ausente

    @SerializedName("conjuge")
    val spouseName: String?,

    @SerializedName("tipo")
    val type: String,

    @SerializedName("time")
    val team: String?,

    @SerializedName("e_mail")
    val email: String,

    @SerializedName("data_nascimento")
    val birthDate: String,

    @SerializedName("dataNascimentoConjuge")
    val spouseBirthDate: String?
)

