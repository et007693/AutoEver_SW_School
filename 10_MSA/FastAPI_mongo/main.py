from fastapi import FastAPI
from routes.product import router
from routes.boxoffice import router as boxoffice_router
from apscheduler.schedulers.background import BackgroundScheduler
from scheduler.molvie import fetch_and_store

app = FastAPI()
app.include_router(router)
# app.include_router(boxoffice_router)

scheduler = BackgroundScheduler()
scheduler.add_job(fetch_and_store, 'cron', hour=12, minute=46)
scheduler.start()

@app.get("/")
async def start():
    return "Server is Running"

