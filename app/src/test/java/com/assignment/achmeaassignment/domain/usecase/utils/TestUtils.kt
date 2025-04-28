package com.assignment.achmeaassignment.domain.usecase.utils

import com.assignment.achmeaassignment.domain.EmployerInfo
import com.google.gson.Gson

private const val mockJsonResponse = """
    [
  {
    "DiscountPercentage": 8,
    "EmployerID": 88219,
    "Name": "&Samhoud Nederland B.V. Utrecht",
    "Place": "UTRECHT"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 87111,
    "Name": "A. Oskam Verhuur en Grondverzet B.V. Moordrecht",
    "Place": "MOORDRECHT"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 93314,
    "Name": "A.C.W. \"Samenwerking\" B.A. Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 92330,
    "Name": "a/d Amstel Architecten B.V. Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 91738,
    "Name": "AM Utrecht",
    "Place": "UTRECHT"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 65674,
    "Name": "AM GROEP Hoofddorp",
    "Place": "HOOFDDORP"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 72786,
    "Name": "Amarant Groep Tilburg",
    "Place": "TILBURG"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 65662,
    "Name": "Amaris Zorggroep Laren nh",
    "Place": "LAREN NH"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 48730,
    "Name": "Amazing Apeldoorn",
    "Place": "APELDOORN"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 83527,
    "Name": "Ambassade van de Verenigde Staten van Amerika 's-gravenhage",
    "Place": "'S-GRAVENHAGE"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 77197,
    "Name": "Ambassade van Iran 's-gravenhage",
    "Place": "'S-GRAVENHAGE"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 86644,
    "Name": "Ambiance International B.V. Nes gem heerenveen",
    "Place": "NES GEM HEERENVEEN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 44119,
    "Name": "Ambiente Europe B.V. Beugen",
    "Place": "BEUGEN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 39777,
    "Name": "Ambiq Hengelo ov",
    "Place": "HENGELO OV"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 80825,
    "Name": "Ambrosius Transporten B.V. Hoogeveen",
    "Place": "HOOGEVEEN"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 86495,
    "Name": "Ambulancedienst VZA International B.V. Waalwijk",
    "Place": "WAALWIJK"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 46204,
    "Name": "Ambulancedienst Zuid-Holland Zuid Papendrecht",
    "Place": "PAPENDRECHT"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 67566,
    "Name": "Ambulancezorg Amsterdam e.o.",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 75811,
    "Name": "Ambulancezorg Limburg Noord Venlo",
    "Place": "VENLO"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 71044,
    "Name": "AmbulanceZorg Noord en Oost Gelderland Elburg",
    "Place": "ELBURG"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 42079,
    "Name": "Ambulante Educatieve Dienst Leiderdorp",
    "Place": "LEIDERDORP"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 43824,
    "Name": "AMC Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 86459,
    "Name": "AMC Medical Research B.V. Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 74623,
    "Name": "Amca Hydraulic Fluid Power B.V. Ten post",
    "Place": "TEN POST"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 44110,
    "Name": "Amco B.V. Milsbeek",
    "Place": "MILSBEEK"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 34349,
    "Name": "Amedes Buren gld",
    "Place": "BUREN GLD"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 75421,
    "Name": "Amefa B.V. Apeldoorn",
    "Place": "APELDOORN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 79616,
    "Name": "Amels B.V. Vlissingen",
    "Place": "VLISSINGEN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 93739,
    "Name": "America Today B.V. Diemen",
    "Place": "DIEMEN"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 39726,
    "Name": "American Medical Systems Europe Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 79580,
    "Name": "Amerongen Kamphuis B.V. Apeldoorn",
    "Place": "APELDOORN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 52042,
    "Name": "Ames Autobedrijf B.V. Dordrecht",
    "Place": "DORDRECHT"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 90029,
    "Name": "Ames Europe Enschede B.V.",
    "Place": "ENSCHEDE"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 76187,
    "Name": "AMF Den Boer B.V. Gorinchem",
    "Place": "GORINCHEM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 19492,
    "Name": "Amfors Groep/RWA Amersfoort",
    "Place": "AMERSFOORT"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 38128,
    "Name": "Amgen Europe B.V. Breda",
    "Place": "BREDA"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 60488,
    "Name": "AMI Lomm",
    "Place": "LOMM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 86277,
    "Name": "Amie Ouderenzorg Bentveld",
    "Place": "BENTVELD"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 92256,
    "Name": "Amkor Zeefdruk B.V. Ede gld",
    "Place": "EDE GLD"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 71177,
    "Name": "AML Liften Amersfoort",
    "Place": "AMERSFOORT"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 34722,
    "Name": "Ammerlaan Orchidieeën Schipluiden",
    "Place": "SCHIPLUIDEN"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 35844,
    "Name": "Ammi-Zorg Arnhem",
    "Place": "ARNHEM"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 83137,
    "Name": "AmniTec B.V. Rotterdam",
    "Place": "ROTTERDAM"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 45712,
    "Name": "Amo Groningen B.V.",
    "Place": "GRONINGEN"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 39260,
    "Name": "Amorim Benelux B.V. Tholen",
    "Place": "THOLEN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 79429,
    "Name": "AMOS Amsterdam",
    "Place": "AMSTERDAM"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 79736,
    "Name": "Amos Milieutechniek B.V. Nieuwegein",
    "Place": "NIEUWEGEIN"
  },
  {
    "DiscountPercentage": 10,
    "EmployerID": 80642,
    "Name": "Amphia Ziekenhuis Breda",
    "Place": "BREDA"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 22987,
    "Name": "AMS Bladel",
    "Place": "BLADEL"
  },
  {
    "DiscountPercentage": 8,
    "EmployerID": 85713,
    "Name": "AMS Sourcing B.V. Schiphol",
    "Place": "SCHIPHOL"
  }
]
"""

fun getMockData(searchQuery: String): List<EmployerInfo> {
    val employers = Gson().fromJson(mockJsonResponse, Array<EmployerInfo>::class.java).toList()
    return employers.filter {
        searchQuery == it.companyName
    }
}