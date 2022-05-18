# events-poc

#Post

curl --location --request POST 'localhost:8080/events' \
--header 'Content-Type: application/json' \
--data-raw '        {
            "divn": 72,
            "eventName": "INVENTORY 2022",
            "startDtm": 1672511400000,
            "endDtm": 1672511400000,
            "displayStartDtm": 1696098600000,
            "displayEndDtm": 1701369000000,
            "allowChgs": "N",
            "createDate": 1652844246000,
            "lastUpdatedBy": "BH212",
            "lastUpdate": 1652844246000
        }'
# Get call curl

curl --location --request GET 'localhost:8080/events?offset=0&divn=67&eventId=70&pageSize=30'
curl --location --request GET 'localhost:8080/events?offset=0&pageSize=30'
