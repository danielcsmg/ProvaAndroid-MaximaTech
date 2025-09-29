package com.maximatech.provaandroid

import com.maximatech.provaandroid.data.remote.entity.ClientResponse
import com.maximatech.provaandroid.data.remote.entity.ContactResponse
import com.maximatech.provaandroid.home.viewmodel.ClientInformation
import com.maximatech.provaandroid.home.viewmodel.ClientInformationData
import com.maximatech.provaandroid.home.viewmodel.ContactData

internal fun ClientResponse.toData() = ClientInformation(
    data = ClientInformationData(
        id = client.id,
        code = client.code,
        corporateName = client.corporateName,
        tradeName = client.tradeName,
        cnpj = client.cnpj,
        businessActivity = client.businessActivity,
        address = client.address,
        status = client.status,
        contacts = client.contacts.map { contactResponse ->
            contactResponse.toData()
        }
    )
)

private fun ContactResponse.toData() = ContactData(
    name = name,
    phone = phone,
    cellPhone = cellPhone,
    spouseName = spouseName,
    type = type,
    team = team,
    email = email,
    birthDate = birthDate,
    spouseBirthDate = spouseBirthDate,
)