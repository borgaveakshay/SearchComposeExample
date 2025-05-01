package com.assignment.achmeaassignment.data.response


import com.assignment.achmeaassignment.domain.entities.EmployerInfo

class EmployersResponse : ArrayList<EmployersResponseItem>()



fun EmployersResponse.toEmployerInfo(): List<EmployerInfo> {
    return this.map {
        EmployerInfo(
            discountPercentage = it.discountPercentage,
            companyName = it.name,
            location = it.place
        )
    }
}