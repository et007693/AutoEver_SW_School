from fastapi.responses import JSONResponse
from fastapi import APIRouter, FastAPI, Request

from database.mongo import predictions

import requests
import joblib
import json
import pytz
import datetime
import pandas as pd
import re

from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import classification_report

router = APIRouter(
    prefix="/model",
    tags=["model"]
)

# url = "https://raw.githubusercontent.com/e9t/nsmc/master/ratings_train.txt"
# response = requests.get(url)
#
# with open("ratings_train.txt", "w", encoding="utf-8") as f:
#     f.write(response.text)
#
# df = pd.read_csv("ratings_train.txt", sep="\t")
# df = df [["document", "label"]].dropna()
#
# def clean_text(text):
#     return re.sub(r"[^\uac00-\ud7a3\s]", "", str(text))
#
# df['text'] = df['document'].apply(clean_text)
# df['label'] = df['label'].map({1:"positive", 0:"negative"})
#
# x_train, x_test, y_train, y_test = train_test_split(df['text'], df['label'], test_size=0.2, random_state=42, stratify=df['label'])
#
# vectorizer = CountVectorizer()
# x_train_vec = vectorizer.fit_transform(x_train)
# x_test_vec = vectorizer.transform(x_test)
#
# model = MultinomialNB()
# model.fit(x_train_vec, y_train)
#
# y_pred = model.predict(x_test_vec)
# print(classification_report(y_test, y_pred))

@router.get("/train")
async def train_model():
    # 데이터 로딩
    df = pd.read_csv("./routes/ratings_train.txt", sep='\t')[['document', 'label']].dropna()
    df['text'] = df['document'].apply(lambda x: re.sub(r"[^\uac00-\ud7a3\s]", "", str(x)))
    df['label'] = df['label'].map({1: "positive", 0: "negative"})

    X_train, _, y_train, _ = train_test_split(df['text'], df['label'], test_size=0.2, random_state=42)

    # 학습 및 저장
    vectorizer = CountVectorizer()
    X_train_vec = vectorizer.fit_transform(X_train)
    model = MultinomialNB()
    model.fit(X_train_vec, y_train)

    joblib.dump(model, "./routes/sentiment_model.pkl")
    joblib.dump(vectorizer, "./routes/vectorizer.pkl")

    return JSONResponse(content={"message": "모델 학습 및 저장 완료"}, status_code=200)

@router.post("/predict")
async def predict(request: Request):
    data = await request.json()

    text = data['title'] + " " + data['content']
    model = joblib.load("./routes/sentiment_model.pkl")
    vectorizer = joblib.load("./routes/vectorizer.pkl")
    vec = vectorizer.transform([text])
    pred = model.predict(vec)[0]

    kst = pytz.timezone("Asia/Seoul")
    now_kst = datetime.datetime.now(kst)

    result = {
        # "post_id" : data['post_id'],
        "title" : data['title'],
        "content" : data['content'],
        "prediction" : pred,
        "created_at" : now_kst.isoformat()
    }

    # predictions.insert_one(result)
    return JSONResponse(result)