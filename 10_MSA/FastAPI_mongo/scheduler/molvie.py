import requests # HTTP 요청과 응답
from datetime import datetime, timedelta # 시간 정보
from database.mongo import products # DB Table 정보
from config import API_KEY
from pprint import pprint
import json

API_KEY = API_KEY
BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"

def fetch_and_store():
    print("fetch 진행 중")
    yesterday = (datetime.now() - timedelta(days=1)).strftime("%Y%m%d")
    param = {"key":API_KEY,"targetDt":yesterday}
    res = requests.get(BASE_URL, params=param)
    pprint(res.json())

    if res.status_code == 200:
        result = res.json()
        data = result["boxOfficeResult"]["dailyBoxOfficeList"]
        products.delete_many({"targetDt":yesterday})
        for item in data:
            item["targetDt"] = yesterday
            products.insert_one(item)
    else:
        return {"error": "API 호출 실패", "status": res.status_code}