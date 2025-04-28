package com.assignment.achmeaassignment.utils

import com.assignment.achmeaassignment.data.response.EmployersResponse
import com.assignment.achmeaassignment.data.response.toEmployerInfo
import com.assignment.achmeaassignment.domain.EmployerInfo
import com.google.gson.Gson

private const val mockJsonResponse = "[\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 88219,\n" +
        "    \"Name\": \"&Samhoud Nederland B.V. Utrecht\",\n" +
        "    \"Place\": \"UTRECHT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 87111,\n" +
        "    \"Name\": \"A. Oskam Verhuur en Grondverzet B.V. Moordrecht\",\n" +
        "    \"Place\": \"MOORDRECHT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 93314,\n" +
        "    \"Name\": \"A.C.W. \\\"Samenwerking\\\" B.A. Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 92330,\n" +
        "    \"Name\": \"a/d Amstel Architecten B.V. Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 91738,\n" +
        "    \"Name\": \"AM Utrecht\",\n" +
        "    \"Place\": \"UTRECHT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 65674,\n" +
        "    \"Name\": \"AM GROEP Hoofddorp\",\n" +
        "    \"Place\": \"HOOFDDORP\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 72786,\n" +
        "    \"Name\": \"Amarant Groep Tilburg\",\n" +
        "    \"Place\": \"TILBURG\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 65662,\n" +
        "    \"Name\": \"Amaris Zorggroep Laren nh\",\n" +
        "    \"Place\": \"LAREN NH\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 48730,\n" +
        "    \"Name\": \"Amazing Apeldoorn\",\n" +
        "    \"Place\": \"APELDOORN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 83527,\n" +
        "    \"Name\": \"Ambassade van de Verenigde Staten van Amerika 's-gravenhage\",\n" +
        "    \"Place\": \"'S-GRAVENHAGE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 77197,\n" +
        "    \"Name\": \"Ambassade van Iran 's-gravenhage\",\n" +
        "    \"Place\": \"'S-GRAVENHAGE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 86644,\n" +
        "    \"Name\": \"Ambiance International B.V. Nes gem heerenveen\",\n" +
        "    \"Place\": \"NES GEM HEERENVEEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 44119,\n" +
        "    \"Name\": \"Ambiente Europe B.V. Beugen\",\n" +
        "    \"Place\": \"BEUGEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 39777,\n" +
        "    \"Name\": \"Ambiq Hengelo ov\",\n" +
        "    \"Place\": \"HENGELO OV\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 80825,\n" +
        "    \"Name\": \"Ambrosius Transporten B.V. Hoogeveen\",\n" +
        "    \"Place\": \"HOOGEVEEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 86495,\n" +
        "    \"Name\": \"Ambulancedienst VZA International B.V. Waalwijk\",\n" +
        "    \"Place\": \"WAALWIJK\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 46204,\n" +
        "    \"Name\": \"Ambulancedienst Zuid-Holland Zuid Papendrecht\",\n" +
        "    \"Place\": \"PAPENDRECHT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 67566,\n" +
        "    \"Name\": \"Ambulancezorg Amsterdam e.o.\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 75811,\n" +
        "    \"Name\": \"Ambulancezorg Limburg Noord Venlo\",\n" +
        "    \"Place\": \"VENLO\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 71044,\n" +
        "    \"Name\": \"AmbulanceZorg Noord en Oost Gelderland Elburg\",\n" +
        "    \"Place\": \"ELBURG\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 42079,\n" +
        "    \"Name\": \"Ambulante Educatieve Dienst Leiderdorp\",\n" +
        "    \"Place\": \"LEIDERDORP\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 43824,\n" +
        "    \"Name\": \"AMC Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 86459,\n" +
        "    \"Name\": \"AMC Medical Research B.V. Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 74623,\n" +
        "    \"Name\": \"Amca Hydraulic Fluid Power B.V. Ten post\",\n" +
        "    \"Place\": \"TEN POST\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 44110,\n" +
        "    \"Name\": \"Amco B.V. Milsbeek\",\n" +
        "    \"Place\": \"MILSBEEK\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 34349,\n" +
        "    \"Name\": \"Amedes Buren gld\",\n" +
        "    \"Place\": \"BUREN GLD\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 75421,\n" +
        "    \"Name\": \"Amefa B.V. Apeldoorn\",\n" +
        "    \"Place\": \"APELDOORN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 79616,\n" +
        "    \"Name\": \"Amels B.V. Vlissingen\",\n" +
        "    \"Place\": \"VLISSINGEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 93739,\n" +
        "    \"Name\": \"America Today B.V. Diemen\",\n" +
        "    \"Place\": \"DIEMEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 39726,\n" +
        "    \"Name\": \"American Medical Systems Europe Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 79580,\n" +
        "    \"Name\": \"Amerongen Kamphuis B.V. Apeldoorn\",\n" +
        "    \"Place\": \"APELDOORN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 52042,\n" +
        "    \"Name\": \"Ames Autobedrijf B.V. Dordrecht\",\n" +
        "    \"Place\": \"DORDRECHT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 90029,\n" +
        "    \"Name\": \"Ames Europe Enschede B.V.\",\n" +
        "    \"Place\": \"ENSCHEDE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 76187,\n" +
        "    \"Name\": \"AMF Den Boer B.V. Gorinchem\",\n" +
        "    \"Place\": \"GORINCHEM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 19492,\n" +
        "    \"Name\": \"Amfors Groep/RWA Amersfoort\",\n" +
        "    \"Place\": \"AMERSFOORT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 38128,\n" +
        "    \"Name\": \"Amgen Europe B.V. Breda\",\n" +
        "    \"Place\": \"BREDA\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 60488,\n" +
        "    \"Name\": \"AMI Lomm\",\n" +
        "    \"Place\": \"LOMM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 86277,\n" +
        "    \"Name\": \"Amie Ouderenzorg Bentveld\",\n" +
        "    \"Place\": \"BENTVELD\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 92256,\n" +
        "    \"Name\": \"Amkor Zeefdruk B.V. Ede gld\",\n" +
        "    \"Place\": \"EDE GLD\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 71177,\n" +
        "    \"Name\": \"AML Liften Amersfoort\",\n" +
        "    \"Place\": \"AMERSFOORT\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 34722,\n" +
        "    \"Name\": \"Ammerlaan Orchidieeën Schipluiden\",\n" +
        "    \"Place\": \"SCHIPLUIDEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 35844,\n" +
        "    \"Name\": \"Ammi-Zorg Arnhem\",\n" +
        "    \"Place\": \"ARNHEM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 83137,\n" +
        "    \"Name\": \"AmniTec B.V. Rotterdam\",\n" +
        "    \"Place\": \"ROTTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 45712,\n" +
        "    \"Name\": \"Amo Groningen B.V.\",\n" +
        "    \"Place\": \"GRONINGEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 39260,\n" +
        "    \"Name\": \"Amorim Benelux B.V. Tholen\",\n" +
        "    \"Place\": \"THOLEN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 79429,\n" +
        "    \"Name\": \"AMOS Amsterdam\",\n" +
        "    \"Place\": \"AMSTERDAM\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 79736,\n" +
        "    \"Name\": \"Amos Milieutechniek B.V. Nieuwegein\",\n" +
        "    \"Place\": \"NIEUWEGEIN\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 10,\n" +
        "    \"EmployerID\": 80642,\n" +
        "    \"Name\": \"Amphia Ziekenhuis Breda\",\n" +
        "    \"Place\": \"BREDA\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 22987,\n" +
        "    \"Name\": \"AMS Bladel\",\n" +
        "    \"Place\": \"BLADEL\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"DiscountPercentage\": 8,\n" +
        "    \"EmployerID\": 85713,\n" +
        "    \"Name\": \"AMS Sourcing B.V. Schiphol\",\n" +
        "    \"Place\": \"SCHIPHOL\"\n" +
        "  }\n" +
        "]"


fun getMockData(searchQuery: String): List<EmployerInfo> {
    val employers =  Gson().fromJson(mockJsonResponse, EmployersResponse::class.java).toEmployerInfo()
    return employers.filter {
        it.companyName.contains(searchQuery, ignoreCase = true)
    }
}


fun getMockNetworkData(): EmployersResponse =
    Gson().fromJson(mockJsonResponse, EmployersResponse::class.java)

