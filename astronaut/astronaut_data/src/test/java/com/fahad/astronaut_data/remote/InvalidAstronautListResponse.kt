package com.fahad.astronaut_data.remote

val invalidAstronautListResponse = """
    {
        "count": 725,
        "next": "https://spacelaunchnow.me/api/3.5.0/astronaut/?limit=2&offset=2",
        "previous": null,
        "results": [
            {
                "id": 32,
                "url": "https://spacelaunchnow.me/api/ll/2.1.0/astronaut/32/",
                "namedsd": "John Young",
                "status": {
                    "id": 11,
                    "name": "Deceased"
                },
                "type": {
                    "id": 2,
                    "name": "Government"
                },
                "date_of_birth": "1930-09-24",
                "date_of_death": "2018-01-05",
                "nationality": "American",
                "bio": "John Watts Young was an American astronaut, naval officer and aviator, test pilot, and aeronautical engineer. He became the ninth person to walk on the Moon as Commander of the Apollo 16 mission in 1972. Young enjoyed the longest career of any astronaut, becoming the first person to fly six space missions (with seven launches, counting his lunar liftoff) over the course of 42 years of active NASA service. He is the only person to have piloted, and been commander of, four different classes of spacecraft: Gemini, the Apollo Command/Service Module, the Apollo Lunar Module, and the Space Shuttle.\r\n\r\nIn 1965, Young flew on the first manned Gemini mission, and commanded another Gemini mission the next year. In 1969 during Apollo 10, he became the first person to fly solo around the Moon. He drove the Lunar Roving Vehicle on the Moon's surface during Apollo 16, and is one of only three people to have flown to the Moon twice. He also commanded two Space Shuttle flights, including its first launch in 1981, and served as Chief of the Astronaut Office from 1974 to 1987. Young retired from NASA in 2004. He died on January 5, 2018.",
                "twitter": null,
                "instagram": null,
                "wiki": "https://en.wikipedia.org/wiki/John_Young_(astronaut)",
                "agency": {
                    "id": 44,
                    "url": "https://spacelaunchnow.me/api/ll/2.1.0/agencies/44/",
                    "name": "National Aeronautics and Space Administration",
                    "featured": true,
                    "type": "Government",
                    "country_code": "USA",
                    "abbrev": "NASA",
                    "description": "The National Aeronautics and Space Administration is an independent agency of the executive branch of the United States federal government responsible for the civilian space program, as well as aeronautics and aerospace research. NASA have many launch facilities but most are inactive. The most commonly used pad will be LC-39B at Kennedy Space Center in Florida.",
                    "administrator": "Administrator: Bill Nelson",
                    "founding_year": "1958",
                    "launchers": "Space Shuttle | SLS",
                    "spacecraft": "Orion",
                    "parent": null,
                    "image_url": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/agency_images/national2520aeronautics2520and2520space2520administration_image_20190207032448.jpeg"
                },
                "profile_image": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/john2520young_image_20190426143657.jpeg",
                "profile_image_thumbnail": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/john_young_thumbnail_20220911033705.jpeg",
                "last_flight": "1983-11-28T16:00:00Z",
                "first_flight": "1965-03-23T14:24:00Z"
            },
            {
                "id": 86,
                "url": "https://spacelaunchnow.me/api/ll/2.1.0/astronaut/86/",
                "name": "Chen Dong",
                "status": {
                    "id": 1,
                    "name": "Active"
                },
                "type": {
                    "id": 2,
                    "name": "Government"
                },
                "date_of_birth": "1978-12-12",
                "date_of_death": null,
                "nationality": "Chinese",
                "bio": "Chen Dong (simplified Chinese: 陈冬; traditional Chinese: 陳冬; pinyin: Chén Dōng; born 12 December 1978) is a Chinese pilot and astronaut selected as part of the Shenzhou program.\r\n\r\nHe was selected to fly on the Shenzhou 11 mission in October 2016 with astronaut Jing Haipeng. The two underwent more than 3,000 hours of training before the launch of the spacecraft. On 17 October 2016 On 07:30 local time (23:30 GMT on 16 October), Chen lifted off with Shenzhou 11 for a 33-day space mission to the Tiangong-2 space station as his first spaceflight, launched from the Jiuquan Satellite Launch Center using a Long March 2F launch rocket. The crew landed successfully after the 33 day mission on 18 November 2016, marking China's longest manned space flight to date. The reentry module of the Shenzhou-11 spacecraft landed in Inner Mongolia around 2.15 p.m(China time) after detaching from the space lab on 17 November.",
                "twitter": null,
                "instagram": null,
                "wiki": "https://en.wikipedia.org/wiki/Chen_Dong_(astronaut)",
                "agency": {
                    "id": 17,
                    "url": "https://spacelaunchnow.me/api/ll/2.1.0/agencies/17/",
                    "name": "China National Space Administration",
                    "featured": true,
                    "type": "Government",
                    "country_code": "CHN",
                    "abbrev": "CNSA",
                    "description": "The China National Space Administration (CNSA) is the national space agency of the People's Republic of China. It is responsible for the national space program and for planning and development of space activities. CNSA and China Aerospace Corporation (CASC) assumed the authority over space development efforts previously held by the Ministry of Aerospace Industry. The CNSA has many launch sites around China with their orbital sites located in Jiuquan, Xichang, Taiyuan and Wenchang.",
                    "administrator": "Administrator: Tang Dengjie",
                    "founding_year": "1993",
                    "launchers": "",
                    "spacecraft": "Shenzhou",
                    "parent": null,
                    "image_url": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/agency_images/china2520national2520space2520administration_image_20190207032431.jpeg"
                },
                "profile_image": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/chen_dong_image_20220604084758.png",
                "profile_image_thumbnail": "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/chen_dong_thumbnail_20220911033506.png",
                "last_flight": "2022-06-05T02:44:10Z",
                "first_flight": "2016-10-16T23:30:31Z"
            }
        ]
    }
""".trimIndent()